package com.qixin.app.lanterngame.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.lanterngame.model.ActInfo;
import com.qixin.app.lanterngame.model.AttachInfo;
import com.qixin.app.lanterngame.service.LanternGameService;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
@Controller
@RequestMapping("/actInfoManage")
public class ActInfoManageController {
	@Resource
	private LanternGameService lantenGameService;
	@RequestMapping("/toManagePage")
	public  ModelAndView toManagePage(HttpServletRequest request,ModelMap map){
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        map.put("bid", bid);
         
		return new ModelAndView("/app/actinfomanage/add",map);
	}
	@RequestMapping("/saveActInfo")
	public ModelAndView saveActInfo(String beginTime,String endTime,HttpServletRequest request,ModelMap map,ActInfo actInfo,HttpSession session){
		//添加活动信息
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        map.put("bid", bid);
        actInfo.setCreatedDate(new Date());
        actInfo.setUpdateDate(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        AttachInfo attachInfo = new AttachInfo();
        attachInfo.setCreatedDate(new Date());
        attachInfo.setImgDir(actInfo.getImgDirec());
        attachInfo.setSuffix(actInfo.getImgDirec().substring(actInfo.getImgDirec().length()-4));
        attachInfo.setUpdateDate(new Date());
        try {
        	lantenGameService.addAttachInfo(attachInfo);
        	actInfo.setImgId(attachInfo.getId());
        	actInfo.setBeginTime(sdf.parse(beginTime));
        	actInfo.setEndTime(sdf.parse(endTime));
			lantenGameService.saveActInfo(actInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:toListActInfo.kq",map);
	}
	@RequestMapping("/toListActInfo")
	public ModelAndView toListActInfo(HttpServletRequest request, HttpServletResponse response, Query query){
		Map<String, Object> map = new HashMap<String, Object>();
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
       
        query = (query != null) ? query : new Query();
        query.setPageSize(10);
        try {
        	PageFinder<ActInfo> pageFinder = lantenGameService.findActInfoByPageFinder(query);
            map.put("pageFinder", pageFinder);
		} catch (Exception e) {
			CommonLogger.error("get Activities byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
		}
        map.put("bid", bid);
       
		return new ModelAndView("/app/actinfomanage/list",map);
	}
	@RequestMapping("/getActInfoDetailForward/{id}")
    public ModelAndView getActInfoDetailForward(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String id, ModelMap map)
    {
        try
        {
            ActInfo actInfo = null;
            if (!CommonTool.isEmpty(id))
            {
                actInfo = lantenGameService.getActInfoById(id);
                if (actInfo == null)
                {
                	actInfo = new ActInfo();
                }
            }
            map.put("actInfo", actInfo);
        }
        catch (Exception e)
        {
            CommonLogger.error("get ActivitiesDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/actinfomanage/detail");
    }
	@RequestMapping("/toUpdateActInfo")
	public ModelAndView toUpdateActInfo(HttpServletRequest request, ModelMap map,String id){
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        map.put("bid", bid);
        try {
			ActInfo actInfo = lantenGameService.getActInfoById(id);
			map.put("actInfo", actInfo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        return new ModelAndView("/app/actinfomanage/update",map);
	}
	@RequestMapping("/updateActInfo")
	public ModelAndView updateActInfo(String beginTime,String endTime,HttpServletRequest request, ModelMap map,String id,ActInfo actInfo){
		
		Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        map.put("bid", bid);
        try {
			ActInfo actInfo2 = lantenGameService.getActInfoById(id);
			AttachInfo attachInfo = lantenGameService.getAttachInfoById(actInfo2.getImgId());
			
			actInfo2.setTitle(actInfo.getTitle());
			actInfo2.setImgDirec(actInfo.getImgDirec());
			actInfo2.setBeginTime(sdf.parse(beginTime));
        	actInfo2.setEndTime(sdf.parse(endTime));
        	actInfo2.setContent(actInfo.getContent());
        	actInfo2.setUpdateDate(new Date());
        	lantenGameService.updateActInfo(actInfo2);
        	attachInfo.setImgDir(actInfo.getImgDirec());
        	attachInfo.setUpdateDate(new Date());
        	lantenGameService.updateAttachInfo(attachInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return new ModelAndView("redirect:toListActInfo.kq",map);
	}
	@RequestMapping("/removeActInfo")
	public ModelAndView removeActInfo(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try
        {
            boolean result = lantenGameService.removActInfo(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove activities出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
		return new ModelAndView("redirect:toListActInfo.kq",map);
	}
	
}
