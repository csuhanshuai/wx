package com.qixin.app.vote.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.stereotype.Repository;

import com.qixin.app.lanterngame.model.EmpScore;
import com.qixin.app.vote.dao.WxVoteDao;
import com.qixin.app.vote.model.WxVote;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;

@Repository
public class WeixinVoteDaoImpl extends HibernateEntityDao<WxVote> implements  WxVoteDao{
	
	/**
	 * 根据报名表vote_apply表的voteId字段查询wx_vote表的数据
	 * 多条数据，集合
	 */
	@Override
	public List<WxVote> getWxVoteByVoteId(String voteId)  throws SQLException{
		SessionFactory sessionFactory = getSessionFactory();
		SessionFactoryImplementor  s = (SessionFactoryImplementor)sessionFactory;
		Connection conn =null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		List<WxVote> wxVotes = new ArrayList<WxVote>();
		try {
			 conn =	s.getConnectionProvider().getConnection();
//			 prep = conn.prepareStatement("select emp_name,score,update_date,id,job_number from emp_score ei    order by score desc,update_Date asc  limit 0,3");
			 prep = conn.prepareStatement("select id,vote_id,open_id,emp_number,vote_time,creater,create_date,updater,update_date from wx_vote where vote_id=? limit 1,3");
			 prep.setString(1, voteId);
			 rst = prep.executeQuery();
			 while(rst.next()){
				 WxVote wxVote = new WxVote();
				 wxVote.setId(rst.getString(1));
				 wxVote.setVoteId(rst.getString(2));
				 wxVote.setOpenId(rst.getString(3));
				 wxVote.setEmpNumber(rst.getString(4));
				 wxVote.setVoteTime(rst.getDate(5));
				 wxVote.setCreater(rst.getString(6));
				 wxVote.setCreateDate(rst.getString(7));
				 wxVote.setUpdater(rst.getString(8));
				 wxVote.setUpdaterTime(rst.getString(9));
				 wxVotes.add(wxVote);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rst.close();
			prep.close();
			conn.close();
		}
		return wxVotes;
	}
	
}