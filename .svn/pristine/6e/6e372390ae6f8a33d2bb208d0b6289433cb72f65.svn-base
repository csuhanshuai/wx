package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.IWxPictureTextDao;
import com.qixin.app.zjminweb.model.PictureText;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class WxPictureTextDaoImpl extends HibernateEntityDao<PictureText>
        implements IWxPictureTextDao
{

    @Override
    public void removeAllByBid(String paramString)
    {

        try
        {
            this.createQuery("delete PictureText where bizid = ?", paramString)
                    .executeUpdate();
        }
        catch (Exception e)
        {
            CommonLogger.error(e);
        }

    }
}