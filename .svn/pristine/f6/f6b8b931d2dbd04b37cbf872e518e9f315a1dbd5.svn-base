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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.platform.log.CommonLogger;

@Controller
@RequestMapping("/zj")
public class MemberlevelController
{
    @Resource
    private MemberlevelService memberlevelservice;

    @RequestMapping("/getMemberlevel")
    public ModelAndView getMemberlevel(HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {
                List<Memberlevel> memberlevellist = this.memberlevelservice
                        .getMemberlevelByBid(bid);
                map.put("memberlevellist", memberlevellist);

            }
            catch (Exception e)
            {
                CommonLogger.error("get Memberlevel byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("/app/zjmemberlevel/list", map);
    }

    @RequestMapping("/updateMemberlevelForward")
    public ModelAndView updateMemberlevelForward(HttpServletRequest request,
            HttpServletResponse response, String id)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {
                Memberlevel memberlevel = this.memberlevelservice
                        .getMemberlevelByBid(bid, id);
                map.put("memberlevel", memberlevel);

            }
            catch (Exception e)
            {
                CommonLogger.error("get Memberlevel byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("/app/zjmemberlevel/modify", map);
    }

    @RequestMapping("/updateMemberlevel")
    public ModelAndView updateMemberlevel(HttpServletRequest request,
            HttpServletResponse response, String id, String start, String end)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {

                Memberlevel memberlevel = this.memberlevelservice
                        .getMemberlevelByBid(bid, id);
                if (memberlevel != null)
                {

                    memberlevel.setIntegralstart(start);
                    memberlevel.setIntegralend(end);
                    this.memberlevelservice.updateMemberlevel(memberlevel);
                    map.put("memberlevel", memberlevel);

                }

            }
            catch (Exception e)
            {
                CommonLogger.error("update memberlevel出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("redirect:getMemberlevel.kq", map);
    }

    @RequestMapping("/getMemberlevelByid")
    public void getMemberlevelByid(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        PrintWriter out = null;

        try
        {
            out = response.getWriter();

            if (CommonTool.isEmpty(id))
            {
                Response<List<Memberlevel>> resp = new Response<List<Memberlevel>>();
                Object bido = request.getSession().getAttribute(
                        "login_system_user");
                SystemmgtUser systemUser = (SystemmgtUser) bido;
                String bid = systemUser.getId();

                List<Memberlevel> memberlevellist = this.memberlevelservice
                        .getMemberlevelByBid(bid);

                resp.setResult("success");
                resp.setT(memberlevellist);
                resp.setMessage("operate ok!");

                CommonLogger.info("查询会员级别信息成功！返回对象：" + resp.toString());
                out.print(JSONObject.fromObject(resp).toString());
            }
            else
            {
                Response<Memberlevel> resp = new Response<Memberlevel>();

                Memberlevel memberlevel = this.memberlevelservice
                        .getMemberlevelByid(id);

                if (memberlevel == null)
                {
                    CommonLogger.info("没有查询到记录");
                    resp.setResult("error");
                    resp.setMessage("查询无数据！");
                }
                else
                {
                    resp.setResult("success");
                    resp.setT(memberlevel);
                    resp.setMessage("operate ok!");

                    CommonLogger.info("查询会员级别信息成功！返回对象：" + resp.toString());
                }
                out.print(JSONObject.fromObject(resp).toString());
            }

        }
        catch (Exception e)
        {
            Response<String> resp = new Response<String>();
            CommonLogger.error("get getMemberlevel Byid出错 :", e);
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

}
