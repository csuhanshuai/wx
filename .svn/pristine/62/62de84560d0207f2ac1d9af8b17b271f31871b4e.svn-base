<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript">
	var BasePath="${BasePath}";
</script>
<link rev="stylesheet" rel="stylesheet" type="text/css" href="${BasePath}/css/thickbox.css"  media="screen" />
<script type="text/javascript"  src="${BasePath}/js/common/thickbox/thickbox.js"></script>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>
</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
		    <ul>
		    	<li><a href="${BasePath}/zjdiaoyan/getDiaoyanList.kq">微调研</a></li>
                <li class="cur"><a href="${BasePath}/zj/getSignin.kq">微签到</a></li>
				

            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">

    <form name="qcust" id="qcust" class="add_form " method="post" action="${BasePath}/zj/getSigninrecord.kq">
    	<input name="signinid" type="hidden" value="<#if signinid??>${signinid?default("")}</#if>"/>
        <table border="0" cellpadding="5" cellspacing="0">
        	<tr>
        		<td colspan="2">标题：<#if signin??>${signin.name?default("")}</#if></td>
        		<td width="30%">今日签到：<#if signinrecordlist?? && (signinrecordlist?size>0)>${signinrecordlist?size}<#else>0</#if>人</td>
        		<td>二维码：<#if signin??><a href="${BasePath}/${signin.path?default("")}" target="_blank"><img src="${BasePath}/${signin.path?default("")}" style="width:30px;height:30px;"></a></#if></td>
        	</tr>
            <tr>
		        <td><span>时间段：</span></td>
                <td>
                	<input name="starttime" placeholder="开始时间" onChange="javascript:clearError();" value="<#if starttime??>${starttime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();" readonly notnull>
		        	至
		        	<input name="endtime" placeholder="结束时间"  onChange="javascript:clearError();" value="<#if endtime??>${endtime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();" readonly notnull>
                </td>
                <td colspan="2"><input type="submit" class="submit" value="查询" name="submit_btn"></td>
            </tr>
        </table>
    </form>
    
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">姓名</td>
                <td  nowrap="nowrap">电话</td>
                <td  nowrap="nowrap">签到时间</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>	
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.name?default("")}</td>
	                <td>${item.telephone?default("")}</td>
	                <td>
	                	${item.intime?string('yyyy-MM-dd')}
	                </td>
	                
	            </tr>
	        </#list>	
	    <#else>
		    <tr><td colspan="9"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if> 
        </tbody>
    </table>
<div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="qcust" />
<div class="blank20"></div>
    
	</div>  
</div>

</body>
</html>