package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.customlink.model.CustomLink;
import com.qixin.app.customlink.service.CustomLinkService;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.systemlink.model.SystemLink;
import com.qixin.app.systemlink.service.SystemLinkService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class ActivitiesController
{
    @Resource
    private ActivitiesService activitiesservice;

    @Resource
    private SystemLinkService slinkService;

    @Resource
    private CustomLinkService clinkService;

    @Resource
    private MemberlevelService memberlevelservices;

    @Resource
    private MemberService memberservice;

    @RequestMapping("/getActivities")
    public ModelAndView getActivities(HttpServletRequest request,
            HttpServletResponse response, Query query, String type)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            PageFinder<Activities> pageFinder = this.activitiesservice
                    .getActivitiesByBid(query, bid, type);
            map.put("pageFinder", pageFinder);

        }
        catch (Exception e)
        {
            CommonLogger.error("get Activities byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("type", type);
        return new ModelAndView("/app/zjactivities/list", map);
    }

    @RequestMapping("/addActivitiesForward")
    public ModelAndView addActivitiesForward(HttpServletRequest request,
            HttpServletResponse response, String type, String id)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            if (type != null && !"".equals(type) && "mod".equals(type)
                    && id != null && !"".equals(id))
            {

                Activities activities = this.activitiesservice
                        .getActivitiesByid(id);
                if (activities == null)
                {
                    activities = new Activities();
                }
                map.put("activities", activities);
                map.put("bid", bid);

            }

            // 查询所有自定义链接
            List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
            map.put("clinks", links);
            List<SystemLink> syslinks = slinkService.getAll(bid);
            map.put("slinks", syslinks);

            // 查询会员级别
            map.put("memberlevellist",
                    this.memberlevelservices.getMemberlevelByBid(bid));

        }
        catch (Exception e)
        {
            CommonLogger.error("add activities 出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        map.put("type", type);

        // 需要加入bid，否则上传组件在页面不可见
        map.put("bid", bid);

        return new ModelAndView("/app/zjactivities/add", map);
    }

    @RequestMapping("/addActivities")
    public ModelAndView addActivities(String ImgPath, String name,
            String description, String url, String starttime, String endtime,
            String type, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String memberlevel)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Activities msg = new Activities();
            msg.setPhotourl(ImgPath);
            msg.setDescription(description);
            msg.setName(name);
            msg.setBizid(bid);
            msg.setUrl(url);
            msg.setStarttime(CommonTool.conversionDate(starttime, "yyyy-MM-dd"));
            msg.setEndtime(CommonTool.conversionDate(endtime, "yyyy-MM-dd"));
            msg.setType(CommonTool.isEmpty(type) ? "0" : type);
            msg.setMemberlevelid(memberlevel);
            this.activitiesservice.addActivities(msg);
            map.put("retailstore", msg);
        }
        catch (Exception e)
        {
            CommonLogger.error("add Activities出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getActivities.kq");
    }

    @RequestMapping("/removeActivities")
    public ModelAndView removeActivities(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.activitiesservice.removeActivities(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove activities出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getActivities.kq", map);
    }

    @RequestMapping("/updateActivities")
    public ModelAndView updateActivities(String id, String ImgPath,
            String name, String description, String url, String starttime,
            String endtime, String type, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String memberlevel)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Activities activities = this.activitiesservice
                    .getActivitiesByid(id);

            if (activities == null)
            {
                activities = new Activities();

                activities.setPhotourl(ImgPath);
                activities.setDescription(description);
                activities.setName(name);
                activities.setUrl(url);
                activities.setBizid(bid);
                activities.setId(id);
                activities.setStarttime(CommonTool.conversionDate(starttime,
                        "yyyy-MM-dd"));
                activities.setEndtime(CommonTool.conversionDate(endtime,
                        "yyyy-MM-dd"));
                activities.setType(type);
                activities.setMemberlevelid(memberlevel);
                this.activitiesservice.addActivities(activities);
            }
            else
            {

                activities.setPhotourl(ImgPath);
                activities.setDescription(description);
                activities.setName(name);
                activities.setUrl(url);
                activities.setBizid(bid);
                activities.setStarttime(CommonTool.conversionDate(starttime,
                        "yyyy-MM-dd"));
                activities.setEndtime(CommonTool.conversionDate(endtime,
                        "yyyy-MM-dd"));
                activities.setType(type);
                activities.setMemberlevelid(memberlevel);
                this.activitiesservice.updateActivities(activities);
            }

            map.put("activities", activities);
        }
        catch (Exception e)
        {
            CommonLogger.error("update activities出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getActivities.kq");
    }

    @RequestMapping("/getActivitiesDetailForward/{id}")
    public ModelAndView getActivitiesDetailForward(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String id, ModelMap map)
    {
        try
        {
            Activities activities = null;
            if (!CommonTool.isEmpty(id))
            {
                activities = this.activitiesservice.getActivitiesByid(id);
                if (activities == null)
                {
                    activities = new Activities();
                }
            }
            map.put("activities", activities);
        }
        catch (Exception e)
        {
            CommonLogger.error("get ActivitiesDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjactivities/detail");
    }

    @RequestMapping("/zjminweb/getActivitiesList")
    public ModelAndView getActivitiesList(HttpServletRequest request,
            HttpServletResponse response, String bid, String memberid,
            String openid)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            if (CommonTool.isEmpty(bid))
            {
                Object bido = request.getSession().getAttribute(
                        "login_system_user");
                SystemmgtUser systemUser = (SystemmgtUser) bido;
                bid = systemUser.getId();
            }

            List<Activities> activitieslist = this.activitiesservice
                    .getActivities(bid);
            map.put("activitieslist", activitieslist);

        }
        catch (Exception e)
        {
            CommonLogger.error("get activities byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("memberid", memberid);
        map.put("openid", openid);
        return new ModelAndView("/app/zjminweb/activities", map);
    }

    @RequestMapping("/getActivitiesBytype")
    public void getActivitiesBytype(HttpServletRequest request,
            HttpServletResponse response, String activitiestype)
    {
        PrintWriter out = null;
        Response<List<Activities>> resp = new Response<List<Activities>>();
        try
        {
            out = response.getWriter();

            if (CommonTool.isEmpty(activitiestype))
            {
                CommonLogger.info("输入参数为空");
                resp.setResult("error");
                resp.setMessage("输入参数为空！");
            }
            else
            {
                Object bido = request.getSession().getAttribute(
                        "login_system_user");
                SystemmgtUser systemUser = (SystemmgtUser) bido;
                String bid = systemUser.getId();

                List<Activities> activitieslist = this.activitiesservice
                        .getActivitiesBytype(bid, activitiestype);

                if (CommonTool.isEmpty(activitieslist))
                {
                    CommonLogger.info("没有查询到记录");
                    resp.setResult("error");
                    resp.setMessage("查询无数据！");
                }
                else
                {

                    resp.setResult("success");
                    resp.setT(activitieslist);
                    resp.setMessage("operate ok!");

                    CommonLogger.info("查询活动列表成功！返回对象：" + resp.toString());
                }
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("get getMember ByCondition出错 :", e);
            resp.setResult("error");
            resp.setMessage("操作失败!");
            out.print(JSONObject.fromObject(resp).toString());
        }
        finally
        {
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/zjminweb/isInMemberlevel")
    public void isInMemberlevel(HttpServletRequest request,
            HttpServletResponse response, String bid, String openid,
            String activitiesid)
    {
        PrintWriter out = null;
        Response<List<Activities>> resp = new Response<List<Activities>>();
        try
        {
            out = response.getWriter();

            if (CommonTool.isEmpty(activitiesid) || CommonTool.isEmpty(openid)
                    || CommonTool.isEmpty(bid))
            {
                CommonLogger.info("输入参数为空");
                resp.setResult("error");
                resp.setMessage("您级别不够，无权限参与！");
            }
            else
            {

                Activities activities = this.activitiesservice
                        .getActivitiesByid(activitiesid);

                if (activities == null)
                {
                    CommonLogger.info("没有查询到记录");
                    resp.setResult("error");
                    resp.setMessage("您级别不够，无权限参与！");
                }
                else
                {

                    // 判断会员级别
                    Member member = this.memberservice
                            .getMemberByOpenid(openid);

                    Memberlevel ml = null;
                    if (activities != null
                            && !CommonTool.isEmpty(activities
                                    .getMemberlevelid()))
                    {
                        ml = this.memberlevelservices
                                .getMemberlevelByid(activities
                                        .getMemberlevelid());
                    }
                    if (!ServiceTool.isInMemberlevel(member, ml))
                    {
                        resp.setResult("error");

                        CommonLogger.info("您级别不够，无权限领取");
                        resp.setMessage("您级别不够，无权限参与！");

                    }
                    else
                    {
                        resp.setResult("success");
                        resp.setMessage("operate ok!");

                    }

                    CommonLogger.info("查询活动列表成功！返回对象：" + resp.toString());
                }
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("isInMemberlevel出错 :", e);
            resp.setResult("error");
            resp.setMessage("您级别不够，无权限参与！");
            out.print(JSONObject.fromObject(resp).toString());
        }
        finally
        {
            out.flush();
            out.close();
        }
    }
}
