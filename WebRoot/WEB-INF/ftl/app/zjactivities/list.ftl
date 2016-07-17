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
    <#if type?? && type == '2'>
    	<li><a href="${BasePath}/zj/wobble/getPrize.kq">摇一摇</a></li>
		<li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=2">中奖信息</a></li>
    <#elseif type?? && type == '3'>
    	<li><a href="${BasePath}/cardManage/queryConfigList.kq">刮刮卡</a></li>
		<li><a href="${BasePath}/cardManage/queryPrizeConfigList.kq">奖项管理</a></li>
		<li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=3">兑奖管理</a></li>
    <#elseif type?? && type == '4'>
    	<li><a href="${BasePath}/turentableManage/toTurentableConfig.kq">大转盘</a></li>
		<li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=4">中奖信息</a></li>
	<#else>
	<#if !type??><li class="cur"><a href="${BasePath}/zj/getActivities.kq">活动发布</a></li></#if>
	<#if type?? && type == '1'><li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=1">活动报名</a></li></#if>
	</#if>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getActivities.kq" name="qcust" id="qcust" method="post">
	    <#if type?? && (type == '1' || type == '2' || type == '3' || type == '4')>
		<#else>
		<a href="${BasePath}/zj/addActivitiesForward.kq" class="btn_green btn_w_120">发布活动</a>
		</#if>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">活动名称</td>
                <td width="10%" nowrap="nowrap">开始时间</td>
		        <td width="10%" nowrap="nowrap">结束时间</td>
		        <td width="10%" nowrap="nowrap">描述</td>
		        <td width="10%" nowrap="nowrap">操作</td>       
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr id='Tr${item.id}'>
					 <td>${item_index+1}</td>
					 <td>${item.name?default("")}</td>
		             <td>${item.starttime?default("")}</td>
		             <td>${item.endtime?default("")} </td>
					 <td>${item.description?default("")}</td> 
					 <td nowrap="nowrap" class="">
								<a href="javascript:getActivitiesDetail('${item.id}');">详情</a>&nbsp;&nbsp;
								<#if type?? && type== '1'>
                                    <a href="${BasePath}/zjhuodong/getBaomingList.kq?activitiesid=${item.id}">活动报名</a>&nbsp;&nbsp;
								<#elseif type?? && type == '2'>
									<a href="${BasePath}/zj/wobble/getPrizerecord.kq?activitiesid=${item.id}">中奖管理</a>&nbsp;&nbsp;
								<#elseif type?? && type == '3'>
									<a href="${BasePath}/cardManage/queryEmployeeList.kq?activitiesid=${item.id}">兑奖管理</a>&nbsp;&nbsp;
								<#elseif type?? && type == '4'>
									<a href="${BasePath}/turentableManage/toWinners.kq?activitiesid=${item.id}">中奖信息</a>&nbsp;&nbsp;
								<#else>
								<a href="${BasePath}/zj/addActivitiesForward.kq?type=mod&id=${item.id}">
								<img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改">
								</a>&nbsp;&nbsp;
								<a href="${BasePath}/zj/removeActivities.kq?id=${item.id?default("")}" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，继续删除吗？')){return false};">
							    	<img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除">
							    </a>
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

</body>
<script type="text/javascript">
	function getActivitiesDetail(id)
	{
		showThickBox("活动信息明细",BasePath+"/zj/getActivitiesDetailForward/"+id+".kq?TB_iframe=true&height=450&width=750",false);
	}
</script>
</html>