<html><head>
<meta charset="utf-8">
<link rel="stylesheet" href="${BasePath}/css/mc.css">
<script type="text/javascript" src="${BasePath}/js/app/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/main.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dialog_min.js"></script>
<title>会员卡</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
</head>
<body onselectstart="return true;" ondragstart="return false;">

	

	<script>
		// 	$().ready(function(){
		//
		// });
	</script>
	<div class="container integral integral_record integral_my coupon">
		<header>
			<nav id="nav_1" class="p_10">
				<ul class="box">
					<li><a href="${BasePath}/zj/zjminweb/getIntegral.kq?memberid=${memberid?default("")}&openid=${openid?default("")}&bid=${bid?default("")}" class="<#if !type??>on</#if>">全部</a></li>
					<li><a href="${BasePath}/zj/zjminweb/getIntegral.kq?memberid=${memberid?default("")}&type=0&openid=${openid?default("")}&bid=${bid?default("")}" class="<#if type?? && type=='0'>on</#if>">获得</a></li>
					<li><a href="${BasePath}/zj/zjminweb/getIntegral.kq?memberid=${memberid?default("")}&type=1&openid=${openid?default("")}&bid=${bid?default("")}" class="<#if type?? && type=='1'>on</#if>">支出</a></li>
				</ul>
			</nav>
		</header>
		<div class="body">
			<section class="p_10">
				<table class="table_record">
					<thead>
						<tr>
							<td style="width: 30%;">积分详情</td>
							<td style="width: 50%;">日期</td>
							<td style="width: 20%;">积分</td>
						</tr>
					</thead>
					<tbody>

		<#if integrallist?? && (integrallist?size>0) >
	      	<#list integrallist as item>
						
						<tr>
							<td>${item.description?default("签到领取")}</td>
							<td>${item.intime?default("")}</td>
							
							<td>
								<#if item.type == '0'>
									+
								<#else>
									-
								</#if>
							    ${item.score?default("")}
							</td>
							
						</tr>
			</#list>
		<#else>
						<tr>


<div class="noData" style="background: url(${BasePath}/images/10.png) no-repeat center 50px;-webkit-background-size: 140px auto;"></div>

							
						</tr>
		
		</#if>
						
						
						

					</tbody>
				</table>
			</section>
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
			<li class="myli"><a href="${BasePath}/zj/zjminweb/enterMyspace.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if memberid??>${memberid?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>" class="my  on">
					<p class="my"></p> <span>我的</span>
			</a></li>
			<li><a href="${BasePath}/zj/zjminweb/getIntegralexchange.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if memberid??>${memberid?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>">
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