<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript">
	var BasePath="${BasePath}";
</script>
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
<#if type='ptypemanage'>
<div id="reply_keyword" class="r_con_wrap">
<form action="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" name="ptypequery" id="ptypequery" method="post">
</form>
<div class="control_btn"><a href="${BasePath}/mallmanage/toAddProductType.kq?type=ptypemanage" class="btn_green btn_w_120">添加商品分类</a></div>

<table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<thead>
    <tr>
        <td width="10%" nowrap="nowrap">序号</td>
        <td width="20%" nowrap="nowrap">分类名称</td>
        <td width="15%" nowrap="nowrap">类型</td>
	<td width="15%" nowrap="nowrap">链接</td>
	<td width="15%" nowrap="nowrap">添加时间</td>
        <td width="10%" nowrap="nowrap" class="last">操作</td>
    </tr>
</thead>
<tbody>
	<#if pageFinder?? && (pageFinder.data)?? >
			  		<#list pageFinder.result as item>	
					<tr>
					<td class="alert alert-info" colspan="6" id="showtr${item_index+1}" style="display: none;" >

						${baseAppUrl}zjmall/mlist.kq?bid=${bid}&qtype=${item.id} 
		
					 </td>
					 </tr>
			  		<tr>
			  			  <td nowrap="nowrap">
							${item_index+1}               
						 </td>
						<td nowrap="nowrap">
							${item.typename?default('')}               
						 </td>
						 <td nowrap="nowrap">
							<#if item.istay??&&item.istay=="1">
							商品分类
							<#else>
							商品标签
							</#if>
						</td>
						<td>
<a class="popalink"   href="javascript:showlink('showtr${item_index+1}')"   
 title="此链接可用于微官网、自定义URL等" >链接</a>

						</td>
						<td nowrap="nowrap">
							${item.addtime?default('')}      
						</td>
						    <td class="last" nowrap="nowrap">
						    
							<a href="${BasePath}/mallmanage/toupdateProductType.kq?type=ptypemanage&id=${item.id}" ><img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改" /></a>
							<a href="${BasePath}/mallmanage/removeProductType.kq?type=ptypemanage&id=${item.id}" onClick="if(!confirm('删除后不可恢复,如果分类下有商品请先删除商品，继续吗？')){return false};"><img src="${BasePath}/images/icon/del.gif" /></a>
						    </td>
					</tr>
			  		</#list>				  	
			  	<#else>
					<tr><td colspan="5"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>        
    </tbody>
</table>
<div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="ptypequery" />
</div>  </div>

<#elseif type='plabelmanage'>
<div id="reply_keyword" class="r_con_wrap">
<form action="${BasePath}/mallmanage/queryLabel.kq?type=plabelmanage" name="plabelquery" id="plabelquery" method="post">
</form>
<div class="control_btn"><a href="${BasePath}/mallmanage/toAddLabel.kq?type=plabelmanage" class="btn_green btn_w_120">添加商品标签</a></div>

<table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<thead>
    <tr>
        <td width="10%" nowrap="nowrap">序号</td>
        <td width="20%" nowrap="nowrap">标签名称</td>
	   <td width="15%" nowrap="nowrap">添加\更新时间</td>
        <td width="10%" nowrap="nowrap" class="last">操作</td>
    </tr>
</thead>
<tbody>
	<#if pageFinder?? && (pageFinder.data)?? >
			  		<#list pageFinder.result as item>
			  		<tr>
			  			  <td nowrap="nowrap">
							${item_index+1}               
						 </td>
						<td nowrap="nowrap">
							${item.name?default('')}               
						 </td>
						<td nowrap="nowrap">
							${item.addtime?default('')}      
						</td>
						    <td class="last" nowrap="nowrap">
						    
							<a href="${BasePath}/mallmanage/toupdateLabel.kq?type=plabelmanage&id=${item.id}" ><img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改" /></a>
							<a href="${BasePath}/mallmanage/removeLabel.kq?type=plabelmanage&id=${item.id}" onClick="if(!confirm('删除后不可恢复,如果标签有被商品引用，请先删除商品的标签，继续吗？')){return false};"><img src="${BasePath}/images/icon/del.gif" /></a>
						    </td>
					</tr>
			  		</#list>				  	
			  	<#else>
					<tr><td colspan="5"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>        
    </tbody>
</table>
<div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="ptypequery" />
</div>  </div>

<#elseif type='pmanage'>
<div id="reply_keyword" class="r_con_wrap">
<form action="${BasePath}/mallmanage/queryProduct.kq?type=pmanage" name="pquery" id="pquery" method="post">
</form>
<div class="control_btn"><a href="${BasePath}/mallmanage/toaddProduct.kq?type=pmanage" class="btn_green btn_w_120">添加商品</a></div>

<table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<thead>
    <tr>
        <td width="5%" nowrap="nowrap">序号</td>
        <td width="10%" nowrap="nowrap">商品编号</td>
        <td width="20%" nowrap="nowrap">商品名称</td>
        <td width="10%" nowrap="nowrap">类型</td>
	<td width="8%" nowrap="nowrap">价格</td>
        <td width="8%" nowrap="nowrap">参考价</td>
	<td width="10%" nowrap="nowrap">链接</td>
	<td width="10%" nowrap="nowrap">状态</td>
        <td width="15%" nowrap="nowrap" class="last">操作</td>
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
							${(item.id)?default("000")}               
						 </td>
						<td nowrap="nowrap">
							${(item.ptitle)}    
						</td>
						 <td nowrap="nowrap" class='replacetag'>
							${typelis[item.ptype]}
						</td>
						<td nowrap="nowrap" >${(item.pric)}</td> 
					        <td nowrap="nowrap" >${(item.opric)}</td>
						<td>	<a href="javascript:showlink('showtr${item_index+1}')"   title="此链接可用于微官网、自定义URL等" >显示链接</a></td>
						 <td nowrap="nowrap" >${(item.status)}</td> 
						    <td class="last" nowrap="nowrap">
						    <#if item.isshow!='1'>
								<a style="display:" id="shows${item_index+1}" href="javascript:updateProductByIsshow('${item.id}','1','${item_index+1}');">加入到商品展示</a>
							<#else>
								<a style="display:" id="shows${item_index+1}" href="javascript:updateProductByIsshow('${item.id}','0','${item_index+1}');">取消</a>
							</#if>
							<a style="display:none" id="show${item_index+1}" href="javascript:updateProductByIsshow('${item.id}','1','${item_index+1}');">加入到商品展示</a>
							<a style="display:none" id="noshow${item_index+1}" href="javascript:updateProductByIsshow('${item.id}','0','${item_index+1}');">取消</a>
							<a href="${BasePath}/mallmanage/toupdateProduct.kq?id=${item.id}&type=pmanage&flag=mod"><img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改" /></a>
							<a href="${BasePath}/mallmanage/remove.kq?type=pmanage&id=${item.id}" onClick="if(!confirm('删除后不可恢复，继续吗？')){return false;};"><img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除" /></a>
						   </td>
					</tr>
			  		</#list>				  	
			  	<#else>
					<tr><td colspan="8"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>        
    </tbody>
</table>

<div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="pquery" />
</div>  </div>
</#if>
</div>  </div>
</body>
<script>
  function showlink(obj)
  {

	$('#'+obj).toggle(200); 
	
  }
  
  
  
  
  function updateProductByIsshow(id,isshow,index){
	 	
	 	if(id.length==0 || isshow.length==0)
		{
			alert("请确认传递参数是否为空");
			return;
		}
		
	 	
	 	
    	$.ajax({
	    		    url: BasePath+"/mallmanage/updateProductByIsshow.kq?id=" + id + "&isshow=" + isshow,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
	    		    success: function(result){
	    		    	var response = eval("(" +result+")" );
	    		    	if (response.result == 'success')
	    		    	{
	    		    		if(isshow == 1)
	    		    		{
	    		    		document.getElementById("shows"+index).style.display="none";
	    		    		document.getElementById("show"+index).style.display="none";
	    		    		document.getElementById("noshow"+index).style.display="";
	    		    		}
	    		    		else
	    		    		{
	    		    		document.getElementById("shows"+index).style.display="none";
	    		    		document.getElementById("show"+index).style.display="";
	    		    		document.getElementById("noshow"+index).style.display="none";
	    		    		}
	    		    	}
	    		    	else
	    		    	{
	    		    		alert(response.message);
	    		    	}
	    		    	
	    		    	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!');
	    		    }
	    });
	    
    }

</script>
</html>