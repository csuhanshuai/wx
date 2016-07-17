package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.ConsumptionDao;
import com.qixin.app.zjminweb.model.Consumption;
import com.qixin.app.zjminweb.service.ConsumptionService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class ConsumptionServiceImpl implements ConsumptionService
{
    @Resource
    private ConsumptionDao consumptiondao;

    @Override
    public PageFinder<Consumption> getConsumptionByMemberid(Query query,
            String memberid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("memberid", memberid);
        critMap.addDesc("intime");
        return (PageFinder<Consumption>) this.consumptiondao.pagedByCritMap(
                critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public String addConsumption(Consumption consumption) throws Exception
    {
        return (String) this.consumptiondao.save(consumption);
    }

    @Override
    public Consumption getConsumptionByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Consumption) this.consumptiondao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateConsumption(Consumption consumption) throws Exception
    {
        Consumption pt = (Consumption) this.consumptiondao.merge(consumption);
        return pt.getId();
    }

    @Override
    public List<Consumption> getConsumptionByMemberid(String memberid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("memberid", memberid);
        return (List<Consumption>) this.consumptiondao.findByCritMapOrderBy(
                critMap, "intime", false, new boolean[] { true });
    }

    @Override
    public List<Consumption> getConsumptionByMemberid(String bid,
            String memberid, String type) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("memberid", memberid);
        if (!CommonTool.isEmpty(type))
        {
            critMap.addEqual("type", type);
        }
        return (List<Consumption>) this.consumptiondao.findByCritMapOrderBy(
                critMap, "intime", false, new boolean[] { true });
    }
}
