package com.qixin.app.zjmall.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class PageStaticTool extends FreeMarkerView
{

  
    /**
     * 根据Freemarker模板文件路径、Map数据生成HTML静态文件
     *
     * @param templateFilePath Freemarker模板文件路径
     * @param htmlFilePath 生成HTML静态文件存放路径
     * @param data Map数据
     *
     */
    public String  buildHtml(String templateFilePath, String htmlFilePath, Map<String, Object> data) {
    	Writer out = null;
		try {
			// url路径
			// 模板文件配置
			Configuration configuration = SpringUtil.getConfiguration();
			 System.out.println(SpringUtil.getDirectoryForTemplateLoading().getPath());
			// 模板文件配置的相对路径
			// configuration.setDirectoryForTemplateLoading(SpringUtil.getDirectoryForTemplateLoading());
			// 模板文件
			Template template = configuration.getTemplate(templateFilePath,
					"UTF8");
			// html输出路径
			File htmlFile = new File(SpringUtil.getServletContextPath()+"/static/"
					+ htmlFilePath+".htm");
			// 文件夹不存在就创建
			File htmlDirectory = htmlFile.getParentFile();
			if (!htmlDirectory.exists()) {
				htmlDirectory.mkdirs();
			}
			// 写对象
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
			// 数据写入模板操作
			template.process(data, out);
			return "/static/"+ htmlFilePath+".htm";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				if(out != null){
					out.flush();// 刷新流
					out.close();// 关闭流
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

    }
    


}