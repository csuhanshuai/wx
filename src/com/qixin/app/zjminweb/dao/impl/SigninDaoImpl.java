package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.SigninDao;
import com.qixin.app.zjminweb.model.Signin;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class SigninDaoImpl extends HibernateEntityDao<Signin> implements
        SigninDao
{

}
