package com.qixin.app.lanterngame.dao.impl;



import org.springframework.stereotype.Repository;

import com.qixin.app.lanterngame.dao.IAttachInfoDao;
import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class AttachInfoDaoImpl extends HibernateEntityDao<AttachInfo> implements IAttachInfoDao {


}
