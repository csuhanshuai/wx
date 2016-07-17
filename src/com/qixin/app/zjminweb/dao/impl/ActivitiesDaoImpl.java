package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.ActivitiesDao;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class ActivitiesDaoImpl extends HibernateEntityDao<Activities> implements
        ActivitiesDao
{

}
