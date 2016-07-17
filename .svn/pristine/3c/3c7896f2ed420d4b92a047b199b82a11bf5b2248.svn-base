package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.IntegralruleDao;
import com.qixin.app.zjminweb.model.Integralrule;
import com.qixin.app.zjminweb.service.IntegralruleService;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class IntegralruleServiceImpl implements IntegralruleService
{
    @Resource
    private IntegralruleDao integralruledao;

    @Override
    public List<Integralrule> getIntegralruleByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Integralrule>) this.integralruledao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateIntegralrule(Integralrule integralrule)
            throws Exception
    {
        Integralrule pt = (Integralrule) this.integralruledao
                .merge(integralrule);
        return pt.getId();
    }

    @Override
    public Integralrule getIntegralruleByBid(String bid, String id)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("id", id);
        return (Integralrule) this.integralruledao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String addIntegralrule(Integralrule integralrule) throws Exception
    {
        return (String) this.integralruledao.save(integralrule);
    }
}
