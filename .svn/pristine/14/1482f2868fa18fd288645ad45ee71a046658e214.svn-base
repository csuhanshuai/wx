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
<style>
.list_exchange li[data-card] figure img {
	width: 280px;
	height: 155px;
}

.list_exchange li[data-card] p {
	padding: 0px 11px;
}

.list_exchange li[data-card] .tbox p {
	padding: 0px;
}
.body .des {
	border-top: 1px dashed #dddddd;
	margin: 10px;
	padding: 10px;
	padding-bottom: 0;
}
.body section {
	height: 212px;
	overflow: hidden;
}
.body li[data-card].on section{
	height:auto;
}
</style>
</head>
<body onselectstart="return true;" ondragstart="return false;"><section id="dialoger"><div class="dialogCover"></div></section>

	

	<script>
	
	
		function exchange(id, point,type,memberid,bid) {
		
			confirm(
					'<label>扣除积分：<span>' + point + '</span></label>',
					function() {
						
						$.ajax({
							url: BasePath+"/zj/zjminweb/addIntegralexchangerecord.kq?id=" + id + "&memberid=" + memberid + "&bid=" + bid + "&type=" + type,
							type:"get",
							data:"",
							dataType:"json",
							success: function(result)
							{
								
								 response = eval(result);
								
				    		    if(response.result == 'success')
				    		    {
									if(type=='0')
									{
										alert('兑换成功，请到我的礼品券中查看',1500);
									}
									else if(type=='-1')
									{
										alert('兑换成功，请进入大转盘活动参与抽奖',1500);
									}
									else if(type=='2')
									{
										alert('兑换成功，请进入刮刮卡活动参与刮奖',1500);
									}
									else if(type=='3')
									{
										alert('兑换成功，请进入摇一摇活动参与摇奖',1500);
									}
									else
									{
										alert('兑换成功，请到我的优惠券中查看',1500);
									}
									//setTimeout('location.reload()',1500);
									
								}
				    		    else
				    		    {
				    		    	alert(response.message,2000);
				    		    }
								
								
							},
			    		    error: function(){
			    		    	alert('操作失败!');
			    		    }
						});
					});
		}
	</script>



	<div class="container exchange ">
		<div class="body">
			<ul class="list_exchange">



	<#if integralexchangelist?? && (integralexchangelist?size>0) >
	      	<#list integralexchangelist as item>
				
				<li data-card="" onclick="//this.classList.toggle('on');" style="height:315px">
				<header  style="height:59px">
						<ul class="tbox">
							<li>
								<h5>${item.name?default("")}</h5>
								<p>有效期至${item.validity?default("")}</p>
							</li>
						</ul>
					</header>
					<section style="height:212px">
						<div>
							<figure>
								
								<img src="
								
									<#if item.type?? && item.type=='1'>
										<#if item.imgurl??>
											${BasePath}/${item.imgurl?default("")}
										<#else>
											${BasePath}/images/app/zjminweb/youhuiquan.jpg
										</#if>
									<#elseif item.type=='-1' || item.type=='2' || item.type=='3'>
										${BasePath}/${item.imgurl?default("")}
									<#else>
										<#if item.imgurl??>
											${BasePath}/${item.imgurl?default("")}
										<#else>
											${BasePath}/images/app/zjminweb/lipinquan.jpg
										</#if>
									</#if>">
								
							</figure>
							<p>亲，请猛击【立即兑换】进入兑换活动页面，祝您好运哦！</p>
						</div>
					</section>
					
					<footer style="height:44px">
						<dl class="box">
							<dd>
								<label><big>${item.score?default("")}</big>积分</label>
							</dd>
							<dd>
								<a href="javascript:;" onclick="exchange('${item.id?default("")}','${item.score?default("")}','${item.type?default("")}','${memberid?default("")}','${bid?default("")}');">立即兑换</a>
							</dd>
						</dl>
					</footer>
				</li>
					
					
			</#list>
		<#else>
						<div class="tbox">暂无记录</div>
							
		
		</#if>
		
		
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
			<li><a href="${BasePath}/zj/zjminweb/getMember.kq?openid=<#if openid??>${openid?default("")}</#if>&bid=<#if bid??>${bid?default("")}</#if>" class="">
					<p class="card"></p> <span>会员卡</span>
			</a></li>
			<li class="myli"><a href="${BasePath}/zj/zjminweb/enterMyspace.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=${memberid?default("")}&openid=<#if openid??>${openid?default("")}</#if>" class="my ">
					<p class="my"></p> <span>我的</span>
			</a></li>
			<li><a href="${BasePath}/zj/zjminweb/getIntegralexchange.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>" class="on">
					<p class="share"></p> <span>兑换</span>
			</a></li>
		</ul>
	</nav>
</footer>
<script>
<script>
$(function(){
	
	var url=location.href;
	if(url.indexOf('/cardMain')!=-1 || url.indexOf('/cardGetPreferential')!=-1 || url.indexOf('/cardApplyInfo2')!=-1){
		$('.nav .box li:eq(0) a').addClass('on');
	}else if(url.indexOf('/cardChange')!=-1){
		$('.nav .box li:eq(1) a').addClass('on');
	}else if(url.indexOf('/getIntegralexchange')!=-1){
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