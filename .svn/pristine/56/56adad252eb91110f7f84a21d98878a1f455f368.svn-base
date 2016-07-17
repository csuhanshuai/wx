<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript">
	var BasePath="${BasePath}";
</script>
<script language="javascript">
		if("oklab"=="${oklab?default('')}")
		{
				alert("提交成功！")
				
		window.location.href='/zj/getMember.kq';
		}
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
		    
		    <li><a href="${BasePath}/zj/getMembercard.kq">卡片管理</a></li>
			<li class="cur"><a href="${BasePath}/zj/getMember.kq">会员管理</a></li>
			<li><a href="${BasePath}/zj/getIntegralrule.kq">积分规则</a></li>
			<li><a href="${BasePath}/zj/getMemberlevel.kq">等级管理</a></li>
			<li><a href="${BasePath}/zj/getMembernotice.kq">公告管理</a></li>
            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getMember.kq<#if salesman?? && salesman=='1'>?salesman=1</#if>" name="qcust" id="qcust" method="post">
		
    </form>
    <form id="add_form" class="add_form " method="post" action="${BasePath}/zj/getMemberByCondition.kq">
    	
    	
    	<#if salesman?? && salesman=='1'>
    	
			<input name="salesman" type="hidden" value="1">
		    
		</#if>
    	
        <table border="0" cellpadding="5" cellspacing="0">
        	<tr>
		        <td colspan="2">
			        <input name="type" type="radio" name="type" value="0" checked="checked" onclick="changeDefaultValue(this.value)">
			        <span>会员卡号</span>
			        <input name="type" type="radio" name="type" value="1" onclick="changeDefaultValue(this.value)">
			        <span>手机号码</span>
		        </td>
		    </tr>
            <tr>
                <td><input placeholder="请输入姓名" type="text" id="condition" name="condition" value="" size="25" class="form_input" notnull /></td>
                <td><input type="submit" class="submit" value="查询" name="submit_btn">&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${BasePath}/servlet/exportMember.kq?cardno=<#if cardno??>${cardno?default("")}</#if>&telephone=<#if telephone??>${telephone?default("")}</#if>" >导出Excel</a>
                </td>
            </tr>
        </table>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">会员姓名</td>
                <td  nowrap="nowrap">电话</td>
                <td  nowrap="nowrap">会员卡</td>
                <td  nowrap="nowrap">积分</td>
                <td  nowrap="nowrap">余额</td>
                <td  nowrap="nowrap">注册时间</td>
                <td  nowrap="nowrap">状态</td>
                <td  nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>	
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.name?default("")}</td>
	                <td>${item.telephone?default("")}</td>
	                <td>${item.cardno?default("")}</td>
	                <td>${item.integral?default("")}</td>
	                <td>${item.balance?default("")}</td>
	                <td>${item.intime?default("")}</td>
	                <td>
	                	<#if item.status=='1'>
					 		正常
					 	<#elseif item.status=='2'>
					 		已锁定
					 	<#else>
					 	--
					 	</#if>
	                </td>
	                <td class="last" nowrap="nowrap">
	                	<a href="javascript:getMemberDetail('${item.id}');" >明细</a>
	                
	                	<a href="javascript:getConsumptionByMemberid('${item.id}','<#if salesman??>${salesman}<#else>0</#if>');" >消费明细</a>
	                	
	                	
	                	<#if salesman?? && salesman=='1'>
	                		<a href="${BasePath}/zj/addConsumptionForward.kq?memberid=${item.id}&salesman=1" >收账</a>
	                	<#else>
	                		<#if item.status=='1'>
						 		<a href="${BasePath}/zj/updateMember.kq?id=${item.id}&salesman=1&status=2" >锁定</a>
						 	<#elseif item.status=='2'>
						 		<a href="${BasePath}/zj/updateMember.kq?id=${item.id}&salesman=1&status=1" >解锁</a>
						 	<#else>
						 	--
						 	</#if>
	                	
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
	function getConsumptionByMemberid(memberid,salesman)
	{
		showThickBox("消费信息明细",BasePath+"/zj/getConsumptionByMemberid/"+salesman+"/"+memberid+".kq?TB_iframe=true&height=300&width=750",false);
	}
	
	
	function getMemberDetail(memberid)
	{
		showThickBox("会员信息明细",BasePath+"/zj/getMemberDetail/"+memberid+".kq?TB_iframe=true&height=300&width=750",false);
	}
</script>
</body>
</html>