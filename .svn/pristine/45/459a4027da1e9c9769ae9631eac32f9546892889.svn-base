<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>

<link rel="stylesheet" href="${BasePath}/css/app/zj/zjmember/mc.css">
<script type="text/javascript" src="${BasePath}/js/app/zj/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/zjmember/main.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/zjmember/dialog_min.js"></script>


<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/bootstrap.min.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/bootstrap-combined.min.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>



</head>


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
.logocontrol
{
position:absolute; 
width:125px; height:45px; 
line-height:45px; 
left:100px; 
top:500px;
text-align: left;
overflow:hidden; 
filter:alpha(opacity=70); -moz-opacity:0.7; -khtml-opacity:0.7; opacity:0.7;
display:black;}
.cardtitle
{
position:absolute; 
width:125px; height:45px; 
line-height:25px; 
left:380px; 
top:515px;
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

<body onselectstart="return true;" ondragstart="return false;">

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li class="cur"><a href="${BasePath}/zj/getMembercard.kq">卡片管理</a></li>
	<li><a href="${BasePath}/zj/getMember.kq">会员管理</a></li>
	<li><a href="${BasePath}/zj/getIntegralrule.kq">积分规则</a></li>
	<li><a href="${BasePath}/zj/getMemberlevel.kq">等级管理</a></li>
	<li><a href="${BasePath}/zj/getMembernotice.kq">公告管理</a></li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
    
    <br/>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="thumbnails">
			
<#if membercard?? >

				<li class="span4" style="width:57.915%;*width:57.915%;">
					<div class="thumbnail">
						
						
						<div class="fg" style="background-image: url(${BasePath}/images/app/zjmember/card_back.jpg);height:286px;*height:286px; width:472px;*width:472px;padding:20px;position:relative;">
							<div class="backtag">
								<canvas data-bgcolor="#d90001" width="54" height="30"></canvas>
							</div>
							<div class="info" style="margin-left:50px;">
									
								<p class="addr">${membercard.shopname?default("")}</p>
								
									
								<p class="tel">
									<a class="autotel" href="#" onclick="event.stopPropagation();">tel:${membercard.shoptelephone?default("")}</a>
								</p>
								
							</div>
							<p class="keywords" style="position:absolute;bottom:20px; left:200px; color:#fff;">${membercard.name?default("")}</p>
						</div>
						
						
						
						
						
						<div class="caption">
							<p>
								<a class="btn btn-primary" href="${BasePath}/zj/updateMembercardForward.kq?type=2">修改反面</a>
							</p>
						</div>
					</div>
				</li>
				
				<li class="span4" style="width:57.915%;*width:57.915%; margin-left: 0" >
					<div class="thumbnail">
						
					<div class="front">
						<div class="fg" style="background-image: url(${BasePath}/${membercard.bgurl?default("images/app/zjmember/card_bg01.jpg")});height:286px; width:472px;padding:20px;position:relative; background-size: 472px 286px;">
							<!--<img id="cardlogoimg" src="${BasePath}/${membercard.logourl?default("")}" style="margin-top: 39px;width:185px;height:65px;margin-left:120px; margin-top:80px;">-->
							<img data-src="{###barcodeimg###}" style="display: none;">
							<div class="fc">
								<!--<span class="cname" style="color: ${membercard.namecolor?default("")};position:absolute;top:10px;">${membercard.name?default("")}-会员卡</span>-->
								<span class="n" style="color: ${membercard.numbercolor?default("")}; text-shadow: rgb(0, 0, 0) 0px -1px;position:absolute;bottom:10px;right:10px; left:210px;bottom:25px;">${membercard.cardnoinit?default("343054")}</span>
							</div>
						</div>
						
						 <div class="logocontrol">
							<img  src="<#if membercard??>${BasePath}/${membercard.logourl?default("")}</#if>" id="setimg2" name="setimg2">
						 </div>
						 
						 <div class="cardtitle">
								<div class="ctitle"><span class="cname" style="font-size:22px;color: <#if membercard??>${membercard.namecolor?default("")}<#else>#957426</#if>;">
								<#if membercard??>${membercard.shopname?default("")}</#if></span></div>
						 </div>
						
					</div>
						<div class="caption">
							<p>
								<a class="btn btn-primary" href="${BasePath}/zj/updateMembercardForward.kq?type=1">修改正面</a>
							</p>
						</div>
					</div>
				</li>
<#else>
	<div class="yt-tb-list-no">暂无内容</div>
</#if>




				
			</ul>
		</div>
	</div>
</div>

</body>
</html>