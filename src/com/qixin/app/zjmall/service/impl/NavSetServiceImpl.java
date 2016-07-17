package com.qixin.app.zjmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.NavSetDao;
import com.qixin.app.zjmall.model.NavSet;
import com.qixin.app.zjmall.service.NavSetService;
import com.qixin.platform.persistent.database.basedao.CritMap;

/**  
 * 
 */
@Service
public class NavSetServiceImpl implements NavSetService {

	@Resource
	private NavSetDao navsetdao;

    @Override
    public void save(NavSet navset) throws Exception
    {
        navsetdao.save(navset);
        
    }

    @Override
    public void update(NavSet navset) throws Exception
    {
        navsetdao.merge(navset);        
    }

    @Override
    public void delete(String uid, int skinid) throws Exception
    {
        NavSet o=new NavSet();
        o.setBizid(uid);
        o.setSkinid(skinid);
        navsetdao.remove(o);
        
    }

    @Override
    public List<NavSet> getNavSet( String uid, int skinid)
            throws Exception
    {
        CritMap mp = new CritMap();
        mp.addEqual("bizid", uid);
        mp.addEqual("skinid", skinid);
        mp.addAsc("navindex");
        return navsetdao.findByCritMap(mp);
    }

    

}
