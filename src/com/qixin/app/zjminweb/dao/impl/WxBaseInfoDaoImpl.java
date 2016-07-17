package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.IWxBaseInfoDao;
import com.qixin.app.zjminweb.model.BaseInfo;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class WxBaseInfoDaoImpl extends HibernateEntityDao<BaseInfo> implements
        IWxBaseInfoDao
{
}