<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<script LANGUAGE="Javascript" SRC="${BasePath}/js/ckeditor/ckeditor.js"></script>
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
			nameclear.innerHTML="请输入微签到名称";
			return;
		}
		
		
		var url = form.url;
		if(url.value.length==0){
			var urlclear = document.getElementById("urlclear");
			url.focus();
			urlclear.innerHTML="请输入微签到内容URL";
			return;
		}
		
		
		var description = CKEDITOR.instances.description;
		
		if(description.getData().length==0){
			var descriptionclear = document.getElementById("descriptionclear");
			description.focus();
			descriptionclear.innerHTML="请输入岗位描述信息";
			return;
		}
		
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("urlclear").innerHTML="";
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
	<li class="cur"><a href="${BasePath}/zj/getSignin.kq">微签到</a></li>
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="${BasePath}/zj/addSignin.kq" method="post" class="r_con_form">
    <#if signin??><input name="id" type="hidden" value="${signin.id}"/></#if>
    <div class="rows">
        <label>微签到名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" placeholder="微签到名称" onKeyUp="javascript:clearError();" value="<#if signin??>${signin.name?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" notnull>
	<div id="nameclear" style="color:#F00;"></div>
	</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>内容URL <span class="fc_red">*</span></label>
        <span class="input"><input name="url" placeholder="内容URL" onKeyUp="javascript:clearError();" value="<#if signin??>${signin.url?default("")}<#else>${BasePath}/zj/zjminweb/addSigninrecordForward.kq?bid=${bid?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
         <span style="font-size:12px;color:#888;">此处"默认值"不建议修改</span>
        <div id="urlclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>描述信息 <span class="fc_red">*</span></label>
        <span class="input">
        	<textarea name="description" onKeyUp="javascript:clearError();" placeholder="描述信息"><#if signin??>${signin.description?default("")}</#if></textarea>
        <div id="descriptionclear" style="color:#F00;"></div>
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