package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
import java.util.Date;
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
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.model.Signin;
import com.qixin.app.zjminweb.model.Signinrecord;
import com.qixin.app.zjminweb.service.SigninService;
import com.qixin.app.zjminweb.service.SigninrecordService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class SigninrecordController
{

    @Resource
    private SigninrecordService signinrecordservice;

    @Resource
    private SigninService signinservice;

    @RequestMapping("/getSigninrecord")
    // @ResponseBody
    public ModelAndView getSigninrecord(HttpServletRequest request,
            HttpServletResponse response, Query query, String starttime,
            String endtime, String signinid)
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
            map.put("bid", bid);
            map.put("signinid", signinid);
            map.put("starttime", starttime);
            map.put("endtime", endtime);

            if (!CommonTool.isEmpty(signinid))
            {

                Signin signin = this.signinservice.getSigninByid(signinid);
                map.put("signin", signin);

                if (signin != null)
                {
                    Date start = CommonTool.conversionDate(starttime,
                            "yyyy-MM-dd");
                    Date end = CommonTool.conversionDate(endtime, "yyyy-MM-dd");

                    PageFinder<Signinrecord> pageFinder = this.signinrecordservice
                            .getSigninrecord(query, signinid, start, end);
                    map.put("pageFinder", pageFinder);

                    // 获取今日签到总数
                    List<Signinrecord> signinrecordlist = this.signinrecordservice
                            .getSigninrecordBysigninid(signinid, CommonTool
                                    .getNowDateBySDF("yyyy-MM-dd HH:mm:ss"), CommonTool.getTomorrowDate(
                                    new Date(), "yyyy-MM-dd"));
                    map.put("signinrecordlist", signinrecordlist);
                }
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("get Signinrecord byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjsigninrecord/list", map);
    }

    @RequestMapping("/zjminweb/addSigninrecordForward")
    public ModelAndView addSigninrecordForward(HttpServletRequest request,
            HttpServletResponse response, String signinid, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        try
        {
            Signin signin = this.signinservice.getSigninByid(signinid);
            map.put("signin", signin);
        }
        catch (Exception e)
        {
            CommonLogger.error("add SigninrecordForward 出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        map.put("bid", bid);
        return new ModelAndView("/app/zjminweb/signin", map);
    }

    @RequestMapping("/zjminweb/addSigninrecord")
    public void addSigninrecord(String signinid, String name, String telephone,
            String bid, HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter out = null;
        Response<Signinrecord> resp = new Response<Signinrecord>();
        try
        {
            out = response.getWriter();

            Signin signin = this.signinservice.getSigninByid(signinid);

            if (signin == null)
            {
                CommonLogger.info("没有查询到签到对象");
                resp.setResult("error");
                resp.setMessage("没有查询到签到对象");
            }
            else
            {
                Signinrecord signinrecord = new Signinrecord();
                signinrecord.setName(new String(name.getBytes("ISO-8859-1"),
                        "UTF-8"));
                signinrecord.setSigninid(signinid);
                signinrecord.setTelephone(telephone);
                signinrecord.setIntime(new Date());
                signinrecord.setBizid(bid);

                this.signinrecordservice.addSigninrecord(signinrecord);
                resp.setResult("success");
                resp.setT(signinrecord);
                CommonLogger.info("查询会员信息成功！返回对象：" + resp.toString());
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {

            CommonLogger.error("add Signinrecord出错 :", e);
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
