package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.SalespromotionDao;
import com.qixin.app.zjminweb.model.Salespromotion;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class SalespromotionDaoImpl extends HibernateEntityDao<Salespromotion>
        implements SalespromotionDao
{

}
