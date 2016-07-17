package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface CouponService
{
    public abstract PageFinder<Coupon> getCoupon(Query query, String bid)
            throws Exception;

    public abstract String addCoupon(Coupon coupon) throws Exception;

    public abstract Coupon getCouponByid(String id) throws Exception;

    public abstract String updateCoupon(Coupon coupon) throws Exception;

    public abstract List<Coupon> getCoupon(String bid, String type)
            throws Exception;
}
