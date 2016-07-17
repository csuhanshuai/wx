package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.IWxIndexModelDao;
import com.qixin.app.zjminweb.model.IndexModel;
import com.qixin.app.zjminweb.service.IWxIndexModelService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class WxIndexModelServiceImpl implements IWxIndexModelService
{

    @Resource
    private IWxIndexModelDao indexModelDao;

    public String addIndexModel(IndexModel indexModel)
            throws Exception
    {
        return (String) this.indexModelDao.save(indexModel);
    }

    public List<IndexModel> getAllIndexModel(String bizid)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bizid);
        //critMap.addFech("model");
        return this.indexModelDao.findByCritMap(critMap,
                new boolean[] { true });
    }

    public IndexModel getIndexModelById(String id)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (IndexModel) this.indexModelDao.getObjectByCritMap(
                critMap, new boolean[] { false });
    }

    public PageFinder<IndexModel> pageQueryIndexModel(String bid,
            Query query)
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return this.indexModelDao.pagedByCritMap(critMap, query.getPage(),
                query.getPageSize());
    }

    public String removeIndexModel(String id) throws Exception
    {
        IndexModel spt = (IndexModel) this.indexModelDao.getById(id);
        if (spt != null)
        {
            this.indexModelDao.removeById(id);
            return "success";
        }

        return "fail";
    }

    public String updateIndexModel(IndexModel indexModel)
            throws Exception
    {
        IndexModel spt = (IndexModel) this.indexModelDao
                .merge(indexModel);
        return spt.getId();
    }

    
}