
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>猜灯谜登录</title>
    
    <meta charset="utf-8" />

	<meta content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport" />
	
	<meta content="yes" name="apple-mobile-web-app-capable" />
	
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	
	<meta content="telephone=yes" name="format-detection" />
	
	<meta content="email=no" name="format-detection" />
	
	<link href="../css/public.css" rel="stylesheet">

	<link href="../css/login.css" rel="stylesheet">
	
	
	
	<script src="../js/jquery.js" type="text/javascript" ></script>
	
	<script src="../js/common_.js" type="text/javascript" ></script>
	

    
  </head>
  
  <body id="body">

	<div class="fullscreen per_login">
	
	
	
	<div class="alert"></div>
	
		
	
	<header class="header">
	
		<div class="header_bar">
	
	         <div class="per_login" id="per_login">
	
			     <div class="account">
	
	                 <div class="per_name">
	
	
	                     <i class="arrowIcon"></i>                 </div>
	             </div>
	
	         </div>
	    </div>
	
	</header>
	
	
	
	<div class="operate_Bar1 clearfix">
	
		<div class="text">企业员工登录</div>
	
	</div>
	
	
	
	<section class="inner_content">
	
	    <form id="loginform" name="loginform" action="${BasePath}/lanterngame/checkLogin.kq" method="post">
	
	    <li class="username"><input type="text" name="empNum" placeholder="工号" id="empNum" value="" /></li>
	
		<li class="pwd"><input type="text" name="empName" placeholder="姓名" id="login_pwd" value="" /></li>
	
		<!--<li class="login_free">
	
	        <div><input type="checkbox" value="ok" name="m.zidong" id="login_auto" checked="checked" /><label for="login_auto">记住登录</label></div>
	
	    </li>-->
	    <br><br>
	
		<li class="submit_btn"><button type="submit" id="login_btn">登 录</button></li>
	
	    </form>
	
	</section>
	
	</div>
	
	</body>
</html>