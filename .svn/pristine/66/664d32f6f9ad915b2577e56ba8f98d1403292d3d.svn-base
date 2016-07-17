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
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>

</head>

<script>

	function checkinput()
	{
		var form = document.getElementById("material_form");
		
		var name = form.title;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入活动名称";
			return;
		}
		
		
		var ImgPath = form.ImgPath;
		if(ImgPath.value.length==0){
			var ImgPathclear = document.getElementById("ImgPathclear");
			ImgPath.focus();
			ImgPathclear.innerHTML="请上传活动照片";
			return;
		}
		
		
		
		var starttime = form.beginTime;
		
		if(starttime.value.length==0){
			var timeclear = document.getElementById("timeclear");
			starttime.focus();
			timeclear.innerHTML="请输入活动开始时间";
			return;
		}
		
		var endtime = form.endTime;
		
		if(endtime.value.length==0){
			var timeclear = document.getElementById("timeclear");
			endtime.focus();
			timeclear.innerHTML="请输入活动结束时间";
			return;
		}
		
		var description = form.content;
		if(description.value.length==0){
			var descriptionclear = document.getElementById("descriptionclear");
			description.focus();
			descriptionclear.innerHTML="请输入活动描述";
			return;
		}
		
		
		
		$("#img2").val($("#img1").val());
		
		form.submit();
	}
	
	function clearError()
	{	
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("ImgPathclear").innerHTML="";
		
		document.getElementById("timeclear").innerHTML="";
		document.getElementById("descriptionclear").innerHTML="";
	}
	
	function changeDiv()
	{
		if($("#type :selected").val() == '1')
		{
			document.getElementById("urldiv").style.display="none";
		}
		else
		{
			document.getElementById("urldiv").style.display="";
		}
		
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
top: 15%;             
left: 20%;
bottom: 10%;
width: 50%;             
height: 70%;                          
border: 16px solid gray;                         
z-index:1002;                      
}     
</style> 


<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li class="cur"><a href="">活动发布</a></li>
   </ul>
</div>

<div id="material" class="r_con_wrap" style="min-height:560px;height:auto !important;">
            <form id="material_form" method="post" action="${BasePath}/actInfoManage/saveActInfo.kq">
                            <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
                <div class="m_lefter one">
                    <div class="title">图片预览</div>
                      <div class="img" id="MsgImgDetail">
                      	<#if activities??>
                      	<a href="${BasePath}/${activities.photourl}" target="_blank">
							<img src="${BasePath}/${activities.photourl}">
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
                            <span class="fc_red">*</span> 活动名称<br />
                            <div class="input"><input name="title" placeholder="活动名称" notnull  type="text" onKeyUp="javascript:clearError();"/></div>
                            <div id="nameclear" style="color:#F00;"></div>
                            <div class="blank20"></div>
                            <span class="fc_red">*</span> 上传活动图片 <span class="tips">大图尺寸建议：640*360px</span><br />
                            <div class="blank6"></div>
                            <div>
                            
                            <input name="FileUpload" id="MsgFileUpload" type="file" style="display: none;" width="120" height="30">
                            <div id="ImgPathclear" style="color:#F00;"></div>
                            <input id="img1" type="hidden" name="ImgPath" onChange="javascript:clearError();" >
                            <input id="img2" type="hidden" name="imgDirec"  >
                            
                            </div>
                            
                            
                            
                            
                           
                            <div id="urlclear" style="color:#F00;"></div>
                            <div class="blank6"></div>
                            
                            
                            
                            
                            <span class="fc_red">*</span> 活动时间<br />
                            <div class="input">
                            	<input name="beginTime" placeholder="开始时间" value="" type="text" onKeyUp="javascript:clearError();" style="width:85px;" onclick="javascript:WdatePicker();"/>
                            	至 <input name="endTime" placeholder="结束时间" value="" type="text" onKeyUp="javascript:clearError();" style="width:85px;" onclick="javascript:WdatePicker();"/>
                            </div>
                            <div id="timeclear" style="color:#F00;"></div>
                            <div class="blank6"></div>
							
                            
                            <div class="blank12"></div>
                            <span class="fc_red">*</span> 活动描述<br />
                            <div><textarea name="content" placeholder="活动描述"></textarea></div>
                            <div id="descriptionclear" style="color:#F00;"></div>
                            <div class="blank20"></div>
                            
						    <input name="oUrl" value="" type="hidden" />
			    </div>
                        </div>
                    </div>
                </div>
                        <div class="clear"></div>
            <div class="button"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="提交" /></div>
            <input type="hidden" name="MId" value="0" />
            <input type="hidden" name="MaterialType" value="0" />
            <input type="hidden" name="do_action" value="wechat.material">
        </form>
    </div>  </div>
<div>
</body>
</html>