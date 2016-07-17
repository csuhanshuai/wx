<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<script>
function checkNum(num)
{
   var number = /^\d+$/;
   return number.test(num);
}

	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		
		var start = form.start;
		if(start.value.length==0){
			var timeclear = document.getElementById("timeclear");
			start.focus();
			timeclear.innerHTML="请输入积分开始值";
			return;
		}
		
		if(!checkNum(start.value)){
			var timeclear = document.getElementById("timeclear");
			start.focus();
			timeclear.innerHTML="建议输入的积分开始值为整数";
			return;
		}
		
		var end = form.end;
		if(end.value.length==0){
			var timeclear = document.getElementById("timeclear");
			end.focus();
			timeclear.innerHTML="请输入积分结束值";
			return;
		}
		
		if(!checkNum(end.value) && end.value != '<'){
			var timeclear = document.getElementById("timeclear");
			end.focus();
			timeclear.innerHTML="建议输入的积分结束值为整数获取'<'";
			return;
		}
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("timeclear").innerHTML="";
	}

</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li><a href="${BasePath}/zj/getMembercard.kq">卡片管理</a></li>
				<li><a href="${BasePath}/zj/getMember.kq">会员管理</a></li>
				<li><a href="${BasePath}/zj/getIntegralrule.kq">积分规则</a></li>
				<li class="cur"><a href="${BasePath}/zj/getMemberlevel.kq">等级管理</a></li>
				<li><a href="${BasePath}/zj/getMembernotice.kq">公告管理</a></li>
	
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="${BasePath}/zj/updateMemberlevel.kq" method="post" class="r_con_form">
    <input name="id" type="hidden" value="<#if memberlevel??>${memberlevel.id}</#if>"/>
    <div class="rows">
        <label><#if memberlevel??>${memberlevel.name}</#if> <span class="fc_red">*</span></label>
        <span class="input">积分开始值
        	<input name="start" placeholder="积分开始值" onChange="javascript:clearError();" value="<#if memberlevel??>${memberlevel.integralstart?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull   >
        	<br><br>积分结束值
        	<input name="end" placeholder="积分结束值"  onChange="javascript:clearError();" value="<#if memberlevel??>${memberlevel.integralend?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull   >
        	<span class="tips">('<'标示到无穷大)</span>
        <div id="timeclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="提交保存" />
        <a href="javascript:history.go(-1); " class="btn_gray">返回</a></span>
        <div class="clear"></div>
    </div>
    <script language="javascript">
		if("oklab"=="${oklab?default('')}")
				alert("提交成功！")
    </script>
   </form>
</div>

</body>
</html>