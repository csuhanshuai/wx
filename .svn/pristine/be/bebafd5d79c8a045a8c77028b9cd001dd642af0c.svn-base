<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>

<script LANGUAGE="Javascript" SRC="${BasePath}/js/ckeditor/ckeditor.js"></script>

<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<script>
	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入岗位名称";
			return;
		}
		
		
		var endtime = form.endtime;
		if(endtime.value.length==0){
			var endtimeclear = document.getElementById("endtimeclear");
			endtime.focus();
			endtimeclear.innerHTML="请输入岗位发布结束日期";
			return;
		}
		
		var age = form.age;
		if(age.value.length==0){
			var ageclear = document.getElementById("ageclear");
			age.focus();
			ageclear.innerHTML="请输入岗位年龄要求";
			return;
		}
		
		var workingplace = form.workingplace;
		if(workingplace.value.length==0){
			var workingplaceclear = document.getElementById("workingplaceclear");
			workingplace.focus();
			workingplaceclear.innerHTML="请输入工作地点";
			return;
		}
		
		var pay = form.pay;
		if(pay.value.length==0){
			var payclear = document.getElementById("payclear");
			pay.focus();
			payclear.innerHTML="请输入薪资待遇";
			return;
		}
		
		var numbers = form.numbers;
		if(numbers.value.length==0){
			var numbersclear = document.getElementById("numbersclear");
			numbers.focus();
			numbersclear.innerHTML="请输入招聘人数";
			return;
		}
		
		var workingnum = form.workingnum;
		if(workingnum.value.length==0){
			var workingnumclear = document.getElementById("workingnumclear");
			workingnum.focus();
			workingnumclear.innerHTML="请输入岗位年限要求";
			return;
		}
		
		var description = CKEDITOR.instances.description;
		
		if(description.getData().length==0){
			var descriptionclear = document.getElementById("descriptionclear");
			description.focus();
			descriptionclear.innerHTML="请输入岗位描述信息";
			return;
		}
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("endtimeclear").innerHTML="";
		document.getElementById("ageclear").innerHTML="";
		document.getElementById("workingplaceclear").innerHTML="";
		document.getElementById("payclear").innerHTML="";
		document.getElementById("numbersclear").innerHTML="";
		document.getElementById("workingnumclear").innerHTML="";
		document.getElementById("descriptionclear").innerHTML="";
	}

</script>
<script type="text/javascript">
	window.onload = function() {
		CKEDITOR.replace('description');
	};
</script>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">图文管理</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<!--<div class="tips_info">
    岗位名称、基本要求（学历、截止时间、性别、年龄、工作地点、待遇）、岗位描述。<br />
</div>-->
<form id="zhaopin_form" action="<#if type?? && type=='mod'>${BasePath}/zj/updateZhaopin.kq<#else>${BasePath}/zj/addZhaopin.kq</#if>" class="r_con_form" method="post">
    <#if zhaopin?? && type?? && type=='mod'>
    <input name="id" type="hidden" value="${zhaopin.id}"/>
    </#if>
    <div class="rows">
        <label>岗位名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" value="<#if zhaopin??>${zhaopin.name?default("")}</#if>" type="text" placeholder="岗位名称" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
	<div id="nameclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>学历 <span class="fc_red">*</span></label>
        <span class="input">
            <!--<input name="education" value="" type="text" class="form_input" size="50" maxlength="32" notnull>-->
                <select name="education">
                    <option value="1" selected>不限</option>
                    <option value="2">中专</option>
                    <option value="3" >大专</option>
                    <option value="4" >本科</option>
                    <option value="5" >硕士</option>
                </select>以上
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>截止时间 <span class="fc_red">*</span></label>
        <span class="input"><input name="endtime" value="<#if zhaopin??>${zhaopin.endtime?default("")}</#if>" type="text" placeholder="岗位发布截止时间" class="form_input" size="50" maxlength="15" notnull onclick="javascript:WdatePicker();" onChange="javascript:clearError();" readonly notnull>
        <div id="endtimeclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>性别 <span class="fc_red">*</span></label>
        <span class="input">
        	<!--<input name="sex" value="" type="text" class="form_input" size="50" maxlength="32" notnull>-->
        	<select name="sex">
                    <option value="1" selected>不限</option>
                    <option value="2" >男</option>
                    <option value="3" >女</option>
            </select>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>年龄 <span class="fc_red">*</span></label>
        <span class="input"><input name="age" value="<#if zhaopin??>${zhaopin.age?default("")}</#if>" type="text" placeholder="年龄要求" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="ageclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>工作地点 <span class="fc_red">*</span></label>
        <span class="input"><input name="workingplace" value="<#if zhaopin??>${zhaopin.workingplace?default("")}</#if>" type="text" placeholder="工作地点" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="workingplaceclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>待遇 <span class="fc_red">*</span></label>
        <span class="input"><input name="pay" value="<#if zhaopin??>${zhaopin.pay?default("")}</#if>" type="text" placeholder="岗位薪资待遇" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="payclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>招聘人数 <span class="fc_red">*</span></label>
        <span class="input"><input name="numbers" value="<#if zhaopin??>${zhaopin.numbers?default("")}</#if>" type="text" placeholder="招聘人数" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="numbersclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>工作年限 <span class="fc_red">*</span></label>
        <span class="input"><input name="workingnum" value="<#if zhaopin??>${zhaopin.workingnum?default("")}</#if>" type="text" placeholder="工作年限" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="workingnumclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>雇佣形式  <span class="fc_red">*</span></label>
        <span class="input">
        	<select name="workingtype">
                    <option value="0">不限</option>
                    <option value="1" selected>全职</option>
                    <option value="2" >兼职</option>
            </select>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>岗位描述 <span class="fc_red">*</span></label>
        <span class="input">
        	<!--<input name="description" value="<#if zhaopin??>${zhaopin.description?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>-->
        	<textarea name="description" onKeyUp="javascript:clearError();" placeholder="岗位描述"><#if zhaopin??>${zhaopin.description?default("")}</#if></textarea>
        	<div id="descriptionclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="<#if type?? && type=='mod'>修改<#else>提交</#if>保存" />
        <a href="javascript:history.go(-1); " class="btn_gray">返回</a></span>
        <div class="clear"></div>
    </div>
    <script language="javascript">
		if("oklab"=="${oklab?default('')}")
				alert("提交成功！")
    </script>
   </form>
</div>

</body>
</html>