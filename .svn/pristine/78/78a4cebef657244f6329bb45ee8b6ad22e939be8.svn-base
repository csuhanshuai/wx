package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.IWxScrollPictureDao;
import com.qixin.app.zjminweb.model.ScrollPicture;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class WxScrollPictureDaoImpl extends HibernateEntityDao<ScrollPicture>
        implements IWxScrollPictureDao
{

    @Override
    public void removeByBizid(String bizid)
    {
        this.createQuery("delete ScrollPicture where bizid = ?", bizid).executeUpdate();
    }

}