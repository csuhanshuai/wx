<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet" href="${BasePath}/css/mc.css">
<link rel="stylesheet" href="${BasePath}/css/dialog.css">
<script type="text/javascript" src="${BasePath}/js/app/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/mymain.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dialog_min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dater_min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/main.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/aSelect.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/aLocation.js"></script>

<title>会员卡</title>
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
	
</script>
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">

<style>
.list_ul>div:not (:last-of-type ){
	padding-bottom: 0px;
	background: none;
}
div.body{
	padding-top:0px; 
}
.list_ul>div:not(:last-of-type) {
	padding:0px;
	background:none;
	
}		
.group_btn li a span{
	display: block;
	line-height: 23px;
	text-align: center;
	color: #ffffff;
	font-size: 15px;
}
p.page-url{
	max-width: 640px;
	text-align: center;
	border-top: 1px solid rgb(178, 176, 176);
	margin-right: 10px;
	margin-left: 10px;
	margin-top: 17px;
	padding-top: 7px;
}
p.page-url a{
	color:gray;
	font-size:13px;
}
.logocontrol
{
position:absolute; 
width:75px; height:25px; 
line-height:45px; 
left:6px; 
top:6px;
text-align: left;
overflow:hidden; 
filter:alpha(opacity=70); -moz-opacity:0.7; -khtml-opacity:0.7; opacity:0.7;
display:black;}
.logocontrol img {width:75; height:23px;}
.cardtitle
{
position:absolute; 
width:125px; height:45px; 
line-height:25px; 
left:103px; 
top:5px;
overflow:hidden; 
display:black;
}
.ctitle{
font-weight:bolder;
color:<#if membercard??>${membercard.namecolor?default("#FFFFFF")}</#if>;
font-family:"黑体";
text-align:right;
}
.cardnumber
{
position:absolute; 
width:125px; height:45px; 
line-height:45px; 
left:100px; 
top:89px;
overflow:hidden; 
display:black;
}
.cnumber{
font-weight:bolder;
font-size:13px;
color:<#if membercard??>${membercard.numbercolor?default("#000000")}</#if>;
font-family:"黑体";
text-align:right;
}
</style>

</head>
<body onselectstart="return true;" ondragstart="return false;">


	
	<script type="text/javascript">
		function charge(memberid, score){
			loading(true);
			
			$.ajax({
				url: BasePath+"/zj/zjminweb/integral.kq?memberid=" + memberid + "&type=0&score=" + score,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var response = eval("(" +result+")" );
	    		    if(response.result == 'success'){
						loading(false);
						alert('签到成功',1500);
						var point=response.message;
						var $currPointsp=$('a#myPoint span').last();
						var currPoint=$currPointsp.html();
						currPoint=Number(currPoint)+Number(point);
						$currPointsp.html(currPoint);
						$('li#signButton').hide();
						$('li#signResult').show();
					}
	    		    else
	    		    {
	    		    	loading(false);
	    		    	alert(response.message,1500);
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
			});
			
			
			
			
		}
	</script>
	
	



<#if member??>


	<div class="container card">
		<header>
			<div class="header card">

				<div class="card " data-side="1" onclick="this.classList.toggle(&#39;on&#39;);">					
					<div class="back">
						<div class="fg" style="background-image: url(${BasePath}/images/app/zjmember/card_back.jpg);">
							<div class="backtag">
								<canvas data-bgcolor="#d90001" width="54" height="30"></canvas>
							</div>
						
							<div class="info">
								
								<p class="addr"><#if membercard??>${membercard.shopaddress?default("")}<#else>深圳福田本元大厦</#if></p>
								
									
								<p class="tel">
									<a class="autotel" href="tel:<#if membercard??>${membercard.shoptelephone?default("")}<#else>0755-88308939</#if>" onclick="event.stopPropagation();">
									<#if membercard??>${membercard.shoptelephone?default("")}<#else>0755-88308939</#if></a>
								</p>
								
							</div>
							<p class="keywords"><#if membercard??>${membercard.shopname?default("")}<#else>花儿精品店</#if></p>
						</div>
					</div>

			
					<div class="front">
						<div class="fg" style="background-image: url(<#if membercard??>${BasePath}/${membercard.bgurl?default("")}<#else>${BasePath}/images/app/zjmember/card_bg01.jpg</#if>);">
							<!--<img id="cardlogoimg"  style="margin-top: 39px;width:185px;height:65px;">-->
							<img src="${BasePath}/servlet/quickMarkServlet.kq?code=<#if member??>${member.cardno?default("")}</#if>" style="margin-top: 79px;margin-left: 20px;width:55px;height:55px;">	
							<img data-src="{###barcodeimg###}" style="display: none;">
							
							<div class="fc">	<span class="n" style="color: <#if membercard??>${membercard.numbercolor?default("")}<#else>#AAAAAA</#if>; text-shadow: rgb(0, 0, 0) 0px -1px;"><#if member??>${member.cardno?default("")}<#else>800001</#if></span>
							</div>
						</div>


							 <div class="logocontrol">
							<img  src="<#if membercard??>${BasePath}/${membercard.logourl?default("")}</#if>" id="setimg2" name="setimg2">
							 </div>
							 <div class="cardtitle">
								<div class="ctitle"><span class="cname" style="color: <#if membercard??>${membercard.namecolor?default("")}<#else>#957426</#if>;">
								<#if membercard??>${membercard.shopname?default("")}</#if></span></div>
						        </div>
						        <div class="cardnumber">
								<div class="cnumber">
								</div>
						        </div>

						
					</div>
				</div>


			</div>
			
			
			
			<div>
				<ul class="box group_btn">
					<input type="hidden" value="<#if signinflag??>${signinflag?default("1")}</#if>" id="signinflag">
					<li><a id="myPoint" href="${BasePath}/zj/zjminweb/getIntegral.kq?memberid=${memberid?default("")}&openid=${openid?default("")}&bid=${bid?default("")}"><span>我的积分</span><span><#if member??>${member.integral?default("")}<#else>0</#if></span></a></li>		
					<li id="signButton"><a href="javascript:charge('<#if member??>${member.id?default("")}</#if>','10');"><span>签到即送</span><span>10</span></a></li>
					<li id="signResult" style="padding-top: 12px;display:none;"><a><img src="${BasePath}/images/app/zjmember/signed.png" width="20px" height="20px" style="vertical-align: -4px;margin-right:2px;">已签到</a></li>
				</ul>
			</div>
		</header>
		<div class="body">
			<ul class="list_ul">
				<div>
					<li class="li_a"><a href="${BasePath}/zj/zjminweb/getMembernotice.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>会员公告 <span>&nbsp;</span></label></a></li>
					<li class="li_b"><a href="${BasePath}/zj/zjminweb/getCouponList.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>领取优惠券<span>&nbsp;</span></label></a></li>
					<li class="li_c"><a href="${BasePath}/zj/zjminweb/getIntegralexchange.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>积分兑换<span>&nbsp;</span></label></a></li>
					<li class="li_d"><a href="${BasePath}/zj/zjminweb/updateMemberInfoForward.kq?id=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>&type=mod&bid=${bid?default("")}"><label class="label"><i>&nbsp;</i>完善会员卡资料 <span>&nbsp;</span></label></a></li>
				</div>
				<div>
						
					<li class="li_i"><a class="label" href="tel:<#if membercard??>${membercard.shoptelephone?default("")}<#else>0755-88308939</#if>"><i>&nbsp;</i>
					<#if membercard??>${membercard.shoptelephone?default("")}<#else>0755-88308939</#if>
							<span>&nbsp;</span></a></li>
					
						
					<li class="li_j"><a href="http://api.map.baidu.com/marker?location=<#if membercard??>${membercard.latitude?default('22.545331')}</#if>,<#if membercard??>${membercard.longitude?default('113.952072')}</#if>&amp;title=<#if membercard??>${membercard.shopname?default("")}</#if>&amp;content=<#if membercard??>${membercard.shopname?default("")}</#if>&amp;output=html">
							<label class="label"><i>&nbsp;</i>
							<#if membercard??>${membercard.shopaddress?default("")}<#else>深圳福田本元大厦</#if>
							 <span>&nbsp;</span></label>
					</a></li>
					
				</div>
			</ul>
			

<!--
<p class="page-url"><a href="http://www.weijuju.com/" target="_blank" class="page-url-link">此功能由“微俱聚”平台提供</a></p>
-->



		</div>
		
	
<style>
footer .nav li.myli>a.on>p, footer .nav li.myli>a.active>p {
	background-position-y: -40px;
}
</style>


<!--
<a href="http://kf.weijuju.com/mobile/crm/chat.jsp?openid=ozdP9jkM7FWtT83sFd87jvt1V0eM&amp;wuid=389" id="CustomerChatFloat" style="position: fixed; right: 0px; top: 150px; z-index: 99999; height: 70px; width: 65px; min-width: 65px; background-image: url(http://wxj.weixinjia.net/crm/image/mobileChatFloat.png); background-size: 65px; background-position: 0px 0px; background-repeat: no-repeat no-repeat;"></a>-->
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
			<li class="myli"><a href="${BasePath}/zj/zjminweb/enterMyspace.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>" class="my ">
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
	
	
	
	
	
<#else>	
	
	
	<div class="container get card">
			<header>
				<div class="header card">
					<div class="card " data-side="1">
					
						<div class="front">
						<div class="fg" style="background-image: url(<#if membercard??>${BasePath}/${membercard.bgurl?default("")}<#else>${BasePath}/images/app/zjmember/card_bg01.jpg</#if>);">
							<!--<img id="cardlogoimg"  style="margin-top: 39px;width:185px;height:65px;">-->
								
							<img data-src="{###barcodeimg###}" style="display: none;">
							
							<div class="fc">	<span class="n" style="color: <#if membercard??>${membercard.numbercolor?default("")}<#else>#AAAAAA</#if>; text-shadow: rgb(0, 0, 0) 0px -1px;"></span>
							</div>
						</div>


							 <div class="logocontrol">
							<img  src="<#if membercard??>${BasePath}/${membercard.logourl?default("")}</#if>" id="setimg2" name="setimg2">
							 </div>
							 <div class="cardtitle">
								<div class="ctitle"><span class="cname" style="color: <#if membercard??>${membercard.namecolor?default("")}<#else>#957426</#if>;">
								<#if membercard??>${membercard.shopname?default("")}</#if></span></div>
						        </div>
						        <div class="cardnumber">
								<div class="cnumber">
								</div>
						        </div>

						
					</div>
					</div>
				</div>
				<div>
					<ul class="tbox group_btn3">
						<li style="width: 100%;display: block;text-align: center;">
							<a style="display: inline-block;" href="${BasePath}/zj/zjminweb/addMemberForward.kq?openid=${openid?default("")}&bid=${bid?default("")}">点击领取</a>
						</li>
					</ul>
				</div>
			</header>
			<div class="body">
				<ul class="list_ul">
				
					<!-- 特权-->
					<li class="li_a"><a href="${BasePath}/zj/zjminweb/getMembernotice.kq?bid=<#if bid??>${bid?default("")}</#if>&memberid=<#if member??>${member.id?default("")}</#if>&openid=<#if openid??>${openid?default("")}</#if>"><label class="label"><i>&nbsp;</i>会员公告<span>&nbsp;</span></label></a></li>
					
					<!-- 开卡活动-->
					
						
						
					<!-- 联系电话-->
					<li class="li_i"><a class="label" href="tel:<#if membercard??>${membercard.shoptelephone?default("")}<#else>0755-88308939</#if>"><i>&nbsp;</i>	
					<#if membercard??>${membercard.shoptelephone?default("")}<#else>0755-88308939</#if>
					<span>&nbsp;</span></a></li>
					
					
						
					<!-- 地址-->
					<li class="li_j"><a href="http://api.map.baidu.com/marker?location=<#if membercard??>${membercard.latitude?default('22.545331')}</#if>,<#if membercard??>${membercard.longitude?default('113.952072')}</#if>&amp;title=<#if membercard??>${membercard.shopname?default("")}</#if>&amp;content=<#if membercard??>${membercard.shopname?default("")}</#if>&amp;output=html">
							<label class="label"><i>&nbsp;</i>
							<#if membercard??>${membercard.shopaddress?default("")}<#else>深圳福田本元大厦</#if>
							<span>&nbsp;</span></label>
					</a>
					</li>
					
					
				</ul>
			</div>
	
	
	
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
	
	
		</div>
		

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



	var signinflagObject = document.getElementById("signinflag");
	if (signinflagObject.value == '0')
	{
		$('li#signButton').hide();
		$('li#signResult').show();
	}
</script>
</div>
</body>
</html>