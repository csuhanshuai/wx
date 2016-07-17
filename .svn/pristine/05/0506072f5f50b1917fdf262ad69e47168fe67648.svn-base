package com.qixin.app;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.qixin.app.pay.alipay.config.AlipayConfig;
import com.qixin.app.system.config.model.SystemConfig;
import com.qixin.platform.commons.Config;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.util.JDBCUtils;

/**
 * 系统启动加载配置
 * 
 * @author sheyujun
 * 
 */
public class DefaultSystemInitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * logger.
	 */
	private static final Logger logger = Logger
			.getLogger(DefaultSystemInitServlet.class);

	/**
	 * 启动时候加载资源
	 */
	public void init() {

		if (logger.isInfoEnabled()) {
			CommonLogger.info("启动时候开始加载资源！");
		}
		// 缓存数据库系统配置项
		initSystemConfig();

		if (logger.isInfoEnabled()) {
			
			CommonLogger.info("BASEAPPURL:["+AppConstants.baseAppUrl+"]");
			CommonLogger.info("启动时候加载资源完成！");
		}
	}

	/**
	 * 缓存数据库系统配置项
	 */
	public void initSystemConfig() {

		try {

		    
		    
			InputStream in = this.getServletContext().getResourceAsStream(
					"/WEB-INF/classes/config.properties");
			Properties props = new Properties();
			props.load(in);
			AppConstants.baseAppUrl=props.getProperty("baseAppUrl");
			
			AlipayConfig.setAlipayReturnNotifyUrl(props.getProperty("alipayReturnNotifyUrl"));
            AlipayConfig.setAlipayReturnCallbackUrl(props.getProperty("alipayReturnCallbackUrl"));
            
            AlipayConfig.setAlipayReturnNotifyUrlPC(props.getProperty("alipayReturnNotifyUrlPC"));
            AlipayConfig.setAlipayReturnCallbackUrlPC(props.getProperty("alipayReturnCallbackUrlPC"));
            
            AppConstants.alipayAccount=props.getProperty("alipayAccount");
			
			List<SystemConfig> configList = JDBCUtils.getInstance()
					.getSystemConfigLsit();
			if (configList != null && configList.size() > 0) {
				for (SystemConfig systemConfig : configList) {
					Config.setConfigValue(systemConfig.getKey(),
							systemConfig.getValue());
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
			logger.error("缓存数据库系统配置项出错！", e);
		}
	}

	/**
	 * 关闭时资源清理
	 */
	public void destroy() {
		if (logger.isInfoEnabled()) {
			logger.info("关闭时资源清理开始！");
		}

		if (logger.isInfoEnabled()) {
			logger.info("关闭时资源清理成功！");
		}
	}
}
