package com.qixin.app.zjmall.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjmall.dao.IProductTypeDao;
import com.qixin.app.zjmall.model.ProductType;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class ProductTypeDaoImpl extends HibernateEntityDao<ProductType> implements IProductTypeDao
{
    
}
