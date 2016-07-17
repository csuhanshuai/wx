package com.qixin.app.wobble.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.wobble.model.Wobbleconfig;
import com.qixin.app.wobble.model.Wobbleprize;
import com.qixin.app.wobble.model.Wobbleprizerecord;
import com.qixin.app.wobble.service.WobbleconfigService;
import com.qixin.app.wobble.service.WobbleprizeService;
import com.qixin.app.wobble.service.WobbleprizerecordService;
import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.log.CommonLogger;

@Controller
@RequestMapping("/zj")
public class WobbleprizeController
{
    @Resource
    private WobbleprizeService prizeservice;

    @Resource
    private WobbleprizerecordService prizerecordservice;

    @Resource
    private ActivitiesService activitiesservice;

    @Resource
    private WobbleconfigService configservice;

    @Resource
    private GiftService giftservices;

    @Resource
    private IntegralexchangerecordService integralexchangerecordservice;

    @Resource
    private MemberService memberservice;

    @RequestMapping("/wobble/getPrize")
    public ModelAndView getPrize(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            List<Wobbleprize> wobbleprizelist = prizeservice.getPrizeBybid(bid);
            map.put("wobbleprizelist", wobbleprizelist);

            // 查询配置信息
            Wobbleconfig cobbleconfig = this.configservice
                    .getWobbleconfigByName("number");
            map.put("cobbleconfig", cobbleconfig);

            map.put("giftlist", this.giftservices.getGiftListBybid(bid));
        }
        catch (Exception e)
        {
            CommonLogger.error("get prize byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("bid", bid);
        return new ModelAndView("/app/zjwobble/prize", map);
    }

    @RequestMapping("/wobble/updatePrize")
    public ModelAndView updatePrize(HttpServletRequest request,
            HttpServletResponse response, String info)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        String[] id = request.getParameterValues("id");
        String[] name = request.getParameterValues("name");
        String[] isprize = request.getParameterValues("isprize");
        String[] number = request.getParameterValues("number");
        String[] v = request.getParameterValues("v");
        String[] description = request.getParameterValues("description");
        String[] giftid = request.getParameterValues("giftid");

        Wobbleprize a = null;
        try
        {
            for (int i = 0; i < id.length; i++)
            {
                a = this.prizeservice.getPrizeByid(id[i], bid);
                if (a != null)
                {

                    // a.setId(id[i]);
                    a.setName(name[i]);
                    a.setIsprize(Integer.parseInt(isprize[i]));
                    a.setNumber(Integer.parseInt(number[i]));
                    a.setV(Integer.parseInt(v[i]));
                    a.setDescription(description[i]);

                    if (!CommonTool.isEmpty(giftid[i]))
                    {
                        a.setGiftid(giftid[i]);

                        // 查询原数目
                        Wobbleprize aw = this.prizeservice.getPrizeByid(id[i],
                                bid);

                        // 查询奖品信息
                        Gift gift = this.giftservices.getGiftByid(giftid[i]);
                        gift.setNumber(gift.getNumber()
                                + (aw.getNumber() - Integer.parseInt(number[i])));
                        this.giftservices.updateGift(gift);
                    }
                    // else
                    // {
                    // a.setGiftid("");
                    // }

                    this.prizeservice.updatePrize(a);
                }
            }

            if (!CommonTool.isEmpty(number) && !"0".equals(number))
            {
                Wobbleconfig wobbleconfig = this.configservice
                        .getWobbleconfigByName("number");
                if (wobbleconfig != null)
                {
                    wobbleconfig.setInfo(info);
                    this.configservice.updateWobbleconfig(wobbleconfig);

                }
                else
                {
                    Wobbleconfig wc = new Wobbleconfig();
                    wc.setIllustrate("初始可抽奖次数");
                    wc.setInfo("1");
                    wc.setName("number");
                    wc.setType(2);
                    this.configservice.addWobbleconfig(wc);

                }
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("updatePrize byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        map.put("bid", bid);
        return new ModelAndView("redirect:getPrize.kq", map);
    }

    @RequestMapping("/zjminweb/getWobble")
    public ModelAndView getWobble(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid,
            String activitiesid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);

        try
        {
            // 获取用户是否中过奖
            Wobbleprizerecord wobbleprizerecord = this.prizerecordservice
                    .getPrizerecordByWin(openid, bid, activitiesid);
            if (wobbleprizerecord != null)
            {
                return new ModelAndView("redirect:winForward.kq", map);
            }

            // 1.查询活动对象
            Activities activities = this.activitiesservice
                    .getActivitiesByid(activitiesid);
            map.put("activities", activities);
            map.put("timedifference",
                    CommonTool.getTimeDifference(activities.getEndtime()));

            // 2.查询奖项设置信息
            List<Wobbleprize> wobbleprizelist = this.prizeservice
                    .getPrizeBybid(bid);
            // 去空操作
            map.put("wobbleprizelist",
                    ServiceTool.getWobbleprize(wobbleprizelist));
        }
        catch (Exception e)
        {
            CommonLogger.error("get activities出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjwobble/wobble", map);
    }

    @RequestMapping("/zjminweb/shake")
    public void shake(String openid, String bid, ModelMap m,
            HttpServletRequest request, HttpServletResponse response,
            String activitiesid)
    {
        PrintWriter out = null;
        Response<Map<String, Object>> resp = new Response<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        String id = "0";

        map.put("openid", openid);
        map.put("bid", bid);
        map.put("activitiesid", activitiesid);

        try
        {
            out = response.getWriter();

            Wobbleprizerecord employee = this.prizerecordservice
                    .getPrizerecordByOpenId(openid, bid, activitiesid);
            if (employee == null)
            {
                Wobbleconfig wc = this.configservice
                        .getWobbleconfigByName("number");
                employee = new Wobbleprizerecord();
                employee.setOpenid(openid);
                employee.setNumber(Integer.parseInt(wc.getInfo()));
                employee.setIsprizes(0);
                employee.setIsreg(0);
                employee.setBizid(bid);
                employee.setActivitiesid(activitiesid);
                prizerecordservice.addPrizerecord(employee);
            }
            else
            {
                // 抽奖次数用完
                if (employee.getNumber() <= 0)
                {
                    // 跳转 中奖纪录？
                    resp.setResult("error");
                    resp.setMessage("抽奖次数用完");
                    CommonLogger.info("抽奖次数用完！返回对象：" + resp.toString());
                    out.print(JSONObject.fromObject(resp).toString());
                    return;
                }

            }

            if (employee.getPrizeid() != null)
            {
                // 已中奖

                // 返回不中奖
                id = Rand(3, bid);

                resp.setResult("error");
                resp.setMessage("您已中奖过了");
                CommonLogger.info("已中奖过了！返回对象：" + resp.toString());
                out.print(JSONObject.fromObject(resp).toString());
                return;

            }
            else
            {

                id = Rand(1, bid);

            }
            /*
             * if (employee.getPrizeid() == null && employee.getNumber() == 1) {
             * // 最后一次 必须中奖 id = Rand(2, bid); }
             */
            // 跟新刮奖次数
            employee.setNumber(employee.getNumber() - 1);

            Wobbleprize g = prizeservice.getPrizeByid(id, bid);
            if (g.getIsprize() == 1 && g.getNumber() > 0)
            {

                // 插入记录到 兑换表
                Member member = this.memberservice.getMemberByOpenid(openid);

                Integralexchangerecord integralexchangerecord = new Integralexchangerecord();
                integralexchangerecord.setMemberid(member != null ? member
                        .getId() : null);
                integralexchangerecord.setIntegralexchangeid("");
                integralexchangerecord.setIsreceive("1");
                integralexchangerecord.setReceivetime(CommonTool
                        .getNowDate("yyyy-MM-dd HH:mm:ss"));
                integralexchangerecord.setIsuse("0");

                integralexchangerecord.setBizid(bid);
                integralexchangerecord.setType("3");
                integralexchangerecord.setActivitiesid(activitiesid);
                integralexchangerecord.setGiftid(g.getGiftid());

                // 短ID
                integralexchangerecord.setId(ShortUUID.generateShortUuid());

                this.integralexchangerecordservice
                        .addIntegralexchangerecord(integralexchangerecord);

                employee.setPrizeid(g.getId());
                employee.setIsprizes(1);

                // 更新奖品个数
                g.setNumber(g.getNumber() - 1);
                this.prizeservice.updatePrize(g);

                prizerecordservice.addPrizerecord(employee);
            }
            else
            {
                prizerecordservice.addPrizerecord(employee);
                resp.setResult("error");
                resp.setMessage(g.getName());
                CommonLogger.info(g.getName() + "！返回对象：" + resp.toString());
                out.print(JSONObject.fromObject(resp).toString());
                return;
            }

            map.put("prizerecord", employee);
            map.put("prize", g);

            resp.setResult("success");
            resp.setT(map);
            resp.setMessage("摇奖成功");
            CommonLogger.info("摇奖成功！返回对象：" + resp.toString());
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("shake出错 :", e);
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

    private String Rand(int type, String bid) throws Exception
    {
        int sum = 100;
        // 概率数组的总概率精度
        List<Wobbleprize> pcList = prizeservice.getPrizeBybid(bid);
        for (Wobbleprize p : pcList)
        {
            // 循环所有
            if (type == 1)
            {

            }
            // 循环中奖奖项
            if (type == 2)
            {
                if (p.getIsprize() == 2)
                {

                    continue;
                }
            }
            // 循环不中奖奖项
            if (type == 3)
            {
                if (p.getIsprize() == 1)
                {

                    continue;
                }
            }

            Random random = new Random();
            int num = random.nextInt(sum) % sum + 1;
            if (num <= p.getV())
            {
                return p.getId();
            }
            else
            {
                sum = sum - p.getV();
            }

        }

        return Rand(type, bid);
    }
}
