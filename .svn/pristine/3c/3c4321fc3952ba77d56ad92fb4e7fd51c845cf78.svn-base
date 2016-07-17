package com.qixin.app.card.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.card.model.Config;
import com.qixin.app.card.model.PrizeConfig;
import com.qixin.app.card.model.Prizerecord;
import com.qixin.app.card.service.cardServices;
import com.qixin.app.common.Tool;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/cardManage")
public class ManageController
{

    @Resource
    private cardServices services;

    @Resource
    private GiftService giftservices;

    @RequestMapping("/toExcel")
    public void toExcel(HttpServletRequest request, HttpServletResponse response)
    {

        String[][] title = { { "姓名", "所在地", "经销商", "联系电话", "身份证号", "购买日期" },
                { "30", "30", "30", "30", "40", "30" } };

        List<Prizerecord> elist = services.queryEmployeeList();
        String[][] data = new String[elist.size()][5];
        int i = 0;
        for (Prizerecord e : elist)
        {
            data[i][0] = e.getName();

            // data[i][1] = e.getArea() == 1 ? "广东" : e.getArea() == 2 ? "江西"
            // : "福建";
            // data[i][2] = e.getDealer();
            data[i][3] = e.getMobilephone();

            i++;
        }
        Tool.getToExcel("会员信息", title, data, request, response);

    }

    @RequestMapping("/queryEmployeeList")
    public ModelAndView queryEmployeeList(@ModelAttribute("employee")
    @Valid
    Prizerecord employee, Query query, HttpServletRequest request,
            HttpServletResponse response, String activitiesid)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        query = (query != null) ? query : new Query();
        query.setPageSize(10);
        // employee.setIsPrizes(1);
        PageFinder<Prizerecord> list = services.queryEmployees(employee, query);

        map.put("pageFinder", list);

        return new ModelAndView("/app/card/employeeList", map);

    }

    @RequestMapping("/queryConfigList")
    public ModelAndView queryConfigList(HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Config> list = services.queryConfigList();

        map.put("list", list);

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            map.put("giftlist", this.giftservices.getGiftListBybid(bid));
        }
        catch (Exception e)
        {
            CommonLogger.error("get Gift byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/card/configList", map);

    }

    @RequestMapping("/queryPrizeInfoList")
    public ModelAndView queryPrizeInfoList(HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Config> list = services.queryConfigList();

        map.put("list", list);

        return new ModelAndView("/app/card/configList", map);

    }

    @RequestMapping("/queryConfig")
    public ModelAndView queryConfig(String id, HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        Config config = services.queryConfig(id);

        map.put("config", config);

        return new ModelAndView("/app/card/configUpdate", map);

    }

    @RequestMapping("/updateConfig")
    public ModelAndView updateConfig(@RequestParam("id")
    String id, @RequestParam("type")
    String type, @RequestParam("info")
    String info, @RequestParam("file")
    CommonsMultipartFile mfile, HttpServletRequest request,
            HttpServletResponse response)
    {

        Config config = services.queryConfig(id);
        if ("1".equals(type))
        {
            String path = request.getRealPath(File.separator)
                    + config.getInfo();
            if (!mfile.isEmpty())
            {
                File file = new File(path); // 新建一个文件
                try
                {
                    mfile.getFileItem().write(file); // 将上传的文件写入新建的文件中
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            config.setInfo(info);
            services.updateConfig(config);
        }
        return queryConfigList(request, response);
    }

    @RequestMapping("/queryPrizeConfigList")
    public ModelAndView queryPrizeConfigList(HttpServletRequest request,
            HttpServletResponse response)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        List<PrizeConfig> list = services.queryPrizeConfig();
        map.put("list", list);

        // 查询奖品列表
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            map.put("giftlist", this.giftservices.getGiftListBybid(bid));
        }
        catch (Exception e)
        {
            CommonLogger.error("get Gift byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/card/prizeConfigList", map);
    }

    @RequestMapping("/toAddPrizeConfig")
    public ModelAndView toAddPrizeConfig(HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            map.put("giftlist", this.giftservices.getGiftListBybid(bid));
        }
        catch (Exception e)
        {
            CommonLogger.error("get Gift byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/card/prizeConfig", map);
    }

    @RequestMapping("/queryPrizeConfig")
    public ModelAndView queryPrizeConfig(String id, HttpServletRequest request,
            HttpServletResponse response)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        PrizeConfig p = services.queryPrizeConfigById(id);
        map.put("prizeConfig", p);

        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            map.put("giftlist", this.giftservices.getGiftListBybid(bid));
        }
        catch (Exception e)
        {
            CommonLogger.error("get Gift byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/card/prizeConfig", map);
    }

    @RequestMapping("/updatePrizeConfig")
    public ModelAndView updatePrizeConfig(String id, @RequestParam("name")
    String name, @RequestParam("v")
    int v, @RequestParam("isprize")
    int isPrize, @RequestParam("file")
    CommonsMultipartFile mfile, HttpServletRequest request,
            HttpServletResponse response, String giftid, int number)
    {

        PrizeConfig info = new PrizeConfig();
        info.setName(name);
        String i = "0";
        if (id != null)
        {

            i = id;
        }
        else
        {
            i = services.addPrizeConfig(info);
        }

        String path = "/ggk/" + id + ".png";
        info.setId(i);
        info.setPath(path);
        info.setV(v);
        info.setIsprize(isPrize);
        info.setName(name);
        info.setNumber(number);

        try
        {
            if (!CommonTool.isEmpty(giftid))
            {
                info.setGiftid(giftid);

                // 查询原数目
                PrizeConfig aw = services.queryPrizeConfigById(i);

                // 查询奖品信息
                Gift gift = this.giftservices.getGiftByid(giftid);
                gift.setNumber(gift.getNumber() + (aw.getNumber() - number));
                this.giftservices.updateGift(gift);
            }
            // else
            // {
            // info.setGiftid("");
            // }

            if (!mfile.isEmpty())
            {
                File file = new File(request.getRealPath(File.separator) + path); // 新建一个文件
                try
                {
                    mfile.getFileItem().write(file); // 将上传的文件写入新建的文件中
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        services.addPrizeConfig(info);

        return queryPrizeConfigList(request, response);
    }

    /**
     * 删除球队
     * 
     * @param teamInfo
     */
    @RequestMapping("/delTeamInfo")
    public ModelAndView delTeamInfo(int id, HttpServletRequest request,
            HttpServletResponse response)
    {

        services.delPrizeConfig(id);
        File file = new File(File.separator + "ggk" + File.separator + id
                + ".png"); // 新建一个文件

        file.delete();
        return queryPrizeConfigList(request, response);
    }

    /*
     * @RequestMapping("/toDeliveryInfo") public ModelAndView
     * toDeliveryInfo(@ModelAttribute("deliveryInfo")
     * 
     * @Valid PrizeInfo deliveryInfo, Query query, HttpServletRequest request,
     * HttpServletResponse response) { Map<String, Object> map = new
     * HashMap<String, Object>(); query = (query != null) ? query : new Query();
     * query.setPageSize(15); PageFinder<PrizeInfo> list =
     * services.queryPrizeInfoList(deliveryInfo, query);
     * 
     * map.put("pageFinder", list); map.put("deliveryInfo", deliveryInfo);
     * return new ModelAndView("/app/card/deliveryList", map); }
     */
}
