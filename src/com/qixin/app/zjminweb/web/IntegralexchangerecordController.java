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

import com.qixin.app.card.model.Config;
import com.qixin.app.card.model.Prizerecord;
import com.qixin.app.card.service.cardServices;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.turntable.model.Customer;
import com.qixin.app.turntable.model.Winners;
import com.qixin.app.turntable.service.TurntableService;
import com.qixin.app.wobble.model.Wobbleconfig;
import com.qixin.app.wobble.model.Wobbleprizerecord;
import com.qixin.app.wobble.service.WobbleconfigService;
import com.qixin.app.wobble.service.WobbleprizerecordService;
import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.model.Integral;
import com.qixin.app.zjminweb.model.Integralexchange;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.model.IntegralexchangerecordResponse;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.CouponService;
import com.qixin.app.zjminweb.service.CouponrecordService;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.app.zjminweb.service.IntegralexchangeService;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class IntegralexchangerecordController
{
    @Resource
    private IntegralexchangerecordService integralexchangerecordservice;

    @Resource
    private IntegralexchangeService integralexchangeservice;

    @Resource
    private CouponrecordService couponrecordservice;

    @Resource
    private CouponService couponservice;

    @Resource
    private MemberService memberservice;

    @Resource
    private IntegralService integralservice;

    @Resource
    private TurntableService turntableService;

    @Resource
    private cardServices cardservices;

    @Resource
    private WobbleprizerecordService prizerecordservice;

    @Resource
    private WobbleconfigService configservice;

    @Resource
    private MemberlevelService memberlevelservices;

    @Resource
    private ActivitiesService activitiesservices;

    @Resource
    private GiftService giftservices;

    @RequestMapping("/getIntegralexchangerecord")
    public ModelAndView getIntegralexchangerecord(HttpServletRequest request,
            HttpServletResponse response, Query query,
            String integralexchangeid, String isuse, String telephone)
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

            PageFinder<Integralexchangerecord> pf = this.integralexchangerecordservice
                    .getIntegralexchangerecord(query, bid, integralexchangeid,
                            isuse, (member != null) ? member.getId() : "");

            List<Integralexchangerecord> list = (List<Integralexchangerecord>) pf
                    .getData();
            List<IntegralexchangerecordResponse> resplist = new ArrayList<IntegralexchangerecordResponse>();
            IntegralexchangerecordResponse resp = null;

            if (!CommonTool.isEmpty(list))
            {
                for (Integralexchangerecord integralexchangerecord : list)
                {
                    resp = new IntegralexchangerecordResponse();
                    resp.setId(integralexchangerecord.getId());
                    resp.setIsreceive(integralexchangerecord.getIsreceive());
                    resp.setReceivetime(integralexchangerecord.getReceivetime());
                    resp.setIsuse(integralexchangerecord.getIsuse());
                    resp.setUsertime(integralexchangerecord.getUsertime());
                    resp.setBizid(integralexchangerecord.getBizid());

                    resp.setIntegralexchange(integralexchangerecord
                            .getIntegralexchangeid() != null ? this.integralexchangeservice
                            .getIntegralexchangeByid(integralexchangerecord
                                    .getIntegralexchangeid()) : null);
                    resp.setMember(integralexchangerecord.getMemberid() != null ? this.memberservice
                            .getMemberByid(integralexchangerecord.getMemberid())
                            : null);
                    resplist.add(resp);
                }

            }
            PageFinder<IntegralexchangerecordResponse> pageFinder = new PageFinder<IntegralexchangerecordResponse>(
                    pf.getPageNo(), pf.getPageSize(), pf.getPageCount(),
                    resplist);

            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Integralexchangerecord byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("integralexchangeid", integralexchangeid);
        map.put("isuse", isuse);
        map.put("telephone", telephone);

        return new ModelAndView("/app/zjintegralexchangerecord/list", map);
    }

    @RequestMapping("/zjminweb/getIntegralexchangerecord")
    public ModelAndView getIntegralexchangerecord(HttpServletRequest request,
            HttpServletResponse response, String bid, String memberid,
            String openid, String isuse)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            // 1.查询积分兑换列表
            List<Integralexchangerecord> list = this.integralexchangerecordservice
                    .getIntegralexchangerecordBymemberid(bid, memberid, isuse);

            List<IntegralexchangerecordResponse> resplist = new ArrayList<IntegralexchangerecordResponse>();
            IntegralexchangerecordResponse resp = null;

            if (!CommonTool.isEmpty(list))
            {
                for (Integralexchangerecord integralexchangerecord : list)
                {
                    resp = new IntegralexchangerecordResponse();
                    resp.setId(integralexchangerecord.getId());
                    resp.setIsreceive(integralexchangerecord.getIsreceive());
                    resp.setReceivetime(integralexchangerecord.getReceivetime());
                    resp.setIsuse(integralexchangerecord.getIsuse());
                    resp.setUsertime(integralexchangerecord.getUsertime());
                    resp.setBizid(integralexchangerecord.getBizid());

                    resp.setMember(integralexchangerecord.getMemberid() != null ? this.memberservice
                            .getMemberByid(integralexchangerecord.getMemberid())
                            : null);

                    Integralexchange ie = integralexchangerecord
                            .getIntegralexchangeid() != null ? this.integralexchangeservice
                            .getIntegralexchangeByid(integralexchangerecord
                                    .getIntegralexchangeid()) : null;

                    // 数据异常
                    if (ie != null)
                    {
                        resp.setIntegralexchange(integralexchangerecord
                                .getIntegralexchangeid() != null ? this.integralexchangeservice
                                .getIntegralexchangeByid(integralexchangerecord
                                        .getIntegralexchangeid()) : null);

                        // 如果积分兑换对象的type为0，即礼品券的时候
                        if ("0".equals(ie.getType()))
                        {
                            // 查询giftid给积分兑换记录对象的giftid
                            Gift gift = this.giftservices.getGiftByid(ie
                                    .getGiftid());
                            resp.setGift(gift);
                        }

                        resplist.add(resp);
                    }
                    else
                    {
                        if (!CommonTool.isEmpty(integralexchangerecord
                                .getType()))
                        {
                            resp.setType(integralexchangerecord.getType());

                            // 查询大转盘中奖信息 \查询摇一摇中奖信息 \查询刮刮卡中奖信息
                            // 1.查询活动信息
                            if (!CommonTool.isEmpty(integralexchangerecord
                                    .getActivitiesid()))
                            {
                                resp.setActivities(this.activitiesservices
                                        .getActivitiesByid(integralexchangerecord
                                                .getActivitiesid()));
                            }

                            // 2.查询礼品信息
                            if (!CommonTool.isEmpty(integralexchangerecord
                                    .getGiftid()))
                            {
                                resp.setGift(this.giftservices
                                        .getGiftByid(integralexchangerecord
                                                .getGiftid()));
                            }

                            resplist.add(resp);
                        }
                    }

                }

            }

            map.put("integralexchangerecordlist", resplist);

        }
        catch (Exception e)
        {
            CommonLogger.error("get Integralexchangerecord byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("memberid", memberid);
        map.put("openid", openid);
        map.put("isuse", isuse);

        return new ModelAndView("/app/zjminweb/integralexchangerecord", map);
    }

    @RequestMapping("/zjminweb/addIntegralexchangerecord")
    public void addIntegralexchangerecord(String id, String memberid,
            String bid, String type, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        PrintWriter out = null;
        Response<Object> resp = new Response<Object>();
        try
        {
            out = response.getWriter();
            if (CommonTool.isEmpty(bid) || CommonTool.isEmpty(id)
                    || CommonTool.isEmpty(memberid))
            {
                CommonLogger.info("输入参数获取失败");
                resp.setResult("error");
                resp.setMessage("输入参数获取失败");
            }
            else
            {
                // 查询该积分兑换
                Integralexchange integralexchange = this.integralexchangeservice
                        .getIntegralexchangeByid(id);

                // 判断会员级别
                Member member = this.memberservice.getMemberByid(memberid);

                Memberlevel ml = null;
                if (integralexchange != null
                        && !CommonTool.isEmpty(integralexchange
                                .getMemberlevelid()))
                {
                    ml = this.memberlevelservices
                            .getMemberlevelByid(integralexchange
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

                    if (integralexchange != null)
                    {

                        // Date islimit = integralexchange.getValidity();
                        // int sum = integralexchange.getSum();

                        String tp = integralexchange.getType();
                        if (!CommonTool.isEmpty(tp) && "1".equals(tp))
                        {

                            String couponid = integralexchange.getCouponid();
                            int integralexcSum = integralexchange.getSum();

                            // 判断该优惠券是否限制领取
                            Coupon coupon = this.couponservice
                                    .getCouponByid(couponid);
                            if (coupon != null)
                            {

                                String islimit = coupon.getIslimit();
                                int sum = coupon.getSum();

                                // 查询该会员是否已经领取
                                List<Couponrecord> list = this.couponrecordservice
                                        .getCouponrecord(coupon.getId(),
                                                memberid, bid);
                                if ((!CommonTool.isEmpty(list)
                                        && list.size() > 0 && !"1"
                                            .equals(islimit))
                                        || sum < 1
                                        || !CommonTool.compareDate(
                                                coupon.getValidityend(),
                                                "yyyy-MM-dd"))
                                {
                                    resp.setResult("error");
                                    if (sum < 1)
                                    {
                                        CommonLogger.info("该兑换活动已领完");
                                        resp.setMessage("该兑换活动已领完");
                                    }
                                    else if (!CommonTool.compareDate(
                                            coupon.getValidityend(),
                                            "yyyy-MM-dd"))
                                    {
                                        CommonLogger.info("该兑换活动已过有效期");
                                        resp.setMessage("该兑换活动已过有效期");
                                    }
                                    else
                                    {
                                        CommonLogger.info("您已兑换过");
                                        resp.setMessage("您已兑换过");
                                    }
                                }
                                else
                                {
                                    // 用户积分减
                                    // Member member = this.memberservice
                                    // .getMemberByid(memberid);

                                    if (Integer
                                            .parseInt(CommonTool.numberMinus(
                                                    member.getIntegral(),
                                                    integralexchange.getScore())) < 0)
                                    {
                                        resp.setResult("error");
                                        CommonLogger.info("积分不够");
                                        resp.setMessage("积分不够");

                                    }
                                    else
                                    {

                                        member.setIntegral(CommonTool
                                                .numberMinus(member
                                                        .getIntegral(),
                                                        integralexchange
                                                                .getScore()));
                                        String result1 = this.memberservice
                                                .updateMember(member);

                                        // 优惠券总数减
                                        coupon.setSum((sum - 1));
                                        String result = this.couponservice
                                                .updateCoupon(coupon);

                                        // 兑换活动减
                                        integralexchange
                                                .setSum(integralexcSum - 1);
                                        String result2 = this.integralexchangeservice
                                                .updateIntegralexchange(integralexchange);

                                        if (!CommonTool.isEmpty(result)
                                                && !CommonTool.isEmpty(result1)
                                                && !CommonTool.isEmpty(result2))
                                        {
                                            // 增加用户积分消费记录
                                            addIntegral(memberid, bid,
                                                    integralexchange);

                                            // 增加领取记录
                                            Couponrecord couponrecord = addCouponrecord(
                                                    memberid, bid, couponid);

                                            resp.setResult("success");
                                            resp.setT(couponrecord);
                                            resp.setMessage("operate ok!");

                                            CommonLogger
                                                    .info("领取优惠券(兑换活动)成功！返回对象："
                                                            + resp.toString());
                                        }
                                        else
                                        {

                                            CommonLogger.info("兑换失败");
                                            resp.setResult("error");
                                            resp.setMessage("兑换失败");

                                        }
                                    }
                                }
                            }
                            else
                            {

                                CommonLogger.info("兑换失败");
                                resp.setResult("error");
                                resp.setMessage("兑换失败");

                            }
                        }
                        else
                        {
                            // 如果为礼品券

                            // 查询该会员是否已经领取
                            List<Integralexchangerecord> list = this.integralexchangerecordservice
                                    .getIntegralexchangerecord(id, memberid,
                                            bid);
                            if ((!CommonTool.isEmpty(list) && list.size() > 0 && !"1"
                                    .equals(integralexchange.getIslimit()))
                                    || integralexchange.getSum() < 1
                                    || !CommonTool.compareDate(
                                            integralexchange.getValidity(),
                                            "yyyy-MM-dd"))
                            {
                                resp.setResult("error");
                                if (integralexchange.getSum() < 1)
                                {
                                    CommonLogger.info("该兑换活动已领完");
                                    resp.setMessage("该兑换活动已领完");
                                }
                                else if (!CommonTool.compareDate(
                                        integralexchange.getValidity(),
                                        "yyyy-MM-dd"))
                                {
                                    CommonLogger.info("该兑换活动已过有效期");
                                    resp.setMessage("该兑换活动已过有效期");
                                }
                                else
                                {
                                    CommonLogger.info("您已兑换过");
                                    resp.setMessage("您已兑换过");
                                }
                            }
                            else
                            {

                                // 用户积分减
                                // Member member = this.memberservice
                                // .getMemberByid(memberid);

                                if (Integer.parseInt(CommonTool.numberMinus(
                                        member.getIntegral(),
                                        integralexchange.getScore())) < 0)
                                {
                                    resp.setResult("error");
                                    CommonLogger.info("积分不够");
                                    resp.setMessage("积分不够");

                                }
                                else
                                {

                                    member.setIntegral(CommonTool.numberMinus(
                                            member.getIntegral(),
                                            integralexchange.getScore()));
                                    String result1 = this.memberservice
                                            .updateMember(member);

                                    // 兑换活动减
                                    integralexchange.setSum(integralexchange
                                            .getSum() - 1);
                                    String result2 = this.integralexchangeservice
                                            .updateIntegralexchange(integralexchange);

                                    if (!CommonTool.isEmpty(result1)
                                            && !CommonTool.isEmpty(result2))
                                    {
                                        // 增加用户积分消费记录
                                        addIntegral(memberid, bid,
                                                integralexchange);

                                        // 增加领取记录
                                        Integralexchangerecord integralexchangerecord = addIntegralexchangerecord(
                                                memberid, bid, id);

                                        // 增加大转盘机会
                                        if ("-1".equals(type))
                                        {
                                            Customer c = new Customer();
                                            c.setOpenid(member.getOpenid());
                                            c.setCompany("");
                                            c.setDepartment("");
                                            c.setName(member.getName());
                                            c.setTel(member.getTelephone());
                                            c.setStatus(0);
                                            c.setActivitiesid(integralexchange
                                                    .getActivitiesid());
                                            turntableService.addCustomer(c);

                                            // 修改兑换记录状态为已兑换
                                            integralexchangerecord
                                                    .setIsuse("1");
                                            integralexchangerecord
                                                    .setUsertime(CommonTool
                                                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                                            this.integralexchangerecordservice
                                                    .updateIntegralexchangerecord(integralexchangerecord);
                                        }
                                        // 增加刮刮卡机会
                                        else if ("2".equals(type))
                                        {
                                            Prizerecord employee = this.cardservices
                                                    .queryEmployeesByOpenId(member
                                                            .getOpenid());
                                            if (employee == null)
                                            {
                                                Config config = this.cardservices
                                                        .queryConfigByName("number");
                                                int number = 5;
                                                if (config != null)
                                                {
                                                    number = Integer
                                                            .parseInt(config
                                                                    .getInfo()
                                                                    .trim());
                                                }

                                                employee = new Prizerecord();
                                                employee.setOpenid(member
                                                        .getOpenid());
                                                employee.setNumber(number + 1);
                                                employee.setIsprizes(0);
                                                employee.setIsreg(0);
                                                employee.setActivitiesid(integralexchange
                                                        .getActivitiesid());
                                                this.cardservices
                                                        .addEmployee(employee);
                                            }
                                            else
                                            {
                                                employee.setNumber(employee
                                                        .getNumber() + 1);
                                                this.cardservices
                                                        .addEmployee(employee);
                                            }

                                            // 修改兑换记录状态为已兑换
                                            integralexchangerecord
                                                    .setIsuse("1");
                                            integralexchangerecord
                                                    .setUsertime(CommonTool
                                                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                                            this.integralexchangerecordservice
                                                    .updateIntegralexchangerecord(integralexchangerecord);

                                        }
                                        // 增加摇一摇机会
                                        else if ("3".equals(type))
                                        {
                                            Wobbleprizerecord employee = prizerecordservice
                                                    .getPrizerecordByOpenId(
                                                            member.getOpenid(),
                                                            bid,
                                                            integralexchange
                                                                    .getActivitiesid());
                                            if (employee == null)
                                            {
                                                Wobbleconfig wc = this.configservice
                                                        .getWobbleconfigByName("number");
                                                employee = new Wobbleprizerecord();
                                                employee.setOpenid(member
                                                        .getOpenid());
                                                employee.setNumber(Integer
                                                        .parseInt(wc.getInfo()) + 1);
                                                employee.setIsprizes(0);
                                                employee.setIsreg(0);
                                                employee.setBizid(bid);
                                                employee.setActivitiesid(integralexchange
                                                        .getActivitiesid());
                                                prizerecordservice
                                                        .addPrizerecord(employee);
                                            }
                                            else
                                            {
                                                employee.setNumber(employee
                                                        .getNumber() + 1);
                                                prizerecordservice
                                                        .updatePrizerecord(employee);
                                            }

                                            // 修改兑换记录状态为已兑换
                                            integralexchangerecord
                                                    .setIsuse("1");
                                            integralexchangerecord
                                                    .setUsertime(CommonTool
                                                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                                            this.integralexchangerecordservice
                                                    .updateIntegralexchangerecord(integralexchangerecord);

                                        }

                                        resp.setResult("success");
                                        resp.setT(integralexchangerecord);
                                        resp.setMessage("operate ok!");

                                        CommonLogger.info("领取兑换活动成功！返回对象："
                                                + resp.toString());
                                    }
                                    else
                                    {

                                        CommonLogger.info("兑换失败");
                                        resp.setResult("error");
                                        resp.setMessage("兑换失败");

                                    }
                                }
                            }

                        }
                    }
                    else
                    {

                        CommonLogger.info("兑换失败");
                        resp.setResult("error");
                        resp.setMessage("兑换失败");

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

    private Couponrecord addCouponrecord(String memberid, String bid,
            String couponid) throws Exception
    {
        Couponrecord couponrecord = new Couponrecord();
        couponrecord.setMemberid(memberid);
        couponrecord.setCouponid(couponid);
        couponrecord.setIsreceive("1");
        couponrecord.setReceivetime(CommonTool
                .getNowDate("yyyy-MM-dd HH:mm:ss"));
        couponrecord.setIsuse("0");

        couponrecord.setBizid(bid);
        this.couponrecordservice.addCouponrecord(couponrecord);
        return couponrecord;
    }

    private Integralexchangerecord addIntegralexchangerecord(String memberid,
            String bid, String id) throws Exception
    {
        Integralexchangerecord integralexchangerecord = new Integralexchangerecord();
        integralexchangerecord.setMemberid(memberid);
        integralexchangerecord.setIntegralexchangeid(id);
        integralexchangerecord.setIsreceive("1");
        integralexchangerecord.setReceivetime(CommonTool
                .getNowDate("yyyy-MM-dd HH:mm:ss"));
        integralexchangerecord.setIsuse("0");

        integralexchangerecord.setBizid(bid);

        // 短ID
        integralexchangerecord.setId(ShortUUID.generateShortUuid());

        this.integralexchangerecordservice
                .addIntegralexchangerecord(integralexchangerecord);
        return integralexchangerecord;
    }

    private void addIntegral(String memberid, String bid,
            Integralexchange integralexchange) throws Exception
    {
        // 增加用户积分消费记录
        Integral integralObj = new Integral();
        integralObj.setScore(integralexchange.getScore());
        integralObj.setMemberid(memberid);
        integralObj
                .setIntime(CommonTool.getNowDateBySDF("yyyy-MM-dd HH:mm:ss"));
        integralObj.setBizid(bid);
        integralObj.setType("1");
        integralObj.setDescription("积分兑换活动");
        this.integralservice.addIntegral(integralObj);
    }

    @RequestMapping("/updateIntegralexchangerecord")
    public ModelAndView updateIntegralexchangerecord(String id, String isuse,
            HttpServletRequest request, HttpServletResponse response,
            String integralexchangeid, ModelMap map)
    {
        try
        {

            Integralexchangerecord ier = this.integralexchangerecordservice
                    .getIntegralexchangerecordByid(id);

            if (ier != null)
            {
                ier.setIsuse("1");
                ier.setUsertime(CommonTool.getNowDate("yyyy-MM-dd HH:mm:ss"));
                this.integralexchangerecordservice
                        .updateIntegralexchangerecord(ier);
            }

            map.put("integralexchangerecord", ier);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Integralexchangerecord出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("integralexchangeid", integralexchangeid);
        map.put("integralexchangerecord", id);
        map.put("isuse", isuse);

        return new ModelAndView("redirect:getIntegralexchangerecord.kq");
    }

    @RequestMapping("/exchangeForward")
    public ModelAndView exchangeForward(HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {

        return new ModelAndView("/app/zjintegralexchangerecord/exchange", map);
    }

    @RequestMapping("/exchange")
    // @ResponseBody
    public void exchange(HttpServletRequest request,
            HttpServletResponse response, String exchangeid, String type)
    {
        PrintWriter out = null;
        Response<IntegralexchangerecordResponse> resp = new Response<IntegralexchangerecordResponse>();

        try
        {

            out = response.getWriter();

            // 查询兑奖记录是否存在
            Integralexchangerecord record = this.integralexchangerecordservice
                    .getIntegralexchangerecordByid(exchangeid);

            if (record == null)
            {
                CommonLogger.info("无兑奖信息,请重新核实！");
                resp.setResult("error");
                resp.setMessage("无兑奖信息,请重新核实！");
            }
            else
            {
                Member member = this.memberservice.getMemberByid(record
                        .getMemberid());
                if (!CommonTool.isEmpty(type) && "doit".equals(type))
                {
                    // 先更新
                    record.setIsuse("1");
                    record.setUsertime(CommonTool
                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                    this.integralexchangerecordservice
                            .updateIntegralexchangerecord(record);

                    String tp = record.getType();
                    // 1.大转盘 2.刮刮卡 3.摇一摇 还需要同步数据
                    if ("1".equals(tp))
                    {
                        Winners winner = this.turntableService.getWinners(
                                member.getOpenid(), record.getActivitiesid());

                        winner.setTicket(1);
                        this.turntableService.addWinners(winner);
                    }
                    else if ("2".equals(tp))
                    {
                        Prizerecord prizerecord = this.cardservices
                                .queryEmployeesByOpenId(member.getOpenid(),
                                        record.getActivitiesid());
                        prizerecord.setIsreg(1);
                        this.cardservices.addEmployee(prizerecord);

                    }
                    else if ("3".equals(tp))
                    {
                        Wobbleprizerecord prizerecord = this.prizerecordservice
                                .getPrizerecordByWin(member.getOpenid(),
                                        member.getBizid(),
                                        record.getActivitiesid());
                        prizerecord.setIsreg(1);
                        this.prizerecordservice.updatePrizerecord(prizerecord);
                    }

                }

                IntegralexchangerecordResponse ieresp = new IntegralexchangerecordResponse();
                ieresp.setId(record.getId());
                ieresp.setIsreceive(record.getIsreceive());
                ieresp.setReceivetime(record.getReceivetime());
                ieresp.setIsuse(record.getIsuse());
                ieresp.setUsertime(record.getUsertime());
                ieresp.setBizid(record.getBizid());

                ieresp.setMember(record.getMemberid() != null ? member : null);

                Integralexchange ie = record.getIntegralexchangeid() != null ? this.integralexchangeservice
                        .getIntegralexchangeByid(record.getIntegralexchangeid())
                        : null;

                // 数据异常
                if (ie != null)
                {
                    ieresp.setIntegralexchange(record.getIntegralexchangeid() != null ? this.integralexchangeservice
                            .getIntegralexchangeByid(record
                                    .getIntegralexchangeid()) : null);

                    // 如果积分兑换对象的type为0，即礼品券的时候
                    if ("0".equals(ie.getType()))
                    {
                        // 查询giftid给积分兑换记录对象的giftid
                        Gift gift = this.giftservices.getGiftByid(ie
                                .getGiftid());
                        ieresp.setGift(gift);
                    }

                }
                else
                {
                    if (!CommonTool.isEmpty(record.getType()))
                    {
                        ieresp.setType(record.getType());

                        // 查询大转盘中奖信息 \查询摇一摇中奖信息 \查询刮刮卡中奖信息
                        // 1.查询活动信息
                        if (!CommonTool.isEmpty(record.getActivitiesid()))
                        {
                            ieresp.setActivities(this.activitiesservices
                                    .getActivitiesByid(record.getActivitiesid()));
                        }

                        // 2.查询礼品信息
                        if (!CommonTool.isEmpty(record.getGiftid()))
                        {
                            ieresp.setGift(this.giftservices.getGiftByid(record
                                    .getGiftid()));
                        }

                    }
                }

                resp.setResult("success");
                resp.setT(ieresp);
                resp.setMessage("operate ok!");
                CommonLogger.info("兑换成功！返回对象：" + resp.toString());

            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("integral operate出错 :", e);
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
