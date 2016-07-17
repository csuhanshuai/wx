package com.qixin.app.zjminweb.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.CouponDao;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.service.CouponService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class CouponServiceImpl implements CouponService
{
    @Resource
    private CouponDao coupondao;

    @Override
    public PageFinder<Coupon> getCoupon(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Coupon>) this.coupondao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public String addCoupon(Coupon coupon) throws Exception
    {
        return (String) this.coupondao.save(coupon);
    }

    @Override
    public Coupon getCouponByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Coupon) this.coupondao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateCoupon(Coupon coupon) throws Exception
    {
        Coupon pt = (Coupon) this.coupondao.merge(coupon);
        return pt.getId();
    }

    @Override
    public List<Coupon> getCoupon(String bid, String type) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addLessAndEq("validitystart", new Date());
        critMap.addGreatAndEq("validityend", new Date());
        critMap.addGreat("sum", 0);
        critMap.addEqual("status", "0");
        critMap.addEqual("type", type);
        return (List<Coupon>) this.coupondao.findByCritMap(critMap);
    }
}
