/**
 * 
 */
package com.qixin.app.zjmall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjmall.dao.IOrderDao;
import com.qixin.app.zjmall.model.Order;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

/**
 * @author sky
 *
 */
@Repository
public class OrderDaoImpl extends HibernateEntityDao<Order> implements IOrderDao {

	/* (non-Javadoc)
	 * @see com.qixin.app.zjmall.dao.IOrderDao#addOrder(com.qixin.app.zjmall.model.Order)
	 */
	@Override
	public void addOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		super.save(order);

	}

	/* (non-Javadoc)
	 * @see com.qixin.app.zjmall.dao.IOrderDao#deleteOrder(com.qixin.app.zjmall.model.Order)
	 */
	@Override
	public void deleteOrder(String id) throws Exception {
		// TODO Auto-generated method stub
		super.removeById(id);
	}

	/* (non-Javadoc)
	 * @see com.qixin.app.zjmall.dao.IOrderDao#queryAllOrder(com.qixin.platform.persistent.database.basedao.Query)
	 */
	@Override
	public List<Order> queryAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	/* (non-Javadoc)
	 * @see com.qixin.app.zjmall.dao.IOrderDao#updateOrder(com.qixin.app.zjmall.model.Order)
	 */
	@Override
	public void updateOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		super.merge(order);
	}
}
