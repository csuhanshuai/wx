<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	var BasePath="${BasePath}";
</script>

<link rev="stylesheet" rel="stylesheet" type="text/css" href="${BasePath}/css/thickbox.css"  media="screen" />





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"  src="${BasePath}/js/common/thickbox/thickbox.js"></script>

<title>微信公众平台管理系统</title>

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>

<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<body>



<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li class="cur"><a href="${BasePath}/zj/getIntegralexchange.kq">积分兑换</a></li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getIntegralexchangerecord.kq" name="qcust" id="qcust" method="post">
		<table border="0" cellpadding="5" cellspacing="0">
            <tr>
                 <input type="hidden" name="integralexchangeid" id="integralexchangeid" value="${integralexchangeid?default("")}" />
                <td>电话 <input type="text" name="telephone" value="<#if telephone??>${telephone?default("")}</#if>" size="25" class="form_input" notnull /></td>
               
             
                   <td>是否兑换 <select name="isuse">
                	   <option value="2" <#if isuse?? && isuse=='2'>selected</#if>>全部</option>
                	   <option value="0" <#if isuse?? && isuse=='0'>selected</#if>>未兑换</option>
                	   <option value="1" <#if isuse?? && isuse=='1'>selected</#if>>已兑换</option>
                </select></td>
                 <td></td>
                     <td><input type="button" class="submit" value="查询" name="submit_btn"  id="submit_btn"></td>
                <!--
                <td> <a href="${BasePath}/turentableManage/getWinnersToExcel.kq">导出Exce表格</a></td>
                -->
                </tr>
        </table>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">兑换名称</td>
                <td width="10%" nowrap="nowrap">领取人</td>
                <td width="10%" nowrap="nowrap">领取日期</td>
		        <td width="10%" nowrap="nowrap">是否被兑换</td>
		        <td width="10%" nowrap="nowrap">兑换日期</td>
		        <td width="10%" nowrap="nowrap">操作</td>       
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr id='Tr${item.id}'>
					 <td>${item_index+1}</td>
					 <td>${item.integralexchange.name?default("")}</td>
					 <td>${item.member.name?default("")}</td> 
					 <td>${item.receivetime?default("")}</td> 
					 <td>
					 	<#if item.isuse == '0'>
	                		未兑换
	                	<#elseif item.isuse == '1'>
	                		已兑换
	                	<#else>
	                		--
	                	</#if>
					 </td>
					 <td>${item.usertime?default("--")}</td>
					 <td nowrap="nowrap" class="">
						<#if item.isuse == '0'>
							<a href="${BasePath}/zj/updateIntegralexchangerecord.kq?id=${item.id}&integralexchangeid=${integralexchangeid?default("")}&isuse=1">兑换</a>
						<#else>
	                		--
						</#if>
					</td>
                </tr>
	      		</#list>	
	      	<#else>
	      		<tr><td colspan="9"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if>
                   
                </tbody>
    </table>
    <div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="qcust" />
<script type="text/javascript">
	function getIntegralexchangeDetail(id)
	{
		showThickBox("积分兑换条目明细",BasePath+"/zj/getIntegralexchangeDetailForward/"+id+".kq?TB_iframe=true&height=230&width=750",false);
	}
	
	$(document).ready(function() {

		$("#submit_btn").click(function(){	 		
		document.getElementById("qcust").submit();	 			 
		})
	
	});
</script>
</body>
</html>