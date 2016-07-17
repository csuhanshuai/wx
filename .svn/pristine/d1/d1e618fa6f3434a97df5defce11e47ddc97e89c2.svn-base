<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>

<link rel="stylesheet" href="${BasePath}/css/app/zj/zjmember/mc.css">
<script type="text/javascript" src="${BasePath}/js/app/zj/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/zjmember/main.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/zjmember/dialog_min.js"></script>


<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/bootstrap.min.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/bootstrap-combined.min.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>

</head>

<body onselectstart="return true;" ondragstart="return false;">

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    	<ul>
				<li class="cur"><a href="${BasePath}/zjdiaoyan/getDiaoyanList.kq">微调研</a></li>
				<li><a href="${BasePath}/zj/getSignin.kq">微签到</a></li>
   		</ul>
        </div>
        
		<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
			
		<div id="url" class="r_con_wrap">
		<br>	   
		<div class="tabbable" id="tabs-250756"><!-- Only required for left/right tabs -->
		<!--
		<ul class="nav nav-tabs">
			<li class="active"><a contenteditable="true" data-toggle="tab" href="${BasePath}/zj/getMembercard.kq">统计图表</a></li>
			<li><a contenteditable="true" data-toggle="tab" href="${BasePath}/zj/getMember.kq">用户数据</a></li>
		</ul>
       
	    <h2>参与调研用户总数：0人</h2><br />
	     -->
	    <br>
	    <#if titleInfo?? && (titleInfo?size>0) >
	      	<#list titleInfo as item>		
				    <span><b>${item.questionName}</b></span>
					<table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
				        <thead>
				            <tr align="left">
				                <td nowrap="nowrap" width="50%">选项</td>
				                <td nowrap="nowrap" width="25%">小计</td>
				                <td nowrap="nowrap" width="25%">比例</td>
				            </tr>
				        </thead>
				        <tbody>
				             <tr>
				                <td>${item.selectA}</td>
				                <td><#if item.selectAtimes??>${item.selectAtimes?default("0")}</#if></td>
				                <td>${item.selectAp?default("0")}</td>
				             </tr>
				             <tr>
				                <td>${item.selectB}</td>
				                <td><#if item.selectBtimes??>${item.selectBtimes?default("0")}</#if></td>
				                <td>${item.selectBp?default("0")}</td>
				             </tr>
				             <#if item.selectC?? && (item.selectC?length > 0)>
					             <tr>
					                <td>${item.selectC}</td>
					                <td><#if item.selectCtimes??>${item.selectCtimes?default("0")}</#if></td>
					                <td>${item.selectCp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectD?? && (item.selectD?length > 0)>
					             <tr>
					                <td>${item.selectD}</td>
					                <td><#if item.selectDtimes??>${item.selectDtimes?default("0")}</#if></td>
					                <td>${item.selectDp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectE?? && (item.selectE?length > 0)>
					             <tr>
					                <td>${item.selectE}</td>
					                <td><#if item.selectEtimes??>${item.selectEtimes?default("0")}</#if></td>
					                <td>${item.selectEp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectF?? && (item.selectF?length > 0)>
					             <tr>
					                <td>${item.selectF}</td>
					                <td><#if item.selectFtimes??>${item.selectFtimes?default("0")}</#if></td>
					                <td>${item.selectFp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectG?? && (item.selectG?length > 0)>
					             <tr>
					                <td>${item.selectG}</td>
					                <td><#if item.selectGtimes??>${item.selectGtimes?default("0")}</#if></td>
					                <td>${item.selectGp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectH?? && (item.selectH?length > 0)>
					             <tr>
					                <td>${item.selectH}</td>
					                <td><#if item.selectHtimes??>${item.selectHtimes?default("0")}</#if></td>
					                <td>${item.selectHp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectI?? && (item.selectI?length > 0)>
					             <tr>
					                <td>${item.selectI}</td>
					                <td><#if item.selectItimes??>${item.selectItimes?default("0")}</#if></td>
					                <td>${item.selectIp?default("0")}</td>
					             </tr>
				             </#if>
				             <#if item.selectJ?? && (item.selectJ?length > 0)>
					             <tr>
					                <td>${item.selectJ}</td>
					                <td><#if item.selectJtimes??>${item.selectJtimes?default("0")}</#if></td>
					                <td>${item.selectJp?default("0")}</td>
					             </tr>
				             </#if>
				        </tbody>
				        <!--
				        <thead>
					        <tr align="left">
					                <td  nowrap="nowrap">本题有效填写人次</td>
					                <td  nowrap="nowrap" colspan="2">0</td>
					         </tr>       
				        </thead>
				        -->
			        </table>		     
			  </#list> 
		<#else>
            <tr>
                <td colspan="3">
                    <div class="yt-tb-list-no">暂无内容</div>
                </td>
            </tr>	       
        </#if>
        
        </div>
</div>
</div>
</body>
</html>