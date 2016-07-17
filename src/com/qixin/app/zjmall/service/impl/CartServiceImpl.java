package com.qixin.app.zjmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.CartDao;
import com.qixin.app.zjmall.model.Cart;
import com.qixin.app.zjmall.model.Product;
import com.qixin.app.zjmall.service.CartService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**
 * 
 */
@Service
public class CartServiceImpl implements CartService {

	@Resource
	private CartDao cartDao;

	@Override
	public void delete(String id) throws Exception {

		cartDao.removeById(id);

	}

	@Override
	public Cart findByid(String id) throws Exception {

		// TODO Auto-generated method stub
		return cartDao.queryCartById(id);
	}

	@Override
	public PageFinder<Cart> findCartUser(String uid, Query query)
			throws Exception {

		CritMap mp = new CritMap();

		// mp.addDesc("addtime");

		mp.addLike("uid", uid);
		return cartDao.pagedByCritMap(mp, query.getPage(), query.getPageSize());
	}

	@Override
	public void save(Cart cart) throws Exception {
		
		CritMap mp = new CritMap();
		mp.addEqual("pid", cart.getPid());
		mp.addEqual("uid",cart.getUid());
		//先查询该用户购物车中已经存在相同产品，如果有则累加数量并更新，如果没有则新增一条记录
		List<Cart> cartList = cartDao.findByCritMap(mp, true);
		
		if (null != cartList && cartList.size() >0){
			Cart thisCart = cartList.get(0);
			int num = thisCart.getNumber() + cart.getNumber();
			thisCart.setNumber(num);
			cartDao.merge(thisCart);
			return;
		}
		cartDao.save(cart);

	}

	@Override
	public List queryCartbyid(String uid, Query query)
			throws Exception {
		return cartDao.querybyCartUID(uid);
		// cartDao.querybyCartUID(uid);
	}

	@Override
	public void deleteCartByUid(String uid) throws Exception{
		// TODO Auto-generated method stub
		cartDao.deleteCartByUid(uid);
	}

	
}
