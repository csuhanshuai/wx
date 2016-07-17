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
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/goods.css">
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
  
  function deleteCart(id){
		var ir = confirm('您确定从购物车中删除此商品？');
        if (ir == true)
        {
             location.href = '${BasePath}/zjmall/deleteOneCart.kq?id='+id +'&openid=${openid}&bid=${bid}';    
        }
	}
	
	function proNumOperate(type,index)
	{
		var obj = document.getElementById('shuliang'+index);
		
		var price = document.getElementById("amount");
		var danjia = document.getElementById('danjia'+index).innerHTML;
		
		var aaa = (price.innerHTML).replace(',','');
		
		var number = obj.value;
		
		var numberspan = document.getElementById('numberspan');
		
		if(type == '0' && parseInt(number) > 1)
		{
			var shuliang = parseInt(number)-1;
			obj.value = shuliang;
			
			//价格减
			price.innerHTML = parseInt(aaa) - parseInt(danjia);
			
			numberspan.innerHTML = parseInt(numberspan.innerHTML) - 1;
			
		}
		else if(type == '1')
		{
			var shuliang = parseInt(number)+1;
			obj.value = shuliang;
			
			//价格加
			price.innerHTML = parseInt(aaa) + parseInt(danjia);
			
			numberspan.innerHTML = parseInt(numberspan.innerHTML) + 1;
		}
	
	}
</script>
</head>

<body>
<div class="screen_wrap">
<header>
	<div class="lftarea">
		<a href="javascript:history.go(-1);"><img src="${BasePath}/images/app/zjmall/touch/ico-back.png" width="18" alt="" /></a>
	</div>
	<h2 class="title" id="tit">购物车(${cartcount}件)</h2>
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
 <input type="hidden" name="bid" value="${(bid)}">
<div class="shopcart">
		<!--<h2 class="shopcart_site_tt">${mconf.mallname}</h2>-->
<#if (cartcount>0) >
<#assign fcount=0 />
<#list cartlist as item>
<#assign fcount=fcount+1 />

   <input type="hidden" name="cartlistinfo[${item_index}].id" value="${(item[0].id)}">

		
		    <!--商品列表 start-->
		<div class="module">
			<!--div class="hd clearfix">
				<h2>		限时抢</h2>	<span>单品广告位</span>
			</div-->

			<div class="pro_item ">
				<div class="title">
					${(item[0].ptitle)}
					<div style="float:right;"><a class="clearfix" href="javascript:deleteCart('${item[2]}');"><p>删除</p></a></div>
				</div>
				<div class="cnt clearfix">
					<div class="pro_img">
						<i>限</i>
						<a href="show.kq?id=${item[0].id}&bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">
						<img src="${BasePath}/${item[0].imgpath}" width="120" alt="${(item[0].ptitle)}" /></a>
					</div>
					<div class="info">
						<p class="marketprice">市场价：<del>&yen;${(item[0].pric)}</del></p>
						<p>
						促销价：<span class="price">&yen;<span id="danjia${item_index}">${(item[0].opric)}</span></span>
						</p>
						<p class="other">
							<span>
							<a class="plut" href="javascript:proNumOperate('0','${item_index}');"><span>-</span></a>
							<input readonly id="shuliang${item_index}"  min="1" max="3" type="number" class="proNO" data="99897997002" type="text"  name="cartlistinfo[${item_index}].number" value="${(item[1])}"/> 件
							<a class="add" href="javascript:proNumOperate('1','${item_index}');"><span>+</span></a>
							</span>
						</p>
						<!--<p>本商品由<span class="corg">商家</span>直接发货</p>-->
						<p class="operat">
							<span pno="101010" flag="-1" class="addfav fav" data="99897997002" no="99897997"></span>
							<span pn="101010" class="delpro" data="99897997002"></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	
</#list>
<p class="tip clearfix">
		<span class="fl" id="downnum">数量：<span id="numberspan">${cartcount}</span>件</span>
		<span class="fr">总金额：（不含运费）<span class="price " >&yen;<span id="amount">${mpric}</span></span></span>
	</p>
	<div class="button_area">
		<a href="javascript:submit1();" class="btn_brown" style="color:#ff6699;">立即结算 </a> 
		<a href="${(mconf.url)?default('')}?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}" class="btn_brown" style="color:#ff6699;">继续购物</a>
	</div>
    <!--商品列表 end-->
<#else>
       <!--空购物车 start-->
	<section class="noresult shopcart_empty">
			<img src="${BasePath}/images/app/zjmall/touch/ico-shopcart-108.png" width="54" alt="" />
			<p>您的购物车还是空的...</p>
		<div class="button_area">
			<a href="${(mconf.url)?default('')}?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}" class="btn_org">去逛逛</a>
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