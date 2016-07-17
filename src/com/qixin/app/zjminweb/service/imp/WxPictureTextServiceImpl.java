package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.IWxPictureTextDao;
import com.qixin.app.zjminweb.model.PictureText;
import com.qixin.app.zjminweb.service.IWxPictureTextService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class WxPictureTextServiceImpl implements IWxPictureTextService
{

    @Resource
    private IWxPictureTextDao pictureTextDao;

    public String addPictureText(PictureText pictureText) throws Exception
    {
        return (String) this.pictureTextDao.save(pictureText);
    }

    public List<PictureText> getAllPictureText(String bizid, String ordername)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bizid);
        return this.pictureTextDao.findByCritMapOrderBy(critMap, ordername,
                true, new boolean[]
                { true });
    }

    public PictureText getPictureTextById(String id)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (PictureText) this.pictureTextDao.getObjectByCritMap(critMap,
                new boolean[]
                { false });
    }

    public PageFinder<PictureText> pageQueryPictureText(String bid, Query query)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return this.pictureTextDao.pagedByCritMap(critMap, query.getPage(),
                query.getPageSize());
    }

    public String removePictureText(String id) throws Exception
    {
        PictureText spt = (PictureText) this.pictureTextDao.getById(id);
        if (spt != null)
        {
            this.pictureTextDao.removeById(id);
            return "success";
        }

        return "fail";
    }

    public String updatePictureText(PictureText pictureText) throws Exception
    {
        PictureText spt = (PictureText) this.pictureTextDao.merge(pictureText);
        return spt.getId();
    }

    @Override
    public void removeAllPictureText(String paramBid) throws Exception
    {

        this.pictureTextDao.removeAllByBid(paramBid);
    }

}