<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
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

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
<div class="r_nav">
    <ul>
       <li class="<#if type=='initmall'>cur</#if>"><a href="${BasePath}/mallmanage/tomallconf.kq?type=initmall">基础设置</a></li>
	<li class="<#if type=='navset'>cur</#if>"><a href="${BasePath}/mallmanage/tonavset.kq?type=navset">导航设置</a></li>
	<li class="<#if type=='ptypemanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage">商品分类</a></li>
	<li class="<#if type=='plabelmanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryLabel.kq?type=plabelmanage">商品标签</a></li>
        <li class="<#if type=='pmanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryProduct.kq?type=pmanage">商品管理</a></li>
        <li class="<#if type=='omanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryOrder.kq?type=omanage">订单管理</a></li>
    </ul>
</div>
<div id="reply_keyword" class="r_con_wrap">
            <script language="javascript">$(document).ready(wechat_obj.reply_keyword_init);</script>
        <form id="keyword_reply_form" class="r_con_form" method="post" role="form" action="addLabel.kq">
	    <input type="hidden" id="id" name="id" value="${(label.id)?default("")}"/>
	    <input type="hidden" id="type" name="type" value="${type}"/>
	    <div class="rows">
                <label>标签名称</label>
                <span class="input"> 
		<input id="name" name="name" type="text"  value="${(label.name)?default("")}"/>
		<div class="tips">当发布产品时，如果有选择标签名称，则会展示到产品页面</div></span>
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label></label>
                <span class="input">
		
		<input type="submit" class="btn_green" name="submit_button"  value="提交保存" /><a href="${BasePath}/mallmanage/queryLabel.kq?type=plabelmanage" class="btn_gray">返回</a></span>
                <div class="clear"></div>
            </div>

        </form>
    </div>  </div>
<div>

</body>
</html>