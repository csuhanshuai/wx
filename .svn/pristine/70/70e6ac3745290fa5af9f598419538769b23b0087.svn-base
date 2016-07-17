package com.qixin.app.wobble.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.wobble.dao.WobbleprizerecordDao;
import com.qixin.app.wobble.model.Wobbleprizerecord;
import com.qixin.app.wobble.service.WobbleprizerecordService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class WobbleprizerecordServiceImpl implements WobbleprizerecordService
{
    @Resource
    private WobbleprizerecordDao prizerecorddao;

    @Override
    public Wobbleprizerecord getPrizerecordByOpenId(String openid, String bid,
            String activitiesid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("openid", openid);
        critMap.addEqual("bizid", bid);
        critMap.addEqual("activitiesid", activitiesid);
        return (Wobbleprizerecord) this.prizerecorddao.getObjectByCritMap(
                critMap, new boolean[] { true });
    }

    @Override
    public Wobbleprizerecord getPrizerecordByWin(String openid, String bid,
            String activitiesid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("openid", openid);
        critMap.addEqual("bizid", bid);
        critMap.addEqual("activitiesid", activitiesid);
        critMap.addEqual("isprizes", 1);
        return (Wobbleprizerecord) this.prizerecorddao.getObjectByCritMap(
                critMap, new boolean[] { true });
    }

    @Override
    public String addPrizerecord(Wobbleprizerecord prizerecord)
            throws Exception
    {
        return (String) this.prizerecorddao.save(prizerecord);
    }

    @Override
    public List<Wobbleprizerecord> getPrizerecordBybid(String bid,
            String activitiesid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("activitiesid", activitiesid);

        return (List<Wobbleprizerecord>) this.prizerecorddao.findByCritMap(
                critMap, new boolean[] { true });
    }

    @Override
    public PageFinder<Wobbleprizerecord> getPrizerecordBybid(Query query,
            String bid, String activitiesid, String name, String mobilephone,
            String isreg) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("activitiesid", activitiesid);
        if (!CommonTool.isEmpty(name))
        {
            critMap.addEqual("name", name);
        }
        if (!CommonTool.isEmpty(mobilephone))
        {
            critMap.addEqual("mobilephone", mobilephone);
        }

        critMap.addEqual("isprizes", 1);

        if (!CommonTool.isEmpty(isreg)
                && ("0".equals(isreg) || "1".equals(isreg)))
        {
            try
            {
                int i = Integer.parseInt(isreg);
                critMap.addEqual("isreg", i);
            }
            catch (NumberFormatException e)
            {

            }
        }

        return (PageFinder<Wobbleprizerecord>) this.prizerecorddao
                .pagedByCritMap(critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public Wobbleprizerecord getPrizerecordByid(String id) throws Exception
    {
        return this.prizerecorddao.getById(id);
    }

    @Override
    public String updatePrizerecord(Wobbleprizerecord prizerecord)
            throws Exception
    {
        Wobbleprizerecord pt = (Wobbleprizerecord) this.prizerecorddao
                .merge(prizerecord);
        return pt.getId();
    }
}
