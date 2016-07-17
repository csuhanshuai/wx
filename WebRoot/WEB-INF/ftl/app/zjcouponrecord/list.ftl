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
				<li class="cur"><a href="${BasePath}/zj/getCoupon.kq">优惠券</a></li>
            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getCouponrecord.kq" name="qcust" id="qcust" method="post">
		<table border="0" cellpadding="5" cellspacing="0">
            <tr>
                 <input type="hidden" name="couponid" id="couponid" value="${couponid?default("")}" />
                <td>电话 <input type="text" name="telephone" value="<#if telephone??>${telephone?default("")}</#if>" size="25" class="form_input" notnull /></td>
               
             
                   <td>是否使用 <select name="isuse">
                	   <option value="2" <#if isuse?? && isuse=='2'>selected</#if>>全部</option>
                	   <option value="0" <#if isuse?? && isuse=='0'>selected</#if>>未使用</option>
                	   <option value="1" <#if isuse?? && isuse=='1'>selected</#if>>已使用</option>
                </select></td>
                 <td></td>
                     <td><input type="button" class="submit" value="查询" name="submit_btn"  id="submit_btn"></td>
                <!--
                <td> <a href="${BasePath}/turentableManage/getWinnersToExcel.kq">导出Exce表格</a></td>
                -->
                </tr>
        </table>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">优惠券名称</td>
                <td  nowrap="nowrap">领用人</td>
                <td  nowrap="nowrap">领取日期</td>
                <td  nowrap="nowrap">是否被使用</td>
                <td  nowrap="nowrap">使用日期</td>
                <td  nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>	
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.coupon.name?default("")}</td>
	                <td>${item.member.name?default("")}</td>
	                <td>${item.receivetime?default("")}</td>
	                <td>
	                	<#if item.isexpire?? &&  item.isexpire == '1'>
	                		已过期
	                	<#else>
		                	<#if item.isuse == '0'>
		                		未使用
		                	<#elseif item.isuse == '1'>
		                		已使用
		                	<#else>
		                		--
		                	</#if>
	                	</#if>
	                </td>
	                <td>${item.usertime?default("--")}</td>
	                <td class="last" nowrap="nowrap">
	                	--
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
	
	$(document).ready(function() {

		$("#submit_btn").click(function(){	 		
		document.getElementById("qcust").submit();	 			 
		})
	
	});
	
</script>
</body>
</html>