<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="${BasePath}/js/wobble/zepto.min.js"></script>
<title>兑奖资料填写</title>
<link rel="stylesheet" href="${BasePath}/css/wobble/common.css"><style>
body{
	background-color: #bf232e;
}
.wrapper {
	width: 100%;
	position: relative;
	margin: 0 auto;
	max-width: 500px;
}
.bg {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	z-index: -1;
}
.loading-mask {
	width: 100%;
	height: 200%;
	position: fixed;
	background: rgba(0,0,0,0.6);
	z-index: 100;
	left: 0px;
	top: 0px;
	display: none;
}
.loading-mask img.gimg {
	display: block;
	margin: 160px auto 0px;
}
.inner-cont{
	width: 85%;
	margin: 0 auto;
	padding-top: 20px;
	color: #FFFFFF;
}
.qtitle{
	line-height: 30px;
	font-size: 26px;
	font-weight: bold;
}
.field-contain{
	margin-top: 20px;
}
.input-label{
	font-size: 18px;
	line-height: 32px;
}
.input-text {
	display: block;
	width: 90%;
	height: 32px;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;
	border-radius: 8px;
	padding: 2px 5px;
	background: -moz-linear-gradient(top, #d2cfd2 0, #ffffff 50%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, #d2cfd2), color-stop(50%, #ffffff));
	background: -webkit-linear-gradient(top, #d2cfd2 0, #ffffff 50%);
	background: -o-linear-gradient(top, #d2cfd2 0, #ffffff 50%);
	background: -ms-linear-gradient(top, #d2cfd2 0, #ffffff 50%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d2cfd2', endColorstr='#ffffff', GradientType=0 );
	background: linear-gradient(top, #d2cfd2 0, #ffffff 50%);
	border: 1px solid #c6c3c6;
	border-top-width: 2px;
}
.loading-mask{
	background: rgba(0,0,0,0.6);
}
.tip{
	color: #FFFFFF;
	font-size: 12px;
}
#save-btn{
	padding: 10px 12px;
	font-size: 1em;
	padding: 10px 32px;
	background: #ffaa22;
	background: -moz-linear-gradient(top, #ffaa22 0, #f04a02 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0, #ffaa22), color-stop(100%, #f04a02));
	background: -webkit-linear-gradient(top, #ffaa22 0, #f04a02 100%);
	background: -o-linear-gradient(top, #ffaa22 0, #f04a02 100%);
	background: -ms-linear-gradient(top, #ffaa22 0, #f04a02 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffaa22', endColorstr='#f04a02', GradientType=0 );
	background: linear-gradient(top, #ffaa22 0, #f04a02 100%);
	color: #000;
	font-size: 20px;
	border: 1px solid #c94e04;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;
	border-radius: 8px;
	font-weight: bold;
	margin-top: 20px;
}
#save-btn{
	color: #c63535;
	padding: 7px 30px;
	background: #ffd700;
	display: inline-block;
	border-radius: 9px;
}
.page-url {
	border-top:0px;
	margin-top: 10px;
	position: absolute;
	bottom: 0px;
	text-align: center;
	width: 100%;
}
.page-url-link{
	color: white;
	text-shadow:none;
}
</style><script type="text/javascript">
//隐藏微信中网页底部导航栏
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
});
//隐藏微信中网页右上角按钮
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideOptionMenu');
});
</script></head>

<script type="text/javascript">
	var BasePath="${BasePath}";
</script>


<body>
	<div class="wrapper">
		<img class="bg" src="${BasePath}/images/wobble/info_bg.jpg">
		<div class="inner-cont">
			<div class="qtitle">填写领奖的个人信息：</div>
			<div class="field-contain">
				<label for="username" class="input-label">请输入您的名称:</label>
				<input type="text" name="username" id="username" class="input-text" value="">
			</div>
			<div class="field-contain">
				<label for="phone" class="input-label">请输入您的手机号码:</label>
				<input type="tel" name="phone" id="phone" class="input-text" value="">
				<span class="tip">*请务必填写正确，此手机号将作为您以后领奖的依据</span>
			</div>
			<button id="save-btn">保存</button>
		</div>
	</div>
	<div id="loading" class="loading-mask">
		<img class="gimg" src="${BasePath}/images/wobble/ajax-loader.gif">
	</div>
	<script type="text/javascript">
	$(function(){		
		$("#save-btn").on("click",function(){
			var $username = $("#username");
			var username = $username.val();
			var $phone = $("#phone");
			var phone = $phone.val();
			if(username == ""){
				alert("请输入用户名!");
				$username.focus();
				return false;
			}
			if(phone == ""){
				alert("请输入手机号码!");
				$phone.focus();
				return false;
			}
			var regu =/^[0-9]{8,20}$/;
			var re = new RegExp(regu); 
			if(!re.test(phone)){
				alert("请输入正确的手机号码!");
				$phone.focus();
				return false;
			}
			if(confirm("信息提交后不可修改，真的确定要提交吗？")){
				var submitData = {
					bid:'${bid?default("")}',
					openid:'${openid?default("")}',
					activitiesid:'${activitiesid?default("")}',
					username:username,
					phone:phone
				};
				$.ajax({
					type : "POST",
					url : BasePath+"/zj/zjminweb/addPrizerecord.kq",
					data : submitData,
					dataType : "json",
					contentType: "application/x-www-form-urlencoded; charset=utf-8",
					success : function(data){
						var response = eval(data);
						if(response.result == 'success'){
							alert("感谢您的参与！");
							location.href=BasePath+'/zj/zjminweb/winForward.kq?bid='+response.t.bid+'&openid='+response.t.openid+'&activitiesid='+response.t.activitiesid;
						}
						else
						{
							alert(response.message);
						}
					}
				});
			}
		});
		$(document).on('ajaxBeforeSend', function(e, xhr, options){
			$("#loading").show();
		}).on("ajaxComplete ",function(e, xhr, options){
			$("#loading").hide();
		});
	});
</script>

</body></html>