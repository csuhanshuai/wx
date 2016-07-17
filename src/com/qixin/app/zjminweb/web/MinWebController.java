package com.qixin.app.zjminweb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.customlink.model.CustomLink;
import com.qixin.app.customlink.service.CustomLinkService;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.systemlink.model.SystemLink;
import com.qixin.app.systemlink.service.SystemLinkService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.BaseInfo;
import com.qixin.app.zjminweb.model.IndexModel;
import com.qixin.app.zjminweb.model.Membercard;
import com.qixin.app.zjminweb.model.PictureText;
import com.qixin.app.zjminweb.model.ScrollPicture;
import com.qixin.app.zjminweb.service.IWxBaseInfoService;
import com.qixin.app.zjminweb.service.IWxIndexModelService;
import com.qixin.app.zjminweb.service.IWxPictureTextService;
import com.qixin.app.zjminweb.service.IWxScrollPictureService;
import com.qixin.app.zjminweb.service.MembercardService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class MinWebController
{
    @Resource
    private IWxBaseInfoService biService;

    @Resource
    private IWxPictureTextService ptService;

    @Resource
    private IWxScrollPictureService spService;

    @Resource
    private IWxIndexModelService imService;

    @Resource
    private SystemLinkService slinkService;

    @Resource
    private CustomLinkService clinkService;

    @Resource
    private MembercardService membercardservice;

    /**
     * 查询多图文信息
     */
    @RequestMapping("/zjminweb/minweb_index")
    public ModelAndView queryIndex(HttpServletRequest request, String bid,
            String openid) throws Exception
    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bid", bid);
        map.put("openid", openid);
        // 获取首页基本信息
        List<BaseInfo> biList = biService.getAllBaseInfo(bid);
        map.put("biList", biList);

        // 获取首页滚动图片列表
        List<ScrollPicture> spList = spService.getAllScrollPicture(bid, "id");
        map.put("spList", spList);

        // 获取首页图文列表
        List<PictureText> ptList = ptService.getAllPictureText(bid, "id");
        map.put("ptList", ptList);

        // 获取模板风格
        String modeid = "";
        if (!CommonTool.isEmpty(biList) && biList.size() > 0)
        {
            modeid = biList.get(0).getModelid();
        }
        else
        {
            modeid = "1";
        }
        IndexModel im = imService.getIndexModelById(modeid);

        map.put("im", im);

        // 获取会员卡信息
        List<Membercard> membercardlist = this.membercardservice
                .getMembercardByBid(bid);

        Membercard membercard = null;
        if (membercardlist != null && membercardlist.size() == 1)
        {
            membercard = membercardlist.get(0);
        }

        map.put("membercard", membercard);

        return new ModelAndView("/app/zjminweb/index" + im.getType(), map);
    }

    /**
     * 查询多图文信息
     */
    @RequestMapping("/queryPictureTexts")
    public ModelAndView queryPictureTexts(HttpServletRequest request)
            throws Exception
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询所有自定义链接
        List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        map.put("clinks", links);
        List<SystemLink> syslinks = slinkService.getAll(bid);
        map.put("slinks", syslinks);

        List<PictureText> ptList = ptService.getAllPictureText(bid, "id");
        map.put("ptList", ptList);
        map.put("bid", bid);
        return new ModelAndView("/app/zjminweb/queryPictureText", map);
    }

    /**
     * 批量修改图文信息
     */
    @RequestMapping("/updateMultiPictureText")
    public ModelAndView updateMultiPictureText(String id,
            HttpServletRequest request, Query query) throws Exception
    {
        String[] titles = request.getParameterValues("Title[]");
        String[] picUrls = request.getParameterValues("ImgPath[]");
        String[] urls = request.getParameterValues("Url[]");
        String[] descriptions = request.getParameterValues("Description[]");

        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();

        this.ptService.removeAllPictureText(bid);

        for (int i = 0; i < titles.length; i++)
        {
            PictureText pt = new PictureText();
            pt.setBizid(bid);
            pt.setDescription(descriptions[i]);
            pt.setPicUrl(picUrls[i]);
            pt.setUrl(urls[i]);
            pt.setTitle(titles[i]);
            ptService.addPictureText(pt);
        }

        return new ModelAndView("redirect:queryPictureTexts.kq", map);
    }

    /**
     * 修改图文信息
     */
    @RequestMapping("/updatePictureText")
    public ModelAndView updatePictureText(String id, String Title,
            String Description, String PicUrl, String Url,
            HttpServletRequest request) throws Exception
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询所有自定义链接
        List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        map.put("clinks", links);
        List<SystemLink> syslinks = slinkService.getAll(bid);
        map.put("slinks", syslinks);

        PictureText pt = ptService.getPictureTextById(id);
        pt.setBizid(bid);
        pt.setDescription(Description);
        pt.setPicUrl(PicUrl);
        pt.setUrl(Url);
        ptService.updatePictureText(pt);
        return new ModelAndView("redirect:queryPictureTexts.kq", map);
    }

    /**
     * 新增图文信息
     */
    @RequestMapping("/addPictureText")
    public ModelAndView addPictureText(String Title, String Description,
            String PicUrl, String Url, HttpServletRequest request)
            throws Exception
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询所有自定义链接
        List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        map.put("clinks", links);
        List<SystemLink> syslinks = slinkService.getAll(bid);
        map.put("slinks", syslinks);

        PictureText pt = new PictureText();
        pt.setBizid(bid);
        pt.setDescription(Description);
        pt.setPicUrl(PicUrl);
        pt.setUrl(Url);
        pt.setTitle(Title);
        ptService.addPictureText(pt);
        return new ModelAndView("redirect:queryPictureTexts.kq", map);
    }

    /**
     * 删除图文信息
     */
    @RequestMapping("/removePictureText")
    public ModelAndView removePictureText(String id, HttpServletRequest request)
            throws Exception
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            ptService.removePictureText(id);
        }
        catch (Exception e)
        {
            if (this.ptService.getPictureTextById(id) != null)
            {
                CommonLogger.error("删除图文出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }

            return new ModelAndView("redirect:queryPictureTexts.kq", map);
        }

        return new ModelAndView("redirect:queryPictureTexts.kq", map);
    }

    /**
     * 查询首页基本信息
     */
    @RequestMapping("/queryBaseInfo")
    public ModelAndView queryBaseInfo(HttpServletRequest request)
            throws Exception
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询所有自定义链接
        List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        map.put("clinks", links);
        List<SystemLink> syslinks = slinkService.getAll(bid);
        map.put("slinks", syslinks);

        List<BaseInfo> biList = biService.getAllBaseInfo(bid);
        map.put("biList", biList);

        List<IndexModel> imList = imService.getAllIndexModel(bid);
        map.put("imList", imList);

        map.put("bid", bid);
        return new ModelAndView("/app/zjminweb/queryBaseInfo", map);
    }

    /**
     * 修改基本信息
     */
    @RequestMapping("/updateBaseInfo")
    public ModelAndView updateBaseInfo(String id, String footer,
            String developer, String dvlUrl, String backgroundUrl,
            String skinid, HttpServletRequest request) throws Exception
    {
        BaseInfo bi = biService.getBaseInfoById(id);
        bi.setBackgroundUrl(backgroundUrl);
        bi.setDeveloper(developer);
        bi.setDvlUrl(dvlUrl);
        bi.setFooter(footer);
        bi.setModelid(skinid);
        biService.updateBaseInfo(bi);
        request.setAttribute("code", 0);
        return queryBaseInfo(request);

    }

    final static int SCROLL_SIZE = 5;

    /**
     * 查询滚动图片列表
     */
    @RequestMapping("/queryScrollPictures")
    public ModelAndView queryScrollPictures(HttpServletRequest request)
            throws Exception
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询所有自定义链接
        List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        map.put("clinks", links);
        List<SystemLink> syslinks = slinkService.getAll(bid);
        map.put("slinks", syslinks);

        List<ScrollPicture> spList = spService.getAllScrollPicture(bid, "id");
        map.put("spList", spList);
        int size = spList.size();
        for (int i = 0; i < SCROLL_SIZE - size; i++)
        {
            spList.add(new ScrollPicture());
        }

        map.put("bid", bid);
        return new ModelAndView("/app/zjminweb/queryScrollPictures", map);
    }

    /**
     * 修改滚动图片信息
     */
    @RequestMapping("/updateScrollPicture")
    public ModelAndView updateScrollPicture(HttpServletRequest request)
            throws Exception
    {
        String[] picurl = request.getParameterValues("inputPicUrl");
        String[] url = request.getParameterValues("inputUrl");
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        spService.removeByBizid(bid);

        for (int i = 0; i < picurl.length; i++)
        {
            if (StringUtils.isNotEmpty(picurl[i]))
            {
                ScrollPicture sp = new ScrollPicture();
                sp.setBizid(bid);
                sp.setPicUrl(picurl[i]);
                sp.setUrl(url[i]);
                spService.updateScrollPicture(sp);
            }
        }
        request.setAttribute("code", 0);
        return queryScrollPictures(request);
        //
        // // 查询所有自定义链接
        // List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        // map.put("clinks", links);
        // List<SystemLink> syslinks = slinkService.getAll(bid);
        // map.put("slinks", syslinks);
        //
        // ScrollPicture sp = spService.getScrollPictureById(id);
        // sp.setBizid(bid);
        // sp.setPicUrl(picUrl);
        // sp.setUrl(url);
        //
        // spService.updateScrollPicture(sp);
        // return new ModelAndView("redirect:queryScrollPictures.kq", map);

    }

    /**
     * 增加滚动图片信息
     */
    @RequestMapping("/addScrollPicture")
    public ModelAndView addScrollPicture(String Title, String Description,
            String PicUrl, String Url, HttpServletRequest request)
            throws Exception
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);

        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询所有自定义链接
        List<CustomLink> links = clinkService.getAllCustomLinkByBizId(bid);
        map.put("clinks", links);
        List<SystemLink> syslinks = slinkService.getAll(bid);
        map.put("slinks", syslinks);

        ScrollPicture sp = new ScrollPicture();
        sp.setBizid(bid);
        sp.setPicUrl(PicUrl);
        sp.setUrl(Url);
        spService.addScrollPicture(sp);
        return new ModelAndView("redirect:queryScrollPictures.kq", map);
    }

    /**
     * 修改图文信息
     */
    @RequestMapping("/removeScrollPicture")
    public ModelAndView removeScrollPicture(String id,
            HttpServletRequest request) throws Exception
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            spService.removeScrollPicture(id);
        }
        catch (Exception e)
        {
            if (this.spService.getScrollPictureById(id) != null)
            {
                CommonLogger.error("删除滚动图片出错 :", e);
                map.put("errorMsg", "出错了!");
                return new ModelAndView("warnframe", map);
            }

            return new ModelAndView("redirect:queryScrollPictures.kq", map);
        }

        return new ModelAndView("redirect:queryScrollPictures.kq", map);
    }
}
