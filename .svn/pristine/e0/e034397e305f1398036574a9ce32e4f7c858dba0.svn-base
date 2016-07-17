<html><head>
<meta charset="utf-8">

<link rel="stylesheet" href="${BasePath}/css/mc.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/main.js"></script>

<title>会员卡</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
</head>
<body onselectstart="return true;" ondragstart="return false;">
	
	
	
	<div class="container my">
	
	
	
	
	
		<header>
			<div class="header">
				<a class="setting">&nbsp;</a>
				<div>
					<ul class="tbox">
						<li><span id="upload_header"> <img src="${BasePath}/images/4.png">
						</span></li>
						<li>
							<h3><#if member??>${member.name?default("")}<#else>花儿精品店</#if></h3>
							<p>
								<sban>&nbsp;</sban><#if memberlevel??>${memberlevel.name?default("")}<#else>普通会员</#if>
							</p>
						</li>
					</ul>
				</div>
				<div>
					<ul class="box">
						<li><a href="${BasePath}/zj/zjminweb/my/getCouponList.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&type=0&openid=<#if openid??>${openid?default("")}</#if>">
								<label>优惠券</label> 
								<span>
								<#if couponrecordlist?? && (couponrecordlist?size>0)>${(couponrecordlist?size)?default(0)}<#else>0</#if>
								</span>
						</a></li>
						<!--<li><a href="#">
								<label>代金券</label> <span>0</span>
						</a></li>-->
						<li><a href="${BasePath}/zj/zjminweb/getIntegral.kq?memberid=<#if member??>${member.id?default("")}</#if>&openid=${openid?default("")}&bid=${bid?default("")}">
								<label>积分</label> <span><#if member??>${member.integral?default("0")}<#else>0</#if></span>
						</a></li>
						<li><a href="${BasePath}/zj/zjminweb/getConsumption.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>">
								<label>余额</label> <span><#if member??>${member.balance?default("0")}<#else>0</#if></span>
						</a></li>
					</ul>
				</div>
			</div>
		</header>
		<div class="body">
			<ul class="list_ul">
				<div>
					<li class="li_s"><a href="${BasePath}/zj/zjminweb/my/getCouponList.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&type=0&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>我的优惠券<span>&nbsp;</span></label></a></li>
					<li class="li_u"><a href="${BasePath}/zj/zjminweb/getIntegralexchangerecord.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>&isuse=0"><label class="label"><i>&nbsp;</i>我的礼品券<span>&nbsp;</span></label></a></li>
					<li class="li_x"><a href="${BasePath}/zj/zjminweb/getIntegralexchange.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>我的活动<span>&nbsp;</span></label></a></li>
					<li class="li_v"><a href="${BasePath}/zj/zjminweb/getConsumption.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>我的账单<span>&nbsp;</span></label></a></li>
					<li class="li_t"><a href="${BasePath}/zjmall/myOrder.kq?openid=<#if openid??>${openid?default("")}</#if>&bid=<#if bid??>${bid?default("")}</#if>"><label class="label"><i>&nbsp;</i>我的订单<span>&nbsp;</span></label></a></li>
				</div>
			</ul>
		</div>
		






<style>
footer .nav li.myli>a.on>p, footer .nav li.myli>a.active>p {
	background-position-y: -40px;
}
</style>






<!--
<a href="http://kf.weijuju.com/mobile/crm/chat.jsp?openid=ozdP9jkM7FWtT83sFd87jvt1V0eM&amp;wuid=389" id="CustomerChatFloat" style="position: fixed; right: 0px; top: 150px; z-index: 99999; height: 70px; width: 65px; min-width: 65px; background-image: url(http://wxj.weixinjia.net/crm/image/mobileChatFloat.png); background-size: 65px; background-position: 0px 0px; background-repeat: no-repeat no-repeat;"></a>
-->
<script type="text/javascript">
	var customerChatFloat=document.getElementById('CustomerChatFloat');
	var initX,initY;
	customerChatFloat.addEventListener("touchstart", function (event) {
        initX=event.targetTouches[0].pageX;
        initY=event.targetTouches[0].pageY;
    }, false);
	customerChatFloat.addEventListener("touchmove", function (event) {
		event.preventDefault();
		customerChatFloat.style.top=parseInt(customerChatFloat.style.top)+(event.targetTouches[0].pageY-initY)+'px';
		customerChatFloat.style.right=parseInt(customerChatFloat.style.right)-(event.targetTouches[0].pageX-initX)+'px';
		initX=event.targetTouches[0].pageX;
        initY=event.targetTouches[0].pageY;
    }, false);
	customerChatFloat.addEventListener("touchend", function (event) {
        initX=null;
        initY=null;
    }, false);
</script>



<footer>
	<nav class="nav">
		<ul class="box">
			<li><a href="${BasePath}/zj/zjminweb/getMember.kq?openid=<#if openid??>${openid?default("")}</#if>&bid=<#if bid??>${bid?default("")}</#if>">
					<p class="card"></p> <span>会员卡</span>
			</a></li>
			<li class="myli"><a href="${BasePath}/zj/zjminweb/enterMyspace.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>" class="my  on">
					<p class="my"></p> <span>我的</span>
			</a></li>
			<li><a href="${BasePath}/zj/zjminweb/getIntegralexchange.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>">
					<p class="share"></p> <span>兑换</span>
			</a></li>
		</ul>
	</nav>
</footer>
<script>
$(function(){
	
	var url=location.href;
	if(url.indexOf('/cardMain')!=-1 || url.indexOf('/cardGetPreferential')!=-1 || url.indexOf('/cardApplyInfo2')!=-1){
		$('.nav .box li:eq(0) a').addClass('on');
	}else if(url.indexOf('/cardChange')!=-1){
		$('.nav .box li:eq(1) a').addClass('on');
	}else if(url.indexOf('/cardProfile')!=-1){
		$('.nav .box li:eq(2) a').addClass('on');
	}else if(url.indexOf('/cardSign')!=-1){
		$('.nav .box li:eq(3) a').addClass('on');
	}else if(url.indexOf('/cardMessage')!=-1){
		$('.nav .box li:eq(4) a').addClass('on');
	}
	
})
</script>

	</div>
	<div mark="stat_code" style="width: 0px; height: 0px; display: none;">
	</div>





</body></html>