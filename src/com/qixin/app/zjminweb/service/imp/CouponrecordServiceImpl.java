package com.qixin.app.zjminweb.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.CouponDao;
import com.qixin.app.zjminweb.dao.CouponrecordDao;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.service.CouponrecordService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;

@Service
public class CouponrecordServiceImpl implements CouponrecordService
{
    @Resource
    private CouponrecordDao couponrecorddao;

    @Resource
    private CouponDao couponDao;

    @Override
    public List<Couponrecord> getCouponrecord(String couponid, String memberid,
            String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("couponid", couponid);
        critMap.addEqual("memberid", memberid);
        critMap.addEqual("bizid", bid);
        return (List<Couponrecord>) this.couponrecorddao.findByCritMap(critMap);
    }

    @Override
    public String addCouponrecord(Couponrecord couponrecord) throws Exception
    {
        return (String) this.couponrecorddao.save(couponrecord);
    }

    @Override
    public List<Couponrecord> getCouponrecord(String memberid, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("memberid", memberid);
        critMap.addEqual("bizid", bid);
        return (List<Couponrecord>) this.couponrecorddao.findByCritMap(critMap);
    }

    @Override
    public List<Couponrecord> getCouponrecordBybid(String memberid, String bid,
            String type) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("isuse", type);
        critMap.addEqual("memberid", memberid);
        critMap.addEqual("bizid", bid);
        return (List<Couponrecord>) this.couponrecorddao.findByCritMap(critMap);
    }

    @Override
    public List<Coupon> getUserValiaCouponByMemId(String memberid,
            float totalMoney) throws Exception
    {
        // 查询用户未使用的优惠券
        CritMap critMap = new CritMap();
        critMap.addEqual("memberid", memberid);
        // 未领用的
        critMap.addEqual("isuse", "0");
        List<Couponrecord> recordList = couponrecorddao.findByCritMap(critMap);

        String couponId;

        Date currentTime = DateUtil.getCurrentDateTime();

        List<Coupon> couponList = new ArrayList<Coupon>();

        // 根据本人领取的优惠券ID，找到优惠券详细信息
        CritMap critMapCoupon = new CritMap();
        for (Couponrecord couponrecord : recordList)
        {
            couponId = couponrecord.getCouponid();
            critMapCoupon.addEqual("id", couponId);
            // 状态为正常的
            critMapCoupon.addEqual("status", "0");
            // 当前时间在有效期之内
            critMapCoupon.addLessAndEq("validitystart", currentTime);
            critMapCoupon.addGreatAndEq("validityend", currentTime);

            // 优惠券的使用范围是大于或等于所要结算的总金额，即符合满多少减多少的
            if (totalMoney != 0)
            {
                critMapCoupon.addLessAndEq("usablerange", totalMoney);
            }
            Coupon coupon = couponDao.getObjectByCritMap(critMapCoupon);
            // 不为空，则说明符合条件
            if (null != coupon)
            {
                couponList.add(coupon);
            }
        }
        return couponList;
    }

    @Override
    public PageFinder<Couponrecord> getCouponrecord(Query query, String bid,
            String couponid, String isuse, String memberid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("couponid", couponid);
        if (!CommonTool.isEmpty(isuse)
                && ("0".equals(isuse) || "1".equals(isuse)))
        {
            critMap.addEqual("isuse", isuse);
        }
        if (!CommonTool.isEmpty(memberid))
        {
            critMap.addEqual("memberid", memberid);
        }
        return (PageFinder<Couponrecord>) this.couponrecorddao.pagedByCritMap(
                critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public Couponrecord getCouponrecordByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Couponrecord) this.couponrecorddao.getObjectByCritMap(critMap);
    }

    @Override
    public String updateCouponrecord(Couponrecord couponrecord)
            throws Exception
    {
        Couponrecord pt = (Couponrecord) this.couponrecorddao
                .merge(couponrecord);
        return pt.getId();
    }
}
