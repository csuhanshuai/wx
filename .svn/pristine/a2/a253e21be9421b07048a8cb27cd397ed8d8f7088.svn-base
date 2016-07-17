package com.qixin.app.flexWechatMain.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.flexWechatMain.dao.WeChatWallDao;
import com.qixin.app.flexWechatMain.model.WeChatWall;
import com.qixin.app.flexWechatMain.service.WeChatWallService;
import com.qixin.app.zjminweb.dao.MemberDao;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class WeChatWallServiceImpl implements WeChatWallService {

	@Resource
	private WeChatWallDao wlDao;
	@Resource
	private MemberDao mDao;
	@Override
	public String addWeChatWall(WeChatWall weChatWall) throws Exception {
		// TODO Auto-generated method stub
		return (String) wlDao.save(weChatWall);
	}

	@Override
	public WeChatWall getWeChatWall(String id) {
		// TODO Auto-generated method stub
		return wlDao.getById(id);
	}

	@Override
	public PageFinder<WeChatWall> getAll(String gamenumber, Query query)
			throws Exception {
		CritMap mp = new CritMap();
		mp.addAsc("updatetime");
		mp.addEqual("gamenumber", gamenumber);
		return wlDao.pagedByCritMap(mp, query.getPage(), query.getPageSize());
	}
	
	public List<WeChatWall> getAll(String gamenumber)
	{
		CritMap mp = new CritMap();
		mp.addAsc("updatetime");
		mp.addEqual("gamenumber", gamenumber);
		return this.wlDao.findByCritMap(mp, new boolean[]{true});
	}

	@Override
	public Member getwiner(String gamenumber, Query query) throws Exception {
		// 清除中奖记录
		CritMap critMap = new CritMap();
		critMap.addEqual("gamenumber", gamenumber);
		critMap.addEqual("isreg", "1");
		List<WeChatWall> eList = wlDao.findByCritMap(critMap, true);

		WeChatWall ww = null;

		if (eList.size() > 0) {
			Random random = new Random();
			int pick = random.nextInt(eList.size());
			ww = eList.get(pick);
			ww.setIsreg("9");
			try {
				wlDao.save(ww);
				CritMap cm = new CritMap();
				cm.addEqual("openid", ww.getOpenid());
				Member member= mDao.getObjectByCritMap(cm, true);
				if(null==member)
				{
					member=new Member();
					member.setName("未注册用户");
					member.setTelephone("13900000000");
					member.setSex("1");
					
				}
				
				 return member;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return null;
		

	}

}
