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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjminweb.model.Album;
import com.qixin.app.zjminweb.model.Photo;
import com.qixin.app.zjminweb.service.AlbumService;
import com.qixin.app.zjminweb.service.PhotoService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Controller
@RequestMapping("/zj")
public class AlbumController
{
    @Resource
    private AlbumService albumservice;

    @Resource
    private PhotoService photoservice;

    @RequestMapping("/getAlbum")
    public ModelAndView getAlbum(HttpServletRequest request,
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
            // 1.获取相册
            PageFinder<Album> pageFinder = this.albumservice.getAlbumByBid(
                    query, bid);

            // 2.获取相册封面
            List<Photo> photolist = this.photoservice.getPhotoByBid(bid);

            List<Photo> coverslist = new ArrayList<Photo>();
            for (Photo photo : photolist)
            {
                // 存放封面
                if (photo != null && "1".equals(photo.getIscovers()))
                {
                    coverslist.add(photo);
                }
            }
            map.put("pageFinder", pageFinder);
            map.put("coverslist", coverslist);
            map.put("photolist", photolist);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get album byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjalbum/list", map);
    }

    @RequestMapping("/addAlbumForward")
    public ModelAndView addAlbumForward(HttpServletRequest request,
            HttpServletResponse response)
    {
        return new ModelAndView("/app/zjalbum/add");
    }

    @RequestMapping("/addAlbum")
    public ModelAndView addAlbum(Album album, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();
            album.setBizid(bid);
            this.albumservice.addAlbum(album);
            map.put("zhaopin", album);
        }
        catch (Exception e)
        {
            CommonLogger.error("add album出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getAlbum.kq");
    }

    @RequestMapping("/removeAlbum")
    public ModelAndView removeAlbum(HttpServletRequest request,
            HttpServletResponse response, String id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.albumservice.removeAlbum(id);
            this.photoservice.removePhoto(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove Album出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("redirect:getAlbum.kq", map);
    }

    @RequestMapping("/zjminweb/getAlbumList")
    public ModelAndView getAlbumList(HttpServletRequest request,
            HttpServletResponse response, String bid)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            // 1.获取相册
            List<Album> albumlist = this.albumservice.getAlbumByBid(bid);

            // 2.获取相册封面
            List<Photo> photolist = this.photoservice.getPhotoByBid(bid);

            List<Photo> coverslist = new ArrayList<Photo>();
            for (Photo photo : photolist)
            {
                // 存放封面
                if (photo != null && "1".equals(photo.getIscovers()))
                {
                    coverslist.add(photo);
                }
            }
            map.put("albumlist", albumlist);
            map.put("coverslist", coverslist);
            map.put("photolist", photolist);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get album byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjminweb/album", map);
    }
}
