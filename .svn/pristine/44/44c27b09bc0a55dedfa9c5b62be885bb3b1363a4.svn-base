package com.qixin.app.system.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qixin.app.system.config.constant.Constant;
import com.qixin.platform.log.CommonLogger;

@Service
public class PrivilegeInterceptor extends HandlerInterceptorAdapter {

	private static String notLogIn = "/toLogin.kq";

	@RequestMapping("/error404")
	public ModelAndView error404(HttpServletRequest request, ModelMap map) {
		return new ModelAndView("system/commontemplate/error_404_page", map);
	}

	@RequestMapping("/error500")
	public ModelAndView error500(HttpServletRequest request, ModelMap map) {
		return new ModelAndView("system/commontemplate/error_500_page", map);
	}

	/**
	 * 异常友好提示页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/systemException")
	public ModelAndView systemException(HttpServletRequest request) {
		return new ModelAndView("system/commontemplate/error_exception_page");
	}

	@RequestMapping("/error_wordcensor")
	public ModelAndView errorWordcensor(HttpServletRequest request, ModelMap map) {
		map.put("wordcensor", request.getAttribute("wordcensor"));
		return new ModelAndView("system/commontemplate/error_wordcensor_page",
				map);
	}

	/**
	 * 去错误页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/error")
	public ModelAndView error(HttpServletRequest request) {
		return new ModelAndView("error", "errorMessageException",
				request.getAttribute("errorMessageException"));
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// String result = privilegeHelper.doCheck(request);
		// if (Constant.ACCESSABLE.equals(result)) {
		// return true;
		// } else if (Constant.NOT_LOGIN.equals(result)) {
		// response.sendRedirect(request.getContextPath()+notLogIn);
		// return false;
		// } else if (Constant.NO_PRIVILEGE.equals(result)) {
		// response.sendRedirect(request.getContextPath()+noPrivilege);
		// return false; //需要替换这个返回值以进入一个无权限警告页面（有返回按钮）
		// }
		//
		// 保存到session
		Object str = request.getSession().getAttribute(
				Constant.LOGIN_SYSTEM_USER);

		CommonLogger.info(request.getRequestURI());

		if (request.getRequestURI().indexOf("uploadImageFile") == -1
				&& request.getRequestURI().indexOf("qxmain") == -1
				&& request.getRequestURI().indexOf("/weixinpay/") == -1
				&& request.getRequestURI().indexOf("/zjmall/") == -1
				&& request.getRequestURI().indexOf("/article/") == -1
				&& request.getRequestURI().indexOf("/zjminweb/") == -1
				&& request.getRequestURI().indexOf("turentable") == -1
				&& request.getRequestURI().indexOf("/toLogin.kq") == -1
				&& request.getRequestURI().indexOf("/login.kq") == -1
				&& request.getRequestURI().indexOf("logOut") == -1
				&& request.getRequestURI().indexOf("/systemException") == -1
				&& request.getRequestURI().indexOf("/error") == -1
				&& request.getRequestURI().indexOf("/nosecurity") == -1
				&& request.getRequestURI().indexOf("/lanterngame") == -1 
				&& request.getRequestURI().indexOf("/jackgame") == -1
				&& request.getRequestURI().indexOf("/vote") == -1) {

			if (str == null) {
				response.getWriter().println(
						"<script>window.parent.location.href=\""
								+ request.getContextPath() + notLogIn
								+ "\";</script>");
				response.getWriter().flush();
				response.getWriter().close();
				return false;

			} else {
				// 检查权限

			}

		}

		return true;
	}

}
