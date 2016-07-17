package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.model.CouponrecordResponse;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.model.Response;
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
public class CouponrecordController
{
    @Resource
    private CouponrecordService couponrecordservice;

    @Resource
    private CouponService couponservice;

    @Resource
    private MemberService memberservice;

    @Resource
    private ConsumptionService consumptionservice;

    @Resource
    private MemberlevelService memberlevelservices;

    @RequestMapping("/getCouponrecord")
    public ModelAndView getCouponrecord(HttpServletRequest request,
            HttpServletResponse response, Query query, String couponid,
            String isuse, String telephone)
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

            Member member = null;
            if (!CommonTool.isEmpty(telephone))
            {
                member = this.memberservice.getMemberByTelephone(telephone);

            }

            PageFinder<Couponrecord> pf = this.couponrecordservice
                    .getCouponrecord(query, bid, couponid, isuse,
                            (member != null) ? member.getId() : "");
            List<Couponrecord> list = (List<Couponrecord>) pf.getData();
            List<CouponrecordResponse> resplist = new ArrayList<CouponrecordResponse>();
            CouponrecordResponse resp = null;

            if (!CommonTool.isEmpty(list))
            {
                for (Couponrecord couponrecord : list)
                {
                    resp = new CouponrecordResponse();
                    resp.setId(couponrecord.getId());
                    resp.setIsreceive(couponrecord.getIsreceive());
                    resp.setReceivetime(couponrecord.getReceivetime());
                    resp.setIsuse(couponrecord.getIsuse());
                    resp.setUsertime(couponrecord.getUsertime());
                    resp.setBizid(couponrecord.getBizid());

                    resp.setCoupon(couponrecord.getCouponid() != null ? this.couponservice
                            .getCouponByid(couponrecord.getCouponid()) : null);
                    resp.setMember(couponrecord.getMemberid() != null ? this.memberservice
                            .getMemberByid(couponrecord.getMemberid()) : null);
                    resp.setConsumption(couponrecord.getConsumptionid() != null ? this.consumptionservice
                            .getConsumptionByid(couponrecord.getConsumptionid())
                            : null);

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
            PageFinder<CouponrecordResponse> pageFinder = new PageFinder<CouponrecordResponse>(
                    pf.getPageNo(), pf.getPageSize(), pf.getPageCount(),
                    resplist);

            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Couponrecord byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("couponid", couponid);
        map.put("isuse", isuse);
        map.put("telephone", telephone);

        return new ModelAndView("/app/zjcouponrecord/list", map);
    }

    @RequestMapping("/zjminweb/addCouponrecord")
    public void addCouponrecord(String id, String memberid, String bid,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        PrintWriter out = null;
        Response<Couponrecord> resp = new Response<Couponrecord>();
        try
        {
            out = response.getWriter();
            if (CommonTool.isEmpty(bid))
            {
                Object bido = request.getSession().getAttribute(
                        "login_system_user");
                SystemmgtUser systemUser = (SystemmgtUser) bido;
                bid = systemUser.getId();
            }
            if (CommonTool.isEmpty(bid))
            {
                CommonLogger.info("bid获取失败");
                resp.setResult("error");
                resp.setMessage("bid获取失败");
            }
            else
            {
                // 判断该优惠券是否限制领取
                Coupon coupon = this.couponservice.getCouponByid(id);

                // 判断会员级别
                Member member = this.memberservice.getMemberByid(memberid);

                Memberlevel ml = null;
                if (coupon != null
                        && !CommonTool.isEmpty(coupon.getMemberlevelid()))
                {
                    ml = this.memberlevelservices.getMemberlevelByid(coupon
                            .getMemberlevelid());
                }
                if (!ServiceTool.isInMemberlevel(member, ml))
                {
                    resp.setResult("error");

                    CommonLogger.info("您级别不够，无权限领取");
                    resp.setMessage("您级别不够，无权限领取");

                }
                else
                {

                    if (coupon != null)
                    {

                        String islimit = coupon.getIslimit();
                        int sum = coupon.getSum();

                        // 查询该会员是否已经领取
                        List<Couponrecord> list = this.couponrecordservice
                                .getCouponrecord(id, memberid, bid);
                        if ((!CommonTool.isEmpty(list) && list.size() > 0 && !"1"
                                .equals(islimit))
                                || sum < 1
                                || !CommonTool.compareDate(
                                        coupon.getValidityend(), "yyyy-MM-dd"))
                        {
                            resp.setResult("error");
                            if (sum < 1)
                            {
                                CommonLogger.info("该优惠券已领完");
                                resp.setMessage("您优惠券已领完");
                            }
                            else if (!CommonTool.compareDate(
                                    coupon.getValidityend(), "yyyy-MM-dd"))
                            {
                                CommonLogger.info("该优惠券已过有效期");
                                resp.setMessage("您优惠券已过有效期");
                            }
                            else
                            {
                                CommonLogger.info("该会员已领取此优惠券");
                                resp.setMessage("您已经领取过该优惠券了");
                            }
                        }
                        else
                        {
                            // 优惠券总数减
                            coupon.setSum((sum - 1));
                            String result = this.couponservice
                                    .updateCoupon(coupon);
                            if (!CommonTool.isEmpty(result))
                            {

                                // 增加领取记录
                                Couponrecord couponrecord = new Couponrecord();
                                couponrecord.setMemberid(memberid);
                                couponrecord.setCouponid(id);
                                couponrecord.setIsreceive("1");
                                couponrecord.setReceivetime(CommonTool
                                        .getNowDate("yyyy-MM-dd HH:mm:ss"));
                                couponrecord.setIsuse("0");

                                couponrecord.setBizid(bid);
                                this.couponrecordservice
                                        .addCouponrecord(couponrecord);

                                resp.setResult("success");
                                resp.setT(couponrecord);
                                resp.setMessage("operate ok!");

                                CommonLogger.info("领取优惠券成功！返回对象："
                                        + resp.toString());
                            }
                            else
                            {

                                CommonLogger.info("更新优惠券对象失败");
                                resp.setResult("error");
                                resp.setMessage("更新优惠券对象失败");

                            }
                        }
                    }
                    else
                    {

                        CommonLogger.info("获取优惠券对象失败");
                        resp.setResult("error");
                        resp.setMessage("获取优惠券对象失败");

                    }
                }
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("add Couponrecord出错 :", e);
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
