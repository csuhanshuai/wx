package com.qixin.app.zjmall.service;

import java.util.List;

import com.qixin.app.zjmall.model.ProductType;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public interface IProductTypeService
{
    /**
     * 增加商品类型
     * @return
     */
    public String addProductType(ProductType productType) throws Exception;
    
    /**
     * 根据ID查询商品类型
     * @param id
     * @return
     */
    public ProductType getProductTypeById(String id);
    
    /**
     * 根据问题查询商品类型
     * @param id
     * @return
     */
    public ProductType getProductTypeByExample(String bizid,String typename);
    
    /**
     * 获取所有商品类型
     * @return
     */
    public List<ProductType> getAllProductType();
    
    /**
     * 获取当前用户所有商品类型
     * @return
     */
    public List<ProductType> getAllbyuid(String bizid);
    
    /**
     * 获取当前用户所有商品类型
     * @return
     */
    public PageFinder<ProductType> getAllProductTypeByBid(String bid,Query query);
    
    /**
     * 
     * @return
     */
    public PageFinder<ProductType> getProductTypeBytay(String istay,String bid,Query query);
    /**
     * 获取型
     * @return
     */
    public  List<ProductType> getPTypelisBytay(String istay,String bid);
    /**
     * 翻页查询
     * @param productType 查询条件
     * @param query         翻页条件
     * @return
     */
    public PageFinder<ProductType> pageQueryProductType(
            ProductType productType, Query query);
    
    /**
     * 修改商品类型
     * @param Menu
     * @return
     * @throws Exception 
     */
    public String updateProductType(ProductType productType) throws Exception;
    
    /**
     * 删除商品类型
     * @param roleid
     * @return
     */
    public String removeProductType(String roleid) throws Exception;
}
