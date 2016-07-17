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
import com.qixin.app.zjminweb.model.Integral;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.platform.log.CommonLogger;

@Controller
@RequestMapping("/zj")
public class IntegralController
{
    @Resource
    private IntegralService integralservice;

    @RequestMapping("/zjminweb/getIntegral")
    public ModelAndView getIntegral(HttpServletRequest request,
            HttpServletResponse response, String bid, String memberid,
            String type, String openid)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        if (CommonTool.isEmpty(bid))
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            bid = systemUser.getId();

        }

        if (!CommonTool.isEmpty(memberid))
        {

            try
            {
                List<Integral> integrallist = this.integralservice
                        .getIntegralByBid(bid, memberid, type);
                map.put("integrallist", integrallist);

            }
            catch (Exception e)
            {
                CommonLogger.error("get integrallist byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        map.put("bid", bid);
        map.put("memberid", memberid);
        map.put("type", type);
        map.put("openid", openid);
        return new ModelAndView("/app/zjintegral/list", map);
    }
}
