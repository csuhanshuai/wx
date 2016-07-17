package com.qixin.app.zjmall.web;

import java.io.PrintWriter;
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
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjmall.model.Label;
import com.qixin.app.zjmall.model.Product;
import com.qixin.app.zjmall.model.ProductLabelRelation;
import com.qixin.app.zjmall.model.ProductType;
import com.qixin.app.zjmall.service.ILabelService;
import com.qixin.app.zjmall.service.IProductService;
import com.qixin.app.zjmall.service.IProductTypeService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.model.Response;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;
import com.qixin.platform.tools.log.factory.AppLogFactory;
import com.qixin.platform.tools.log.model.vo.AppLog;

@Controller
@RequestMapping("/mallmanage")
public class ProductController
{

    AppLog log = AppLogFactory.getLog(ProductController.class);

    @Resource
    private IProductService productService;

    @Resource
    private IProductTypeService ptService;

    @Resource
    private ILabelService labelService;

    @RequestMapping("/queryProduct")
    public ModelAndView queryProduct(Query query, String type,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        query = (query != null) ? query : new Query();
        query.setPageSize(10);
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        Map<String, Object> map = new HashMap<String, Object>();
        PageFinder<Product> pageFinder = productService.getAllbyuid(bid, query,
                null);
        map.put("pageFinder", pageFinder);

        Map<String, String> typelis = new HashMap<String, String>();
        List<ProductType> types = ptService.getAllbyuid(bid);
        for (ProductType productType : types)
        {
            typelis.put(productType.getId(), productType.getTypename());
        }
        map.put("bid", bid);
        map.put("baseAppUrl", AppConstants.baseAppUrl);
        map.put("typelis", typelis);
        map.put("type", type);
        return new ModelAndView("/app/zjmall/qxmall", map);

    }

    @RequestMapping("/updateProductByIsshow")
    public void updateProductByIsshow(HttpServletRequest request,
            HttpServletResponse response, String id, String isshow)
            throws Exception
    {

        PrintWriter out = null;
        Response<Product> resp = new Response<Product>();
        try
        {
            out = response.getWriter();
            if (!CommonTool.isEmpty(id))
            {

                Product product = this.productService.findByid(id);
                if (product != null)
                {
                    product.setIsshow(isshow);
                    this.productService.updateProduct(product);
                    resp.setResult("success");
                    resp.setT(product);
                    resp.setMessage("operate ok!");

                    CommonLogger.info("更新成功！返回对象：" + resp.toString());
                }
                else
                {

                    CommonLogger.info("查询到的商品对象为空");
                    resp.setResult("error");
                    resp.setMessage("查询到的商品对象为空");

                }
            }
            else
            {

                CommonLogger.info("id不能为空");
                resp.setResult("error");
                resp.setMessage("id不能为空");

            }
            out.print(JSONObject.fromObject(resp).toString());
        }
        catch (Exception e)
        {
            CommonLogger.error("update ProductByIsshow出错 :", e);
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

    /**
     * 去增加商品页面
     * 
     * @return
     */
    @RequestMapping("/toaddProduct")
    public ModelAndView toAddProduct(String type, HttpServletRequest request,
            HttpServletResponse response, ModelMap map)
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        map.put("bizid", bid);
        map.put("type", type);
        PageFinder<ProductType> producttypes = ptService
                .getAllProductTypeByBid(bid, new Query(100));
        map.put("producttypes", producttypes);

        // 增加标签的查询显示
        try
        {
            List<Label> productLabels = labelService.queryAllLabel();
            map.put("productLabels", productLabels);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ModelAndView("/app/zjmall/addproduct", map);
    }

    /**
     * 去修改商品页面
     * 
     * @return
     */
    @RequestMapping("/toupdateProduct")
    public ModelAndView toUpdateProduct(String type,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map, String id, String flag)
    {
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        map.put("bizid", bid);
        map.put("type", type);
        map.put("flag", flag);
        PageFinder<ProductType> producttypes = ptService
                .getAllProductTypeByBid(bid, new Query(100));
        map.put("producttypes", producttypes);

        try
        {
            // 查询商品
            Product product = this.productService.findByid(id);
            map.put("product", product);

            // 增加标签的查询显示
            List<Label> productLabels = labelService.queryAllLabel();
            map.put("productLabels", productLabels);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ModelAndView("/app/zjmall/addproduct", map);
    }

    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/addProduct")
    public ModelAndView addproduct(String type, Query query,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map)
    {

        /**
         * String pname, String pid, String pric, String ptype, String imgpath,
         * String imgcount, String status, String description, String
         * lastupdate, String remark
         */
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        String ptitle = request.getParameter("ptitle");
        String pid = request.getParameter("pid");
        String pric = request.getParameter("pric");
        String opric = request.getParameter("opric");
        String ptype = request.getParameter("ptype");
        String imgpath = request.getParameter("imgpath");
        String imgcount = request.getParameter("imgcount");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String remark = request.getParameter("remark");
        int fristimgw = Integer.valueOf(request.getParameter("fristimgw"));
        int fristimgh = Integer.valueOf(request.getParameter("fristimgh"));

        // 产品类别：实物商品、虚拟商品
        String category = request.getParameter("category");
        Product cinfo = new Product(ptitle, pid, bid, pric, opric, ptype,
                imgpath, imgcount, status, description, DateUtil.getDate(),
                remark, fristimgh, fristimgw, category, "0");
        try
        {
            String productId = productService.save(cinfo);
            map.put("type", type);

            // 接着保存该产品的标签
            String labels = request.getParameter("selectlabel");
            if (null != labels && !"".equals(labels))
            {
                String[] labelArray = labels.split(",");
                ProductLabelRelation plr = null;
                for (int i = 0; i < labelArray.length; i++)
                {
                    plr = new ProductLabelRelation();
                    plr.setLabelId(labelArray[i]);
                    plr.setProductId(productId);
                    labelService.saveProductLabel(plr);
                }
            }

            return new ModelAndView("redirect:queryProduct.kq", map);
        }
        catch (Exception e)
        {
            return new ModelAndView("/warnframe", null);
        }

    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,
            HttpServletResponse response, ModelMap map, String type)
            throws Exception
    {
        map.put("type", type);
        /**
         * String pname, String pid, String pric, String ptype, String imgpath,
         * String imgcount, String status, String description, String
         * lastupdate, String remark
         */
        Object bido = request.getSession().getAttribute(
                Constant.LOGIN_SYSTEM_USER);
        SystemmgtUser systemUser = (SystemmgtUser) bido;
        String bid = systemUser.getId();
        String id = request.getParameter("id");
        String ptitle = request.getParameter("ptitle");
        String pid = request.getParameter("pid");
        String pric = request.getParameter("pric");
        String opric = request.getParameter("opric");
        String ptype = request.getParameter("ptype");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String remark = request.getParameter("remark");

        // 产品类别：实物商品、虚拟商品
        String category = request.getParameter("category");

        Product cinfo = this.productService.findByid(id);

        // Product cinfo = new Product(ptitle, pid, bid, pric, opric, ptype,
        // imgpath, imgcount, status, description, DateUtil.getDate(),
        // remark, fristimgh, fristimgw, category, "0");
        cinfo.setPtitle(ptitle);
        cinfo.setPid(pid);
        cinfo.setUid(bid);
        cinfo.setPric(pric);
        cinfo.setOpric(opric);
        cinfo.setPtype(ptype);

        cinfo.setStatus(status);
        cinfo.setDescription(description);
        cinfo.setLastupdate(DateUtil.getDate());
        cinfo.setRemark(remark);

        cinfo.setCategory(category);

        String imgpath = request.getParameter("imgpath");
        if (!CommonTool.isEmpty(imgpath))
        {
            cinfo.setImgpath(imgpath);
        }
        String imgcount = request.getParameter("imgcount");
        if (!CommonTool.isEmpty(imgcount))
        {
            cinfo.setImgcount(imgcount);
        }
        if (!CommonTool.isEmpty(request.getParameter("fristimgw")))
        {
            int fristimgw = Integer.valueOf(request.getParameter("fristimgw"));
            cinfo.setFristimgw(fristimgw);
        }
        if (!CommonTool.isEmpty(request.getParameter("fristimgh")))
        {
            int fristimgh = Integer.valueOf(request.getParameter("fristimgh"));
            cinfo.setFristimgh(fristimgh);
        }
        // PrintWriter out = response.getWriter();
        try
        {
            // productService.delete(id);
            // productService.save(cinfo);

            productService.updateProduct(cinfo);

            // 接着保存该产品的标签
            String labels = request.getParameter("selectlabel");
            if (!CommonTool.isEmpty(labels))
            {
                if (null != labels && !"".equals(labels))
                {
                    String[] labelArray = labels.split(",");
                    ProductLabelRelation plr = null;
                    for (int i = 0; i < labelArray.length; i++)
                    {
                        plr = new ProductLabelRelation();
                        plr.setLabelId(labelArray[i]);
                        plr.setProductId(cinfo.getId());
                        labelService.saveProductLabel(plr);
                    }
                }
            }
            // out.print("succ");
        }
        catch (Exception e)
        {
            // out.print("error");
        }
        // finally
        // {
        // out.flush();
        // out.close();
        // }
        return new ModelAndView("redirect:queryProduct.kq", map);

    }

    @RequestMapping("/remove")
    public ModelAndView remove(String id, String type,
            HttpServletRequest request, HttpServletResponse response,
            ModelMap map) throws Exception
    {

        try
        {
            productService.delete(id);
            map.put("type", type);
        }
        catch (Exception e)
        {
            CommonLogger.error("删除商品出错 :", e);
            map.put("errorMsg", "出错了!");
            return new ModelAndView("/warnframe", map);

        }
        return new ModelAndView("redirect:queryProduct.kq");

    }

}
