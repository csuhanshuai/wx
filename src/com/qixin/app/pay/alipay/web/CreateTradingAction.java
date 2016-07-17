package com.qixin.app.pay.alipay.web;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.pay.alipay.config.AlipayConfig;
import com.qixin.app.pay.alipay.dao.RechargeLogDao;
import com.qixin.app.pay.alipay.model.RechargeLog;
import com.qixin.app.pay.alipay.util.AlipaySubmit;
import com.qixin.app.pay.alipay.util.UtilDate;

/**
 * 调用支付宝手机支付接口action
 */
@Controller
@RequestMapping("nosecurity/alipay")
public class CreateTradingAction {

	private static final Logger logger = Logger
			.getLogger(CreateTradingAction.class);

	/** 商品展示地址 **/
	// private String show_url;



	@Resource
	private RechargeLogDao rechargeDao;

	public CreateTradingAction() {
		// rightcode="createtrading";
		// this.alipayservice =
		// (AlipayService)BeanUtil.getBean("alipayService");
	}

	/**
	 * go方法 创建支付宝交易日志
	 * <p>
	 * 方法说明:生成数据库唯一标示记录 ，然后调用生成表单方法 提交表单
	 * </p>
	 * 
	 * @date 2013-3-17
	 */
	@RequestMapping("/go")
	public ModelAndView go(String subject, String total_fee,
			String out_trade_no, String order_id, ModelMap map)
			throws Exception {
		// 价格超过千 替换掉'，'
		total_fee = total_fee.replace(",", "");
		// 生成唯一标示
		// out_trade_no =
		// alipayservice.getNextProductId(Integer.valueOf(order_id));
		// todo 订单号,要换
		out_trade_no = order_id;
		if (out_trade_no != null && !out_trade_no.equals("")) {
			String alipayFormText = getAlipaySubmitForm(subject, total_fee,
					out_trade_no, order_id);

			map.put("formHtml", alipayFormText);
		} else {
			logger.info("生成alipay_no唯一标示失败!");
		}

		// 入支付宝记录表
		RechargeLog tsysrechargelog = new RechargeLog();
		tsysrechargelog.setOUT_TRADE_NO(out_trade_no);
		tsysrechargelog.setOrder_Name(subject);
		tsysrechargelog.setTOTAL_FEE(Double.valueOf(total_fee));
		tsysrechargelog.setService_name("alipay.wap.trade.create.direct");
		rechargeDao.save(tsysrechargelog);
		logger.info("====>生成alipay_no:" + out_trade_no);

		return new ModelAndView("/app/alipay/dispachPage", map);
	}

	/**
	 * getAlipaySubmitForm方法
	 * <p>
	 * 方法说明:支付宝即时到账交易接口FORM表单。
	 * </p>
	 * 
	 * @date 2013-3-17
	 */
	private String getAlipaySubmitForm(String subject, String total_fee,
			String out_trade_no, String order_id) {

		// 支付宝网关地址
		String ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";
		// 返回格式
		String format = "xml";

		// 返回格式
		String v = "2.0";
		// 请求号
		String req_id = UtilDate.getOrderNum();

		// 卖家支付宝帐户f@bindow.cn 
		//4006191616@bdd1616.com
		//String seller_email = "f@bindow.cn";
		String seller_email = AppConstants.alipayAccount;
		// 服务器异步通知页面路径
		String notify_url = AlipayConfig.getAlipayReturnNotifyUrl();

		// 页面跳转同步通知页面路径
		String call_back_url = AlipayConfig.getAlipayReturnCallbackUrl();

		// 请求业务参数详细
		String req_dataToken = "<direct_trade_create_req><notify_url>"
				+ notify_url + "</notify_url><call_back_url>" + call_back_url
				+ "</call_back_url><seller_account_name>" + seller_email
				+ "</seller_account_name><out_trade_no>" + out_trade_no
				+ "</out_trade_no><subject>" + subject
				+ "</subject><total_fee>" + total_fee
				+ "</total_fee></direct_trade_create_req>";

		logger.info("=************===>生成req_dataToken:" + req_dataToken);
		// 把请求参数打包成数组
		Map<String, String> sParaTempToken = new HashMap<String, String>();
		sParaTempToken.put("service", "alipay.wap.trade.create.direct");
		sParaTempToken.put("partner", AlipayConfig.partner);
		sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
		sParaTempToken.put("sec_id", AlipayConfig.sign_type);
		sParaTempToken.put("format", format);
		sParaTempToken.put("v", v);
		sParaTempToken.put("req_id", req_id);
		sParaTempToken.put("req_data", req_dataToken);

		// 建立请求
		String sHtmlTextToken = "";
		String request_token = "";
		try {
			sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, "",
					"", sParaTempToken);
			// URLDECODE返回的信息
			sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,
					AlipayConfig.input_charset);
			// 获取token
			request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		// //////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////

		// 业务详细
		String req_data = "<auth_and_execute_req><request_token>"
				+ request_token + "</request_token></auth_and_execute_req>";
		// 必填

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("sec_id", AlipayConfig.sign_type);
		sParaTemp.put("format", format);
		sParaTemp.put("v", v);
		sParaTemp.put("req_data", req_data);

		// 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,
				sParaTemp, "get", "确认");

		return sHtmlText;
	}
	
	
	/**
	 * go方法 创建支付宝交易日志
	 * <p>
	 * 方法说明:生成数据库唯一标示记录 ，然后调用生成表单方法 提交表单
	 * </p>
	 * 
	 * @date 2013-3-17
	 */
	@RequestMapping("/gopc")
	public ModelAndView goPC(String subject, String total_fee,
			String out_trade_no, String order_id, ModelMap map)
			throws Exception {
		// 价格超过千 替换掉'，'
		total_fee = total_fee.replace(",", "");
		// 生成唯一标示
		// out_trade_no =
		// alipayservice.getNextProductId(Integer.valueOf(order_id));
		// todo 订单号,要换
		out_trade_no = order_id;
		if (out_trade_no != null && !out_trade_no.equals("")) {
			String alipayFormText = getAlipaySubmitFormPC(subject, total_fee,
					out_trade_no, order_id);

			map.put("formHtml", alipayFormText);
		} else {
			logger.info("生成alipay_no唯一标示失败!");
		}

		// 入支付宝记录表
		RechargeLog tsysrechargelog = new RechargeLog();
		tsysrechargelog.setOUT_TRADE_NO(out_trade_no);
		tsysrechargelog.setOrder_Name(subject);
		tsysrechargelog.setTOTAL_FEE(Double.valueOf(total_fee));
		tsysrechargelog.setService_name("create_direct_pay_by_user");
		rechargeDao.save(tsysrechargelog);
		logger.info("====>生成alipay_no:" + out_trade_no);

		return new ModelAndView("/app/alipay/dispachPage", map);
	}

	/**
	 * getAlipaySubmitForm方法
	 * <p>
	 * 方法说明:支付宝即时到账交易接口FORM表单。
	 * </p>
	 * 
	 * @date 2013-3-17
	 */
	private String getAlipaySubmitFormPC(String subject, String total_fee,
			String out_trade_no, String order_id) {

		// 支付宝网关地址
		String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
		// 返回格式
		String format = "xml";

		// 返回格式
		String v = "2.0";
		// 请求号
		String req_id = UtilDate.getOrderNum();

		// 卖家支付宝帐户f@bindow.cn
		//String seller_email = "f@bindow.cn";
		String seller_email = AppConstants.alipayAccount;
		// 服务器异步通知页面路径
		String notify_url = AlipayConfig.getAlipayReturnNotifyUrlPC();

		// 页面跳转同步通知页面路径
		String call_back_url = AlipayConfig.getAlipayReturnCallbackUrlPC();

		// 请求业务参数详细
		String req_dataToken = "<direct_trade_create_req><notify_url>"
				+ notify_url + "</notify_url><return_url>" + call_back_url
				+ "</return_url><seller_account_name>" + seller_email
				+ "</seller_account_name><out_trade_no>" + out_trade_no
				+ "</out_trade_no><subject>" + subject
				+ "</subject><total_fee>" + total_fee
				+ "</total_fee></direct_trade_create_req>";

		logger.info("=************===>生成req_dataToken:" + req_dataToken);
		// 把请求参数打包成数组
	
		// 必填

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
	
		sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", "1");
		
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", call_back_url);
		sParaTemp.put("seller_email", seller_email);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		//sParaTemp.put("body", body);

		// 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,
				sParaTemp, "get", "确认");

		return sHtmlText;
	}
	

	
	


}
