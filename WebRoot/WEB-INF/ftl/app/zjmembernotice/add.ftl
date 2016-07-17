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
	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入会员公告名称";
			return;
		}
		
		
		var description = CKEDITOR.instances.description;
		
		if(description.getData().length==0){
			var descriptionclear = document.getElementById("descriptionclear");
			description.focus();
			descriptionclear.innerHTML="请输入公告描述信息";
			return;
		}
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
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
    <li><a href="${BasePath}/zj/getMembercard.kq">卡片管理</a></li>
				<li><a href="${BasePath}/zj/getMember.kq">会员管理</a></li>
				<li><a href="${BasePath}/zj/getIntegralrule.kq">积分规则</a></li>
				<li><a href="${BasePath}/zj/getMemberlevel.kq">等级管理</a></li>
				<li class="cur"><a href="${BasePath}/zj/getMembernotice.kq">公告管理</a></li>
	
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<!--<div class="tips_info">
    岗位名称、基本要求（学历、截止时间、性别、年龄、工作地点、待遇）、岗位描述。<br />
</div>-->
<form id="zhaopin_form" action="${BasePath}/zj/addMembernotice.kq" class="r_con_form" method="post">
    <div class="rows">
        <label>公告名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" value="" type="text" placeholder="公告名称" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
	<div id="nameclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>公告内容 <span class="fc_red">*</span></label>
        <span class="input">
        	<!--<input name="description" value="" type="text" class="form_input" size="50" maxlength="32" notnull>-->
        	<textarea name="description" onKeyUp="javascript:clearError();" placeholder="公告内容描述"></textarea>
        	<div id="descriptionclear" style="color:#F00;"></div>
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