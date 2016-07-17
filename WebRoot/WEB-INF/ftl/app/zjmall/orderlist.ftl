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
    <link rel="stylesheet" href="${BasePath}/css/bootstrap.min.css">
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script src="${BasePath}/js/app/zjmall/producttype.js"></script>
<script src="${BasePath}/js/app/zjmall/qxmall.js"></script>
 <script src="${BasePath}/js/bootstrap.min.js"></script>

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
<form action="${BasePath}/mallmanage/queryOrder.kq?type=omanage" name="oquery" id="oquery" method="post">
</form>

<table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<thead>
    <tr>
        <td nowrap="nowrap">序号</td>
        <td  nowrap="nowrap">订单编号</td>
        <td  nowrap="nowrap">收货人</td>
        <td  nowrap="nowrap">收货人地址</td>
	    <td  nowrap="nowrap">收货人电话</td>
        <td nowrap="nowrap">下订单时间</td>
        <td nowrap="nowrap">快递公司</td>
        <td nowrap="nowrap">快递单号</td>
	<td nowrap="nowrap">订单详情</td>
	<td nowrap="nowrap">状态</td>
        <td nowrap="nowrap" class="last">操作</td>
    </tr>
</thead>
<tbody>
	              <#if pageFinder?? && (pageFinder.data)?? >
			 <#list pageFinder.result as item>
			 		<tr>
					<td class="alert alert-info" colspan="9" id="showtr${item_index+1}" style="display: none;" >

						${baseAppUrl}zjmall/show.kq?bid=${bid}&id=${item.id} 
		
					 </td>
					 </tr>
			  		<tr id="t${item_index+1}">
			  			  <td nowrap="nowrap">
							${item_index+1}               
						 </td>
						<td nowrap="nowrap" style="word-break:break-all;word-wrap:break-word">
							<#if   item.id?length   lt   10   >
								${(item.id)?default("000000")}       
							<#else>
								${(item.id[0..6])?default("000000")}...
							</#if>        
						 </td>
						<td nowrap="nowrap">
							${(item.receiver)}    
						</td>
						 <td nowrap="nowrap" style="word-break:break-all;word-wrap:break-word">
								${(item.receiveAddr)?default("")}       
						</td>
						<td nowrap="nowrap" >${(item.phoneNum)}</td> 
					    <td nowrap="nowrap" >${(item.orderTime)}</td>
					    <td nowrap="nowrap" >${(item.expCompany)?default("")}</td>
					    <td nowrap="nowrap" >${(item.expNum?default(""))}</td>
						<td>	<a href="${BasePath}/mallmanage/queryOrderDetail.kq?type=omanage&id=${item.id}"   title="订单详情" >查看订单详情</a></td>
						 <td nowrap="nowrap" >
						     <#if item.status?? && item.status==0>
						        未支付
						     <#elseif item.status=1>
						        已支付
						     <#elseif item.status=2>
						        已发货
						     <#elseif item.status=3>
						        已完成
						     </#if>
						   </td> 
						    <td class="last" nowrap="nowrap">
						
							<a href="${BasePath}/mallmanage/queryOrderById.kq?type=omanage&id=${item.id}"><img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改" /></a>
							<a href="${BasePath}/mallmanage/removeOrder.kq?type=omanage&id=${item.id}" onClick="if(!confirm('删除后不可恢复，继续吗？')){return false;};"><img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除" /></a>
						   </td>
					</tr>
			  		</#list>				  	
			  	<#else>
					<tr><td colspan="11"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>        
    </tbody>
</table>

<div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="oquery" />
</div>  </div>
</div>  </div>
</body>
<script>
  function showlink(obj)
  {

	$('#'+obj).toggle(200); 
	
  }

</script>
</html>