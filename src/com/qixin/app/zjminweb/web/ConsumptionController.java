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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Consumption;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.model.Integralrule;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.ConsumptionService;
import com.qixin.app.zjminweb.service.CouponService;
import com.qixin.app.zjminweb.service.CouponrecordService;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.app.zjminweb.service.IntegralruleService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class ConsumptionController
{
    @Resource
    private ConsumptionService consumptionservice;

    @Resource
    private CouponrecordService couponrecordservice;

    @Resource
    private CouponService couponservice;

    @Resource
    private MemberService memberservice;

    @Resource
    private IntegralruleService integralruleservice;

    @Resource
    private IntegralService integralservice;

    @RequestMapping("/getConsumptionByMemberid/{salesman}/{memberid}")
    public ModelAndView getConsumptionByMemberid(HttpServletRequest request,
            HttpServletResponse response, Query query, @PathVariable
            String memberid, ModelMap map, String page, @PathVariable
            String salesman)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        // if (!CommonTool.isEmpty(page))
        // {
        // query.setPage(Integer.valueOf(page).intValue());
        // }

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            PageFinder<Consumption> pageFinder = this.consumptionservice
                    .getConsumptionByMemberid(query, memberid);
            map.put("pageFinder", pageFinder);
            map.put("memberid", memberid);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Consumption byMemberid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("salesman", salesman);
        return new ModelAndView("/app/zjconsumption/list", map);
    }

    @RequestMapping("/zjminweb/getConsumption")
    public ModelAndView getConsumption(HttpServletRequest request,
            HttpServletResponse response, String memberid, String bid,
            String openid, String type, ModelMap map)
    {

        try
        {
            if (!CommonTool.isEmpty(bid) && !CommonTool.isEmpty(memberid))
            {
                List<Consumption> consumptionlist = this.consumptionservice
                        .getConsumptionByMemberid(bid, memberid, type);
                map.put("consumptionlist", consumptionlist);
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("get Consumption byMemberid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("openid", openid);
        map.put("memberid", memberid);
        map.put("type", type);
        return new ModelAndView("/app/zjminweb/consumption", map);
    }

    @RequestMapping("/addConsumptionForward")
    public ModelAndView addConsumptionForward(HttpServletRequest request,
            HttpServletResponse response, String memberid, String salesman,
            String type, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(memberid))
        {
            try
            {
                Member member = this.memberservice.getMemberByid(memberid);
                map.put("member", member);

                if (!CommonTool.isEmpty(type) && "mod".equals(type)
                        && !CommonTool.isEmpty(id))
                {
                    Consumption consumption = this.consumptionservice
                            .getConsumptionByid(id);

                    map.put("consumption", consumption);
                }
            }
            catch (Exception e)
            {
                CommonLogger.error("add consumption出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("salesman", salesman);
        map.put("bid", bid);
        map.put("type", type);
        return new ModelAndView("/app/zjconsumption/add", map);
    }

    @RequestMapping("/addConsumption")
    public void addConsumption(String memberid, String money,
            HttpServletRequest request, HttpServletResponse response,
            String couponrecordid)
    {
        PrintWriter out = null;
        Response<String> resp = new Response<String>();

        try
        {
            out = response.getWriter();

            // 查询余额

            Member member = this.memberservice.getMemberByid(memberid);
            if (member == null)
            {
                resp.setResult("error");
                resp.setMessage("查询会员余额失败");
                CommonLogger.info("查询会员余额失败");
                out.print(JSONObject.fromObject(resp).toString());
                return;
            }

            String balance = member.getBalance();
            if (CommonTool.compareNum(balance, money))
            {
                resp.setResult("error");
                resp.setMessage("消费额度超限");
                CommonLogger.info("消费额度超限");
                out.print(JSONObject.fromObject(resp).toString());
                return;
            }

            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            if (!CommonTool.isEmpty(memberid) || !CommonTool.isEmpty(bid))
            {
                Couponrecord couponrecord = null;
                if (!CommonTool.isEmpty(couponrecordid))
                {
                    // 将优惠券置为已使用
                    couponrecord = this.couponrecordservice
                            .getCouponrecordByid(couponrecordid);

                    if ("0".equals(couponrecord.getIsuse()))
                    {

                        couponrecord.setIsuse("1");
                        couponrecord.setUsertime(CommonTool
                                .getNowDate("yyyy-MM-dd HH:mm:ss"));
                        // couponrecord.setConsumptionid(consumption.getId());
                        this.couponrecordservice
                                .updateCouponrecord(couponrecord);

                        Coupon coupon = this.couponservice
                                .getCouponByid(couponrecord.getCouponid());

                        money = CommonTool.numberMinusFloat(money,
                                coupon.getMoney());
                    }
                }

                // Member member = this.memberservice.getMemberByid(memberid);
                member.setBalance(CommonTool.numberMinusFloat(
                        member.getBalance(), money));
                this.memberservice.updateMember(member);

                Consumption consumption = new Consumption();
                consumption.setMemberid(memberid);
                consumption.setMoney(money);
                Date nowdate = CommonTool
                        .getNowDateBySDF("yyyy-MM-dd HH:mm:ss");
                consumption.setIntime(nowdate);
                consumption.setReasons("线下消费");
                consumption.setStatus("0");
                consumption.setType("0");
                consumption.setBizid(bid);
                String result = this.consumptionservice
                        .addConsumption(consumption);

                // 增加相应积分
                if (!CommonTool.isEmpty(result))
                {
                    if (couponrecord != null)
                    {
                        // 更新消费ID
                        couponrecord.setConsumptionid(consumption.getId());
                        this.couponrecordservice
                                .updateCouponrecord(couponrecord);
                    }

                    List<Integralrule> integralrulelist = this.integralruleservice
                            .getIntegralruleByBid(bid);

                    if (!CommonTool.isEmpty(integralrulelist)
                            && integralrulelist.size() == 1)
                    {
                        Integralrule integralrule = integralrulelist.get(0);
                        String integral = ServiceTool.getIntegralOnRuleByMoney(
                                integralrule, money);

                        if (member != null)
                        {
                            member.setIntegral(CommonTool.numberAdd(
                                    member.getIntegral(), integral));
                            this.memberservice.updateMember(member);

                            // 更新消费记录
                            consumption.setBalance(member.getBalance());
                            this.consumptionservice
                                    .updateConsumption(consumption);

                            // 增加积分消费记录
                            this.integralservice.addIntegral(member, "0",
                                    integral, "消费获取");
                        }

                    }

                    resp.setResult("success");
                    resp.setT(member.getIntegral()
                            + '_'
                            + CommonTool.conversionDate(nowdate,
                                    "yyyy-MM-dd HH:mm:ss"));
                    resp.setMessage("operate ok!");
                    CommonLogger.info("添加会员消费记录成功！返回对象：" + resp.toString());
                }
                else
                {

                    resp.setResult("error");
                    resp.setMessage("添加消费记录失败");
                    CommonLogger.info("添加消费记录失败");

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

    @RequestMapping("/updateConsumption")
    public ModelAndView updateConsumption(String id, String memberid,
            String money, String reasons, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String parentSourcePage)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            if (!CommonTool.isEmpty(id))
            {
                Consumption consumption = this.consumptionservice
                        .getConsumptionByid(id);

                if (consumption == null)
                {
                    consumption = new Consumption();

                    consumption.setMoney(money);
                    consumption.setIntime(CommonTool
                            .getNowDateBySDF("yyyy-MM-dd HH:mm:ss"));
                    consumption.setReasons(reasons);
                    consumption.setStatus("0");

                    consumption.setId(id);
                    consumption.setBizid(bid);
                    this.consumptionservice.addConsumption(consumption);
                }
                else
                {
                    consumption.setMoney(money);
                    consumption.setReasons(reasons);
                    consumption.setBizid(bid);
                    this.consumptionservice.updateConsumption(consumption);
                }
                map.put("consumption", consumption);
            }

        }
        catch (Exception e)
        {
            CommonLogger.error("update Consumption出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        String url = "warnframe";
        map.put("warnMessagekey", "alert.message.success");
        map.put("returnUrl", parentSourcePage);
        return new ModelAndView(url, map);
        // return new ModelAndView("redirect:/zj/getMember.kq");
    }

    @RequestMapping("/getConsumptionForward")
    public ModelAndView getConsumptionForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        return new ModelAndView("/app/zjconsumption/salelist");
    }

}
