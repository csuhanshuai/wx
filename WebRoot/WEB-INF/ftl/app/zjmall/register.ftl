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
		<a href="javascript:history.go(-1);"><img src="${BasePath}/images/qxmall/touch/ico-back.png" width="18" alt="" /></a>
	</div>
	<h2 class="title" id="tit">注册</h2>
	<div class="sitebar">
	<a href="${BasePath}/qxmall/tologin.kq?bid=${mconf.bizid}">登录</a>
	</div>
</header>

	<section id="register" class="loginarea">
		<form method="post" action="${BasePath}/qxmall/register.kq">
			<label>
				账户名：
				<input type="text" placeholder="请输入注册的邮箱或手机号" id="username" value="" name="username" class="inptxt jusername">	
			</label>
			<p class="formtip"><span class="corg">${(error)?default('')}</span></p>
			<label>
				密 码：
				<input type="password" maxlength="25" id="password" name="password" class="inptxt">
			</label>
			<input type="hidden" id="bid" name="bid" value='${mconf.bizid}'/>
			<p class="formtip"></p>
			<div class="button_area">
				<input type="submit" value="提交注册" class="btn_org">
			</div>				
		</form>
	</section>
<#include "mweb-footer.ftl">
</div>
</body>
</html>