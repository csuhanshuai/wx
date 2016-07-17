package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Consumption;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.model.CouponrecordResponse;
import com.qixin.app.zjminweb.model.Integral;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Membercard;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.model.Salespromotion;
import com.qixin.app.zjminweb.service.ConsumptionService;
import com.qixin.app.zjminweb.service.CouponService;
import com.qixin.app.zjminweb.service.CouponrecordService;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.app.zjminweb.service.MembercardService;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.app.zjminweb.service.SalespromotionService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class MemberController
{
    @Resource
    private MemberService memberservice;

    @Resource
    private MembercardService membercardservice;

    @Resource
    private ConsumptionService consumptionservice;

    @Resource
    private IntegralService integralservice;

    @Resource
    private CouponrecordService couponrecordservice;

    @Resource
    private MemberlevelService memberlevelservice;

    @Resource
    private SalespromotionService salespromotionService;

    @Resource
    private CouponService couponservice;

    @RequestMapping("/getMember")
    public ModelAndView getMember(HttpServletRequest request,
            HttpServletResponse response, Query query, String salesman,
            ModelMap map)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        try
        {
            PageFinder<Member> pageFinder = this.memberservice.getMember(query);
            map.put("pageFinder", pageFinder);
            map.put("salesman", salesman);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Member byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjmember/list", map);
    }

    @RequestMapping("/getMemberByCondition")
    public ModelAndView getMemberByCondition(HttpServletRequest request,
            HttpServletResponse response, Query query, String type,
            String condition, String salesman)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            PageFinder<Member> pageFinder = this.memberservice
                    .getMemberByCondition(query, type, condition);
            map.put("pageFinder", pageFinder);
            map.put("salesman", salesman);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Member byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        if ("0".equals(type))
        {
            map.put("cardno", condition);
        }
        else if ("1".equals(type))
        {
            map.put("telephone", condition);
        }
        return new ModelAndView("/app/zjmember/list", map);
    }

    @RequestMapping("/saleman/getMemberByCondition")
    public void getMemberByCondition(HttpServletRequest request,
            HttpServletResponse response, String condition)
    {
        PrintWriter out = null;
        Response<Map<String, Object>> respmap = new Response<Map<String, Object>>();
        try
        {
            out = response.getWriter();
            Member member = this.memberservice.getMemberByTelephone(condition);

            if (member == null)
            {

                member = this.memberservice.getMemberByCardno(condition);
            }

            if (member == null)
            {
                CommonLogger.info("没有查询到记录");
                respmap.setResult("error");
                respmap.setMessage("查询无数据！");
            }
            else
            {
                Map<String, Object> map = new HashMap<String, Object>();
                respmap.setResult("success");
                map.put("member", member);

                // resp.setMessage("operate ok!");

                // 获取会员的最新消费时间
                List<Consumption> list = this.consumptionservice
                        .getConsumptionByMemberid(member.getId());
                if (!CommonTool.isEmpty(list) && list.size() > 0)
                {
                    Consumption con = list.get(0);
                    // respmap.setMessage(CommonTool.conversionDate(
                    // con.getIntime(), "yyyy-MM-dd HH:mm:ss"));
                    map.put("lastconsumtime", CommonTool.conversionDate(
                            con.getIntime(), "yyyy-MM-dd HH:mm:ss"));
                }

                // 获取用户的优惠券
                List<Couponrecord> couponrecordlist = this.couponrecordservice
                        .getCouponrecordBybid(member.getId(),
                                member.getBizid(), "0");

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

                respmap.setT(map);
                CommonLogger.info("查询会员信息成功！返回对象：" + respmap.toString());
            }
            out.print(JSONObject.fromObject(respmap).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("get getMember ByCondition出错 :", e);
            respmap.setResult("error");
            respmap.setMessage("操作失败!");
            out.print(JSONObject.fromObject(respmap).toString());
        }
        finally
        {
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/zjminweb/getMember")
    public ModelAndView getMembercard(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid,
            Member member, ModelMap map)
    {
        if (CommonTool.isEmpty(openid))
        {
            openid = (String) map.get("openid");
        }
        if (CommonTool.isEmpty(bid))
        {
            bid = (String) map.get("bid");
        }
        try
        {
            if (CommonTool.isEmpty(openid) || CommonTool.isEmpty(bid))
            {
                map.put("member", null);

            }
            else
            {
                // 1.获取会员信息
                List<Member> memberlist = this.memberservice.getMember(openid,
                        bid);

                if (!CommonTool.isEmpty(memberlist) && memberlist.size() == 1)
                {
                    member = memberlist.get(0);
                    map.put("member", member);

                    // 将用户对象信息放入到session
                    request.getSession()
                            .setAttribute("zjminweb_member", member);
                    map.put("memberid", member.getId());

                    // 2.判断用户是否已经签到了
                    // List<Integral> list = this.integralservice
                    // .getIntegralByBid(bid, member.getId(), "0");
                    List<Integral> list = this.integralservice
                            .getIntegralByNowDate(member.getId());

                    if (!CommonTool.isEmpty(list) && list.size() > 0)
                    {
                        // Integral integral = list.get(0);
                        // Date time = integral.getIntime();
                        // if (!CommonTool.compareDate(time, "yyyy-MM-dd"))
                        // {

                        // }
                        // else
                        // {
                        // 今天已签到
                        map.put("signinflag", "0");
                        // }

                    }
                    else
                    {
                        // 今天没有签到
                        map.put("signinflag", "1");
                    }

                    // 3.获取用户等级
                    List<Memberlevel> memberlevellist = this.memberlevelservice
                            .getMemberlevelByBid(bid);
                    Memberlevel memberlevel = ServiceTool.getMemberlevel(
                            memberlevellist, member);
                    map.put("memberlevel", memberlevel);
                    request.getSession().setAttribute("zjminweb_memberlevel",
                            memberlevel);
                }
                else
                {
                    map.put("member", null);
                }

            }

            // 2.如果存在会员，则查询会员卡信息

            Membercard membercard = getMembercard(bid);

            map.put("membercard", membercard);

            map.put("bid", bid);
            map.put("openid", openid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get member byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjminweb/member", map);
    }

    @RequestMapping("/zjminweb/addMemberForward")
    public ModelAndView addMemberForward(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("bid", bid);
        map.put("openid", openid);
        return new ModelAndView("/app/zjminweb/memberregistration", map);
    }

    @RequestMapping("/zjminweb/addMember")
    public ModelAndView addMember(@ModelAttribute("member")
    @Valid
    Member member, String birth_year, String birth_month, String birth_date,
            HttpServletRequest request, HttpServletResponse response,
            String openid, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        if (CommonTool.isEmpty(bid))
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            bid = systemUser.getId();
        }
        if (member != null)
        {
            try
            {
                StringBuffer birth = new StringBuffer();
                if (!CommonTool.isEmpty(birth_year))
                {
                    birth.append(birth_year);
                }
                if (!CommonTool.isEmpty(birth_month))
                {
                    birth.append('-').append(birth_month);
                    if (!CommonTool.isEmpty(birth_date))
                    {
                        birth.append('-').append(birth_date);
                    }
                }

                // 获取会员卡号初始值
                Membercard membercard = getMembercard(bid);

                String cardno = CommonTool.getMembercardno(membercard
                        .getCardnoinit());
                if (CommonTool.isEmpty(cardno))
                {
                    CommonLogger.error("会员卡号生成出错了 ! openid=" + openid);
                    map.put("errorMsg", "会员卡号生成出错了!");
                    return new ModelAndView("warnframe", map);
                }

                // 更新初始值
                membercard.setCardnoinit(cardno);
                this.membercardservice.updateMembercard(membercard);

                member.setCardno(cardno);

                member.setBirthday(birth.toString());

                member.setBizid(bid);
                member.setOpenid(openid);
                member.setIntime(CommonTool.getNowDate("yyyy-MM-dd hh:mm:ss"));
                member.setStatus("1");
                this.memberservice.addMember(member);
                map.put("member", member);
            }
            catch (Exception e)
            {
                CommonLogger.error("add member出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        map.put("openid", openid);
        return new ModelAndView("redirect:/zj/zjminweb/getMember.kq", map);
    }

    private Membercard getMembercard(String bid) throws Exception
    {
        // 获取会员卡号起始值
        List<Membercard> membercardlist = this.membercardservice
                .getMembercardByBid(bid);
        Membercard membercard = null;
        if (membercardlist != null && membercardlist.size() == 1)
        {
            membercard = membercardlist.get(0);
        }
        return membercard;
    }

    /**
     * 检测用户号码是否被注册
     * 
     * @Title: getMemberBytelephone
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request
     * @param response
     * @param telephone 设定文件 void 返回类型
     */
    @RequestMapping("/zjminweb/getMemberBytelephone")
    public void getMemberBytelephone(HttpServletRequest request,
            HttpServletResponse response, String telephone, String openid)
    {
        PrintWriter out = null;
        Response<String> resp = new Response<String>();

        try
        {

            out = response.getWriter();

            if (!CommonTool.isEmpty(telephone) && !CommonTool.isEmpty(openid))
            {
                List<Member> list = this.memberservice
                        .getMemberBytelephone(telephone);
                if (!CommonTool.isEmpty(list))
                {
                    resp.setResult("error");
                    resp.setMessage("该电话号码已注册过");
                    CommonLogger.info("该电话号码已注册过！返回对象：" + resp.toString());
                }
                else
                {

                    Member member = this.memberservice
                            .getMemberByOpenid(openid);
                    if (member != null)
                    {
                        resp.setResult("error");
                        resp.setMessage("该微信号已注册过");
                        CommonLogger.info("该微信号已注册过！返回对象：" + resp.toString());
                    }
                    else
                    {

                        resp.setResult("success");
                        resp.setMessage("该电话号码/微信号可注册");
                        CommonLogger.info("该电话号码/微信号可注册，返回对象："
                                + resp.toString());
                    }
                }
            }
            else
            {

                CommonLogger.info("用户电话号码/微信号为空");
                resp.setResult("error");
                resp.setMessage("电话号码/微信号不能为空");

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

    /**
     * 对外提供积分操作接口
     * 
     * @Title: integral
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param request 请求对象
     * @param response 返回对象
     * @param openid 微信ID
     * @param type 加减操作 0:加 1:减
     * @param score 分数
     * @param map 对象Map
     * @return 设定文件 ModelAndView 返回类型
     */
    @RequestMapping("/zjminweb/integral")
    // @ResponseBody
    public void integral(HttpServletRequest request,
            HttpServletResponse response, String memberid, String type,
            String score, ModelMap map)
    {
        PrintWriter out = null;
        Response<Member> resp = new Response<Member>();

        try
        {

            out = response.getWriter();

            // 查询用户今天是否签到了
            List<Integral> list = this.integralservice
                    .getIntegralByNowDate(memberid);

            if (!CommonTool.isEmpty(list))
            {
                CommonLogger.info("今天已签到");
                resp.setResult("error");
                resp.setMessage("今天已签到");
            }
            else
            {
                // Member member = this.memberservice.getMemberByOpenid(openid);
                Member member = this.memberservice.getMemberByid(memberid);

                if (member != null)
                {

                    String integral = member.getIntegral();

                    Integral integralObj = new Integral();
                    integralObj.setScore(score);
                    integralObj.setMemberid(member.getId());
                    integralObj.setIntime(CommonTool
                            .getNowDateBySDF("yyyy-MM-dd HH:mm:ss"));
                    integralObj.setBizid(member.getBizid());
                    integralObj.setType(type);

                    if (!CommonTool.isEmpty(type) && "0".equals(type))
                    {
                        integralObj.setDescription("签到领取");
                        this.integralservice.addIntegral(integralObj);

                        integral = CommonTool.numberAdd(integral, score);
                        CommonLogger.info("会员：" + member.getName() + "("
                                + member.getId() + ")积分增加：" + score);
                    }
                    else if (!CommonTool.isEmpty(type) && "1".equals(type))
                    {
                        integral = CommonTool.numberMinus(integral, score);
                        CommonLogger.info("会员：" + member.getName() + "("
                                + member.getId() + ")积分减少：" + score);
                    }
                    member.setIntegral(integral);

                    this.memberservice.updateMember(member);

                    resp.setResult("success");
                    resp.setT(member);
                    resp.setMessage(score);
                    CommonLogger.info("查询会员信息成功！返回对象：" + resp.toString());
                }
                else
                {
                    CommonLogger.info("没有查询到会员记录");
                    resp.setResult("error");
                    resp.setMessage("没有查询到会员记录！");
                }
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

    @RequestMapping("/updateMember")
    public ModelAndView updateMember(String id, String status,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Member member = this.memberservice.getMemberByid(id);

            if (member != null)
            {
                member.setStatus(status);
                member.setBizid(bid);
                this.memberservice.updateMember(member);
            }

            map.put("member", member);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Member出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getMember.kq");
    }

    @RequestMapping("/zjminweb/updateMemberInfo")
    public ModelAndView updateMemberInfo(Member member, String birth_year,
            String birth_month, String birth_date, HttpServletRequest request,
            HttpServletResponse response, String openid, ModelMap map,
            String bid)
    {
        try
        {
            if (CommonTool.isEmpty(bid))
            {
                Object bido = request.getSession().getAttribute(
                        "login_system_user");
                SystemmgtUser systemUser = (SystemmgtUser) bido;
                bid = systemUser.getId();
            }
            if (member != null && !CommonTool.isEmpty(member.getId()))
            {
                Member mem = this.memberservice.getMemberByid(member.getId());

                StringBuffer birth = new StringBuffer();
                if (!CommonTool.isEmpty(birth_year))
                {
                    birth.append(birth_year);
                }
                if (!CommonTool.isEmpty(birth_month))
                {
                    birth.append('-').append(birth_month);
                    if (!CommonTool.isEmpty(birth_date))
                    {
                        birth.append('-').append(birth_date);
                    }
                }

                if (!CommonTool.isEmpty(member.getName()))
                {
                    mem.setName(member.getName());
                }
                if (!CommonTool.isEmpty(member.getTelephone()))
                {
                    mem.setTelephone(member.getTelephone());
                }

                if (!CommonTool.isEmpty(member.getSex()))
                {
                    mem.setSex(member.getSex());
                }
                if (!CommonTool.isEmpty(member.getAddr_prov()))
                {
                    mem.setAddr_prov(member.getAddr_prov());
                }
                if (!CommonTool.isEmpty(member.getAddr_city()))
                {
                    mem.setAddr_city(member.getAddr_city());
                }
                if (!CommonTool.isEmpty(member.getAddr_area()))
                {
                    mem.setAddr_area(member.getAddr_area());
                }
                if (!CommonTool.isEmpty(member.getAddress()))
                {
                    mem.setAddress(member.getAddress());
                }
                if (!CommonTool.isEmpty(member.getQq()))
                {
                    mem.setQq(member.getQq());
                }

                mem.setBirthday(birth.toString());

                mem.setBizid(bid);

                this.memberservice.updateMember(mem);
                map.put("member", mem);
                map.put("memberid", mem.getId());
            }

            map.put("openid", openid);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Member出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:/zj/zjminweb/getMember.kq");
    }

    @RequestMapping("/zjminweb/updateMemberInfoForward")
    public ModelAndView updateMemberInfoForward(HttpServletRequest request,
            HttpServletResponse response, String openid, String id,
            String type, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            Member member = this.memberservice.getMemberByid(id);
            map.put("member", member);
            map.put("memberid", member.getId());
        }
        catch (Exception e)
        {
            CommonLogger.error("update MemberInfoForward出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("type", type);
        map.put("openid", openid);
        map.put("bid", bid);
        return new ModelAndView("/app/zjminweb/memberregistration", map);
    }

    @RequestMapping("/zjminweb/enterMyspace")
    public ModelAndView enterMyspace(HttpServletRequest request,
            HttpServletResponse response, String memberid, String bid,
            String openid)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        try
        {
            if (CommonTool.isEmpty(memberid) || CommonTool.isEmpty(bid)
                    || CommonTool.isEmpty(openid))
            {
                map.put("member", null);

            }
            else
            {
                // 1.获取会员信息
                Member member = this.memberservice.getMemberByid(memberid, bid);
                if (null != member)
                {
                    map.put("member", member);
                    map.put("memberid", member.getId());

                    // 2.查询优惠券数量
                    List<Couponrecord> couponrecordlist = this.couponrecordservice
                            .getCouponrecord(memberid, bid);

                    if (!CommonTool.isEmpty(couponrecordlist)
                            && couponrecordlist.size() > 0)
                    {
                        map.put("couponrecordlist", couponrecordlist);
                    }
                    else
                    {
                        map.put("couponrecordlist", null);
                    }

                    Memberlevel memberlevel = ServiceTool.getMemberlevel(
                            this.memberlevelservice.getMemberlevelByBid(bid),
                            member);
                    map.put("memberlevel", memberlevel);

                }
                else
                {
                    map.put("member", null);

                }
            }

        }
        catch (Exception e)
        {
            CommonLogger.error("update MemberInfoForward出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        map.put("memberid", memberid);
        map.put("bid", bid);
        map.put("openid", openid);
        return new ModelAndView("/app/zjminweb/my", map);
    }

    @RequestMapping("/getMemberDetail/{memberid}")
    public ModelAndView getMemberDetail(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String memberid, ModelMap map)
    {

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            Member member = this.memberservice.getMemberByid(memberid);
            map.put("member", member);

            Memberlevel memberlevel = ServiceTool.getMemberlevel(
                    this.memberlevelservice.getMemberlevelByBid(bid), member);
            map.put("memberlevel", memberlevel);

            map.put("memberid", memberid);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Consumption byMemberid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjmember/detail", map);
    }

    @RequestMapping("/inpayForward")
    public ModelAndView inpayForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        return new ModelAndView("/app/zjmember/inpay");
    }

    @RequestMapping("/inPay")
    public void inPay(String memberid, String money,
            HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter out = null;
        Response<Member> resp = new Response<Member>();

        try
        {
            out = response.getWriter();

            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            if (!CommonTool.isEmpty(memberid) || !CommonTool.isEmpty(bid))
            {

                Member member = this.memberservice.getMemberByid(memberid);
                if (member != null)
                {

                    member.setBalance(CommonTool.flaotAdd(member.getBalance(),
                            money));

                    // 查询是否存在促销活动（充值优惠活动）
                    List<Salespromotion> list = this.salespromotionService
                            .getSalespromotion(bid, "0", Long.parseLong(money));

                    Salespromotion salespromotion = ServiceTool
                            .getSalespromotion(list);

                    if (salespromotion != null)
                    {
                        member.setBalance(CommonTool.flaotAdd(
                                member.getBalance(), salespromotion.getMoney()));
                    }

                    String result = this.memberservice.updateMember(member);

                    if (!CommonTool.isEmpty(result))
                    {
                        // 增加消费记录
                        Consumption consumption = new Consumption();
                        consumption.setMemberid(memberid);
                        consumption.setMoney(money);
                        Date nowdate = CommonTool
                                .getNowDateBySDF("yyyy-MM-dd HH:mm:ss");
                        consumption.setIntime(nowdate);
                        consumption.setReasons("充值");
                        consumption.setStatus("0");
                        consumption.setType("1");
                        consumption.setBalance(member.getBalance());
                        consumption.setBizid(bid);
                        this.consumptionservice.addConsumption(consumption);

                        resp.setResult("success");
                        resp.setT(member);
                        resp.setMessage("operate ok!");
                        CommonLogger.info("充值成功！返回对象：" + resp.toString());
                    }

                }
                else
                {
                    resp.setResult("error");
                    resp.setMessage("获取会员对象为空！");
                    CommonLogger.info("获取会员对象为空");
                }

            }
            else
            {
                resp.setResult("error");
                resp.setMessage("输入参数为空！");
                CommonLogger.info("输入参数为空");
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("add consumption出错 :", e);

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

    @RequestMapping("/zjminweb/inpayByweixin")
    public ModelAndView inpayByweixin(HttpServletRequest request,
            HttpServletResponse response, String memberid, String bid,
            String openid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("memberid", memberid);
        map.put("bid", bid);
        map.put("openid", openid);
        return new ModelAndView("/app/zjweixinpay/pay", map);
    }
}
