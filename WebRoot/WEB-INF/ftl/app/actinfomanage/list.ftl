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
	<li class="cur">活动列表</li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/actInfoManage/toListActInfo.kq" name="qcust" id="qcust" method="post">
	    <a href="${BasePath}/actInfoManage/toManagePage.kq" class="btn_green btn_w_120">发布活动</a>
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
					 <td>${item.title?default("")}</td>
		             <td>${item.beginTime?default("")}</td>
		             <td>${item.endTime?default("")} </td>
					 <td>${item.content?default("")}</td> 
					 <td nowrap="nowrap" class="">
								<a href="javascript:getActivitiesDetail('${item.id}');">详情</a>&nbsp;&nbsp;
								 
								<a href="${BasePath}/actInfoManage/toUpdateActInfo.kq?id=${item.id}">
								<img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改">
								</a>&nbsp;&nbsp;
								<a href="${BasePath}/actInfoManage/removeActInfo.kq?id=${item.id?default("")}" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，继续删除吗？')){return false};">
							    	<img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除">
							    </a>
								
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
		showThickBox("活动信息明细",BasePath+"/actInfoManage/getActInfoDetailForward/"+id+".kq?TB_iframe=true&height=450&width=750",false);
	}
</script>
</html>