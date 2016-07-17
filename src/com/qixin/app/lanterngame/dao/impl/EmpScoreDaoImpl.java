package com.qixin.app.lanterngame.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.qixin.app.lanterngame.dao.IEmpScoreDao;
import com.qixin.app.lanterngame.model.EmpScore;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;
@Repository
public class EmpScoreDaoImpl extends HibernateEntityDao<EmpScore> implements IEmpScoreDao {
	@Override
	public List<EmpScore> queryEmpScoreTop() throws SQLException {
		final String hql = "select ei.empName,ei.score,ei.updateDate,ei.id,ei.jobNumber from EmpScore ei order by ei.score desc,ei.updateDate asc";
		Assert.hasText(hql);

		List list = getHibernateTemplate().executeFind(  
	              new HibernateCallback() {  
	                  public Object doInHibernate(Session arg0)  
	                         throws HibernateException, SQLException {  
	                     Query query = arg0.createQuery(hql);  
	                     query.setFirstResult(0);  
	                     query.setMaxResults(3);  
	                     return query.list();  
	  
	                  }  
	              });  
		
		List<EmpScore> empList = new ArrayList<EmpScore>();
		if (list != null && list.size() > 0) {
			EmpScore empScore=null;;
			for (int i = 0; i < list.size(); i++) {
				Object[] object = (Object[]) list.get(i);
				empScore = new EmpScore();
				empScore.setEmpName((String)object[0]);
				if (null != object[1]){
					empScore.setScore((Integer)object[1]);
				}
				if (null != object[2]){
					empScore.setUpdateDate((Date)object[2]);
				}
				empScore.setId((String)object[3]);
				empScore.setJobNumber((String)object[4]);;
				
				empList.add(empScore);
			}
		}
		return empList;
	}
}
