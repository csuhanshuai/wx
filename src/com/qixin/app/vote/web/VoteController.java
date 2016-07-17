package com.qixin.app.vote.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.app.lanterngame.model.EmpInfo;
import com.qixin.app.lanterngame.model.QuizTopic;
import com.qixin.app.lanterngame.model.UserMedal;
import com.qixin.app.lanterngame.service.LanternGameService;
import com.qixin.app.lanterngame.util.ByValueComparator;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.vote.model.Vote;
import com.qixin.app.vote.model.VoteApply;
import com.qixin.app.vote.model.WxVote;
import com.qixin.app.vote.service.VoteService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/vote")
public class VoteController {
	@Resource
	private VoteService voteService;
	@Resource
	private LanternGameService lantenGameService;
	
	
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(){
		//前往登录页面
		return new ModelAndView("/app/lanterngame/lanterngame_login");
	}
	
	//---------------------------vote---------------------------
	@RequestMapping("/getVoteByid")
    public ModelAndView getVoteByid(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
//        Object bido = request.getSession().getAttribute("login_system_user");
//        SystemmgtUser systemUser = (SystemmgtUser) bido;
//        String bid = systemUser.getId();

        try
        {
            Vote vote = this.voteService.getVoteByid(id);
            if (vote == null)
            {
                vote = new Vote();
            }
            map.put("vote", vote);
//            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Vote byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/vote/detail", map);
    }

    @RequestMapping("/removeVote")
    public ModelAndView removeVote(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.voteService.removeVote(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove Vote出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getVote.kq", map);
    }
   
    /**
     * 修改
     * @param request
     * @param response
     * @param type
     * @param id
     * @return
     */
    @RequestMapping("/addVoteForward")
    public ModelAndView addVoteForward(HttpServletRequest request,
            HttpServletResponse response, String type, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        if (!CommonTool.isEmpty(type) && "mod".equals(type)
                && !CommonTool.isEmpty(id))
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            try
            {
                Vote vote = this.voteService.getVoteByid(id);
                if (vote == null)
                {
                    vote = new Vote();
                }
                map.put("vote", vote);
                map.put("bid", bid);
            }
            catch (Exception e)
            {
                CommonLogger.error("get Vote byid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }

        }

        map.put("type", type);
        return new ModelAndView("/app/vote/add", map);
    }

    

    /**
     * 
     * @Title: getVoteList
     * @Description: 
     * @param request 请求对象
     * @param response 返回对象
     * @param bid 微信端传递的查询参数
     * @return 设定文件 ModelAndView 返回类型
     */
    @RequestMapping("/zjminweb/getVoteList")
    public ModelAndView getVoteList(HttpServletRequest request,
            HttpServletResponse response, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            List<Vote> votelist = this.voteService
                    .getVoteByBid(bid);

            if (votelist == null)
            {
                votelist = new ArrayList<Vote>();
            }
            map.put("votelist", votelist);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Vote byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjminweb/Vote", map);
    }

    /**
     * 根据id查询数据
     * @param request
     * @param response
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/getVoteDetailForward/{id}")
    public ModelAndView getVoteDetailForward(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String id, ModelMap map)
    {
        try
        {
        	voteService.getVoteByid(id);
            Vote vote = null;
            if (!CommonTool.isEmpty(id))
            {
                vote = this.voteService.getVoteByid(id);
                if (vote == null)
                {
                    vote = new Vote();
                }
            }
            map.put("vote", vote);
        }
        catch (Exception e)
        {
            CommonLogger.error("get VoteDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/vote/detail");
    }

    @RequestMapping("/updateVote")
    public ModelAndView updateVote(String id, String name, String education,
            String endtime, String sex, String age, String workingplace,
            String pay, String description, String numbers, String workingnum,
            String workingtype, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();
            Vote vote = this.voteService.getVoteByid(id);
            if (vote == null)
            {
                vote = new Vote();
                
                this.voteService.addVote(vote);
            }
            else
            {
                this.voteService.updateVote(vote);
            }

            map.put("Vote", vote);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Vote出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getVote.kq");
    }
    
    
    
    //------------------wxVote----------------------
    //------------------wxVote----------------------
    /**
	 * 投票接口
	 * @throws Throwable 
	 */
    @RequestMapping("/voteAccess")
	public void voteAccess(String sVoteApplyId,HttpServletRequest request,
            HttpServletResponse response) throws Throwable{
		PrintWriter out = response.getWriter();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// 投票成功，wx_vote表增加一条数据
			HttpSession session = request.getSession();
			// 微信投票表
			EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
			//如果游客投票
			if(empInfo==null){
				out.print("[{\"youke\":\"1\"}]");
//				String openID="openId123";
//				List<WxVote> listTemp=this.voteService.getWxvoteByOpenId(openID);
//				if(listTemp!=null&&listTemp.size()>0){
//					out.print("[{\"hasVote\":\"1\"}]");
//				}else{
//					WxVote wxVote = new WxVote();
//					wxVote.setVoteTime(new Date());
//					wxVote.setVoteId(sVoteApplyId);
//					wxVote.setOpenId(openID);
//					this.voteService.addWxVote(wxVote);
//					// 更新汇总表
//					Vote vote = this.voteService.getVote();
//					vote.setVoteTotalCount(vote.getVoteTotalCount() + 1);
//					this.voteService.updateVote(vote);
//					// 更新报名表
//					String svoteApplyIdString = request
//							.getParameter("sVoteApplyId");
//					svoteApplyIdString = com.qixin.app.lanterngame.util.Utils
//							.addZeroForJobNumbe(svoteApplyIdString);
//					VoteApply va = this.voteService
//							.getVoteApplyByCode(svoteApplyIdString);
//					if (va != null) {
//						va.setVoteCount(va.getVoteCount() + 1);
//						this.voteService.updateVoteApply(va);
//						JSONArray award = JSONArray.fromObject(va);
//						out.print(award.toString());
//					} else {
//						out.print("{success:false}");
//					}
//					
//				}
			}else if(empInfo!=null){
				List<WxVote> listTemp=this.voteService.getWxVoteByJobNum(empInfo.getJobNumber());
				if(listTemp!=null&&listTemp.size()>0){
					out.print("[{\"hasVote\":\"1\"}]");
				}else{
					WxVote wxVote = new WxVote();
					if (empInfo != null) {
						wxVote.setEmpNumber(empInfo.getJobNumber());
					}
					wxVote.setVoteTime(new Date());
					wxVote.setVoteId(sVoteApplyId);
					this.voteService.addWxVote(wxVote);
					// 更新汇总表
					Vote vote = this.voteService.getVote();
					vote.setVoteTotalCount(vote.getVoteTotalCount() + 1);
					this.voteService.updateVote(vote);
					// 更新报名表
					String svoteApplyIdString = request
							.getParameter("sVoteApplyId");
					svoteApplyIdString = com.qixin.app.lanterngame.util.Utils
							.addZeroForJobNumbe(svoteApplyIdString);
					VoteApply va = this.voteService
							.getVoteApplyByCode(svoteApplyIdString);
					if (va != null) {
						va.setVoteCount(va.getVoteCount() + 1);
						this.voteService.updateVoteApply(va);
						JSONArray award = JSONArray.fromObject(va);
						out.print(award.toString());
					} else {
						out.print("{success:false}");
					}
				}
			}
			
			
		} catch (IOException e) {
			out.print("{'status':'1'}");
		} finally {
			out.flush();
			out.close();
		}
    }
    
	
	/**
	 * 报名接口
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/voteApply")
	public ModelAndView voteApply(HttpServletRequest request,
            HttpServletResponse response,HttpSession session, VoteApply va) throws Throwable{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			//校验是否报过名
			EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
			VoteApply vaTemp=this.voteService.getVoteApplyByCode(empInfo.getJobNumber());
			if(vaTemp!=null&&vaTemp.getCode()!=null&&!"".equals(vaTemp.getCode())){
				//去首页
				return getIndexInformation(request,response,null);
			}
			Vote vote=this.voteService.getVote();
            vote.setSignCount(vote.getSignCount()+1);
            this.voteService.updateVote(vote);
            //保存图片附件
            String imgUrlHidden = request.getParameter("imgUrlHidden");
    		AttachInfo attachInfo = new AttachInfo();
    		if (imgUrlHidden != null && !"".equals(imgUrlHidden)) {
    			attachInfo.setImgDir(imgUrlHidden);
    			String suff = "jpg";
    			attachInfo.setSuffix(suff);
    			lantenGameService.addAttachInfo(attachInfo);
    			va.setImgId(attachInfo.getId());
    			va.setImgUrl(imgUrlHidden);
    		}
    		 //save 报名的对象
    		
    		
    		va.setCreateTime(new Date());
    		va.setCode(empInfo.getJobNumber());
    		va.setVoteCount(0);
    		va.setStatus(0);
    		va.setName(empInfo.getEmpName());
            this.voteService.saveVoteApply(va);
            
            //插入员工勋章表
			UserMedal userMedal = new UserMedal();
			userMedal.setJobNumber(empInfo.getJobNumber());
			userMedal.setEmpName(empInfo.getEmpName());
			userMedal.setBadgeCount(2);
			userMedal.setType(4);
			userMedal.setUpdateDate(new Date());
			try {
				lantenGameService.addUserMedal(userMedal);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
		} catch (Exception e) {
			CommonLogger.error("update Wx Vote SignCount出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
		//报名成功页面
		return new ModelAndView("/app/vote/vote_applyfinish", map);

	}
	
	
	
	/**
	 * 首页接口（取出参与人数，浏览人数，投票数）
	 * @param request
	 * @param response
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/getIndexInformation")
	public ModelAndView getIndexInformation(HttpServletRequest request,
            HttpServletResponse response,Query query) throws Throwable{
		Map<String, Object> map = new HashMap<String, Object>();
		EmpInfo empInfo = (EmpInfo) request.getSession().getAttribute("empInfo");
		try {
			Vote vote=this.voteService.getVote();
			
			
			boolean fromSearchService="true".equals(request.getAttribute("fromSearchService"));
			if(fromSearchService){
				if(request.getAttribute("voteApplyfromSearchService")!=null){
					PageFinder<VoteApply> pageFinder=(PageFinder)request.getAttribute("voteApplyfromSearchService") ;
					map.put("pageFinder",pageFinder);
				}
				
			}else{
				List<VoteApply> list=this.voteService.getVoteApplyList();
//				for (VoteApply voteApply : list) {
//					String imgId = voteApply.getImgId();
//					if (imgId != null && !"".equals(imgId)) {
//						AttachInfo ai = this.lantenGameService.getAttachInfoById(imgId);
//						voteApply.setImgUrl(ai.getImgDir());
//						System.out.println(voteApply.getImgUrl()+"=====");
//					}
//					voteApplyList.add(voteApply);
//				}
				query = (query != null) ? query : new Query();
				query.setPageSize(6);
				PageFinder<VoteApply> pageFinder=this.voteService.findVoteApplyByPageFinder(query);
				map.put("pageFinder", pageFinder);
				vote.setLookCount(vote.getLookCount()+1);
				this.voteService.updateVote(vote);
			}
			
			map.put("signCount", vote.getSignCount());
			map.put("lookCount", vote.getLookCount());
			map.put("voteTotalCount",vote.getVoteTotalCount());
			
			
			//判断当前用户是否报名
			checkVoteApply(empInfo,map);
			
			//取前3名
			List<VoteApply> list=this.voteService.getVoteApplyList();
			Collections.sort(list, new Comparator<VoteApply>() {  
	            public int compare(VoteApply arg0, VoteApply arg1) {
	            	int iarg0=arg0.getVoteCount()==null?0:arg0.getVoteCount();
	            	int iarg1=arg1.getVoteCount()==null?0:arg1.getVoteCount();
	                return iarg1-iarg0;
	            }  
	        });  
			List<VoteApply> voteApplyList=new ArrayList();
			Map<String,List<VoteApply>> resultMap=new LinkedHashMap<String, List<VoteApply>>();
			
			Set<Integer> numSet = new HashSet();
			Map<Integer,Integer> tempMap=new LinkedHashMap<Integer, Integer>();
			Map<Integer,List<VoteApply>> voteApplyMap=new LinkedHashMap<Integer, List<VoteApply>>();
			for (VoteApply voteApply : list) {
				if (voteApply.getStatus() == null || voteApply.getStatus() != 1) {
					continue;
				}
				if (numSet.size() < 3) {
					numSet.add(voteApply.getVoteCount());
					voteApplyList.add(voteApply);
					Integer k=tempMap.get(voteApply.getVoteCount());
					if(k==null){
						k=0;
					}
					k++;
					tempMap.put(voteApply.getVoteCount(),k);//获得某票的有多少人
					List<VoteApply> tempList=voteApplyMap.get(voteApply.getVoteCount());
					if(tempList==null){
						tempList=new ArrayList();
					}
					tempList.add(voteApply);
					voteApplyMap.put(voteApply.getVoteCount(), tempList);//獲得某票的List
				} else {
					break;
				}
			}
			
			if(numSet.size()==0){
				map.put("resultMap", null);
			}
			
			if(numSet.size()==1){
				resultMap.put("第一名", voteApplyList);
				map.put("resultMap", resultMap);
				
			} else if (numSet.size() == 2) {
				int i=0;
				for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
					i++;
					if(i==1){
						//第一名
						resultMap.put("第一名",voteApplyMap.get(entry.getKey()));
						if(entry.getValue()>=3){
							break;
						}
					}else if(i==2){
						if(resultMap.get("第一名").size()==2){
							
							resultMap.put("第三名", voteApplyMap.get(entry.getKey()));
							
						}else{
							
							resultMap.put("第二名",voteApplyMap.get(entry.getKey()));
							
						}
					}
				}
				map.put("resultMap", resultMap);
			} else if (numSet.size() == 3) {
				int i=0;
				for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
					i++;
					if(i==1){
						//第一名
						resultMap.put("第一名",voteApplyMap.get(entry.getKey()));
						
						if(entry.getValue()>=3){
							
							break;
							
						}
						
					}else if(i==2){
						
						if(resultMap.get("第一名").size()==1){
							
							resultMap.put("第二名", voteApplyMap.get(entry.getKey()));
							
						}else if(resultMap.get("第一名").size()==2){
							
							resultMap.put("第三名", voteApplyMap.get(entry.getKey()));
							break;
							
						}
						
						
					}else if(i==3){
						
						if(resultMap.get("第一名").size()+resultMap.get("第二名").size()==2){
							
							resultMap.put("第三名", voteApplyMap.get(entry.getKey()));
							
							break;
						}
						
					}
					
				}
				map.put("resultMap", resultMap);
			}
			
		} catch (Exception e) {
			map.put("errorMsg", "出错了!");
			e.printStackTrace();
		}
		
		return new ModelAndView("/app/vote/vote_Index", map);
	} 
	
	
	
	
	
	
	
	
	public void checkVoteApply(EmpInfo empInfo,Map<String, Object> map ) throws Throwable{
		if(empInfo==null){
			map.put("hasVoteApply", 2);
		}else{
			VoteApply vaApply=this.voteService.getVoteApplyByCode(empInfo.getJobNumber());
			if(vaApply!=null&&vaApply.getCode()!=null&&!"".equals(vaApply.getCode())){
				map.put("hasVoteApply", 1);
			}else{
				map.put("hasVoteApply", 0);
			}
		}
	}
	
	
	//排行榜接口
		@RequestMapping("/voteApplyRankService")
		public ModelAndView voteApplyRankService(HttpServletRequest request,
	            HttpServletResponse response,HttpSession session) throws Throwable {
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				//取排行榜信息
				
				
				List<VoteApply> list=this.voteService.getVoteApplyList();
				Collections.sort(list, new Comparator<VoteApply>() {  
		            public int compare(VoteApply arg0, VoteApply arg1) {
		            	int iarg0=arg0.getVoteCount()==null?0:arg0.getVoteCount();
		            	int iarg1=arg1.getVoteCount()==null?0:arg1.getVoteCount();
		                return iarg1-iarg0;
		            }  
		        });  
				List<VoteApply> voteApplyList=new ArrayList();
				Map<String,List<VoteApply>> resultMap=new LinkedHashMap<String, List<VoteApply>>();
				
				Set<Integer> numSet = new HashSet();
				Map<Integer,Integer> tempMap=new LinkedHashMap<Integer, Integer>();
				Map<Integer,List<VoteApply>> voteApplyMap=new LinkedHashMap<Integer, List<VoteApply>>();
				for (VoteApply voteApply : list) {
					if (voteApply.getStatus() == null || voteApply.getStatus() != 1) {
						continue;
					}
					if (numSet.size() < 3) {
						numSet.add(voteApply.getVoteCount());
						voteApplyList.add(voteApply);
						Integer k=tempMap.get(voteApply.getVoteCount());
						if(k==null){
							k=0;
						}
						k++;
						tempMap.put(voteApply.getVoteCount(),k);//获得某票的有多少人
						List<VoteApply> tempList=voteApplyMap.get(voteApply.getVoteCount());
						if(tempList==null){
							tempList=new ArrayList();
						}
						tempList.add(voteApply);
						voteApplyMap.put(voteApply.getVoteCount(), tempList);//獲得某票的List
					} else{
						break;
					}
					
				}
				
				
				
				if(numSet.size()==0){
					map.put("resultMap", null);
				}
				
				if(numSet.size()==1){
					resultMap.put("第一名", voteApplyList);
					map.put("resultMap", resultMap);
					
				} else if (numSet.size() == 2) {
					int i=0;
					for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
						i++;
						if(i==1){
							//第一名
							resultMap.put("第一名",voteApplyMap.get(entry.getKey()));
							if(entry.getValue()>=3){
								break;
							}
						}else if(i==2){
							if(resultMap.get("第一名").size()==2){
								
								resultMap.put("第三名", voteApplyMap.get(entry.getKey()));
								
							}else{
								
								resultMap.put("第二名",voteApplyMap.get(entry.getKey()));
								
							}
						}
					}
					map.put("resultMap", resultMap);
				} else if (numSet.size() == 3) {
					int i=0;
					for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
						i++;
						if(i==1){
							//第一名
							resultMap.put("第一名",voteApplyMap.get(entry.getKey()));
							if(entry.getValue()>=3){
								break;
							}
						}else if(i==2){
							
							if(resultMap.get("第一名").size()==1){
								
								resultMap.put("第二名", voteApplyMap.get(entry.getKey()));
								
							}else if(resultMap.get("第一名").size()==2){
								
								resultMap.put("第三名", voteApplyMap.get(entry.getKey()));
								break;
								
							}
							
							
						}else if(i==3){
							
							if(resultMap.get("第一名").size()+resultMap.get("第二名").size()==2){
								
								resultMap.put("第三名", voteApplyMap.get(entry.getKey()));
								
								break;
							}
							
						}
						
					}
					map.put("resultMap", resultMap);
				}
				
				//获取个人的投票信息
				//取当前用户的个人投票信息
				EmpInfo empInfo = (EmpInfo) session.getAttribute("empInfo");
				if (empInfo == null) {
					map.put("luren", 1);
					map.put("hasVoteApply", 1);
				} else {
					map.put("luren", 2);
					checkVoteApply(empInfo, map);
					if (Integer.parseInt(map.get("hasVoteApply").toString()) == 1) {
						VoteApply vote = this.voteService.getVoteApplyByCode(empInfo.getJobNumber());
						map.put("VoteApply", vote);
						if(vote.getStatus()!=null&&vote.getStatus()==1){
							map.put("hasApprove", 1);
						}
					}
					
					 List<WxVote> wxVoteList=this.voteService.getWxVote();
					 WxVote wxVote=null;
					 for (WxVote wxVote1 : wxVoteList) {
						if(wxVote1.getEmpNumber()!=null&&wxVote1.getEmpNumber().equals(empInfo.getJobNumber())){
							wxVote=wxVote1;
						}
					 }
					 
					 if(wxVote!=null){
						 VoteApply va=this.voteService.getVoteApplyByCode(wxVote.getVoteId());
						 map.put("others", va);
					 }
				}
			} catch (Exception e) {
				map.put("errorMsg", "出错了!");
				e.printStackTrace();
			}
			return new ModelAndView("/app/vote/vote_sort", map);
		} 
	
	//搜索接口
	/**
	 * 浏览一次，vote表浏览人数lookCount+1
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/searchService")
	public ModelAndView searchService(HttpServletRequest request,
			HttpServletResponse response,Query query) throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			String inputContent = request.getParameter("inputContent");// input所填内容
			if(inputContent.equals("")){
				return getIndexInformation(request,response,null);
			}
			query = (query != null) ? query : new Query();
			query.setPageSize(6);
			PageFinder<VoteApply> pageFinder=this.voteService.getVoteApplyByCode(inputContent, query);
			request.setAttribute("fromSearchService", "true");
			if (pageFinder.getData()!=null&&pageFinder.getData().size()>0) {
				Vote vote = this.voteService.getVote();
				vote.setLookCount(vote.getLookCount() + 1);
				this.voteService.updateVote(vote);
			}
			request.setAttribute("voteApplyfromSearchService", pageFinder);
		} catch (Exception e) {
			CommonLogger.error("update Wx Vote BrowseCount出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("warnframe", map);
		}
		return getIndexInformation(request,response,null); 
	}
	
	
	
	
	public ModelAndView approveWxVoteApply(HttpServletRequest request,
            HttpServletResponse response, String id){
//		Object bido = request.getSession().getAttribute("login_system_user");
//		SystemmgtUser systemUser = (SystemmgtUser) bido;
//		String bid = systemUser.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Vote vote=this.voteService.getVote();
            vote.setSignCount(vote.getSignCount()+1);
            this.voteService.updateVote(vote);
//            this.voteService.getv
            //save 报名的对象
		} catch (Exception e) {
			CommonLogger.error("update Wx Vote SignCount出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
		//报名成功页面
		return new ModelAndView("/app/...", map);
	}
	
	
	/**
	 * 投票审核成功
	 * vote表修改人数，审核通过人数passCount+1
	 * vote_apply表status状态改为已审核通过
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateWxVotePassCount")
	public ModelAndView updateWxVotePassnum(HttpServletRequest request,
            HttpServletResponse response, String id){
		Object bido = request.getSession().getAttribute("login_system_user");
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		int status;
		try {
			//vote表passCount增1
			Vote vote = this.voteService.getVoteByid(id);
            vote.setPassCount(vote.getPassCount()+1);
            this.voteService.updateVote(vote);
            
//            status=this.voteService.
		} catch (Exception e) {
			CommonLogger.error("update Wx Vote PassCount出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
//		if(status==1){
			//修改成功，返回显示页面
			return new ModelAndView("redirect:getWxVote.kq");
//		}else{
//			return new ModelAndView("warnframe", map);
//		}
	}
	
	/**
	 * 根据id获取wx_vote表的投票数据
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/getWxVoteByid")
	public ModelAndView getWxVoteById(HttpServletRequest request,
            HttpServletResponse response, String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			WxVote wxVote=voteService.getWxvoteByid(id);
			//取出微信投票对象存入map
			map.put("wxVote", wxVote);
		} catch (Exception e) {
			CommonLogger.error("get WxVote byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
		//转到投票记录显示页面
		return new ModelAndView("/app/...", map);
	}
	
	
	/**
	 * 获取所有投票信息
	 * @return
	 */
	@RequestMapping("/getWxVote")
	public ModelAndView getWxVote(HttpServletRequest request,
            HttpServletResponse response, Query query){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WxVote> wxvote=new ArrayList<WxVote>();
		try {
			//取出所有记录放入集合
			wxvote=this.voteService.getWxVote();
		} catch (Exception e) {
			CommonLogger.error("get WxVote出错 :", e);
			e.printStackTrace();
		}
		map.put("wxvote",wxvote);
		//返回页面
		return new ModelAndView("/app/wxvote/list", map);
	}
	
	/**
	 * 根据vote_apply表voteId查询对应的wx_vote表的记录
	 * 获取投票记录集合
	 * 显示投票结果页面
	 * @param request
	 * @param response
	 * @param query
	 * @param voteId
	 * @return
	 */
	@RequestMapping("/getWxVoteByVoteId")
	public ModelAndView getWxVoteByVoteId(HttpServletRequest request,
            HttpServletResponse response, Query query,String voteId){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WxVote> wxvotes=new ArrayList<WxVote>();
		try {
			wxvotes=this.voteService.getWxVoteByVoteId(voteId);
		} catch (Exception e) {
			CommonLogger.error("get WxVote By VoteId出错 :", e);
			e.printStackTrace();
		}
		map.put("wxvotes", wxvotes);
		//返回显示投票详细信息页面
		return new ModelAndView("/app/wxvote/list", map);
	}
	
	@RequestMapping("/voteApplyIndex")
	public ModelAndView voteApplyIndex(HttpServletRequest request,
            HttpServletResponse response, Query query){
		//这里要加一个判断是否报名
		Map<String, Object> map = new HashMap<String, Object>();
		EmpInfo empInfo2 = (EmpInfo) request.getSession().getAttribute("empInfo");
		try {
			checkVoteApply(empInfo2,map);
		} catch (Throwable e) {
			map.put("errorMsg", "出错了!");
			e.printStackTrace();
		}
		return new ModelAndView("/app/vote/vote_apply",map);
	}
	
	
	
	
	/**
	 * 审核详情
	 */
	@RequestMapping("/getShenheDetail/{id}")
    public ModelAndView getShenheDetail(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String id, ModelMap map)
    {
		 try
	        {
	            VoteApply voteApply = null;
	            if (!CommonTool.isEmpty(id))
	            {
	            	voteApply = this.voteService.getVoteApplyByID(id);
	                if (voteApply == null)
	                {
	                	voteApply = new VoteApply();
	                }
	            }
	            map.put("voteApply", voteApply);
	        }
        catch (Exception e)
        {
            CommonLogger.error("get shenheDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/vote/shenhe_detail",map);
    }
	/**
	 * 审核通过
	 */
	@RequestMapping("/approveWxVoteApply")
    public void approveWxVoteApply(String id, String checkId,HttpServletRequest request,HttpServletResponse response,
            String activitiesid) throws Exception
    {
		Object bido = request.getSession().getAttribute("login_system_user");
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		String name=systemUser.getUsername();
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            //vote表passCount增1
			Vote vote = this.voteService.getVote();
            vote.setPassCount(vote.getPassCount()+1);
            this.voteService.updateVote(vote);
            
            VoteApply voteApply=this.voteService.getVoteApplyByID(id);

            voteApply.setCheckTime(new Date());
            
            voteApply.setStatus(1);
            //修改审核状态，审核人id，审核时间
            voteApply.setCheckId(bid);
            voteApply.setCheckName(name);
            //当前系统时间
            voteApply.setCheckTime(new Date());

            voteService.saveVoteApply(voteApply);

                JSONArray result = JSONArray.fromObject(voteApply);

                out.print(result.toString());

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
	/**
	 * 审核不通过
	 * @param id
	 * @param response
	 * @param activitiesid
	 * @throws Exception
	 */
	@RequestMapping("/approveWxVoteApply1")
    public void approveWxVoteApply1(String id,HttpServletResponse response,HttpServletRequest request,
            String activitiesid) throws Exception
    {
		Object bido = request.getSession().getAttribute("login_system_user");
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		String name=systemUser.getUsername();
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            //vote表passCount减1
			//Vote vote = this.voteService.getVote();
            //vote.setPassCount(vote.getPassCount()-1);
            //this.voteService.updateVote(vote);
            VoteApply voteApply = voteService.getVoteApplyByID(id);
            voteApply.setStatus(2);//2
            voteApply.setCheckId(bid);
            voteApply.setCheckName(name);
            voteApply.setCheckTime(new Date());
            voteService.saveVoteApply(voteApply);

                JSONArray result = JSONArray.fromObject(voteApply);

                out.print(result.toString());

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
	/**
	 * * 获取所有报名（投票）信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getVoteApplyAll")
	public ModelAndView getVoteApplyAll(HttpServletRequest request,
            HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<VoteApply> voteApplys=this.voteService.getVoteApplyList();
			map.put("voteApplys", voteApplys);
		} catch (Exception e) {
			map.put("errorMsg", "出错了!");
			e.printStackTrace();
		}
		return new ModelAndView("/app/vote/vote_shenhe", map);
	}
	
	/**
	 * * 获取所有报名审核已通过信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getVoteApplyPass")
	public ModelAndView getVoteApplyPass(HttpServletRequest request,
            HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<VoteApply> voteApplys=this.voteService.getVoteApplyPass();
			map.put("voteApplys", voteApplys);
		} catch (Exception e) {
			map.put("errorMsg", "出错了!");
			e.printStackTrace();
		}
		return new ModelAndView("/app/vote/vote_info", map);
	}
	
	
	
	/**
	 * 活动说明接口
	 * @throws Throwable 
	 */
	@RequestMapping("/activitesInfomation")
	public ModelAndView activitesInfomation(HttpServletRequest request,
            HttpServletResponse response) throws Throwable{
		Map<String, Object> map = new HashMap<String, Object>();
		

		EmpInfo empInfo = (EmpInfo) request.getSession().getAttribute("empInfo");
		this.checkVoteApply(empInfo, map);
		return new ModelAndView("/app/vote/vote_Introduce", map);
	}
	
	/**
	 * 投票分页详情
	 */
	@RequestMapping("/getVoteDetail")
	public ModelAndView getVoteDetail(ModelMap map, HttpServletRequest request,String id,Query query) throws Exception{
				query = (query != null) ? query : new Query();
				query.setPageSize(10);
//				Object bido = request.getSession().getAttribute("login_system_user");
//				SystemmgtUser systemUser = (SystemmgtUser) bido;
//				String bid = systemUser.getId();
                try
                {
                	//System.out.println(id+"****");
                	PageFinder<WxVote> pageFinder = voteService.findWxVoteByPageFinder(id,query);
        			map.put("type", "wxVoteList");
        			map.put("pageFinder", pageFinder);
        			map.put("voteApplyId", id);
        			//System.out.println(map.get("voteApplyId")+"=======");
                }
                catch (Exception e)
                {
                	CommonLogger.error("get getVoteDetailFy出错 :", e);
        			map.put("errorMsg", "出错了!");
        			return new ModelAndView("warnframe", map);
                }
                return new ModelAndView("/app/vote/vote_info_detail",map);
      }
}