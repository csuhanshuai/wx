<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src="${BasePath}/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/aSelect.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/aLocation.js"></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<body>





<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>


<div id="wechat_zhaopin" class="r_con_wrap">
<script language="javascript">$(document).ready(wechat_obj.auth_init);</script>
    
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<#if member??>
		<tr>
			<td>
				<div >
	        	会员名称：${member.name?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	会员卡号：${member.cardno?default("")}
	    		</div>
			</td>
		</tr>
		<tr>
			<td>
				<div >
	        	电话：${member.telephone?default("")}
	    		</div>
			</td>
			<td>
				<div>
	        	性别：<#if member.sex=='1'>
					 		男
					 	<#elseif member.sex=='0'>
					 		女
					 	<#else>
					 	--
					 	</#if>
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				<div >
	        	生日：${member.birthday?default("")}
	    		</div>
			</td>
			<td>
				<div >
	        	QQ：${member.qq?default("")}
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			
			<td>
				<div>
	        	积分：${member.integral?default("")}
	    		</div>
			</td>
			<td>
				<div >
	        	账户余额：${member.balance?default("")}
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				<div >
	        	等级：<#if memberlevel??>${memberlevel.name?default("")}</#if>
	    		</div>
			</td>
			<td>
				<div>
	        	注册时间：${member.intime?default("")}
	    		</div>
			</td>
		</tr>
		
		
		<tr>
			
			<td colspan="2">
				<div>
	        	状态：<#if member.status=='2'>
					 		已锁定
					 	<#elseif member.status=='1'>
					 		正常
					 	<#else>
					 	--
					 	</#if>
	    		</div>
			</td>
		</tr>
		
		<tr>
		
			<td colspan="2">
				<div id="address">
	        	地址：
	        	
											<select name="addr_prov" id="selectProvince" selectedindex="0" disabled>
											<option value="">请选择</option>
											</select>
											
											<select name="addr_city" id="selectCity" disabled>
											<option value="">请选择</option>
											</select>
											
											<select name="addr_area" id="selectArea" disabled>
											<option value="">请选择</option>
											</select>
	        	
	        	 ${member.address?default("")}
	    		</div>
			</td>
		</tr>
		
		
		
		
		
		
<#else>
<tr><td colspan="2"><div class="yt-tb-list-no">暂无内容</div></td></tr>
</#if>
</table>


<script>
	//$().ready(function(){
		
		
		var addr_prov='<#if member??>${member.addr_prov?default("")}</#if>';
		var addr_city='<#if member??>${member.addr_city?default("")}</#if>';
		var addr_area='<#if member??>${member.addr_area?default("")}</#if>';
		if(!addr_prov)
		{
			addr_prov = '0';
		}
		
		if(!addr_city)
		{
			addr_city = '0';
		}
		
		if(!addr_area)
		{
			addr_area = '0';
		}
		var sel = aSelect({data: aLocation});
		
		
		sel.bind('#selectProvince', addr_prov);
		
		
		sel.bind('#selectCity', addr_city);
		
		
		sel.bind('#selectArea', addr_area);
		
		
		
	//});
	
	function change()
	{
		var a = $('#selectProvince option:selected').text();
			//alert(a);
		var b = $('#selectCity option:selected').text();
		var c = $('#selectArea option:selected').text();
		var d = $('#xxxx').val();
		$('#address').text(a+b+c+d);
	}
	
</script>



</div>

</body>
</html>