/**
 * 
 */
package com.qixin.app.zjmall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.qixin.app.zjmall.dao.IOrderDetailDao;
import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

/**
 * @author sky
 *
 */
@Repository
public class OrderDetailDaoImpl extends HibernateEntityDao<OrderDetail> implements
		IOrderDetailDao {

	/* (non-Javadoc)
	 * @see com.qixin.app.zjmall.dao.IOrderDetail#queryOrderDetail(java.lang.String)
	 */
	@Override
	public List<OrderDetail> queryOrderDetail(String orderId) throws Exception {
		
		String hql = "select a.id,a.pid,b.ptitle,a.buyNum,a.totalMoney,b.imgpath from OrderDetail as a,Product as b where a.pid = b.id and a.orderId=?";
		Assert.hasText(hql);
		List list = getHibernateTemplate().find(hql,
				new String[] { orderId });
		
		List<OrderDetail> respList = new ArrayList<OrderDetail>();
		if (list != null && list.size() > 0) {
			OrderDetail orderDetail;
			for (int i = 0; i < list.size(); i++) {
				Object[] object = (Object[]) list.get(i);
				orderDetail = new OrderDetail();
				orderDetail.setId((String) object[0]);
				orderDetail.setOrderId(orderId);
				orderDetail.setPid((String) object[1]);
				orderDetail.setPtitle((String) object[2]);
				orderDetail.setBuyNum((Integer)object[3]);
				orderDetail.setTotalMoney((Float)object[4]);
				orderDetail.setImgPath((String)object[5]);
				respList.add(orderDetail);
			}
		}
		return respList;
	}
}
