package com.qixin.app.vote.dao;

import java.sql.SQLException;
import java.util.List;

import com.qixin.app.vote.model.WxVote;
import com.qixin.platform.persistent.database.IHibernateEntityDao;

public interface WxVoteDao extends IHibernateEntityDao<WxVote>{
	public List<WxVote> getWxVoteByVoteId(String voteId) throws SQLException;
}
