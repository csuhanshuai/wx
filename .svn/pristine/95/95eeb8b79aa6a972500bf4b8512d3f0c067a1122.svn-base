<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js?t=2013122302'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
    
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<#if zhaopin??>
		<tr>
			<td>
				<div >
	        	岗位名称：${zhaopin.name?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	学历：<#if zhaopin.education=='1'>
					 		中专
					 	<#elseif zhaopin.education=='2'>
					 		大专
					 	<#elseif zhaopin.education=='2'>
					 		本科
					 	<#elseif zhaopin.education=='2'>
					 		硕士
					 	<#else>
					 	--
					 	</#if>
	    		</div>
			</td>
		</tr>
		<tr>
			<td>
				<div >
	        	截止时间：${zhaopin.endtime?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	性别：<#if zhaopin.sex=='1'>
					 		不限
					 	<#elseif zhaopin.sex=='2'>
					 		男
					 	<#elseif zhaopin.sex=='3'>
					 		女
					 	<#else>
					 	--
					 	</#if>
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				<div >
	        	年龄：${zhaopin.age?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	工作地点：${zhaopin.workingplace?default("")}
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				<div >
	        	待遇：${zhaopin.pay?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	招聘人数：${zhaopin.numbers?default("")}
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				<div >
	        	工作年限：${zhaopin.workingnum?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	雇佣形式：<#if zhaopin.workingtype=='0'>
					 		不限
					 	<#elseif zhaopin.workingtype=='1'>
					 		全职
					 	<#elseif zhaopin.workingtype=='2'>
					 		兼职
					 	<#else>
					 	--
					 	</#if>
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2">
				<div >
	        	岗位描述 ：${zhaopin.description?default("")}
	    		</div>
			</td>
		</tr>
<#else>
<tr><td colspan="2"><div class="yt-tb-list-no">暂无内容</div></td></tr>
</#if>
</table>
    

</div>

</body>
</html>