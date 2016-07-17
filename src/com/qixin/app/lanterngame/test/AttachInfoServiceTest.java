package com.qixin.app.lanterngame.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.app.lanterngame.service.LanternGameService;
import com.qixin.app.vote.model.VoteApply;
import com.qixin.app.vote.service.VoteService;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public class AttachInfoServiceTest {
	
	@Test
	 public void addAttachInfoTest() throws Throwable{
		 BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
		 VoteService aImpl = (VoteService) factory.getBean("ss");
		 Query query = new Query();
		 query.setPage(1);
		 query.setPageSize(2);
		 PageFinder pageFinder = aImpl.getVoteApplyByCode("222", query);
		 List<VoteApply> list = pageFinder.getData();
		 for (VoteApply voteApply : list) {
			System.out.println(voteApply.getCode());
		}
		
	 }
}
