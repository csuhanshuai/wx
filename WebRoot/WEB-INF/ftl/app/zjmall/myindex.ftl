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
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/h5.css">
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
	<h2 class="title" id="tit">我的${mconf.mallname}</h2>
	<div class="sitebar">
	<!--a href="${BasePath}/zjmall/logout.kq">退出</a-->
	</div>
</header>
	<h2 class="shopcart_site_tt">${muser.name}：您好，欢迎光临${mconf.mallname}。</h2>
	<div class="module">
		<div class="hd clearfix">
			<h2>普通会员</h2>
			<span class="fr">累计积分：${muser.integral}积分</span>
		</div>
		<div class="bd">
			<div class="prowrdlst">
				<a class="go" href="myorderlist.sc">
					<span class="tt"><span class="corg">0笔</span>待付款订单</span>
				</a>
				<a class="go" href="/touch/my/listCommodityComments.sc">
					<span class="tt"><span class="corg">0件</span>待评论商品</span>
				</a>
				
			</div>			
		</div>
	</div>
	<nav>
		<ul class="clearfix">
			<li><a href="${BasePath}/zjmall/tomyorder.kq"><img width="40" alt="" src="${BasePath}/images/app/zjmall/touch/ico-cat8.png"><p>我的订单</p></a></li>
			<li><a href=""><img width="40" alt="" src="${BasePath}/images/app/zjmall/touch/ico-cat5.png"><p>物流查询</p></a></li>
			<li><a href=""><img width="37" alt="" src="${BasePath}/images/app/zjmall/touch/ico-review.png"><p>商品点评</p></a></li>
			<li><a href=""><img width="42" alt="" src="${BasePath}/images/app/zjmall/touch/ico-giftcard.png"><p>礼品卡</p></a></li>
			<li><a href=""><img width="35" alt="" src="${BasePath}/images/app/zjmall/touch/ico-coupon.png"><p>优惠券</p></a></li>
			<li><a href=""><img width="40" alt="" src="${BasePath}/images/app/zjmall/touch/ico-cat6.png"><p>收藏夹</p></a></li>
			<li><a href="${BasePath}/qxmall/topwd.kq"><img width="38" alt="" src="${BasePath}/images/app/zjmall/touch/ico-lock.png"><p>修改密码</p></a></li>
			<li><a href=""><img width="41" alt="" src="${BasePath}/images/app/zjmall/touch/ico-address-org.png"><p>收货地址</p></a></li>
			<li><a href=""><img width="40" alt="" src="${BasePath}/images/app/zjmall/touch/ico-integrate.png"><p>我的积分</p></a></li>
			
		</ul>
	</nav>
<#include "login-footer.ftl">
</div>
</body>
</html>