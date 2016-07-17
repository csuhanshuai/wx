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


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getConsumptionByMemberid/<#if salesman??>${salesman}<#else>0</#if>/<#if memberid??>${memberid}</#if>.kq" name="qcust" id="qcust" method="post">
		
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">消费金额</td>
                <td  nowrap="nowrap">消费时间</td>
                <td  nowrap="nowrap">消费项目</td>
                <td  nowrap="nowrap">余额</td>
                <#if !salesman?? || salesman!='1'>
                	<td  nowrap="nowrap" class="last">操作</td>
                </#if>
            </tr>
        </thead>
        <tbody>
                    
		<#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>	
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.money?default("")}</td>
	                <td>${item.intime?default("")}</td>
	                <td>${item.reasons?default("")}</td>
	                <td>${item.balance?default("")}</td>
	                <#if !salesman?? || salesman!='1'>
		                <td class="last" nowrap="nowrap">
			                <a href="${BasePath}/zj/addConsumptionForward.kq?memberid=<#if memberid??>${memberid}</#if>&type=mod&id=${item.id}" >修改</a>
		                </td>
	                </#if>
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
	
	//function getConsumptionByMemberid(memberid)
	//{
	//	showThickBox("消费信息明细",BasePath+"/zj/getConsumptionByMemberid/"+memberid+".kq?TB_iframe=true&height=300&width=750",false);
	//}
</script>
</body>
</html>