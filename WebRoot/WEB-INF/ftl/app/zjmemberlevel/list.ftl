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
				<li><a href="${BasePath}/zj/getMembercard.kq">卡片管理</a></li>
				<li><a href="${BasePath}/zj/getMember.kq">会员管理</a></li>
				<li><a href="${BasePath}/zj/getIntegralrule.kq">积分规则</a></li>
				<li class="cur"><a href="${BasePath}/zj/getMemberlevel.kq">等级管理</a></li>
				<li><a href="${BasePath}/zj/getMembernotice.kq">公告管理</a></li>
            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">会员等级名称</td>
                <td  nowrap="nowrap">积分区间</td>
                <td  nowrap="nowrap">描述</td>
                <td  nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if memberlevellist?? && (memberlevellist?size>0) >
	      	<#list memberlevellist as item>	
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.name?default("")}</td>
	                <td>${item.integralstart?default("")} ~ ${item.integralend?default("")}</td>
	                <td>${item.description?default("")}</td>
		            <td class="last" nowrap="nowrap">
			            <a href="${BasePath}/zj/updateMemberlevelForward.kq?id=${item.id?default("")}" >
			            <img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改">
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
    
	</div>  
</div>

</body>
</html>