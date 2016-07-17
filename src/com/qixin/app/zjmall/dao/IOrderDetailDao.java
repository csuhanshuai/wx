/**
 * 
 */
package com.qixin.app.zjmall.dao;

import java.util.List;

import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.platform.persistent.database.IHibernateEntityDao;

/**
 * 订单详情DAO
 * @author sky
 *
 */
public interface IOrderDetailDao extends IHibernateEntityDao<OrderDetail> {

	/**
	 * 查询某一个订单的订单详情(未分页，并关联了产品的图片路径)
	 * @param query
	 * @param orderId
	 * @return
	 */
	public List<OrderDetail> queryOrderDetail(String orderId) throws Exception;
}
