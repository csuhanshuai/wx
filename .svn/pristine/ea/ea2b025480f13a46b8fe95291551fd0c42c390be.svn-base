package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Diaoyan;
import com.qixin.app.zjminweb.model.TitleInfo;
import com.qixin.app.zjminweb.model.TitleItems;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.DiaoyanService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;

@Controller
@RequestMapping("/zjdiaoyan")
public class DiaoyanController {
	
	@Resource
	private DiaoyanService diaoyanService;
	
	@Resource
	private ActivitiesService activitiesService;
	
	@RequestMapping("/getDiaoyanList")
	public ModelAndView getDiaoyanList(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			Object bido = request.getSession().getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();
            
            List<Diaoyan> diaoyanList = this.diaoyanService.getDiaoyanListByBid(bid);
            map.put("diaoyanlist", diaoyanList);
            
		}
		catch(Exception ex)
		{
			CommonLogger.error("get diaoyanlist byBid出错 :", ex);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
		
		 return new ModelAndView("/app/zjdiaoyan/list", map);
		//return new ModelAndView("/app/zjdiaoyan/cydiaoyan",map);
		//return new ModelAndView("/app/zjdiaoyan/dati",map);
	}
	
	@RequestMapping("/zjminweb/getDiaoyanListByCondtion")
	public ModelAndView getDiaoyanListByCondtion(HttpServletRequest request, HttpServletResponse response,String bid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
//			Object bido = request.getSession().getAttribute("login_system_user");
//            SystemmgtUser systemUser = (SystemmgtUser) bido;
//            String bid = systemUser.getId();
            
            List<Diaoyan> diaoyanList = this.diaoyanService.getDiaoyanListByBid(bid);
            List<Diaoyan> diaoyanlt = new ArrayList<Diaoyan>();
            for(Diaoyan dy : diaoyanList)
            {
            	if(dy.getStatus().equals("1"))
            	{
            		diaoyanlt.add(dy);
            	}
            }
            map.put("diaoyanlist", diaoyanlt);
            
		}
		catch(Exception ex)
		{
			CommonLogger.error("get diaoyanlist byBid出错 :", ex);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
		
		 //return new ModelAndView("/app/zjdiaoyan/list", map);
		return new ModelAndView("/app/zjdiaoyan/cydiaoyan",map);
		//return new ModelAndView("/app/zjdiaoyan/dati",map);
	}
	
	@RequestMapping("/addDiaoyanForward")
	public ModelAndView addDiaoyanForward(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        map.put("bid",bid);
         
        //String htmlStr = "<tr><td>幸运大抽奖</td><td>大奖</td><td>2014-06-17至2014-06-30</td><td>进行中</td><td id='td_1'><a href='#' onclick='hideDIV(this.id)' id='1_ok'>【选择】</a></td></tr>";
        map.put("relatinActiveHtml", "");
        map.put("selectHtmlStr", "");
        map.put("type", "add");
		return new ModelAndView("/app/zjdiaoyan/adddiaoyan",map);
	}
	
	  @RequestMapping("/addDiaoyan")
	  public ModelAndView addDiaoyan(String openId, String name, String starttime, String endtime, String ImgPath,
			  String keyword,String remark,String relationActive, HttpServletRequest request, Query query)
	  {
		    Map<String,Object> map = new HashMap<String,Object>();
		    try
		    {
			    Object bido = request.getSession().getAttribute("login_system_user");
			    SystemmgtUser systemUser = (SystemmgtUser)bido;
			    String bid = systemUser.getId();
			
			    Diaoyan diaoyan = new Diaoyan();
			    diaoyan.setOpenId(openId);
			    diaoyan.setBizid(bid);
			    diaoyan.setActiveName(name);
			    diaoyan.setImgPath(ImgPath);
			    diaoyan.setActiveStartTime(starttime);
			    diaoyan.setActiveEndTime(endtime);
			    diaoyan.setKeyword(keyword);
			    diaoyan.setRemark(remark);
			    diaoyan.setRelationActive(relationActive);
			    String curTime = DateUtil.format(new Date(),"yyyy-MM-dd");
			    Date cur = DateUtil.getdate(curTime);
			    Date sTime = DateUtil.getdate(starttime);
			    Date eTime = DateUtil.getdate(endtime);
			    if(DateUtil.diffDate(cur, sTime) < 0)
			    {
			    	//未开始
			    	diaoyan.setStatus("0");
			    }
			    else if(DateUtil.diffDate(cur, sTime) >= 0 && DateUtil.diffDate(cur, eTime) <= 0)
			    {
			    	//进行中
			    	diaoyan.setStatus("1");
			    }
			    else if(DateUtil.diffDate(cur, eTime) > 0)
			    {
			    	//已结束
			    	diaoyan.setStatus("2");
			    }
			    else
			    {
			    	diaoyan.setStatus("0");
			    }
			    	
			    diaoyan.setOperationTime(DateUtil.getDate(new Date()));
			    
			    String diaoyanId = this.diaoyanService.addDiaoyan(diaoyan);
			    map.put("id", diaoyanId);
		    }
		    catch(Exception ex)
		    {
		    	CommonLogger.error("addDiaoyan出错 :", ex);
	            map.put("errorMsg", "出错了!");
	            return new ModelAndView("warnframe", map);
		    }
		    
		    //return new ModelAndView("redirect:getDiaoyanList.kq", map);
		    
		    return new ModelAndView("redirect:addquestion.kq",map);
	  }
	  
	  @RequestMapping("/updatediaoyanBefore")
	  public ModelAndView updatediaoyanBefore(HttpServletRequest request, HttpServletResponse response, String id,ModelMap map)
	  {
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
	          Diaoyan diaoyan = this.diaoyanService.getDiaoyanById(id);
	          map.put("diaoyan", diaoyan);
	          map.put("type", "update");
	          
	          //根据relationActiveid获得关联活动
	          String htmlStr = "<tr><td>幸运大抽奖</td><td>大奖</td><td>2014-06-17至2014-06-30</td><td>进行中</td><td id='td_1'><a href='#' onclick='hideDIV(this.id)' id='1_ok'>【选择】</a></td></tr>";
	          map.put("relatinActiveHtml", htmlStr);
	          String selectHtmlStr = "<tr><td>幸运大抽奖</td><td>大奖</td><td>2014-06-17至2014-06-30</td><td>进行中</td><td id='td_1'><a href='#' onclick='hideDIV(this.id)' id='1_ok'>【删除关联】</a></td></tr>";
	          map.put("selectHtmlStr", selectHtmlStr);
	          
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("updatediaoyanBefore出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/adddiaoyan",map);
	  }
	  
	  @RequestMapping("/udpatediaoyan")
	  public ModelAndView updatediaoyan(HttpServletRequest request, HttpServletResponse response,
			  String openId, String name, String starttime, String endtime, String ImgPath,
			  String keyword,String remark,String relationActive,String id)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
			  Diaoyan dy = new Diaoyan();
			  dy.setId(id);
			  dy.setBizid(bid);
			  dy.setActiveName(name);
			  dy.setActiveStartTime(starttime);
			  dy.setActiveEndTime(endtime);
			  dy.setImgPath(ImgPath);
			  dy.setRemark(remark);
			  dy.setRelationActive(relationActive);
			  dy.setKeyword(keyword);
			  dy.setOperationTime(DateUtil.getDateTime(new Date()));
			  String curTime = DateUtil.format(new Date(),"yyyy-MM-dd");
			  Date cur = DateUtil.getdate(curTime);
			  Date sTime = DateUtil.getdate(starttime);
			  Date eTime = DateUtil.getdate(endtime);
			  if(DateUtil.diffDate(cur, sTime) < 0)
			  {
			    	//未开始
			    	dy.setStatus("0");
			  }
			  else if(DateUtil.diffDate(cur, sTime) >= 0 && DateUtil.diffDate(cur, eTime) <= 0)
			  {
			    	//进行中
			    	dy.setStatus("1");
			  }
			  else if(DateUtil.diffDate(cur, eTime) > 0)
			  {
			    	//已结束
			    	dy.setStatus("2");
			  }
			  else
			  {
			    	dy.setStatus("0");
			   }
			  this.diaoyanService.updateDiaoyanById(dy);
			  
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("updatediaoyanBefore出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("redirect:getDiaoyanList.kq");
	  }
	  
	  @RequestMapping("/deletediaoyanById")
	  public ModelAndView deletediaoyanById(HttpServletRequest request,HttpServletResponse response,String id)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  this.diaoyanService.deleteDiaoyanById(id);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("deletediaoyanById出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("redirect:getDiaoyanList.kq");
	  }
	  
	  @RequestMapping("/viewdiaoyanById")
	  public ModelAndView viewdiaoyanById(HttpServletRequest request,HttpServletResponse response,String id)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
	          Diaoyan diaoyan = this.diaoyanService.getDiaoyanById(id);
	          map.put("diaoyan", diaoyan);
	          map.put("type", "view");
	          //根据relationActiveid获得关联活动
	          String selectHtmlStr = ""; 
	          if(diaoyan.getRelationActive() != null && !"".equals(diaoyan.getRelationActive()))
	          {
	        	  Activities act = this.activitiesService.getActivitiesByid(diaoyan.getRelationActive());
	        	  if(act != null)
	        	  {
	        		  selectHtmlStr = "<tr><td>"+act.getName()+"</td><td>"+String.valueOf(act.getStarttime()).substring(0,10)+"至"+String.valueOf(act.getEndtime()).substring(0,10)+"</td><td id='td_"+act.getId()+"'><a href='#' onclick='deleRelation()' id='"+act.getId()+"'>【删除关联】</a></td></tr>";
	        	  }
	          }
	          map.put("selectHtmlStr", selectHtmlStr);
	         
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("updatediaoyanBefore出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/adddiaoyan",map);
	  }
	  
	  @RequestMapping("/addquestion")
	  public ModelAndView addquestion(HttpServletRequest request,HttpServletResponse response,String id)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
	          List<TitleInfo> questionList = this.diaoyanService.getTitleListById(id); 
	          map.put("questionlist", questionList);
	          map.put("relationDiaoyanId", id);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("addquestion出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/addquestion",map);
	  }
	  
	  @RequestMapping("/setquession")
	  public ModelAndView setquession(HttpServletRequest request, HttpServletResponse response, String relationDiaoyanId)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
	          map.put("relationDiaoyanId", relationDiaoyanId);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("setquession出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  
		  return new ModelAndView("/app/zjdiaoyan/setquestion",map);
	  }
	  
	  @RequestMapping("/saveQuesstion")
	  public ModelAndView saveQuesstion(HttpServletRequest request, HttpServletResponse response,String relationDiaoyanId, 
			  String name, String selectA,String selectB, String selectC,String selectD, 
			  String selectE,String selectF, String selectG,String selectH, String selectI,String selectJ,String limit)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          TitleInfo ti = new TitleInfo();
	          ti.setBizid(bid);
	          ti.setRelationDiaoyanId(relationDiaoyanId);
	          ti.setQuestionName(name);
	          ti.setAnwserMaxNum(limit);
	          String titleId = this.diaoyanService.addDiaoyanTitle(ti);
	          
	          List<TitleItems> listItems = new ArrayList<TitleItems>();
	          TitleItems items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectA);
	          items.setSelectedTimes("0");
	          items.setSelectName("selectA");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectB);
	          items.setSelectedTimes("0");
	          items.setSelectName("selectB");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectC != null ? selectC : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectC");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectD != null ? selectD : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectD");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectE != null ? selectE : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectE");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectF != null ? selectF : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectF");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectG != null ? selectG : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectG");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectH != null ? selectH : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectH");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectI != null ? selectI : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectI");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setTitleId(titleId);
	          items.setContent(selectJ != null ? selectJ : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectJ");
	          listItems.add(items);
	          
	          this.diaoyanService.addTitleSelect(listItems);
	          
	          
	          //传到addqueestion.kq对应id参数
	          map.put("id", relationDiaoyanId);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("saveQuesstion出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("redirect:addquestion.kq",map);
	  }
	  
	  @RequestMapping("/deleteTitleById")
	  public ModelAndView deleteTitleById(HttpServletRequest request, HttpServletResponse response,String id,String relationDiaoyanId)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  this.diaoyanService.deleteTitleById(id);
			  //传到addqueestion.kq对应id参数
	          map.put("id", relationDiaoyanId);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("deletediaoyanById出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("redirect:addquestion.kq",map);
	  }
	  
	  @RequestMapping("/updateTitleBefore")
	  public ModelAndView updateTitleBefore(HttpServletRequest request, HttpServletResponse response,String id,String relationDiaoyanId)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  TitleInfo ti = new TitleInfo();
			  ti = this.diaoyanService.getTitleById(id);
			  List<TitleItems> items = this.diaoyanService.getTitleItemsById(ti.getId());
			  String[] content = new String[items.size()];
			  String[] ids = new String[items.size()];
			  for(int i = 0; i < items.size(); i ++)
			  {
				  content[i] = items.get(i).getContent();
				  ids[i] = items.get(i).getId();
			  }
              if(content.length > 0 && ids.length > 0)
              {
            	  ti.setSelectA(content[0]);
    			  ti.setSelectB(content[1]);
    			  ti.setSelectC(content[2]);
    			  ti.setSelectD(content[3]);
    			  ti.setSelectE(content[4]);
    			  ti.setSelectF(content[5]);
    			  ti.setSelectG(content[6]);
    			  ti.setSelectH(content[7]);
    			  ti.setSelectI(content[8]);
    			  ti.setSelectJ(content[9]);
    			  
    			  ti.setSelectAid(ids[0]);
    			  ti.setSelectBid(ids[1]);
    			  ti.setSelectCid(ids[2]);
    			  ti.setSelectDid(ids[3]);
    			  ti.setSelectEid(ids[4]);
    			  ti.setSelectFid(ids[5]);
    			  ti.setSelectGid(ids[6]);
    			  ti.setSelectHid(ids[7]);
    			  ti.setSelectIid(ids[8]);
    			  ti.setSelectJid(ids[9]);
              }
              
			  

			  map.put("titleInfo", ti);
			  map.put("relationDiaoyanId", relationDiaoyanId);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("updateTitleBefore出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/setquestion",map);
	  }
	  
	  @RequestMapping("/updateTitleById")
	  public ModelAndView updateTitleById(HttpServletRequest request, HttpServletResponse response,String id,String relationDiaoyanId, 
			  String name, String selectA,String selectB, String selectC,String selectD, 
			  String selectE,String selectF, String selectG,String selectH, String selectI,String selectJ,String limit,
			  String selectAid,String selectBid,String selectCid,String selectDid,String selectEid,String selectFid,String selectGid,String selectHid,String selectIid,String selectJid)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          TitleInfo ti = new TitleInfo();
	          ti.setId(id);
	          ti.setBizid(bid);
	          ti.setRelationDiaoyanId(relationDiaoyanId);
	          ti.setQuestionName(name);
	          ti.setAnwserMaxNum(limit);
         
	          this.diaoyanService.updateTitleById(ti);
	          
	          List<TitleItems> listItems = new ArrayList<TitleItems>();
	          TitleItems items = new TitleItems();
	          items.setId(selectAid);
	          items.setTitleId(id);
	          items.setContent(selectA);
	          items.setSelectedTimes("0");
	          items.setSelectName("selectA");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectBid);
	          items.setTitleId(id);
	          items.setContent(selectB);
	          items.setSelectedTimes("0");
	          items.setSelectName("selectB");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectCid);
	          items.setTitleId(id);
	          items.setContent(selectC != null ? selectC : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectC");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectDid);
	          items.setTitleId(id);
	          items.setContent(selectD != null ? selectD : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectD");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectEid);
	          items.setTitleId(id);
	          items.setContent(selectE != null ? selectE : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectE");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectFid);
	          items.setTitleId(id);
	          items.setContent(selectF != null ? selectF : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectF");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectGid);
	          items.setTitleId(id);
	          items.setContent(selectG != null ? selectG : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectG");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectHid);
	          items.setTitleId(id);
	          items.setContent(selectH != null ? selectH : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectH");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectIid);
	          items.setTitleId(id);
	          items.setContent(selectI != null ? selectI : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectI");
	          listItems.add(items);
	          
	          items = new TitleItems();
	          items.setId(selectJid);
	          items.setTitleId(id);
	          items.setContent(selectJ != null ? selectJ : "");
	          items.setSelectedTimes("0");
	          items.setSelectName("selectJ");
	          listItems.add(items);
	          
	          this.diaoyanService.upateTitleSelect(listItems);
	          
			  //传到addqueestion.kq对应id参数
	          map.put("id", relationDiaoyanId);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("deletediaoyanById出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("redirect:addquestion.kq",map);
	  }
	  
	  @RequestMapping("/stopdiaoyanById")
	  public ModelAndView stopdiaoyanById(HttpServletRequest request, HttpServletResponse response,String id)
	  {
		  Map<String,Object> map = new HashMap<String,Object>();
		  try
		  {
			  Diaoyan dy = this.diaoyanService.getDiaoyanById(id);
			  dy.setStatus("3");
			  this.diaoyanService.updateDiaoyanById(dy);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("deletediaoyanById出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("redirect:getDiaoyanList.kq");
	  }
	  
	  @RequestMapping("/statdiaoyan")
	  public ModelAndView statdiaoyan(HttpServletRequest request, HttpServletResponse response,String id)
	  {
		  Map<String,Object> map = new HashMap<String, Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
	          
	          //获得题目列表
	          List<TitleInfo> titleList = this.diaoyanService.getTitleListById(id);
	          String titleIds = "";
	          for(TitleInfo t : titleList)
	          {
	        	  titleIds += t.getId() + ",";
	          }
	          if(titleIds.length() > 0)
	          {
	        	  titleIds = titleIds.substring(0,titleIds.length() - 1);
	        	  List<TitleItems> titleItemList = this.diaoyanService.getTitleItemsByIds(titleIds);
	        	  for(TitleInfo t : titleList)
	        	  {
	        		  float total = 0.2f;
     				  int countA = 0;
     				  int countB = 0;
     				  int countC = 0;
     				  int countD = 0;
     				  int countE = 0;
    				  int countF = 0;
    				  int countG = 0;
    				  int countH = 0;
     				  int countI = 0;
     				  int countJ = 0;
 
	        		  for(TitleItems i : titleItemList)
	        		  {
	        			  if(t.getId().equals(i.getTitleId()))
	        			  {
	        				
	        				 if(i.getSelectName().equals("selectA"))
	        				 {
	        					 t.setSelectA(i.getContent());
	        					 t.setSelectAtimes(i.getSelectedTimes());
	        					 countA = Integer.parseInt(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectB"))
	        				 {
	        					 t.setSelectB(i.getContent());
	        					 t.setSelectBtimes(i.getSelectedTimes());
	        					 countB = Integer.parseInt(t.getSelectBtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectC"))
	        				 {
	        					 t.setSelectC(i.getContent());
	        					 t.setSelectCtimes(i.getSelectedTimes());
	        					 countC = Integer.parseInt(t.getSelectCtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectD"))
	        				 {
	        					 t.setSelectD(i.getContent());
	        					 t.setSelectDtimes(i.getSelectedTimes());
	        					 countD = Integer.parseInt(t.getSelectDtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectE"))
	        				 {
	        					 t.setSelectE(i.getContent());
	        					 t.setSelectEtimes(i.getSelectedTimes());
	        					 countE = Integer.parseInt(t.getSelectEtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectF"))
	        				 {
	        					 t.setSelectF(i.getContent());
	        					 t.setSelectFtimes(i.getSelectedTimes());
	        					 countF = Integer.parseInt(t.getSelectFtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectG"))
	        				 {
	        					 t.setSelectG(i.getContent());
	        					 t.setSelectGtimes(i.getSelectedTimes());
	        					 countG = Integer.parseInt(t.getSelectGtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectH"))
	        				 {
	        					 t.setSelectH(i.getContent());
	        					 t.setSelectHtimes(i.getSelectedTimes());
	        					 countH = Integer.parseInt(t.getSelectHtimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectI"))
	        				 {
	        					 t.setSelectI(i.getContent());
	        					 t.setSelectItimes(i.getSelectedTimes());
	        					 countI = Integer.parseInt(t.getSelectItimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectJ"))
	        				 {
	        					 t.setSelectJ(i.getContent());
	        					 t.setSelectJtimes(i.getSelectedTimes());
	        					 countJ = Integer.parseInt(t.getSelectJtimes());
	        				 }
	        			  }
	        		  }
	        		  total = countA + countB + countC + countD + countE + countF +countG + countH +countI + countJ;
	        		  if(total > 0)
	        		  {
	        			  t.setSelectAp(String.valueOf((double)(Math.round(countA/total*100))) + "%");
	        			  t.setSelectBp(String.valueOf((double)(Math.round(countB/total*100))) + "%");
	        			  t.setSelectCp(String.valueOf((double)(Math.round(countC/total*100))) + "%");
	        			  t.setSelectDp(String.valueOf((double)(Math.round(countD/total*100))) + "%");
	        			  t.setSelectEp(String.valueOf((double)(Math.round(countE/total*100))) + "%");
	        			  t.setSelectFp(String.valueOf((double)(Math.round(countF/total*100))) + "%");
	        			  t.setSelectGp(String.valueOf((double)(Math.round(countG/total*100))) + "%");
	        			  t.setSelectHp(String.valueOf((double)(Math.round(countH/total*100))) + "%");
	        			  t.setSelectIp(String.valueOf((double)(Math.round(countI/total*100))) + "%");
	        			  t.setSelectJp(String.valueOf((double)(Math.round(countJ/total*100))) + "%");
	        		  }
	        		  
	        	  }
	          }
	          map.put("titleInfo", titleList);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("deletediaoyanById出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/stat",map);
	  }
	  
	  @RequestMapping("/zjminweb/diaoyandati")
	  public ModelAndView diaoyandati(HttpServletRequest request,HttpServletResponse response,String id)
	  {
		  Map<String,Object> map = new HashMap<String, Object>();
		  try
		  {
//			  Object bido = request.getSession().getAttribute("login_system_user");
//	          SystemmgtUser systemUser = (SystemmgtUser) bido;
//	          String bid = systemUser.getId();
//	          // 需要加入bid，否则上传组件在页面不可见
//	          map.put("bid", bid);
	          
	          //获得题目列表
	          List<TitleInfo> titleList = this.diaoyanService.getTitleListById(id);
	          String titleIds = "";
	          for(TitleInfo t : titleList)
	          {
	        	  titleIds += t.getId() + ",";
	          }
	          if(titleIds.length() > 0)
	          {
	        	  titleIds = titleIds.substring(0,titleIds.length() - 1);
	        	  List<TitleItems> titleItemList = this.diaoyanService.getTitleItemsByIds(titleIds);
	        	  for(TitleInfo t : titleList)
	        	  {
 
	        		  for(TitleItems i : titleItemList)
	        		  {
	        			  if(t.getId().equals(i.getTitleId()))
	        			  {
	        				
	        				 if(i.getSelectName().equals("selectA"))
	        				 {
	        					 t.setSelectA(i.getContent());
	        					 t.setSelectAid(i.getId());
	        					 t.setSelectAtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectB"))
	        				 {
	        					 t.setSelectB(i.getContent());
	        					 t.setSelectBid(i.getId());
	        					 t.setSelectBtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectC"))
	        				 {
	        					 t.setSelectC(i.getContent());
	        					 t.setSelectCid(i.getId());
	        					 t.setSelectCtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectD"))
	        				 {
	        					 t.setSelectD(i.getContent());
	        					 t.setSelectDid(i.getId());
	        					 t.setSelectDtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectE"))
	        				 {
	        					 t.setSelectE(i.getContent());
	        					 t.setSelectEid(i.getId());
	        					 t.setSelectEtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectF"))
	        				 {
	        					 t.setSelectF(i.getContent());
	        					 t.setSelectFid(i.getId());
	        					 t.setSelectFtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectG"))
	        				 {
	        					 t.setSelectG(i.getContent());
	        					 t.setSelectGid(i.getId());
	        					 t.setSelectGtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectH"))
	        				 {
	        					 t.setSelectH(i.getContent());
	        					 t.setSelectHid(i.getId());
	        					 t.setSelectHtimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectI"))
	        				 {
	        					 t.setSelectI(i.getContent());
	        					 t.setSelectIid(i.getId());
	        					 t.setSelectItimes(i.getSelectedTimes());
	        				 }
	        				 else if(i.getSelectName().equals("selectJ"))
	        				 {
	        					 t.setSelectJ(i.getContent());
	        					 t.setSelectJid(i.getId());
	        					 t.setSelectJtimes(i.getSelectedTimes());
	        				 }
	        			  }
	        		  }  
	        	  }
	          }
	          map.put("titleInfo", titleList);
	          
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("stattubiao出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/dati",map);
	  }
	  
	  
	  @RequestMapping("/zjminweb/dydatisave")
	  public ModelAndView dydatisave(HttpServletRequest request, HttpServletResponse response,String resultStr)
	  {
		  Map<String,Object> map = new HashMap<String, Object>();
		  try
		  {
//			  Object bido = request.getSession().getAttribute("login_system_user");
//	          SystemmgtUser systemUser = (SystemmgtUser) bido;
//	          String bid = systemUser.getId();
//	          // 需要加入bid，否则上传组件在页面不可见
//	          map.put("bid", bid);
	          
	          if(resultStr != null && !"".equals(resultStr))
	          {
	        	  String[] str = resultStr.split(";");
	        	  String ids = "";
	        	  for(String s : str)
	        	  {
	        		  ids += s.split("=")[0] + ",";
	        	  }
	        	  if(ids.length() > 0)
	        	  {
	        		  ids = ids.substring(0,ids.length() - 1);
	        		  List<TitleItems> itList = this.diaoyanService.getTitleItemsByItemIds(ids);
	        		  for(TitleItems i : itList)
	        		  {
	        			  for(String idAndTimes : str)
	        			  {
	        				  if(idAndTimes.split("=")[0].equals(i.getId()))
	        				  {
	        					  i.setSelectedTimes(idAndTimes.split("=")[1]);
	        					  this.diaoyanService.updateItemsTimes(i);
	        					  break;
	        				  }
	        			  }
	        		  }
	        	  }
	          }
	          
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("stattubiao出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/thanksdiaoyan");
	  }
	  
	  
	  @RequestMapping("/getRelationHuodong")
	  public void getRelationHuodong(HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		    Map<String,Object> map = new HashMap<String, Object>();
		    PrintWriter out = response.getWriter();
		    StringBuffer sb = new StringBuffer();
		    try
		    {
		    	 Object bido = request.getSession().getAttribute("login_system_user");
		         SystemmgtUser systemUser = (SystemmgtUser) bido;
		         String bid = systemUser.getId();
		         // 需要加入bid，否则上传组件在页面不可见
		         map.put("bid", bid);
		    	 List<Activities> actList = this.activitiesService.getActivities(bid);
		    	 String curTime = DateUtil.format(new Date(),"yyyy-MM-dd");
				 Date cur = DateUtil.getdate(curTime);
		    	 for(Activities act : actList)
		    	 { 
		    		if(DateUtil.diffDate(cur, act.getStarttime()) >= 0 && DateUtil.diffDate(cur, act.getEndtime()) <= 0)
				    {
				    	//进行中
		    			sb.append("<tr><td>"+act.getName()+"</td><td>"+String.valueOf(act.getStarttime()).substring(0,10)+"至"+String.valueOf(act.getEndtime()).substring(0,10)+"</td><td id='td_"+act.getId()+"'><a href='#' onclick='hideDIV(this.id)' id='"+act.getId()+"'>【选择】</a></td></tr>");
				    }
		    	 }
		    	 out.print(sb.toString());
		    }
		    catch(Exception ex)
		    {
		    	out.print("");
		    }
			out.flush();
			out.close();
	  }
	  
	  
	  /*
	  @RequestMapping("/userdata")
	  public ModelAndView userdata(HttpServletRequest request,HttpServletResponse response)
	  {
		  Map<String,Object> map = new HashMap<String, Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("stattubiao出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/stat");
	  }
	  
	  
	  @RequestMapping("/adduserdata")
	  public ModelAndView adduserdata(HttpServletRequest request, HttpServletResponse response,String mobile,String username)
	  {
		  Map<String,Object> map = new HashMap<String, Object>();
		  try
		  {
			  Object bido = request.getSession().getAttribute("login_system_user");
	          SystemmgtUser systemUser = (SystemmgtUser) bido;
	          String bid = systemUser.getId();
	          // 需要加入bid，否则上传组件在页面不可见
	          map.put("bid", bid);
	          
	          DiaoyanUser dy = new DiaoyanUser();
	          dy.setBizid(bid);
	          dy.setMobile(mobile);
	          dy.setName(username);
	          
	          this.diaoyanService.addUserData(dy);
		  }
		  catch(Exception ex)
		  {
			  CommonLogger.error("stattubiao出错 :", ex);
	          map.put("errorMsg", "出错了!");
	          return new ModelAndView("warnframe", map);
		  }
		  return new ModelAndView("/app/zjdiaoyan/stat");
	  } 
	  */
}
