package com.qixin.app.zjmall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjmall.dao.IProductDao;
import com.qixin.app.zjmall.model.Product;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

/**  
 * 
 */
@Repository
public class ProductDaoImpl extends HibernateEntityDao<Product> implements
        IProductDao
{
    
    @Override
    public void addProduct(Product Product) throws Exception
    {
        
        super.save(Product);
        
    }
    
    @Override
    public Product getConfidInfoBytype(String ptype) throws Exception
    {
        
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<Product> queryAll() throws Exception
    {
        
        // TODO Auto-generated method stub
        return super.getAll();
    }
    
    @Override
    public List<Product> queryMemberByModel(Product Product) throws Exception
    {
        
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Product queryProductById(String id) throws Exception
    {
        
        // TODO Auto-generated method stub
        return super.getById(id);
    }

	@Override
	public List<Product> queryAllByUid(String uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    
}
