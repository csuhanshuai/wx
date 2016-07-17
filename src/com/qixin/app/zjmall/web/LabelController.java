package com.qixin.app.zjmall.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjmall.model.Label;
import com.qixin.app.zjmall.service.ILabelService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;

@Controller
@RequestMapping("/mallmanage")
public class LabelController {
	
	@Resource
	private ILabelService labelService;

	/**
	 * 去增加标签页面
	 * 
	 * @return
	 */
	@RequestMapping("/toAddLabel")
	public ModelAndView toAddLabel(String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();

		map.put("bizid", bid);

		map.put("type", type);
		return new ModelAndView("/app/zjmall/addlabel", map);
	}

	/**
	 * 添加标签
	 * 
	 * @return
	 */
	@RequestMapping("/addLabel")
	public ModelAndView addLabel(String name, String id,String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {

		try {
			  Object bido = request.getSession()
                      .getAttribute(Constant.LOGIN_SYSTEM_USER);
              SystemmgtUser systemUser=(SystemmgtUser) bido;
              String bid = systemUser.getId();
              map.put("bid", bid);
			// 判断类型是否重复
			Label labelQ = labelService.queryLabelByName(name);
			if (labelQ != null) {
				map.put("errorMsg", "此标签已存在，标签不允许重名!");
				map.put("warnMessagekey", "00009");
				map.put("returnUrl", "queryLabel.kq?type="
						+ type);
				return new ModelAndView("/warnframe", map);
			}
			Label label = new Label();
			label.setName(name);
			if (!"".equals(id)) {
				//更新
				label.setId(id);
				label.setAddtime(DateUtil.getCurrentDateTimeToStr2());
				labelService.update(label);
			} else {
				//添加
				label.setAddtime(DateUtil.getCurrentDateTimeToStr2());
				labelService.save(label);
			}
			
		} catch (Exception e) {
			CommonLogger.error("标签处理出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("/warnframe", map);

		}
		map.put("type", type);
		return new ModelAndView("redirect:queryLabel.kq", map);
	}

	/**
	 * 去修改分类页面
	 * 
	 * @return
	 */
	@RequestMapping("/toupdateLabel")
	public ModelAndView toupdateLabel(String id, String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();
          map.put("bizid", bid);
          map.put("type", type);
		Label label = null;
		try {
			label = labelService.queryLabelbyid(id);
		} catch (Exception e) {
			CommonLogger.error("标签处理出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("/warnframe", map);
		}
		map.put("label", label);
		return new ModelAndView("/app/zjmall/addLabel", map);
	}

	/**
	 * 删除商品分类
	 * 
	 * @return
	 */
	@RequestMapping("/removeLabel")
	public ModelAndView removeLabel(String id, String type,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		try {
			//判断该标签是否有被引用
			if(labelService.queryLabelIsUsed(id))
			{
				map.put("errorMsg", "有商品使用了该标签，不允许删除！");
				map.put("warnMessagekey", "00008");
				map.put("returnUrl", "queryLabel.kq?type="
						+ type);
				return new ModelAndView("/warnframe", map);
			}
			labelService.delete(id);
			
		} catch (Exception e) {
			CommonLogger.error("删除商品标签出错 :", e);
			map.put("errorMsg", "出错了!");
			return new ModelAndView("/warnframe", map);

		}
		map.put("type", type);
		return new ModelAndView("redirect:queryLabel.kq", map);
	}

	/**
	 * 翻页查询
	 * 
	 * @param role
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryLabel")
	public ModelAndView queryLabel(String type,
			HttpServletRequest request, Query query) throws Exception {
		  Object bido = request.getSession()
                  .getAttribute(Constant.LOGIN_SYSTEM_USER);
          SystemmgtUser systemUser=(SystemmgtUser) bido;
          String bid = systemUser.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		query = (query != null) ? query : new Query();
		PageFinder<Label> pageFinder = labelService.findLabel(query);
		map.put("pageFinder", pageFinder);
		map.put("type", type);
		map.put("bid", bid);
		map.put("baseAppUrl",AppConstants.baseAppUrl);
		return new ModelAndView("/app/zjmall/qxmall", map);
	}
}
