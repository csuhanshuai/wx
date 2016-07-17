package com.qixin.app.lanterngame.dao;

import java.sql.SQLException;

import com.qixin.app.lanterngame.model.QuizGameRecord;
import com.qixin.platform.persistent.database.IHibernateEntityDao;

public interface IQuizGameRecordDao extends IHibernateEntityDao<QuizGameRecord> {

	public Integer queryGameScore(String recordId) throws SQLException;
}
