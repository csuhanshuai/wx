package com.qixin.app.jackgame.web;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.qixin.app.jackgame.model.JackGameRecord;
import com.qixin.app.jackgame.model.JackGameScore;
import com.qixin.app.jackgame.service.IJackGameService;
import com.qixin.app.lanterngame.model.EmpInfo;
import com.qixin.app.lanterngame.model.IjferUser;
import com.qixin.app.lanterngame.model.UserMedal;
import com.qixin.app.lanterngame.service.LanternGameService;
import com.qixin.app.system.config.service.ISystemConfigService;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.CommonUtil;

@Controller
@RequestMapping("/jackgame")
public class JackgameController {
	@Resource
	private LanternGameService lantenGameService;
	@Resource
	private IJackGameService jackGameService;
	@Resource
	private ISystemConfigService systemConfigService;
	
	@RequestMapping("/checkCanPlay")
	public ModelAndView checkCanPlay(HttpSession session,ModelMap map){
		//再来一次，校验是否可以游戏
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if(null==empInfo){
			map.put("type", "2");
			return new ModelAndView("/app/lanterngame/lanterngame_login",map);
		}
		String jobNumber = empInfo.getJobNumber();
		String empName = empInfo.getEmpName();
		int i = jackGameService.checkCanplay(jobNumber, empName);
		int jackGamePlayCount =3;
		try {
			jackGamePlayCount=Integer.parseInt(systemConfigService.getSystemConfigByKey("jackGamePlayCount").getValue());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		if(i==1){//第一次玩
			JackGameScore jackGameScore = new JackGameScore();
			jackGameScore.setCanPlayCount(jackGamePlayCount);
			jackGameScore.setCreatedDate(new Date());
			jackGameScore.setEmpBadgeCount(0);
			jackGameScore.setEmpName(empName);
			jackGameScore.setJobNumber(jobNumber);
			jackGameScore.setPlayCount(1);
			jackGameScore.setScore(0);
			jackGameScore.setUpdateDate(new Date());
			JackGameRecord jackGameRecord = new JackGameRecord();
			jackGameRecord.setBadgeCount(0);
			jackGameRecord.setBeginTime(new Date());
			jackGameRecord.setCreatedDate(new Date());
			jackGameRecord.setEmpName(empName);
			jackGameRecord.setJobNumber(jobNumber);
			jackGameRecord.setScore(0);
			jackGameRecord.setUpdateDate(new Date());
			try {
				jackGameService.saveJackGameRecord(jackGameRecord);
				jackGameService.saveJackGameScore(jackGameScore);
				session.setAttribute("jackGameRecord", jackGameRecord);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView("/app/jackgame/jackgame",map); 
		}else if (i==2) {//多次玩，还有答题机会
			JackGameScore jackGameScore = jackGameService.getJackGameScoreByPara(jobNumber, empName);
			jackGameScore.setPlayCount(jackGameScore.getPlayCount()+1);
			JackGameRecord jackGameRecord = new JackGameRecord();
			jackGameRecord.setBadgeCount(0);
			jackGameRecord.setBeginTime(new Date());
			jackGameRecord.setCreatedDate(new Date());
			jackGameRecord.setEmpName(empName);
			jackGameRecord.setJobNumber(jobNumber);
			jackGameRecord.setScore(0);
			jackGameRecord.setUpdateDate(new Date());
			try {
				jackGameService.updateJackGameScore(jackGameScore);
				jackGameService.saveJackGameRecord(jackGameRecord);
				session.removeAttribute("jackGameRecord");
				session.setAttribute("jackGameRecord", jackGameRecord);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView("/app/jackgame/jackgame",map); 
		}else{//无机会
			return new ModelAndView("redirect:showTopFour.kq",map);
		}
		
	}
	@RequestMapping("/gameEnd")
	public ModelAndView gameEnd(int score,HttpSession session,ModelMap map,String time,String checkcode) throws ParseException{
		//游戏结束
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		JackGameRecord jacGameRecord = (JackGameRecord) session.getAttribute("jackGameRecord");
		if(null==empInfo||null==jacGameRecord){
			map.put("type", "2");
			return new ModelAndView("/app/lanterngame/lanterngame_login",map);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssS") ;
		Date date1 = sdf.parse(time);
		long mills = date1.getTime();
		String secretStr = null;
		try {
			secretStr = systemConfigService.getSystemConfigByKey("secretKey").getValue();
		} catch (Exception e1) {
		}
		String str = CommonUtil.md5(score+secretStr+mills);
		//System.out.println(str);
		if(!str.equals(checkcode)||null!=jacGameRecord.getEndTime()){
			map.put("medalflag", "0");
			map.put("medalmessage", "对不起，本次游戏无效，请遵守游戏规则！");
			return new ModelAndView("/app/jackgame/jackgameEnd");
		}
		String jobNumber = empInfo.getJobNumber();
		String empName = empInfo.getEmpName();
		JackGameScore jackGameScore = jackGameService.getJackGameScoreByPara(jobNumber, empName);
		
		int jackGameGetMedalScore = 3000;
		try {
			jackGameGetMedalScore = Integer.parseInt(systemConfigService.getSystemConfigByKey("jackGameGetMedalScore").getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(jobNumber, empName);
		jacGameRecord.setEndTime(new Date());
		jacGameRecord.setScore(score);
		jacGameRecord.setUpdateDate(new Date());
		String medalflag="0";
		if(score>=jackGameGetMedalScore&&jackGameScore.getEmpBadgeCount()<3){
			 medalflag ="1";
			jacGameRecord.setBadgeCount(1);
			jackGameScore.setEmpBadgeCount(jackGameScore.getEmpBadgeCount()+1);
			ijferUser.setBadgeCount(ijferUser.getBadgeCount()+1);
			ijferUser.setUpdateDate(new Date());
			//插入员工勋章表
			UserMedal userMedal = new UserMedal();
			userMedal.setJobNumber(jobNumber);
			userMedal.setEmpName(empName);
			userMedal.setBadgeCount(1);
			userMedal.setType(3);
			userMedal.setUpdateDate(new Date());
			try {
				lantenGameService.addUserMedal(userMedal);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(score>jackGameScore.getScore()){
			jackGameScore.setScore(score);
			jackGameScore.setUpdateDate(new Date());
		}
		jackGameService.updateJackGameRecord(jacGameRecord);
		jackGameService.updateJackGameScore(jackGameScore);
		lantenGameService.updateIjferUser(ijferUser);
		//前往排行榜处理action
		map.put("totalscore", score);
		map.put("medalflag", medalflag);
		if(medalflag.equals("0")&&jackGameScore.getEmpBadgeCount()<3){
			map.put("medalmessage", "很遗憾，您没有获得约章!");
		}else if(medalflag.equals("0")&&jackGameScore.getEmpBadgeCount()>=3){
			map.put("medalmessage", "您已经获得了三枚约章，不能再获得更多了!");
		}else{
			map.put("medalmessage", "恭喜您，获得一枚约章!");
		}
		return new ModelAndView("/app/jackgame/jackgameEnd");
	}
	@RequestMapping("/showTopFive")
	public ModelAndView showTopFive(HttpSession session,ModelMap map){
		//查询前三、自己最好成绩、自己当次成绩
		JackGameRecord jackGameRecord =(JackGameRecord)session.getAttribute("jackGameRecord");
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if(null==empInfo||null==jackGameRecord){
			map.put("type", "2");
			return new ModelAndView("/app/lanterngame/lanterngame_login",map);
		}
		String jackGameRecordId = jackGameRecord.getId();
		String jobNumber = empInfo.getJobNumber();
		String empName = empInfo.getEmpName();
		JackGameScore myBest = null;
		JackGameRecord myCurrentScore=null;
		List<JackGameScore> topThree = null;
		try {
			topThree = jackGameService.getTopThreejackGameScores();
			myBest = jackGameService.getJackGameScoreByPara(jobNumber, empName);
			myCurrentScore=jackGameService.getJackGameRecordById(jackGameRecordId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<JackGameScore> myBest2 = new ArrayList<JackGameScore>();
		List<JackGameRecord> myCurrentScore2 = new ArrayList<JackGameRecord>();
		myBest2.add(myBest);
		myCurrentScore2.add(myCurrentScore);
		map.put("topThree", topThree);
		map.put("myBest", myBest2);
		map.put("myCurrentScore", myCurrentScore2);
		return new ModelAndView("/app/jackgame/jackgameSort",map);
	}
	@RequestMapping("/showTopFour")
	public ModelAndView showTopFour(HttpSession session,ModelMap map){
		//查询前三、自己最好成绩
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		
		JackGameScore myBest = null;
		if (null != empInfo){
			String jobNumber = empInfo.getJobNumber();
			String empName = empInfo.getEmpName();
			myBest = jackGameService.getJackGameScoreByPara(jobNumber, empName);
			List<JackGameScore> myBest2 = new ArrayList<JackGameScore>();
			myBest2.add(myBest);
			map.put("myBest", myBest2);
		}
		List<JackGameScore> topThree = null;
		try {
			topThree = jackGameService.getTopThreejackGameScores();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		map.put("topThree", topThree);
		
		return new ModelAndView("/app/jackgame/jackgame_nochance",map);
	}
	@RequestMapping("/addPlayCount")
	@ResponseBody
	public void addPlayCount(HttpSession session,ModelMap map){
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if(null!=empInfo){
			String jobNumber = empInfo.getJobNumber();
			String empName = empInfo.getEmpName();
			JackGameScore jackGameScore = jackGameService.getJackGameScoreByPara(jobNumber, empName);
			jackGameScore.setCanPlayCount(jackGameScore.getCanPlayCount()+1);
			jackGameService.updateJackGameScore(jackGameScore);
		}
		
	}
	@RequestMapping("/toGame")
	public ModelAndView toGame(HttpSession session,ModelMap map){
		return new ModelAndView("/app/jackgame/jackgame");
	}
	@RequestMapping("/listJakeGameRecord")
	public ModelAndView listJakeGameRecord(HttpServletRequest request, HttpServletResponse response, Query query,JackGameRecord jackGameRecord){
		Map<String, Object> map = new HashMap<String, Object>();
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        query = (query != null) ? query : new Query();
        query.setPageSize(20);
        try {
        	PageFinder<JackGameRecord> pageFinder = jackGameService.findJackGameRecordByPageFinder(query, jackGameRecord);
            map.put("pageFinder", pageFinder);
		} catch (Exception e) {
			CommonLogger.error("get Activities byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
        map.put("bid", bid);
        return new ModelAndView("/app/jackgame/list",map);
	}
}
