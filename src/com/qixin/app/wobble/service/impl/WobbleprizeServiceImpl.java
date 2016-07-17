package com.qixin.app.wobble.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.wobble.dao.WobbleprizeDao;
import com.qixin.app.wobble.model.Wobbleprize;
import com.qixin.app.wobble.service.WobbleprizeService;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class WobbleprizeServiceImpl implements WobbleprizeService
{
    @Resource
    private WobbleprizeDao prizedao;

    @Override
    public Wobbleprize getPrizeByid(String id, String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        critMap.addEqual("bizid", bid);
        return (Wobbleprize) this.prizedao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public List<Wobbleprize> getPrizeBybid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Wobbleprize>) this.prizedao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updatePrize(Wobbleprize prize) throws Exception
    {
        Wobbleprize pt = (Wobbleprize) this.prizedao.merge(prize);
        return pt.getId();
    }
}
