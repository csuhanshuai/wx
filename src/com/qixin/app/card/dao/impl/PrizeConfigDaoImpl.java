package com.qixin.app.card.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.card.dao.PrizeConfigDao;
import com.qixin.app.card.model.PrizeConfig;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class PrizeConfigDaoImpl extends HibernateEntityDao<PrizeConfig>
        implements PrizeConfigDao
{

}
