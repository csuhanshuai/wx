package com.qixin.app.wobble.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.wobble.dao.WobbleconfigDao;
import com.qixin.app.wobble.model.Wobbleconfig;
import com.qixin.app.wobble.service.WobbleconfigService;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class WobbleconfigServiceImpl implements WobbleconfigService
{
    @Resource
    private WobbleconfigDao configdao;

    @Override
    public String updateWobbleconfig(Wobbleconfig wobbleconfig)
            throws Exception
    {
        Wobbleconfig pt = (Wobbleconfig) this.configdao.merge(wobbleconfig);
        return pt.getId();
    }

    @Override
    public Wobbleconfig getWobbleconfigByName(String name) throws Exception
    {

        CritMap critMap = new CritMap();
        critMap.addEqual("name", name);
        return configdao.getObjectByCritMap(critMap, true);
    }

    @Override
    public String addWobbleconfig(Wobbleconfig wobbleconfig) throws Exception
    {
        return (String) this.configdao.save(wobbleconfig);
    }

}
