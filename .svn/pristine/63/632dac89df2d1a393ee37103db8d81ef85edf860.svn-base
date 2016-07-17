package com.qixin.app.pay.alipay.web;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.pay.alipay.dao.RechargeLogDao;
import com.qixin.app.pay.alipay.model.RechargeLog;
import com.qixin.app.pay.alipay.util.AlipayNotify;
import com.qixin.app.zjmall.model.Order;
import com.qixin.app.zjmall.service.IOrderService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.dao.ConsumptionDao;
import com.qixin.app.zjminweb.dao.CouponrecordDao;
import com.qixin.app.zjminweb.dao.IntegralruleDao;
import com.qixin.app.zjminweb.dao.MemberDao;
import com.qixin.app.zjminweb.model.Consumption;
import com.qixin.app.zjminweb.model.Integralrule;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.platform.persistent.database.basedao.CritMap;
//import com.qixin.app.sms.SmsService;
//import com.qixin.app.swj.dao.PerfOrderDaoImpl;
//import com.qixin.app.swj.model.PerfOrder;

/*******************************************************************************
 * 
 * http://localhost:8088/zy/noscurity/alipay/returnurl.kq?out_trade_no=7&
 * request_token
 * =201008309e298cf01c58146274208eda1e4cdf2b&result=success&trade_no
 * =2011110823389231&sign=49a330fee069465c64e561a25bf31c78
 * 
 * 功能： 支付宝实时消息接收接口
 */
@Controller
@RequestMapping("nosecurity/alipay")
public class ReturnUrlAction
{

    private static final Logger logger = Logger
            .getLogger(ReturnUrlAction.class);

    @Resource
    private RechargeLogDao rechargeDao;

    // @Resource
    // private PerfOrderDaoImpl orderDao;

    /** 短信接口 */
    // @Resource
    // private SmsService smsService;

    @Resource
    private IOrderService orderService;

    @Resource
    private MemberDao memberDao;

    @Resource
    private ConsumptionDao consumptiondao;

    @Resource
    private IntegralruleDao integralruledao;

    @Resource
    private IntegralService integralservice;

    public ReturnUrlAction()
    {

    }

    /**
     * 
     * @param result 支付结果
     * @param out_trade_no 商户网站唯一订单号
     * @param trade_no 支付宝交易号
     * @param request_token 授权令牌
     * @param request
     * @return
     * @throws JDBCException
     * @throws SQLException
     * @throws HibernateException
     * @throws Exception
     */
    @RequestMapping("/returnurl")
    public ModelAndView returnurl(String result, String out_trade_no,
            String trade_no, String request_token, HttpServletRequest request,
            ModelMap map) throws JDBCException, SQLException,
            HibernateException, Exception
    {
        // 获取支付宝GET过来反馈信息
        logger.info("进入同步支付！-------->>>>>>result:" + result + ">>out_trade_no:"
                + out_trade_no + ">>trade_no:" + trade_no + ">>request_token:"
                + request_token);
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();)
        {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++)
            {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        // 交易状态
        String trade_status = new String(request.getParameter("trade_status")
                .getBytes("ISO-8859-1"), "UTF-8");

        // 计算得出通知验证结果
        boolean verify_result = AlipayNotify.verifyReturn(params);
        logger.info("verify_result:" + verify_result);

        float totalfee = 0;

        if (verify_result)
        {
            // 验证成功

            /*******************************************************************
             * 手机支付宝实时回调接口 判断是否存在该订单 a.如果存在处理如下 (1) 存在的处理结果为成功处理 就直接返回success
             * (2) 存在的处理结果不是成功处理 支付宝返回结果为成功时 1.更新支付宝日志表，2.更新订单表 (3)
             * 存在的处理结果不是成功处理 支付宝返回结果不是成功时 1.更新支付宝日志表2.更新订单表 b.如果不存在就返回失败
             */

            logger.info("支付宝回调接口ReturnUrlAction==out_trade_no=====>"
                    + out_trade_no);

            CritMap critMap = new CritMap();
            critMap.addEqual("OUT_TRADE_NO", out_trade_no);
            List<RechargeLog> rechargeloglist = rechargeDao.findByCritMap(
                    critMap, false);
            if (rechargeloglist != null && rechargeloglist.size() > 0)
            {
                RechargeLog rechargelog = rechargeloglist.get(0);
                rechargelog.setTRADE_STATUS(result);
                rechargelog.setTRADE_NO(trade_no);
                rechargeDao.save(rechargelog);// 更新

                // 查看订单表
                String orderids[] = out_trade_no.split("\\_");
                for (String orderid : orderids)
                {
                    Order order = orderService.queryOrderById(orderid);
                    totalfee = totalfee + order.getTotalMoney();

                    if (0 != order.getStatus())
                    {
                        logger.debug("未更新，已经是成功");
                        JsonConfig jsonConfig = new JsonConfig();
                        jsonConfig.setExcludes(new String[] {
                                "itvTimediscount", "validItvTimediscount" });
                        JSONObject jsonObject = JSONObject.fromObject(order,
                                jsonConfig);
                        logger.debug(jsonObject);
                    }
                    else
                    {
                        // 判断返回结果
                        if ("TRADE_FINISHED".equals(result)
                                || "TRADE_SUCCESS".equals(result)
                                || "success".equals(result))
                        {
                            order.setStatus(1);
                        }
                        else
                        {
                            order.setStatus(0);
                        }
                        JsonConfig jsonConfig = new JsonConfig();
                        jsonConfig.setExcludes(new String[] {
                                "itvTimediscount", "validItvTimediscount" });
                        JSONObject jsonObject = JSONObject.fromObject(order,
                                jsonConfig);
                        logger.debug(jsonObject);
                        orderService.updateOrder(order);

                    }
                }
                Member member = (Member) request.getSession().getAttribute(
                        "zjminweb_member");
                if (member != null)
                {

                    map.put("bid", member.getBizid());
                    map.put("openid", member.getOpenid());
                }
            }

        }

        return new ModelAndView("redirect:/zjmall/myOrder.kq", map);
    }

    @RequestMapping("/returnurlPC")
    public ModelAndView returnurlPC(String result, String out_trade_no,
            String trade_no, String request_token, HttpServletRequest request,
            ModelMap map) throws JDBCException, SQLException,
            HibernateException, Exception
    {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();)
        {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++)
            {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        // 商户订单号

        out_trade_no = new String(request.getParameter("out_trade_no")
                .getBytes("ISO-8859-1"), "UTF-8");

        // 支付宝交易号

        trade_no = new String(request.getParameter("trade_no").getBytes(
                "ISO-8859-1"), "UTF-8");

        // 交易状态
        String trade_status = new String(request.getParameter("trade_status")
                .getBytes("ISO-8859-1"), "UTF-8");

        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        // 计算得出通知验证结果
        boolean verify_result = AlipayNotify.verifyReturn(params);
        logger.info("verify_result:" + verify_result);

        float totalfee = 0;

        // 验证成功
        if (verify_result)
        {

            /*******************************************************************
             * 手机支付宝实时回调接口 判断是否存在该订单 a.如果存在处理如下 (1) 存在的处理结果为成功处理 就直接返回success
             * (2) 存在的处理结果不是成功处理 支付宝返回结果为成功时 1.更新支付宝日志表，2.更新订单表 (3)
             * 存在的处理结果不是成功处理 支付宝返回结果不是成功时 1.更新支付宝日志表2.更新订单表 b.如果不存在就返回失败
             */

            logger.info("支付宝回调接口ReturnUrlAction==out_trade_no =====>"
                    + out_trade_no);
            CritMap critMap = new CritMap();
            critMap.addEqual("OUT_TRADE_NO", out_trade_no);
            List<RechargeLog> rechargeloglist = rechargeDao.findByCritMap(
                    critMap, false);
            if (rechargeloglist != null && rechargeloglist.size() > 0)
            {
                RechargeLog rechargelog = rechargeloglist.get(0);
                rechargelog.setTRADE_STATUS(trade_status);
                rechargelog.setTRADE_NO(trade_no);
                rechargeDao.save(rechargelog);// 更新

                // 查看订单表
                String orderids[] = out_trade_no.split("\\_");

                for (String orderid : orderids)
                {
                    Order order = orderService.queryOrderById(orderid);
                    totalfee = totalfee + order.getTotalMoney();

                    if (0 != order.getStatus())
                    {
                        logger.debug("未更新，已经是成功");
                        JsonConfig jsonConfig = new JsonConfig();
                        jsonConfig.setExcludes(new String[] {
                                "itvTimediscount", "validItvTimediscount" });
                        JSONObject jsonObject = JSONObject.fromObject(order,
                                jsonConfig);
                        logger.debug(jsonObject);
                    }
                    else
                    {
                        // 判断返回结果
                        if ("TRADE_SUCCESS".equals(result)
                                || "success".equals(result)
                                || "TRADE_FINISHED".equals(result))
                        {
                            order.setStatus(1);
                        }
                        else
                        {
                            order.setStatus(0);
                        }
                        JsonConfig jsonConfig = new JsonConfig();
                        jsonConfig.setExcludes(new String[] {
                                "itvTimediscount", "validItvTimediscount" });
                        JSONObject jsonObject = JSONObject.fromObject(order,
                                jsonConfig);
                        logger.debug(jsonObject);
                        orderService.updateOrder(order);

                    }

                }

                Member member = (Member) request.getSession().getAttribute(
                        "zjminweb_member");
                if (member != null)
                {
                    addOtherOperate(member, totalfee);

                    map.put("bid", member.getBizid());
                    map.put("openid", member.getOpenid());
                }
            }

        }

        return new ModelAndView("redirect:/zjmall/myOrder.kq", map);
    }

    private void addOtherOperate(Member u, float allTotalPric) throws Exception
    {
        // 同时还要增加用户的消费积分
        Consumption consumption = new Consumption();
        consumption.setMemberid(u.getId());
        consumption.setMoney(String.valueOf(allTotalPric));
        Date nowdate = CommonTool.getNowDateBySDF("yyyy-MM-dd HH:mm:ss");
        consumption.setIntime(nowdate);
        consumption.setReasons("商城消费");
        consumption.setStatus("0");
        consumption.setType("0");
        consumption.setBizid(u.getBizid());
        consumption.setBalance(u.getBalance());
        String result = (String) consumptiondao.save(consumption);

        // 增加相应积分
        if (!CommonTool.isEmpty(result))
        {
            CritMap critMap = new CritMap();
            critMap.addEqual("bizid", u.getBizid());
            List<Integralrule> integralrulelist = (List<Integralrule>) integralruledao
                    .findByCritMap(critMap, new boolean[] { true });

            if (!CommonTool.isEmpty(integralrulelist)
                    && integralrulelist.size() == 1)
            {
                Integralrule integralrule = integralrulelist.get(0);

                int totalMoney = (int) allTotalPric;
                String integral = ServiceTool.getIntegralOnRuleByMoney(
                        integralrule, String.valueOf(totalMoney));

                u.setIntegral(CommonTool.numberAdd(u.getIntegral(), integral));
                memberDao.merge(u);

                // 增加积分消费记录
                this.integralservice.addIntegral(u, "0", integral, "消费获取");

            }
        }
    }

}
