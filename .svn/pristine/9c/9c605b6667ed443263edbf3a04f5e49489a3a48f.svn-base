<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>摇一摇</title>
</head>
<script type="text/javascript">
	var BasePath="${BasePath}";
</script>
<body>




<link rel="stylesheet" href="${BasePath}/css/wobble/font.css">
<link rel="stylesheet" href="${BasePath}/css/wobble/weiba.new.css">
<link rel="stylesheet" href="${BasePath}/css/wobble/shake.css">
<link rel="stylesheet" href="${BasePath}/css/wobble/alertify.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/wobble/jquery.mobile.events.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/wobble/alertify.min.js"></script>
<style>
.game-yao:before {
	z-index: 999;
}
.game-run-top{
	position:relative;
}
.game-run-bottom{
	position:relative;
}
</style>
<script type="text/javascript">

//隐藏微信中网页底部导航栏
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
});
//隐藏微信中网页右上角按钮
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideOptionMenu');
});

var result=undefined; //记录摇奖结果
var shaking=false;
var audio1=null;
var audio2=null;
var stop=false;
var stepCount=0;
var hasSend=false;

function toBig(num){
	if(num==1){
		return '一';
	}else if(num==2){
		return '二';
	}else if(num==3){
		return '三';
	}else if(num==4){
		return '四';
	}else if(num==5){
		return '五';
	}else if(num==6){
		return '六';
	}else if(num==7){
		return '七';
	}else if(num==8){
		return '八';
	}
	return '';
}

//处理摇奖结果
function pointResult(res){
	stepCount++;
	if(stepCount<4) return;
	if(!shaking) return;
	shaking=false;
	stop=true;
	if (audio2.paused) {
		audio2.play();
	}
	setTimeout(function(){
		$('.game-run-tips').html('摇奖结束');
		if(res.result == 'success'){
		
			//var dataArr=res.data.split('::');
			//var snCode=1234;//dataArr[0];
			//var idx=1;//dataArr[1];
			//var pName='我也不知道啥将';//dataArr[2];
			Alertify.dialog.labels.ok = "去填写资料";
			//Alertify.dialog.alert('恭喜您，您中了'+toBig(idx)+'等奖（'+pName+'）',function(){
			Alertify.dialog.alert('恭喜您，您中了'+res.t.prize.name+'（'+res.t.prize.description+'）',function(){
				location.href=BasePath+'/zj/zjminweb/addPrizerecordForward.kq?bid='+res.t.bid+'&openid='+res.t.openid+'&activitiesid='+res.t.activitiesid;
			});
		}else{
			Alertify.dialog.labels.ok = "再试一次";
			Alertify.dialog.alert(res.message+"！",function(){
				location.reload();
			});
		}
	},800);	
}

//开始摇动
function shake(){
	
	if (audio1.paused && !stop) {
		audio1.play();
	}
	if(!shaking && !stop){
		
		shaking=true;
		if(!hasSend){
			hasSend=true;		
			//发送请求
			$.ajax({
				url : BasePath+"/zj/zjminweb/shake.kq",
				dataType : "json",
				data : {
					bid:'${bid?default("")}',
					openid:'${openid?default("")}',
					activitiesid:'${activitiesid?default("")}'
				},
				success : function(res){
					var response = eval(res);
					if(response.result != 'success' && response.message=='操作失败!'){
						Alertify.dialog.labels.ok = "确定";
						Alertify.dialog.alert("摇奖失败",function(){
							location.reload();
						});
					}else{
						result=response;
						$('.loading_pop').hide();
						pointResult(result);
					}
				}
			});
		}
		setTimeout(function(){
			$(".game-run-top").animate({
				top : "-25%"
			}, 300, function() {
				$(".game-run-top").animate({
					top : "0"
				}, 300);
			});
			$(".game-run-bottom").animate({
				top : "25%"
			}, 300, function() {
				$(".game-run-bottom").animate({
					top :"0"
				}, 300, function() {					
					if(result==undefined && stepCount==2){
						$('.loading_pop').show();						
					}else{
						pointResult(result);
					}
					$('.game-run-tips').html('请您继续摇动...');
					shaking=false;
				});
			});
		},1000);	
	}
}

$(function(){

	var $game_status=$('.game-status');
	$game_status.height($game_status.width()+20);
	audio1=document.getElementById('audio1');
	audio2=document.getElementById('audio2');
	var SHAKE_THRESHOLD = 1500;    
	var last_update = 0;    
	var x=y=z=last_x=last_y=last_z=0;
	
	$(".game-start-btn,.lihua").off("click").on("click",function() {
		
		var overTotalCount=false; //是否超过总次数
		var overPerDayCount=false; //是否超过每天总次数
		if(overPerDayCount){
			Alertify.dialog.labels.ok = "确定";
			Alertify.dialog.alert("亲，您今天的参与次数已经用完了，请明天再来吧！");
			return;
		}
		if(overTotalCount){
			Alertify.dialog.labels.ok = "确定";
			Alertify.dialog.alert("亲，您的参与次数已经用完了，请下次再来吧！");
			return;
		}
		
		$(".wap").hide();
		var z = '<div class="game-blank"><div class="game-run-top"></div><div class="game-run-bottom"></div><div class="game-run-tips">大力摇吧，摇出大奖</div></div>';
		$("body").append(z);
	});
	
	//添加点击事件和摇动事件
	$('body').on('click','.game-blank',shake);
	if (window.DeviceMotionEvent) {
		window.addEventListener('devicemotion',function(eventData) {
			var acceleration =eventData.accelerationIncludingGravity;   
			var curTime = new Date().getTime(); 
			if ((curTime - last_update)> 100) {  
				var diffTime = curTime -last_update;    
				last_update = curTime;        
				x = acceleration.x;
				y = acceleration.y;
				z = acceleration.z;
				var speed = Math.abs(x +y + z - last_x - last_y - last_z) / diffTime * 10000;   
				if (speed > SHAKE_THRESHOLD/4 && $('.wap').css('display')=='none') {
					shake();
				}
				last_x = x;    
				last_y = y;    
				last_z = z;
			}
		}, false);
	} 
	
});
</script>

<div class="wap">
    <div class="shake-title"><#if activities??>${activities.name?default("")}</#if></div>
    <div class="game-status" style="height: 1346px;">
        <div class="game-yao"></div>
        <div class="lihua"></div>
    </div>
    <div class="game-btn" style="z-index: 9999;position: relative;">
        <div class="game-start"><span class="game-start-btn">开始摇奖</span></div>
        <div class="game-last-time">
            距离活动结束<span class="game-last-times font-ffd700"><#if timedifference??>${timedifference[0]?default("")}天${timedifference[1]?default("")}小时${timedifference[2]?default("")}分钟</#if></span>
        </div>
    </div>

    <div class="game-box page-descs">
        <h1>摇奖说明</h1>
        <div class="content page-desc">
        	<#if activities??>${activities.description?default("")}</#if>
        </div>
        <h1 class="game-prize-list">奖项设置</h1>
        <ul class="prize-list game-list clearfix page-prize-list">
        
		<#if wobbleprizelist?? && (wobbleprizelist?size>0) >
	      	<#list wobbleprizelist as item>
	      	
				<li class="clearfix">
					<span class="prize-name">${item.name?default("")}：${item.description?default("")}</span>
					
					<span class="prize-num">${item.number?default(0)}个</span>
					
				</li>
			
			</#list>
		<#else>
			<li class="clearfix">
					<span class="prize-name">暂无记录</span>
					
					<span class="prize-num"></span>
					
				</li>
							
		</#if>
			
			
			
			
			
			
			
			
			
        </ul>
    </div>    
	

<!--
<p class="page-url"><a href="http://www.weijuju.com" target="_blank" class="page-url-link">此功能由“微俱聚”平台提供</a></p>

-->


</div>

	
<div class="loading_pop" style="display:none;">
	<div class="cont" style="text-align:center;width:100%;height:50px;position:absolute;top:50%;margin-top:-25px;z-index:999999;font-size:20px;color:rgb(249, 249, 249);">
		<img style="width:30px;height:30px;vertical-align:-7px;" src="data:image/gif;base64,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" alt="Loading..."> <span>摇奖中...</span>
	</div>
	<div class="pop_mask" id="popMask" style="position:absolute;width:100%;height:100%;background-color:black;opacity:0.65;top:0;left:0;z-index:99999;"></div>
</div>
    
<audio id="audio1" src="${BasePath}/music/wobble/shake_sound_male.mp3" preload="auto">
</audio>
<audio id="audio2" src="${BasePath}/music/wobble/shake_match.mp3" preload="auto">
</audio>
	


</body></html>