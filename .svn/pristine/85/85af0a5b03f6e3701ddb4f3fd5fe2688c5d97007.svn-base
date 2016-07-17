<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js?t=2013122302'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<script>
function checkNum(num)
{
   var number = /^\d+$/;
   return number.test(num);
}

	function checkinput()
	{
		var form = document.getElementById("zhaopin_form");
		
		var name = form.name;
		if(name.value.length==0){
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入优惠券名称";
			return;
		}
		
		
		var money = form.money;
		if(money.value.length==0){
			var moneyclear = document.getElementById("moneyclear");
			money.focus();
			moneyclear.innerHTML="请输入优惠劵金额";
			return;
		}
		
		var starttime = form.starttime;
		if(starttime.value.length==0){
			var timeclear = document.getElementById("timeclear");
			starttime.focus();
			timeclear.innerHTML="请输入优惠券使用开始时间";
			return;
		}
		
		var endtime = form.endtime;
		if(endtime.value.length==0){
			var timeclear = document.getElementById("timeclear");
			endtime.focus();
			timeclear.innerHTML="请输入优惠券使用结束时间";
			return;
		}
		
		
		var sum = form.sum;
		if(sum.value.length==0){
			var sumclear = document.getElementById("sumclear");
			sum.focus();
			sumclear.innerHTML="请输入优惠券张数";
			return;
		}
		if(!checkNum(sum.value)){
			var sumclear = document.getElementById("sumclear");
			sum.focus();
			sumclear.innerHTML="请输入正确的优惠券张数";
			return;
		}
		
		var usablerange = form.usablerange;
		if(usablerange.value.length==0){
			var usablerangeclear = document.getElementById("usablerangeclear");
			usablerange.focus();
			usablerangeclear.innerHTML="请输入优惠券使用范围";
			return;
		}
		
		if(!checkNum(usablerange.value)){
			var usablerangeclear = document.getElementById("usablerangeclear");
			usablerange.focus();
			usablerangeclear.innerHTML="请输入正确的优惠券使用范围";
			return;
		}
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("moneyclear").innerHTML="";
		document.getElementById("timeclear").innerHTML="";
		document.getElementById("sumclear").innerHTML="";
		document.getElementById("usablerangeclear").innerHTML="";
	}

</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
				<li class="cur"><a href="${BasePath}/zj/getCoupon.kq">优惠券</a></li>
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="${BasePath}/zj/addCoupon.kq" method="post" class="r_con_form">
    <input name="id" type="hidden" value="<#if zhaopin??>${zhaopin.id}</#if>"/>
    <div class="rows">
        <label>优惠券名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" placeholder="优惠券名称" onKeyUp="javascript:clearError();" value="<#if zhaopin??>${zhaopin.name?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" notnull>
	<div id="nameclear" style="color:#F00;"></div>
	</span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>金额 <span class="fc_red">*</span></label>
        <span class="input"><input name="money" placeholder="优惠劵金额" onKeyUp="javascript:clearError();" value="<#if zhaopin??>${zhaopin.age?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
        <div id="moneyclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>有效期 <span class="fc_red">*</span></label>
        <span class="input">
        	<input name="starttime" placeholder="开始时间" onChange="javascript:clearError();" value="<#if zhaopin??>${zhaopin.endtime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();" readonly notnull>
        	至
        	<input name="endtime" placeholder="结束时间"  onChange="javascript:clearError();" value="<#if zhaopin??>${zhaopin.endtime?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull onclick="javascript:WdatePicker();" readonly notnull>
        <div id="timeclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>数量 <span class="fc_red">*</span></label>
        <span class="input"><input name="sum" placeholder="优惠券张数" onKeyUp="javascript:clearError();" value="<#if zhaopin??>${zhaopin.pay?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
        <div id="sumclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>是否参与积分兑换 <span class="fc_red"></span></label>
        <span class="input"><input name="type" placeholder="是否参与积分兑换" value="1" type="checkbox" class="form_input" notnull>参与(不显示在微官网优惠券中，显示在积分兑换中)
        </span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>是否限制领取 <span class="fc_red"></span></label>
        <span class="input"><input name="islimit" placeholder="是否限制领取" value="1" type="checkbox" class="form_input" notnull>不限制
        </span>
        <div class="clear"></div>
    </div>
    
     <div id="memberleveldiv" class="rows" style="display:">
        <label>可参与的会员级别 <span class="fc_red">*</span></label>
        <span class="input">
        	<select name='memberlevel' id='memberlevel'>
        						<option value="">不限制</option>
								<#if memberlevellist?? && (memberlevellist?size>0) >
	      						<#list memberlevellist as memberlevel>
	      							<option value="${memberlevel.id?default('')}" >${memberlevel.name?default("")}</option>
	      						</#list>
	      						</#if>
			</select> <span class="tips"><a href="${BasePath}/zj/getMemberlevel.kq" class="material">会员等级管理</a></span>
        </span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>使用范围 <span class="fc_red">*</span></label>
        <span class="input">
        	买满<input name="usablerange" placeholder="优惠券使用范围" onKeyUp="javascript:clearError();" value="<#if zhaopin??>${zhaopin.pay?default("")}</#if>" type="text" class="form_input" size="20" maxlength="15" notnull>可使用
        	<!--<textarea name="usablerange" placeholder="优惠券使用范围" onKeyUp="javascript:clearError();"><#if zhaopin??>${zhaopin.description?default("")}</#if></textarea>-->
        <div id="usablerangeclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="<#if type?? && type=='mod'>修改<#else>立即生成</#if>保存" />
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