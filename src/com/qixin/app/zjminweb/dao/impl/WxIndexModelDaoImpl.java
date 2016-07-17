package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.IWxIndexModelDao;
import com.qixin.app.zjminweb.model.IndexModel;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class WxIndexModelDaoImpl extends HibernateEntityDao<IndexModel> implements
        IWxIndexModelDao
{
}