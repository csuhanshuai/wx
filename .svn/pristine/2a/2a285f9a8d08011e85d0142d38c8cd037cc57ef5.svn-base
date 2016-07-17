package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.flexWechatMain.model.WeChatWall;
import com.qixin.app.flexWechatMain.service.WeChatWallService;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
@Controller
@RequestMapping("/zjshagnqiang")
public class ShangqqiangController 
{
	@Resource
	private WeChatWallService weChatWallService;
	
	@RequestMapping("/zjminweb/getSqFirstPageList")
	public ModelAndView getSqFirstPageList(HttpServletRequest request,HttpServletResponse response,String gamenumber)
	{
		
	    Map<String,Object> map = new HashMap<String,Object>();
	    int totalPage = 0;
	    try
	    {
	    	Object bido = request.getSession().getAttribute("login_system_user");
		    SystemmgtUser systemUser = (SystemmgtUser) bido;
		    String bid = systemUser.getId();
		    map.put("bid", bid);
		    List<WeChatWall> list = this.weChatWallService.getAll(gamenumber);
		    if(list != null && list.size() > 0)
		    {
		    	if(list.size() % 2 == 0)
		    	{
		    		totalPage = list.size() / 2;
		    	}
		    	else
		    	{
		    		totalPage = list.size() / 2 + 1;
		    	}
		    }
		    map.put("totalPage",totalPage);
		    map.put("gamenumber", gamenumber);
	    }
	    catch(Exception ex)
	    {
	    	CommonLogger.error("getSqFirstPageList出错 :", ex);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
	    }
	    return new ModelAndView("/app/zjsq/shangqiang",map);
	}
	
	@RequestMapping("/zjminweb/geSqList")
	public void getSqList(HttpServletRequest request,HttpServletResponse response, int pageNum, String gamenumber)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();
		int totalPage = 0;
		try 
		{
			out = response.getWriter();
			Object bido = request.getSession().getAttribute("login_system_user");
		    SystemmgtUser systemUser = (SystemmgtUser) bido;
		    String bid = systemUser.getId();
		    map.put("bid", bid);
		    map.put("gamenumber", gamenumber);
		    Query query = new Query();
		    query.setPageSize(10);
		    query.setPage(pageNum);
		    List<WeChatWall> list = this.weChatWallService.getAll(gamenumber);
		    if(list != null && list.size() > 0)
		    {
		    	if(list.size() % query.getPage() == 0)
		    	{
		    		totalPage = list.size() / query.getPage();
		    	}
		    	else
		    	{
		    		totalPage = list.size() / query.getPage() + 1;
		    	}
		    }
		    map.put("totalPage",totalPage);
		    
		    PageFinder<WeChatWall> pf = this.weChatWallService.getAll(gamenumber, query);
		    if(pf != null)
		    {
		    	List<WeChatWall> listwall = pf.getData();
		    	if(listwall != null&& listwall.size() > 0)
		    	{
		    		for(WeChatWall ww: listwall)
		    		{
		    		    sb.append("<b>"+ww.getMsgtxg()+"</b><br>");
		    		}
		    		out.print(sb.toString());
		    	}
		    	else
		    	{
		    	   out.print("<b>等你来参与！</b>");
		    	}
		    }
		    /*
		    if(pageNum == 1)
		    {
		    	out.print("<b>13012345671</b><br><b>13012345672</b><br>");
		    }
		    else if(pageNum == 2)
		    {
		    	out.print("<b>13012345673</b><br><b>13012345674</b><br>");
		    }
		    else if(pageNum == 3)
		    {
		    	out.print("<b>13012345675</b><br><b>13012345676</b><br>");
		    }
		    */
		}
		catch (Exception e) 
		{
		    out.print("<b>系统繁忙，请稍后重试！</b>");
		}
		out.flush();
		out.close();
		
	}
}
