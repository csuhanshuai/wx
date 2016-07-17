<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>


</head>

<script>
<!--
function checkNum(num)
{
   var number = /^\d+$/;
   return number.test(num);
}

function changeShow(val, name)
{
   if(val != "")
   {        
      $("#" + name).attr("disabled",false);
   }
   else
   {
      $("#" + name).attr("disabled",true);
   }
}
   

function checkinput()
{
	var form = document.getElementById("material_form");
	
	var name = form.name;
	if(name.value.length==0){
		var nameclear = document.getElementById("nameclear");
		name.focus();
		nameclear.innerHTML="请输入题目名称";
		return;
	}
	
	var selectA = form.selectA;
	if(selectA.value.length == 0)
	{
	   var selectAclear = document.getElementById("clearA");
	   selectA.focus();
	   selectAclear.innerHTML="请输入A选项内容";
	   return;
	}
	
	var selectB = form.selectB;
	if(selectB.value.length == 0)
	{
	   var selectBclear = document.getElementById("clearB");
	   selectB.focus();
	   selectBclear.innerHTML="请输入B选项内容";
	   return;
	}
	
	
	var flag = "true";
	var len = $("[id^=select][disabled!=disabled]").length;
	
	$("[id^=select][disabled!=disabled]").each(function(i)
	   {  
	      if( parseInt(i) < parseInt(len -1))
	      {
		       if($(this).val() == "")
		       {
		          $(this).focus();
		          var id = $(this).attr("id");
		          var prefix = id.substring(id.length-1,id.length);
		          var clearId = "clear" + prefix;
		          document.getElementById(clearId).innerHTML="请输入"+prefix+"选项内容";
		          flag = "false";
		          return false;
		       }
	      }    
	   }
	); 
	
	if(flag=="false")
	{
	   return;
	}

	var id = form.id;
	if(id.value.length != 0)
	{
	    form.action="${BasePath}/zjdiaoyan/updateTitleById.kq";
	}
	
	form.submit();
}
	
function clearError()
{
	document.getElementById("nameclear").innerHTML="";
	document.getElementById("clearA").innerHTML="";
	document.getElementById("clearB").innerHTML="";
	document.getElementById("clearC").innerHTML="";
	document.getElementById("clearD").innerHTML="";
	document.getElementById("clearE").innerHTML="";
	document.getElementById("clearF").innerHTML="";
	document.getElementById("clearG").innerHTML="";
	document.getElementById("clearH").innerHTML="";
	document.getElementById("clearI").innerHTML="";
	document.getElementById("clearJ").innerHTML="";
}
-->
</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    	<ul>
				<li class="cur"><a href="${BasePath}/zjdiaoyan/getDiaoyanList.kq">微调研</a></li>
				<li><a href="${BasePath}/zj/getSignin.kq">微签到</a></li>
   		</ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<form id="material_form" action="${BasePath}/zjdiaoyan/saveQuesstion.kq" method="post" class="r_con_form">
    <input type="hidden" name="relationDiaoyanId" id="relationDiaoyanId" value="${relationDiaoyanId}"/>
    <input type="hidden" name="id" value="<#if titleInfo??>${titleInfo.id?default("")}</#if>"/> 
    <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
    <div class="rows">
        <label>题目名称 <span class="fc_red">*</span></label>
        <span class="input">
		   <input name="name" placeholder="题目名称中文英文数字都可，长度不超过60个字符" onKeyUp="javascript:clearError();" value="<#if titleInfo??>${titleInfo.questionName?default("")}</#if>" type="text" class="form_input" size="50" maxlength="60" notnull>
		   <div id="nameclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>选项A <span class="fc_red">*</span></label>
        <span class="input">
	        <input name="selectA" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();" value="<#if titleInfo??>${titleInfo.selectA?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
	        <div id="clearA" style="color:#F00;"></div>
	        <input type="hidden" name="selectAid" value="<#if titleInfo??>${titleInfo.selectAid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项B <span class="fc_red">*</span></label>
        <span class="input">
        	<input name="selectB" id="selectB" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectC')" value="<#if titleInfo??>${titleInfo.selectB?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearB" style="color:#F00;"></div>
        	<input type="hidden" name="selectBid" value="<#if titleInfo??>${titleInfo.selectBid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
	
	<div class="rows">
        <label>选项C</label>
        <span class="input">
        	<input name="selectC" id="selectC" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectD')" value="<#if titleInfo??>${titleInfo.selectC?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearC" style="color:#F00;"></div>
        	<input type="hidden" name="selectCid" value="<#if titleInfo??>${titleInfo.selectCid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>选项D</label>
        <span class="input">
        	<input name="selectD" id="selectD" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectE')" value="<#if titleInfo??>${titleInfo.selectD?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearD" style="color:#F00;"></div>
        	<input type="hidden" name="selectDid" value="<#if titleInfo??>${titleInfo.selectDid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项E</label>
        <span class="input">
        	<input name="selectE" id="selectE" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectF')" value="<#if titleInfo??>${titleInfo.selectE?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearE" style="color:#F00;"></div>
        	<input type="hidden" name="selectEid" value="<#if titleInfo??>${titleInfo.selectEid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项F</label>
        <span class="input">
        	<input name="selectF" id="selectF" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectG')" value="<#if titleInfo??>${titleInfo.selectF?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearF" style="color:#F00;"></div>
        	<input type="hidden" name="selectFid" value="<#if titleInfo??>${titleInfo.selectFid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项G</label>
        <span class="input">
        	<input name="selectG" id="selectG" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectH')" value="<#if titleInfo??>${titleInfo.selectG?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearG" style="color:#F00;"></div>
        	<input type="hidden" name="selectGid" value="<#if titleInfo??>${titleInfo.selectGid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项H</label>
        <span class="input"> 
        	<input name="selectH" id="selectH" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectI')" value="<#if titleInfo??>${titleInfo.selectH?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearH" style="color:#F00;"></div>
        	<input type="hidden" name="selectHid" value="<#if titleInfo??>${titleInfo.selectHid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项I</label>
        <span class="input">
        	<input name="selectI" id="selectI" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();changeShow(this.value,'selectJ')" value="<#if titleInfo??>${titleInfo.selectI?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearI" style="color:#F00;"></div>
        	<input type="hidden" name="selectIid" value="<#if titleInfo??>${titleInfo.selectIid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>选项J</label>
        <span class="input">
        	<input name="selectJ" id="selectJ" disabled="true" placeholder="长度不超过16个字符" onKeyUp="javascript:clearError();" value="<#if titleInfo??>${titleInfo.selectJ?default("")}</#if>" type="text" class="form_input" size="50" maxlength="16" notnull>
        	<div id="clearJ" style="color:#F00;"></div>
        	<input type="hidden" name="selectJid" value="<#if titleInfo??>${titleInfo.selectJid?default("")}</#if>"/>
        </span>
        <div class="clear"></div>
    </div>	
    
    <div class="rows">
        <label>最多能选几个答案 <span class="fc_red">*</span></label>
        <span class="input">
        	<select id="limit" name="limit">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
        </span>
        <div class="clear"></div>
    </div>	

    <div class="rows">
        <label></label>
        <span class="input">
             <input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="保存" />
             <a href="javascript:history.go(-1); " class="btn_gray">返回</a>  
        </span>
        <div class="clear"></div>
    </div>
    <input type="hidden" name="titleHid" value="<#if titleInfo??>${titleInfo.anwserMaxNum?default("")}</#if>"/>
   </form>
</div>

</body>

<script>
function init()
{
   $("[id^=select]").each(function(){
       if($(this).val() != "")
       {
           $(this).attr("disabled",false);
       }
   });
   changeShow($("[id^=select][disabled!=disabled]:last").val(),$("[id^=select][disabled=disabled]:first").attr("id"));
   
   var limit = document.forms[0].titleHid.value;
   if(limit != "")
   {
      $("#limit option[value="+limit+"]").attr("selected",true);
   }
   
 }
 
 init();  
</script>
</html>