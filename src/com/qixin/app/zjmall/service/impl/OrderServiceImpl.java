/**
 * 
 */
package com.qixin.app.zjmall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjmall.dao.CartDao;
import com.qixin.app.zjmall.dao.IOrderDao;
import com.qixin.app.zjmall.dao.IOrderDetailDao;
import com.qixin.app.zjmall.model.Order;
import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.app.zjmall.model.Product;
import com.qixin.app.zjmall.service.IOrderService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.dao.ConsumptionDao;
import com.qixin.app.zjminweb.dao.CouponDao;
import com.qixin.app.zjminweb.dao.CouponrecordDao;
import com.qixin.app.zjminweb.dao.IntegralruleDao;
import com.qixin.app.zjminweb.dao.MemberDao;
import com.qixin.app.zjminweb.model.Consumption;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Couponrecord;
import com.qixin.app.zjminweb.model.Integralrule;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;

import edu.emory.mathcs.backport.java.util.LinkedList;

/**
 * 订单和订单详细的业务实现类
 * 
 * @author sky
 * 
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService
{

    @Resource
    private IOrderDao orderDao;

    @Resource
    private IOrderDetailDao orderDetailDao;

    @Resource
    private CartDao cartDao;

    @Resource
    private CouponDao coupondao;

    @Resource
    private MemberDao memberDao;

    @Resource
    private CouponrecordDao couponrecordDao;

    @Resource
    private ConsumptionDao consumptiondao;

    @Resource
    private IntegralruleDao integralruledao;

    @Resource
    private IntegralService integralservice;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.qixin.app.zjmall.service.IOrderService#addOrder(com.qixin.app.zjmall
     * .model.Order)
     */
    @Override
    public String addOrder(Order order, String openId, String coupon,
            String payType, Member u, String bid,
            Map<String, String> orderToAlipaymap) throws Exception
    {
        // TODO Auto-generated method stub

        List cartList = cartDao.querybyCartUID(openId);

        // 某类商品总价格
        float totalPric = 0;
        // 该订单的总金额(实物商品)
        float allTotalPricForSW = 0;
        // 该订单的总金额(虚拟商品)
        float allTotalPricForSN = 0;
        // 几件商品数
        Integer buyNum = 0;

        // 订单详情集合临时对象(实物商品)
        List<OrderDetail> orderDetaiListForSW = new ArrayList<OrderDetail>();

        // 订单详情集合临时对象(虚拟商品)
        List<OrderDetail> orderDetaiListForSN = new ArrayList<OrderDetail>();

        // 商品类别（1实物商品、2虚拟商品）
        String category = null;
        for (int i = 0; i < cartList.size(); i++)
        {
            LinkedList unionPlis = (LinkedList) cartList.get(i);

            // 第一条放的是PRODUCT
            Product pro = (Product) unionPlis.get(0);
            category = pro.getCategory();

            // 第二条放PRODUCT数量
            buyNum = (Integer) unionPlis.get(1);

            totalPric = Float.valueOf(pro.getPric()) * buyNum;

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBuyNum(buyNum);
            orderDetail.setPid(pro.getId());
            orderDetail.setPtitle(pro.getPtitle());
            orderDetail.setTotalMoney(totalPric);
            // 假如是2，则虚拟商品,否则是实物商品
            if ("2".equals(category))
            {
                orderDetaiListForSN.add(orderDetail);
                allTotalPricForSN += totalPric;
            }
            else
            {
                orderDetaiListForSW.add(orderDetail);
                allTotalPricForSW += totalPric;
            }
        }

        Couponrecord record = null;
        // 虚拟商品的优惠金额
        float couponMoneyForSW = 0;
        // 实物商品的优惠金额
        float couponMoneyForSN = 0;
        // 优惠ID不为空,则要在总金额的基础上减去优惠
        if (null != coupon && !"".equals(coupon))
        {
            // 先用户是否有这个有效优惠券
            // 查询用户未使用的优惠券
            CritMap critMap = new CritMap();
            critMap.addEqual("memberid", u.getId());
            // 未领用的
            critMap.addEqual("isuse", "0");
            critMap.addEqual("couponid", coupon);
            List<Couponrecord> recordList = couponrecordDao
                    .findByCritMap(critMap);
            if (null != recordList && recordList.size() > 0)
            {
                CritMap critMapCoupon = new CritMap();
                critMapCoupon.addEqual("id", coupon);
                // 状态为正常的
                critMapCoupon.addEqual("status", "0");
                // 当前时间在有效期之内
                Date currentTime = DateUtil.getCurrentDateTime();
                critMapCoupon.addLessAndEq("validitystart", currentTime);
                critMapCoupon.addGreatAndEq("validityend", currentTime);

                // 优惠券的使用范围是大于或等于所要结算的总金额，即符合满多少减多少的
                critMapCoupon.addLessAndEq("usablerange", allTotalPricForSW
                        + allTotalPricForSN);
                Coupon cp = coupondao.getObjectByCritMap(critMapCoupon);
                // 不为空，则说明符合条件
                if (null != cp)
                {
                    float couponMoney = Float.parseFloat(cp.getMoney());

                    // 假如存在虚拟商品，则要把优惠券按比例分成两个子订单中
                    if (orderDetaiListForSN.size() > 0)
                    {
                        // 由于分实物商品和虚拟商品，要分成两个子订单，每个订单要按各订单金额比例来分这个优惠券可优惠金额
                        couponMoneyForSW = ((allTotalPricForSW / (allTotalPricForSW + allTotalPricForSN))
                                * couponMoney * 100) / 100;

                        // 得到上面实物类的可优惠金额后，就可得到虚拟商品类的可以优惠金额
                        couponMoneyForSN = couponMoney - couponMoneyForSW;

                        // 所以最终实物类的订单实际支付金额为
                        allTotalPricForSW = allTotalPricForSW
                                - couponMoneyForSW;
                        // 虚拟商品实际支付金额为
                        allTotalPricForSN = allTotalPricForSN
                                - couponMoneyForSN;
                    }
                    else
                    {
                        // 否则
                        allTotalPricForSW = allTotalPricForSW - couponMoney;
                    }
                    // 还要更新用户的优惠券已经使用
                    record = recordList.get(0);
                }
            }
        }

        // 订单最终实际支付的总金额(包括虚拟和实物商品)
        float allTotalPric = allTotalPricForSW + allTotalPricForSN;

        // 得到订单信息以及总金额
        orderToAlipaymap.put("alltotalpric", String.valueOf(allTotalPric));

        // 假如是余额支付，则要看一余额是否够
        Consumption consumption = new Consumption();
        if ("1".equals(payType))
        {
            float balance = Float.parseFloat(u.getBalance());

            if (balance < allTotalPric)
            {
                // 余额不够
                return "notbalance";
            }
            // 如果余额够，则直接减余额，并设置订单状态为已支付
            order.setStatus(1);
            // 更新用户帐户余额
            u.setBalance(String.valueOf(balance - allTotalPric));
            memberDao.merge(u);

            // 同时还要增加用户的消费积分

            consumption.setMemberid(u.getId());
            consumption.setMoney(String.valueOf(allTotalPric));
            Date nowdate = CommonTool.getNowDateBySDF("yyyy-MM-dd HH:mm:ss");
            consumption.setIntime(nowdate);
            consumption.setReasons("商城消费");
            consumption.setStatus("0");
            consumption.setType("0");
            consumption.setBizid(bid);
            consumption.setBalance(u.getBalance());
            String result = (String) consumptiondao.save(consumption);

            // 增加相应积分
            if (!CommonTool.isEmpty(result))
            {
                CritMap critMap = new CritMap();
                critMap.addEqual("bizid", bid);
                List<Integralrule> integralrulelist = (List<Integralrule>) integralruledao
                        .findByCritMap(critMap, new boolean[] { true });

                if (!CommonTool.isEmpty(integralrulelist)
                        && integralrulelist.size() == 1)
                {
                    Integralrule integralrule = integralrulelist.get(0);

                    int totalMoney = (int) allTotalPric;
                    String integral = ServiceTool.getIntegralOnRuleByMoney(
                            integralrule, String.valueOf(totalMoney));

                    u.setIntegral(CommonTool.numberAdd(u.getIntegral(),
                            integral));
                    memberDao.merge(u);

                    // 增加积分消费记录
                    this.integralservice.addIntegral(u, "0", integral, "消费获取");

                }
            }
        }
        order.setPayType(payType);

        // 得到订单信息以及总金额
        StringBuffer ordertoalipay = new StringBuffer();

        // 判断实物订单
        if (orderDetaiListForSW.size() > 0)
        {
            // 订单总金额
            order.setTotalMoney(allTotalPricForSW);
            order.setCouponMoney(couponMoneyForSW);
            // 先增加表订单信息
            Order respOrder = orderDao.saveObject(order);
            // 订单编号
            String orderId = respOrder.getId();

            // 将订单信息存下
            ordertoalipay.append(orderId + '_');

            for (OrderDetail orderDetail : orderDetaiListForSW)
            {
                orderDetail.setOrderId(orderId);
                // 再增加订单详情
                orderDetailDao.save(orderDetail);
            }
        }

        // 如果有虚拟商品就分成两个订单，则要保存两个订单
        if (orderDetaiListForSN.size() > 0)
        {
            Order orderSN = new Order();

            orderSN.setPhoneNum(order.getPhoneNum());
            orderSN.setReceiveAddr(order.getReceiveAddr());
            orderSN.setReceiver(order.getReceiver());
            orderSN.setUid(openId);
            orderSN.setOrderTime(order.getOrderTime());
            // 订单总金额
            orderSN.setTotalMoney(allTotalPricForSN);
            orderSN.setCouponMoney(couponMoneyForSN);
            orderSN.setPayType(order.getPayType());
            if ("1".equals(payType))
            {
                // 设置虚拟商品已发货
                orderSN.setStatus(2);

            }
            else
            {
                orderSN.setStatus(0);
            }

            // 短ID
            orderSN.setId(ShortUUID.generateShortUuid());

            // 先增加表订单信息
            Order respOrder = orderDao.saveObject(orderSN);
            // 订单编号
            String orderId = respOrder.getId();

            // 将订单信息存下
            ordertoalipay.append(orderId + '_');

            for (OrderDetail orderDetail : orderDetaiListForSN)
            {
                orderDetail.setOrderId(orderId);
                // 再增加订单详情
                orderDetailDao.save(orderDetail);
            }
        }

        // 最后将订单信息返回回去
        orderToAlipaymap.put("orderidtoalipay", ordertoalipay.toString());

        // 最后删除该用户的购物车信息
        cartDao.deleteCartByUid(openId);

        // 优惠券信息不为空，则说明有用优惠券，则要更新优惠券已经使用
        if (null != record)
        {
            record.setIsuse("1");
            record.setUsertime(CommonTool.getNowDate("yyyy-MM-dd HH:mm:ss"));
            record.setConsumptionid(consumption.getId());
            couponrecordDao.merge(record);
        }
        return "success";
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.qixin.app.zjmall.service.IOrderService#deleteOrder(com.qixin.app.
     * zjmall.model.Order)
     */
    @Override
    public void deleteOrder(String id) throws Exception
    {
        // TODO Auto-generated method stub
        orderDao.deleteOrder(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.qixin.app.zjmall.service.IOrderService#queryAllOrder(com.qixin.platform
     * .persistent.database.basedao.Query)
     */
    @Override
    public PageFinder<Order> queryAllOrder(Query query) throws Exception
    {
        // TODO Auto-generated method stub
        CritMap mp = new CritMap();
        mp.addDesc("orderTime");
        return orderDao
                .pagedByCritMap(mp, query.getPage(), query.getPageSize());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.qixin.app.zjmall.service.IOrderService#queryOrderDetail(com.qixin
     * .platform.persistent.database.basedao.Query, java.lang.String)
     */
    @Override
    public PageFinder<OrderDetail> queryOrderDetail(Query query, String orderId)
            throws Exception
    {
        // TODO Auto-generated method stub
        CritMap mp = new CritMap();
        mp.addEqual("orderId", orderId);
        return orderDetailDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.qixin.app.zjmall.service.IOrderService#updateOrder(com.qixin.app.
     * zjmall.model.Order)
     */
    @Override
    public void updateOrder(Order order) throws Exception
    {
        // TODO Auto-generated method stub
        orderDao.updateOrder(order);
    }

    @Override
    public Order queryOrderById(String id) throws Exception
    {
        // TODO Auto-generated method stub
        return orderDao.getById(id);
    }

    @Override
    public List<Order> queryOrderByUid(String uid) throws Exception
    {
        CritMap mp = new CritMap();
        mp.addEqual("uid", uid);
        mp.addDesc("orderTime");
        return orderDao.findByCritMap(mp, false);
    }

    @Override
    public PageFinder<Order> queryOrderByUidForPage(Query query, String uid)
            throws Exception
    {
        // TODO Auto-generated method stub
        CritMap mp = new CritMap();
        mp.addEqual("uid", uid);
        mp.addDesc("orderTime");
        return orderDao
                .pagedByCritMap(mp, query.getPage(), query.getPageSize());
    }

    @Override
    public List<OrderDetail> queryOrderDetail(String orderId) throws Exception
    {
        // TODO Auto-generated method stub
        return orderDetailDao.queryOrderDetail(orderId);
    }

}
