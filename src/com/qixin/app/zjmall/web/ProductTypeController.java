package com.qixin.app.zjmall.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qixin.app.AppConstants;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjmall.model.Product;
import com.qixin.app.zjmall.model.ProductType;
import com.qixin.app.zjmall.service.IProductService;
import com.qixin.app.zjmall.service.IProductTypeService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;

@Controller
@RequestMapping("/mallmanage")
public class ProductTypeController {

	@Resource
	private IProductTypeService ptService;
	
	
	@Resource
	private IProductService productService;




	/**
	 * 去增加分类页面
	 * 
	 * @return
	 */
	@RequestMapping("/toAddProductType")
	public ModelAndView toAddProductType(String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();

		map.put("bizid", bid);

		map.put("type", type);
		return new ModelAndView("/app/zjmall/addproducttype", map);
	}

	/**
	 * 添加消息
	 * 
	 * @return
	 */
	@RequestMapping("/addProductType")
	public ModelAndView addProductType(String typename, String id, String type,String istay,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {

		try {
			  Object bido = request.getSession()
                      .getAttribute(Constant.LOGIN_SYSTEM_USER);
              SystemmgtUser systemUser=(SystemmgtUser) bido;
              String bid = systemUser.getId();
			ProductType msg = new ProductType();
			msg.setTypename(typename);
			msg.setBizid(bid);
			msg.setIstay(istay);
			msg.setAddtime(DateUtil.getCurrentDateTimeToStr2());
			// 判断类型是否重复
			ProductType m = ptService.getProductTypeByExample(bid, typename);
			if (m != null && !"".equals(id)) {
				map.put("errorMsg", "此名称已存在，分类和标签不允许重名!");
				map.put("warnMessagekey", "00009");
				map.put("returnUrl", "queryProductType.kq?type="
						+ type);
				return new ModelAndView("/warnframe", map);
			}

			if (!"".equals(id)) {
				msg.setId(id);
				ptService.updateProductType(msg);
			} else {
				ptService.addProductType(msg);
			}
			map.put("type", type);
		} catch (Exception e) {
			CommonLogger.error("分类处理出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("/warnframe", map);

		}
		return new ModelAndView("redirect:queryProductType.kq", map);
	}

	/**
	 * 去修改分类页面
	 * 
	 * @return
	 */
	@RequestMapping("/toupdateProductType")
	public ModelAndView toUpdateProductType(String id, String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();
		ProductType pt = ptService.getProductTypeById(id);
		map.put("bizid", bid);
		map.put("type", type);
		map.put("pt", pt);
		return new ModelAndView("/app/zjmall/addproducttype", map);
	}

	/**
	 * 删除商品分类
	 * 
	 * @return
	 */
	@RequestMapping("/removeProductType")
	public ModelAndView removeProductType(String id, String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		try {
			Query query = new Query();
			PageFinder<Product> pageFinder  = productService.findByProducttype(id, query);
			if(null!=pageFinder&&pageFinder.getRowCount()>0)
			{
				map.put("errorMsg", "有商品使用了该分类，不允许删除！");
				map.put("warnMessagekey", "00008");
				map.put("returnUrl", "queryProductType.kq?type="
						+ type);
				return new ModelAndView("/warnframe", map);
			}
			ptService.removeProductType(id);
			map.put("type", type);
		} catch (Exception e) {
			CommonLogger.error("删除商品分类出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("/warnframe", map);

		}
		return new ModelAndView("redirect:queryProductType.kq");
	}

	/**
	 * 翻页查询
	 * 
	 * @param role
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryProductType")
	public ModelAndView queryProductType(String type,
			HttpServletRequest request, Query query) throws Exception {
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		query = (query != null) ? query : new Query();
		PageFinder<ProductType> pageFinder = ptService.getAllProductTypeByBid(
				bid, query);
		map.put("pageFinder", pageFinder);
		map.put("type", type);
		map.put("bid", bid);
		map.put("baseAppUrl",AppConstants.baseAppUrl);
		return new ModelAndView("/app/zjmall/qxmall", map);
	}

	@RequestMapping("/getptype")
	public void getproducType(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 取得用户归属的商家，需要调接口，不是这个方法
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();
		PrintWriter out = response.getWriter();
		try {

			Query query = new Query(100);
			PageFinder<ProductType> pageFinder = ptService
					.getAllProductTypeByBid(bid, query);
			Map<String, String> result = new HashMap<String, String>();
			for (ProductType pt : pageFinder.getData()) {
				result.put(pt.getId(), pt.getTypename());
			}
			String json = new Gson().toJson(result,
					new TypeToken<Map<String, String>>() {
					}.getType());
			out.print(json);
		} catch (Exception e) {
			out.print(500);
		} finally {
			out.flush();
			out.close();
		}
	}
}
