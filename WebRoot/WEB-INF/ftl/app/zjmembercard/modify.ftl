<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript">
	var bid="${bid}"; 	
	var BasePath="${BasePath}"; 	
	
</script>



<#if type?? && type=="1">

<link rel="stylesheet" href="${BasePath}/css/color/bootstrap.min.css">
<link rel="stylesheet" href="${BasePath}/css/color/colorpicker.css">

<script type="text/javascript" src="${BasePath}/js/color/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/color/bootstrap-colorpicker.js"></script>
<#else>
<link rel="stylesheet" type="text/css" href="${BasePath}/css/map/style_2_common.css" />
<link rel="stylesheet" type="text/css" href="${BasePath}/css/map/style.css"/>
<link rel="stylesheet" type="text/css" href="${BasePath}/css/map/cymain.css" />

<script type="text/javascript" src="${BasePath}/js/map/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/map/common.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2b79c282b0f365ca9782cceb499e6022"></script>
</#if>




<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/app/zjmember/card.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<style type="text/css">body, html{background:url(images/main-bg.jpg) left top fixed no-repeat;}</style>
</head>
<style type="text/css"> 
body, html {width: 100%;height: 100%;overflow: hidden;margin:0;}
#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
#l-map{height:85%;width:100%;}
</style>

<style type="text/css">         
.black_overlay
{             
display: none;             
position: absolute;             
top: 0%;             
left: 0%;             
width: 100%;             
height: 100%;             
background-color:#EEEEEE;           
z-index:1001;             
-moz-opacity: 0.8;             
opacity:.80;             
filter: alpha(opacity=80);         
}         
.white_content 
{             
display: none;             
position: absolute;            
top: 10%;             
left: 20%;
bottom: 40%;
width: 50%;             
height: 50%;                        
border: 16px solid gray;                         
z-index:1002;                      
}

#material .multi .first .info .bgimg {
     color: #888;
    font-size: 20px;
    height: 180px;
    line-height: 180px;
    text-align: center;
     z-index: -1;
}
#material .multi .first .logocontrol
{
position:absolute; 
width:125px; height:45px; 
line-height:45px; 
left:10px; 
top:10px;
overflow:hidden; 
filter:alpha(opacity=70); -moz-opacity:0.7; -khtml-opacity:0.7; opacity:0.7;
display:black;}
.cardtitle
{
position:absolute; 
width:125px; height:45px; 
line-height:45px; 
left:180px; 
top:10px;
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
width:100px; height:35px; 
line-height:45px; 
left:90px; 
top:152px;
overflow:hidden; 
display:black;
}
.cnumber{
font-weight:bolder;
font-size:20px;
color:<#if membercard??>${membercard.numbercolor?default("#000000")}</#if>;
font-family:"黑体";
text-align:right;
}
.swm2{
position:absolute; 
width:55px; 
height:55px; 
line-height:55px; 
left:130px; 
top:100px;
overflow:hidden; 
display:black;
z-index:9999;
}
</style> 

<script>
function checkTel(tel)
{
   var mobile = /^1[3|5|8]\d{9}$/ , phone = /^0\d{2,3}-?\d{7,8}$/;
   return mobile.test(tel) || phone.test(tel);
}

function checkNum(num)
{
   var number = /^\d+$/;
   return number.test(num);
}
	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var shopname = form.shopname;
		if(shopname.value.length==0){
			var shopnameclear = document.getElementById("shopnameclear");
			shopname.focus();
			shopnameclear.innerHTML="请输入商家名称";
			return;
		}
		
		
		var shopaddress = form.shopaddress;
		if(shopaddress.value.length==0){
			var shopaddressclear = document.getElementById("shopaddressclear");
			shopaddress.focus();
			shopaddressclear.innerHTML="请输入商家地址";
			return;
		}
		
		var longitude = form.longitude;
		if(longitude.value.length==0){
			var jingweiduclear = document.getElementById("jingweiduclear");
			longitude.focus();
			jingweiduclear.innerHTML="请输入商家地址经度";
			return;
		}
		
		var latitude = form.latitude;
		if(latitude.value.length==0){
			var jingweiduclear = document.getElementById("jingweiduclear");
			latitude.focus();
			jingweiduclear.innerHTML="请输入商家地址纬度";
			return;
		}
		
		var shoptelephone = form.shoptelephone;
		if(shoptelephone.value.length==0){
			var shoptelephoneclear = document.getElementById("shoptelephoneclear");
			shoptelephone.focus();
			shoptelephoneclear.innerHTML="请输入商家电话";
			return;
		}
		
		if(!checkTel(shoptelephone.value)){
			var shoptelephoneclear = document.getElementById("shoptelephoneclear");
			shoptelephone.focus();
			shoptelephoneclear.innerHTML="请输入正确的商家电话";
			return;
		}
		
		var shopdescription = form.shopdescription;
		if(shopdescription.value.length==0){
			var shopdescriptionclear = document.getElementById("shopdescriptionclear");
			shopdescription.focus();
			shopdescriptionclear.innerHTML="请输入商家描述";
			return;
		}
		
		
		
		
		form.submit();
	}
	
	
	
	function checkcardinput()
	{
		var form = document.getElementById("material_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入会员卡名称";
			return;
		}
		
		var cardnoinit = form.cardnoinit;
		if(cardnoinit.value.length==0){
			var cardnoinitclear = document.getElementById("cardnoinitclear");
			cardnoinit.focus();
			cardnoinitclear.innerHTML="请输入起始会员卡号";
			return;
		}
		
		if(!checkNum(form.cardnoinit.value)){
			var cardnoinitclear = document.getElementById("cardnoinitclear");
			cardnoinit.focus();
			cardnoinitclear.innerHTML="请输入正确的起始会员卡号";
			return;
		}
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("shopnameclear").innerHTML="";
		document.getElementById("shopaddressclear").innerHTML="";
		document.getElementById("shoptelephoneclear").innerHTML="";
		document.getElementById("shopdescriptionclear").innerHTML="";
		document.getElementById("jingweiduclear").innerHTML="";
	}
	
	function clearCardError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("cardnoinitclear").innerHTML="";
	}

</script>
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
		
		
		<#if type?? && type=="1">
		
		
		<div id="material" class="r_con_wrap" style="min-height:550px;height:auto !important;">
			
		   <form id="material_form" method="post" action="${BasePath}/zj/updateMembercard.kq">
		   <input name="type" value="1" type="hidden" >
		   	<script language="javascript">$(document).ready(card_obj.material_two_init);</script>
		    
		    
		    
		    
		    
		    <div class="m_lefter multi">
		         <div class="first" id="multi_msg_0">
				<div class="info">
					<div class="bgimg">
						<#if membercard??>
							<a href="${BasePath}/${membercard.bgurl}" target="_blank">
								<img  name="setimg1" id="setimg1" src="${BasePath}/${membercard.bgurl}" onchange="javascript:alert('1');">
							</a>
						</#if>
					</div>
	
				</div>
				<div class="swm2">
					<img src="${BasePath}/images/2wm.jpg" />	
				</div>
				  <div class="logocontrol">
					<img name="setimg2" id="setimg2" src="${BasePath}/${membercard.logourl}"/>
				  </div>
				   <div class="cardtitle">
						<div class="ctitle">卡片名称</div>
				       </div>
				       <div class="cardnumber">
						<div class="cnumber"><#if membercard??>${membercard.cardnoinit?default("888888")}</#if></div>
				       </div>
				       		
			</div>
		        
		        
		        
		        
		    </div>
		    <div class="m_righter">
		        <div class="mod_form">
		            <div class="jt"><img src="${BasePath}/images/global/jt.gif" /></div>
		            <div class="m_form">
		                <span class="fc_red">*</span> 会员卡名称<span class="tips">(必填,不能超过20个字符)</span><br />
		                <div class="input"><input name="name" value="<#if membercard??>${membercard.name?default("")}</#if>" type="text" placeholder="会员卡名称" onKeyUp="javascript:clearCardError();"/></div>
		                <div id="nameclear" style="color:#F00;"></div>
		                <div class="blank9"></div>
		                <span class="fc_red">*</span> 起始会员卡号<span class="tips">(必填,不能比原值小)</span><br />
		                <div class="input">
				<input name="cardnoinit" value="<#if membercard??>${membercard.cardnoinit?default("")}</#if>" type="text" placeholder="起始会员卡号" onKeyUp="javascript:clearCardError();"/></div>
		                <div id="cardnoinitclear" style="color:#F00;"></div>
		                <div class="blank9"></div>
		                <span class="fc_red">*</span> 名称字体颜色<span class="tips">
				(见左边会员卡右上角)</span><br />
		                
		                <div class="controls">
					<input type="text" class="span2" value="<#if membercard??>${membercard.namecolor?default("#FFFFFF")}</#if>" name="namecolor" id="name_color" readonly="">
				</div>
												    
		                <div class="blank9"></div>
		                <span class="fc_red">*</span> 卡号字体颜色<span class="tips">
				(见左边会员卡右下角)</span><br />
		                
		                <div class="controls">
					<input type="text" class="span2" value="<#if membercard??>${membercard.numbercolor?default("#000000")}</#if>" name="numbercolor" id="number_color" readonly="">
				</div>
		                
		                <div class="blank9"></div>
		                <span class="fc_red">*</span> 会员卡背景图 <span class="tips">大图尺寸建议：
				<span class="big_img_size_tips">640像素 *360像素 </span></span><br />
		                <div class="blank6"></div>
		                <div>
				<input name="FileUpload1" id="MsgFileUpload1" type="file" /></div>
		                <input name="carimgurl" type="hidden" value="<#if membercard?? && membercard.bgurl??>${membercard.bgurl}</#if>">
				<div class="blank3"></div>
				

				<div class="blank9"></div>
		                <span class="fc_red">*</span> Logo图 <span class="tips">小图尺寸建议：
				<span class="big_img_size_tips">175像素 * 45像素</span></span><br />
		                <div class="blank6"></div>
		                <div>
				 <input name="FileUpload2" id="MsgFileUpload2" type="file" /></div>
		                 <input name="logoimgurl" type="hidden" value="<#if membercard?? && membercard.logourl??>${membercard.logourl}</#if>">
				<div class="blank3"></div>
						
						
						
						
					</div>
		        </div>
		    </div>
		    
		    
		    
		                <div class="clear"></div>
<div class="button">
<input type="button" onClick="javascript:checkcardinput();" class="btn_green" name="submit_button" value="提交保存" />
<a href="javascript:history.go(-1); " class="btn_gray">返回</a></div>
		    
		    
		    </form>
		 </div>
		 <br>
		 
		 
		
		<#else>
		
		
		
		<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<!--<div class="tips_info">
    岗位名称、基本要求（学历、截止时间、性别、年龄、工作地点、待遇）、岗位描述。<br />
</div>-->
<form id="zhaopin_form" action="${BasePath}/zj/updateMembercard.kq" class="r_con_form" method="post">
	<input name="type" value="2" type="hidden" >
    <div class="rows">
        <label>商家名称 <span class="fc_red">*</span></label>
        <span class="input">
		<input name="shopname" value="<#if membercard??>${membercard.shopname?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
		<div id="shopnameclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>商家详细地址 <span class="fc_red">*</span></label>
        <span class="input">
		<input name="shopaddress" value="<#if membercard??>${membercard.shopaddress?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
		<div id="shopaddressclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
    </div>
    
    
    
    <div class="rows">
        <label>商家地址经纬度 <span class="fc_red">*</span></label>
        <span class="input">
        	经度：<input class="form_input" name="longitude" id="longitude" value="<#if membercard??>${membercard.longitude?default("")}<#else>114.07568</#if>" type="text" size="15" style="width:78px;" onKeyUp="javascript:clearError();" onChange="javascript:clearError();"/> 
                                纬度：<input class="form_input" name="latitude" id="latitude" value="<#if membercard??>${membercard.latitude?default("")}<#else>22.535718</#if>" type="text"  size="15" style="width:78px;" onKeyUp="javascript:clearError();" onChange="javascript:clearError();"/>
            <a href="javascript:tcdiv()">地图中获取经纬度</a><span class="tips">(此字段用于微官网首页和会员页地图导航)</span>
			<div id="jingweiduclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
	    <input type="hidden" id="longitudebak" value="<#if membercard??>${membercard.longitude?default("")}<#else>114.07568</#if>" />
		<input type="hidden" id="latitudebak" value="<#if membercard??>${membercard.latitude?default("")}<#else>22.535718</#if>" />
    </div>
    
    
    <div class="rows">
        <label>联系方式 <span class="fc_red">*</span></label>
        <span class="input">
		<input name="shoptelephone" value="<#if membercard??>${membercard.shoptelephone?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
		<div id="shoptelephoneclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>商家描述 <span class="fc_red">*</span></label>
        <span class="input">
        	<textarea name="shopdescription" onKeyUp="javascript:clearError();"><#if membercard??>${membercard.shopdescription?default("")}</#if></textarea>
        	<span class="tips">(此字段用于微官网首页商家介绍)</span>
        	<div id="shopdescriptionclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
	<div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="修改保存" />
        <a href="javascript:history.go(-1); " class="btn_gray">返回</a></span>
        <div class="clear"></div>
    </div>
    <script language="javascript">
		if("oklab"=="${oklab?default('')}")
				alert("提交成功！")
    </script>
		
   </form>
</div>
		
		</#if>
		
		
		
	</div>
</div>






<!-- 地图显示 -->
<div id="light" class="white_content"> 
	<div id="divt" class="ftip">拖动红色图标到相应位置然后点击右侧链接->
		<a id="ok" onclick="setOver()" href="#">已经设定好，关闭该页面</a>
	</div>
	<div id="l-map"></div>
</div>
<div id="fade" class="black_overlay"></div> 

<script type="text/javascript"> 
	
	
	
	function tcdiv()
	{
	   document.getElementById('light').style.display='block';
	   document.getElementById('fade').style.display='block';
	
	}
	// 关闭并返回数据到主页面
	function setOver() 
	{
		document.getElementById("longitude").value=document.getElementById("longitudebak").value;
		
		document.getElementById("latitude").value=document.getElementById("latitudebak").value;
		
		document.getElementById('light').style.display='';
		document.getElementById('fade').style.display='';
	}
	
	 
	var map = new BMap.Map("l-map");
	
	var point = new BMap.Point($('#longitudebak').val(),$('#latitudebak').val());
	map.centerAndZoom(point,80);
	map.enableScrollWheelZoom();                            //启用滚轮放大缩小
	map.getBounds().getCenter();
	function myFun(result)
	{
		var cityName = result.name;
		if($('#longitudebak').val()==0||$('#longitudebak').val()=='')
		{
			map.setCenter(cityName);
			p = new BMap.Point(result.center.lng,result.center.lat);
		}
		else
		{
			p = new BMap.Point($('#longitudebak').val(),$('#latitudebak').val());
		}
		var marker = new BMap.Marker(p);
		marker.enableDragging();
		map.addOverlay(marker);
	 
		marker.addEventListener("dragend", function(e){
			$('#longitudebak').attr('value',e.point.lng);
			$('#latitudebak').attr('value',e.point.lat);
			//alert(e.point.lng + ";" + e.point.lat);
			//alert($('#longitudebak').val());
		})
	}
	 
	var myCity = new BMap.LocalCity();
	var p=myCity.get(myFun);
</script>







<#if type?? && type=="1">
<script>

$(function(){
	$('#name_color').colorpicker().on('changeColor', function(ev){
		var color = ev.color.toHex();
		$('#name_color').val(color);
		$(".img-preview .mc-name").css("color",color);
	});
	$('#number_color').colorpicker().on('changeColor', function(ev){
		var color = ev.color.toHex();
		$('#number_color').val(color);
		$(".img-preview .mc-number").css("color",color);
	});
	$(".reset").click(function(){
		var prev = $(this).prev();
		if(prev.is("#name_color")){
			if($('#name_color').val() != ''){
				$('#name_color').val("#957426");
				$(".img-preview .mc-name").css("color","#957426");
			}
		}else{
			$('#number_color').val("#AAAAAA");
			$(".img-preview .mc-number").css("color","#AAAAAA");
		}
		return false;
	});
	
});
</script>
</#if>

</body>
</html>