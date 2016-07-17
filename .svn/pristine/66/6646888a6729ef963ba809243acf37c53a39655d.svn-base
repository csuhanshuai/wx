package com.qixin.app.zjmall.dao;

import java.util.List;

import com.qixin.app.zjmall.model.Cart;
import com.qixin.app.zjmall.model.Product;
import com.qixin.platform.persistent.database.IHibernateEntityDao;

public interface CartDao extends IHibernateEntityDao<Cart>
{
    /**
     * ������Ϣ
     * @param member
     */
    public void addCart(Cart cart) throws Exception;

    /**
     * ���ID��ѯ��Ϣ
     * @param id
     * @return
     */
    public Cart queryCartById(String id) throws Exception;
    
    /**
     * ��ѯ�ļ���Ϣ
     * @param member
     * @return
     */
    public List<Cart> queryMemberByModel(Product Cart) throws Exception;
    
    /**
     * ���User��Ϣ
     * @param term
     * @param termVal
     * @return MemberAccount
     */
    public Cart getCartByuser(String user) throws Exception;

  
    public List querybyCartUID(String user)throws Exception;
    
    /**
     * 删除某一用户的购物车信息
     * @param uid
     * @throws Exception
     */
    public void deleteCartByUid(String uid) throws Exception;
}
