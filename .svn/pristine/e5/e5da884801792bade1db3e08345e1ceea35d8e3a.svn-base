<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="application/x-www-form-urlencoded; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<script type='text/javascript' src='${BasePath}/js/jquery.json-2.4.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js?t=2013122302'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
</script>
<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
		<li class="cur"><a href="${BasePath}/turentableManage/toTurentableConfig.kq">大转盘</a></li>
		<li><a href="${BasePath}/zj/getActivities.kq?type=4">中奖信息</a></li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/turentableManage/updateAwards.kq" name="qcust" id="qcust" method="post">
	
   
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap" class="first">序号</td>               
		        <td width="10%" nowrap="nowrap">奖品名称</td>
		        <td width="10%" nowrap="nowrap">是否是奖品</td>
		        <td width="10%" nowrap="nowrap">对应奖品</td>
		        <td width="10%" nowrap="nowrap">数量</td>
		        <td width="10%" nowrap="nowrap">中奖提示</td>
		        <td width="10%" nowrap="nowrap">中奖概率</td>
                
            </tr>
        </thead>
        <tbody>
                    
        <#if awards??>
	      		<#list awards as item>		
	      		<tr id='Tr${item.id}'>
	      		
	      			<input type="hidden" name="id" value="${item.id}" size="25"  notnull />
	      			
	      			
	      			
	      			<input type="hidden" name="min" value="${item.min}" size="25"  notnull />
	      			<input type="hidden" name="max" value="${item.max}" size="25"  notnull />
					 <td class="first">${item_index+1}</td>
					 		 
		             <td><input type="text" name="name" value="${item.name}" size="25" class="form_input" notnull /> </td>
		             
		             
		             <td><select name="prize" id="prize${item.id}" onChange="javascript:changegift('${item.id}');"><option <#if item.isPrize==1>selected</#if> value=1>是</option><option <#if item.isPrize==0>selected</#if> value=0>否</option> </select> </td>
		            
		             <td id="havatd" style="">
		             	<select name="giftid" id="giftid${item.id}">
		             		<#if item.isPrize==1>
		             			<#if giftlist?? && (giftlist?size>0) >
		             				<option value="">请选择奖品</option>
	      						<#list giftlist as gift>
	      							<option value="${gift.id?default('')}" <#if item.giftid?? && item.giftid==gift.id>selected</#if>>${gift.name?default("")}</option>
	      						</#list>
	      						<#else>
	      							<option value="">暂无奖品</option>
	      						</#if>
		             		<#else>
		             			<option value="" >非奖品</option>
		             		</#if>
		             		
		             	</select> 
		             </td>
		             
		             <td><input type="text" name="num" id="num${item.id}" value="${item.num}" size="15" class="form_input" onkeyup="javascript:getGiftnumber('${item.id}');" notnull /> </td>
		             <td><input type="text" name="prompt" value="${item.prompt}" size="25" class="form_input" notnull /> </td>
		             
		             <td><input type="text" name="v" value="${item.v}" size="15" class="form_input" onkeyup="value=value.replace(/[^\d]/g,'')"  notnull />%</td>
                     
                </tr>
	      		</#list>	
	      	
		</#if>
		   <tr>
		   <td colspan="2">活动信息：</td>
		   <td colspan="5" > <textarea style="padding:0 0 0  0;width:100%" rows="5" name="info"cols="90" > ${info.info?default('')}  </textarea></td>
		   </tr>
                   <tr>
		    <td colspan="2">无资格提示信息：</td>
		   <td colspan="5"> <textarea  style="padding:0 0 0  0;width:100%" rows="5" name="tip"cols="90" > ${info.prompt?default('')}    </textarea></td>
		   
          
		   </tr>
                </tbody>
    </table>
    
        	
    	
    	
	 </form>

	
	 <div    style="padding:5px;margin-bottom:0px;margin-right: auto; margin-left: auto;text-align:center; ">
	
	            <input type="button" class="submit" value="提交" name="submit_btn"  id="submit_btn">
	           
  </div>
	
</body>
</html>
<script type="text/javascript" >

$(document).ready(function() {

	$("#submit_btn").click(function(){	 		
		document.getElementById("qcust").submit();	 			 
	})
	
});
   
	
	
	// 发达ajax请求
	function ajaxRequest(url, data, callback) {
		$.ajax({
			url : url,  
            type : "POST",  
            dataType:"json",  
			data :  $.toJSON(data), 
			contentType: "application/json; charset=utf-8", 
			success : callback
		});
	}
	
	function changegift(id)
	{
		var prize = $("#prize"+id).val();
		
		$("#giftid"+id).empty();
			
		if(prize == 1)
		{
			
			
			//根据不同的类型获取不同类型的活动列表
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
	    		    		$("#giftid"+id).append("<option value=''>请选择奖品</option>");
	    		    		for(var i in t)
	    		    		{
	    		    			
	    		    			$("#giftid"+id).append("<option value='"+t[i].id+"'>"+t[i].name+"</option>");
	    		    		}
	    		    	}
	    		    	else
	    		    	{
	    		    		$("#giftid"+id).append("<option value=''>暂无奖品</option>");
	    		    		
	    		    	}
					}
	    		    else
	    		    {
	    		    	$("#giftid"+id).append("<option value=''>暂无奖品</option>");
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
			});
		}
		else
		{
			$("#giftid"+id).append("<option value=''>非奖品</option>");
		}
	}
	
	function checkNum(num)
	{
	   var number = /^\d+$/;
	   return number.test(num);
	}
	
	function getGiftnumber(id)
	{
		var num = $("#num"+id).val();
		
		var prize = $("#prize"+id).val();
		var giftid = $("#giftid"+id+" :selected").val();
		
		if(prize == 1)
		{
		
			if(!giftid)
			{
				$("#num"+id).val('0');
				alert("请选择对应的奖品");
				return ;
			}
			if(!checkNum(num))
			{
				$("#num"+id).val(num.replace(/[^\d]/g,''));
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
		    		    				$("#num"+id).val(num.substring(0,num.length-1));
		    		    			}
		    		    			else
		    		    			{
		    		    				$("#num"+id).val('0');
		    		    			}
		    		    			alert("该奖品总数为："+t.number+"，请重新输入！");
		    		    		}
		    		    		
		    		    		
		    		    	}
		    		    	else
		    		    	{
								$("#num"+id).val('0');
		    		    		alert("请重新选择奖品");
								return ;
		    		    		
		    		    	}
						}
		    		    else
		    		    {
							$("#num"+id).val('0');
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
		else
		{
			$("#num"+id).val('0');
			alert("非奖品，数量为0");
		}
	}
	
</script>