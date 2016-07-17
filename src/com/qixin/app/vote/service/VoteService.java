package com.qixin.app.vote.service;



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


public abstract interface VoteService {
	
	//VoteApply
	public abstract String saveVoteApply(VoteApply voteApply) throws Exception; 
	public abstract VoteApply updateVoteApply(VoteApply voteApply);
	public Serializable deleteVoteApplyById(Serializable itemId) throws Exception;
	public VoteApply getVoteApplyByID(Serializable voteApplyId);
	public List<VoteApply> getVoteApplyList();
	
	public PageFinder<VoteApply> findVoteApplyByPageFinder(Query query);
	public PageFinder<VoteApply> getVoteApplyByCode(String inputContent,Query query) throws Throwable;
	
	public VoteApply getVoteApplyByCode(String code);
	
	
	//WxVote
    public abstract WxVote getWxvoteByid(String id) throws Exception;//id查
	public abstract List<WxVote> getWxVoteByVoteId(String voteId) throws Exception;
	public abstract List<WxVote> getWxVote() throws Exception;//查
	public abstract String addWxVote(WxVote wxVote) throws Exception;//增
    public abstract String removeWxVote(String id) throws Exception;//删
    public abstract WxVote updateWxVote(WxVote wxVote) throws Exception;//改
    public List<WxVote> getWxvoteByOpenId(String openId) throws Exception;//改
    
    
    
	
	//vote
    public abstract Vote getVote() throws Exception;
    public abstract String addVote(Vote paramSecret) throws Exception;
    public abstract PageFinder<Vote> getVoteByBid(Query query, String bid)throws Exception;
    public abstract List<Vote> getVoteByBid(String bid) throws Exception;
    public abstract Vote getVoteByid(String id) throws Exception;
    public abstract boolean removeVote(String id) throws Exception;
    public abstract String updateVote(Vote Vote) throws Exception;
    
    public abstract List<VoteApply> getVoteApplyPass() throws Exception;
    public VoteApply getVoteApplyByName(String name) throws Throwable;
    public List<WxVote> getWxVoteByJobNum(String empNumber) throws Exception;
    
    public PageFinder<WxVote> findWxVoteByPageFinder(String id,Query query);
    
}
