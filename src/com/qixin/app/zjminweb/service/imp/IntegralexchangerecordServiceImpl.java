package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.IntegralexchangerecordDao;
import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.app.zjminweb.service.IntegralexchangerecordService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class IntegralexchangerecordServiceImpl implements
        IntegralexchangerecordService
{
    @Resource
    private IntegralexchangerecordDao integralexchangerecorddao;

    @Override
    public List<Integralexchangerecord> getIntegralexchangerecord(String id,
            String memberid, String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("integralexchangeid", id);
        critMap.addEqual("memberid", memberid);
        critMap.addEqual("bizid", bid);
        return (List<Integralexchangerecord>) this.integralexchangerecorddao
                .findByCritMap(critMap);
    }

    @Override
    public String addIntegralexchangerecord(
            Integralexchangerecord integralexchangerecord) throws Exception
    {
        return (String) this.integralexchangerecorddao
                .save(integralexchangerecord);
    }

    @Override
    public PageFinder<Integralexchangerecord> getIntegralexchangerecord(
            Query query, String bid, String integralexchangeid, String isuse,
            String memberid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("integralexchangeid", integralexchangeid);
        if (!CommonTool.isEmpty(isuse)
                && ("0".equals(isuse) || "1".equals(isuse)))
        {
            critMap.addEqual("isuse", isuse);
        }
        if (!CommonTool.isEmpty(memberid))
        {
            critMap.addEqual("memberid", memberid);
        }
        return (PageFinder<Integralexchangerecord>) this.integralexchangerecorddao
                .pagedByCritMap(critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public String updateIntegralexchangerecord(
            Integralexchangerecord integralexchangerecord) throws Exception
    {
        Integralexchangerecord pt = (Integralexchangerecord) this.integralexchangerecorddao
                .merge(integralexchangerecord);
        return pt.getId();
    }

    @Override
    public Integralexchangerecord getIntegralexchangerecordByid(String id)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Integralexchangerecord) this.integralexchangerecorddao
                .getObjectByCritMap(critMap, new boolean[] { true });
    }

    @Override
    public List<Integralexchangerecord> getIntegralexchangerecordBymemberid(
            String bid, String memberid, String isuse) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("memberid", memberid);
        critMap.addEqual("bizid", bid);
        if (!CommonTool.isEmpty(isuse)
                && ("0".equals(isuse) || "1".equals(isuse)))
        {
            critMap.addEqual("isuse", isuse);
        }
        return (List<Integralexchangerecord>) this.integralexchangerecorddao
                .findByCritMap(critMap);
    }

    @Override
    public Integralexchangerecord getIntegralexchangerecordBytype(
            String memberid, String activitiesid, String type) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("memberid", memberid);
        critMap.addEqual("activitiesid", activitiesid);
        critMap.addEqual("type", type);
        return (Integralexchangerecord) this.integralexchangerecorddao
                .getObjectByCritMap(critMap, new boolean[] { true });
    }

}
