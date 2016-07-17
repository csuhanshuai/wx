package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface CouponrecordService
{
    public abstract PageFinder<Couponrecord> getCouponrecord(Query query,
            String bid, String couponid, String isuse, String memberid)
            throws Exception;

    public abstract List<Couponrecord> getCouponrecord(String couponid,
            String memberid, String bid) throws Exception;

    public abstract String addCouponrecord(Couponrecord couponrecord)
            throws Exception;

    public abstract List<Couponrecord> getCouponrecord(String memberid,
            String bid) throws Exception;

    public abstract List<Couponrecord> getCouponrecordBybid(String memberid,
            String bid, String type) throws Exception;

    public abstract Couponrecord getCouponrecordByid(String id)
            throws Exception;

    public abstract String updateCouponrecord(Couponrecord couponrecord)
            throws Exception;

    /**
     * 查询用户当前能使用的有效优惠券
     * 
     * @param memberid
     * @param totalMoney 用户结算的总金额
     * @return
     * @throws Exception
     */
    public List<Coupon> getUserValiaCouponByMemId(String memberid,
            float totalMoney) throws Exception;
}
