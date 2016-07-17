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
<script src="${BasePath}/js/app/zjmall/TouchSlide.1.1.js"></script>
</head>
	<body>
<div class="screen_wrap">
<header>
<h1 style=" float: left;margin-top: 6px;">
<a href="${(mconf.url)?default("")}">
<img src="${BasePath}/${(navlis[0].setkey)?default('images/logo.gif')}" width="107px" alt="logo"></a></h1>
<div class="sitebar">
<!--a class="search jswapdialog">
<img src="${BasePath}/images/app/zjmall/touch/ico-srch.png" width="15" alt="搜索"></a-->
<a  class="shopcart" href="${BasePath}/zjmall/tocart.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">
<img src="${BasePath}/images/app/zjmall/touch/ico-shopcart.png" width="16" alt="收藏车"></a>
<a  class="my" href="${BasePath}/zj/zjminweb/getMember.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">
<img src="${BasePath}/images/app/zjmall/touch/ico-person.png" width="16" alt="服务"></a>
</div>
</header>
	<!----  滑动广告   begin -->
		<section class="focus" id="focus">
				<div class="hd">
					<ul></ul>
				</div>
				<div class="bd">
					<ul>
							<li><a href="${(navlis[1].setvalue)?default('')}"><img   _src="${BasePath}/${(navlis[1].setkey)?default('images/skin/1/bdgg1.jpg')}" src="${BasePath}/images/skin/blank.png" /></a></li>
							<li><a href="${(navlis[2].setvalue)?default('')}"><img   _src="${BasePath}/${(navlis[2].setkey)?default('images/skin/1/bdgg2.jpg')}" src="${BasePath}/images/skin/blank.png"/></a></li>
							<li><a href="${(navlis[3].setvalue)?default('')}"><img   _src="${BasePath}/${(navlis[3].setkey)?default('images/skin/1/bdgg1.jpg')}"  src="${BasePath}/images/skin/blank.png"/></a></li>
					</ul>
				</div>
		</section>		
		<!-- 滑动广告  end -->
		<nav>
		<ul class="clearfix">
			<li><a href="${(navlis[4].setvalue)?default('')}&openid=${openid?default('')}"><img   src="${BasePath}/images/app/zjmall/touch/icosy1.png" width="40" alt=""><p id="settxt4">${(navlis[4].setkey)?default('特惠')}</p></a></li>
			<li><a href="${(navlis[5].setvalue)?default('')}&openid=${openid?default('')}"><img  src="${BasePath}/images/app/zjmall/touch/icosy2.png" width="40" alt=""><p id="settxt5">${(navlis[5].setkey)?default('新品')}</p></a></li>
			<li><a href="${(navlis[6].setvalue)?default('')}&openid=${openid?default('')}"><img src="${BasePath}/images/app/zjmall/touch/icosy3.png" width="40" alt=""><p id="settxt6">${(navlis[6].setkey)?default('秒杀')}</p></a></li>
			<li><a href="${(navlis[7].setvalue)?default('')}&openid=${openid?default('')}"><img  src="${BasePath}/images/app/zjmall/touch/icosy4.png" width="40" alt=""><p id="settxt7">${(navlis[7].setkey)?default('推荐')}</p></a></li>
			<li><a href="${BasePath}/zjmall/mlist.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}&qtype=0"><img src="${BasePath}/images/app/zjmall/touch/ico-cat3.png" width="40" alt=""><p>特卖    </p></a></li>
			<li><a href="${BasePath}/zjmall/mlist.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}&qtype=0"><img src="${BasePath}/images/app/zjmall/touch/ico-cat4.png" width="40" alt=""><p>TOP    </p></a></li>
			<li><a href="${BasePath}/zjmall/myOrder.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}"><img src="${BasePath}/images/app/zjmall/touch/ico-cat8.png" width="40" alt=""><p>订单    </p></a></li>
			<li><a href="${BasePath}/zjmall/tocart.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}"><img src="${BasePath}/images/app/zjmall/touch/ico-cat7.png" width="40" alt=""><p>购物车</p></a></li>
		</ul>
		</nav>
<!--                            ----------------------                            -->
	<div class="module">
		<div id ="hdalex" class="hd clearfix">
			<a href="${BasePath}/zjmall/mlist.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}&qtype=" class="clearfix">
				<h2>新品上架</h2>
				<span>More &gt;</span>
			</a>
		</div>
		<div class="bd">
			<ul id="ulalex" class="pro_img_lst clearfix">
			<#if pageFinder?? && (pageFinder.data)?? >
			  		<#list pageFinder.result as item>	
			<li class="lialex" >
						<a href="${BasePath}/zjmall/show.kq?bid=${mconf.bizid}&openid=${openid}&id=${item.id}">
							<span class="imgwrap">
							<img width="74" alt="${item.ptitle}" src="${BasePath}/${item.imgpath}">
							</span>
							<span class="tt">${item.ptitle}</span>
							<span class="price">
									特惠价:¥${item.pric}
							</span>
						</a>
				</li>
				</#list>				  	
			  	<#else>
					<img src="${BasePath}/images/app/zjmall/touch/ico-shopcart-108.png" width="54" alt="" />
					<p>还没有商品哦...</p>
				</#if> 
					
			</ul>
		</div>
	</div>

<#include "mweb-footer.ftl">
</div>
<script type="text/javascript">
window.addEventListener("orientationchange", function() {
// 横竖屏切换
document.location.reload();
}, false);

	TouchSlide({ 
		slideCell:"#focus",
		titCell:".hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
		mainCell:".bd ul", 
		effect:"left", 
		autoPlay:true,//自动播放
		autoPage:true, //自动分页
		switchLoad:"_src" //切换加载，真实图片路径为"_src" 
	});
</script>
</body>
</html>