<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet" href="./css/app/zjmember/mc.css">
<script type="text/javascript" src="./js/app/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="./js/app/zjmember/main.js"></script>
<script type="text/javascript" src="./js/app/zjmember/dialog_min.js"></script>

<title>会员卡</title>

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
	border-bottom: 2px solid #E37176;
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
</style>

</head>
<body onselectstart="return true;" ondragstart="return false;">


	
	<script type="text/javascript">
		function charge(){
			loading(true);
			$.ajax({
				url: "/mobile/mcard",
				type:"get",
				data:{
					action:'signin',
					mcid:1704,
					wuid:61892,
					talker:'oNrR5t1G3TuV-V_DdiXvp6nH_6_E'
				},
				dataType:"json",
				success: function(res){
					if(res.success){
						loading(false);
						alert('签到成功',1500);
						var point=res.result;
						var $currPointsp=$('a#myPoint span').last();
						var currPoint=$currPointsp.html();
						currPoint=Number(currPoint)+point;
						$currPointsp.html(currPoint);
						$('li#signButton').hide();
						$('li#signResult').show();
					}
				}
			});
		}
	</script>
	<div class="container card">
		<header>
			<div class="header card">

				<div class="card " data-side="1" onclick="this.classList.toggle(&#39;on&#39;);">					
					<div class="back">
						<div class="fg" style="background-image: url(images/card_back.jpg);">
							<div class="backtag">
								<canvas data-bgcolor="#d90001" width="54" height="30"></canvas>
							</div>
							<div class="info">
									
								<p class="addr">深圳福田本元大厦</p>
								
									
								<p class="tel">
									<a class="autotel" href="tel:0755-88308939" onclick="event.stopPropagation();">0755-88308939</a>
								</p>
								
							</div>
							<p class="keywords">花儿精品店</p>
						</div>
					</div>
					<div class="front">
						<div class="fg" style="background-image: url(images/card_bg01.jpg);">
							<img id="cardlogoimg" src="images/b5186e6a-69d3-4883-8a7e-b0df77ef6d49.png" style="margin-top: 39px;width:185px;height:65px;">
							<img data-src="{###barcodeimg###}" style="display: none;">
							<div class="fc">
								<span class="cname" style="color: #957426;">花儿精品店-会员卡</span>
								<span class="n" style="color: #AAAAAA; text-shadow: rgb(0, 0, 0) 0px -1px;">343054</span>
							</div>
						</div>
					</div>
				</div>


			</div>
			
		</header>
		<div class="body">
			<ul class="list_ul">
				<div>
					<li class="li_a"><a href="http://www.weijuju.com/mobile/mc/cardMainPriv.jsp?wuid=61892&uid=60135&talker=oNrR5t1G3TuV-V_DdiXvp6nH_6_E&mcid=1704"><label class="label"><i>&nbsp;</i>会员特权 <span>&nbsp;</span></label></a></li>
					<li class="li_b"><a href="http://www.weijuju.com/mobile/mc/cardGetPreferential.jsp?wuid=61892&uid=60135&talker=oNrR5t1G3TuV-V_DdiXvp6nH_6_E&mcid=1704"><label class="label"><i>&nbsp;</i>领取优惠券<span>&nbsp;</span></label></a></li>
					<li class="li_c"><a href="http://www.weijuju.com/mobile/mc/cardChange.jsp?wuid=61892&uid=60135&talker=oNrR5t1G3TuV-V_DdiXvp6nH_6_E&mcid=1704"><label class="label"><i>&nbsp;</i>积分兑换<span>&nbsp;</span></label></a></li>
					<li class="li_d"><a href="http://www.weijuju.com/mobile/mc/cardApplyInfo2.jsp?wuid=61892&uid=60135&talker=oNrR5t1G3TuV-V_DdiXvp6nH_6_E&mcid=1704"><label class="label"><i>&nbsp;</i>完善会员卡资料 <span>&nbsp;</span></label></a></li>
				</div>
				<div>
						
					<li class="li_i"><a class="label" href="tel:0755-88308939"><i>&nbsp;</i>0755-88308939
							<span>&nbsp;</span></a></li>
					
						
					<li class="li_j"><a>
							<label class="label"><i>&nbsp;</i>深圳福田本元大厦 <span>&nbsp;</span></label>
					</a></li>
					
				</div>
			</ul>
		</div>
		

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
</body>
</html>