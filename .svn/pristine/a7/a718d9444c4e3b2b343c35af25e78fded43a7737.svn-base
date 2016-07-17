package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.ZhaopinDao;
import com.qixin.app.zjminweb.model.Zhaopin;
import com.qixin.app.zjminweb.service.ZhaopinService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class ZhaopinServiceImpl implements ZhaopinService
{

    @Resource
    private ZhaopinDao zhaopindao;

    @Override
    public String addZhaopin(Zhaopin paramSecret) throws Exception
    {
        return (String) this.zhaopindao.save(paramSecret);
    }

    @Override
    public PageFinder<Zhaopin> getZhaopinByBid(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Zhaopin>) this.zhaopindao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public Zhaopin getZhaopinByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Zhaopin) this.zhaopindao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public boolean removeZhaopin(String id) throws Exception
    {
        Zhaopin zp = this.zhaopindao.getById(id);
        if (zp != null)
        {
            this.zhaopindao.remove(zp);
            return true;
        }
        return false;
    }

    @Override
    public List<Zhaopin> getZhaopinByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Zhaopin>) this.zhaopindao.findByCritMap(critMap,
                new boolean[] { true });
    }

    public String updateZhaopin(Zhaopin zhaopin) throws Exception
    {
        Zhaopin pt = (Zhaopin) this.zhaopindao.merge(zhaopin);
        return pt.getId();
    }

}
