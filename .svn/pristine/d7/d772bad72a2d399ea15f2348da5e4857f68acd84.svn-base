<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js?t=2013122302'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script src="${BasePath}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/turentable/jQueryRotate.2.2.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/turentable/jquery.easing.min.js"></script>

<script type="text/javascript">
	function getAward(recordId){ 
		 $.ajax({ 
		        type: 'POST', 
		        url:'${BasePath}/turentableManage/getAwardAjax.kq?recordId='+recordId, 
		        dataType: 'json', 
		        cache: false, 
		        error: function(data){ 
		            //document.getElementById("tip").style.display="block";	 
		            return false; 
		        }, 
		        success:function(data){ 
		        	if(data[0].isGet!=undefined){
		        		alert("兑奖成功");
		        		document.getElementById(recordId).innerHTML="已兑奖";
		        		document.getElementById(recordId+"time").innerHTML=data[0].SGetTime;
		        	}else if(data[0].hasGet!=undefined){
		        		alert("已兑奖");
		        	}
		      	}    
		 });
	}
</script>

</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
				<li><a href="${BasePath}/turentableManage/toTurentableConfig.kq">大转盘</a></li>
				<li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=4">中奖信息</a></li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/turentableManage/toWinners.kq?queryAction=1" name="qcust" id="qcust" method="post">
	<input type="hidden" name="activitiesid" value="${activitiesid}">
	<table border="0" cellpadding="5" cellspacing="0">
            <tr>
                 <input type="hidden" name="ids" id="ids"  />
                <td>姓名 <input type="text" name="empName" value="${lRecord.empName?default("")}" size="15" class="form_input" notnull /></td>
                <td>工号 <input type="text" name="jobNumber" value="${lRecord.jobNumber?default("")}" size="15" class="form_input" notnull /></td>
             
                <td>是否兑奖 
		            <select name="isGet">
		            	   <option value="-1" <#if isGet==-1>selected</#if>>全部</option>
		            	   <option value="0" <#if isGet==0>selected</#if>>未兑奖</option>
		            	   <option value="1" <#if isGet==1>selected</#if>>已兑奖</option>
		            </select>
		        </td>
		         <td>奖项 
		            <select name="award">
		            	   <option value="-1" <#if award=="-1">selected</#if>>全部</option>
		            	   <option value="一等奖" <#if award=="一等奖">selected</#if>>一等奖</option>
		            	   <option value="二等奖" <#if award=="二等奖">selected</#if>>二等奖</option>
		            	   <option value="三等奖" <#if award=="三等奖">selected</#if>>三等奖</option>
		            	   <option value="四等奖" <#if award=="四等奖">selected</#if>>四等奖</option>
		            </select>
		        </td>
                <td><input type="button" class="submit" value="查询" name="submit_btn"  id="submit_btn"></td>
                <td>&nbsp;<a href="${BasePath}/turentableManage/getWinnersToExcel.kq">导出Exce表格</a></td>
                
            </tr>
        </table>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">姓名</td>
				<td width="10%" nowrap="nowrap">工号</td>
		        <td width="10%" nowrap="nowrap">奖项</td> 
				<td width="10%" nowrap="nowrap">兑奖时间</td>             
		        <td width="10%" nowrap="nowrap">是否兑奖</td> 
		        <td width="10%" nowrap="nowrap">操作</td> 
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr >
					 <td>${item_index+1}</td>
					 <td>${item.empName?default("")}</td>
					  <td>${item.jobNumber?default("")}</td>
					 <td>${item.award?default("")}</td>  
					 <td id="${item.id}time">${item.getTime?default("")}</td> 
					 
					 <#if item.isPrize==1>
					 <td id="${item.id}"><#if item.isGet==1>已兑奖</#if><#if item.isGet==0>未兑奖</#if></td>  
					 <#else>
					 <td >--</td>  
					 </#if>
					 
					 <td><#if item.isPrize==1><a href="javascript:getAward('${item.id}')"/>兑奖<#else>--</#if></td>
                </tr>
	      		</#list>	
	      	<#else>
	      		<tr><td colspan="8"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if>
                   
                </tbody>
    </table>
    
	 <div    style="padding:5px;margin-bottom:0px;margin-right: auto; margin-left: auto;text-align:center; ">
	
	            <!--<input type="button" class="submit" value="批量兑奖" name="update_btn"  id="update_btn">-->
	           
     </div>
    <div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="qcust" />


</body>
</html>
<script type="text/javascript" >

$(document).ready(function() {

	$("#submit_btn").click(function(){	 		
	var obj = {  name : '', mobilePhone : ''  };
	document.getElementById("qcust").submit();	 			 
	})
	
	$("#all").click(function(){	
	    if ($(this).is(":checked")) {
              $("[name = id]:checkbox").each(function () {
                  $(this).attr("checked","checked");
                });		 
         }else{
            $("[name = id]:checkbox").each(function () {
                  $(this).attr("checked",false);
                });		 
          }
	}) 
	
	
	$("#update_btn").click(function(){	 		
	
		var value="";
	    
	    $("[name = id]:checkbox").each(function () {
	                    if ($(this).is(":checked")) {
	                 
	                       value=value+"|"+$(this).attr("value");
	                    }
	                });
		if(value!=""){
			value=value.substring(1,value.length);
		}else{
			alert("请选择要兑奖的数据");
			return;
		}
		document.getElementById("ids").value=value;
		
		document.getElementById("qcust").submit();
			 
	})
	

   });
   
	// 发达ajax请求
	function ajaxRequest(url, reqParam, callback) {
		$.ajax({
			type : 'POST',
			url : url,
			data : reqParam,
			cache : true,
			success : callback
		});
	}
	

</script>