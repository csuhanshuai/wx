<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

<script type="text/javascript">
	var BasePath="${BasePath}"; 	
	var bid = "${bid}";
</script>

</head>

<body>
<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li><a href="${BasePath}/turentableManage/toTurentableConfig.kq">大转盘</a></li>
				<li class="cur"><a href="${BasePath}/zj/getCoupon.kq">优惠券</a></li>
				<li><a href="${BasePath}/turentableManage/toWinners.kq">中奖信息</a></li>
				<li><a href="${BasePath}/zj/getActivities.kq">活动发布</a></li>
				<li><a href="${BasePath}/zj/getIntegralexchange.kq">积分兑换</a></li>
				<li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=1">活动报名</a></li>
                <li><a href="${BasePath}/zj/getSalespromotion.kq">促销活动</a></li>
   </ul>
</div>


<div id="wechat_zhaopin" class="r_con_wrap">
<form id="huodong_form" action="${BasePath}/zjhuodong/zjminweb/addBaoming.kq" method="post" class="r_con_form">
    <input type="hidden" name="id" value="<#if baoming??>${baoming.id?default("")}</#if>"/>
    <input type="hidden" name="activitiesid" value="<#if baoming??>${baoming.activitiesid?default("")}</#if>"/>
     <input type="hidden" name="bid" value="${bid}"/>
    <div class="rows">
        <label>
            联系人<span class="fc_red">*</span>
        </label>
        <span class="input">
		    <input name="name" placeholder="联系人姓名" onKeyUp="javascript:clearError();" value="<#if baoming??>${baoming.name?default("")}</#if>" type="text" class="form_input" size="50" maxlength="18" notnull>
		    <div id="nameclear" style="color:#F00;"></div>
	    </span>
        <div class="clear"></div>
    </div>
    <div class="rows">
        <label>
           联系电话<span class="fc_red">*</span>
        </label>
        <span class="input">
           <input name="mobile" placeholder="联系电话" onKeyUp="javascript:clearError();" value="<#if baoming??>${baoming.mobile?default("")}</#if>" type="text" class="form_input" size="50" maxlength="32" notnull>
           <div id="mobileclear" style="color:#F00;"></div>
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
    <script language="javascript">
		if("oklab"=="${oklab?default('')}")
				alert("提交成功！")
    </script>
   </form>
</div>
</body>
<script>
    var flag = false;
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
		var form = document.getElementById("huodong_form");
		
		var name = form.name;
		if(name.value.length==0)
		{
			var nameclear = document.getElementById("nameclear");
			name.focus();
			nameclear.innerHTML="请输入您的真实姓名";
			return;
		}
		
		var mobile = form.mobile;
		if(mobile.value.length==0 || !checkTel(mobile.value))
		{
		    alert("请输入正确的手机号", 1500);
	  	    return;
	    }
	    
	    $.ajax({
		    url:BasePath+"/zjhuodong/zjminweb/checkMobile.kq?mobile="+form.mobile.value + "&bid="+bid,
			type:"post",
			async:false,
			timeout:1000,
			success:function(result)
			{
			    if(result == 'exist')
			    {
                   alert("该号码已经报名！");
                   flag = true;
                }
                else if(result == 'noExist')
                {
                   flag = false;
                }
			   
			}
		});
		
		if(flag)
		{
		   return;
		}
		
		var id = form.id;
		if(id.value.length == 0)
		{
		    form.action = "${BasePath}/zjhuodong/zjminweb/addBaoming.kq";
		}
		else
		{
		    form.action = "${BasePath}/zjhuodong/updateBaomingById.kq";
		}
		form.submit();
	}
	
	function clearError()
	{
		document.getElementById("nameclear").innerHTML="";
		document.getElementById("mobileclear").innerHTML="";
	}

</script>
</html>