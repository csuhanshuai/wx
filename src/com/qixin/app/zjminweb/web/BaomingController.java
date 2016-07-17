package com.qixin.app.zjminweb.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ExportExcel;
import com.qixin.app.zjminweb.model.Baoming;
import com.qixin.app.zjminweb.service.BaomingService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zjhuodong")
public class BaomingController
{
    @Resource
    public BaomingService baomingService;

    @RequestMapping("/addBaomingForward")
    public ModelAndView addBaomingForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        // 需要加入bid，否则上传组件在页面不可见
        map.put("bid", bid);
        return new ModelAndView("/app/zjhuodong/addbaoming", map);
    }

    @RequestMapping("/zjminweb/addForward")
    public ModelAndView addForward(HttpServletRequest request,
            HttpServletResponse response, String activitiesid, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        // Object bido = request.getSession().getAttribute("login_system_user");
        // SystemmgtUser systemUser = (SystemmgtUser) bido;
        // String bid = systemUser.getId();
        // 需要加入bid，否则上传组件在页面不可见
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);
        return new ModelAndView("/app/zjhuodong/add", map);
    }

    @RequestMapping("/zjminweb/addBaoming")
    public ModelAndView addBaoming(String name, String mobile,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map, String activitiesid, String bid)
    {
        try
        {
            // Object bido =
            // request.getSession().getAttribute("login_system_user");
            // SystemmgtUser systemUser = (SystemmgtUser) bido;
            // String bid = systemUser.getId();

            Baoming baoming = new Baoming();
            baoming.setBizid(bid);
            baoming.setName(name);
            baoming.setMobile(mobile);
            baoming.setActivitiesid(activitiesid);

            this.baomingService.addBaoming(baoming);
            map.put("baoming", baoming);
        }
        catch (Exception e)
        {
            CommonLogger.error("addBaoming出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjhuodong/result", map);
        // return new ModelAndView("redirect:getBaomingList.kq", map);
    }

    @RequestMapping("/getBaomingList")
    public ModelAndView getBaomingList(HttpServletRequest request,
            HttpServletResponse response, Query query, Baoming baoming)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();
            baoming.setBizid(bid);
            PageFinder<Baoming> pageFinder = this.baomingService
                    .getBaomingList(query, baoming);
            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("getBaomingList出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjhuodong/list", map);
    }

    @RequestMapping("/getBaomingListToExcel")
    public void getBaomingList(HttpServletRequest request,
            HttpServletResponse response, Baoming baoming)
    {
        try
        {
            List<Baoming> baominglist = this.baomingService
                    .getBaomingList(baoming);

            String str = CommonTool.getNowDate("yyyyMMddHHmmssSSS") + ".xls";
            String path = request.getSession().getServletContext()
                    .getRealPath("exportfile" + File.separator + str);

            ExportExcel<Baoming> ee = new ExportExcel<Baoming>();
            ee.exportBaoming(baominglist, path);

            ee.download(path, response);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @RequestMapping("/updateBaomingBefore")
    public ModelAndView updateBaomingBefore(HttpServletRequest request,
            HttpServletResponse response, String id, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();
            // 需要加入bid，否则上传组件在页面不可见
            map.put("bid", bid);
            Baoming bm = this.baomingService.getBaomingById(id);
            map.put("baoming", bm);
        }
        catch (Exception ex)
        {
            CommonLogger.error("updateBaomingBefore出错 :", ex);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjhuodong/addbaoming", map);
    }

    @RequestMapping("/updateBaomingById")
    public ModelAndView updateBaomingById(HttpServletRequest request,
            HttpServletResponse response, String id, String activitiesid,
            String name, String mobile, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Baoming bm = this.baomingService.getBaomingById(id);

            if (bm != null)
            {
                bm.setBizid(bid);
                bm.setName(name);
                bm.setMobile(mobile);
                this.baomingService.updateBaoming(bm);
            }
            map.put("activitiesid", activitiesid);
            map.put("baoming", bm);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Coupon出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getBaomingList.kq");
    }

    @RequestMapping("/deleteBaomingById")
    public ModelAndView deleteBaomingById(HttpServletRequest request,
            HttpServletResponse response, String id, String activitiesid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            this.baomingService.deleteBaoming(id);
            map.put("activitiesid", activitiesid);
        }
        catch (Exception e)
        {
            CommonLogger.error("deleteBaomingById 出错:", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);

        }
        return new ModelAndView("redirect:getBaomingList.kq", map);
    }

    @RequestMapping("/zjminweb/checkMobile")
    public void checkMobile(HttpServletRequest request,
            HttpServletResponse response, String mobile, String bid)
    {
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            // Object bido =
            // request.getSession().getAttribute("login_system_user");
            // SystemmgtUser systemUser = (SystemmgtUser) bido;
            // String bid = systemUser.getId();

            Baoming bm = this.baomingService.getBaomingByMobile(bid, mobile);
            if (bm != null)
            {
                out.print("exist");
            }
            else
            {
                out.print("noExist");
            }
        }
        catch (IOException e)
        {
            out.print("");
        }
        out.flush();
        out.close();
    }
}
