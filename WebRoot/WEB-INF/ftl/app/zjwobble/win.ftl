<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>摇一摇中奖页面</title>


<link rel="stylesheet" href="${BasePath}/css/wobble/common.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<style>
	body {
		padding: 15px 10px 0;
		position: relative;
		height: 100%;
		color: #444;
		font-family: Microsoft YaHei, Helvetica, STHeiti STXihei, Microsoft JhengHei,Tohoma, Arial;
		background: url("${BasePath}/images/wobble/win_bg_2.jpg") repeat-x 0px 0px;
		background-color: #e5e5e5;
	}
	#article-name{
		font-size: 20px;
		color: black;
		font-weight: 200;
		word-break: normal;
		word-wrap: break-word;
	}
	.summary{
		margin: 20px auto;
		text-indent: 2em;
	}
	#create_time{
		font-size: 11px;
		color: #8C8C8C;
		margin: 0;
	}
	.cover{
		text-align: center;
		width: 99%;
		max-width : 425px;
		margin: 50px auto 20px;
	}
	.cover img{
		width: 100%;
		height: auto;
		-moz-box-shadow: 0 1px 5px rgba(0,0,0,0.2);
		-webkit-box-shadow: 0 1px 5px rgba(0,0,0,0.2);
		box-shadow: 0 1px 5px rgba(0,0,0,0.15);
		border: #E2E2E2 solid 1px;
		-moz-border-radius: 12px;
		-webkit-border-radius: 12px;
		border-radius: 12px;
	}
	.content{
		background-color: #FFF;
		-moz-box-shadow: 0 1px 5px rgba(0,0,0,0.2);
		-webkit-box-shadow: 0 1px 5px rgba(0,0,0,0.2);
		box-shadow: 0 1px 5px rgba(0,0,0,0.15);
		border: #E2E2E2 solid 1px;
		-moz-border-radius: 12px;
		-webkit-border-radius: 12px;
		border-radius: 12px;
		padding: 8px 13px;
	}
	.content .desc{
		font-weight: bold;
		border-bottom: 1px dashed #000;
		padding: 12px 0px;
	}
	.content .desc .sncode{
		float: right;
	}
	.loading-mask {
		width: 100%;
		height: 200%;
		position: fixed;
		background: rgba(0,0,0,0.6);
		z-index: 100;
		left: 0px;
		top: 0px;
		display:none;
	}
	.loading-mask img.gimg {
		display: block;
		margin: 160px auto 0px;
	}
	.loading-mask{
		background: rgba(0,0,0,0.6);
	}
</style>
<script type="text/javascript">
$(function(){
	
	//隐藏微信中网页底部导航栏
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('hideToolbar');
	});
	//隐藏微信中网页右上角按钮
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('hideOptionMenu');
	});
	
	var password='';
	if(password){
		$('.content .consume').show();
	}
	$('#check_cp').click(function(){
		var pwd=$('#consume_password').val();
		if(pwd.length==0){
			alert('请输入商家兑奖密码');
			return;
		}
		if(password!=pwd){
			alert('商家兑奖密码输入不正确');
			return;
		}
		$('.loading-mask').show();
		$.ajax({
			type : "POST",
			url : "/mobile/shake",
			data : {
				action:'useCode',
				aid:'89190',
				snCode:'4133753851'
			},
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			success : function(data){
				$('.loading-mask').hide();
				if(data.success == true){					
					alert("使用成功");
					location.reload();
				}else{
					alert("使用失败");
				}
			}
		});
	});
})
</script>
</head>
<body>
	<div>
		<div class="cover">
			<img src="${BasePath}/images/wobble/win_bg_1.jpg">
		</div>
								
		<div class="content">
			
			
			<div class="consume" style="font-size: 14px;color: rgb(200, 14, 14);margin-top: 8px;">
				使用状态：<#if wobbleprizerecord?? && wobbleprizerecord.isreg == 1>已兑换<#else>未兑换</#if>
			</div>
			
			
			<div class="desc">
				<span>您中的奖品是：</span>
			</div>
			<div style="margin-top: 10px;">
			<#if wobbleprize??>${wobbleprize.name?default("")}（${wobbleprize.description?default("")}）</#if>
			<div class="desc">
				<span>活动说明：</span><br>
			</div>
			<div style="margin-top: 10px;margin-bottom:6px;">
				<#if activities??>${activities.description?default("")}</#if>
			</div>
			</div>
		</div>
		<div style="clear:both;"></div>
	</div>
	
	<div id="loading" class="loading-mask">
		<img class="gimg" src="${BasePath}/images/wobble/ajax-loader.gif">
	</div>
	
	
<!--

<p class="page-url"><a href="http://www.weijuju.com" target="_blank" class="page-url-link">此功能由“微俱聚”平台提供</a></p>

-->



</body></html>