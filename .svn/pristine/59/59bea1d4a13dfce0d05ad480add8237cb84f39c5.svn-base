package com.qixin.app.zjminweb.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Zhaopin;
import com.qixin.app.zjminweb.service.ZhaopinService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class ZhaopinController
{
    @Resource
    private ZhaopinService zhaopinservice;

    @RequestMapping("/getZhaopinByid")
    public ModelAndView getZhaopinByid(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        try
        {
            Zhaopin zhaopin = this.zhaopinservice.getZhaopinByid(id);
            if (zhaopin == null)
            {
                zhaopin = new Zhaopin();
            }
            map.put("zhaopin", zhaopin);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get zhaopin byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjzhaopin/detail", map);
    }

    @RequestMapping("/removeZhaopin")
    public ModelAndView removeZhaopin(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.zhaopinservice.removeZhaopin(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove zhaopin出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getZhaopin.kq", map);
    }

    @RequestMapping("/getZhaopin")
    public ModelAndView getZhaopin(HttpServletRequest request,
            HttpServletResponse response, Query query)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            PageFinder<Zhaopin> pageFinder = this.zhaopinservice
                    .getZhaopinByBid(query, bid);
            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get zhaopin byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjzhaopin/list", map);
    }

    @RequestMapping("/addZhaopinForward")
    public ModelAndView addZhaopinForward(HttpServletRequest request,
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
                Zhaopin zhaopin = this.zhaopinservice.getZhaopinByid(id);
                if (zhaopin == null)
                {
                    zhaopin = new Zhaopin();
                }
                map.put("zhaopin", zhaopin);
                map.put("bid", bid);
            }
            catch (Exception e)
            {
                CommonLogger.error("get zhaopin byid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }

        }

        map.put("type", type);
        return new ModelAndView("/app/zjzhaopin/add", map);
    }

    @RequestMapping("/addZhaopin")
    public ModelAndView addZhaopin(String name, String education,
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
            Zhaopin zhaopin = new Zhaopin();
            zhaopin.setName(name);
            zhaopin.setEducation(education);
            zhaopin.setEndtime(endtime);
            zhaopin.setSex(sex);
            zhaopin.setAge(age);
            zhaopin.setWorkingplace(workingplace);
            zhaopin.setPay(pay);
            zhaopin.setDescription(description);
            zhaopin.setNumbers(numbers);
            zhaopin.setWorkingnum(workingnum);
            zhaopin.setWorkingtype(workingtype);
            zhaopin.setBizid(bid);
            this.zhaopinservice.addZhaopin(zhaopin);
            map.put("zhaopin", zhaopin);
        }
        catch (Exception e)
        {
            CommonLogger.error("add zhaopin出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getZhaopin.kq");
    }

    /**
     * 微官网查询招聘信息使用
     * 
     * @Title: getZhaopinList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request 请求对象
     * @param response 返回对象
     * @param bid 微信端传递的查询参数
     * @return 设定文件 ModelAndView 返回类型
     */
    @RequestMapping("/zjminweb/getZhaopinList")
    public ModelAndView getZhaopinList(HttpServletRequest request,
            HttpServletResponse response, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            List<Zhaopin> zhaopinlist = this.zhaopinservice
                    .getZhaopinByBid(bid);

            if (zhaopinlist == null)
            {
                zhaopinlist = new ArrayList<Zhaopin>();
            }
            map.put("zhaopinlist", zhaopinlist);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get zhaopin byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjminweb/zhaopin", map);
    }

    @RequestMapping("/getZhaopinDetailForward/{id}")
    public ModelAndView getZhaopinDetailForward(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String id, ModelMap map)
    {

        try
        {
            Zhaopin zhaopin = null;
            if (!CommonTool.isEmpty(id))
            {
                zhaopin = this.zhaopinservice.getZhaopinByid(id);
                if (zhaopin == null)
                {
                    zhaopin = new Zhaopin();
                }
            }
            map.put("zhaopin", zhaopin);
        }
        catch (Exception e)
        {
            CommonLogger.error("get ZhaopinDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjzhaopin/detail");
    }

    @RequestMapping("/updateZhaopin")
    public ModelAndView updateZhaopin(String id, String name, String education,
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

            Zhaopin zhaopin = this.zhaopinservice.getZhaopinByid(id);

            if (zhaopin == null)
            {
                zhaopin = new Zhaopin();
                zhaopin.setId(id);
                zhaopin.setName(name);
                zhaopin.setEducation(education);
                zhaopin.setEndtime(endtime);
                zhaopin.setSex(sex);
                zhaopin.setAge(age);
                zhaopin.setWorkingplace(workingplace);
                zhaopin.setPay(pay);
                zhaopin.setDescription(description);
                zhaopin.setNumbers(numbers);
                zhaopin.setWorkingnum(workingnum);
                zhaopin.setWorkingtype(workingtype);
                zhaopin.setBizid(bid);
                this.zhaopinservice.addZhaopin(zhaopin);
            }
            else
            {
                zhaopin.setName(name);
                zhaopin.setEducation(education);
                zhaopin.setEndtime(endtime);
                zhaopin.setSex(sex);
                zhaopin.setAge(age);
                zhaopin.setWorkingplace(workingplace);
                zhaopin.setPay(pay);
                zhaopin.setDescription(description);
                zhaopin.setNumbers(numbers);
                zhaopin.setWorkingnum(workingnum);
                zhaopin.setWorkingtype(workingtype);
                zhaopin.setBizid(bid);
                this.zhaopinservice.updateZhaopin(zhaopin);
            }

            map.put("zhaopin", zhaopin);
        }
        catch (Exception e)
        {
            CommonLogger.error("update zhaopin出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getZhaopin.kq");
    }
}
