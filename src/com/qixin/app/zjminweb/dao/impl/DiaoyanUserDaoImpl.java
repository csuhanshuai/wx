package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.DiaoyanUserDao;
import com.qixin.app.zjminweb.model.DiaoyanUser;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class DiaoyanUserDaoImpl extends HibernateEntityDao<DiaoyanUser> implements DiaoyanUserDao{

}
