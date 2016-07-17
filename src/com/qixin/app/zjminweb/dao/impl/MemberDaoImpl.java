package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.MemberDao;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class MemberDaoImpl extends HibernateEntityDao<Member> implements
        MemberDao
{

}
