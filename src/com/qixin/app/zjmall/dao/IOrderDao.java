/**
 * 
 */
package com.qixin.app.zjmall.dao;

import java.util.List;

import com.qixin.app.zjmall.model.Order;
import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.platform.persistent.database.IHibernateEntityDao;
import com.qixin.platform.persistent.database.basedao.Query;

/**
 * @author sky
 *订单DAO
 */
public interface IOrderDao extends IHibernateEntityDao<Order> {
	/**
	 * 新增一个订单
	 * @param order
	 */
	public void addOrder(Order order) throws Exception;
	
	/**
	 * 查询所有订单
	 * @param query
	 * @return
	 */
	public List<Order> queryAllOrder() throws Exception;
	
	/**
	 * 修改订单
	 * @param order
	 * @throws Exception
	 */
	public void updateOrder(Order order) throws Exception;
	
	/**
	 * 删除一个订单
	 * @param order
	 * @throws Exception
	 */
	public void deleteOrder(String id) throws Exception;
	
}
