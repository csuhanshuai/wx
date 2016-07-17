/**
 * 
 */
package com.qixin.app.zjmall.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjmall.model.Order;
import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.app.zjmall.service.IOrderService;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**
 * @author sky 订单的后台管理
 */
@Controller
@RequestMapping("/mallmanage")
public class OrderController
{

    @Resource
    private IOrderService orderService;

    @Resource
    private MemberService memberservice;

    /**
     * 分页查询订单列表
     * 
     * @param query
     * @param type
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryOrder")
    public ModelAndView queryOrder(Query query, String type,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        query = (query != null) ? query : new Query();
        query.setPageSize(10);
        PageFinder<Order> pageFinder = orderService.queryAllOrder(query);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("pageFinder", pageFinder);

        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        map.put("bid", bid);
        map.put("baseAppUrl", AppConstants.baseAppUrl);
        map.put("type", type);
        return new ModelAndView("/app/zjmall/orderlist", map);
    }

    /**
     * 更新订单
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/updateOrderByajax")
    public void updateOrderByajax(Order order, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter out = response.getWriter();
        try
        {
            orderService.updateOrder(order);
            out.print("succ");
        }
        catch (Exception e)
        {
            out.print("error");
        }
        finally
        {
            out.flush();
            out.close();
        }
    }

    /**
     * 更新订单
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/updateOrder")
    public ModelAndView updateOrder(Order order, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String type)
            throws Exception
    {
        map.put("type", type);
        try
        {
            orderService.updateOrder(order);
        }
        catch (Exception e)
        {
            CommonLogger.error("修改订单出错 :", e);
            map.put("errorMsg", "出错了!");

        }
        return new ModelAndView("redirect:queryOrder.kq", map);

    }

    /**
     * 删除订单
     * 
     * @param id
     * @param type
     * @param request
     * @param response
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/removeOrder")
    public ModelAndView removeOrder(String id, String type,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map) throws Exception
    {
        map.put("type", type);
        try
        {
            orderService.deleteOrder(id);
        }
        catch (Exception e)
        {
            CommonLogger.error("删除订单出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("/warnframe", map);

        }
        return new ModelAndView("redirect:queryOrder.kq", map);

    }

    @RequestMapping("/queryOrderById")
    public ModelAndView queryOrderById(String id, String type,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map) throws Exception
    {

        try
        {
            Order order = orderService.queryOrderById(id);
            map.put("order", order);
            map.put("type", type);

        }
        catch (Exception e)
        {
            CommonLogger.error("删除订单出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("/warnframe", map);

        }
        return new ModelAndView("/app/zjmall/orderupdate", map);

    }

    /**
     * 分页查询订单详情列表
     * 
     * @param query
     * @param type
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryOrderDetail")
    public ModelAndView queryOrderDetail(Query query, String type, String id,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        String orderId = id;
        query = (query != null) ? query : new Query();
        query.setPageSize(10);
        PageFinder<OrderDetail> pageFinder = orderService.queryOrderDetail(
                query, orderId);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("pageFinder", pageFinder);

        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        map.put("bid", bid);
        map.put("baseAppUrl", AppConstants.baseAppUrl);
        map.put("type", type);
        return new ModelAndView("/app/zjmall/orderdetail", map);
    }

    @RequestMapping("/zjmall/confirmOrder")
    public ModelAndView confirmOrder(String orderid, String openid, String bid,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Order order = orderService.queryOrderById(orderid);

        order.setStatus(3);
        orderService.updateOrder(order);

        map.put("order", order);

        map.put("orderid", orderid);
        map.put("openid", openid);
        map.put("bid", bid);
        return new ModelAndView("redirect:/zjmall/myOrder.kq", map);
    }

    @RequestMapping("/zjmall/cancelOrder")
    public ModelAndView cancelOrder(String orderid, String openid, String bid,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        Map<String, Object> map = new HashMap<String, Object>();

        // 验证此用户的有效性
        Member u = memberservice.getMemberByOpenid(openid);
        if (u == null || null == openid || "".equals(openid))
            return new ModelAndView("redirect:tologin.kq", map);

        orderService.deleteOrder(orderid);

        map.put("orderid", orderid);
        map.put("openid", openid);
        map.put("bid", bid);
        return new ModelAndView("redirect:/zjmall/myOrder.kq", map);
    }

    @RequestMapping("/zjmall/payOrder")
    public void payOrder(String orderid, String openid, String bid,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        PrintWriter out = null;
        Response<Map<String, Object>> resp = new Response<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orderid", orderid);
        map.put("openid", openid);
        map.put("bid", bid);

        try
        {

            out = response.getWriter();

            // 验证此用户的有效性
            Member u = memberservice.getMemberByOpenid(openid);
            if (u == null || null == openid || "".equals(openid))
            {
                // return new ModelAndView("redirect:tologin.kq", map);
                resp.setResult("error");
                resp.setMessage("您未登陆，不允许进行此操作！");

            }
            else
            {
                Order order = orderService.queryOrderById(orderid);
                if (order != null)
                {
                    String paytyle = order.getPayType();

                    // 未支付的订单只可能是非余额支付方式，否则订单错误
                    if ("1".equals(paytyle))
                    {
                        resp.setResult("error");
                        resp.setMessage("订单信息错误！");
                    }
                    else
                    {
                        // ModelAndView("redirect:/zjmall/myOrder.kq", map);
                        map.put("order", order);
                        resp.setResult("success");
                        resp.setT(map);
                        resp.setMessage("转向支付页面");

                    }

                }
                else
                {
                    resp.setResult("error");
                    resp.setMessage("订单信息错误！");
                }

            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("integral operate出错 :", e);
            resp.setResult("error");
            resp.setMessage("操作失败!");
            out.print(JSONObject.fromObject(resp).toString());
        }
        finally
        {
            out.flush();
            out.close();
        }
    }
}
