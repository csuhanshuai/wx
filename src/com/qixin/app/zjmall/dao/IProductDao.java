package com.qixin.app.zjmall.dao;

import java.util.List;

import com.qixin.app.zjmall.model.Product;
import com.qixin.platform.persistent.database.IHibernateEntityDao;

/**  
 * 
 */
public interface IProductDao extends IHibernateEntityDao<Product> 
{
    /**
     * 新增信息
     * @param member
     */
    public void addProduct(Product Product) throws Exception;

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    public Product queryProductById(String id) throws Exception;
    
    /**
     * 查询文件信息
     * @param member
     * @return
     */
    public List<Product> queryMemberByModel(Product Product) throws Exception;
    
    /**
     * 根据类型信息
     * @param term
     * @param termVal
     * @return MemberAccount
     */
    public Product getConfidInfoBytype(String ptype) throws Exception;

    /**
     * 查询所有文件信息
     * @param member
     * @return
     */
    public List<Product> queryAll() throws Exception;
    
    public List<Product> queryAllByUid(String uid) throws Exception;
   
    
}
