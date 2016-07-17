package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.RetailstoreDao;
import com.qixin.app.zjminweb.model.Retailstore;
import com.qixin.app.zjminweb.service.RetailstoreService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class RetailstoreServiceImpl implements RetailstoreService
{
    @Resource
    private RetailstoreDao retailstoredao;

    @Override
    public PageFinder<Retailstore> getRetailstoreByBid(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Retailstore>) this.retailstoredao.pagedByCritMap(
                critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public Retailstore getRetailstoreByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Retailstore) this.retailstoredao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String addRetailstore(Retailstore retailstore) throws Exception
    {
        return (String) this.retailstoredao.save(retailstore);
    }

    @Override
    public boolean removeRetailstore(String id) throws Exception
    {
        Retailstore zp = this.retailstoredao.getById(id);
        if (zp != null)
        {
            this.retailstoredao.remove(zp);
            return true;
        }
        return false;
    }

    @Override
    public String updateRetailstore(Retailstore retailstore) throws Exception
    {
        Retailstore pt = (Retailstore) this.retailstoredao.merge(retailstore);
        return pt.getId();
    }

    @Override
    public List<Retailstore> getRetailstoreByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Retailstore>) this.retailstoredao.findByCritMap(critMap,
                new boolean[] { true });
    }
}
