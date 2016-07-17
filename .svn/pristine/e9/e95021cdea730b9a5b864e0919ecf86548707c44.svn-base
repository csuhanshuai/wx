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
	<li class="cur"><a href="${BasePath}/zj/getGift.kq">礼品管理</a></li>
	
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getGift.kq" name="qcust" id="qcust" method="post">
            <!--<a href="${BasePath}/zj/addGiftForward.kq">
		<input type="button" class="btn_green" value="新增" name="submit_btn"  id="submit_btn">
		</a>
		-->
		<a href="${BasePath}/zj/addGiftForward.kq" class="btn_green btn_w_120">新增礼品</a>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">礼品名称</td>
                <td width="10%" nowrap="nowrap">数量</td>
		        <td width="10%" nowrap="nowrap">描述</td>
		        <td width="10%" nowrap="nowrap">状态</td>
		        <td width="10%" nowrap="nowrap">录入日期</td>
		        <td width="10%" nowrap="nowrap">操作</td>       
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr id='Tr${item.id}'>
					 <td>${item_index+1}</td>
					 <td>${item.name?default("")}</td>
					 <td>${item.number?default(0)}</td>
					 <td>${item.description?default("")}</td>
					 <td>
					 	<#if item.status=='0'>
					 		正常
					 	<#else>
					 		不可用
					 	</#if>
					 </td>
		             <td>${item.intime?string("yyyy-MM-dd")}</td>
					 <td nowrap="nowrap" class="">
					 	<#if item.status=='0'>
							<a href="${BasePath}/zj/addGiftForward.kq?type=mod&id=${item.id}">
							<img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改">
							</a>&nbsp;&nbsp;
							<a href="${BasePath}/zj/updateGiftBystatus.kq?status=1&id=${item.id}">停用</a>&nbsp;&nbsp;
						<#else>
							--
						</#if>
						<!--<a href="${BasePath}/zj/removeGift.kq?id=${item.id?default("")}" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，继续删除吗？')){return false};">
							<img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除">
						</a>-->
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