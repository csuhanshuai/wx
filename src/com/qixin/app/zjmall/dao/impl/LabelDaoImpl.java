package com.qixin.app.zjmall.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjmall.dao.ILabelDao;
import com.qixin.app.zjmall.model.Label;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;
@Repository
public class LabelDaoImpl extends HibernateEntityDao<Label> implements ILabelDao {

}
