package com.qixin.app.lanterngame.service;



import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qixin.app.lanterngame.model.ActInfo;
import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.app.lanterngame.model.EmpInfo;
import com.qixin.app.lanterngame.model.EmpScore;
import com.qixin.app.lanterngame.model.IjferUser;
import com.qixin.app.lanterngame.model.QuizGameRecord;
import com.qixin.app.lanterngame.model.QuizTopic;
import com.qixin.app.lanterngame.model.QuizTopicReply;
import com.qixin.app.lanterngame.model.UserMedal;
import com.qixin.app.vote.model.Vote;
import com.qixin.app.vote.model.VoteApply;
import com.qixin.app.vote.model.WxVote;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;


public abstract interface LanternGameService {
	public abstract String addAttachInfo(AttachInfo attachInfo) throws Exception;

	public abstract String deleteAttachInfoById(String id) throws Exception;
	public abstract AttachInfo findAttachInfoByPara(String desc,String suffix) ;
	public abstract AttachInfo updateAttachInfo(AttachInfo attachInfo) ; 
	public abstract List<AttachInfo> getAllAttachInfo();
	public abstract ActInfo getActInfoById(String id) throws Exception;
	public abstract ActInfo updateActInfo(ActInfo actInfo) throws Exception;
	public abstract String addQuizTopic(QuizTopic quizTopic) throws Exception;
	public abstract QuizTopic getQuizTopicById(String id) ;
	public abstract List<QuizTopic> getAllQuizTopic();
	public abstract String saveAnswerRecord(QuizGameRecord quizGameRecord) throws Exception;
	public abstract QuizGameRecord updateAnswerRecord(QuizGameRecord quizGameRecord);
	public abstract String saveAnswerRecordQuestion(QuizTopicReply quizTopicReply) throws Exception;
	public abstract QuizTopicReply updateAnswerRecordQuestion(QuizTopicReply quizTopicReply) ;
	public abstract String saveEmpScore(EmpScore empScore) throws Exception;
	public abstract EmpScore updateEmpScore(EmpScore empScore); 
	public abstract EmpInfo checkIsEmp(String empNum,String empName);
	public abstract EmpScore getEmpScoreByPara(String empNum,String empName);
	public abstract int checkIsCanGame(String empNum);
	public abstract EmpScore getEmpScoreByJobNum(String jobNum);
	public abstract List<EmpScore> queryEmpScoreTop() throws SQLException;
	public abstract List<EmpScore> queryEmpScoreTop2(String jobNumber) throws SQLException;
	public abstract List<QuizTopic> queryQuizTopicByPage(int pageSize,int page);
	public abstract QuizTopic updateQuizTopic(QuizTopic quiz);
	public Serializable deleteQuizTopicById(Serializable itemId) throws Exception;
	public abstract QuizTopic getTopic(String topicId);
	public abstract int getTotalScore(String recordId);
	
	public abstract  QuizGameRecord queryQuizGameRecordById(String id);

	public abstract String saveActInfo(ActInfo actInfo) throws Exception;
	public abstract PageFinder<ActInfo> findActInfoByPageFinder(Query query);
	public abstract AttachInfo getAttachInfoById(String id);
	public abstract boolean removActInfo(String id) throws Exception;
	public List<QuizTopicReply> getQuizTopicReplyByRecordId(String gameRecordId);
	public EmpInfo updateEmpInfo(EmpInfo empInfo);
	public IjferUser checkIsEmpIjferUser(String empNum,String empName);
	public Integer saveIjferUser(IjferUser ijferUser) throws Exception;
	public IjferUser updateIjferUser(IjferUser ijferUser);
	public PageFinder<QuizTopic> findQuizTopicByPageFinder(Query query);

	public PageFinder<QuizGameRecord> getQuizGameRecordList(Map<String, Object> conditionMap, Query query);
	
	public String addUserMedal(UserMedal userMedal) throws Exception;
	public UserMedal getUserMedal(String empNum,String empName) throws Exception;
	public UserMedal updateUserMedal(UserMedal userMedal);
	
	public IjferUser getEmpIjferUserByWorkNo(String wokeNo);

    
	
    public abstract int isExistReply(String recordId, String jobNum,String topicId) throws Exception;
    
    public int handleNotAnswer(String recordId);
    
    public QuizTopicReply getTopicReplyById(String id);
}
