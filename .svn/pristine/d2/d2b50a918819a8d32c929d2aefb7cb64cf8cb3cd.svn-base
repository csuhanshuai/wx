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

	

	<script>
	
	
		$().ready(
				function() {
					$("#nav_1 a").on("touchstart touchend mouseover mouseout",
							function(e) {
								switch (e.type) {
								case "touchstart":
								case "mouseover":
									this.classList.add("hover");
									break;
								case "touchend":
								case "mouseout":
									this.classList.remove("hover");
									break;
								}
							});
					
				});

		function getCoupon(id, memberid, bid) {
			
			$.ajax({
						url : BasePath+"/zj/zjminweb/addCouponrecord.kq?id=" + id + "&memberid=" + memberid + "&bid=" + bid,
						type: "POST",
		    		    date: "",
		    		    datetype: "json",
		    		    async: false,
		    		    timeout: 1000,
						success: function(result){
		    		    var response = eval("(" +result+")" );
		    		    if(response.result == 'success'){
							
							alert('领取成功，请到我的优惠券中查看',1500);
							//setTimeout("self.location.reload()", 1500);
						}
		    		    else
		    		    {
		    		    	alert(response.message,1500);
		    		    }		
		    		    	
		    		    },
		    		    error: function(){
		    		    	alert('操作失败!');
		    		    }
	    		    
	    		    
					});
		}
	</script>
	<div class="container coupon">
		<header>
			<nav id="nav_1" class="p_10">
				<ul class="box">
					<li><a class="<#if isuse='0'>on</#if>" href="${BasePath}/zj/zjminweb/getIntegralexchangerecord.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=${memberid?default("")}&isuse=0&openid=<#if openid??>${openid?default("")}</#if>">未兑换</a></li>
					<li><a class="<#if isuse='1'>on</#if>" href="${BasePath}/zj/zjminweb/getIntegralexchangerecord.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=${memberid?default("")}&isuse=1&openid=<#if openid??>${openid?default("")}</#if>">已兑换</a></li>
				</ul>
			</nav>
		</header>
		<div class="body">
			<ul class="list_coupon">
				<ol>
				

				
				
				
		<#if integralexchangerecordlist?? && (integralexchangerecordlist?size>0) >
	      	<#list integralexchangerecordlist as item>
					
					<li data-card="">
					<a href="javascript:;" onclick="try{this.classList.toggle('toggle')}catch(e){$(this).toggleClass('toggle');}" class="toggle"> <header>
								<label class="listItemLabel"><#if item.type?? && item.type != ''>${item.activities.name?default("")}: ${item.gift.name?default("")}<#else>${item.integralexchange.name?default("")}</#if></label>
								<#if item.gift?? && item.gift.id != ''>
								<br />
								<label class="listItemLabel" style="font-size: 12px;">兑奖编码：${item.id?default("")}</label>
								</#if>
							</header>
							<section>
								<div>
								
									
									<div class="tbox" style="background: none repeat scroll 0 0 #E37176;height:110px">
										<div>
											<img src="<#if item.type?? && item.type != ''>
												<#if item.activities.photourl??>${BasePath}/${item.activities.photourl?default("")}<#else>${BasePath}/images/app/zjminweb/lipinquan.jpg</#if>
											<#else>
												<#if item.integralexchange.imgurl??>${BasePath}/${item.integralexchange.imgurl?default("")}<#else>${BasePath}/images/app/zjminweb/youhuiquan.jpg</#if>
											</#if>
											">
										</div>
										
											<div onclick="use(12,'凭此券全场九折优惠券（演示）','',true);event.stopPropagation();">
												<#if item.isuse?? && item.isuse == '0'>
													<a href="#"><label>还未<br>兑换</label></a>
												<#else>
													<a href="#"><label>已经<br>兑换</label></a>
												</#if>
											</div>
									</div>									
									
									
								</div>
								<div class="des">
									<dl>
										<#if !item.type?? || item.type == ''>
										<dt onclick="this.classList.toggle('on');event.stopPropagation();">兑换活动截止日期：${item.integralexchange.validity?string('yyyy-MM-dd')}
										</#if>
										</dt>
										<#if item.isuse?? && item.isuse == '0'>
										<dt>
											<p>请出示礼品券给商家服务人员<br></p>
										</dt>
										</#if>
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