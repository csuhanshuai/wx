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
		    
				<li class="cur"><a href="${BasePath}/zj/exchangeForward.kq">兑奖管理</a></li>
				

            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">

    <form id="add_form" class="add_form " method="post" action="${BasePath}/zj/xxxx.kq" onsubmit="return false;">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
		        <td><span>兑奖编码：</span></td>
                <td><input placeholder="兑奖编码" type="text" id="exchangeid" name="exchangeid" value="" size="25" class="form_input" onkeypress="javascript:enterkeyPay();" notnull/></td>
                <td><input type="button" class="submit" value="查询" name="submit_btn" onClick="javascript:inpay();"></td>
            </tr>
        </table>
    </form>
    
    
    <!--
    <form id="insystem" class="add_form " method="post" action="" style="display:none" onsubmit="return false;">
    	<table border="0" cellpadding="5" cellspacing="0">
            <tr>
		        <td><span>本次消费：</span></td>
                <td><input placeholder="请输入消费金额" type="text" id="money" name="money" value="" size="20" class="form_input" onkeypress="javascript:enterkeyPay();" notnull />&nbsp;&nbsp;元&nbsp;&nbsp;&nbsp;</td>
                <td>
                <select name='couponrecordid' id='couponrecordid'>
								
				</select>
                <input type="button" class="submit" value="入账" name="submit_btn" onClick="javascript:inpay();">
                </td>
            </tr>
        </table>
    </form>
    -->
    
    <table id="memberinfo" border="0" cellpadding="5" cellspacing="0" class="r_con_table" style="display:none">
            <tr>
                <td colspan="4" style="padding:15px 0;background-color: #c4dff8;">礼品券来源：<span nowrap="" id="title"></span></td>

                <input type="hidden" value="" id="exchangeidhidden"/>
            </tr>
            <tr>
                <td  nowrap="nowrap" >姓名：</td>
                <td><div id="membername"></div></td>
                <td  nowrap="nowrap">电话：</td>
                <td><div id="membertelephone"></div></td>
            </tr>
            <tr>
                <td  nowrap="nowrap" >奖品名称：</td>
                <td><div id="giftname"></div></td>
                <td  nowrap="nowrap">中奖时间：</td>
                <td><div id="intime"></div></td>
            </tr>
            <tr>
                <td nowrap="nowrap">会员编号：</td>
                <td><div id="cardno"></div></td>
                <td nowrap="nowrap">兑换时间：</td>
                <td><div id="usertime"></div></td>
            </tr>
            <tr>
                <td nowrap="nowrap" colspan="4" style="padding:15px 10px 15px 0; text-align:right;">状态：&nbsp;&nbsp;&nbsp;&nbsp;<a id='inpayhref' href="javascript:inpay('doit');" ><div id="isuse">xx</div></a></td>
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
	function getConsumptionByMemberid(salesman)
	{
		var memberid = document.getElementById("memberidhidden").value;
		
		if(memberid.length==0)
		{
			alert("请确认会员ID是否存在！");
		}
		else
		{
			showThickBox("消费信息明细",BasePath+"/zj/getConsumptionByMemberid/"+salesman+"/"+memberid+".kq?TB_iframe=true&height=300&width=750",false);
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
	  //document.getElementById("insystem").style.display="";
		 document.getElementById("memberinfo").style.display="";
	 }
	 
	 function hiddenMemberInfo()
	 {
	  //document.getElementById("insystem").style.display="none";
		 document.getElementById("memberinfo").style.display="none";
	 }
	 
	function checkFloatNum(num)
	{
	   var number = /^\d+\.?\d*$/;
	   return number.test(num);
	}
	 
	 function inpay(type){
	 	var exchangeid = document.getElementById("exchangeid");
	 	var exchangeidhidden = document.getElementById("exchangeidhidden");
	 	
	 	if(exchangeid.value.length==0 && exchangeidhidden.value.length==0)
		{
			alert("输入参数不能为空");
			return;
		}
		
		var values = exchangeid.value;
		if(values.length==0)
		{
			values = exchangeidhidden.value;
		}
	 	
    	$.ajax({
	    		    url: BasePath+"/zj/exchange.kq?exchangeid=" + values + '&type=' + type,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
	    		    success: function(result){
	    		    	var response = eval("(" +result+")" );
	    		    	if (response.result == 'success')
	    		    	{
	    		    		
	    		    		//清空输入框
	    		    		document.getElementById("exchangeid").value = "";
	    		    		
	    		    		exchangeidhidden.value = response.t.id;
	    		    		
	    		    		var title = document.getElementById("title");
	    		    		var giftname = document.getElementById("giftname");
	    		    		var intime = document.getElementById("intime");
	    		    		var membername = document.getElementById("membername");
	    		    		var membertelephone = document.getElementById("membertelephone");
	    		    		var cardno = document.getElementById("cardno");
	    		    		var isuse = document.getElementById("isuse");
	    		    		var usertime = document.getElementById("usertime");
	    		    		var inpayhref = document.getElementById("inpayhref");
	    		    		
	    		    		if(!response.activities)
	    		    		{
	    		    			//是积分兑换礼品
	    		    			title.innerHTML=response.t.activities.name;
	    		    			
	    		    		}
	    		    		else if(!response.integralexchange)
	    		    		{
	    		    			//是大转盘、刮刮卡、摇一摇中奖信息
	    		    			title.innerHTML=response.t.activities.name;
	    		    			
	    		    			
	    		    		}
	    		    		giftname.innerHTML=response.t.gift.name;
	    		    		intime.innerHTML=response.t.receivetime;
	    		    			
	    		    		membername.innerHTML=response.t.member.name;
	    		    		membertelephone.innerHTML=response.t.member.telephone;
	    		    		cardno.innerHTML=response.t.member.cardno;
	    		    		
	    		    		if('1' == response.t.isuse)
	    		    		{
	    		    			isuse.innerHTML="已兑换";
	    		    			inpayhref.href="#";
	    		    		}
	    		    		else
	    		    		{
	    		    			isuse.innerHTML='未兑换';
	    		    			inpayhref.href="javascript:inpay('doit');";
	    		    		}
	    		    		
	    		    		if(response.t.usertime)
	    		    		{
	    		    			usertime.innerHTML=response.t.usertime;
	    		    		}
	    		    		else
	    		    		{
	    		    			usertime.innerHTML="";
	    		    		}
	    		    		showMemberInfo();
	    		    	}
	    		    	else
	    		    	{
	    		    		//清空输入框
	    		    		document.getElementById("exchangeid").value = "";
	    		    		hiddenMemberInfo
	    		    		alert(response.message);
	    		    	}
	    		    	
	    		    	
	    		    	
	    		    },
	    		    error: function(){
	    		    	
	    		    	//清空输入框
	    		    	document.getElementById("money").value = "";
	    		    	
	    		    	alert('操作失败!');
	    		    }
	    });
	    
	    
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
	    		    		var memberid = document.getElementById("memberid");
	    		    		memberid.innerHTML=response.t.member.cardno;
	    		    		
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
	    		    		
	    		    		var comsumptionintime = document.getElementById("comsumptionintime");
	    		    		if(!response.t.lastconsumtime)
	    		    		{
	    		    			comsumptionintime.innerHTML="暂无消费记录";
	    		    		}
	    		    		else
	    		    		{
	    		    			comsumptionintime.innerHTML=response.t.lastconsumtime;
	    		    		}
	    		    		
	    		    		
	    		    		var couponrecordlist = response.t.couponrecordlist;
	    		    		$("#couponrecordid").empty();
		    		    	if(couponrecordlist)
		    		    	{
		    		    		$("#couponrecordid").append("<option value=''>请选择优惠券</option>");
		    		    		for(var i in couponrecordlist)
		    		    		{
		    		    			if(!couponrecordlist[i].isexpire || couponrecordlist[i].isexpire != '1')
		    		    			{
		    		    				$("#couponrecordid").append("<option value='"+couponrecordlist[i].id+"'>"+couponrecordlist[i].coupon.name+",  ID："+couponrecordlist[i].coupon.id+",  可抵："+couponrecordlist[i].coupon.money+"</option>");
		    		    			}
		    		    		}
		    		    	}
		    		    	else
		    		    	{
		    		    		$("#couponrecordid").append("<option value=''>暂无优惠券</option>");
		    		    		
		    		    	}
	    		    		
	    		    		
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