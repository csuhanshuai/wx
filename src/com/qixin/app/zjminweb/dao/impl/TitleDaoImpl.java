package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.TitleDao;
import com.qixin.app.zjminweb.model.TitleInfo;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class TitleDaoImpl extends HibernateEntityDao<TitleInfo> 
        implements TitleDao {
}
