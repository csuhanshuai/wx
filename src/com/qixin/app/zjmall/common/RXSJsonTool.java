package com.qixin.app.zjmall.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.qixin.app.zjmall.model.Product;

public class RXSJsonTool
{

    /*
     * 过滤自身关联
     */
    public static JsonConfig filterJsonConfig(final String... params)
    {

	JsonConfig config = new JsonConfig();
	config.setJsonPropertyFilter(new PropertyFilter()
	{

	    public boolean apply(Object arg0, String arg1, Object arg2)
	    {

		for (String par : params)
		{
		    if (arg1.equals(par)) { return true; }
		}
		return false;
	    }
	});
	return config;
    }

    public String convertObj2json(List<Product> list)
    {

	// 只需要"id", "imgpath", "ptitle","opric", "pric"
	JsonConfig jsConItem = filterJsonConfig("lastupdate", "status",
		"remark", "description", "pid", "imgcount", "ptype");

	// json数组
	String[] result = new String[list.size()];

	int k = 0;
	for (Product item : list)
	{

	    JSONObject object = JSONObject.fromObject(item, jsConItem);
	    //		
	    // object = JSONObject.fromObject(item, jsConItem);
	    // object.put("value", object);

	    result[k] = object.toString();
	    k++;
	}
	return JSONArray.fromObject(result).toString();
    }
   

    public String WriteWaterfallsflow(String filepath)
	    throws FileNotFoundException, IOException
    {

	File file = new File(filepath);
	BufferedImage sourceImg = ImageIO.read(new FileInputStream(file));
	System.out.println(sourceImg.getWidth());
	System.out.println(sourceImg.getHeight());

	return "";

    }

    public String getnextmlix(HttpServletRequest request, List<Product> pis, int pagecount)
    {
	int margin = 3;
	final int limaxcount=3;
	// 只需要"id", "imgpath", "ptitle","opric", "pric"
	JsonConfig jsConItem = filterJsonConfig("lastupdate", "status",
		"remark", "description", "pid", "imgcount", "ptype");
	String[] result = new String[pis.size()];
	
	for (int i = 0; i < pis.size(); i++)
	{
	    Product p=pis.get(i);
	    JSONObject object = JSONObject.fromObject(p, jsConItem);
	    result[i] = object.toString();
	}
	return JSONArray.fromObject(result).toString();
    }
    
    public String getwwli(HttpServletRequest request,int w, int top,int ti, List<Product> pis, int pagecount)
    {
	int margin = 3;
	final int limaxcount=3;
	int[] h=(int[]) request.getSession().getAttribute("h");
	if(h==null||pagecount == 1)
	    h=new int[limaxcount];
	// 只需要"id", "imgpath", "ptitle","opric", "pric"
	JsonConfig jsConItem = filterJsonConfig("lastupdate", "status",
		"remark", "description", "pid", "imgcount", "ptype");
	String[] result = new String[pis.size()];
	int liw = (int) (w * 1/limaxcount*0.97);
	for (int i = 0; i < pis.size(); i++)
	{
	    Product p=pis.get(i);
	    int lih = p.getFristimgh() * liw / p.getFristimgw()+ti;

	    if (pagecount == 1)
	    {
		h[i] = lih+top;
		p.setPtop(top);
		p.setPleft(i * liw);
	    }
	    else
	    {
		int mixkey = getarraymin(h);
		p.setPtop(h[mixkey]);
		p.setPleft(mixkey * liw);
		h[mixkey] += lih+margin;
	    }
	    JSONObject object = JSONObject.fromObject(p, jsConItem);
	    result[i] = object.toString();
	}
	request.getSession().setAttribute("h", h);
	return JSONArray.fromObject(result).toString();
    }

    public static int getarraymax(int[] arr)
    {

	int max = 0;
	for (int i = 1; i < arr.length; i++)
	{
	    if (arr[max] < arr[i])
		max = i;
	}
	return max;
    }

    public int getarraymin(int[] arr)
    {

	int min = 0;
	for (int i = 1; i < arr.length; i++)
	{
	    if (arr[min] > arr[i])
		min = i;
	}
	return min;
    }
    public static String cutstrbytag(String str, String tag) {
		if (null == str || null == tag || str.length() < 1 || tag.length() < 1)
			return null;

		return str.substring(0, str.indexOf(tag));
	}
}
