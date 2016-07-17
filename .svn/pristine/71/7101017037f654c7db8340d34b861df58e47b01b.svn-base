<!doctype html>
<html>
<head>
<#include "web-include.ftl">
<title>${mconf.mallname}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="软小三,优质软件,绿色软件，高性价比，高实用软件">
<meta name="keywords" content="软小三，高效，实用">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable"> 
<meta content="black" name="apple-mobile-web-app-status-bar-style"> 
<meta content="telephone=no" name="format-detection">
<link rel="stylesheet" href="${BasePath}/css/qxmall/h5.css">
<style type="text/css">
	.pname{
		display: block;
		//width:92px;/*对宽度的定义,根据情况修改*/
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		//max-width:92px;   /*IE不能解释该属性，而FF可以*/
	}
	.pname:after{
		content:"...";
	}
</style>
</head>

<body>
<div class="screen_wrap">
<header>
	<div class="lftarea">
		<a href="javascript:history.go(-1);"><img src="${BasePath}/images/app/zjmall/touch/ico-back.png" width="18" alt="" /></a>
	</div>
	<h2 class="title" id="tit">修改密码</h2>
	<div class="sitebar">
	<!--a href="${BasePath}/zjmall/logout.kq">退出</a-->
	</div>
</header>

<section id="findpassword" class="loginarea">
		<form action="${BasePath}/zjmall/mpwd.kq" autocomplete="off" name="myform" method="post">
			<label>
				新密码：
				<input type="password" placeholder="请输入新密码 " id="pwcode" name="password" class="inptxt">
			</label>
			<p id="codeTips" class="formtip">
			</p>
			<div class="button_area">
			<a onclick="javascript:document.myform.submit();" href="javascript:void(0)" id="savenewpassword" class="btn_org">保存新密码</a>
			</div>				
		</form>
	</section>
<#include "login-footer.ftl">
</div>
</body>
</html>