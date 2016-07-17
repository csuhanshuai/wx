package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.MembernoticeDao;
import com.qixin.app.zjminweb.model.Membernotice;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class MembernoticeDaoImpl extends HibernateEntityDao<Membernotice>
        implements MembernoticeDao
{

}
