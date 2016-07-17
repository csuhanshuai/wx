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

function checkTel(tel)
{
   var mobile = /^1[3|5|8]\d{9}$/ , phone = /^0\d{2,3}-?\d{7,8}$/;
   return mobile.test(tel) || phone.test(tel);
}

	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入门店名称";
			return;
		}
		
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
	}

</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">图文管理</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
	<li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<!--<div class="tips_info">
    岗位名称、基本要求（学历、截止时间、性别、年龄、工作地点、待遇）、岗位描述。<br />
</div>-->
<form id="zhaopin_form" action="${BasePath}/zj/addAlbum.kq" class="r_con_form" method="post">
    <div class="rows">
        <label>相册名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" value="" type="text" class="form_input" size="50" maxlength="18" placeholder="相册名称" onKeyUp="javascript:clearError();" notnull>
	<div id="nameclear" style="color:#F00;"></div>
	</span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>相册描述 <span class="fc_red"></span></label>
        <span class="input">
        	<textarea name="description" placeholder="相册描述"></textarea>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="提交保存" /><a href="javascript:history.go(-1); " class="btn_gray">返回</a></span>
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