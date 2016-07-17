package com.qixin.app.zjminweb.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.SalespromotionDao;
import com.qixin.app.zjminweb.model.Salespromotion;
import com.qixin.app.zjminweb.service.SalespromotionService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class SalespromotionServiceImpl implements SalespromotionService
{
    @Resource
    private SalespromotionDao salespromotiondao;

    @Override
    public PageFinder<Salespromotion> getSalespromotion(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Salespromotion>) this.salespromotiondao
                .pagedByCritMap(critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public String addSalespromotion(Salespromotion salespromotion)
            throws Exception
    {
        return (String) this.salespromotiondao.save(salespromotion);
    }

    @Override
    public Salespromotion getSalespromotionByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Salespromotion) this.salespromotiondao.getObjectByCritMap(
                critMap, new boolean[] { true });
    }

    @Override
    public String updateSalespromotion(Salespromotion salespromotion)
            throws Exception
    {
        Salespromotion pt = (Salespromotion) this.salespromotiondao
                .merge(salespromotion);
        return pt.getId();
    }

    @Override
    public List<Salespromotion> getSalespromotion(String bid, String type,
            long usablerange) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addLessAndEq("starttime", new Date());
        critMap.addGreatAndEq("endtime", new Date());
        critMap.addEqual("status", "0");
        critMap.addEqual("type", type);
        critMap.addLessAndEq("usablerange", usablerange);
        return (List<Salespromotion>) this.salespromotiondao
                .findByCritMap(critMap);
    }
}
