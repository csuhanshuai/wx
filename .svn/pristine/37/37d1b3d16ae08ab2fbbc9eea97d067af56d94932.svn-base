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
	<form action="${BasePath}/turentableManage/toWinners.kq" name="qcust" id="qcust" method="post">
	<table border="0" cellpadding="5" cellspacing="0">
            <tr>
                 <input type="hidden" name="ids" id="ids"  />
                <td>姓名 <input type="text" name="name" value="${winners.name?default("")}" size="25" class="form_input" notnull /></td>
                <td>电话 <input type="text" name="tel" value="${winners.tel?default("")}" size="25" class="form_input" notnull /></td>
               
                <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                
                </tr>
                <tr>
                <td>公司 <input type="text" name="company" value="${winners.company?default("")}" size="25" class="form_input" notnull /></td>
                <td>部门 <input type="text" name="department" value="${winners.department?default("")}" size="25" class="form_input" notnull /></td>
             
                   <td>是否兑奖 <select name="ticket"    >
                	   <option value="3" <#if winners.ticket==3>selected</#if>>全部</option>
                	   <option value="0" <#if winners.ticket==0>selected</#if>>未兑奖</option>
                	   <option value="1" <#if winners.ticket==1>selected</#if>>已兑奖</option>
                </select></td>
                 <td></td>
                     <td><input type="button" class="submit" value="查询" name="submit_btn"  id="submit_btn"></td>
                
                <td> <a href="${BasePath}/turentableManage/getWinnersToExcel.kq">导出Exce表格</a></td>
                
            </tr>
        </table>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap"><input type="checkbox" name="all"  id="all"    class="form_input" notnull /></td>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">姓名</td>
                <td width="10%" nowrap="nowrap">电话</td>
		        <td width="10%" nowrap="nowrap">公司</td>
		        <td width="10%" nowrap="nowrap">部门</td>
		        <td width="10%" nowrap="nowrap">奖项</td>
		        <td width="10%" nowrap="nowrap">是否兑奖</td>                
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr >
	      		     <td width="5%" nowrap="nowrap"><input type="checkbox" name="id"  value="${item.id?default("")}" class="form_input"  /></td>
					 <td>${item_index+1}</td>
					 <td>${item.name?default("")}</td>
					  <td>${item.tel?default("")}</td>
					 <td>${item.company?default("")} </td>
		             <td>${item.department?default("")} </td>
					 <td>${item.award?default("")}</td>  
					 <td><#if item.ticket==1>已兑奖</#if><#if item.ticket==0>未兑奖</#if></td>                              
                </tr>
	      		</#list>	
	      	<#else>
	      		<tr><td colspan="8"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if>
                   
                </tbody>
    </table>
    
	 <div    style="padding:5px;margin-bottom:0px;margin-right: auto; margin-left: auto;text-align:center; ">
	
	            <input type="button" class="submit" value="批量兑奖" name="update_btn"  id="update_btn">
	           
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