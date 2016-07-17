package com.qixin.app.zjmall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.qixin.app.zjmall.dao.CartDao;
import com.qixin.app.zjmall.model.Cart;
import com.qixin.app.zjmall.model.Product;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

import edu.emory.mathcs.backport.java.util.LinkedList;

/**
 * 
 */
@Repository
public class CartDaoImpl extends HibernateEntityDao<Cart> implements CartDao {

	@Override
	public void addCart(Cart cart) throws Exception {

		super.save(cart);

	}

	@Override
	public Cart getCartByuser(String user) throws Exception {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart queryCartById(String id) throws Exception {

		// TODO Auto-generated method stub
		return super.getById(id);
	}

	@Override
	public List<Cart> queryMemberByModel(Product Cart) throws Exception {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List querybyCartUID(String user) throws Exception {

		// Session session =
		// this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		StringBuffer sb = new StringBuffer(
				" select p.id,p.pid,p.ptitle,p.pric,p.opric,p.imgpath,c.number,c.id,p.category from Product as p,Cart as c where p.id=c.pid  and c.uid=?");
		// org.hibernate.Query q = session.createQuery(sb.toString());
		// q.setParameter("uid", user);

		Assert.hasText(sb.toString());
		List list = getHibernateTemplate().find(sb.toString(),
				new String[] { user });
		// q.list();
		LinkedList unionPlist = new LinkedList();

		if (list != null && list.size() > 0) {
			Product pt;
			for (int i = 0; i < list.size(); i++) {
				LinkedList plis = new LinkedList();

				Object[] object = (Object[]) list.get(i);// ÿ�м�¼������һ������
															// ����һ������
				String id = (String) object[0];
				String pid = (String) object[1];
				String ptitle = (String) object[2];
				String pric = (String) object[3];
				String opric = (String) object[4];
				String imgpath = (String) object[5];
				String category = (String) object[8];
				pt = new Product(ptitle, pid, "", opric, pric, null, imgpath,
						null, null, null, null, null, 0, 0,category);
				pt.setId(id);
				plis.add(pt);

				// 保存该产品的购物车数量
				Integer number = (Integer) object[6];
				//购物车ID
				String cartId = (String) object[7];
				plis.add(number);
				plis.add(cartId);
				unionPlist.add(plis);
			}

		}
		return unionPlist;
	}

	@Override
	public void deleteCartByUid(String uid) throws Exception {
		
		this.createQuery("delete Cart where uid = ?", uid).executeUpdate();
	}

}
