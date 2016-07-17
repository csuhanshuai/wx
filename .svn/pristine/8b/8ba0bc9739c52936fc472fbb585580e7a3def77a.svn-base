<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<script type='text/javascript' src='${BasePath}/js/global.js?t=2013122302'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js?t=2013122302'></script>
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
                <li class="cur"><a href="${BasePath}/zj/getSalespromotion.kq">促销活动</a></li>
            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getSalespromotion.kq" name="qcust" id="qcust" method="post">
		<a href="${BasePath}/zj/addSalespromotionForward.kq" class="btn_green btn_w_120">增加促销活动</a>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">促销活动名称</td>
                <td  nowrap="nowrap">赠送金额</td>
                <td  nowrap="nowrap">有效期</td>
                <td  nowrap="nowrap">使用范围</td>
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
	                <td>${item.money?default("")}</td>
	                <td>
	                	${item.starttime?string('yyyy-MM-dd')}
	                	--
	                	${item.endtime?string('yyyy-MM-dd')}
	                </td>
	                <td>${item.usablerange?default("")}</td>
	                <td>
	                	<#if item.status=='0'>
					 		正常
					 	<#elseif item.status=='1'>
					 		已停用
					 	<#else>
					 	--
					 	</#if>
	                
	                </td>
	                <td class="last" nowrap="nowrap">
	                	<#if item.status=='0'>
		                	<a href="${BasePath}/zj/updateSalespromotion.kq?id=${item.id}&status=1" >停用</a>
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
	
</script>
</body>
</html>