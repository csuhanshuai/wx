package com.qixin.app.zjminweb.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.IntegralexchangeDao;
import com.qixin.app.zjminweb.model.Integralexchange;
import com.qixin.app.zjminweb.service.IntegralexchangeService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class IntegralexchangeServiceImpl implements IntegralexchangeService
{
    @Resource
    private IntegralexchangeDao integralexchangedao;

    @Override
    public PageFinder<Integralexchange> getIntegralexchangeByBid(Query query,
            String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        // critMap.addLessAndEq("validity", new Date());
        // critMap.addGreat("sum", 0);
        return (PageFinder<Integralexchange>) this.integralexchangedao
                .pagedByCritMap(critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public boolean removeIntegralexchange(String id) throws Exception
    {
        Integralexchange zp = this.integralexchangedao.getById(id);
        if (zp != null)
        {
            this.integralexchangedao.remove(zp);
            return true;
        }
        return false;
    }

    @Override
    public String addIntegralexchange(Integralexchange integralexchange)
            throws Exception
    {
        return (String) this.integralexchangedao.save(integralexchange);
    }

    @Override
    public Integralexchange getIntegralexchangeByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Integralexchange) this.integralexchangedao.getObjectByCritMap(
                critMap, new boolean[] { true });
    }

    @Override
    public List<Integralexchange> getIntegralexchangeByBid(String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addGreatAndEq("validity", new Date());
        critMap.addGreat("sum", 0);
        return (List<Integralexchange>) this.integralexchangedao
                .findByCritMapOrderBy(critMap, "intime", false,
                        new boolean[] { true });
    }

    @Override
    public String updateIntegralexchange(Integralexchange integralexchange)
            throws Exception
    {
        Integralexchange pt = (Integralexchange) this.integralexchangedao
                .merge(integralexchange);
        return pt.getId();
    }

}
