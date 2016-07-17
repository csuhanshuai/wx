package com.qixin.app.pay.alipay.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.pay.alipay.Consts;
import com.qixin.app.pay.alipay.dao.RechargeLogDao;
import com.qixin.app.pay.alipay.model.RechargeLog;
import com.qixin.app.pay.alipay.util.AlipayNotify;
import com.qixin.app.zjmall.service.IOrderService;
import com.qixin.app.zjminweb.dao.impl.MemberDaoImpl;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.platform.commons.Config;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.sms.service.SmsService;

/*******************************************************************************
 * 
 * 功能： 支付宝异步消息接收接口
 */
@Controller
@RequestMapping("nosecurity/alipay")
public class NotifyUrlAction
{

	private static final Logger logger = Logger
			.getLogger(NotifyUrlAction.class);

	@Resource
	private RechargeLogDao rechargeDao;
	
	@Resource
	private SmsService smsService;
	
	@Resource
	private MemberDaoImpl memberDao;

	@Resource
	private IOrderService orderService;

	public NotifyUrlAction() {
		// rightcode="notifyurl";
		// service = (MenuService)this.getBean("menuService");
	}

	@RequestMapping("/notify")
	public void notify(String out_trade_no,HttpServletRequest request,HttpServletResponse response) throws JDBCException,
			SQLException, HibernateException, Exception {

		logger.info("进入异步支付！-------->>>>>>");
		// 定义返回值
		String result = "";

		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//

		// 解密（如果是RSA签名需要解密，如果是MD5签名则下面一行清注释掉）
		// params = AlipayNotify.decrypt(params);
		// XML解析notify_data数据
		Document doc_notify_data = DocumentHelper.parseText(params
				.get("notify_data"));

		// 商户订单号
		out_trade_no = doc_notify_data
				.selectSingleNode("//notify/out_trade_no").getText();
		// 支付宝交易号
		String trade_no = doc_notify_data.selectSingleNode("//notify/trade_no")
				.getText();
		// 交易状态
		String trade_status = doc_notify_data.selectSingleNode(
				"//notify/trade_status").getText();
		// 买家支付宝账号
		String buyer_email = doc_notify_data.selectSingleNode(
				"//notify/buyer_email").getText();
		// 交易付款时间
		String gmt_payment = doc_notify_data.selectSingleNode(
				"//notify/gmt_payment").getText();
		// 交易关闭时间
		String gmt_close = doc_notify_data.selectSingleNode(
				"//notify/gmt_close").getText();
		// 通知时间
		String notify_time = doc_notify_data.selectSingleNode(
				"//notify/notify_time").getText();
		// 支付宝回传交易金额
		String total_fee_alipa = doc_notify_data.selectSingleNode(
				"//notify/total_fee").getText();
		// 通知类型
		String notify_type = doc_notify_data.selectSingleNode(
				"//notify/notify_type").getText();

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		// if(1==1){
		if (AlipayNotify.verifyNotify(params)) {// 验证成功
			// 判断是否存在当前订单
			// DetachedCriteria dc =
			// DetachedCriteria.forClass(TsysRechargeLog.class);
			// dc.add(Restrictions.eq("outTradeNo", out_trade_no));
			logger.info("支付宝NotifyUrlAction==out_trade_no=====>" + out_trade_no
					+ "doc_notify_data====>" + doc_notify_data.toString());

			CritMap critMap = new CritMap();
			critMap.addEqual("OUT_TRADE_NO", out_trade_no);
			List<RechargeLog> rechargeloglist = rechargeDao.findByCritMap(
					critMap, false);
			logger.info(rechargeloglist);
			if (null != rechargeloglist && rechargeloglist.size() > 0) {
				RechargeLog tsysrechargelog = rechargeloglist.get(0);
				/**
				 * 跟支付宝客服沟通 返回这两个结果均表示返回状态成功。且是实时到账的。2013-09-03
				 */
				if (trade_status.equals("TRADE_FINISHED")
						|| trade_status.equals("TRADE_SUCCESS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					if (notify_time.indexOf(" ") < 0) {
						notify_time = notify_time.substring(0, 10)
								+ " "
								+ notify_time.substring(10,
										notify_time.length());
					}
					if (gmt_close.indexOf(" ") < 0) {
						gmt_close = gmt_close.substring(0, 10) + " "
								+ gmt_close.substring(10, gmt_close.length());
					}
					if (gmt_payment.indexOf(" ") < 0) {
						gmt_payment = gmt_payment.substring(0, 10)
								+ " "
								+ gmt_payment.substring(10,
										gmt_payment.length());
					}
					tsysrechargelog.setNOTIFY_TIME(notify_time);
					tsysrechargelog.setTRADE_STATUS(trade_status);
					tsysrechargelog.setNOTIFY_TYPE(notify_type);
					tsysrechargelog.setBUYER_EMAIL(buyer_email);
					tsysrechargelog.setTOTAL_FEE_ALIPAY(Double
							.valueOf(total_fee_alipa));
					tsysrechargelog.setGMT_CLOSE(gmt_close);
					tsysrechargelog.setGMT_PAYMENT(gmt_payment);
					rechargeDao.save(tsysrechargelog);

					// 更新订单表
					CritMap m=new CritMap();
					m.addEqual("orderId", out_trade_no);
//					List<PerfOrder> orderlist=orderDao.findByCritMap(m, false);
//					
//					if (null != orderlist && orderlist.size() > 0) {
//						for (int i = 0; i < orderlist.size(); i++) {
//							PerfOrder order = orderlist.get(i);
//							
//							if (Consts.ORDER_PAY_STATUS_OK == order
//									.getPayStatus()) {
//								//成功
//								result = "success";
//								//return SUCCESS;
//							} else {
//								// 更新订单状态、更新支付状态
//								order.setPayStatus(Consts.ORDER_PAY_STATUS_OK);
//								//order.setOrderStatus(Consts.ORDERSTATUS_CONFIRM);
//								JsonConfig jsonConfig = new JsonConfig();
//								jsonConfig.setExcludes(new String[] {
//										"itvTimediscount",
//										"validItvTimediscount" });
//								JSONObject jsonObject = JSONObject.fromObject(
//										order, jsonConfig);
//								logger.debug(jsonObject);
//								//更新订单状态为支付成功
//								orderDao.save(order);
//
//								String msgcontent=Config.getConfigValue("sms_payok_remark");
//								String smssn=Config.getConfigValue("");
//								String smsspmd5=Config.getConfigValue("");
//								String smsurl=Config.getConfigValue("");
//								String signature=Config.getConfigValue("");
//								//发送短信通知
//								Member mem=memberDao.getById(order.getMember());
//								smsService.sendSms(mem.getTelephone(), msgcontent.replace("money", order.getFinalPrice()+""), "1", smssn, smsspmd5, smsurl, signature);
//								//发送信息给管理员
//								smsService.sendSms(AppConstants.MANAGER_MOBILE, AppConstants.SMS_PAYOK_TOMANAGER.replace("username", order.getuName()).replace("orderid", order.getId()));
//							}
//						
//						
//						}
//					}
					result = "success";// 请不要修改或删除
				}
			}
		} else {// 验证失败
			result = "fail";
		}

		// 结果不为""时返回相关数据
		if (!"".equals(result)) {
			response.getWriter().write(result);
			response.getWriter().flush();
		}

		return;
	}
	
	
	@RequestMapping("/notifyPC")
	public ModelAndView notifyPC(String out_trade_no,HttpServletRequest request,HttpServletResponse response) throws JDBCException,
			SQLException, HibernateException, Exception {

		logger.info("进入异步支付！-------->>>>>>");
		// 定义返回值
		String result = "";

		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//支付宝交易号

		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		
		String  notify_time=new String(request.getParameter("notify_time").getBytes("ISO-8859-1"),"UTF-8");
		String  gmt_close=new String(request.getParameter("gmt_payment").getBytes("ISO-8859-1"),"UTF-8");
		
		String  gmt_payment=new String(request.getParameter("gmt_payment").getBytes("ISO-8859-1"),"UTF-8");
		
		String  notify_type=new String(request.getParameter("notify_type").getBytes("ISO-8859-1"),"UTF-8");
		
		String  buyer_email=new String(request.getParameter("buyer_email").getBytes("ISO-8859-1"),"UTF-8");
		
		String  total_fee=new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
		
		
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		// if(1==1){
		if (AlipayNotify.verify(params)) {// 验证成功
			// 判断是否存在当前订单
			// DetachedCriteria dc =
			// DetachedCriteria.forClass(TsysRechargeLog.class);
			// dc.add(Restrictions.eq("outTradeNo", out_trade_no));
			logger.info("支付宝NotifyUrlAction ==out_trade_no=====>" + out_trade_no
					+ "doc_notify_data====>" + out_trade_no);

			CritMap critMap = new CritMap();
			critMap.addEqual("OUT_TRADE_NO", out_trade_no);
			List<RechargeLog> rechargeloglist = rechargeDao.findByCritMap(
					critMap, false);
			logger.info(rechargeloglist);
			if (null != rechargeloglist && rechargeloglist.size() > 0) {
				RechargeLog tsysrechargelog = rechargeloglist.get(0);
				/**
				 * 跟支付宝客服沟通 返回这两个结果均表示返回状态成功。且是实时到账的。2013-09-03
				 */
				if (trade_status.equals("TRADE_FINISHED")
						|| trade_status.equals("TRADE_SUCCESS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					if (notify_time.indexOf(" ") < 0) {
						notify_time = notify_time.substring(0, 10)
								+ " "
								+ notify_time.substring(10,
										notify_time.length());
					}
					if (gmt_close.indexOf(" ") < 0) {
						gmt_close = gmt_close.substring(0, 10) + " "
								+ gmt_close.substring(10, gmt_close.length());
					}
					if (gmt_payment.indexOf(" ") < 0) {
						gmt_payment = gmt_payment.substring(0, 10)
								+ " "
								+ gmt_payment.substring(10,
										gmt_payment.length());
					}
					tsysrechargelog.setNOTIFY_TIME(notify_time);
					tsysrechargelog.setTRADE_STATUS(trade_status);
					tsysrechargelog.setNOTIFY_TYPE(notify_type);
					tsysrechargelog.setBUYER_EMAIL(buyer_email);
					tsysrechargelog.setTOTAL_FEE_ALIPAY(Double
							.valueOf(total_fee));
					tsysrechargelog.setGMT_CLOSE(gmt_close);
					tsysrechargelog.setGMT_PAYMENT(gmt_payment);
					tsysrechargelog.setTRADE_NO(trade_no);
					rechargeDao.save(tsysrechargelog);

					// 更新订单表
					CritMap m=new CritMap();
					m.addEqual("orderId", out_trade_no);
//					List<PerfOrder> orderlist=orderDao.findByCritMap(m, false);
//					
//					if (null != orderlist && orderlist.size() > 0) {
//						for (int i = 0; i < orderlist.size(); i++) {
//							PerfOrder order = orderlist.get(i);
//							if (Consts.ORDER_PAY_STATUS_OK == order
//									.getPayStatus()) {
//								//成功
//								//return SUCCESS;
//							} else {
//								// 更新订单状态、更新支付状态
//								order.setPayStatus(Consts.ORDER_PAY_STATUS_OK);
//								//order.setOrderStatus(Consts.ORDERSTATUS_CONFIRM);
//								JsonConfig jsonConfig = new JsonConfig();
//								jsonConfig.setExcludes(new String[] {
//										"itvTimediscount",
//										"validItvTimediscount" });
//								JSONObject jsonObject = JSONObject.fromObject(
//										order, jsonConfig);
//								logger.debug(jsonObject);
//								//更新订单状态为支付成功
//							//	orderDao.save(order);
//								String msgcontent=Config.getConfigValue("sms_payok_remark");
//								String smssn=Config.getConfigValue("");
//								String smsspmd5=Config.getConfigValue("");
//								String smsurl=Config.getConfigValue("");
//								String signature=Config.getConfigValue("");
//								//发送短信通知
//								Member mem=memberDao.getById(order.getMember());
//								smsService.sendSms(mem.getTelephone(), msgcontent.replace("money", order.getFinalPrice()+""), "1", smssn, smsspmd5, smsurl, signature);
//								//发送信息给管理员
//								//smsService.sendSms(AppConstants.MANAGER_MOBILE, AppConstants.SMS_PAYOK_TOMANAGER.replace("username", order.getuName()).replace("orderid", order.getId()));
//							}
//						}
//
//					}
					result = "success";// 请不要修改或删除
				}
			}
		} else {// 验证失败
			result = "fail";
		}

		// 结果不为""时返回相关数据
		if (!"".equals(result)) {
			response.getWriter().write(result);
		}

		return null;
	}


}
