<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript" src="${BasePath}/js/common/historyperpage.js"></script>
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
	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var money = form.money;
		if(money.value.length==0){
			var moneyclear = document.getElementById("moneyclear");
			money.focus();
			moneyclear.innerHTML="请输入消费金额";
			return;
		}
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("moneyclear").innerHTML="";
	}

</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">

<#if !type?? >
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<#if salesman?? && salesman=='1'>
		<li class="cur"><a href="${BasePath}/zj/getMember.kq?salesman=1">消费记录管理</a></li>
		    
	<#else>
	
	
	</#if>
	
   </ul>
</div>
</#if>

<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="<#if type?? && type=='mod'>${BasePath}/zj/updateConsumption.kq?id=${consumption.id}<#else>${BasePath}/zj/addConsumption.kq</#if>" method="post" class="r_con_form">
    
    <script>document.write("<input type='hidden' name='parentSourcePage' value='"+getThickBoxUrl()+"'/>");</script>
    
    <input name="id" type="hidden" value="<#if consumption??>${consumption.id}</#if>"/>
    <input name="memberid" type="hidden" value="<#if member??>${member.id}</#if>"/>
    <input name="salesman" type="hidden" value="1"/>
    <div class="rows">
        <label>会员名称 <span class="fc_red">*</span></label>
        <span class="input">
			<#if member?? && member.name??>
				${member.name}
			<#else>
				--
			</#if>
		</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>消费金额 <span class="fc_red">*</span></label>
        <span class="input">
			<input name="money" value="<#if consumption??>${consumption.money?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
		<div id="moneyclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>消费项目 <span class="fc_red"></span></label>
        <span class="input">
        	<textarea name="reasons"><#if consumption??>${consumption.reasons?default("")}</#if></textarea>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="<#if type?? && type=='mod'>修改<#else>录入</#if>消费记录" />
        <a href="javascript:history.go(-1); " class="btn_gray">返回</a></span>
        <div class="clear"></div>
    </div>
    <script language="javascript">
		if("oklab"=="${oklab?default('')}")
		{
				alert("提交成功！")
				
		window.location.href='/zj/getMember.kq';
		}
    </script>
   </form>
</div>

</body>
</html>