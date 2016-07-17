package com.qixin.app.zjmall.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.system.config.constant.Constant;
import com.qixin.app.system.user.model.SystemmgtUser;
import com.qixin.app.zjmall.common.PageStaticTool;
import com.qixin.app.zjmall.model.ClinkVo;
import com.qixin.app.zjmall.model.MallConf;
import com.qixin.app.zjmall.model.NavSet;
import com.qixin.app.zjmall.model.ProductType;
import com.qixin.app.zjmall.model.Skin;
import com.qixin.app.zjmall.service.IProductTypeService;
import com.qixin.app.zjmall.service.MallConfService;
import com.qixin.app.zjmall.service.NavSetService;
import com.qixin.app.zjmall.service.SkinService;
import com.qixin.platform.commons.Config;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.date.DateUtil;
import com.qixin.platform.tools.log.factory.AppLogFactory;
import com.qixin.platform.tools.log.model.vo.AppLog;

@Controller
@RequestMapping("/mallmanage")
public class SkinController {

	AppLog log = AppLogFactory.getLog(SkinController.class);

	@Resource
	private NavSetService navsetservice;
	@Resource
	private SkinService skinservice;
	@Resource
	private MallConfService mallconfservice;
	@Resource
	private IProductTypeService ptService;

	/**
	 * 导航设置
	 * 
	 * @param role
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/tonavset")
	public ModelAndView tonavset(String type, HttpServletRequest request,
			Query query) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		query = (query != null) ? query : new Query();
		query.setPageSize(10);
		Object bido = request.getSession().getAttribute(
				Constant.LOGIN_SYSTEM_USER);
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		// 商城模板配置信息
		MallConf mconf = mallconfservice.findByid((String) bid);
		map.put("mconf", mconf);
		List<Skin> skins = null;
		if (null != mconf) {
			skins = skinservice.getSkin(mconf.getSkinid());
		} else {
			// 首次进入选择默认风格
			skins = skinservice.getSkin(1);
		}
		map.put("skins", skins);
		List<NavSet> navs = null;
		if (null != mconf) {
			navs = navsetservice.getNavSet(bid, mconf.getSkinid());
		} else {
			navs = navsetservice.getNavSet(bid, 1);
		}

		NavSet[] navlis = new NavSet[navs.size()];
		navs.toArray(navlis);
		map.put("navlis", navlis);
		List<ClinkVo> linklis = getClinkByBid(request, bid);
		map.put("linklis", linklis);
		map.put("type", type);
		return new ModelAndView("/app/zjmall/navset", map);
	}

	@RequestMapping("/savenav")
	public void create(Query query, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		try {
			Object bido = request.getSession().getAttribute(
					Constant.LOGIN_SYSTEM_USER);
			SystemmgtUser systemUser = (SystemmgtUser) bido;
			String bid = systemUser.getId();
			int skinid = Integer.valueOf(request.getParameter("skinid"));
			int navindex = Integer.valueOf(request.getParameter("navindex"));
			String id = request.getParameter("id");
			String setkey = request.getParameter("setkey");
			String setvalue = request.getParameter("setvalue");
			NavSet nav = new NavSet();
			nav.setId(id);
			nav.setBizid(bid);
			nav.setNavindex(navindex);
			nav.setSkinid(skinid);
			nav.setSetkey(setkey);
			nav.setSetvalue(setvalue);
			nav.setUpdatetime(DateUtil.getCurrentDateTimeToStr2());
			navsetservice.update(nav);
			out.print("succ");
//			String url = createindexhtml(request, skinid);
//			log.info("Create Mall Index Page Success! bid ["+bid+"]");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("error");
		} finally {
			out.flush();
			out.close();
		}

	}

	@RequestMapping("/tomallconf")
	public ModelAndView tomallconf(Query query, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,Map<String, Object> map )
			throws Exception {
		Object bido = request.getSession().getAttribute(
				Constant.LOGIN_SYSTEM_USER);
		SystemmgtUser systemUser = (SystemmgtUser) bido;
		String bid = systemUser.getId();
		map.put("bizid", bid);
		MallConf mconf = mallconfservice.findByid(bid);
		map.put("mconf", mconf);
		map.put("type", "initmall");
		map.put("skin", getSkinimgurl(mconf.getSkinid()));
		return new ModelAndView("/app/zjmall/initmall", map);
	}

	@RequestMapping("/addmallconf")
	public ModelAndView addmallconf(HttpServletRequest request,
			HttpServletResponse response, String cstel, String skinid,
			String mallname, String footword, String outtimeset,Map<String, Object> map ) {
		try {
			Object bido = request.getSession().getAttribute(
					Constant.LOGIN_SYSTEM_USER);
			SystemmgtUser systemUser = (SystemmgtUser) bido;
			String bid = systemUser.getId();
			int skin = 1;
			if (skinid != null && !"".equals(skinid))
				skin = Integer.valueOf(skinid);

			MallConf msg = new MallConf();
			msg.setBizid(bid);
			msg.setCstel(cstel);
			msg.setSkinid(skin);
			msg.setMallname(mallname);
			msg.setStatus("1");
			msg.setOuttimeset(outtimeset);
			msg.setFootword(footword);
			msg.setUpdatetime(DateUtil.getCurrentDateTimeToStr2());
			// 根据规则构建商家首页

			String url = AppConstants.baseAppUrl + "static/" + bid
					+ "/app/mall/index.htm";
			msg.setUrl(url);
			MallConf mconf = mallconfservice.findByid((String) bid);
			if (null == mconf) {
				mallconfservice.save(msg);
				addDefaultNavsets(skin, bid);
			} else {
				mallconfservice.update(msg);
				map.put("oklab", "oklab");
//				String indexurl = createindexhtml(request, skin);
//				log.info("Create Mall Index Page Success! bid ["+bid+"] URL:["+indexurl+"]");
			}

			return new ModelAndView("redirect:tomallconf.kq",map);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/warnframe", null);
		}
	}

	@RequestMapping("/addskins")
	public ModelAndView addskins(HttpServletRequest request,
			HttpServletResponse response) {
		Skin sk = new Skin();
		try {
			String _skin = request.getParameter("skinid");
			int skinid = 1;
			if (_skin != null && !"".equals(_skin))
				skinid = Integer.valueOf(_skin);

			String _navindex = request.getParameter("navindex");
			int navindex = 1;
			if (_navindex != null && !"".equals(_navindex))
				navindex = Integer.valueOf(_navindex);

			int settype = 1;
			String _settype = request.getParameter("settype");
			if (_settype != null && !"".equals(_settype))
				settype = Integer.valueOf(_settype);

			String skinname = request.getParameter("skinname");
			String defaultvalue = request.getParameter("defaultvalue");
			String defaultkey = request.getParameter("defaultkey");
			String description = request.getParameter("description");
			sk.setDescription(description);
			sk.setDefaultvalue(defaultvalue);
			sk.setDefaultkey(defaultkey);
			sk.setSkinname(skinname);
			sk.setSettype(settype);
			sk.setSkinid(skinid);
			sk.setNavindex(navindex);

			skinservice.save(sk);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("/app/zjmall/skin");
	}

	@RequestMapping("/toaddskins")
	public ModelAndView toaddskins(HttpServletRequest request,
			HttpServletResponse response) {

		return new ModelAndView("/app/zjmall/skin");
	}

	public List<String> getSkinimgurl(int skinid) {
		List<String> lis = new ArrayList<String>();
		Config conf = Config.getInstance();
		int typecount = Integer.valueOf(conf.getconf("skincount"));
		String skinimgurl = conf.getconf("skinimgurl");
		for (int i = 1; i <= typecount; i++) {
			lis.add(skinimgurl + skinid + "/" + i + ".jpg");
		}
		return lis;
	}

	public void addDefaultNavsets(int skinid, String bizid) {

		try {
			List<NavSet> navs = navsetservice.getNavSet(bizid, skinid);
			List<Skin> skins = skinservice.getSkin(skinid);
			if (navs != null && navs.size() == skins.size())
				return;
			for (Skin skin : skins) {
				NavSet ns = new NavSet();
				ns.setBizid(bizid);
				ns.setNavindex(skin.getNavindex());
				ns.setSetkey(skin.getDefaultkey());
				ns.setSetvalue(skin.getDefaultvalue() + "&bid=" + bizid);
				ns.setSkinid(skinid);
				ns.setUpdatetime(DateUtil.getCurrentDateTimeToStr2());
				navsetservice.save(ns);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ClinkVo> getClinkByBid(HttpServletRequest request, String bid) {
		// 自定义URL列表
		/*
		 * PageFinder<WxMessage> msgurl = cusService.pageQueryWxMessage(
		 * WxMessage.PTXT_TYPE, bid, query);
		 */
		// 消息

		List<ClinkVo> linklis = new ArrayList<ClinkVo>();
		// 商品分类列表
		PageFinder<ProductType> typeFinder = ptService.getAllProductTypeByBid(
				bid, new Query(100));
		if (typeFinder.getRowCount() > 0) {
			for (ProductType ptype : typeFinder.getData()) {
				ClinkVo cv = new ClinkVo();
				cv.setLab(ptype.getTypename());
				cv.setValue(AppConstants.baseAppUrl
						+ "zjmall/mlist.kq?bid=" + bid + "&qtype="
						+ ptype.getId());
				linklis.add(cv);
			}
		}
		// 手动增加最新商品链接
		ClinkVo cv = new ClinkVo();
		cv.setLab("新品");
		cv.setValue(AppConstants.baseAppUrl + "zjmall/mlist.kq?bid=" + bid
				+ "&qtype=0");
		linklis.add(cv);
		return linklis;
	}

	public String createindexhtml(HttpServletRequest request, int skinid) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Object bido = request.getSession().getAttribute(
					Constant.LOGIN_SYSTEM_USER);
			SystemmgtUser systemUser = (SystemmgtUser) bido;
			String bid = systemUser.getId();
			MallConf mconf;
			mconf = mallconfservice.findByid((String) bid);
			map.put("mconf", mconf);
			List<NavSet> navlis = navsetservice.getNavSet(bid, skinid);
			map.put("navlis", navlis);
			PageStaticTool pst = new PageStaticTool();
			return pst.buildHtml("app/zjmall/index.ftl", bid
					+ "/app/mall/index", map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
