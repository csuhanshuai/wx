package com.qixin.app.zjmall.service;


import java.util.List;

import com.qixin.app.zjmall.model.Cart;
import com.qixin.app.zjmall.model.Product;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**  
 * 
 */
public interface CartService
{
    
    public void save(Cart cart) throws Exception;
    
    public void delete(String id) throws Exception;
    
    public PageFinder<Cart>  findCartUser(String uid,Query query) throws Exception;
        
    public List  queryCartbyid(String uid,Query query) throws Exception;
    
    public Cart findByid(String id) throws Exception;
    
    public void deleteCartByUid(String uid) throws Exception;
    
}
