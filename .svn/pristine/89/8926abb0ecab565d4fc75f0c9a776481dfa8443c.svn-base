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

<script>
function checkNum(num)
{
   var number = /^\d+$/;
   return number.test(num);
}

	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入促销活动名称";
			return;
		}
		
		
		var money = form.money;
		if(money.value.length==0){
			var moneyclear = document.getElementById("moneyclear");
			money.focus();
			moneyclear.innerHTML="请输入促销活动赠送金额";
			return;
		}
		
		if(!checkNum(money.value)){
			var moneyclear = document.getElementById("moneyclear");
			money.focus();
			moneyclear.innerHTML="请输入正确的促销活动赠送金额";
			return;
		}
		
		var starttime = form.starttime;
		if(starttime.value.length==0){
			var timeclear = document.getElementById("timeclear");
			starttime.focus();
			timeclear.innerHTML="请输入促销活动开始时间";
			return;
		}
		
		var endtime = form.endtime;
		if(endtime.value.length==0){
			var timeclear = document.getElementById("timeclear");
			endtime.focus();
			timeclear.innerHTML="请输入促销活动结束时间";
			return;
		}
		
		
		
		var usablerange = form.usablerange;
		if(usablerange.value.length==0){
			var usablerangeclear = document.getElementById("usablerangeclear");
			usablerange.focus();
			usablerangeclear.innerHTML="请输入促销活动使用范围";
			return;
		}
		
		if(!checkNum(usablerange.value)){
			var usablerangeclear = document.getElementById("usablerangeclear");
			usablerange.focus();
			usablerangeclear.innerHTML="请输入正确的促销活动使用范围";
			return;
		}
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("moneyclear").innerHTML="";
		document.getElementById("timeclear").innerHTML="";
		document.getElementById("usablerangeclear").innerHTML="";
	}

</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li class="cur"><a href="${BasePath}/zj/getSalespromotion.kq">促销活动</a></li>
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="${BasePath}/zj/addSalespromotion.kq" method="post" class="r_con_form">
    <input name="id" type="hidden" value="<#if salespromotion??>${salespromotion.id}</#if>"/>
    <div class="rows">
        <label>促销活动名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" placeholder="促销活动名称" onKeyUp="javascript:clearError();" value="<#if salespromotion??>${salespromotion.name?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" notnull>
	<div id="nameclear" style="color:#F00;"></div>
	</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>赠送金额 <span class="fc_red">*</span></label>
        <span class="input"><input name="money" placeholder="赠送金额" onKeyUp="javascript:clearError();" value="<#if salespromotion??>${salespromotion.money?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
        <div id="moneyclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>有效期 <span class="fc_red">*</span></label>
        <span class="input">
        	<input name="starttime" placeholder="开始时间" onChange="javascript:clearError();" value="<#if salespromotion??>${salespromotion.starttime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();" readonly notnull>
        	至
        	<input name="endtime" placeholder="结束时间"  onChange="javascript:clearError();" value="<#if salespromotion??>${salespromotion.endtime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();" readonly notnull>
        <div id="timeclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>使用范围 <span class="fc_red">*</span></label>
        <span class="input">
        	充值<input name="usablerange" placeholder="促销活动使用范围" onKeyUp="javascript:clearError();" value="<#if zhaopin??>${zhaopin.pay?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull>可送
        <div id="usablerangeclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="<#if type?? && type=='mod'>修改<#else>立即生成</#if>保存" />
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