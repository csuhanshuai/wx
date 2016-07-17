package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.IWxBaseInfoDao;
import com.qixin.app.zjminweb.model.BaseInfo;
import com.qixin.app.zjminweb.service.IWxBaseInfoService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class WxBaseInfoServiceImpl implements IWxBaseInfoService
{

    @Resource
    private IWxBaseInfoDao baseInfoDao;

    public String addBaseInfo(BaseInfo baseInfo)
            throws Exception
    {
        return (String) this.baseInfoDao.save(baseInfo);
    }

    public List<BaseInfo> getAllBaseInfo(String bizid)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bizid);
        //critMap.addFech("model");
        return this.baseInfoDao.findByCritMap(critMap,
                new boolean[] { true });
    }

    public BaseInfo getBaseInfoById(String id)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (BaseInfo) this.baseInfoDao.getObjectByCritMap(
                critMap, new boolean[] { false });
    }

    public PageFinder<BaseInfo> pageQueryBaseInfo(String bid,
            Query query)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return this.baseInfoDao.pagedByCritMap(critMap, query.getPage(),
                query.getPageSize());
    }

    public String removeBaseInfo(String id) throws Exception
    {
        BaseInfo spt = (BaseInfo) this.baseInfoDao.getById(id);
        if (spt != null)
        {
            this.baseInfoDao.removeById(id);
            return "success";
        }

        return "fail";
    }

    public String updateBaseInfo(BaseInfo baseInfo)
            throws Exception
    {
        BaseInfo spt = (BaseInfo) this.baseInfoDao
                .merge(baseInfo);
        return spt.getId();
    }

    
}