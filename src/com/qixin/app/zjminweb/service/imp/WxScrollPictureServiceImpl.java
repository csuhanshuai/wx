package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.IWxScrollPictureDao;
import com.qixin.app.zjminweb.model.ScrollPicture;
import com.qixin.app.zjminweb.service.IWxScrollPictureService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class WxScrollPictureServiceImpl implements IWxScrollPictureService
{

    @Resource
    private IWxScrollPictureDao scrollPictureDao;

    public String addScrollPicture(ScrollPicture scrollPicture)
            throws Exception
    {
        return (String) this.scrollPictureDao.save(scrollPicture);
    }

    public List<ScrollPicture> getAllScrollPicture(String bizid,
            String ordername)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bizid);
        return this.scrollPictureDao.findByCritMapOrderBy(critMap, ordername,
                true, new boolean[]
                { true });
    }

    public ScrollPicture getScrollPictureById(String id)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (ScrollPicture) this.scrollPictureDao.getObjectByCritMap(
                critMap, new boolean[]
                { false });
    }

    public PageFinder<ScrollPicture> pageQueryScrollPicture(String bid,
            Query query)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return this.scrollPictureDao.pagedByCritMap(critMap, query.getPage(),
                query.getPageSize());
    }

    public String removeScrollPicture(String id) throws Exception
    {
        ScrollPicture spt = (ScrollPicture) this.scrollPictureDao.getById(id);
        if (spt != null)
        {
            this.scrollPictureDao.removeById(id);
            return "success";
        }

        return "fail";
    }

    public String updateScrollPicture(ScrollPicture scrollPicture)
            throws Exception
    {
        ScrollPicture spt = (ScrollPicture) this.scrollPictureDao
                .merge(scrollPicture);
        return spt.getId();
    }

    @Override
    public void removeByBizid(String bizid) throws Exception
    {
        // TODO Auto-generated method stub
        this.scrollPictureDao.removeByBizid(bizid);
    }

}