package com.qixin.app.zjminweb.web;

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
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Membernotice;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.app.zjminweb.service.MembernoticeService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class MembernoticeController
{
    @Resource
    private MembernoticeService membernoticeservice;

    @Resource
    private MemberService memberservice;

    @RequestMapping("/getMembernotice")
    public ModelAndView getMembernotice(HttpServletRequest request,
            HttpServletResponse response, Query query)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {
                PageFinder<Membernotice> pageFinder = this.membernoticeservice
                        .getMembernoticeByBid(query, bid);
                map.put("pageFinder", pageFinder);

                map.put("bid", bid);

            }
            catch (Exception e)
            {
                CommonLogger.error("get membernotice byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("/app/zjmembernotice/list", map);
    }

    @RequestMapping("/zjminweb/getMembernotice")
    public ModelAndView getMembernotice(HttpServletRequest request,
            HttpServletResponse response, String bid, String openid,
            String memberid)
    {

        Map<String, Object> map = new HashMap<String, Object>();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {
                List<Membernotice> membernoticelist = this.membernoticeservice
                        .getMembernoticeByBid(bid);
                map.put("membernoticelist", membernoticelist);

                // 获取会员信息
                Member member = this.memberservice.getMemberByid(memberid, bid);
                if (null != member)
                {
                    map.put("member", member);
                    map.put("memberid", member.getId());
                }

            }
            catch (Exception e)
            {
                CommonLogger.error("get membernotice byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        map.put("openid", openid);
        map.put("memberid", memberid);
        return new ModelAndView("/app/zjminweb/membernotice", map);
    }

    @RequestMapping("/removeMembernotice")
    public ModelAndView removeMembernotice(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.membernoticeservice.removeMembernotice(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove Membernotice出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getMembernotice.kq", map);
    }

    @RequestMapping("/addMembernoticeForward")
    public ModelAndView addMembernoticeForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        return new ModelAndView("/app/zjmembernotice/add");
    }

    @RequestMapping("/addMembernotice")
    public ModelAndView addMembernotice(String name, String description,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Membernotice membernotice = new Membernotice();
            membernotice.setName(name);
            membernotice.setDescription(description);
            membernotice
                    .setIntime(CommonTool.getNowDate("yyyy-MM-dd HH:mm:ss"));
            membernotice.setBizid(bid);
            this.membernoticeservice.addMembernotice(membernotice);
            map.put("membernotice", membernotice);
        }
        catch (Exception e)
        {
            CommonLogger.error("add membernotice出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getMembernotice.kq");
    }

    @RequestMapping("/getMembernoticeDetailForward/{id}")
    public ModelAndView getMembernoticeDetailForward(
            HttpServletRequest request, HttpServletResponse response,
            @PathVariable
            String id, ModelMap map)
    {

        try
        {
            Membernotice membernotice = null;
            if (!CommonTool.isEmpty(id))
            {
                membernotice = this.membernoticeservice.getMembernoticeByid(id);
                if (membernotice == null)
                {
                    membernotice = new Membernotice();
                }
            }
            map.put("membernotice", membernotice);
        }
        catch (Exception e)
        {
            CommonLogger.error("get membernoticeDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjmembernotice/detail");
    }
}
