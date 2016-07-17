package com.qixin.app.zjminweb.web;

import java.util.Date;
import java.util.HashMap;
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
import com.qixin.app.zjminweb.model.Salespromotion;
import com.qixin.app.zjminweb.service.SalespromotionService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class SalespromotionController
{
    @Resource
    private SalespromotionService salespromotionservice;

    @RequestMapping("/getSalespromotion")
    // @ResponseBody
    public ModelAndView getSalespromotion(HttpServletRequest request,
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

            PageFinder<Salespromotion> pageFinder = this.salespromotionservice
                    .getSalespromotion(query, bid);
            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Salespromotion byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjsalespromotion/list", map);
    }

    @RequestMapping("/addSalespromotionForward")
    public ModelAndView addSalespromotionForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        map.put("bid", bid);
        return new ModelAndView("/app/zjsalespromotion/add", map);
    }

    @RequestMapping("/addSalespromotion")
    public ModelAndView addSalespromotion(String name, String money,
            String starttime, String endtime, String usablerange,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Salespromotion salespromotion = new Salespromotion();
            salespromotion.setName(name);
            salespromotion.setMoney(money);
            salespromotion.setStarttime(CommonTool.conversionDate(starttime,
                    "yyyy-MM-dd"));
            salespromotion.setEndtime(CommonTool.conversionDate(endtime,
                    "yyyy-MM-dd"));
            salespromotion.setUsablerange(Long.parseLong(usablerange));
            salespromotion.setStatus("0");
            salespromotion.setType("0");
            salespromotion.setIntime(new Date());
            salespromotion.setBizid(bid);
            this.salespromotionservice.addSalespromotion(salespromotion);
            map.put("salespromotion", salespromotion);
        }
        catch (Exception e)
        {
            CommonLogger.error("add salespromotion出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getSalespromotion.kq");
    }

    @RequestMapping("/updateSalespromotion")
    public ModelAndView updateSalespromotion(String id, String status,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Salespromotion salespromotion = this.salespromotionservice
                    .getSalespromotionByid(id);

            if (salespromotion != null)
            {
                salespromotion.setStatus(status);
                salespromotion.setBizid(bid);
                this.salespromotionservice.updateSalespromotion(salespromotion);
            }

            map.put("salespromotion", salespromotion);
        }
        catch (Exception e)
        {
            CommonLogger.error("update salespromotion出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getSalespromotion.kq");
    }

}
