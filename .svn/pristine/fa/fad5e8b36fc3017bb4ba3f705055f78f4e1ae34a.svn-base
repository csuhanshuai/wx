package com.qixin.app.zjmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjmall.dao.IProductTypeDao;
import com.qixin.app.zjmall.model.ProductType;
import com.qixin.app.zjmall.service.IProductTypeService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class ProductTypeServiceImpl implements IProductTypeService
{
    
    @Resource
    private IProductTypeDao ptDao;
    
    @Override
    public String addProductType(ProductType productType) throws Exception
    {
    	productType.setId(ShortUUID.generateShortUuid());
        return (String) ptDao.save(productType);
    }
    
    @Override
    public ProductType getProductTypeById(String id)
    {
        return ptDao.getById(id);
    }
    
    @Override
    public ProductType getProductTypeByExample(String bizid,String question)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("typename", question);
        critMap.addEqual("bizid", bizid);
        return ptDao.getObjectByCritMap(critMap, false);
    }
    
    @Override
    public List<ProductType> getAllProductType()
    {
        return ptDao.getAll();
    }
    
    @Override
    public PageFinder<ProductType> pageQueryProductType(
            ProductType productType, Query query)
    {
        CritMap critMap = new CritMap();
        critMap.addDesc("addtime");
        
        return ptDao.pagedByCritMap(critMap,
                query.getPage(),
                query.getPageSize());
    }
    
    @Override
    public String updateProductType(ProductType productType) throws Exception
    {
        ProductType pt = ptDao.merge(productType);
        return pt.getId();
    }
    
    @Override
    public String removeProductType(String id) throws Exception
    {
        ProductType pt = ptDao.getById(id);
        if (pt != null)
        {
            ptDao.removeById(id);
            return Constant.SUCCESS;
        }
        else
        {
            return Constant.FAIL;
        }
    }

	@Override
	public PageFinder<ProductType> getAllProductTypeByBid(String bid, Query query) {
		// TODO Auto-generated method stub
		CritMap critMap = new CritMap();
        critMap.addDesc("addtime");
        critMap.addEqual("bizid", bid);
        return ptDao.pagedByCritMap(critMap,
                query.getPage(),
                query.getPageSize());
	}

	@Override
	public List<ProductType> getAllbyuid(String bizid) {
		CritMap mp = new CritMap();
        mp.addEqual("bizid", bizid);
        return ptDao.findByCritMap(mp);
	}

	@Override
	public PageFinder<ProductType> getProductTypeBytay(String istay,String bizid,Query query) {
		CritMap critMap = new CritMap();
		critMap.addEqual("istay",istay);
		critMap.addEqual("bizid",bizid);
        critMap.addDesc("addtime");
        
        return ptDao.pagedByCritMap(critMap,
                query.getPage(),
                query.getPageSize());
	}

	@Override
	public List<ProductType> getPTypelisBytay(String istay,String bizid) {
		CritMap mp = new CritMap();
        mp.addEqual("istay", istay);
        mp.addEqual("bizid", bizid);
        return ptDao.findByCritMap(mp);
	}
    
}
