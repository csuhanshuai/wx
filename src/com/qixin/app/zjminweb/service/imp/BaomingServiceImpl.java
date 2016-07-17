package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.BaomingDao;
import com.qixin.app.zjminweb.model.Baoming;
import com.qixin.app.zjminweb.service.BaomingService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class BaomingServiceImpl implements BaomingService
{

    @Resource
    public BaomingDao baomingDao;

    @Override
    public String addBaoming(Baoming baoming) throws Exception
    {
        return (String) this.baomingDao.save(baoming);
    }

    @Override
    public PageFinder<Baoming> getBaomingList(Query query, Baoming baoming)
    {
        CritMap critMap = new CritMap();
        if (baoming.getActivitiesid() != null
                && !"".equals(baoming.getActivitiesid()))
        {
            critMap.addEqual("activitiesid", baoming.getActivitiesid());
        }
        if (baoming.getMobile() != null && !"".equals(baoming.getMobile()))
        {
            critMap.addLike("mobile", baoming.getMobile());
        }
        if (baoming.getName() != null && !"".equals(baoming.getName()))
        {
            critMap.addLike("name", baoming.getName());
        }
        return (PageFinder<Baoming>) this.baomingDao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public List<Baoming> getBaomingList(Baoming baoming)
    {
        CritMap critMap = new CritMap();
        if (baoming.getActivitiesid() != null
                && !"".equals(baoming.getActivitiesid()))
        {
            critMap.addEqual("activitiesid", baoming.getActivitiesid());
        }
        if (baoming.getMobile() != null && !"".equals(baoming.getMobile()))
        {
            critMap.addLike("mobile", baoming.getMobile());
        }
        if (baoming.getName() != null && !"".equals(baoming.getName()))
        {
            critMap.addLike("name", baoming.getName());
        }
        return (List<Baoming>) this.baomingDao.findByCritMap(critMap);
    }

    @Override
    public Baoming getBaomingById(String id)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Baoming) this.baomingDao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateBaoming(Baoming bm)
    {
        Baoming pt = (Baoming) this.baomingDao.merge(bm);
        return pt.getId();

    }

    @Override
    public String deleteBaoming(String id) throws Exception
    {
        Baoming bm = this.baomingDao.getById(id);
        if (bm != null)
        {
            this.baomingDao.removeById(id);
            return "success";
        }
        return "fail";
    }

    public Baoming getBaomingByMobile(String bid, String mobile)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("mobile", mobile);
        return (Baoming) this.baomingDao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }
}
