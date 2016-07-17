package com.qixin.app.zjminweb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Membercard;
import com.qixin.app.zjminweb.service.MembercardService;
import com.qixin.platform.log.CommonLogger;

@Controller
@RequestMapping("/zj")
public class MembercardController
{
    @Resource
    private MembercardService membercardservice;

    @RequestMapping("/getMembercard")
    public ModelAndView getMembercard(HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            // 1.获取会员卡信息
            List<Membercard> membercardlist = this.membercardservice
                    .getMembercardByBid(bid);

            Membercard membercard = null;
            if (membercardlist != null && membercardlist.size() == 1)
            {
                membercard = membercardlist.get(0);
            }

            map.put("membercard", membercard);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get membercard byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjmembercard/membercard", map);
    }

    @RequestMapping("/updateMembercardForward")
    public ModelAndView updateMembercardForward(HttpServletRequest request,
            HttpServletResponse response, String type)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        try
        {
            // 1.获取会员卡信息
            List<Membercard> membercardlist = this.membercardservice
                    .getMembercardByBid(bid);

            Membercard membercard = null;
            if (membercardlist != null && membercardlist.size() == 1)
            {
                membercard = membercardlist.get(0);
            }
            map.put("membercard", membercard);
        }
        catch (Exception e)
        {
            CommonLogger.error("get membercard byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("type", type);
        return new ModelAndView("/app/zjmembercard/modify", map);
    }

    @RequestMapping("/updateMembercard")
    public ModelAndView updateMembercard(@ModelAttribute("membercard")
    @Valid
    Membercard membercard, HttpServletRequest request,
            HttpServletResponse response, String type, String carimgurl,
            String logoimgurl)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        //String[] imgpaths = request.getParameterValues("ImgPath[]");

        try
        {
            // 1.获取会员卡信息
            List<Membercard> membercardlist = this.membercardservice
                    .getMembercardByBid(bid);

            Membercard info = null;
            if (membercardlist != null && membercardlist.size() == 1)
            {
                info = membercardlist.get(0);

                if ("1".equals(type))
                {
                    // 正面
                    info.setName(membercard.getName());
                    info.setNamecolor(membercard.getNamecolor());
                    info.setNumbercolor(membercard.getNumbercolor());

                    // if (imgpaths != null && imgpaths.length == 2)
                    // {

                    // if (imgpaths[0] != null && !"".equals(imgpaths[0]))
                    if (!CommonTool.isEmpty(carimgurl))
                    {

                        info.setBgurl(carimgurl);
                    }
                    // if (imgpaths[1] != null && !"".equals(imgpaths[1]))
                    if (!CommonTool.isEmpty(logoimgurl))
                    {
                        info.setLogourl(logoimgurl);
                    }
                    // }

                }
                else if ("2".equals(type))
                {

                    // 反面
                    info.setShopaddress(membercard.getShopaddress());
                    info.setShopname(membercard.getShopname());
                    info.setShoptelephone(membercard.getShoptelephone());
                    info.setShopdescription(membercard.getShopdescription());
                    info.setLongitude(membercard.getLongitude());
                    info.setLatitude(membercard.getLatitude());
                }
                this.membercardservice.updateMembercard(info);
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("update membercard byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        return new ModelAndView("redirect:getMembercard.kq", map);
    }
}
