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
		
		
		var money = form.money;
		if(money.value.length==0){
			var timeclear = document.getElementById("timeclear");
			money.focus();
			timeclear.innerHTML="请输入积分规则的消费金额比例";
			return;
		}
		
		if(!checkNum(money.value)){
			var timeclear = document.getElementById("timeclear");
			money.focus();
			timeclear.innerHTML="建议输入积分规则的消费金额比例为整数";
			return;
		}
		
		var integral = form.integral;
		if(integral.value.length==0){
			var timeclear = document.getElementById("timeclear");
			integral.focus();
			timeclear.innerHTML="请输入积分规则的积分比例";
			return;
		}
		
		if(!checkNum(integral.value)){
			var timeclear = document.getElementById("timeclear");
			integral.focus();
			timeclear.innerHTML="建议输入积分规则的积分比例为整数";
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
	<li class="cur"><a href="${BasePath}/zj/getIntegralrule.kq">积分规则</a></li>
	<li><a href="${BasePath}/zj/getMemberlevel.kq">等级管理</a></li>
				<li><a href="${BasePath}/zj/getMembernotice.kq">公告管理</a></li>
	
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="${BasePath}/zj/updateIntegralrule.kq" method="post" class="r_con_form">
    <input name="id" type="hidden" value="<#if integralrule??>${integralrule.id}</#if>"/>
    <div class="rows">
        <label>积分规则 <span class="fc_red">*</span></label>
        <span class="input">消费金额比例
        	<input name="money" placeholder="消费金额" onChange="javascript:clearError();" value="<#if integralrule??>${integralrule.moneyproportion?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull   >
        	：积分比例
        	<input name="integral" placeholder="积分"  onChange="javascript:clearError();" value="<#if integralrule??>${integralrule.integralproportion?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull   >
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