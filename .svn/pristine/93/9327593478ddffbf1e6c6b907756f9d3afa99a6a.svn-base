package com.qixin.app.wobble.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.wobble.model.Wobbleprize;
import com.qixin.app.wobble.model.Wobbleprizerecord;
import com.qixin.app.wobble.service.WobbleprizeService;
import com.qixin.app.wobble.service.WobbleprizerecordService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class WobbleprizerecordController
{
    @Resource
    private WobbleprizerecordService prizerecordservice;

    @Resource
    private WobbleprizeService prizeservice;

    @Resource
    private ActivitiesService activitiesservice;

    @Resource
    private MemberService memberservice;

    @Resource
    private IntegralexchangerecordService integralexchangerecordservice;

    @RequestMapping("/zjminweb/addPrizerecordForward")
    public ModelAndView addPrizerecordForward(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid,
            String activitiesid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);
        return new ModelAndView("/app/zjwobble/addprizerecord", map);
    }

    @RequestMapping("/zjminweb/winForward")
    public ModelAndView winForward(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid,
            String activitiesid)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        try
        {
            Activities activities = this.activitiesservice
                    .getActivitiesByid(activitiesid);
            map.put("activities", activities);

            Wobbleprizerecord wobbleprizerecord = this.prizerecordservice
                    .getPrizerecordByOpenId(openid, bid, activitiesid);
            map.put("wobbleprizerecord", wobbleprizerecord);

            if (wobbleprizerecord != null)
            {
                Wobbleprize wobbleprize = this.prizeservice.getPrizeByid(
                        wobbleprizerecord.getPrizeid(), bid);
                map.put("wobbleprize", wobbleprize);
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("winForward 出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        map.put("openid", openid);
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);
        return new ModelAndView("/app/zjwobble/win", map);
    }

    @RequestMapping("/zjminweb/addPrizerecord")
    public void addPrizerecord(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid,
            String activitiesid, String username, String phone)
    {
        PrintWriter out = null;
        Response<Map<String, Object>> resp = new Response<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("openid", openid);
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);

        try
        {
            out = response.getWriter();

            Wobbleprizerecord wobbleprizerecord = this.prizerecordservice
                    .getPrizerecordByWin(openid, bid, activitiesid);
            if (wobbleprizerecord != null)
            {
                wobbleprizerecord.setName(username);
                wobbleprizerecord.setMobilephone(phone);
                String result = this.prizerecordservice
                        .updatePrizerecord(wobbleprizerecord);

                if (!CommonTool.isEmpty(result))
                {
                    resp.setResult("success");
                    resp.setT(map);
                    resp.setMessage("填写中奖信息成功");
                    CommonLogger.info("填写中奖信息成功！返回对象：" + resp.toString());
                    out.print(JSONObject.fromObject(resp).toString());
                }
                else
                {
                    resp.setResult("error");
                    resp.setMessage("填写中奖信息失败");
                    CommonLogger.info("填写中奖信息失败！返回对象：" + resp.toString());
                    out.print(JSONObject.fromObject(resp).toString());
                }
            }
            else
            {
                resp.setResult("error");
                resp.setMessage("您没有中奖信息");
                CommonLogger.info("您没有中奖信息！返回对象：" + resp.toString());
                out.print(JSONObject.fromObject(resp).toString());
            }

        }
        catch (Exception e)
        {
            CommonLogger.error("addPrizerecord出错 :", e);
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

    @RequestMapping("/wobble/getPrizerecord")
    public ModelAndView getPrizerecord(HttpServletRequest request,
            HttpServletResponse response, String activitiesid, String name,
            String mobilephone, String isreg, Query query, String ids)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        try
        {
            // 批量兑换

            if (!CommonTool.isEmpty(ids))
            {
                String idArr[] = ids.split("\\|");
                for (String id : idArr)
                {
                    Wobbleprizerecord prizerecord = this.prizerecordservice
                            .getPrizerecordByid(id);
                    if (prizerecord != null)
                    {
                        prizerecord.setIsreg(1);
                        this.prizerecordservice.updatePrizerecord(prizerecord);

                        // 还需要更新 奖品兑换表的信息
                        Member member = this.memberservice
                                .getMemberByOpenid(prizerecord.getOpenid());
                        Integralexchangerecord record = this.integralexchangerecordservice
                                .getIntegralexchangerecordBytype(
                                        member.getId(),
                                        prizerecord.getActivitiesid(), "3");
                        if (record != null)
                        {
                            record.setIsuse("1");
                            record.setUsertime(CommonTool
                                    .getNowDate("yyyy-MM-dd HH:mm:ss"));
                            this.integralexchangerecordservice
                                    .updateIntegralexchangerecord(record);
                        }

                    }
                }

            }

            // 查询
            PageFinder<Wobbleprizerecord> pageFinder = prizerecordservice
                    .getPrizerecordBybid(query, bid, activitiesid, name,
                            mobilephone, isreg);
            map.put("pageFinder", pageFinder);
        }
        catch (Exception e)
        {
            CommonLogger.error("get prizerecord byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);
        map.put("name", name);
        map.put("mobilephone", mobilephone);
        map.put("isreg", isreg);
        return new ModelAndView("/app/zjwobble/prizerecord", map);
    }
}
