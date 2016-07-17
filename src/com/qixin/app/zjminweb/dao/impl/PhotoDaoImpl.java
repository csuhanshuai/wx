package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.PhotoDao;
import com.qixin.app.zjminweb.model.Photo;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class PhotoDaoImpl extends HibernateEntityDao<Photo> implements PhotoDao
{

}
