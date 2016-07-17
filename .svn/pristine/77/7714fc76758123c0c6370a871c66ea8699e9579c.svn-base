package com.qixin.app.zjminweb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Integralrule;
import com.qixin.app.zjminweb.service.IntegralruleService;
import com.qixin.platform.log.CommonLogger;

@Controller
@RequestMapping("/zj")
public class IntegralruleController
{
    @Resource
    private IntegralruleService integralruleservice;

    @RequestMapping("/getIntegralrule")
    public ModelAndView getIntegralrule(HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {
                Integralrule integralrule = getIntegralrule(bid);
                map.put("integralrule", integralrule);

            }
            catch (Exception e)
            {
                CommonLogger.error("get integralrulelist byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("/app/zjintegralrule/modify", map);
    }

    private Integralrule getIntegralrule(String bid) throws Exception
    {
        Integralrule integralrule = null;
        List<Integralrule> integralrulelist = this.integralruleservice
                .getIntegralruleByBid(bid);

        if (!CommonTool.isEmpty(integralrulelist)
                && integralrulelist.size() == 1)
        {
            integralrule = integralrulelist.get(0);
        }
        return integralrule;
    }

    @RequestMapping("/updateIntegralrule")
    public ModelAndView updateIntegralrule(HttpServletRequest request,
            HttpServletResponse response, String money, String integral)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (!CommonTool.isEmpty(bid))
        {

            try
            {

                Integralrule integralrule = getIntegralrule(bid);
                if (integralrule != null)
                {

                    integralrule.setMoneyproportion(money);
                    integralrule.setIntegralproportion(integral);
                    this.integralruleservice.updateIntegralrule(integralrule);
                    map.put("integralrule", integralrule);

                }
                else
                {
                    integralrule = new Integralrule();
                    integralrule.setMoneyproportion(money);
                    integralrule.setIntegralproportion(integral);
                    integralrule.setBizid(bid);
                    this.integralruleservice.addIntegralrule(integralrule);

                }

            }
            catch (Exception e)
            {
                CommonLogger.error("update integralrule出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        return new ModelAndView("redirect:getIntegralrule.kq", map);
    }

}
