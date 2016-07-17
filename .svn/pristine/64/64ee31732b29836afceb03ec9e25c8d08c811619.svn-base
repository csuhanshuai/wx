package com.qixin.app.turntable.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.lanterngame.dao.IUserMedalDao;
import com.qixin.app.lanterngame.dao.IjferUserDao;
import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.app.lanterngame.model.EmpInfo;
import com.qixin.app.lanterngame.model.IjferUser;
import com.qixin.app.lanterngame.model.UserMedal;
import com.qixin.app.system.config.model.SystemConfig;
import com.qixin.app.turntable.dao.ActivityInfoDao;
import com.qixin.app.turntable.dao.AwardDao;
import com.qixin.app.turntable.dao.CustomerDao;
import com.qixin.app.turntable.dao.LotteryRecordDao;
import com.qixin.app.turntable.dao.WinnersDao;
import com.qixin.app.turntable.model.ActivityInfo;
import com.qixin.app.turntable.model.Award;
import com.qixin.app.turntable.model.Customer;
import com.qixin.app.turntable.model.LotteryRecord;
import com.qixin.app.turntable.model.Winners;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.GiftDao;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.app.turntable.bean.AwardBean;
@Service
public class TurntableService
{
    @Resource
    private AwardDao awardDao;

    @Resource
    private WinnersDao winnersDao;

    @Resource
    private CustomerDao customerDao;

    @Resource
    private ActivityInfoDao activityInfoDao;
    
    @Resource
    private LotteryRecordDao lotteryRecordDao;
    

    @Resource
    private IntegralexchangerecordService integralexchangerecordservice;

    @Resource
    private MemberService memberservice; 

    
    @Resource
    private GiftService giftservice;
    
    @Resource
	private IjferUserDao ijferUserDao;
    
    @Resource
	private IUserMedalDao iUserMedalDao;
 
    
    public IUserMedalDao getiUserMedalDao() {
		return iUserMedalDao;
	}

	public void setiUserMedalDao(IUserMedalDao iUserMedalDao) {
		this.iUserMedalDao = iUserMedalDao;
	}

	public Gift getGiftNameById(String giftId) throws Exception{
    	Gift gift=giftservice.getGiftByid(giftId);
    	return gift;
    }
    
    /*
     * 获取按照Map<String,AwardBean>其中key：获奖name，value：AwardBean
     */
    public Map<String,AwardBean> getAwardBean() throws Exception{
    	 Map<String, AwardBean> tempMap = new HashMap<String, AwardBean>();
    	 AwardBean awardbean1=new AwardBean();
         AwardBean awardbean2=new AwardBean();
         AwardBean awardbean3=new AwardBean();
         AwardBean awardbean4=new AwardBean();
         List<Award> aList = getAward();  //查找大转盘所有的得奖记录
         for (Award award : aList) {
 			if(award.getIsPrize()==0){
 				continue;
 			}
 			Gift gift = null;
 			if (null != award.getGiftid()){
 				gift = getGiftNameById(award.getGiftid());
 			}
 			if("一等奖".equals(award.getName())){
 				awardbean1.setGiftid(award.getGiftid());
 				if (null != gift){
 					awardbean1.setGiftName(gift.getName());
 				}else{
 					awardbean1.setGiftName("");
 				}
 				awardbean1.setId(award.getId());
 				awardbean1.setIsPrize(award.getIsPrize());
 				awardbean1.setName(award.getName()+" (iPad mini4)");
 				awardbean1.setNum(award.getNum()+1);
 				awardbean1.setPrompt(award.getPrompt());
 				tempMap.put("1", awardbean1);
 			}else if("二等奖".equals(award.getName())){
 				awardbean2.setGiftid(award.getGiftid());
 				if (null != gift){
 					awardbean2.setGiftName(gift.getName());
 				}else{
 					awardbean2.setGiftName("");
 				}
 				awardbean2.setId(award.getId());
 				awardbean2.setIsPrize(award.getIsPrize());
 				awardbean2.setName(award.getName()+" (山地自行车)");
 				awardbean2.setNum(award.getNum());
 				awardbean2.setPrompt(award.getPrompt());
 				tempMap.put("2", awardbean2);

 			}else if("三等奖".equals(award.getName())){
 				awardbean3.setGiftid(award.getGiftid());
 				if (null != gift){
 					awardbean3.setGiftName(gift.getName());
 				}else{
 					awardbean3.setGiftName("");
 				}
 				awardbean3.setId(award.getId());
 				awardbean3.setIsPrize(award.getIsPrize());
 				awardbean3.setName(award.getName()+" (小米手环)");
 				awardbean3.setNum(award.getNum());
 				awardbean3.setPrompt(award.getPrompt());
 				tempMap.put("3", awardbean3);
 			}else if("四等奖".equals(award.getName())){
 				awardbean4.setGiftid(award.getGiftid());
 				if (null != gift){
 					awardbean4.setGiftName(gift.getName());
 				}
 				else{
 					awardbean4.setGiftName("");
 				}
 				awardbean4.setId(award.getId());
 				awardbean4.setIsPrize(award.getIsPrize());
 				awardbean4.setName(award.getName()+" (神秘礼物)");
 				awardbean4.setNum(award.getNum());
 				awardbean4.setPrompt(award.getPrompt());
 				tempMap.put("4", awardbean4);
 			}
 		}
        return tempMap;
    }
    
    /**
     * 抽奖方法
     * @param empInfo 登陆用户信息
     * @param at 活动信息
     * @param a 奖项
     * @param badgeCount 约章数
     * @param ijferUser 解放号用户
     * @return 抽奖记录
     * @throws Exception 数据库操作异常
     */
    public LotteryRecord updateLotteryRecord(EmpInfo empInfo,Activities at,Award a,int badgeCount, IjferUser ijferUser) throws Exception{
    	LotteryRecord lr = new LotteryRecord();
		lr.setJobNumber(empInfo.getJobNumber());
		lr.setEmpName(empInfo.getEmpName());
		lr.setUserBadgeCount(badgeCount);
		lr.setIsGet(0);
		lr.setGotAwardTime(new Date());
		lr.setAward(a.getName());
		lr.setActivitiesid(at.getId());
		lr.setIsPrize(a.getIsPrize());	
		lotteryRecordDao.save(lr);
		// 维护解放表和约章表的约章数
		if (ijferUser != null) {
			ijferUser.setBadgeCount(ijferUser.getBadgeCount() - badgeCount);
			ijferUser=this.getIjferUserDao().merge(ijferUser);
		}
		
		UserMedal userMedal=new UserMedal();
		userMedal.setBadgeCount(-badgeCount);
		userMedal.setType(0);
		userMedal.setJobNumber(empInfo.getJobNumber());
		userMedal.setEmpName(empInfo.getEmpName());
		userMedal.setCreatedDate(new Date());
		userMedal.setUpdateDate(new Date());
		
		this.iUserMedalDao.save(userMedal);
		
		a.setNum(a.getNum() - 1);
		awardDao.save(a);
		
		return lr;
    }
   
   //get lorryReord List
    public List<LotteryRecord> getLotteryList(){
	   CritMap critMap = new CritMap();
       critMap.addEqual("isPrize", 1);
       return this.lotteryRecordDao.findByCritMap(critMap);
   }
    
    
    public List<Award> getAward()
    {
        return awardDao.getAll();
    }

    public Award getAwardByid(int id)
    {

        return awardDao.getById(id);
    }

    public void updateAward(List<Award> list)
    {

        for (Award a : list)
        {

            try
            {
                awardDao.save(a);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void updateAward(Award a)
    {

        try
        {
            awardDao.save(a);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public Customer getQualifications(String openid, String activitiesid)
    {

        List<Customer> list = customerDao.find(
                "from Customer where openid=? and status=0 and activitiesid=?",
                openid, activitiesid);
        if (list != null && list.size() >= 1)
        {

            Customer c = list.get(0);
            c.setStatus(1);
            try
            {
                // customerDao.save(c);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return c;
        }
        else
        {

            return null;
        }
    }

    public void addWinners(Winners winners)
    {

        try
        {
            winnersDao.save(winners);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateWinners(String[] ids)
    {

        Winners winners = null;

        try
        {
            for (String id : ids)
            {

                winners = winnersDao.getById(Integer.parseInt(id));
                winners.setTicket(1);
                winnersDao.save(winners);

                // 还需要更新 奖品兑换表的信息
                Member member = this.memberservice.getMemberByOpenid(winners
                        .getOpenid());
                Integralexchangerecord record = this.integralexchangerecordservice
                        .getIntegralexchangerecordBytype(member.getId(),
                                winners.getActivitiesid(), "1");
                if (record != null)
                {
                    record.setIsuse("1");
                    record.setUsertime(CommonTool
                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                    this.integralexchangerecordservice
                            .updateIntegralexchangerecord(record);
                }
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public PageFinder<Winners> getWinnersList(Winners winners, Query query) {
		CritMap critMap = new CritMap();
		if (winners.getCompany() != null && winners.getCompany() != "")
			critMap.addLike("company", winners.getCompany());
		if (winners.getTel() != null && winners.getTel() != "")
			critMap.addLike("tel", winners.getTel());
		if (winners.getName() != null && winners.getName() != "")
			critMap.addLike("name", winners.getName());
		if (winners.getTicket() != 3)
			critMap.addEqual("ticket", winners.getTicket());
		critMap.addEqual("activitiesid", winners.getActivitiesid());
		return winnersDao.pagedByCritMap(critMap, query.getPage(), query
				.getPageSize());
	}

    public Winners getWinners(String openid, String activitiesid) {
		CritMap critMap = new CritMap();
		critMap.addLike("openid", openid);
		critMap.addEqual("ticket", 0);
		critMap.addEqual("activitiesid", activitiesid);
		return winnersDao.getObjectByCritMap(critMap);
	}

    public List<Winners> getWinnersList() {
		return winnersDao.getAll();
	}

    public void addCustomer(Customer c) {
		try {
			customerDao.save(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public ActivityInfo getActivityInfo() {
		List<ActivityInfo> infoList = activityInfoDao.getAll();
		if (infoList != null && infoList.size() >= 1) {
			return infoList.get(0);
		}
		return null;
	}

    public void updateActivityInfo(String str, String prompt) {
		try {
			ActivityInfo info = new ActivityInfo();
			info.setId(1);
			info.setInfo(str);
			info.setPrompt(prompt);
			activityInfoDao.save(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
    public PageFinder<LotteryRecord> getLotteryRecordList(
			LotteryRecord lotteryRecord, Query query) {
		CritMap critMap = new CritMap();
		critMap.addEqual("activitiesid", lotteryRecord.getActivitiesid());
		if (lotteryRecord.getEmpName() != null
				&& lotteryRecord.getEmpName() != "") {
			critMap.addLike("empName", lotteryRecord.getEmpName());
		}
		if (lotteryRecord.getJobNumber() != null
				&& lotteryRecord.getJobNumber() != "") {
			critMap.addEqual("jobNumber", lotteryRecord.getJobNumber());
		}
		if (lotteryRecord.getAward() != null && !lotteryRecord.getAward().equals("-1")) {
			critMap.addEqual("award", lotteryRecord.getAward());
		}
		if (lotteryRecord.getIsGet() != null &&lotteryRecord.getIsGet() != -1) {
			critMap.addEqual("isGet", lotteryRecord.getIsGet());
		}
		
		return lotteryRecordDao.pagedByCritMap(critMap, query.getPage(), query
				.getPageSize());
	}
    
    
    public List<LotteryRecord> getLotteryRecordListByjobNumber(String jobNumber){
    	CritMap critMap = new CritMap();
    	critMap.addEqual("jobNumber",jobNumber);
    	return lotteryRecordDao.findByCritMap(critMap, true);
    }
   
    
    
    
    public void addLotteryRecord(LotteryRecord lotteryRecord) {
		try {
			lotteryRecordDao.save(lotteryRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
    
    public LotteryRecord  updateLotteryRecord(LotteryRecord lotteryRecord) {
			return lotteryRecordDao.merge(lotteryRecord);
	}
    
	public LotteryRecord getLotteryRecordById(Serializable id) {
		return lotteryRecordDao.getById(id);
	}

	public IjferUserDao getIjferUserDao() {
		return ijferUserDao;
	}

	public void setIjferUserDao(IjferUserDao ijferUserDao) {
		this.ijferUserDao = ijferUserDao;
	}
    

}
