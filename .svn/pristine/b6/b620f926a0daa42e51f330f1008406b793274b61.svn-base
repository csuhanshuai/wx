/**
 * 
 */
package com.qixin.app.zjmall.service;

import java.util.List;
import java.util.Map;

import com.qixin.app.zjmall.model.Order;
import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**
 * @author sky 订单的业务接口
 */
public interface IOrderService
{

    /**
     * 新增一个订单
     * 
     * @param order
     */
    public String addOrder(Order order, String openId, String coupon,
            String payType, Member u, String bid,
            Map<String, String> orderToAlipaymap) throws Exception;

    /**
     * 查询所有订单(分页)
     * 
     * @param query
     * @return
     */
    public PageFinder<Order> queryAllOrder(Query query) throws Exception;

    public void updateOrder(Order order) throws Exception;

    public void deleteOrder(String id) throws Exception;

    /**
     * 根据订单ID查询一个订单
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public Order queryOrderById(String id) throws Exception;

    /**
     * 查询某一个订单的订单详情
     * 
     * @param query
     * @param orderId
     * @return
     */
    public PageFinder<OrderDetail> queryOrderDetail(Query query, String orderId)
            throws Exception;

    /**
     * 根据用户ID查询该用户的所有订单(未分页)
     * 
     * @param uid
     * @return
     * @throws Exception
     */
    public List<Order> queryOrderByUid(String uid) throws Exception;

    /**
     * 根据用户ID查询该用户的所有订单（分页）
     * 
     * @param query
     * @param uid
     * @return
     * @throws Exception
     */
    public PageFinder<Order> queryOrderByUidForPage(Query query, String uid)
            throws Exception;

    /**
     * 查询某一个订单的订单详情(不分页) 并关联查询到每件产品的图片
     * 
     * @param query
     * @param orderId
     * @return
     */
    public List<OrderDetail> queryOrderDetail(String orderId) throws Exception;
}
