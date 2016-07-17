package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.RetailstoreDao;
import com.qixin.app.zjminweb.model.Retailstore;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class RetailstoreDaoImpl extends HibernateEntityDao<Retailstore> implements RetailstoreDao
{

}
