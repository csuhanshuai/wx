package com.qixin.app.zjminweb.web;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
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
import com.qixin.app.zjminweb.common.QuickMarkTool;
import com.qixin.app.zjminweb.model.Signin;
import com.qixin.app.zjminweb.service.SigninService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class SigninController
{
    @Resource
    private SigninService signinservice;

    @RequestMapping("/getSignin")
    // @ResponseBody
    public ModelAndView getSignin(HttpServletRequest request,
            HttpServletResponse response, Query query)
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

            PageFinder<Signin> pageFinder = this.signinservice.getSignin(query,
                    bid);
            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Signin byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjsignin/list", map);
    }

    @RequestMapping("/addSigninForward")
    public ModelAndView addSigninForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        map.put("bid", bid);
        return new ModelAndView("/app/zjsignin/add", map);
    }

    @RequestMapping("/addSignin")
    public ModelAndView addSignin(String name, String url, String description,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {

            String str = CommonTool.getNowDate("yyyyMMddHHmmssSSS") + ".png";
            String pa = "signin" + File.separator + str;
            String path = request.getSession().getServletContext()
                    .getRealPath(pa);
            if (QuickMarkTool.creatQuickMark(path, url))
            {

                Object bido = request.getSession().getAttribute(
                        "login_system_user");
                SystemmgtUser systemUser = (SystemmgtUser) bido;
                String bid = systemUser.getId();

                Signin signin = new Signin();
                signin.setName(name);
                signin.setUrl(url);
                signin.setStatus("0");
                signin.setDescription(description);
                signin.setIntime(new Date());
                signin.setBizid(bid);
                signin.setPath(pa);
                this.signinservice.addSignin(signin);
                map.put("signin", signin);

                // 更新下url
                signin.setUrl(url + "&signinid=" + signin.getId());
                this.signinservice.updateSignin(signin);

            }

        }
        catch (Exception e)
        {
            CommonLogger.error("add Signin出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getSignin.kq");
    }

    @RequestMapping("/updateSignin")
    public ModelAndView updateSignin(String id, String status,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Signin signin = this.signinservice.getSigninByid(id);

            if (signin != null)
            {
                signin.setStatus(status);
                signin.setBizid(bid);
                this.signinservice.updateSignin(signin);
            }

            map.put("signin", signin);
        }
        catch (Exception e)
        {
            CommonLogger.error("update signin出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getSignin.kq");
    }
}
