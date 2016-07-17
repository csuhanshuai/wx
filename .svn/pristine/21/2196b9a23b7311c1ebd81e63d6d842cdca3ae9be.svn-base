package com.qixin.app.zjmall.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.zjmall.common.RXSJsonTool;
import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjmall.model.Cart;
import com.qixin.app.zjmall.model.CartListBean;
import com.qixin.app.zjmall.model.Label;
import com.qixin.app.zjmall.model.Labelselect;
import com.qixin.app.zjmall.model.MallConf;
import com.qixin.app.zjmall.model.NavSet;
import com.qixin.app.zjmall.model.Order;
import com.qixin.app.zjmall.model.OrderDetail;
import com.qixin.app.zjmall.model.PayType;
import com.qixin.app.zjmall.model.Product;
import com.qixin.app.zjmall.model.ProductLabelRelation;
import com.qixin.app.zjmall.model.ProductType;
import com.qixin.app.zjmall.service.CartService;
import com.qixin.app.zjmall.service.ILabelService;
import com.qixin.app.zjmall.service.IOrderService;
import com.qixin.app.zjmall.service.IPayTypeService;
import com.qixin.app.zjmall.service.IProductService;
import com.qixin.app.zjmall.service.IProductTypeService;
import com.qixin.app.zjmall.service.MallConfService;
import com.qixin.app.zjmall.service.NavSetService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ServiceTool;
import com.qixin.app.zjminweb.model.Coupon;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.app.zjminweb.service.CouponrecordService;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;
import com.qixin.platform.tools.log.factory.AppLogFactory;
import com.qixin.platform.tools.log.model.vo.AppLog;

import edu.emory.mathcs.backport.java.util.LinkedList;

@Controller
@RequestMapping("/zjmall")
public class MallController
{

    AppLog log = AppLogFactory.getLog(MallController.class);

    @Resource
    private IProductService productService;

    @Resource
    private MallConfService mallconfservice;

    @Resource
    private CartService cartService;

    @Resource
    private IProductTypeService ptService;

    @Resource
    private MemberService memberservice;

    @Resource
    private NavSetService navsetservice;

    /**
     * 订单的业务接口
     */
    @Resource
    private IOrderService orderService;

    @Resource
    private IPayTypeService payTypeService;

    @Resource
    private CouponrecordService couponrecordService;

    @Resource
    private ILabelService labelService;

    @RequestMapping("/index")
    public ModelAndView index(Query query, String bid, String openid,
            HttpServletRequest request, Map<String, Object> map,
            HttpServletResponse response) throws Exception
    {

        MallConf mconf;
        mconf = mallconfservice.findByid(bid);
        map.put("mconf", mconf);
        List<NavSet> navlis = navsetservice.getNavSet(bid, mconf.getSkinid());
        map.put("navlis", navlis);
        map.put("openid", openid);

        Member member = memberservice.getMemberByOpenid(openid);
        if (member != null)
        {
            request.getSession().setAttribute("zjminweb_member", member);

        }
        query.setPageSize(6);
        PageFinder<Product> pageFinder = productService
                .getAllforbid(bid, query);
        map.put("pageFinder", pageFinder);
        return new ModelAndView("/app/zjmall/index", map);
    }

    @RequestMapping("/toregister")
    public ModelAndView toregister(String error, String bid,
            HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> map) throws Exception
    {

        MallConf mconf = mallconfservice.findByid(bid);

        map.put("mconf", mconf);
        map.put("error", error);
        return new ModelAndView("/app/zjmall/register", map);

    }

    @RequestMapping("/tomyindex")
    public ModelAndView tomyindex(String bid, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        Map<String, Object> map = islogin(request);
        if (null == map)
            return new ModelAndView("redirect:tologin.kq?bid=" + bid);
        else
            return new ModelAndView("/app/zjmall/myindex", map);

    }

    @RequestMapping("/tologin")
    public ModelAndView tologin(String bid, String openid, String loginerror,
            HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> map) throws Exception
    {
        MallConf mconf = mallconfservice.findByid(bid);
        map.put("bid", bid);
        map.put("openid", openid);
        map.put("mconf", mconf);
        map.put("loginerror", loginerror);
        return new ModelAndView("/app/zjmall/login", map);

    }

    public Map<String, Object> islogin(HttpServletRequest request)
            throws Exception
    {

        Map<String, Object> map = new HashMap<String, Object>();

        // MallUser u = muserService.findByid(uid);
        // map.put("muser", u);
        // MallConf mconf = mallconfservice.findByid(u.getBid());
        // map.put("mconf", mconf);
        return map;
    }

    @RequestMapping("/topwd")
    public ModelAndView topwd(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        Map<String, Object> map = islogin(request);
        if (null == map)
            return new ModelAndView("redirect:/qxmall/tologin.kq");
        return new ModelAndView("/app/zjmall/mypwd", map);

    }

    @RequestMapping("/tomyorder")
    public ModelAndView tomyorder(Query query, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        Map<String, Object> map = islogin(request);
        if (null == map)
            return new ModelAndView("redirect:/qxmall/tologin.kq?");
        return new ModelAndView("/app/zjmall/myorderlist", map);

    }

    @RequestMapping("/login")
    public ModelAndView login(String bid, String username, String openid,
            HttpServletRequest request, ModelMap map)
    {
        try
        {
            Member u = memberservice.getMemberByOpenid(openid);
            if (u == null || null == openid || "".equals(openid))
            {
                map.put("loginerror", "openid不正確或未注册!");
                map.put("bid", bid);
                return new ModelAndView("redirect:/qxmall/tologin.kq", map);
            }
            else
            {
                MallConf mconf = mallconfservice.findByid(bid);
                map.put("mconf", mconf);
                map.put("muser", u);
                // 保存到session
                request.getSession().setAttribute(
                        AppConstants.MallLoginUserSessionATRN, u.getId());
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("登录出错 :", e);
        }
        return new ModelAndView("/app/zjmall/myindex", map);
    }

    @RequestMapping("/mlist")
    public ModelAndView mlist(Query query, String bid, String openid,
            String isshow, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        String qtype = request.getParameter("qtype");
        Map<String, Object> map = new HashMap<String, Object>();
        MallConf mconf = mallconfservice.findByid(bid);

        map.put("mconf", mconf);
        ProductType pt = ptService.getProductTypeById(qtype);
        String pagetitle = pt == null ? "最新上线" : pt.getTypename();
        pagetitle = !CommonTool.isEmpty(isshow) ? "商品展示" : pagetitle;
        query.setPageSize(10);
        PageFinder<Product> pageFinder = productService
                .UserfindByProductBytype(bid, qtype, query);
        map.put("pageFinder", pageFinder);
        map.put("pagetitle", pagetitle);
        map.put("qtype", qtype);
        map.put("openid", openid);
        map.put("isshow", isshow);
        map.put("bid", bid);
        map.put("ptflag", request.getParameter("ptflag"));

        // 查询商品分类
        List<ProductType> ptlist = this.ptService.getPTypelisBytay("1", bid);
        map.put("ptlist", ptlist);

        List<Label> labellist = labelService.queryAllLabel();
        map.put("labellist", labellist);

        // 查询用户信息
        if (!CommonTool.isEmpty(openid))
        {
            Member member = this.memberservice.getMemberByOpenid(openid);
            request.getSession().setAttribute("zjminweb_member", member);
        }

        return new ModelAndView("/app/zjmall/mlist", map);
    }

    @RequestMapping("/nextmlist")
    public void nextmlist(String bizid, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter out = response.getWriter();
        String qtype = request.getParameter("qtype");
        String isshow = request.getParameter("isshow");
        int page = 0;
        try
        {
            page = Integer.parseInt(request.getParameter("page"));
        }
        catch (Exception e)
        {
            page = 0;
        }
        Query query = new Query();
        query.setPageSize(10);
        query.setPage(page);
        PageFinder<Product> pageFinder;
        if (null != qtype && !"".equals(qtype) && !"0".equals(qtype))
        {
            // typeID是唯一的，所以不用区分商家,不bizid
            pageFinder = productService.findByProducttype(qtype, query);
        }
        else
        {
            pageFinder = productService.UserfindByProductBytype(bizid, qtype,
                    query);
        }
        if (pageFinder.getRowCount() < 1)
        {
            out.print("");
        }
        else
        {
            String json = new RXSJsonTool().getnextmlix(request,
                    pageFinder.getData(), page);
            out.print(json);
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/datact")
    public void dataact(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        PrintWriter out = response.getWriter();
        try
        {
            int[] h = (int[]) request.getSession().getAttribute("h");
            if (h == null)
                h = new int[3];
            int index = RXSJsonTool.getarraymax(h);
            out.print(h[index]);
        }
        catch (Exception e)
        {
            out.print(500);
        }
        finally
        {
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/ajaxmlist")
    public void ajaxmgetlist(String bizid, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter out = response.getWriter();
        String qtype = request.getParameter("qtype");
        int w = Integer.parseInt(request.getParameter("w"));
        int top = Integer.parseInt(request.getParameter("top"));
        int ti = Integer.parseInt(request.getParameter("ti"));

        String isshow = request.getParameter("isshow");

        int page = 0;
        try
        {
            page = Integer.parseInt(request.getParameter("page"));
        }
        catch (Exception e)
        {
            page = 0;
        }
        Query query = new Query();
        query.setPageSize(10);
        query.setPage(page);
        PageFinder<Product> pageFinder;
        if (null != qtype && !"".equals(qtype) && !"0".equals(qtype))
        {
            // typeID是唯一的，所以不用区分商家,不bizid
            pageFinder = productService.findByProducttype(qtype, query);
        }
        else
        {
            pageFinder = productService.getAllbyuid(bizid, query, isshow);
        }
        if (pageFinder.getRowCount() < 1)
        {
            out.print("");
        }
        else
        {
            String json = new RXSJsonTool().getwwli(request, w, top, ti,
                    pageFinder.getData(), page);
            out.print(json);
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/show")
    public ModelAndView show(Query query, String bid, String id, String openid,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("product", productService.findByid(id));
        MallConf mconf = mallconfservice.findByid(bid);
        // 增加OPENID，在加入购物车时会用到
        map.put("openid", openid);
        map.put("mconf", mconf);
        map.put("bid", bid);
        // 查询该产品的标签
        List<Label> labels = labelService.queryProductLabelByProductId(id);
        map.put("labels", labels);

        return new ModelAndView("/app/zjmall/show", map);
    }

    @RequestMapping("/tocart")
    public ModelAndView tocart(Query query, String bid, String openid,
            HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> map) throws Exception
    {

        query = (query != null) ? query : new Query();

        map.put("bid", bid);
        map.put("openid", openid);
        Member u = memberservice.getMemberByOpenid(openid);
        if (u == null || null == openid || "".equals(openid))
            return new ModelAndView("redirect:tologin.kq", map);
        query.setPageSize(10);
        List lis = cartService.queryCartbyid(openid, query);
        map.put("cartlist", lis);
        float mpric = 0;

        // 几件商品数
        Integer mNum = 0;
        // 总商品数
        int totalNum = 0;
        for (int i = 0; i < lis.size(); i++)
        {
            LinkedList unionPlis = (LinkedList) lis.get(i);

            // 第一条放的是PRODUCT
            Product pro = (Product) unionPlis.get(0);
            // 第二条放PRODUCT数量
            mNum = (Integer) unionPlis.get(1);

            mpric += Float.valueOf(pro.getOpric()) * mNum;

            totalNum += mNum;

        }

        map.put("cartcount", totalNum);
        map.put("mpric", (float) (Math.round(mpric * 100)) / 100);
        MallConf mconf = mallconfservice.findByid(bid);
        map.put("mconf", mconf);
        map.put("muser", u);
        return new ModelAndView("/app/zjmall/cart", map);
    }

    @RequestMapping("/addtocart")
    public void addtocart(HttpServletRequest request,
            HttpServletResponse response, String openid) throws Exception
    {

        PrintWriter out = response.getWriter();
        try
        {
            // 产品表中的id，对应购物车表中的pid
            String id = request.getParameter("id");
            String number = request.getParameter("number");
            if (null == openid || "".equals(openid))
            {
                out.print("logout");
            }
            else
            {
                // 首先查询看购物车中是否有同品牌的商品，有就进行更新操作，累加数量，没有就新增一条记录

                Cart cart = new Cart(id, openid, DateUtil.getDate(),
                        Integer.parseInt(number));
                cartService.save(cart);
                out.print("已放入购物车！");
            }
        }
        catch (Exception e)
        {
            out.print("error");
        }
        finally
        {
            out.flush();
            out.close();
        }

    }

    /**
     * 在购物车界面中点击结算跳到填写订单收货地址
     * 
     * @param request
     * @param response
     * @param cartlistinfo
     * @param openid
     * @return
     */
    @RequestMapping(value = "/preOrder", method = RequestMethod.POST)
    public ModelAndView preOrder(HttpServletRequest request,
            HttpServletResponse response, CartListBean cartlistinfo,
            String openid)
    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        if (null == openid || "".equals(openid))
        {
            return new ModelAndView("redirect:tologin.kq", map);
        }

        map.put("bid", request.getParameter("bid"));

        // 查询当前用户的有效性
        Member u = null;
        try
        {
            u = memberservice.getMemberByOpenid(openid);
        }
        catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (u == null)
            return new ModelAndView("redirect:tologin.kq", map);

        // 最终要提交的购物车
        List<Cart> cartList = cartlistinfo.getCartlistinfo();
        if (null != cartList && 0 != cartList.size())
        {
            try
            {
                cartService.deleteCartByUid(openid);
                for (Cart cart : cartList)
                {
                    Cart saveCart = new Cart(cart.getId(), openid,
                            DateUtil.getDate(), cart.getNumber());
                    cartService.save(saveCart);
                }

                // 查询支付类型（可以考虑把这个数据放在缓存中，当系统初始化时）
                List<PayType> payTypeList = payTypeService.queryValidPayType();
                map.put("payTypeList", payTypeList);

                // 再查询一下购物车的总金额
                List lis = cartService.queryCartbyid(openid, null);
                Integer mNum;
                float mpric = 0;
                
                List<Product> productlist = new ArrayList<Product>();
                
                for (int i = 0; i < lis.size(); i++)
                {
                    LinkedList unionPlis = (LinkedList) lis.get(i);

                    // 第一条放的是PRODUCT
                    Product pro = (Product) unionPlis.get(0);
                    productlist.add(pro);
                    // 第二条放PRODUCT数量
                    mNum = (Integer) unionPlis.get(1);

                    mpric += Float.valueOf(pro.getOpric()) * mNum;

                }
                map.put("mpric", mpric);
                map.put("productlist", productlist);

                // 查询一下有效的优惠券
                List<Coupon> couponList = couponrecordService
                        .getUserValiaCouponByMemId(u.getId(), mpric);

                map.put("couponList", couponList);
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                map.put("errorMessageException", "提交订单失败，请联系客服人员，谢谢！");
                return new ModelAndView("/app/zjmall/error", map);
            }
        }

        try
        {
            // 获取收获地址
            List<Order> orderlist = this.orderService.queryOrderByUid(openid);

            if (!CommonTool.isEmpty(orderlist))
            {

                map.put("orderaddress", orderlist.get(0));
            }
            else
            {
                // 获取会员卡的地址信息
                Member member = this.memberservice.getMemberByOpenid(openid);
                map.put("memberaddress", member);
            }
        }
        catch (Exception e)
        {

        }

        return new ModelAndView("/app/zjmall/preorder", map);
    }

    /**
     * 下订单
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public void addOrder(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        // JSONObject resp = new JSONObject();
        Response<Map<String, String>> resp = new Response<Map<String, String>>();
        PrintWriter out = response.getWriter();

        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            String openId = request.getParameter("openid");
            map.put("openid", openId);
            if (null == openId || "".equals(openId))
            {
                // return new ModelAndView("redirect:tologin.kq", map);
                resp.setResult("logout");
                out.print(JSONObject.fromObject(resp));
                // resp.put("result", "logout");
                // return resp.toString();
            }

            String bid = request.getParameter("bid");

            // 查询当前用户的有效性
            Member u = null;
            try
            {
                u = memberservice.getMemberByOpenid(openId);
            }
            catch (Exception e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (u == null)
            {
                resp.setResult("invaliduser");
                out.print(JSONObject.fromObject(resp));
                // resp.put("result", "invaliduser");
                // return resp.toString();
            }

            String receiver = request.getParameter("receiver");
            String phoneNum = request.getParameter("phoneNum");
            String receiveAddr = request.getParameter("receiveAddr");
            String payType = request.getParameter("payType");
            if (receiver == null || "".equals(receiver) || phoneNum == null
                    || "".equals(phoneNum) || receiveAddr == null
                    || "".equals(receiveAddr) || "".equals(payType)
                    || payType == null)
            {
                map.put("errorMessageException", "收货人或收货人联系电话或收货人地址为空，请正确输入");
                // return new ModelAndView("/app/zjmall/error", map);
                resp.setResult("paramisnull");
                out.print(JSONObject.fromObject(resp));
            }
            else
            {
                // 优惠券ID
                String coupon = request.getParameter("coupon");

                StringBuffer address = new StringBuffer();
                String addrProv = request.getParameter("addrProv");
                String addrCity = request.getParameter("addrCity");
                String addrArea = request.getParameter("addrArea");
                address.append(
                        !CommonTool.isEmpty(addrProv)
                                && !"请选择".equals(addrProv) ? addrProv : "")
                        .append(!CommonTool.isEmpty(addrCity)
                                && !"请选择".equals(addrCity) ? addrCity : "")
                        .append(!CommonTool.isEmpty(addrArea)
                                && !"请选择".equals(addrArea) ? addrArea : "")
                        .append(receiveAddr);
                Order order = new Order();
                order.setPhoneNum(phoneNum);
                order.setReceiveAddr(address.toString());
                order.setReceiver(receiver);
                order.setUid(openId);
                order.setOrderTime(CommonTool
                        .getNowDateBySDF("yyyy-MM-dd HH:mm:ss"));
                order.setStatus(0);

                // 短ID
                order.setId(ShortUUID.generateShortUuid());

                Map<String, String> orderToAlipaymap = new HashMap<String, String>();

                String result = orderService.addOrder(order, openId, coupon,
                        payType, u, bid, orderToAlipaymap);

                // return new ModelAndView("/app/zjmall/ordersucc", map);
                resp.setResult(result);
                resp.setT(orderToAlipaymap);
                out.print(JSONObject.fromObject(resp));
                // resp.put("result", result);
            }

        }
        catch (Exception e)
        {
            resp.setResult("error");
            out.print(JSONObject.fromObject(resp));
            // resp.put("result", "error");
        }
        finally
        {
            out.flush();
            out.close();
        }
        // return resp.toString();
    }

    /**
     * 我的订单
     * 
     * @param request
     * @param response
     * @param openid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/myOrder")
    public ModelAndView myOrder(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid)
            throws Exception
    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        if (null == openid || "".equals(openid))
        {
            return new ModelAndView("redirect:tologin.kq", map);
        }
        map.put("bid", bid);
        // 验证此用户的有效性
        Member u = memberservice.getMemberByOpenid(openid);
        if (u == null || null == openid || "".equals(openid))
            return new ModelAndView("redirect:tologin.kq", map);

        // 首先查询该用户的主订单信息
        List<Order> orderList = orderService.queryOrderByUid(openid);

        String orderId;
        List<OrderDetail> orderDetailList = null;
        // 返回订单信息集合
        List<List<Object>> orderInfoList = new ArrayList<List<Object>>();
        for (Order order : orderList)
        {
            orderId = order.getId();
            orderDetailList = orderService.queryOrderDetail(orderId);

            // 保存的订单信息(包含订单主信息和详情信息)
            List<Object> orderInfo = new ArrayList<Object>();
            orderInfo.add(order);
            orderInfo.add(orderDetailList);

            orderInfoList.add(orderInfo);
        }
        // 订单个数
        map.put("orderCount", orderList.size());
        map.put("orderInfoList", orderInfoList);

        MallConf mconf = mallconfservice.findByid(bid);
        map.put("mconf", mconf);
        map.put("muser", u);

        return new ModelAndView("/app/zjmall/myorder", map);
    }

    /**
     * 查我的订单详情
     * 
     * @param request
     * @param response
     * @param openid
     * @param orderId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/myOrderDetail")
    public ModelAndView myOrderDetail(HttpServletRequest request,
            HttpServletResponse response, String openid, String bid,
            String orderId) throws Exception
    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        if (null == openid || "".equals(openid))
        {
            return new ModelAndView("redirect:tologin.kq", map);
        }
        map.put("bid", bid);
        // 验证此用户的有效性
        Member u = memberservice.getMemberByOpenid(openid);
        if (u == null || null == openid || "".equals(openid))
            return new ModelAndView("redirect:tologin.kq", map);

        // 首先查询该用户的主订单信息
        Order order = orderService.queryOrderById(orderId);
        List<OrderDetail> orderDetailList = orderService
                .queryOrderDetail(orderId);

        map.put("orderDetailList", orderDetailList);
        map.put("order", order);

        return new ModelAndView("/app/zjmall/myorderdetail", map);
    }

    /**
     * 删除购物车中某一产品
     * 
     * @param id
     * @param bid
     * @param openid
     * @param request
     * @param response
     * @param map
     * @throws Exception
     */
    @RequestMapping("/deleteOneCart")
    public ModelAndView deleteOneCart(String id, String bid, String openid,
            HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> map) throws Exception
    {
        map.put("bid", bid);
        map.put("openid", openid);
        Member u = memberservice.getMemberByOpenid(openid);
        if (u == null || null == openid || "".equals(openid))
            return new ModelAndView("redirect:tologin.kq", map);

        cartService.delete(id);
        ModelAndView ma = new ModelAndView("redirect:tocart.kq");
        ma.addObject("openid", openid);
        ma.addObject("bid", bid);
        return ma;
    }

    /**
     * 立即购买
     * 
     * @param id
     * @param bid
     * @param openid
     * @param number
     * @param request
     * @param response
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/nowToOrder")
    public ModelAndView nowToOrder(String id, String bid, String openid,
            String number, HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> map)
            throws Exception
    {
        // 首先查询看购物车中是否有同品牌的商品，有就进行更新操作，累加数量，没有就新增一条记录
        Cart cart = new Cart(id, openid, DateUtil.getDate(),
                Integer.parseInt(number));
        cartService.save(cart);
        map.put("openid", openid);
        map.put("bid", bid);
        ModelAndView ma = new ModelAndView("redirect:tocart.kq", map);

        return ma;
    }

    @RequestMapping("/queryProductByLabel")
    public ModelAndView queryProductByLabel(Query query, String bid,
            String openid, String labelid, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        // String qtype = request.getParameter("qtype");
        Map<String, Object> map = new HashMap<String, Object>();
        MallConf mconf = mallconfservice.findByid(bid);

        map.put("mconf", mconf);
        // ProductType pt = ptService.getProductTypeById(qtype);
        // String pagetitle = pt == null ? "最新上线" : pt.getTypename();
        // pagetitle = !CommonTool.isEmpty(isshow) ? "商品展示" : pagetitle;
        query.setPageSize(10);

        List<Labelselect> labelidlist = ServiceTool.getLabellist(labelid);
        map.put("selectlabelidlist", labelidlist);

        PageFinder<ProductLabelRelation> labelPageFinder = labelService
                .queryProductIdByLabelId(
                        ServiceTool.getLabelselect(labelidlist), query);

        List<Product> products = new ArrayList<Product>();
        List<ProductLabelRelation> plrs = labelPageFinder.getData();
        if (!CommonTool.isEmpty(plrs))
        {
            for (ProductLabelRelation plr : plrs)
            {
                String productId = plr.getProductId();
                Product product = productService.findByid(productId);
                products.add(product);
            }
        }
        PageFinder<Product> pageFinder = new PageFinder<Product>(
                labelPageFinder.getPageNo(), labelPageFinder.getPageSize(),
                labelPageFinder.getRowCount(), products);

        List<Label> labellist = labelService.queryAllLabel();
        map.put("labellist", labellist);

        map.put("pageFinder", pageFinder);
        // map.put("pagetitle", pagetitle);
        // map.put("qtype", qtype);
        map.put("openid", openid);
        map.put("bid", bid);
        // map.put("isshow", isshow);
        map.put("labelid", labelid);
        return new ModelAndView("/app/zjmall/labelquerylist", map);
    }

    @RequestMapping("/nextQueryProductByLabel")
    public void nextQueryProductByLabel(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter out = response.getWriter();
        String labelid = request.getParameter("labelid");
        int page = 0;
        try
        {
            page = Integer.parseInt(request.getParameter("page"));
        }
        catch (Exception e)
        {
            page = 0;
        }
        Query query = new Query();
        query.setPageSize(10);
        query.setPage(page);

        String[] labelids = null;
        if (!CommonTool.isEmpty(labelid))
        {
            labelids = labelid.split("\\,");
        }

        PageFinder<ProductLabelRelation> labelPageFinder = labelService
                .queryProductIdByLabelId(labelids, query);

        List<Product> products = new ArrayList<Product>();
        List<ProductLabelRelation> plrs = labelPageFinder.getData();
        if (!CommonTool.isEmpty(plrs))
        {
            for (ProductLabelRelation plr : plrs)
            {
                String productId = plr.getProductId();
                Product product = productService.findByid(productId);
                products.add(product);
            }
        }
        PageFinder<Product> pageFinder = new PageFinder<Product>(
                labelPageFinder.getPageNo(), labelPageFinder.getPageSize(),
                labelPageFinder.getRowCount(), products);

        if (pageFinder.getRowCount() < 1)
        {
            out.print("");
        }
        else
        {
            String json = new RXSJsonTool().getnextmlix(request,
                    pageFinder.getData(), page);
            out.print(json);
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/zjminweb/getAddress")
    public void getAddress(HttpServletRequest request,
            HttpServletResponse response, String openid)
    {
        PrintWriter out = null;
        Response<Order> resp = new Response<Order>();
        try
        {
            out = response.getWriter();

            if (CommonTool.isEmpty(openid))
            {
                CommonLogger.info("输入参数为空");
                resp.setResult("error");
                resp.setMessage("输入参数为空！");
            }
            else
            {

                List<Order> orderlist = this.orderService
                        .queryOrderByUid(openid);

                if (CommonTool.isEmpty(orderlist))
                {
                    CommonLogger.info("没有查询到记录");
                    resp.setResult("error");
                    resp.setMessage("查询无数据！");
                }
                else
                {

                    resp.setResult("success");
                    resp.setT(orderlist.get(0));
                    resp.setMessage("operate ok!");

                    CommonLogger.info("查询最近订单地址成功！返回对象：" + resp.toString());
                }
            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("get order 出错 :", e);
            resp.setResult("error");
            resp.setMessage("操作失败!");
            out.print(JSONObject.fromObject(resp).toString());
        }
        finally
        {
            out.flush();
            out.close();
        }
    }
}
