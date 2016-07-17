<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript">
	var bid="${bid}"; 	
	var BasePath="${BasePath}"; 	
</script>

<link rel="stylesheet" type="text/css" href="${BasePath}/css/map/style_2_common.css" />
<link rel="stylesheet" type="text/css" href="${BasePath}/css/map/style.css"/>
<link rel="stylesheet" type="text/css" href="${BasePath}/css/map/cymain.css" />

<script type="text/javascript" src="${BasePath}/js/map/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/map/common.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2b79c282b0f365ca9782cceb499e6022"></script>


<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />

<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>

</head>

<script>

function checkTel(tel)
{
   var mobile = /^1[3|5|8]\d{9}$/ , phone = /^0\d{2,3}-?\d{7,8}$/;
   return mobile.test(tel) || phone.test(tel);
}

	function checkinput()
	{
		var form = document.getElementById("material_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入门店名称";
			return;
		}
		
		
		var ImgPath = form.ImgPath;
		if(ImgPath.value.length==0){
			var ImgPathclear = document.getElementById("ImgPathclear");
			ImgPath.focus();
			ImgPathclear.innerHTML="请上传门店图片";
			return;
		}
		
		var telephone = form.telephone;
		if(telephone.value.length==0){
			var telephoneclear = document.getElementById("telephoneclear");
			telephone.focus();
			telephoneclear.innerHTML="请输入门店服务电话";
			return;
		}
		
		if(!checkTel(telephone.value)){
			var telephoneclear = document.getElementById("telephoneclear");
			telephone.focus();
			telephoneclear.innerHTML="请输入正确的门店服务电话";
			return;
		}
		
		var address = form.address;
		if(address.value.length==0){
			var addressclear = document.getElementById("addressclear");
			address.focus();
			addressclear.innerHTML="请输入门店地址";
			return;
		}
		
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("ImgPathclear").innerHTML="";
		document.getElementById("telephoneclear").innerHTML="";
		document.getElementById("addressclear").innerHTML="";
	}

</script>
<body>



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
#r-result{height:100%;float:left;}
</style> 


<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">图文管理</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
	<li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li ><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>

<div id="material" class="r_con_wrap" style="min-height:500px;height:auto !important;">
            <form id="material_form" method="post" action="<#if type?? && type=='mod'>${BasePath}/zj/updateRetailstore.kq?id=${retailstore.id}<#else>${BasePath}/zj/addRetailstore.kq</#if>">
                            <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
                <div class="m_lefter one">
                    <div class="title">图片预览</div>
                      <div class="img" id="MsgImgDetail">
                      	<#if retailstore??>
                      	<a href="${BasePath}/${retailstore.url}" target="_blank">
							<img src="${BasePath}/${retailstore.url}">
						</a>
						<#else>
                      	封面图片
                      	</#if>
                      </div>
                    <div class="txt"></div>
                </div>
                <div class="m_righter">
                    <div class="mod_form">
                        <div class="jt"><img src="${BasePath}/images/global/jt.gif" /></div>
                        <div class="m_form">
                        	
                            <div class="input">
                            <span class="fc_red">*</span> 门店名称<br />
                            <div class="input"><input name="name" placeholder="门店名称" notnull value="<#if retailstore??>${retailstore.name?default("")}</#if>" type="text" onKeyUp="javascript:clearError();"/></div>
                            <div id="nameclear" style="color:#F00;"></div>
                            <div class="blank20"></div>
                            <span class="fc_red">*</span> 上传门店图片 <span class="tips">大图尺寸建议：640*360px</span><br />
                            <div class="blank6"></div>
                            <div>
                            
                            <input name="FileUpload" id="MsgFileUpload" type="file" style="display: none;" width="120" height="30">
                            <div id="ImgPathclear" style="color:#F00;"></div>
                            <input type="hidden" name="ImgPath" onChange="javascript:clearError();" value="<#if retailstore?? && retailstore.url??>${retailstore.url}</#if>">
                            
                            </div>
                            <span class="fc_red">*</span> 门店电话<br />
                            <div class="input"><input name="telephone" placeholder="门店电话" value="<#if retailstore??>${retailstore.telephone?default("")}</#if>" type="text" onKeyUp="javascript:clearError();"/></div>
                            <div id="telephoneclear" style="color:#F00;"></div>
                            <div class="blank6"></div>
                            
			     <div class="blank12"></div>门店描述<br />
                            <div><textarea name="description" placeholder="门店描述"><#if retailstore??>${retailstore.description?default("")}</#if></textarea></div>
                            <div class="blank20"></div>
                            
						    <input name="oUrl" value="" type="hidden" />
			    </div>
			    
                            
			    
			    <div id="addressclear" style="color:#F00;"></div>
                            <div class="blank6"></div>
			    <div class="" style="">经度：<input name="longitude" id="longitude" value="<#if retailstore??>${retailstore.longitude?default("")}<#else>114.07568</#if>" type="text" size="15" style="width:78px;"/> 
                            			     纬度：<input name="latitude" id="latitude" value="<#if retailstore??>${retailstore.latitude?default("")}<#else>22.535718</#if>" type="text"  size="15" style="width:78px;"/>
                            
                           
                            </div>
                            
                            <input type="hidden" id="longitudebak" value="<#if retailstore??>${retailstore.longitude?default("")}<#else>114.07568</#if>" />
							<input type="hidden" id="latitudebak" value="<#if retailstore??>${retailstore.latitude?default("")}<#else>22.535718</#if>" />

                            <div id="searchResultPanel" style=""></div>
			    
							
                            
                           
                        

			<span class="fc_red">*</span> 门店地址<br />
                            <div class="input" id="r-result" style="height:auto;overflow:hidden;">
			    <input style="height:auto;overflow:hidden;" name="address" id="address"  placeholder="<#if retailstore??>${retailstore.address?default("门店地址")}</#if>" value="<#if retailstore??>${retailstore.address?default("")}</#if>" type="text" />
			     <a href="javascript:tcdiv()">获取经纬度</a>
			    </div>
			</div>

                    </div>
                </div>
                        <div class="clear"></div>
            <div class="button">
	    <input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="<#if type?? && type=='mod'>修改<#else>提交</#if>保存" /><a href="javascript:history.go(-1); " class="btn_gray">返回</a></div>
            <input type="hidden" name="MId" value="0" />
            <input type="hidden" name="MaterialType" value="0" />
            <input type="hidden" name="do_action" value="wechat.material">
        </form>
    </div>  </div>
<div>

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

	
// 百度地图API功能
function G(id) {
    return document.getElementById(id);
}

var map = new BMap.Map("l-map");



if($('#longitudebak').val()==0||$('#longitudebak').val()=='')
{
	map.centerAndZoom("广州",15);    
}
else
{
	var point = new BMap.Point($('#longitudebak').val(),$('#latitudebak').val());
	map.centerAndZoom(point,15);
}


map.enableScrollWheelZoom();                            //启用滚轮放大缩小
map.getBounds().getCenter();

var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {"input" : "address"
    ,"location" : map
});

ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
var str = "";
    var _value = e.fromitem.value;
    var value = "";
    if (e.fromitem.index > -1) {
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
    
    value = "";
    if (e.toitem.index > -1) {
        _value = e.toitem.value;
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
  //  G("searchResultPanel").innerHTML = str;
});

var myValue;
ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
var _value = e.item.value;
    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  //  G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
     setPlace();
 });

function setPlace(){	

    map.clearOverlays();    //清除地图上所有覆盖物
    function myFun(){
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 45);
		var marker = new BMap.Marker(pp);
		marker.enableDragging();
		map.addOverlay(marker);
		map.panBy(new GSize(305,165));	//这里的数值单位是像素不是百度的经纬度
		
		marker.addEventListener("dragend", function(e){
			$('#longitudebak').attr('value',e.point.lng);
			$('#latitudebak').attr('value',e.point.lat);
		});
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
      onSearchComplete: myFun

    });
    local.search(myValue);
}	


</script>


</body>
</html>