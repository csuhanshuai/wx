<html><head>
<meta charset="utf-8">

<link rel="stylesheet" href="${BasePath}/css/mc.css">
<link rel="stylesheet" href="${BasePath}/css/dialog.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dialog_min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/main.js"></script>

<title>会员卡</title>
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
	
</script>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<style type="text/css">
.list_coupon div>div {
	vertical-align: middle;
}

.list_coupon div img,.list_coupon div img {
	width: 210px;
	height: 110px;
}

.list_coupon div label {
	display: block;
	font-size: 18px;
	color: #ffffff;
	text-align: center;
	position: relative;
}

.list_coupon div label::after {
	content: "";
	position: absolute;
	display: inline-block;
	border: 6px solid #5ac5d4;
	border-color: transparent #5ac5d4 transparent transparent;
	left: -12px;
	top: 50%;
	margin-top: -6px;
}
</style>
</head>
<body onselectstart="return true;" ondragstart="return false;">

	
	<div class="container coupon">
		<div class="body">
			<ul class="list_coupon" style="padding-top: 10px;">
				<ol>
				
				
					
	<#if membernoticelist?? && (membernoticelist?size>0) >
	      	<#list membernoticelist as item>
	      	
	      		
					
					<li data-card=""><a class="toggle" href="javascript:;" onclick="try{this.classList.toggle('toggle')}catch(e){$(this).toggleClass('toggle');}"> <header>
								<label class="listItemLabel">${item.name?default("")}</label>
								
							</header>
							<section>
								<div>
									${item.description?default("")}
								</div>
								<div class="des">
									<dl>
										<dt  class="on">发布日期  ${item.intime?default("")}
										</dt>
									</dl>
								</div>
							</section>
					</a>
					</li>
					

			</#list>
		<#else>
						<div class="tbox">暂无记录</div>
							
		
		</#if>
					
					
					
				</ol>
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

<#if member??>

<footer>
	<nav class="nav">
		<ul class="box">
			<li><a href="${BasePath}/zj/zjminweb/getMember.kq?openid=<#if openid??>${openid?default("")}</#if>&bid=<#if bid??>${bid?default("")}</#if>" class="on">
					<p class="card"></p> <span>会员卡</span>
			</a></li>
			<li class="myli"><a href="${BasePath}/zj/zjminweb/enterMyspace.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=${memberid?default("")}&openid=<#if openid??>${openid?default("")}</#if>" class="my ">
					<p class="my"></p> <span>我的</span>
			</a></li>
			<li><a href="${BasePath}/zj/zjminweb/getIntegralexchange.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if memberid??>${memberid?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>">
					<p class="share"></p> <span>兑换</span>
			</a></li>
		</ul>
	</nav>
</footer>
</#if>
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