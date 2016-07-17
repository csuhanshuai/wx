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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.model.CouponrecordResponse;
import com.qixin.app.zjminweb.service.ConsumptionService;
import com.qixin.app.zjminweb.service.CouponService;
import com.qixin.app.zjminweb.service.CouponrecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class CouponController
{
    @Resource
    private CouponService couponservice;

    @Resource
    private CouponrecordService couponrecordservice;

    @Resource
    private MemberlevelService memberlevelservices;

    @Resource
    private MemberService memberservice;

    @Resource
    private ConsumptionService consumptionservice;

    @RequestMapping("/getCoupon")
    // @ResponseBody
    public ModelAndView getCoupon(HttpServletRequest request,
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

            PageFinder<Coupon> pageFinder = this.couponservice.getCoupon(query,
                    bid);
            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Coupon byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjcoupon/list", map);
    }

    @RequestMapping("/addCouponForward")
    public ModelAndView addCouponForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            // 查询会员级别
            map.put("memberlevellist",
                    this.memberlevelservices.getMemberlevelByBid(bid));
        }
        catch (Exception e)
        {
            CommonLogger.error("add Memberlevel出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        map.put("bid", bid);
        return new ModelAndView("/app/zjcoupon/add", map);
    }

    @RequestMapping("/addCoupon")
    public ModelAndView addCoupon(String name, String money, String starttime,
            String endtime, String sum, String usablerange, String type,
            String islimit, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String memberlevel)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Coupon coupon = new Coupon();
            coupon.setName(name);
            coupon.setMoney(money);
            coupon.setValiditystart(CommonTool.conversionDate(starttime,
                    "yyyy-MM-dd"));
            coupon.setValidityend(CommonTool.conversionDate(endtime,
                    "yyyy-MM-dd"));
            coupon.setSum(Integer.parseInt(sum));
            coupon.setUsablerange(Long.parseLong(usablerange));
            coupon.setStatus("0");
            coupon.setMemberlevelid(memberlevel);

            if (CommonTool.isEmpty(type) || !"1".equals(type))
            {

                coupon.setType("0");
            }
            else
            {
                coupon.setType("1");
            }
            coupon.setIslimit(islimit);
            coupon.setBizid(bid);
            this.couponservice.addCoupon(coupon);
            map.put("coupon", coupon);
        }
        catch (Exception e)
        {
            CommonLogger.error("add Coupon出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getCoupon.kq");
    }

    @RequestMapping("/updateCoupon")
    public ModelAndView updateCoupon(String id, String status,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Coupon coupon = this.couponservice.getCouponByid(id);

            if (coupon != null)
            {
                coupon.setStatus(status);
                coupon.setBizid(bid);
                this.couponservice.updateCoupon(coupon);
            }

            map.put("coupon", coupon);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Coupon出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getCoupon.kq");
    }

    @RequestMapping("/zjminweb/getCouponList")
    public ModelAndView getCouponList(HttpServletRequest request,
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

            List<Coupon> couponlist = this.couponservice.getCoupon(bid, "0");
            map.put("couponlist", couponlist);

        }
        catch (Exception e)
        {
            CommonLogger.error("get Coupon byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("memberid", memberid);
        map.put("openid", openid);
        return new ModelAndView("/app/zjminweb/coupon", map);
    }

    @RequestMapping("/zjminweb/my/getCouponList")
    public ModelAndView getCouponList(HttpServletRequest request,
            HttpServletResponse response, String bid, String memberid,
            String type, String openid)
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

            if (!CommonTool.isEmpty(type))
            {
                // 获取用户的优惠券
                List<Couponrecord> couponrecordlist = this.couponrecordservice
                        .getCouponrecordBybid(memberid, bid, type);

                List<CouponrecordResponse> resplist = new ArrayList<CouponrecordResponse>();
                CouponrecordResponse resp = null;
                if (!CommonTool.isEmpty(couponrecordlist))
                {
                    for (Couponrecord couponrecord : couponrecordlist)
                    {
                        resp = new CouponrecordResponse();
                        resp.setId(couponrecord.getId());
                        resp.setIsreceive(couponrecord.getIsreceive());
                        resp.setReceivetime(couponrecord.getReceivetime());
                        resp.setIsuse(couponrecord.getIsuse());
                        resp.setUsertime(couponrecord.getUsertime());
                        resp.setBizid(couponrecord.getBizid());

                        resp.setCoupon(couponrecord.getCouponid() != null ? this.couponservice
                                .getCouponByid(couponrecord.getCouponid())
                                : null);
                        resp.setMember(couponrecord.getMemberid() != null ? this.memberservice
                                .getMemberByid(couponrecord.getMemberid())
                                : null);
                        resp.setConsumption(couponrecord.getConsumptionid() != null ? this.consumptionservice
                                .getConsumptionByid(couponrecord
                                        .getConsumptionid()) : null);

                        // 判断该优惠券是否过期
                        if (resp.getCoupon() != null)
                        {
                            // boolean isstart =
                            // CommonTool.compareDate(resp.getCoupon().getValiditystart(),
                            // "yyyy-MM-dd HH:mm:ss");
                            boolean isexpire = CommonTool.compareDate(resp
                                    .getCoupon().getValidityend());
                            if (isexpire)
                            {
                                // 未过期
                                resp.setIsexpire("0");
                            }
                            else
                            {
                                // 已过期
                                resp.setIsexpire("1");
                            }
                        }

                        resplist.add(resp);
                    }

                }

                map.put("couponrecordlist", resplist);

                /*
                 * List<Coupon> couponlist = new ArrayList<Coupon>(); for
                 * (Couponrecord couponrecord : couponrecordlist) { String id =
                 * couponrecord.getCouponid();
                 * 
                 * Coupon coupon = this.couponservice.getCouponByid(id);
                 * couponlist.add(coupon); } map.put("couponlist", couponlist);
                 */
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("get my Coupon byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("memberid", memberid);
        map.put("flag", "my");
        map.put("type", type);
        map.put("openid", openid);
        return new ModelAndView("/app/zjminweb/coupon", map);
    }
}
