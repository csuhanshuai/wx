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
public class PhotoController
{
    @Resource
    private PhotoService photoservice;

    @Resource
    private AlbumService albumservice;

    @RequestMapping("/addPhotoForward")
    public ModelAndView addPhotoForward(HttpServletRequest request,
            HttpServletResponse response, String almid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();

        try
        {
            List<Album> albumlist = this.albumservice.getAlbumByBid(bid);

            if (albumlist == null)
            {
                albumlist = new ArrayList<Album>();
            }
            map.put("albumlist", albumlist);

            // 需要加入bid，否则上传组件在页面不可见
            map.put("bid", bid);

            map.put("almid", almid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get album byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("/app/zjphoto/addPhoto", map);
    }

    @RequestMapping("/getPhoto")
    public ModelAndView getPhoto(HttpServletRequest request,
            HttpServletResponse response, Query query, String id)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            // 1.获取照片
            PageFinder<Photo> pageFinder = this.photoservice.getPhotoByAlmid(
                    query, id);

            // 2.获取相册
            Album album = this.albumservice.getAlbumByid(id);

            map.put("pageFinder", pageFinder);
            map.put("album", album);
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

    @RequestMapping("/getPhotos")
    public ModelAndView getPhotos(HttpServletRequest request,
            HttpServletResponse response, Query query, String almid)
    {
        query = (query != null) ? query : new Query();
        query.setPageSize(10);

        Map<String, Object> map = new HashMap<String, Object>();
        Object bido = request.getSession().getAttribute("login_system_user");
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        try
        {
            // 1.获取照片
            PageFinder<Photo> pageFinder = this.photoservice.getPhotoByAlmid(
                    query, almid);

            // 2.获取相册
            Album album = this.albumservice.getAlbumByid(almid);

            map.put("pageFinder", pageFinder);
            map.put("album", album);
            map.put("bid", bid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get Photos byBid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjphoto/list", map);
    }

    @RequestMapping("/addPhoto")
    public ModelAndView addPhoto(String ImgPath, String almid, String iscovers,
            String description, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        try
        {
            Object bido = request.getSession()
                    .getAttribute("login_system_user");
            SystemmgtUser systemUser = (SystemmgtUser) bido;
            String bid = systemUser.getId();

            // 如果作为封面，需要更新旧的封面数据
            if (iscovers != null && !"".equals(iscovers)
                    && "1".equals(iscovers))
            {
                Photo photo = this.photoservice
                        .getPhotoByAlmid(almid, iscovers);
                if (photo != null)
                {
                    photo.setIscovers("0");
                    this.photoservice.updatePhoto(photo);
                }

            }

            Photo msg = new Photo();
            msg.setAlmid(almid);
            msg.setUrl(ImgPath);
            msg.setDescription(description);
            msg.setIscovers(iscovers);
            msg.setBizid(bid);
            this.photoservice.addPhoto(msg);
            map.put("photo", msg);
        }
        catch (Exception e)
        {
            CommonLogger.error("add photo出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }

        return new ModelAndView("redirect:getAlbum.kq");
    }

    @RequestMapping("/zjminweb/getPhotoList")
    public ModelAndView getPhotoList(HttpServletRequest request,
            HttpServletResponse response, String almid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            List<Photo> photolist = this.photoservice.getPhotoByAlmid(almid);

            if (photolist == null)
            {
                photolist = new ArrayList<Photo>();
            }
            map.put("photolist", photolist);

            map.put("almid", almid);
        }
        catch (Exception e)
        {
            CommonLogger.error("get photo byAlmid出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        return new ModelAndView("/app/zjminweb/photos", map);
    }

    @RequestMapping("/removePhoto")
    public ModelAndView removePhoto(HttpServletRequest request,
            HttpServletResponse response, String id, String almid)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            boolean result = this.photoservice.removePhotoByid(id);
            map.put("result", result);
        }
        catch (Exception e)
        {
            CommonLogger.error("remove Photo出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("warnframe", map);
        }
        map.put("almid", almid);
        return new ModelAndView("redirect:getPhotos.kq", map);
    }
}
