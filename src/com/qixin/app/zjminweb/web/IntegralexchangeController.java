package com.qixin.app.zjminweb.web;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.model.Integralexchange;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.CouponService;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.app.zjminweb.service.IntegralexchangeService;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class IntegralexchangeController
{
    @Resource
    private IntegralexchangeService integralexchangeservice;

    @Resource
    private CouponService couponService;

    @Resource
    private ActivitiesService activitiesService;

    @Resource
    private GiftService giftservices;

    @Resource
    private MemberlevelService memberlevelservices;

    @RequestMapping("/getIntegralexchange")
    public ModelAndView getIntegralexchange(HttpServletRequest request,
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
                PageFinder<Integralexchange> pageFinder = this.integralexchangeservice
                        .getIntegralexchangeByBid(query, bid);
                map.put("pageFinder", pageFinder);

                map.put("bid", bid);

            }
            catch (Exception e)
            {
                CommonLogger.error("get Integralexchange byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("/app/zjintegralexchange/list", map);
    }

    @RequestMapping("/zjminweb/getIntegralexchange")
    public ModelAndView getIntegralexchange(HttpServletRequest request,
            HttpServletResponse response, String bid, String openid,
            String memberid)
    {

        Map<String, Object> map = new HashMap<String, Object>();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {
                List<Integralexchange> integralexchangelist = this.integralexchangeservice
                        .getIntegralexchangeByBid(bid);
                map.put("integralexchangelist", integralexchangelist);

            }
            catch (Exception e)
            {
                CommonLogger.error("get integralexchange byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        map.put("openid", openid);
        map.put("memberid", memberid);
        return new ModelAndView("/app/zjminweb/integralexchange", map);
    }

    @RequestMapping("/removeIntegralexchange")
    public ModelAndView removeIntegralexchange(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.integralexchangeservice
                    .removeIntegralexchange(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove Integralexchange出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getIntegralexchange.kq", map);
    }

    @RequestMapping("/addIntegralexchangeForward")
    public ModelAndView addIntegralexchangeForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            // 查询用于兑换活动的优惠券
            List<Coupon> couponlist = this.couponService.getCoupon(bid, "1");
            map.put("couponlist", couponlist);

            // 查询活动列表信息
            List<Activities> list = this.activitiesService.getActivities(bid);
            map.put("activitieslist", list);

            // 查询奖品列表
            map.put("giftlist", this.giftservices.getGiftListBybid(bid));

            // 查询会员级别
            map.put("memberlevellist",
                    this.memberlevelservices.getMemberlevelByBid(bid));

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("add integralexchange出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjintegralexchange/add", map);
    }

    @SuppressWarnings("deprecation")
    @RequestMapping("/addIntegralexchange")
    public ModelAndView addIntegralexchange(String name, String validity,
            String score, String description, String type, String sum,
            String islimit, String activitiesid, @RequestParam("imgurl")
            CommonsMultipartFile imgurl, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String giftid,
            String memberlevel)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Integralexchange integralexchange = new Integralexchange();
            if (!imgurl.isEmpty())
            {
                String path = "/integralexchange/"
                        + CommonTool.getNowDate("yyyyMMddHHmmssSSS") + ".png";
                File file = new File(request.getRealPath(File.separator) + path); // 新建一个文件
                imgurl.getFileItem().write(file); // 将上传的文件写入新建的文件中
                integralexchange.setImgurl(path);
            }

            integralexchange.setName(name);
            integralexchange.setValidity(CommonTool.conversionDate(validity,
                    "yyyy-MM-dd"));
            integralexchange.setScore(score);
            integralexchange.setSum(Integer.valueOf(sum).intValue());
            integralexchange.setDescription(description);
            integralexchange.setIntime(CommonTool
                    .getNowDate("yyyy-MM-dd HH:mm:ss"));
            integralexchange.setBizid(bid);
            integralexchange.setIslimit(islimit);
            integralexchange.setActivitiesid(activitiesid);
            integralexchange.setMemberlevelid(memberlevel);
            integralexchange.setGiftid("");

            if (CommonTool.isEmpty(type) || "0".equals(type))
            {
                integralexchange.setType("0");

                integralexchange.setGiftid(giftid);
                // 查询原数目
                // Wobbleprize aw =
                // this.integralexchangeservice.getIntegralexchangeByid(id[i],
                // bid);

                // 查询奖品信息
                Gift gift = this.giftservices.getGiftByid(giftid);
                gift.setNumber(gift.getNumber() + (0 - Integer.parseInt(sum)));
                this.giftservices.updateGift(gift);

            }
            else if ("-1".equals(type))
            {
                integralexchange.setType("-1");
            }
            else if ("2".equals(type))
            {
                integralexchange.setType("2");
            }
            else if ("3".equals(type))
            {
                integralexchange.setType("3");
            }
            else
            {
                integralexchange.setType("1");
                integralexchange.setCouponid(type);
            }

            this.integralexchangeservice.addIntegralexchange(integralexchange);
            map.put("integralexchange", integralexchange);

        }
        catch (Exception e)
        {
            CommonLogger.error("add integralexchange出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getIntegralexchange.kq");
    }

    @RequestMapping("/getIntegralexchangeDetailForward/{id}")
    public ModelAndView getIntegralexchangeDetailForward(
            HttpServletRequest request, HttpServletResponse response,
            @PathVariable
            String id, ModelMap map)
    {

        try
        {
            Integralexchange integralexchange = null;
            if (!CommonTool.isEmpty(id))
            {
                integralexchange = this.integralexchangeservice
                        .getIntegralexchangeByid(id);
                if (integralexchange == null)
                {
                    integralexchange = new Integralexchange();
                }
            }
            map.put("integralexchange", integralexchange);
        }
        catch (Exception e)
        {
            CommonLogger.error("get integralexchangeDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjintegralexchange/detail");
    }
}
