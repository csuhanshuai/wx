package com.qixin.app.zjminweb.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.SigninDao;
import com.qixin.app.zjminweb.model.Signin;
import com.qixin.app.zjminweb.service.SigninService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class SigninServiceImpl implements SigninService
{
    @Resource
    private SigninDao signindao;

    @Override
    public PageFinder<Signin> getSignin(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Signin>) this.signindao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public String addSignin(Signin signin) throws Exception
    {
        return (String) this.signindao.save(signin);
    }

    @Override
    public Signin getSigninByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Signin) this.signindao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateSignin(Signin signin) throws Exception
    {
        Signin pt = (Signin) this.signindao.merge(signin);
        return pt.getId();
    }

    @Override
    public List<Signin> getSignin(String bid, String status) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addLessAndEq("starttime", new Date());
        critMap.addGreatAndEq("endtime", new Date());
        critMap.addEqual("status", status);
        return (List<Signin>) this.signindao.findByCritMap(critMap);
    }
}
