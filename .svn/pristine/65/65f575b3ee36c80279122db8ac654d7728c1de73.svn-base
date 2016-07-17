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
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">栏目设置</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getZhaopin.kq" name="qcust" id="qcust" method="post">
            <!--<a href="${BasePath}/zj/addZhaopinForward.kq">
		<input type="button" class="btn_green" value="新增" name="submit_btn"  id="submit_btn">
		</a>
		-->
		<a href="${BasePath}/zj/addZhaopinForward.kq" class="btn_green btn_w_120">新增招聘信息</a>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">岗位名称</td>
                <td width="10%" nowrap="nowrap">学历</td>
		        <td width="10%" nowrap="nowrap">性别</td>
		        <td width="10%" nowrap="nowrap">年龄</td>
		        <td width="10%" nowrap="nowrap">工作地点</td>
		        <td width="10%" nowrap="nowrap">待遇</td> 
		        <td width="10%" nowrap="nowrap">截止日期</td>
		        <td width="10%" nowrap="nowrap">操作</td>       
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr id='Tr${item.id}'>
					 <td>${item_index+1}</td>
					 <td>${item.name?default("")}</td>
					 <td>
					 	<#if item.education=='1'>
					 		中专
					 	<#elseif item.education=='2'>
					 		大专
					 	<#elseif item.education=='2'>
					 		本科
					 	<#elseif item.education=='2'>
					 		硕士
					 	<#else>
					 	--
					 	</#if>
					 </td>
					 <td>
					 	<#if item.sex=='1'>
					 		不限
					 	<#elseif item.sex=='2'>
					 		男
					 	<#elseif item.sex=='3'>
					 		女
					 	<#else>
					 	--
					 	</#if>
					 </td>
		             <td>${item.age?default("")}</td>
		             <td>${item.workingplace?default("")} </td>
					 <td>${item.pay?default("")}</td> 
					 <td>${item.endtime?default("")}</td>
					 <td nowrap="nowrap" class="left last">
								<a href="javascript:getZhaopinDetail('${item.id}');">详情</a>&nbsp;&nbsp;
								<a href="${BasePath}/zj/addZhaopinForward.kq?type=mod&id=${item.id}">
								<img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改">
								</a>&nbsp;&nbsp;
								<a href="${BasePath}/zj/removeZhaopin.kq?id=${item.id?default("")}" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，继续删除吗？')){return false};">
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
<script type="text/javascript">
	function getZhaopinDetail(zhaopinid)
	{
		showThickBox("招聘信息明细",BasePath+"/zj/getZhaopinDetailForward/"+zhaopinid+".kq?TB_iframe=true&height=300&width=750",false);
	}
</script>
</body>
</html>