package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.MemberlevelDao;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class MemberlevelDaoImpl extends HibernateEntityDao<Memberlevel>
        implements MemberlevelDao
{

}
