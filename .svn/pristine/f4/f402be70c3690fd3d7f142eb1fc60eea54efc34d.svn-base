package com.qixin.app.zjminweb.web;

import java.io.PrintWriter;
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

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class GiftController
{
    @Resource
    private GiftService giftservice;

    @RequestMapping("/getGift")
    public ModelAndView getGift(HttpServletRequest request,
            HttpServletResponse response, Query query, ModelMap map)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        try
        {

            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            PageFinder<Gift> pageFinder = this.giftservice.getGift(query, bid);
            map.put("pageFinder", pageFinder);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Gift byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjgift/list", map);
    }

    @RequestMapping("/addGiftForward")
    public ModelAndView addGiftForward(HttpServletRequest request,
            HttpServletResponse response, String type, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);

        if (!CommonTool.isEmpty(type) && "mod".equals(type))
        {
            try
            {
                Gift gift = this.giftservice.getGiftByid(id);
                map.put("gift", gift);
            }
            catch (Exception e)
            {
                CommonLogger.error("get Gift byBid出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }
        }
        return new ModelAndView("/app/zjgift/add", map);
    }

    @RequestMapping("/addGift")
    public ModelAndView addGift(String name, String number, String description,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            Gift gift = new Gift();

            gift.setName(name);
            gift.setNumber(Long.valueOf(number).longValue());
            gift.setDescription(description);
            gift.setIntime(CommonTool.getNowDateBySDF("yyyy-MM-dd HH:mm:ss"));
            gift.setBizid(bid);
            gift.setStatus("0");

            this.giftservice.addGift(gift);
            map.put("gift", gift);

        }
        catch (Exception e)
        {
            CommonLogger.error("add gift出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getGift.kq");
    }

    @RequestMapping("/updateGift")
    public ModelAndView updateGift(String name, String number,
            String description, HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String id)
    {
        try
        {

            Gift gift = this.giftservice.getGiftByid(id);

            gift.setName(name);
            gift.setNumber(Long.valueOf(number).longValue());
            gift.setDescription(description);

            this.giftservice.updateGift(gift);
            map.put("gift", gift);

        }
        catch (Exception e)
        {
            CommonLogger.error("update gift出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getGift.kq");
    }

    @RequestMapping("/updateGiftBystatus")
    public ModelAndView updateGiftBystatus(String status,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map, String id)
    {
        try
        {

            Gift gift = this.giftservice.getGiftByid(id);

            if (!CommonTool.isEmpty(status) && "0".equals(status))
            {
                gift.setStatus(status);
            }
            else
            {
                gift.setStatus("1");
            }

            this.giftservice.updateGift(gift);
            map.put("gift", gift);

        }
        catch (Exception e)
        {
            CommonLogger.error("update gift出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getGift.kq");
    }

    @RequestMapping("/getGiftListBybid")
    public void getGiftListBybid(HttpServletRequest request,
            HttpServletResponse response)
    {
        PrintWriter out = null;
        Response<List<Gift>> resp = new Response<List<Gift>>();
        try
        {
            out = response.getWriter();

            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            List<Gift> giftlist = this.giftservice.getGiftListBybid(bid);

            if (CommonTool.isEmpty(giftlist))
            {
                CommonLogger.info("没有查询到记录");
                resp.setResult("error");
                resp.setMessage("查询无数据！");
            }
            else
            {

                resp.setResult("success");
                resp.setT(giftlist);
                resp.setMessage("operate ok!");

                CommonLogger.info("查询礼品列表成功！返回对象：" + resp.toString());
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("get giftlist Bybid出错 :", e);
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

    @RequestMapping("/getGiftByid")
    public void getGiftByid(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        PrintWriter out = null;
        Response<Gift> resp = new Response<Gift>();
        try
        {
            out = response.getWriter();

            Gift gift = this.giftservice.getGiftByid(id);

            if (gift == null)
            {
                CommonLogger.info("没有查询到记录");
                resp.setResult("error");
                resp.setMessage("查询无数据！");
            }
            else
            {

                resp.setResult("success");
                resp.setT(gift);
                resp.setMessage("operate ok!");

                CommonLogger.info("查询礼品成功！返回对象：" + resp.toString());
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("get giftlist Bybid出错 :", e);
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
