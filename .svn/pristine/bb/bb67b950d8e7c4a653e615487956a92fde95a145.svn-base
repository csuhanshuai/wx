<!doctype html>
<html>
<head>
<#include "web-include.ftl">
<title>我的订单</title>
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
<script>
  function submit1(){
     var form = document.getElementById("cartlist");
     form.submit();
  }
</script>
</head>

<body>
<div class="screen_wrap">
<header>
	<div class="lftarea">
		<a href="javascript:history.go(-1);"><img src="${BasePath}/images/app/zjmall/touch/ico-back.png" width="18" alt="" /></a>
	</div>
	<h2 class="title" id="tit">我的订单</h2>
	<!--<div class="sitebar">
		<a href="#"  id="mainnav"><img src="${BasePath}/images/app/zjmall/touch/ico-menu.png" width="20" alt="menu" /></a>
	</div>-->
</header>

<!--主导航-->
<div class="navmenu" id="ygnavmenu">
	<i class="corner"></i>
	<h2>时尚商城</h2>
	<div class="bd">
		<ul>
			<li ><a href="/touch" class="item1">主页</a></li>
			<li ><a href="/touch/sell" class="item2">促销专区</a></li>
			<li ><a href="/touch/tehui" class="item3">今日特惠</a></li>
			<li ><a href="/touch/top100" class="item4">TOP 100</a></li>
			<li ><a href="/touch/xinpin" class="item5">每日新品</a></li>
			<li ><a href="/touch/brand" class="item6">品牌馆</a></li>
			<li ><a href="/touch/fenlei" class="item7">分类浏览</a></li>
			<li ><a href="/touch/my/myIndex.sc" class="item8">我的商城</a></li>
		</ul>
	</div>
</div>	
<!--主导航结束-->
 <!--购物车 start-->
 <form name="cartlist" id="cartlist" action="preOrder.kq" method="post">
 <input type="hidden" name="openid" value="${(openid)}">
<div class="shopcart">
		<!--<h2 class="shopcart_site_tt">我的订单</h2>-->
<#if (orderCount>0) >
<#assign fcount=0 />
<#list orderInfoList as orderInfo>
<#assign fcount=fcount+1 />


		
		    <!--商品列表 start-->
		<div class="module">

			<div class="pro_item ">
				<div class="title">
					订单号：${(orderInfo[0].id)}
					<div style="float:right;"><a class="clearfix" href="${BasePath}/zjmall/myOrderDetail.kq?orderId=${orderInfo[0].id}&openid=${openid}&bid=${bid}"><p>详情</p></a></div>
				</div>
				<div class="cnt clearfix">
					<div class="pro_img">
					    <#list orderInfo[1] as orderDetail>
						   <a href="show.kq?id=${orderDetail.pid}&bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}"><img src="${BasePath}/${orderDetail.imgPath}" width="70" alt="${orderDetail.ptitle}" /></a>
						</#list>
					</div>
				</div>
				<div class="title">
					<div style="margin-bottom:5px;">总额：<span style="color: #c73d00;">&yen;${orderInfo[0].totalMoney}</span>&nbsp;&nbsp(<#if (orderInfo[0].payType?default('')) == "1"> 余额支付<#elseif (orderInfo[0].payType?default('')) == "2">支付宝<#else>其它支付</#if>)
					<div style="float:right;">订单状态：<#if (orderInfo[0].status) == 0> 未支付<#elseif (orderInfo[0].status) == 1>已支付<#elseif (orderInfo[0].status) == 2>已发货<#elseif (orderInfo[0].status) == 3>已完成<#else>未知状态</#if></div>
					</div>
				</div>
			</div>
		</div>
	
</#list>
    <!--商品列表 end-->
<#else>
       <!--空购物车 start-->
	<section class="noresult shopcart_empty">
			<img src="${BasePath}/images/app/zjmall/touch/ico-shopcart-108.png" width="54" alt="" />
			<p>您暂时没有任何订单...</p>
		<div class="button_area">
			<!--<a href="${(mconf.url)?default('')}" class="btn_org">去逛逛</a>-->
			<!--a href="/touch/my/listMyFavorites.sc" class="btn_brown">查看收藏夹</a-->
		</div>			
	</section>	
    <!--空购物车 end-->
</#if>	
</div>	
</form>
     <!--购物车 end-->
<#include "login-footer.ftl">
</div>
</body>
</html>