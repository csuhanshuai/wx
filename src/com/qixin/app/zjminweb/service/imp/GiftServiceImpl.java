package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.GiftDao;
import com.qixin.app.zjminweb.model.Gift;
import com.qixin.app.zjminweb.service.GiftService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class GiftServiceImpl implements GiftService
{
    @Resource
    private GiftDao giftDao;

    @Override
    public PageFinder<Gift> getGift(Query query, String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Gift>) this.giftDao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public Gift getGiftByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Gift) this.giftDao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateGift(Gift gift) throws Exception
    {
        Gift pt = (Gift) this.giftDao.merge(gift);
        return pt.getId();
    }

    @Override
    public List<Gift> getGiftListBybid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addGreat("number", 0l);
        critMap.addEqual("bizid", bid);
        critMap.addEqual("status", "0");
        return (List<Gift>) this.giftDao.findByCritMap(critMap);
    }

    @Override
    public String addGift(Gift gift) throws Exception
    {
        return (String) this.giftDao.save(gift);
    }
}
