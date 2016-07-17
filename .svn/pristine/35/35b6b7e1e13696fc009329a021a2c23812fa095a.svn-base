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
        <td width="5%" nowrap="nowrap">序号</td>
        <td width="10%" nowrap="nowrap">订单编号</td>
        <td width="8%" nowrap="nowrap">产品ID</td>
        <td width="20%" nowrap="nowrap">产品名称</td>
	    <td width="8%" nowrap="nowrap">购买数量</td>
        <td width="8%" nowrap="nowrap">产品总金额</td>
        
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
						<td nowrap="nowrap">
							${(item.orderId)?default("000")}               
						 </td>
						<td nowrap="nowrap">
							${(item.pid)}    
						</td>
						 <td nowrap="nowrap">
							${(item.ptitle)}
						</td>
						<td nowrap="nowrap" >${(item.buyNum)}</td> 
					    <td nowrap="nowrap" >${(item.totalMoney)}</td>
					    
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