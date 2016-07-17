package com.qixin.app.zjminweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjminweb.dao.CouponrecordDao;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class CouponrecordDaoImpl extends HibernateEntityDao<Couponrecord>
        implements CouponrecordDao
{

}
