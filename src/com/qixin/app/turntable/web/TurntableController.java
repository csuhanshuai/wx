package com.qixin.app.turntable.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.Advanced.model.NameValue;
import com.qixin.app.lanterngame.dao.IUserMedalDao;
import com.qixin.app.lanterngame.model.EmpInfo;
import com.qixin.app.lanterngame.model.IjferUser;
import com.qixin.app.lanterngame.model.UserMedal;
import com.qixin.app.lanterngame.service.LanternGameService;
import com.qixin.app.system.config.model.SystemConfig;
import com.qixin.app.system.config.service.ISystemConfigService;
import com.qixin.app.turntable.bean.AwardBean;
import com.qixin.app.turntable.model.Award;
import com.qixin.app.turntable.model.Customer;
import com.qixin.app.turntable.model.LotteryRecord;
import com.qixin.app.turntable.model.Winners;
import com.qixin.app.turntable.service.TurntableService;
import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.wxbase.http.HttpRequestExecutor;

@Controller
@RequestMapping("/turentable")
public class TurntableController
{

    @Resource
    private TurntableService services;

    @Resource
    private IntegralexchangerecordService integralexchangerecordservice;

    @Resource
    private MemberService memberservice;
    
    
    @Resource
    private LanternGameService lantenGameService;
    
    @Resource
	private ISystemConfigService systemConfigService;
    
    @Resource
    private ActivitiesService activitiesService;
    
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    
    
    @RequestMapping(value = "/syncUser", method = RequestMethod.POST)
    public void syncUser(HttpServletResponse response,
            HttpServletRequest request)
    {

        BufferedReader in = null;
        StringBuffer jsonStr = null;
        PrintWriter out = null;
        try
        {
            in = request.getReader();
            out = response.getWriter();
            jsonStr = new StringBuffer();
            String str = "";
            while ((str = in.readLine()) != null)
            {
                jsonStr.append(str);
            }

            System.out.println(jsonStr.toString());

            JSONObject retJson = JSONObject.fromObject(jsonStr.toString());
            JSONObject jData = null;
            String key = retJson.getString("key");
            Customer c = null;
            if (key != null)
            {

                JSONArray jArray = retJson.getJSONArray("data");
                for (int i = 0; i < jArray.size(); i++)
                {

                    jData = jArray.getJSONObject(i);
                    c = new Customer();
                    c.setOpenid(jData.getString("openid"));
                    c.setCompany(jData.getString("company"));
                    c.setDepartment(jData.getString("department"));
                    c.setName(jData.getString("username"));
                    c.setTel(jData.getString("tel"));
                    c.setStatus(0);
                    services.addCustomer(c);
                    modifyPoint(c.getName(), c.getOpenid());
                }
            }

            out.print("{'status':'0'}");

        }
        catch (IOException e)
        {
            out.print("{'status':'1'}");
        }
        finally
        {

            out.flush();
            out.close();
            try
            {
                in.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void modifyPoint(String userName, String openId)
    {

        String url = "http://www.weijuju.com/mc";
        List<NameValuePair> params = null;
        JSONObject retJson = null;
        String result = null;

        try
        {

            params = new ArrayList<NameValuePair>();
            params.add(new NameValue("action", "modifyPoint"));
            params.add(new NameValue("openId", openId));
            params.add(new NameValue("wuid", "63403"));
            params.add(new NameValue("pointtType", "1"));
            params.add(new NameValue("point", "20"));

            result = HttpRequestExecutor.getInstance().sendHttpPostRequest(url,
                    params);

            if (StringUtils.isNotEmpty(result))
            {
                retJson = JSONObject.fromObject(result);
                String status = retJson.getString("status");

                System.out.println("Send Shipmsg Return Message [" + status
                        + "]");
            }
        }
        catch (Exception e)
        {

        }
        finally
        {
            params = null;
            result = null;
            retJson = null;
        }

    }

    /**
     * 去转盘页
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(method=RequestMethod.GET,value="/toTurentable")
    public ModelAndView toTurntable(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
    	
    	EmpInfo empInfo = (EmpInfo) request.getSession().getAttribute("empInfo");
    	
    	if (null != empInfo){
	    	IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(empInfo.getJobNumber(), empInfo.getEmpName());  //通过empInfo和empName查找对应的解放号
	    	SystemConfig scoreConfig = systemConfigService.getSystemConfigByKey("lottery_user_madul_count");
	  		int badgeCount=Integer.parseInt(scoreConfig.getValue());
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map.put("emp", empInfo);
	        map.put("chance",ijferUser.getBadgeCount()/badgeCount );//ijferUser.getBadgeCount()/badgeCount
	        map.put("badgeCount", ijferUser.getBadgeCount());
	        map.put("id", "");
	        List<AwardBean> aListNew=new ArrayList<AwardBean>(); 
	        aListNew.add((AwardBean)services.getAwardBean().get("1"));
	        aListNew.add((AwardBean)services.getAwardBean().get("2"));
	        aListNew.add((AwardBean)services.getAwardBean().get("3"));
	        aListNew.add((AwardBean)services.getAwardBean().get("4"));
	        map.put("aList", aListNew);
	        String newContent = services.getActivityInfo().getInfo()
	                .replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	        String prompt = services.getActivityInfo().getPrompt()
	                .replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	        map.put("info", newContent);
	        map.put("prompt", prompt);
	        map.put("lorryRecord", services.getLotteryList());
	        return new ModelAndView("/app/turentable/turentable", map);
    	}else{
    		 return new ModelAndView("redirect:/app/lanterngame/checkForward.kq?type=4", null);
    	}
    }

    
    
    
    @RequestMapping("/turn")
    public void turn(String id, HttpServletResponse response,
            String activitiesid) throws Exception
    {
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            List<Award> aList = services.getAward();
            Customer c = services.getQualifications(id, activitiesid);
            if (c != null)
            {
                int i = getAward(aList, id);
                Award a = aList.get(i - 1);
                if (a.getIsPrize() == 1)
                {

                    Winners w = new Winners();
                    w.setAward(a.getName());
                    w.setCompany(c.getCompany());
                    w.setDepartment(c.getDepartment());
                    w.setName(c.getName());
                    w.setTel(c.getTel());
                    w.setTicket(0);
                    w.setOpenid(c.getOpenid());
                    w.setActivitiesid(activitiesid);
                    services.addWinners(w);  
                    a.setNum(a.getNum() - 1);
                    services.updateAward(a);

                    // 插入记录到 兑换表
                    Member member = this.memberservice.getMemberByOpenid(id);

                    Integralexchangerecord integralexchangerecord = new Integralexchangerecord();
                    integralexchangerecord.setMemberid(member != null ? member
                            .getId() : null);
                    integralexchangerecord.setIntegralexchangeid("");
                    integralexchangerecord.setIsreceive("1");
                    integralexchangerecord.setReceivetime(CommonTool
                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                    integralexchangerecord.setIsuse("0");

                    integralexchangerecord.setBizid(member != null ? member
                            .getBizid() : null);
                    integralexchangerecord.setType("1");
                    integralexchangerecord.setActivitiesid(activitiesid);
                    integralexchangerecord.setGiftid(a.getGiftid());

                    // 短ID
                    integralexchangerecord.setId(ShortUUID.generateShortUuid());

                    this.integralexchangerecordservice
                            .addIntegralexchangerecord(integralexchangerecord);

                }
                c.setStatus(1);
                services.addCustomer(c);
                JSONArray award = JSONArray.fromObject(a);
                out.print(award.toString());
            }
            else
            {
                out.print("{success:false}");
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            out.flush();
            out.close();
        }
    }
    
    
  @RequestMapping("/turnGame")
	public void turnGame(String id, HttpServletResponse response, HttpServletRequest request,
			String activitiesid){
		PrintWriter out = null;
		try {
			out = response.getWriter();
			//取大转盘活动
			List<Activities> activiList= activitiesService.getActivitiesBytype("4");
			Date currentDate=new Date();
			Activities at=null;
			for (Activities activities : activiList) {
				if(currentDate.after(activities.getStarttime())&& currentDate.before(activities.getEndtime())){
					at=activities;
					break;
				}
			}
			if(at==null){  //活动时间段
				
				out.print("[{\"noActivi\":\"1\"}]");
				
			}else{
				
				EmpInfo empInfo = (EmpInfo) request.getSession().getAttribute("empInfo");
				IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(empInfo.getJobNumber(), empInfo.getEmpName());
				if (ijferUser != null) {
					SystemConfig scoreConfig = systemConfigService.getSystemConfigByKey("lottery_user_madul_count");
					int badgeCount=Integer.parseInt(scoreConfig.getValue());
					if(ijferUser.getBadgeCount()>=badgeCount){
						List<Award> aList = services.getAward();
						int i =0;
						List<LotteryRecord> awardList=services.getLotteryRecordListByjobNumber(empInfo.getJobNumber());  //通过工号获取获奖记录
						boolean flag=false;
						for (LotteryRecord lotteryRecord : awardList) {
							if(lotteryRecord.getIsPrize()==1&&lotteryRecord.getActivitiesid().equals(at.getId())){
								flag=true;
								break;
							}
						}
						if(flag){
							i=getAward1(aList, id);
						}else{
							i=getAward(aList, id);
						}
						Award a = aList.get(i - 1);
						//记录抽奖信息
						services.updateLotteryRecord(empInfo, at, a, badgeCount,ijferUser);
						a.setChanceCount(ijferUser.getBadgeCount()/badgeCount);
						a.setBadgeCount(ijferUser.getBadgeCount());
		                JSONArray award = JSONArray.fromObject(a);
		                out.print(award.toString());
					}else{
						out.print("[{\"noChance\":\"1\"}]");
					}
				}else{
					out.print("[{\"noChance\":\"1\"}]");
				}
			}
			
		} catch (Exception e) {
			out.print("[{\"systemBusy\":\"1\"}]");
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
    
    
    
    
    private int getAward(List<Award> aList, String id) throws Exception
    {
        int i = getRand(aList);
        Award a = aList.get(i - 1);
        if (a.getIsPrize() == 1)
        {
            if (a.getNum() == 0)
            {
                return getAward(aList, id);
            }
        }
        return i;
    }
    
    private int getAward1(List<Award> aList, String id) throws Exception
    {
        int i = getRand(aList);
        Award a = aList.get(i - 1);
        if (a.getIsPrize() == 1){
        	return getAward1(aList, id);
        }
        return i;
    }
    
    
    //中奖概率计算方法
    private static int getRand(List<Award> list)
    {
        // 概率数组的总概率精度
        int proSum = 1000;
        // 概率数组循环
        for (Award a : list)
        {
            Random random = new Random();
            int num = random.nextInt(proSum) % (proSum - 1 + 1) + 1;    
            if (num <= a.getV())
            {
                return a.getId();
            }
            else
            {
                proSum -= a.getV(); 
            }
        }
        return getRand(list);
    }

}
