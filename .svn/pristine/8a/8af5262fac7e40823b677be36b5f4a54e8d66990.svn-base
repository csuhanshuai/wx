package com.qixin.app.lanterngame.dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.qixin.app.lanterngame.dao.IQuizGameRecordDao;
import com.qixin.app.lanterngame.model.EmpScore;
import com.qixin.app.lanterngame.model.QuizGameRecord;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;
@Repository
public class QuizGameRecordDaoImpl extends HibernateEntityDao<QuizGameRecord> implements IQuizGameRecordDao {
	
	public Integer queryGameScore(String recordId) throws SQLException
	{
		String hql = "select sum(r.score) from QuizTopicReply r where r.gameRecordId=?";
		Assert.hasText(hql);
		List list = getHibernateTemplate().find(hql,
				new String[] { recordId });
		
		Integer score = 0;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				score = ((Long)list.get(i)).intValue();
			}
		}
		return score;
		
//		Session session = this.getSession();
//		String sql = "select sum(score) from quiz_topic_reply where game_record_id='"
//		        + recordId + "'";
//		return (Integer)session.createSQLQuery(sql).uniqueResult();
		
		/*SessionFactoryImplementor  s = (SessionFactoryImplementor)sessionFactory;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		List<EmpScore> empScores = new ArrayList<EmpScore>();
		 int totalscore = 0;
		try {
			 conn =	s.getConnectionProvider().getConnection();
			 prep = conn.prepareStatement("select sum(score),game_record_id from quiz_topic_reply where game_record_id='"
			        + recordId + "' group by game_record_id ");
			 rst = prep.executeQuery();
			 while(rst.next()){
				// EmpScore e = new EmpScore();
				  totalscore = rst.getInt(1);
				
				 //empScores.add(e);
			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			rst.close();
			prep.close();
			conn.close();
		}
		return totalscore;*/
	}

	
	

}
