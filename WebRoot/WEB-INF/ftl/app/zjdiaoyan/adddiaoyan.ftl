<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript">
	var bid="${bid}"; 	
	var BasePath="${BasePath}"; 	
	var selectHtmlStr = "${selectHtmlStr}";
</script>
<link rel="stylesheet" href="${BasePath}/css/app/bootstrap.min.css" />
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src="${BasePath}/js/bootstrap.min.js"></script>
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

function checkinput()
{
	var form = document.getElementById("material_form");
	
	var name = form.name;
	if(name.value.length==0){
		var nameclear = document.getElementById("nameclear");
		name.focus();
		nameclear.innerHTML="请输入活动名称";
		return;
	}
	
	
	var starttime = form.starttime;
	if(starttime.value.length==0){
		var timeclear = document.getElementById("timeclear");
		starttime.focus();
		timeclear.innerHTML="请输入活动开始时间";
		return;
	}
	
	var endtime = form.endtime;
	if(endtime.value.length==0){
		var timeclear = document.getElementById("timeclear");
		endtime.focus();
		timeclear.innerHTML="请输入活动结束时间";
		return;
	}
	
	
	var keyword = form.keyword;
	if(keyword.value.length==0){
		var keywordclear = document.getElementById("keywordclear");
		keyword.focus();
		keywordclear.innerHTML="请输入活动关键词";
		return;
	}
	
	
	var id = form.id;
	if(id.value.length != 0)
	{
	    form.action="${BasePath}/zjdiaoyan/udpatediaoyan.kq";
	}

	form.submit();
}
	
function clearError()
{
	document.getElementById("nameclear").innerHTML="";
	document.getElementById("timeclear").innerHTML="";
	document.getElementById("keywordclear").innerHTML="";
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
   		</ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<form id="material_form" action="${BasePath}/zjdiaoyan/addDiaoyan.kq" method="post" class="r_con_form">
    <input type="hidden" name="id" value="<#if diaoyan??>${diaoyan.id?default("")}</#if>" /> 
    <input type="hidden" name="relationActive" id="relationActive" value="<#if diaoyan??>${diaoyan.relationActive?default("")}</#if>"/>
    <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
    <div class="rows">
        <label>活动名称 <span class="fc_red">*</span></label>
        <span class="input">
		<input name="name" placeholder="活动名称" onKeyUp="javascript:clearError();" value="<#if diaoyan??>${diaoyan.activeName?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" notnull>
		<div id="nameclear" style="color:#F00;"></div>
		</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>图文消息封面<span class="fc_red">*</span></label>
        <span class="input">
	        <div>          
               <input name="FileUpload" id="MsgFileUpload" type="file" style="display: none;">
               <input type="hidden" name="ImgPath" value="<#if diaoyan??>${diaoyan.imgPath?default("")}</#if>">
            </div>
            <div class="img" id="MsgImgDetail"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>有效期 <span class="fc_red">*</span></label>
        <span class="input">
        	<input name="starttime" placeholder="开始时间" onChange="javascript:clearError();" value="<#if diaoyan??>${diaoyan.activeStartTime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();"  notnull>
        	至
        	<input name="endtime" placeholder="结束时间"  onChange="javascript:clearError();" value="<#if diaoyan??>${diaoyan.activeEndTime?default("2014-06-30")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();"  notnull>
            <div id="timeclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>活动回复关键词 <span class="fc_red">*</span></label>
        <span class="input">
	        <input name="keyword" placeholder="活动回复关键词" onKeyUp="javascript:clearError();" value="<#if diaoyan??>${diaoyan.keyword?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
	        <div id="keywordclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>活动说明 </label>
        <span class="input">
        	<textarea name="remark" placeholder="活动说明" onKeyUp="javascript:clearError();"><#if diaoyan??>${diaoyan.remark?default("")}</#if></textarea>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows" style="display:none">
        <br>
  		<span>关联抽奖活动(用户参与调研完成后可以直接参加刮刮奖或大转盘活动)</span>
	    <div class="controls">
		    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
		        <thead>
		            <tr>
		                <td  nowrap="nowrap">活动名称</td>
		                <td  nowrap="nowrap">活动时间</td>
		                <td  nowrap="nowrap" class="last">操作</td>
		            </tr>
		        </thead>
		        <tbody id="selectHuodong">
	                 ${selectHtmlStr}
				</tbody>
			</table>
			<div  class="emptytext" align="right" id="relationLj">
			    目前没有关联营销活动，<a href="#" id="activity-btn" onclick="getHudongList()">点击此处</a>选择	
			</div>    
	    </div>	
	    <br />			    
	</div>
			

    <div class="rows">
        <label></label>
        <span class="input">
            <#if type??&&type=="view">
              <a href="javascript:history.go(-1); " class="btn_gray">返回</a>  
            <#else>
               <#if diaoyan?? && diaoyan.id !="">
                   <input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="保存" />
               <#else>
                    <input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="保存并设置题目" />
               </#if>
               <a href="javascript:history.go(-1); " class="btn_gray">取消</a>    
           </#if>
           
        </span>
        <div class="clear"></div>
    </div>
    <script language="javascript">
		if("oklab"=="${oklab?default('')}")
				alert("提交成功！")
    </script>
   </form>
</div>

<div id="act_choice_dialog" class="modal hide">
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    <h4>以下是符合条件的营销活动</h4>	  
		</div>
		<div class="info alert alert-info">
			<p>注意：营销活动的开始时间必须比当前活动早，并且结束时间比当前活动晚</p>
		</div>
		<div class="modal-body">
		   <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
	        <thead>
	            <tr>
	                <td  nowrap="nowrap">活动名称</td>
	                <td  nowrap="nowrap">活动时间</td>
	                <td  nowrap="nowrap" class="last">操作</td>
	            </tr>
	        </thead>
	        <tbody id="relationHd">
	          
			</tbody>
		</table>
		</div>
</div>
</body>
<script>
var type="${type}";
if(type == "view")
{
     $("#relationLj").hide();
}
function hideDIV(id)
{
    $("#act_choice_dialog").modal("hide");
    $("#relationLj").hide();
    $("#td_"+id).html("<a href='#' onclick='deleRelation()'>[删除关联]</a>");
    $("#selectHuodong").html($("#relationHd").html());
    $("#relationActive").val(id);
    alert(document.getElementById("relationActive").value);
       
}

function deleRelation()
{
    $("#selectHuodong").html("");
    $("#relationActive").val('');
}

if(selectHtmlStr != "")
{
   $("#selectHuodong").html(selectHtmlStr);
}

function getHudongList()
{
     $.ajax(
	        {
				    url:BasePath+"/zjdiaoyan/getRelationHuodong.kq",
					type:"post",
					async:false,
					timeout:1000,
					success:function(result)
					{
					    $("#relationHd").html(result);
						$("#act_choice_dialog").modal("show");
					}
    });
}
	
</script>
</html>