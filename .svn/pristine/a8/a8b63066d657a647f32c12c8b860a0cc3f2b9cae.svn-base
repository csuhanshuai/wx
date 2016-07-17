package com.qixin.app.zjmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.SkinDao;
import com.qixin.app.zjmall.model.Skin;
import com.qixin.app.zjmall.service.SkinService;
import com.qixin.platform.persistent.database.basedao.CritMap;

/**  
 * 
 */
@Service
public class SkinServiceImpl implements SkinService
{

    @Resource
    private SkinDao skindao;

    @Override
    public void save(Skin skin) throws Exception
    {
        skindao.save(skin);

    }

    @Override
    public void update(Skin skin) throws Exception
    {
        skindao.merge(skin);

    }

    @Override
    public void delete(int skinid) throws Exception
    {
        Skin o = new Skin();
        o.setSkinid(skinid);
        skindao.remove(o);

    }

    @Override
    public List<Skin> getSkin(int skinid) throws Exception
    {
        CritMap mp = new CritMap();
        mp.addEqual("skinid", skinid);
        mp.addAsc("navindex");
        return skindao.findByCritMap(mp);
    }

}
