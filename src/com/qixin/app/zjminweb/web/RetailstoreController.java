package com.qixin.app.zjminweb.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Retailstore;
import com.qixin.app.zjminweb.service.RetailstoreService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class RetailstoreController
{
    @Resource
    private RetailstoreService retailstoreservice;

    @RequestMapping("/getRetailstore")
    public ModelAndView getRetailstore(HttpServletRequest request,
            HttpServletResponse response, Query query)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            PageFinder<Retailstore> pageFinder = this.retailstoreservice
                    .getRetailstoreByBid(query, bid);
            map.put("pageFinder", pageFinder);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Retailstore byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjretailstore/list", map);
    }

    @RequestMapping("/addRetailstoreForward")
    public ModelAndView addRetailstoreForward(HttpServletRequest request,
            HttpServletResponse response, String type, String id)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        if (type != null && !"".equals(type) && "mod".equals(type)
                && id != null && !"".equals(id))
        {

            try
            {
                Retailstore retailstore = this.retailstoreservice
                        .getRetailstoreByid(id);
                if (retailstore == null)
                {
                    retailstore = new Retailstore();
                }
                map.put("retailstore", retailstore);
                map.put("bid", bid);
            }
            catch (Exception e)
            {
                CommonLogger.error("add retailstore 出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }

        }

        map.put("type", type);

        // 需要加入bid，否则上传组件在页面不可见
        map.put("bid", bid);

        return new ModelAndView("/app/zjretailstore/add", map);
    }

    @RequestMapping("/addRetailstore")
    public ModelAndView addRetailstore(String ImgPath, String name,
            String telephone, String address, String description,
            String longitude, String latitude, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Retailstore msg = new Retailstore();
            msg.setUrl(ImgPath);
            msg.setDescription(description);
            msg.setName(name);
            msg.setTelephone(telephone);
            msg.setAddress(address);
            msg.setBizid(bid);
            msg.setLongitude(longitude);
            msg.setLatitude(latitude);
            this.retailstoreservice.addRetailstore(msg);
            map.put("retailstore", msg);
        }
        catch (Exception e)
        {
            CommonLogger.error("add Retailstore出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getRetailstore.kq");
    }

    @RequestMapping("/removeRetailstore")
    public ModelAndView removeRetailstore(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.retailstoreservice.removeRetailstore(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove Retailstore出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getRetailstore.kq", map);
    }

    @RequestMapping("/updateRetailstore")
    public ModelAndView updateRetailstore(String id, String ImgPath,
            String name, String telephone, String address, String description,
            String longitude, String latitude, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Retailstore retailstore = this.retailstoreservice
                    .getRetailstoreByid(id);

            if (retailstore == null)
            {
                retailstore = new Retailstore();

                retailstore.setUrl(ImgPath);
                retailstore.setDescription(description);
                retailstore.setName(name);
                retailstore.setTelephone(telephone);
                retailstore.setAddress(address);
                retailstore.setBizid(bid);
                retailstore.setId(id);
                retailstore.setLongitude(longitude);
                retailstore.setLatitude(latitude);
                this.retailstoreservice.addRetailstore(retailstore);
            }
            else
            {

                retailstore.setUrl(ImgPath);
                retailstore.setDescription(description);
                retailstore.setName(name);
                retailstore.setTelephone(telephone);
                retailstore.setAddress(address);
                retailstore.setBizid(bid);
                retailstore.setLongitude(longitude);
                retailstore.setLatitude(latitude);
                this.retailstoreservice.updateRetailstore(retailstore);
            }

            map.put("retailstore", retailstore);
        }
        catch (Exception e)
        {
            CommonLogger.error("update Retailstore出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getRetailstore.kq");
    }

    @RequestMapping("/getRetailstoreDetailForward/{id}")
    public ModelAndView getRetailstoreDetailForward(HttpServletRequest request,
            HttpServletResponse response, @PathVariable
            String id, ModelMap map)
    {
        try
        {
            Retailstore retailstore = null;
            if (!CommonTool.isEmpty(id))
            {
                retailstore = this.retailstoreservice.getRetailstoreByid(id);
                if (retailstore == null)
                {
                    retailstore = new Retailstore();
                }
            }
            map.put("retailstore", retailstore);
        }
        catch (Exception e)
        {
            CommonLogger.error("get retailstoreDetail byid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjretailstore/detail");
    }

    @RequestMapping("/zjminweb/getRetailstoreList")
    public ModelAndView getRetailstoreList(HttpServletRequest request,
            HttpServletResponse response, String bid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            List<Retailstore> retailstorelist = this.retailstoreservice
                    .getRetailstoreByBid(bid);

            if (retailstorelist == null)
            {
                retailstorelist = new ArrayList<Retailstore>();
            }
            map.put("retailstorelist", retailstorelist);

            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get retailstore byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjminweb/retailstore", map);
    }

}
