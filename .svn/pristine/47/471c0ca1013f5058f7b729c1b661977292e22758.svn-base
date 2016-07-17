package com.qixin.app.jackgame.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.jackgame.dao.IJackGameRecordDao;
import com.qixin.app.jackgame.dao.IJackGameScoreDao;
import com.qixin.app.jackgame.model.JackGameRecord;
import com.qixin.app.jackgame.model.JackGameScore;
import com.qixin.app.jackgame.service.IJackGameService;
import com.qixin.app.lanterngame.util.Utils;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
@Service()
public class JackGameServiceImpl implements IJackGameService{
	@Resource
	private IJackGameScoreDao jackGameScoreDao;
	@Resource
	private IJackGameRecordDao jackGameRecordDao;
	@Override
	public JackGameScore getJackGameScoreByPara(String jobNumber,
			String empName) {
		jobNumber = Utils.addZeroForJobNumbe(jobNumber);
		CritMap critMap = new CritMap();
		critMap.addEqual("jobNumber", jobNumber);
		critMap.addEqual("empName", empName);
		return jackGameScoreDao.getObjectByCritMap(critMap, true);
	}
	@Override
	public int checkCanplay(String jobNumber, String empName) {
		jobNumber=Utils.addZeroForJobNumbe(jobNumber);
		CritMap critMap = new CritMap();
		critMap.addEqual("jobNumber", jobNumber);
		critMap.addEqual("empName", empName);
		JackGameScore jackGameScore = jackGameScoreDao.getObjectByCritMap(critMap, true);
		if(jackGameScore==null){
			return 1;
		}else {
			if(jackGameScore.getPlayCount()<jackGameScore.getCanPlayCount()){
				return 2;
			}else {
				return 3;
			}
			
		}
		
	}
	@Override
	public String saveJackGameScore(JackGameScore jackGameScore) throws Exception {
		
		return (String) jackGameScoreDao.save(jackGameScore);
	}
	@Override
	public String saveJackGameRecord(JackGameRecord jackGameRecord)
			throws Exception {
		
		return (String) jackGameRecordDao.save(jackGameRecord);
	}
	@Override
	public JackGameScore updateJackGameScore(JackGameScore jackGameScore) {
		
		return jackGameScoreDao.merge(jackGameScore);
	}
	@Override
	public JackGameRecord updateJackGameRecord(JackGameRecord jackGameRecord) {
		
		return jackGameRecordDao.merge(jackGameRecord);
	}
	@Override
	public List<JackGameScore> getTopThreejackGameScores() throws SQLException {
		
		return jackGameScoreDao.queryJackGameScoreTop();
	}
	@Override
	public JackGameRecord getJackGameRecordByPara(String jobNumber,
			String empName) {
		jobNumber=Utils.addZeroForJobNumbe(jobNumber);
		CritMap critMap = new CritMap();
		critMap.addEqual("jobNumber", jobNumber);
		critMap.addEqual("empName", empName);
		return jackGameRecordDao.getObjectByCritMap(critMap, true);
	}
	@Override
	public JackGameRecord getJackGameRecordById(String id) {
		
		return jackGameRecordDao.getById(id);
	}
	@Override
	public PageFinder<JackGameRecord> findJackGameRecordByPageFinder(Query query,JackGameRecord jackGameRecord) {
		CritMap critMap = new CritMap();
		critMap.addLike("jobNumber", jackGameRecord.getJobNumber());
		critMap.addLike("empName", jackGameRecord.getEmpName());
		
		critMap.addAsc("jobNumber");
		return jackGameRecordDao.pagedByCritMap(critMap, query.getPage(), query.getPageSize());
	}

}
