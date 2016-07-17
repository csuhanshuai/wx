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
<#if membernotice??>
		<tr>
			<td>
				<div >
	        	公告名称：${membernotice.name?default("")}
	    		</div>
			</td>
			<td>
				<div >
	        	录入时间：${membernotice.intime?default("")}
	    		</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div >
	        	公告内容描述 ：${membernotice.description?default("")}
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