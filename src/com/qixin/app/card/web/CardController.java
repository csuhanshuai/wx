package com.qixin.app.card.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.card.model.Config;
import com.qixin.app.card.model.PrizeConfig;
import com.qixin.app.card.model.Prizerecord;
import com.qixin.app.card.service.cardServices;
import com.qixin.app.system.user.service.ISystemmgtUserService;
import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.app.zjminweb.service.MemberService;

@Controller
@RequestMapping("/card")
public class CardController
{

    @Resource
    private cardServices services;

    @Resource
    private ISystemmgtUserService systemmgtUserService;

    @Resource
    private MemberService memberService;

    @Resource
    private IntegralexchangerecordService integralexchangerecordservice;

    /**
     * 去主页
     * 
     * @param openId
     * @param userId
     * @param bid
     * @return
     */
    @RequestMapping("/zjminweb/toMain")
    public ModelAndView toMain(String openid, String bid, ModelMap m,
            String activitiesid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = "0";
        map.put("openid", openid);

        try
        {

            Prizerecord employee = services.queryEmployeesByOpenId(openid);
            if (employee == null)
            {
                Config config = services.queryConfigByName("number");
                int number = 5;
                if (config != null)
                {
                    number = Integer.parseInt(config.getInfo().trim());
                }

                employee = new Prizerecord();
                employee.setOpenid(openid);
                employee.setNumber(number);
                employee.setIsprizes(0);
                employee.setIsreg(0);
                employee.setActivitiesid(activitiesid);
                services.addEmployee(employee);
            }

            // 抽奖次数用完
            if (employee.getNumber() <= 0)
            {
                // 跳转 中奖纪录？
                map.put("numberover", "1");
            }
            else
            {

                if (employee.getPrizename() != null)
                {
                    // 已中奖

                    // 返回不中奖
                    id = Rand(3);

                }
                else
                {

                    id = Rand(1);

                }
                if (employee.getPrizename() == null
                        && employee.getNumber() == 1)
                {
                    // 最后一次 必须中奖
                    id = Rand(2);
                }
                // 跟新刮奖次数
                employee.setNumber(employee.getNumber() - 1);

                PrizeConfig g = services.queryPrizeConfigById(id);
                if (g.getIsprize() == 1 && g.getNumber() > 0)
                {

                    // 插入记录到 兑换表
                    Member member = this.memberService
                            .getMemberByOpenid(openid);

                    Integralexchangerecord integralexchangerecord = new Integralexchangerecord();
                    integralexchangerecord.setMemberid(member != null ? member
                            .getId() : null);
                    integralexchangerecord.setIntegralexchangeid("");
                    integralexchangerecord.setIsreceive("1");
                    integralexchangerecord.setReceivetime(CommonTool
                            .getNowDate("yyyy-MM-dd HH:mm:ss"));
                    integralexchangerecord.setIsuse("0");

                    integralexchangerecord.setBizid(bid);
                    integralexchangerecord.setType("2");
                    integralexchangerecord.setActivitiesid(activitiesid);
                    integralexchangerecord.setGiftid(g.getGiftid());
                    
                    // 短ID
                    integralexchangerecord.setId(ShortUUID.generateShortUuid());
                    
                    this.integralexchangerecordservice
                            .addIntegralexchangerecord(integralexchangerecord);

                    // PrizeInfo info=new PrizeInfo();
                    // employee.setPrizeId(g.getId());
                    employee.setPrizename(g.getName());

                    // 更新奖品个数
                    g.setNumber(g.getNumber() - 1);
                    this.services.addPrizeConfig(g);

                }
                services.addEmployee(employee);

                map.put("path", g.getPath());
            }
            if (employee.getPrizename() != null)
            {

                map.put("but", "1");
            }

            Config c = services.queryConfigByName("activityExplain");
            String[] activityExplain = c.getInfo().split("\r\n");
            map.put("activityExplain", activityExplain);

            c = services.queryConfigByName("prize");
            String[] prize = c.getInfo().split("\r\n");
            map.put("prize", prize);

            c = services.queryConfigByName("time");
            map.put("time", c.getInfo());

            c = services.queryConfigByName("background");
            map.put("background", c.getInfo());
        }
        catch (Exception e)
        {
            // 添加中奖记录失败
            e.printStackTrace();
        }
        return new ModelAndView("/app/card/ggk", map);

    }

    @RequestMapping("/zjminweb/addEmployee")
    public ModelAndView addEmployee(String openid, String name,
            String mobilephone, HttpServletRequest request,
            HttpServletResponse response)
    {

        Prizerecord employee = services.queryEmployeesByOpenId(openid);
        employee.setMobilephone(mobilephone);
        employee.setName(name);
        employee.setIsreg(1);
        services.addEmployee(employee);

        return toPrizeInfo(openid);

    }

    @RequestMapping("/toAddEmployeeSucc")
    public ModelAndView toAddCustomerSucc()
    {

        return new ModelAndView("/app/article/addEmployeeSucc");

    }

    /**
     * 去中奖纪录
     * 
     * @param id
     * @return
     */
    @RequestMapping("/zjminweb/toPrizeInfo")
    public ModelAndView toPrizeInfo(String openid)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Prizerecord employee = services.queryEmployeesByOpenId(openid);
        map.put("openid", openid);
        if (employee.getName() == null)
        {
            // 去填写信息
            return new ModelAndView("/app/card/employee", map);
        }

        Config c = services.queryConfigByName("time");
        map.put("time", c.getInfo());

        c = services.queryConfigByName("expiredTime");
        map.put("expiredTime", c.getInfo());

        map.put("employee", employee);

        return new ModelAndView("/app/card/prizeInfo", map);
    }

    @RequestMapping("/toPrizes")
    public ModelAndView toPrizes(String openid)
    {
        try
        {
            // Map<String, Object> map = new HashMap<String, Object>();

            Prizerecord employee = services.queryEmployeesByOpenId(openid);
            employee.setIsprizes(1);
            services.addEmployee(employee);

            // 还需要更新 奖品兑换表的信息
            Member member = this.memberService.getMemberByOpenid(openid);
            Integralexchangerecord record = this.integralexchangerecordservice
                    .getIntegralexchangerecordBytype(member.getId(),
                            employee.getActivitiesid(), "2");
            if (record != null)
            {
                record.setIsuse("1");
                record.setUsertime(CommonTool.getNowDate("yyyy-MM-dd HH:mm:ss"));
                this.integralexchangerecordservice
                        .updateIntegralexchangerecord(record);
            }

        }
        catch (Exception e)
        {
            // 兑换失败
        }
        return toPrizeInfo(openid);
    }

    public static void main(String[] a)
    {

        // int n = 0;
        // for (int i = 1; i < 100; i++) {
        //
        // int num = i % 10;
        // if (num == 0) {
        // n++;
        // }
        //
        // }

        for (int i = 1; i < 100; i++)
        {

            // System.out.println(Rand(0));

        }
        // Rand(0);

        // System.out.println(n);
    }

    private String Rand(int type)
    {
        int sum = 100;
        // 概率数组的总概率精度
        List<PrizeConfig> pcList = services.queryPrizeConfig();
        for (PrizeConfig p : pcList)
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

        return Rand(type);
    }

}
