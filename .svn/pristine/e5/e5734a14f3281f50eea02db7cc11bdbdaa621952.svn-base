<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript">
	var BasePath="${BasePath}";
</script>
<link rev="stylesheet" rel="stylesheet" type="text/css" href="${BasePath}/css/thickbox.css"  media="screen" />
<script type="text/javascript"  src="${BasePath}/js/common/thickbox/thickbox.js"></script>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>
</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
		    <ul>
				<li class="cur"><a href="${BasePath}/zj/inpayForward.kq">会员充值</a></li>
				

            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">

    <form id="add_form" class="add_form " method="post" action="${BasePath}/zj/getMemberByCondition.kq" onsubmit="return false;">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
		        <td><span>会员标示：</span></td>
                <td><input placeholder="手机号/会员卡号" type="text" id="condition" name="condition" value="" size="25" class="form_input" onkeypress="javascript:enterkey();" notnull/></td>
                <td><input type="button" class="submit" value="查询" name="submit_btn" onClick="javascript:querymember();"></td>
            </tr>
        </table>
    </form>
    
    
    
    <form id="insystem" class="add_form " method="post" action="" style="display:none" onsubmit="return false;">
    	<table border="0" cellpadding="5" cellspacing="0">
            <tr>
		        <td><span>本次充值：</span></td>
                <td><input placeholder="请输入充值金额" type="text" id="money" name="money" value="" size="20" class="form_input" onkeypress="javascript:enterkeyPay();" notnull />&nbsp;&nbsp;元&nbsp;&nbsp;&nbsp;</td>
                <td><input type="button" class="submit" value="充值" name="submit_btn" onClick="javascript:inpay();"></td>
            </tr>
        </table>
    </form>
    
    
    <table id="memberinfo" border="0" cellpadding="5" cellspacing="0" class="r_con_table" style="display:none">
            <tr>
                <td colspan="4" style="padding:15px 0;background-color: #c4dff8;">会员卡号：<span nowrap="" id="cardno"></span></td>

                <input type="hidden" value="" id="memberidhidden"/>
            </tr>
            <tr>
                <td  nowrap="nowrap" >姓名：</td>
                <td><div id="membername"></div></td>
                <td  nowrap="nowrap">注册时间：</td>
                <td><div id="intime"></div></td>
            </tr>
            <tr>
                <td  nowrap="nowrap">电话：</td>
                <td><div id="membertelephone"></div></td>
                <td  nowrap="nowrap">积分：</td>
                <td><div id="integral"></div></td>
            </tr>
            <tr>
                <td nowrap="nowrap" colspan="4" style="padding:15px 10px 15px 0; text-align:right;">余额：<span id="balance" style="color:#ff0000; font-weight:bold;">20</span>&nbsp;&nbsp;&nbsp;&nbsp;
            </tr>
            
    </table>
<div class="blank20"></div>
    
	</div>  
</div>


<script>
	
	function changeDefaultValue(value)
	{
	     if(value == "0")
		 {
			 document.getElementById("condition").placeholder = "请输入会员卡号";
		 }
		 else if(value == "1")
		 {
			 document.getElementById("condition").placeholder = "请输入手机号";
		 }
	}
	
	
	function enterkey() 
    { 
        if (event.keyCode == 13)
        { 
        	querymember();
            
        }
    }
    
	function enterkeyPay() 
    { 
        if (event.keyCode == 13)
        { 
        	inpay();
            
        }
    }
    
    function showMemberInfo()
	 {
	  document.getElementById("insystem").style.display="";
		 document.getElementById("memberinfo").style.display="";
	 }
	 
	 function hiddenMemberInfo()
	 {
	  document.getElementById("insystem").style.display="none";
		 document.getElementById("memberinfo").style.display="none";
	 }
	 
	function checkFloatNum(num)
	{
	   var number = /^\d+\.?\d*$/;
	   return number.test(num);
	}
	 
	 function inpay(){
	 	var money = document.getElementById("money");
	 	var memberid = document.getElementById("memberidhidden");
	 	
	 	if(money.value.length==0)
		{
			alert("输入金额不能为空");
			return;
		}
		
		if(!checkFloatNum(money.value))
		{
			alert("输入正确的金额");
			return;
		}
	 	
	 	if(memberid.value.length==0)
		{
			alert("请确认会员ID是否存在！");
			return;
		}
	 	
    	$.ajax({
	    		    url: BasePath+"/zj/inPay.kq?money=" + money.value + "&memberid=" + memberid.value,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
	    		    success: function(result){
	    		    	var response = eval("(" +result+")" );
	    		    	if (response.result == 'success')
	    		    	{
	    		    		var balance = document.getElementById("balance");
	    		    		balance.innerHTML=response.t.balance;
	    		    		
	    		    		//清空输入框
	    		    		document.getElementById("money").value = "";
	    		    		
	    		    		alert("充值成功");
	    		    	}
	    		    	else
	    		    	{
	    		    	
	    		    		//清空输入框
	    		    		document.getElementById("money").value = "";
	    		    		
	    		    		alert(response.message);
	    		    	}
	    		    	
	    		    	
	    		    	
	    		    },
	    		    error: function(){
	    		    	
	    		    	//清空输入框
	    		    	document.getElementById("money").value = "";
	    		    		
	    		    	alert('操作失败!');
	    		    }
	    });
	    
	    showMemberInfo();
    }
	 
	 
	 
	 function querymember(){
	 
	 
	 	var condition = document.getElementById("condition");
	 	
	 	if(condition.value.length==0)
		{
			alert("输入标示不能为空");
			return;
		}
    	$.ajax({
	    		    url: BasePath+"/zj/saleman/getMemberByCondition.kq?condition=" + condition.value,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
	    		    success: function(result){
	    		    	var response = eval("(" +result+")" );
	    		    	if (response.result == 'success')
	    		    	{
	    		    		var cardno = document.getElementById("cardno");
	    		    		cardno.innerHTML=response.t.member.cardno;
	    		    		
	    		    		document.getElementById("memberidhidden").value = response.t.member.id;
	    		    		
	    		    		var membername = document.getElementById("membername");
	    		    		membername.innerHTML=response.t.member.name;
	    		    		
	    		    		var membertelephone = document.getElementById("membertelephone");
	    		    		membertelephone.innerHTML=response.t.member.telephone;
	    		    		
	    		    		var intime = document.getElementById("intime");
	    		    		intime.innerHTML=response.t.member.intime;
	    		    		
	    		    		var integral = document.getElementById("integral");
	    		    		integral.innerHTML=response.t.member.integral;
	    		    		
	    		    		var balance = document.getElementById("balance");
	    		    		balance.innerHTML=response.t.member.balance;
	    		    		
	    		    		
	    		    		showMemberInfo();
	    		    		
	    		    		
	    		    	}
	    		    	else
	    		    	{
	    		    		alert(response.message);
	    		    		hiddenMemberInfo();
	    		    	}
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
	    		});
    }
</script>
</body>
</html>