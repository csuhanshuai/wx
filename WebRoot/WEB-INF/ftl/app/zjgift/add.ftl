<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>

<script LANGUAGE="Javascript" SRC="${BasePath}/js/ckeditor/ckeditor.js"></script>

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
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入礼品名称";
			return;
		}
		
		var number = form.number;
		if(number.value.length==0){
			var numberclear = document.getElementById("numberclear");
			number.focus();
			numberclear.innerHTML="请输入礼品数量";
			return;
		}
		
		if(!checkNum(number.value)){
			var numberclear = document.getElementById("numberclear");
			number.focus();
			numberclear.innerHTML="请输入正确的礼品数量";
			return;
		}
		
		var description = CKEDITOR.instances.description;
		
		if(description.getData().length==0){
			var descriptionclear = document.getElementById("descriptionclear");
			description.focus();
			descriptionclear.innerHTML="请输入礼品描述信息";
			return;
		}
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("numberclear").innerHTML="";
		document.getElementById("descriptionclear").innerHTML="";
	}

</script>
<script type="text/javascript">
	window.onload = function() {
		CKEDITOR.replace('description');
	};
</script>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li class="cur"><a href="${BasePath}/zj/getGift.kq">礼品管理</a></li>
	
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="<#if type?? && type=='mod'>${BasePath}/zj/updateGift.kq<#else>${BasePath}/zj/addGift.kq</#if>" class="r_con_form" method="post">
    <#if gift?? && type?? && type=='mod'>
    <input name="id" type="hidden" value="${gift.id}"/>
    </#if>
    <div class="rows">
        <label>礼品名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" value="<#if gift??>${gift.name?default("")}</#if>" type="text" placeholder="礼品名称" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
	<div id="nameclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>礼品数量 <span class="fc_red">*</span></label>
        <span class="input"><input name="number" value="<#if gift??>${gift.number?default(0)}</#if>" type="text" placeholder="礼品数量" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="numberclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>描述信息 <span class="fc_red">*</span></label>
        <span class="input">
        	<textarea name="description" onKeyUp="javascript:clearError();" placeholder="描述信息"><#if gift??>${gift.description?default("")}</#if></textarea>
        	<div id="descriptionclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="<#if type?? && type=='mod'>修改<#else>提交</#if>保存" />
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