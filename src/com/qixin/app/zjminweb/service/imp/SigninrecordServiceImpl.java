package com.qixin.app.zjminweb.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.SigninrecordDao;
import com.qixin.app.zjminweb.model.Signinrecord;
import com.qixin.app.zjminweb.service.SigninrecordService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class SigninrecordServiceImpl implements SigninrecordService
{
    @Resource
    private SigninrecordDao signinrecorddao;

    @Override
    public PageFinder<Signinrecord> getSigninrecord(Query query,
            String signinid, Date starttime, Date endtime) throws Exception
    {
        CritMap critMap = new CritMap();
        if (endtime != null)
        {
            critMap.addLessAndEq("intime", endtime);
        }
        if (starttime != null)
        {
            critMap.addGreatAndEq("intime", starttime);
        }
        critMap.addEqual("signinid", signinid);
        return (PageFinder<Signinrecord>) this.signinrecorddao.pagedByCritMap(
                critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public String addSigninrecord(Signinrecord signinrecord) throws Exception
    {
        return (String) this.signinrecorddao.save(signinrecord);
    }

    @Override
    public Signinrecord getSigninrecordByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Signinrecord) this.signinrecorddao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateSigninrecord(Signinrecord signinrecord)
            throws Exception
    {
        Signinrecord pt = (Signinrecord) this.signinrecorddao
                .merge(signinrecord);
        return pt.getId();
    }

    @Override
    public List<Signinrecord> getSigninrecordBysigninid(String signinid,
            Date startdate, Date enddate) throws Exception
    {
        CritMap critMap = new CritMap();
        if (enddate != null)
        {
            critMap.addLessAndEq("intime", enddate);
        }
        if (startdate != null)
        {
            critMap.addGreatAndEq("intime", startdate);
        }
        critMap.addEqual("signinid", signinid);
        return (List<Signinrecord>) this.signinrecorddao.findByCritMap(critMap);
    }
}
