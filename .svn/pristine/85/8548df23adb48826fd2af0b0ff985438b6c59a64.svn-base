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
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
</script>
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
			nameclear.innerHTML="请输入积分兑换条目的名称";
			return;
		}
		
		var score = form.score;
		if(score.value.length==0){
			var scoreclear = document.getElementById("scoreclear");
			score.focus();
			scoreclear.innerHTML="请输入兑换积分分值";
			return;
		}
		
		
		if(!checkNum(score.value)){
			var scoreclear = document.getElementById("scoreclear");
			score.focus();
			scoreclear.innerHTML="请输入正确的兑换积分分值";
			return;
		}
		
		var validity = form.validity;
		if(validity.value.length==0){
			var validityclear = document.getElementById("validityclear");
			validity.focus();
			validityclear.innerHTML="请输入截至日期";
			return;
		}
		
		
		var sum = form.sum;
		if(sum.value.length==0){
			var sumclear = document.getElementById("sumclear");
			sum.focus();
			sumclear.innerHTML="请输入数量";
			return;
		}
		if(!checkNum(sum.value)){
			var sumclear = document.getElementById("sumclear");
			sum.focus();
			sumclear.innerHTML="请输入正确的数量";
			return;
		}
		
		var description = CKEDITOR.instances.description;
		
		if(description.getData().length==0){
			var descriptionclear = document.getElementById("descriptionclear");
			description.focus();
			descriptionclear.innerHTML="请输入积分兑换内容描述信息";
			return;
		}
		
		
		
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("scoreclear").innerHTML="";
		document.getElementById("sumclear").innerHTML="";
		document.getElementById("validityclear").innerHTML="";
		document.getElementById("descriptionclear").innerHTML="";
	}
	
	
	
	function setValue()
	{
		if($("#type111 :selected").val() != '0' && $("#type111 :selected").val() != '-1' && $("#type111 :selected").val() != '2' && $("#type111 :selected").val() != '3')
		{
			var couponvalidityend= $("#type111 :selected").attr("couponvalidityend");
			var couponsum= $("#type111 :selected").attr("couponsum");
			var islimit= $("#type111 :selected").attr("islimit");
			
			document.getElementById("validity").value=couponvalidityend;
			document.getElementById("validity").readOnly = true;
			$("#validity").attr("onclick","");
			document.getElementById("sum").value=couponsum;
			document.getElementById("sum").readOnly = true;
			if(islimit == '1')
			{
				document.getElementById("islimit").checked = true;
			}
			document.getElementById("islimit").disabled="disabled";
			
			
			
			
			
			
			
			
		
		}
		else
		{
			document.getElementById("validity").readOnly = false;
			document.getElementById("sum").readOnly = false;
			document.getElementById("islimit").disabled="";
			$("#validity").attr("onclick","javascript:WdatePicker();");
			
			
			
			
			
			
			
			
		}
		
		
		
		
		var memberlevelid= $("#type111 :selected").attr("memberlevelid");
		
		if("undefined" == typeof memberlevelid)
		{
			memberlevelid = '';
		
		}
		
		$("#memberlevel").empty();
			
			$.ajax({
				url: BasePath+"/zj/getMemberlevelByid.kq?id="+memberlevelid,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var response = eval("(" +result+")" );
	    		    if(response.result == 'success'){
	    		    	
	    		    	var t = response.t;
	    		    	if(t)
	    		    	{
	    		    		if(memberlevelid)
	    		    		{
	    		    			$("#memberlevel").append("<option value='"+t.id+"'>"+t.name+"</option>");
	    		    		}
	    		    		else
	    		    		{
	    		    			$("#memberlevel").append("<option value=''>不限制</option>");
		    		    		for(var i in t)
		    		    		{
		    		    			
		    		    			$("#memberlevel").append("<option value='"+t[i].id+"'>"+t[i].name+"</option>");
		    		    		}
	    		    		}
	    		    		
	    		    	}
	    		    	else
	    		    	{
	    		    		$("#memberlevel").append("<option value=''>不限制</option>");
	    		    		
	    		    	}
					}
	    		    else
	    		    {
	    		    	$("#memberlevel").append("<option value=''>不限制</option>");
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
			});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if($("#type111 :selected").val() == '-1' || $("#type111 :selected").val() == '2' || $("#type111 :selected").val() == '3')
		{
			document.getElementById("imgurldiv").style.display="";
			document.getElementById("activitiesiddiv").style.display="";
			
			var activitiestype = '';
			if($("#type111 :selected").val() == '-1')
			{
				//大转盘
				activitiestype = '4';
			}
			
			if($("#type111 :selected").val() == '2')
			{
				//刮刮卡
				activitiestype = '3';
			}
			
			if($("#type111 :selected").val() == '3')
			{
				//摇一摇
				activitiestype = '2';
			}
			
			$("#activitiesid").empty();
			
			//根据不同的类型获取不同类型的活动列表
			$.ajax({
				url: BasePath+"/zj/getActivitiesBytype.kq?activitiestype=" + activitiestype,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var response = eval("(" +result+")" );
	    		    if(response.result == 'success'){
	    		    	
	    		    	var t = response.t;
	    		    	if(t)
	    		    	{
	    		    		for(var i in t)
	    		    		{
	    		    			
	    		    			$("#activitiesid").append("<option value='"+t[i].id+"'>"+t[i].name+"</option>");
	    		    		}
	    		    	}
	    		    	else
	    		    	{
	    		    		$("#activitiesid").append("<option value='0' selected>暂无活动</option>");
	    		    		
	    		    	}
					}
	    		    else
	    		    {
	    		    	$("#activitiesid").append("<option value='0' selected>暂无活动</option>");
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
			});
			
			
			
		}
		else
		{
			document.getElementById("imgurldiv").style.display="";
			document.getElementById("activitiesiddiv").style.display="none";
		}
		//var objS = document.getElementById("type111");
		//var couponvalidityend = objS.options[objS.selectedIndex].couponvalidityend;
		//var couponsum = objS.options[objS.selectedIndex].couponsum;
		//alert(couponvalidityend);
	
		
		if($("#type111 :selected").val() == '0')
		{
			document.getElementById("giftdiv").style.display="";
			
			$("#giftid").empty();
			$.ajax({
				url: BasePath+"/zj/getGiftListBybid.kq",
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var response = eval("(" +result+")" );
	    		    if(response.result == 'success'){
	    		    	
	    		    	var t = response.t;
	    		    	if(t)
	    		    	{
	    		    		$("#giftid").append("<option value=''>请选择奖品</option>");
	    		    		for(var i in t)
	    		    		{
	    		    			
	    		    			$("#giftid").append("<option value='"+t[i].id+"'>"+t[i].name+"</option>");
	    		    		}
	    		    	}
	    		    	else
	    		    	{
	    		    		$("#giftid").append("<option value=''>暂无奖品</option>");
	    		    		
	    		    	}
					}
	    		    else
	    		    {
	    		    	$("#giftid").append("<option value=''>暂无奖品</option>");
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
			});
			
			
		}
		else
		{
			document.getElementById("giftdiv").style.display="none";
		}
		
		
	}
	
	
	
	
	
	
	function getGiftnumber()
	{
	
	
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("scoreclear").innerHTML="";
		document.getElementById("sumclear").innerHTML="";
		document.getElementById("validityclear").innerHTML="";
		document.getElementById("descriptionclear").innerHTML="";
	
	
	
	
	
		var num = $("#sum").val();
		
		var giftid = $("#giftid :selected").val();
		
		if($("#type111 :selected").val() == '0')
		{
		
			if(!giftid)
			{
				$("#sum").val('0');
				alert("请选择对应的奖品");
				return ;
			}
			if(!checkNum(num))
			{
				$("#sum").val(num.replace(/[^\d]/g,''));
			}
			else
			{
				//根据不同的类型获取不同类型的活动列表
				$.ajax({
					url: BasePath+"/zj/getGiftByid.kq?id="+giftid,
		    		    type: "POST",
		    		    date: "",
		    		    datetype: "json",
		    		    async: false,
		    		    timeout: 1000,
					success: function(result){
		    		    var response = eval("(" +result+")" );
		    		    if(response.result == 'success'){
		    		    	
		    		    	var t = response.t;
		    		    	if(t)
		    		    	{
		    		    		if(t.number < num)
		    		    		{
		    		    			//截取长度
		    		    			if(num.length > 1)
		    		    			{
		    		    				$("#sum").val(num.substring(0,num.length-1));
		    		    			}
		    		    			else
		    		    			{
		    		    				$("#sum").val('0');
		    		    			}
		    		    			alert("该奖品总数为："+t.number+"，请重新输入！");
		    		    		}
		    		    		
		    		    		
		    		    	}
		    		    	else
		    		    	{
								$("#sum").val('0');
		    		    		alert("请重新选择奖品");
								return ;
		    		    		
		    		    	}
						}
		    		    else
		    		    {
							$("#sum").val('0');
		    		    	alert("请重新选择奖品");
							return ;
		    		    }	
		    		    	
		    		    },
		    		    error: function(){
		    		    	alert('操作失败!');
		    		    }
				});
			}
		
		}
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
	<li class="cur"><a href="${BasePath}/zj/getIntegralexchange.kq">积分兑换</a></li>
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
<form id="zhaopin_form" action="${BasePath}/zj/addIntegralexchange.kq" class="r_con_form" method="post" enctype="multipart/form-data">
    <div class="rows">
        <label>积分兑换条目名称 <span class="fc_red">*</span></label>
        <span class="input">
	<input name="name" value="" type="text" placeholder="积分兑换条目名称" class="form_input" size="50" maxlength="18" onKeyUp="javascript:clearError();" notnull>
	<div id="nameclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    
    <div class="rows">
        <label>兑换积分分值 <span class="fc_red">*</span></label>
        <span class="input"><input name="score" value="<#if zhaopin??>${zhaopin.numbers?default("")}</#if>" type="text" placeholder="兑换的积分分值" class="form_input" size="50" maxlength="32" onKeyUp="javascript:clearError();" notnull>
        <div id="scoreclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>类型 <span class="fc_red">*</span></label>
        <span class="input">
        	<select name='type' id='type111' onChange="javascript:setValue();">
				<option value='0' selected>礼品券</option>
				<optgroup label='---优惠券--'></optgroup>
				<#if couponlist?? && (couponlist?size>0) >
					<#list couponlist as item>
						<option value='${item.id?default("")}' couponvalidityend='${item.validityend?string("yyyy-MM-dd")}' couponsum='${item.sum?default("")}' islimit='${item.islimit?default("")}' memberlevelid='${item.memberlevelid?default("")}'>${item.name?default("")}</option>
					</#list>				  	
				</#if>  
				<option value='-1'>大转盘</option>
				<option value='2'>刮刮卡</option>
				<option value='3'>摇一摇</option>
			</select> <span class="tips">1.选择关联的优惠券时，务必保证'有效期'、'数量'和'是否限制兑换'一致；</span>
        </span>
        <div class="clear"></div>
    </div>
    
    <div id="activitiesiddiv" class="rows" style="display:none">
        <label>对应的活动 <span class="fc_red">*</span></label>
        <span class="input">
        	<select name='activitiesid' id='activitiesid'>
				
			</select> <span class="tips"><a href="${BasePath}//zj/addActivitiesForward.kq" class="material">活动发布</a></span>
        </span>
        <div class="clear"></div>
    </div>
    
    <div id="giftdiv" class="rows" style="display:">
        <label>对应的奖品 <span class="fc_red">*</span></label>
        <span class="input">
        	<select name='giftid' id='giftid'>
								<#if giftlist?? && (giftlist?size>0) >
		             				<option value="">请选择奖品</option>
	      						<#list giftlist as gift>
	      							<option value="${gift.id?default('')}" >${gift.name?default("")}</option>
	      						</#list>
	      						<#else>
	      							<option value="">暂无奖品</option>
	      						</#if>
			</select> <span class="tips"><a href="${BasePath}/zj/addGiftForward.kq" class="material">增加奖品</a></span>
        </span>
        <div class="clear"></div>
    </div>
    
    <div id="imgurldiv" class="rows" style="display:">
        <label>图片 <span class="fc_red">*</span></label>
        <span class="input">
        <input name="imgurl"  id="imgurl" type="file"/>
        <div id="imgurlclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    
    <div id="islimitdiv" class="rows" style="display:">
        <label>是否限制兑换 <span class="fc_red"></span></label>
        <span class="input"><input name="islimit" id="islimit" placeholder="是否限制领取" value="1" type="checkbox" class="form_input" notnull>不限制
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
        <label>有效期截至 <span class="fc_red">*</span></label>
        <span class="input"><input name="validity" id="validity" value="" type="text" placeholder="截止时间" class="form_input" size="50" maxlength="15" notnull onclick="javascript:WdatePicker();" onChange="javascript:clearError();" readonly notnull>
        <div id="validityclear" style="color:#F00;"></div></span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>数量 <span class="fc_red">*</span></label>
        <span class="input"><input name="sum" id="sum" placeholder="兑换数量" onKeyUp="javascript:getGiftnumber();" value="<#if zhaopin??>${zhaopin.pay?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
        <div id="sumclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>
    
    
    <div class="rows">
        <label>积分兑换内容描述 <span class="fc_red">*</span></label>
        <span class="input">
        	<!--<input name="description" value="" type="text" class="form_input" size="50" maxlength="32" notnull>-->
        	<textarea name="description" onKeyUp="javascript:clearError();" placeholder="积分兑换内容描述"></textarea>
        	<div id="descriptionclear" style="color:#F00;"></div>
        </span>
        <div class="clear"></div>
    </div>

    <div class="rows">
        <label></label>
        <span class="input"><input type="button" onClick="javascript:checkinput();" class="btn_green" name="submit_button" value="提交保存" />
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