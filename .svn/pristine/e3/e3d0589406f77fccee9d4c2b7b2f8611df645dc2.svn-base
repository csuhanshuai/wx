package com.qixin.app.zjmall.service;

import com.qixin.app.zjmall.model.Product;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**  
 * 
 */
public interface IProductService
{

    public String save(Product Product) throws Exception;

    public void delete(String id) throws Exception;

    public PageFinder<Product> findProductTitle(String title, Query query)
            throws Exception;

    public PageFinder<Product> findByProducttype(String type, Query query)
            throws Exception;

    public PageFinder<Product> UserfindProductByTitle(String uid, String title,
            Query query) throws Exception;

    public PageFinder<Product> UserfindByProductBytype(String uid, String type,
            Query query) throws Exception;

    public PageFinder<Product> getAllbyuid(String uid, Query query,String isshow)
            throws Exception;
    
    public PageFinder<Product> getAllforbid(String uid, Query query)
            throws Exception;

    public PageFinder<Product> getAll(Query query) throws Exception;

    public Product findByid(String id) throws Exception;

    public String getname(String id) throws Exception;

    public abstract String updateProduct(Product product) throws Exception;

}
