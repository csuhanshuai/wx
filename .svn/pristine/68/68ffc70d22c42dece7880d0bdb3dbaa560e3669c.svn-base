package com.qixin.app.jackgame.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.qixin.app.jackgame.dao.IJackGameScoreDao;
import com.qixin.app.jackgame.model.JackGameScore;
import com.qixin.app.lanterngame.model.EmpScore;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;
@Repository
public class JackGameScoreDaoImpl extends HibernateEntityDao<JackGameScore> implements IJackGameScoreDao {

	@Override
	public List<JackGameScore> queryJackGameScoreTop() throws SQLException {
		final String hql = "select ei.empName,ei.score,ei.updateDate,ei.id,ei.jobNumber from JackGameScore ei order by ei.score desc,ei.updateDate asc";
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
		List<JackGameScore> jackGameScores = new ArrayList<JackGameScore>();
		if (list != null && list.size() > 0) {
			JackGameScore jackGameScore=null;
			for (int i = 0; i < list.size(); i++) {
				Object[] object = (Object[]) list.get(i);
				jackGameScore = new JackGameScore();
				jackGameScore.setEmpName((String)object[0]);
				if (null != object[1]){
					jackGameScore.setScore((Integer)object[1]);
				}
				if (null != object[2]){
					jackGameScore.setUpdateDate((Date)object[2]);
				}
				jackGameScore.setId((String)object[3]);
				jackGameScore.setJobNumber((String)object[4]);;
				
				jackGameScores.add(jackGameScore);
			}
		}
		return jackGameScores;
	}

//	@Override
//	public List<JackGameScore> queryJackGameScoreTop() throws SQLException {
//		SessionFactory sessionFactory = getSessionFactory();
//		SessionFactoryImplementor  s = (SessionFactoryImplementor)sessionFactory;
//		Connection conn =null;
//		PreparedStatement prep = null;
//		ResultSet rst = null;
//		List<JackGameScore> jackGameScores = new ArrayList<JackGameScore>();
//		try {
//			 conn =	s.getConnectionProvider().getConnection();
//			 prep = conn.prepareStatement("select emp_name,score,update_date,id,job_number from jack_game_score ei    order by score desc,update_Date asc  limit 0,3");
//			 rst = prep.executeQuery();
//			 while(rst.next()){
//				 JackGameScore e = new JackGameScore();
//				 e.setEmpName(rst.getString(1));
//				 e.setScore(rst.getInt(2));
//				 e.setUpdateDate(rst.getDate(3));
//				 e.setId(rst.getString(4));
//				 e.setJobNumber(rst.getString(5));
//				 jackGameScores.add(e);
//			 }
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}finally{
//			rst.close();
//			prep.close();
//			conn.close();
//		}
//		return jackGameScores;
//		
//	}

	
	

}
