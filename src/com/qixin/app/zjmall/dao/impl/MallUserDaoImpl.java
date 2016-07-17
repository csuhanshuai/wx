package com.qixin.app.zjmall.dao.impl;

import org.springframework.stereotype.Repository;

import com.qixin.app.zjmall.dao.MallUserDao;
import com.qixin.app.zjmall.model.MallUser;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

/**  
 * 
 */
@Repository
public class MallUserDaoImpl extends HibernateEntityDao<MallUser> implements MallUserDao
{


}
