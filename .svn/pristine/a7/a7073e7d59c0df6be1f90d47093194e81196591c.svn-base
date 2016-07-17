package com.qixin.app.jackgame.service;

import java.sql.SQLException;
import java.util.List;

import com.qixin.app.jackgame.model.JackGameRecord;
import com.qixin.app.jackgame.model.JackGameScore;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public interface IJackGameService {
	public JackGameScore getJackGameScoreByPara(String jobNumber,String empName);
	public int checkCanplay(String jobNumber,String empName);
	public String saveJackGameScore(JackGameScore jackGameScore) throws Exception;
	public String saveJackGameRecord(JackGameRecord jackGameRecord) throws Exception;
	public JackGameScore updateJackGameScore(JackGameScore jackGameScore);
	public JackGameRecord updateJackGameRecord(JackGameRecord jackGameRecord);
	public List<JackGameScore> getTopThreejackGameScores() throws SQLException;
	public JackGameRecord getJackGameRecordByPara(String jobNumber,String empName);
	public JackGameRecord getJackGameRecordById(String id);
	public PageFinder<JackGameRecord> findJackGameRecordByPageFinder(Query query,JackGameRecord jackGameRecord);
}
