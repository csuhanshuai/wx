package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.BaomingDao;
import com.qixin.app.zjminweb.model.Baoming;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class BaomingDaoImpl extends HibernateEntityDao<Baoming> implements BaomingDao {

}
