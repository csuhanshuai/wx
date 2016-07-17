package com.qixin.app.lanterngame.web;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.jackgame.model.JackGameScore;
import com.qixin.app.jackgame.service.IJackGameService;
import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.app.lanterngame.model.EmpInfo;
import com.qixin.app.lanterngame.model.EmpScore;
import com.qixin.app.lanterngame.model.IjferUser;
import com.qixin.app.lanterngame.model.QuizGameRecord;
import com.qixin.app.lanterngame.model.QuizTopic;
import com.qixin.app.lanterngame.model.QuizTopicReply;
import com.qixin.app.lanterngame.model.UserMedal;
import com.qixin.app.lanterngame.service.LanternGameService;
import com.qixin.app.lanterngame.util.Utils;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.config.model.SystemConfig;
import com.qixin.app.system.config.service.ISystemConfigService;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.turntable.model.Award;
import com.qixin.app.turntable.service.TurntableService;
import com.qixin.app.vote.model.Vote;
import com.qixin.app.vote.model.VoteApply;
import com.qixin.app.vote.model.WxVote;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/lanterngame")

public class LanterngameController {
	@Resource
	private LanternGameService lantenGameService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private IJackGameService jackGameService;

	@Resource
    private TurntableService services;
	// 前往游戏首页
	@RequestMapping("/toLanternGameIndex")
	public ModelAndView toLanternGameIndex(ModelMap map) {
		map.put("score", this.getMadulScore());
		return new ModelAndView("/app/lanterngame/LanternGameIndex", map);
	}

	// 游戏结束
	@RequestMapping("/completeLantenGame")
	public ModelAndView completeLantenGame(HttpServletRequest request) {
		EmpInfo e = new EmpInfo();
		e.setArea("123");
		request.setAttribute("s", e);
		return new ModelAndView("/app/lanterngame/test2");
	}

	@RequestMapping("/toLogin")
	public ModelAndView toLogin() {
		return new ModelAndView("/app/lanterngame/LanternGameIndex");
	}

	@RequestMapping("/toLoginPage")
	public ModelAndView toLoginPage() {
		// 前往登录页面
		return new ModelAndView("/app/lanterngame/lanterngame_login");
	}

	private String getMadulScore() {
		SystemConfig scoreConfig = null;
		try {
			scoreConfig = systemConfigService.getSystemConfigByKey("score");
		} catch (Exception e) {
		}
		String getMadulScore = "80";
		if (null != scoreConfig) {
			getMadulScore = scoreConfig.getValue();
		}

		return getMadulScore;
	}

	@RequestMapping("/checkForward")
	public ModelAndView checkForward(HttpSession session, ModelMap map,  String type) {
		// type 1竞猜 2大冒险 3祝福 4大转盘
		Object object = session.getAttribute("empInfo");
		// 校验用户session是否存在
		if (object == null) {// 不存在，前往登录页面
			map.put("type", type);
			return new ModelAndView("/app/lanterngame/lanterngame_login", map);
		} else {// session存在，前往对应游戏页面\
			EmpInfo empInfo = (EmpInfo) object;
			String empNum = empInfo.getJobNumber();
			String empName = empInfo.getEmpName();
			if (type != null && type.equals("1")) {
				// 剩余游戏次数
				String value = "3";
				try {
					value = systemConfigService.getSystemConfigByKey("lanterngamePlayCount").getValue();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int lanterngamePlayCount = 3;
				if (value == null || value.equals("") || value.equals("lanterngamePlayCount")) {
					lanterngamePlayCount = 3;
				} else {
					lanterngamePlayCount = Integer.parseInt(value);
				}
				EmpScore empScore = lantenGameService.getEmpScoreByJobNum(empNum);
				int lastPlayCount = 0;
				if (empScore == null) {
					lastPlayCount = lanterngamePlayCount;
				} else {
					int i = empScore.getCanPlayCount() - empScore.getPlayCount();
					if (i >= 0) {
						lastPlayCount = i;
					} else {
						lastPlayCount = 0;
					}
				}

				map.put("score", this.getMadulScore());
				map.put("lastPlayCount", lastPlayCount);
				return new ModelAndView("/app/lanterngame/LanternGameIndex", map);// 猜灯谜介绍页面
			} else if (type != null && type.equals("2")) {
				String value = "3";
				try {
					value = systemConfigService.getSystemConfigByKey("jackGamePlayCount").getValue();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int jackGamePlayCount = 3;
				if (value == null || value.equals("") || value.equals("jackGamePlayCount")) {
					jackGamePlayCount = 3;
				} else {
					jackGamePlayCount = Integer.parseInt(value);
				}
				int lastPlayCount = 0;
				JackGameScore jackGameScore = jackGameService.getJackGameScoreByPara(empNum, empName);
				if (jackGameScore == null) {
					lastPlayCount = jackGamePlayCount;
				} else {
					int i = jackGameScore.getCanPlayCount() - jackGameScore.getPlayCount();
					if (i >= 0) {
						lastPlayCount = i;
					} else {
						lastPlayCount = 0;
					}
				}
				map.put("lastPlayCount", lastPlayCount);

				return new ModelAndView("/app/jackgame/jackgameindex");// 大冒险介绍页面
			} else if (type != null && type.equals("3")) {
				return new ModelAndView("redirect:/vote/getIndexInformation.kq");
			} else if (type != null && type.equals("4")) {
				return new ModelAndView("redirect:/turentable/toTurentable.kq");// 大转盘介绍页面
			} else {
				return new ModelAndView("");// 提示页面，无该游戏
			}
		}
	}

	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(String empNum, String empName, String type, HttpSession session, ModelMap map) {
		session.removeAttribute("empInfo");// 清除用户session
		System.out.println("login");
		EmpInfo empInfo = lantenGameService.checkIsEmp(empNum, empName);
		if (empInfo == null) {
			// 员工不存在
			map.put("loginError", "姓名或工号错误");
			map.put("type", type);
			return new ModelAndView("/app/lanterngame/lanterngame_loginfail", map);
		} else {// 员工存在
			session.setAttribute("empInfo", empInfo);// 保存员工信息至session
			// 解放号用户信息查询
			IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(empNum, empName);
			if (ijferUser == null) {
				IjferUser iUser = new IjferUser();
				iUser.setBadgeCount(0);
				iUser.setCreatedDate(new Date());
				iUser.setEmpName(empName);
				iUser.setUpdateDate(new Date());
				iUser.setWorkNo(Utils.addZeroForJobNumbe(empNum));
				try {
					lantenGameService.saveIjferUser(iUser);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			if (type != null && type.equals("1")) {
				// 剩余游戏次数
				String value = "3";
				try {
					value = systemConfigService.getSystemConfigByKey("lanterngamePlayCount").getValue();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int lanterngamePlayCount = 3;
				if (value == null || value.equals("") || value.equals("lanterngamePlayCount")) {
					lanterngamePlayCount = 3;
				} else {
					lanterngamePlayCount = Integer.parseInt(value);
				}
				EmpScore empScore = lantenGameService.getEmpScoreByJobNum(empNum);
				int lastPlayCount = 0;
				if (empScore == null) {
					lastPlayCount = lanterngamePlayCount;
				} else {
					int i = empScore.getCanPlayCount() - empScore.getPlayCount();
					if (i >= 0) {
						lastPlayCount = i;
					} else {
						lastPlayCount = 0;
					}
				}

				map.put("score", this.getMadulScore());
				map.put("lastPlayCount", lastPlayCount);
				return new ModelAndView("/app/lanterngame/LanternGameIndex", map);// 猜灯谜介绍页面
			} else if (type != null && type.equals("2")) {
				String value = "3";
				try {
					value = systemConfigService.getSystemConfigByKey("jackGamePlayCount").getValue();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int jackGamePlayCount = 3;
				if (value == null || value.equals("") || value.equals("jackGamePlayCount")) {
					jackGamePlayCount = 3;
				} else {
					jackGamePlayCount = Integer.parseInt(value);
				}
				int lastPlayCount = 0;
				JackGameScore jackGameScore = jackGameService.getJackGameScoreByPara(empNum, empName);
				if (jackGameScore == null) {
					lastPlayCount = jackGamePlayCount;
				} else {
					int i = jackGameScore.getCanPlayCount() - jackGameScore.getPlayCount();
					if (i >= 0) {
						lastPlayCount = i;
					} else {
						lastPlayCount = 0;
					}
				}
				map.put("lastPlayCount", lastPlayCount);
				return new ModelAndView("/app/jackgame/jackgameindex");// 大冒险介绍页面
			} else if (type != null && type.equals("3")) {
				return new ModelAndView("redirect:/vote/getIndexInformation.kq");
			} else if (type != null && type.equals("4")) {
				return new ModelAndView("redirect:/turentable/toTurentable.kq");// 大转盘介绍页面
			} else {
				return new ModelAndView("");// 提示页面，无该游戏
			}

		}

	}

	@RequestMapping("/checkCanPlay")
	public ModelAndView checkCanPlay(HttpSession session, ModelMap map, HttpServletRequest request) {
		// 校验是否有答题机会，在此答题
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if (null == empInfo) {
			map.put("type", "1");
			return new ModelAndView("/app/lanterngame/lanterngame_login", map);
		}
		String jobNumber = empInfo.getJobNumber();
		empInfo.setErrorNum(0);
		lantenGameService.updateEmpInfo(empInfo);
		int i = lantenGameService.checkIsCanGame(jobNumber);
		session.removeAttribute("topicId");
		session.setAttribute("empInfo", empInfo);
		if (i == 1) {
			// 第一次答题
			String value = "3";
			try {
				value = systemConfigService.getSystemConfigByKey("lanterngamePlayCount").getValue();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			int lanterngamePlayCount = 3;
			if (value == null || value.equals("")) {
				lanterngamePlayCount = 3;
			} else {
				lanterngamePlayCount = Integer.parseInt(value);
			}
			EmpScore empScore = new EmpScore();
			empScore.setJobNumber(jobNumber);
			empScore.setEmpName(empInfo.getEmpName());
			empScore.setScore(0);
			empScore.setPlayCount(1);
			empScore.setCanPlayCount(lanterngamePlayCount);
			empScore.setEmpBadgeCount(0);
			empScore.setUpdateDate(new Date());
			QuizGameRecord quizGameRecord = new QuizGameRecord();
			quizGameRecord.setJobNumber(jobNumber);
			quizGameRecord.setEmpName(empInfo.getEmpName());
			quizGameRecord.setBeginTime(new Date());
			quizGameRecord.setScore(0);
			try {
				// 插入员工得分记录表、员工本次答题记录表、本次答题记录放入session，游戏结束需要更新及统计数据
				lantenGameService.saveEmpScore(empScore);
				lantenGameService.saveAnswerRecord(quizGameRecord);
				session.setAttribute("quizGameRecord", quizGameRecord);

			} catch (Exception e) {

				e.printStackTrace();
			}
			return new ModelAndView("/app/lanterngame/LanternGameMain", map);
		} else if (i == 2) {
			// 原来有答题记录，可继续答题
			EmpScore empScore = lantenGameService.getEmpScoreByJobNum(jobNumber);
			empScore.setPlayCount(empScore.getPlayCount() + 1);
			QuizGameRecord quizGameRecord = new QuizGameRecord();
			quizGameRecord.setJobNumber(jobNumber);
			quizGameRecord.setEmpName(empInfo.getEmpName());
			quizGameRecord.setBeginTime(new Date());
			quizGameRecord.setScore(0);
			try {
				// 更新员工得分记录表答题次数+1
				// 为了排除再次答题存在"quizGameRecord"，先remove，在set
				// 本次答题记录放入session，游戏结束需要更新及统计数据
				lantenGameService.updateEmpScore(empScore);
				session.removeAttribute("quizGameRecord");
				lantenGameService.saveAnswerRecord(quizGameRecord);
				session.setAttribute("quizGameRecord", quizGameRecord);
			} catch (Exception e) {

				e.printStackTrace();
			}
			return new ModelAndView("/app/lanterngame/LanternGameMain", map);
		} else {
			// 答题机会已用完
			return new ModelAndView("redirect:showTopFour.kq", map);
		}
	}

	@RequestMapping("/continueAnswer")
	public ModelAndView continueAnswer(HttpServletRequest request) {
		return new ModelAndView("/app/lanterngame/LanternGameMain");
	}

	@RequestMapping("/toAddQuestion")
	public ModelAndView toAddQuestion(ModelMap map, HttpServletRequest request) {
		// 前往录入题目页面
		String type = request.getParameter("type");
		Object bido = request.getSession().getAttribute(Constant.LOGIN_SYSTEM_USER);

		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		map.put("bid", bid);

		if ("mod".equals(type)) {
			String itemID = request.getParameter("questionID");
			QuizTopic qt = lantenGameService.getQuizTopicById(itemID);
			map.put("question", qt);
			map.put("type", type);
		}
		return new ModelAndView("/app/lanterngame/toAddQuestion");
	}

	@RequestMapping("/addQuestion")
	public ModelAndView addQuestion(ModelMap map, QuizTopic quiz, HttpServletRequest request) throws Exception {
		// 维护附件信息表

		String imgUrlHidden = request.getParameter("imgUrlHidden");
		AttachInfo attachInfo = new AttachInfo();
		Object bido = request.getSession().getAttribute(Constant.LOGIN_SYSTEM_USER);
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		if (imgUrlHidden != null && !"".equals(imgUrlHidden)) {
			attachInfo.setImgDir(imgUrlHidden);
			String suff = "jpg";
			attachInfo.setSuffix(suff);
			quiz.setImgUrl(imgUrlHidden);
			lantenGameService.addAttachInfo(attachInfo);
		}
		String operation = request.getParameter("operation");
		String rightTitle = request.getParameter("rightTitle");
		quiz.setRightTitle(rightTitle.replace(" ", ""));
		if ("mod".equals(operation)) {
			quiz.setUpdateTime(new Date());
			quiz.setUpdater(bid);
			quiz.setImgId(attachInfo.getId());// 图片Id
			lantenGameService.updateQuizTopic(quiz);
		} else {
			quiz.setCreateTime(new Date());
			quiz.setImgId(attachInfo.getId());// 图片Id
			quiz.setCreater(systemUser.getId());
			lantenGameService.addQuizTopic(quiz);
		}
		List<QuizTopic> list = lantenGameService.getAllQuizTopic();
		map.put("quziTopicList", list);
		return listQuestion(map, request, null);
	}

	@RequestMapping("/listQuestion")
	public ModelAndView listQuestion(ModelMap map, HttpServletRequest request, Query query) {
		query = (query != null) ? query : new Query();
		query.setPageSize(20);

		Object bido = request.getSession().getAttribute("login_system_user");
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		try {

			PageFinder<QuizTopic> pageFinder = lantenGameService.findQuizTopicByPageFinder(query);
			map.put("type", "questionList");
			map.put("pageFinder", pageFinder);
			map.put("bid", bid);

		} catch (Exception e) {
			CommonLogger.error("get Retailstore byBid出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("warnframe", map);
		}
		return new ModelAndView("/app/lanterngame/questionList");
	}

	@RequestMapping("/deleteQuestion")
	public ModelAndView deleteQuestion(ModelMap map, HttpServletRequest request, Query query) throws Exception {
		String itemId = request.getParameter("questionID");
		lantenGameService.deleteQuizTopicById(itemId);
		return listQuestion(map, request, null);
	}

	@RequestMapping("/getQuestionDetailForward/{id}")
	public ModelAndView getQuestionDetailForward(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id, ModelMap map) {
		try {
			QuizTopic quiz = null;
			if (!CommonTool.isEmpty(id)) {
				quiz = lantenGameService.getQuizTopicById(id);
				if (quiz.getImgUrl() != null) {
					map.put("hasImgUrl", "true");
				}
				if (quiz == null) {
					quiz = new QuizTopic();
				}
			}
			map.put("question", quiz);
		} catch (Exception e) {
			CommonLogger.error("get ZhaopinDetail byid出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("warnframe", map);
		}
		return new ModelAndView("/app/lanterngame/questionDetail");
	}

	@RequestMapping("/queryGameList")
	public ModelAndView queryGameList(ModelMap map, HttpServletRequest request, Query query) throws Exception {
		query = (query != null) ? query : new Query();
		query.setPageSize(20);
		String searchType = request.getParameter("searchType");
		String condition = request.getParameter("condition");
		Map conditionMap = new HashMap();
		PageFinder<QuizGameRecord> pageFinder = null;
		if (searchType == null || "".equals(searchType) || condition == null || "".equals(condition)) {
			pageFinder = lantenGameService.getQuizGameRecordList(conditionMap, query);
			map.put("searchType", "");
		} else {
			if ("jobNumber".equals(searchType)) {
				conditionMap.put("jobNumber", condition);
			} else if ("empName".equals(searchType)) {
				conditionMap.put("empName", condition);
			}
			map.put("searchType", searchType);
			pageFinder = lantenGameService.getQuizGameRecordList(conditionMap, query);
		}
		if (condition != null && !"".equals(condition)) {
			map.put("conditionValue", condition);
		} else {
			map.put("conditionValue", "");
		}

		map.put("type", "queryGameList");
		map.put("pageFinder", pageFinder);

		return new ModelAndView("/app/lanterngame/queryGameList");
	}

	@RequestMapping("/queryTopicListofOneGame/{id}")
	public ModelAndView queryTopicListofOneGame(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id, ModelMap map) {
		try {
			List<QuizTopicReply> list = new ArrayList<QuizTopicReply>();
			Map<Integer, String> titleMap = new HashMap<Integer, String>();
			if (!CommonTool.isEmpty(id)) { 
				list = lantenGameService.getQuizTopicReplyByRecordId(id);
				for (QuizTopicReply quizTopicReply : list) {
					String titleID = quizTopicReply.getTopicId();
					if (titleID != null && !"".equals(titleID)) {
						QuizTopic qt = lantenGameService.getQuizTopicById(titleID);
						if (qt != null && qt.getTitle() != null && !"".equals(qt.getTitle())) {
							quizTopicReply.setTopicTitle(qt.getTitle());
						} else {
							quizTopicReply.setTopicTitle("");
						}
					}
				}
			}
			map.put("quizTopicReplyList", list);
			map.put("titleMap", titleMap);
		} catch (Exception e) {
			CommonLogger.error("get ZhaopinDetail byid出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("warnframe", map);
		}
		return new ModelAndView("/app/lanterngame/queryTopicListofOneGame");
	}

	// 给题接口
	@RequestMapping("/giveTopic")
	public ModelAndView giveTopic(HttpSession session, ModelMap map) {

		// String topicId = (String) session.getAttribute("topicId");
		String topicId = (String) session.getAttribute("topicId");
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		QuizGameRecord quizGame = (QuizGameRecord) session.getAttribute("quizGameRecord");
		if (null == empInfo || null == quizGame) {
			map.put("type", "1");
			return new ModelAndView("/app/lanterngame/lanterngame_login", map);
		}
		if (null == topicId)
			topicId = "'0'";

		// String topicId="41";

		Integer errorNum = empInfo.getErrorNum();
		// int errorNum=1;
		String tipMsg = "";
		String jobNumber = empInfo.getJobNumber();

		// 游戏记录id

		String recordId = quizGame.getId();
		if (null == recordId)
			recordId = "";

		// 查询没有进行回答的题目
		int count = lantenGameService.handleNotAnswer(recordId);
		int medalscore = Integer.parseInt(this.getMadulScore());
		errorNum += count;
		empInfo.setErrorNum(errorNum);
		session.removeAttribute("empInfo");
		session.setAttribute("empInfo", empInfo);

		if (errorNum >= 3) {
			quizGame.setJobNumber(jobNumber);
			quizGame.setEmpName(empInfo.getEmpName());
			quizGame.setEndTime(new Date());
			quizGame.setUpdateDate(new Date());
			int score = lantenGameService.getTotalScore(recordId);
			quizGame.setScore(score);
			session.removeAttribute("quizGameRecord");
			lantenGameService.updateAnswerRecord(quizGame);
			session.setAttribute("quizGameRecord", quizGame);

			
			int confignum = 0;
			String medalflag = "0";

			SystemConfig errorNumsystemConfig = null;
			try {
				errorNumsystemConfig = systemConfigService.getSystemConfigByKey("errornum");
			} catch (Exception e) {
				e.printStackTrace();
			}

			medalscore = Integer.parseInt(this.getMadulScore());

			if (null != errorNumsystemConfig) {
				confignum = Integer.parseInt(errorNumsystemConfig.getValue());
			}

			tipMsg = "错误次数已经达到" + confignum + "次，不能继续答题";
			map.put("tipMsg", tipMsg);

			// 计算本次游戏得分和约章数
			// 更新员工得分表
			EmpScore empScore = lantenGameService.getEmpScoreByJobNum(jobNumber);
			int bagCount = 0;
			if (null != empScore.getEmpBadgeCount())
				bagCount = empScore.getEmpBadgeCount().intValue();

			if (score > empScore.getScore()) {
				empScore.setScore(score);
				empScore.setUpdateDate(new Date());
			}
			if (score >= medalscore && bagCount < 3) {
				medalflag = "1";
				empScore.setEmpBadgeCount(bagCount + 1);
				IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(jobNumber, empInfo.getEmpName());
				ijferUser.setBadgeCount(ijferUser.getBadgeCount() + 1);
				ijferUser.setUpdateDate(new Date());
				lantenGameService.updateIjferUser(ijferUser);
				// 插入员工勋章表
				UserMedal userMedal = new UserMedal();
				userMedal.setJobNumber(jobNumber);
				userMedal.setEmpName(empInfo.getEmpName());
				userMedal.setBadgeCount(1);
				userMedal.setType(1);
				userMedal.setUpdateDate(new Date());
				try {
					lantenGameService.addUserMedal(userMedal);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			lantenGameService.updateEmpScore(empScore);

			map.put("totalscore", score);
			map.put("tipMsg", tipMsg);
			map.put("bagCount", bagCount);
			map.put("medalflag", medalflag);
			map.put("medalscore", medalscore);
			return new ModelAndView("/app/lanterngame/LanternGameEnd", map);

		}
		QuizTopic quizTopic = lantenGameService.getTopic(topicId);
		if (null == quizTopic) {
			tipMsg = "题目已经答完，谢谢参与本次答题活动";
			map.put("tipMsg", tipMsg);
			return new ModelAndView("/app/lanterngame/LanternGameEnd", map);
		}
		List<QuizTopic> quizTopics = new ArrayList<QuizTopic>();
		quizTopics.add(quizTopic);
		map.put("quizTopics", quizTopics);
		map.put("maxSubmitTime", quizTopic.getMaxSubmitTime());
		try {
			// 插入答题表
			QuizTopicReply quizTopicReply = new QuizTopicReply();
			quizTopicReply.setScore(0);
			quizTopicReply.setReplyJobNumber(jobNumber);
			quizTopicReply.setEmpName(empInfo.getEmpName());
			quizTopicReply.setBeginTime(new Date());
			quizTopicReply.setGameRecordId(recordId);
			quizTopicReply.setTopicId(quizTopic.getId());
			lantenGameService.saveAnswerRecordQuestion(quizTopicReply);
			map.put("replyId", quizTopicReply.getId());
			session.setAttribute("quizTopicReply", quizTopicReply);
		} catch (Exception e) {
		}
		
		map.put("lastCount", count);
		return new ModelAndView("/app/lanterngame/lanterngame_timu", map);
	}

	// 跳转接口
	@RequestMapping("/goNext")
	public ModelAndView goNext(ModelMap map) {
		String tipMsg = "本次答题已经超时!";
		map.put("tipMsg", tipMsg);
		
		return new ModelAndView("/app/lanterngame/lanterngame_chaoshi", map);
	}

	// 答题接口
	@RequestMapping("/answerTopic")
	public ModelAndView answerTopic(HttpSession session, ModelMap map, String replyId, String result) {
		String topicId = (String) session.getAttribute("topicId");
		if (null == topicId)
		{
			topicId = "'0'";
		}
		// 游戏记录id
		QuizGameRecord quizGame = (QuizGameRecord) session.getAttribute("quizGameRecord");
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if (null == empInfo || quizGame == null) {
			map.put("type", "1");
			return new ModelAndView("/app/lanterngame/lanterngame_login", map);
		}
		
		int medalscore = Integer.parseInt(this.getMadulScore());
		// 员工得分信息
		EmpScore empScore = lantenGameService.getEmpScoreByJobNum(empInfo.getJobNumber());
		
		if (quizGame.getEndTime() != null){
			map.put("totalscore", "0");
			map.put("tipMsg", "答题已结束");
			map.put("bagCount", empScore.getEmpBadgeCount());
			map.put("medalflag", "0");
			map.put("medalscore", medalscore);
			return new ModelAndView("/app/lanterngame/LanternGameEnd", map);
		}

		int errorNum = empInfo.getErrorNum();
		String recordId = quizGame.getId();

		if (null == recordId)
			recordId = "";

		String jobNumber = empInfo.getJobNumber();
		QuizTopicReply quizTopicReply = (QuizTopicReply) session.getAttribute("quizTopicReply");
		
		java.util.Date date1 = quizTopicReply.getBeginTime();
		java.util.Date date2 = new Date();

		SystemConfig systemConfig2 = null;
		try {
			systemConfig2 = systemConfigService.getSystemConfigByKey("errornum");
		} catch (Exception e) {
		}
		
		long temp = date2.getTime() - date1.getTime();

		int confignum = 0;

		if (null != systemConfig2)
			confignum = Integer.parseInt(systemConfig2.getValue());

		String medalflag = "0";
		
		QuizTopicReply reply = lantenGameService.getTopicReplyById(replyId);
		QuizTopic quizTopic = null;
		
		// 如果答题时间超过60秒，作为答错处理
		if (temp > 1000 * 60 || null == reply) {
			// 插入答题表
			quizTopicReply.setGameRecordId(recordId);
			quizTopicReply.setReplyJobNumber(jobNumber);
			quizTopicReply.setEmpName(empInfo.getEmpName());
			int i = (int) (temp / 1000);
			quizTopicReply.setReplySpendTime(i);
			quizTopicReply.setScore(0);
			quizTopicReply.setBeginTime(date1);
			quizTopicReply.setEndTime(date2);
			quizTopicReply.setUpdateDate(date2);
			try {
				// 更新员工得分记录表答题次数+1
				// 将选过的题目加入到session中
				if (null != reply) {
					quizTopic = lantenGameService.getQuizTopicById(reply.getTopicId());
					topicId = topicId + ",'" + quizTopic.getId() + "'";
				}
				else{
					quizTopic = new QuizTopic();
					quizTopic.setId(quizTopicReply.getTopicId());
				}
				session.removeAttribute("topicId");
				session.setAttribute("topicId", topicId);

				// 该用户的答错次数+1
				errorNum += 1;
				empInfo.setErrorNum(errorNum);
				session.removeAttribute("empInfo");
				session.setAttribute("empInfo", empInfo);

				// 如果数据库中有记录但是没更新则更新，否则不做更新
				if (1 == lantenGameService.isExistReply(recordId, jobNumber, quizTopic.getId())) {
					session.removeAttribute("quizTopicReply");
					lantenGameService.updateAnswerRecordQuestion(quizTopicReply);
					session.setAttribute("quizTopicReply", quizTopicReply);
				}
				map.put("quizTopicReply", quizTopicReply);
				quizTopic = lantenGameService.getTopic(topicId);
				// 判断题库中是否还有题目，如果没有表明这次题目已经答完
				if (null == quizTopic || errorNum >= confignum) {
					// 插入游戏记录表

					quizGame.setJobNumber(jobNumber);
					quizGame.setEmpName(empInfo.getEmpName());
					quizGame.setBeginTime(date1);
					quizGame.setEndTime(date2);
					quizGame.setUpdateDate(date2);
					int score = lantenGameService.getTotalScore(recordId);
					quizGame.setScore(score);
					session.removeAttribute("quizGameRecord");
					lantenGameService.updateAnswerRecord(quizGame);
					session.setAttribute("quizGameRecord", quizGame);

					
					int bagCount = 0;
					if (null != empScore.getEmpBadgeCount())
						bagCount = empScore.getEmpBadgeCount().intValue();

					if (score > empScore.getScore()) {
						empScore.setScore(score);
						empScore.setUpdateDate(new Date());
					}
					if (score >= medalscore && bagCount < 3) {
						medalflag = "1";
						empScore.setEmpBadgeCount(bagCount + 1);
						IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(jobNumber, empInfo.getEmpName());
						ijferUser.setBadgeCount(ijferUser.getBadgeCount() + 1);
						ijferUser.setUpdateDate(new Date());
						lantenGameService.updateIjferUser(ijferUser);
						// 插入员工勋章表
						UserMedal userMedal = new UserMedal();
						userMedal.setJobNumber(jobNumber);
						userMedal.setEmpName(empInfo.getEmpName());
						userMedal.setBadgeCount(1);
						userMedal.setType(1);
						userMedal.setUpdateDate(new Date());
						lantenGameService.addUserMedal(userMedal);
					}
					lantenGameService.updateEmpScore(empScore);
					String tipMsg = "";
					
					if (null == quizTopic){
						tipMsg = "题目已经答完，谢谢参与本次答题活动";
					}
					else{
						tipMsg = "错误次数已经达到" + confignum + "次，不能继续答题";
					}
						
					map.put("totalscore", score);
					map.put("tipMsg", tipMsg);
					map.put("bagCount", bagCount);
					map.put("medalflag", medalflag);
					map.put("medalscore", medalscore);
					return new ModelAndView("/app/lanterngame/LanternGameEnd", map);
				}
				return new ModelAndView("/app/lanterngame/lanterngame_fail", map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 如果用户给出的答案与题目的正确答案相符合
			// 插入答题表
			quizTopic = lantenGameService.getQuizTopicById(reply.getTopicId());
			if (null != quizTopicReply && quizTopicReply.getTopicId().equals(quizTopic.getId()) && result.trim().equals(quizTopic.getRightTitle().trim())) 
			{
				int score = quizTopic.getTopicScore();
				// empScore.setScore(empScore.getScore()+score);
				// 插入答题表
				quizTopicReply.setGameRecordId(recordId);
				quizTopicReply.setAnswerResult(result);

				quizTopicReply.setReplyJobNumber(jobNumber);
				quizTopicReply.setEmpName(empInfo.getEmpName());
				quizTopicReply.setTopicId(quizTopic.getId());
				int i = (int) (temp / 1000);
				quizTopicReply.setReplySpendTime(i);
				if (i<=30){
					quizTopicReply.setScore(score);
				}
				else{
					quizTopicReply.setScore(score/2);
				}
				quizTopicReply.setBeginTime(date1);
				quizTopicReply.setEndTime(date2);
				quizTopicReply.setUpdateDate(date2);
				try {
					// 更新员工得分记录表答题次数+1
					// lantenGameService.updateEmpScore(empScore);

					// 将选过的题目加入到session中
					if (null != quizTopic)
					// 将选过的题目加入到session中
					{
						topicId = topicId + ",'" + quizTopic.getId() + "'";
					}
					session.removeAttribute("topicId");
					session.setAttribute("topicId", topicId);

					// 如果数据库中有记录但是没更新则更新，否则不做更新
					if (1 == lantenGameService.isExistReply(recordId, jobNumber, quizTopic.getId())) {
						session.removeAttribute("quizTopicReply");
						lantenGameService.updateAnswerRecordQuestion(quizTopicReply);
						session.setAttribute("quizTopicReply", quizTopicReply);
					}
					map.put("quizTopicReply", quizTopicReply);

					quizTopic = lantenGameService.getTopic(topicId);
					// 判断题库中是否还有题目，如果没有表明这次题目已经答完
					if (null == quizTopic || errorNum >= confignum) {
						// 插入游戏记录表
						// QuizGameRecord quizGameRecord = new QuizGameRecord();
						quizGame.setJobNumber(jobNumber);
						quizGame.setEmpName(empInfo.getEmpName());
						quizGame.setBeginTime(date1);
						quizGame.setEndTime(date2);
						quizGame.setUpdateDate(date2);
						int totalscore = lantenGameService.getTotalScore(recordId);
						quizGame.setScore(totalscore);
						session.removeAttribute("quizGameRecord");
						lantenGameService.updateAnswerRecord(quizGame);
						session.setAttribute("quizGameRecord", quizGame);

						// 更新员工得分表
						int bagCount = 0;
						if (null != empScore.getEmpBadgeCount())
							bagCount = empScore.getEmpBadgeCount().intValue();
						// 如果此次员工得分大于此前最高得分，则需要更新最高得分和最后更新时间
						if (totalscore > empScore.getScore()) {
							empScore.setScore(totalscore);
							empScore.setUpdateDate(new Date());
						}
						if (totalscore >= medalscore && bagCount < 3) {
							medalflag = "1";
							empScore.setEmpBadgeCount(bagCount + 1);
							IjferUser ijferUser = lantenGameService.getEmpIjferUserByWorkNo(jobNumber);
							if (null == ijferUser.getBadgeCount()) {
								ijferUser.setBadgeCount(0);
							}

							ijferUser.setBadgeCount(ijferUser.getBadgeCount() + 1);

							ijferUser.setUpdateDate(new Date());
							lantenGameService.updateIjferUser(ijferUser);
							// 插入员工勋章表
							UserMedal userMedal = new UserMedal();
							userMedal.setJobNumber(jobNumber);
							userMedal.setEmpName(empInfo.getEmpName());
							userMedal.setBadgeCount(1);
							userMedal.setType(1);
							userMedal.setUpdateDate(new Date());
							lantenGameService.addUserMedal(userMedal);
						}
						lantenGameService.updateEmpScore(empScore);

						String tipMsg = "";
						if (null == quizTopic)
						{
							tipMsg = "题目已经答完，谢谢参与本次答题活动";
						}
						else{
							tipMsg = "错误次数已经达到" + confignum + "次，不能继续答题";
						}
						map.put("totalscore", totalscore);
						map.put("tipMsg", tipMsg);
						map.put("bagCount", bagCount);
						map.put("medalflag", medalflag);
						map.put("medalscore", medalscore);
						return new ModelAndView("/app/lanterngame/LanternGameEnd", map);
					}
					// 答对后重新给题
					List<QuizTopic> quizTopics = new ArrayList<QuizTopic>();
					quizTopics.add(quizTopic);
					map.put("quizTopics", quizTopics);
					map.put("maxSubmitTime", quizTopic.getMaxSubmitTime());
					try {
						// date1= sdf.parse(beginTime);
						// 插入答题表
						QuizTopicReply quizTopicReply2 = new QuizTopicReply();
						quizTopicReply2.setScore(0);
						quizTopicReply2.setReplyJobNumber(jobNumber);
						quizTopicReply2.setEmpName(empInfo.getEmpName());
						quizTopicReply2.setBeginTime(new Date());
						quizTopicReply2.setGameRecordId(recordId);
						quizTopicReply2.setTopicId(quizTopic.getId());
						// 数据库保存
						lantenGameService.saveAnswerRecordQuestion(quizTopicReply2);
						map.put("replyId", quizTopicReply2.getId());
						session.setAttribute("quizTopicReply", quizTopicReply2);
					} catch (Exception e) {
					}

					return new ModelAndView("/app/lanterngame/lanterngame_timu", map);
					// return quizTopicReply;
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			// 答错的处理方法
			else {
				quizTopicReply.setGameRecordId(recordId);
				quizTopicReply.setReplyJobNumber(jobNumber);
				quizTopicReply.setEmpName(empInfo.getEmpName());
				quizTopicReply.setTopicId(quizTopic.getId());
				int i = (int) (temp / 1000);
				quizTopicReply.setReplySpendTime(i);
				quizTopicReply.setScore(0);
				quizTopicReply.setBeginTime(date1);
				quizTopicReply.setEndTime(new Date());
				quizTopicReply.setUpdateDate(new Date());
				quizTopicReply.setAnswerResult(result);
				try {
					// 更新员工得分记录表答题次数+1
					// lantenGameService.updateEmpScore(empScore);

					// 将选过的题目加入到session中
					if (null != quizTopic)
					{
						topicId = topicId + ",'" + quizTopicReply.getTopicId() + "'";
					}
					session.removeAttribute("topicId");
					session.setAttribute("topicId", topicId);

					// 该用户的答错次数+1
					errorNum += 1;
					empInfo.setErrorNum(errorNum);
					session.removeAttribute("empInfo");
					session.setAttribute("empInfo", empInfo);

					// 如果数据库中有记录但是没更新则更新，否则不做更新
					if (1 == lantenGameService.isExistReply(recordId, jobNumber, quizTopic.getId())) {
						session.removeAttribute("quizTopicReply");
						lantenGameService.updateAnswerRecordQuestion(quizTopicReply);
						session.setAttribute("quizTopicReply", quizTopicReply);
					}
					map.put("quizTopicReply", quizTopicReply);

					quizTopic = lantenGameService.getTopic(topicId);
					// 判断题库中是否还有题目，如果没有表明这次题目已经答完
					if (null == quizTopic || errorNum >= confignum) {
						// 插入游戏记录表
						// QuizGameRecord quizGameRecord = new QuizGameRecord();
						quizGame.setJobNumber(jobNumber);
						quizGame.setEmpName(empInfo.getEmpName());
						quizGame.setBeginTime(date1);
						quizGame.setEndTime(date2);
						quizGame.setUpdateDate(date2);
						int score = lantenGameService.getTotalScore(recordId);
						quizGame.setScore(score);
						session.removeAttribute("quizGameRecord");
						lantenGameService.updateAnswerRecord(quizGame);
						session.setAttribute("quizGameRecord", quizGame);

						// 更新员工得分表
						int bagCount = 0;
						if (null != empScore.getEmpBadgeCount())
							bagCount = empScore.getEmpBadgeCount().intValue();
						
						if (score > empScore.getScore()) {
							empScore.setScore(score);
							empScore.setUpdateDate(new Date());
						}
						if (score >= medalscore && bagCount < 3) {
							medalflag = "1";
							empScore.setEmpBadgeCount(bagCount + 1);
							IjferUser ijferUser = lantenGameService.checkIsEmpIjferUser(jobNumber,
									empInfo.getEmpName());
							ijferUser.setBadgeCount(ijferUser.getBadgeCount() + 1);
							ijferUser.setUpdateDate(new Date());
							lantenGameService.updateIjferUser(ijferUser);
							// 插入员工勋章表
							UserMedal userMedal = new UserMedal();
							userMedal.setJobNumber(jobNumber);
							userMedal.setEmpName(empInfo.getEmpName());
							userMedal.setBadgeCount(1);
							userMedal.setType(1);
							userMedal.setUpdateDate(new Date());
							lantenGameService.addUserMedal(userMedal);
						}
						lantenGameService.updateEmpScore(empScore);
						String tipMsg = "";
						if (null == quizTopic){
							tipMsg = "题目已经答完，谢谢参与本次答题活动";
						}
						else{
							tipMsg = "错误次数已经达到" + confignum + "次，不能继续答题";
						}
						map.put("totalscore", score);
						map.put("tipMsg", tipMsg);
						map.put("bagCount", bagCount);
						map.put("medalflag", medalflag);
						map.put("medalscore", medalscore);
						return new ModelAndView("/app/lanterngame/LanternGameEnd", map);
					}

					if(!quizTopicReply.getTopicId().equals(quizTopic.getId())){
						map.put("errorReason", "重复答题计答错1次");
					}
					
					return new ModelAndView("/app/lanterngame/lanterngame_fail", map);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@RequestMapping("/showTopFive")
	public ModelAndView showTopFive(ModelMap map, HttpSession session) {
		// 查询前三、自己最好成绩、自己当次成绩
		QuizGameRecord quizGameRecord = (QuizGameRecord) session.getAttribute("quizGameRecord");

		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if (null == empInfo || null == quizGameRecord) {
			map.put("type", "1");
			return new ModelAndView("/app/lanterngame/lanterngame_login", map);
		}
		String jobNumber = empInfo.getJobNumber();
		String id = quizGameRecord.getId();
		EmpScore myBest = null;
		QuizGameRecord myCurrentScore = null;
		List<EmpScore> topThree = null;
		try {
			topThree = lantenGameService.queryEmpScoreTop();
			myBest = lantenGameService.getEmpScoreByJobNum(jobNumber);
			myCurrentScore = lantenGameService.queryQuizGameRecordById(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		List<EmpScore> myBest2 = new ArrayList<EmpScore>();
		List<QuizGameRecord> myCurrentScore2 = new ArrayList<QuizGameRecord>();
		myBest2.add(myBest);
		myCurrentScore2.add(myCurrentScore);
		map.put("topThree", topThree);
		map.put("myBest", myBest2);
		map.put("myCurrentScore", myCurrentScore2);
		return new ModelAndView("/app/lanterngame/LanternGameSort", map);
	}

	@RequestMapping("/addCanPlayCount")
	@ResponseBody
	public void addCanPlayCount(ModelMap map, HttpSession session) {
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		if (null != empInfo) {
			String jobNumber = empInfo.getJobNumber();
			EmpScore empScore = lantenGameService.getEmpScoreByJobNum(jobNumber);
			empScore.setCanPlayCount(empScore.getCanPlayCount() + 1);
			try {
				lantenGameService.updateEmpScore(empScore);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	@RequestMapping("/showTopFour")
	public ModelAndView showTopFour(ModelMap map, HttpSession session) {
		// 查询前三、自己最好成绩
		EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
		EmpScore myBest = null;
		if (null != empInfo) {
			String jobNumber = empInfo.getJobNumber();
			myBest = lantenGameService.getEmpScoreByJobNum(jobNumber);
			List<EmpScore> myBest2 = new ArrayList<EmpScore>();
			myBest2.add(myBest);
			map.put("myBest", myBest2);
		}

		List<EmpScore> topThree = null;
		try {
			topThree = lantenGameService.queryEmpScoreTop();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		map.put("topThree", topThree);
		return new ModelAndView("/app/lanterngame/lanterngame_over", map);
	}
	
}
