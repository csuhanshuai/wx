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
<script src="${BasePath}/js/app/zjmall/producttype.js"></script>
<script src="${BasePath}/js/app/zjmall/zjmall.js"></script>
</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
<div class="r_nav">
    <ul>
        <li class="<#if type=='initmall'>cur</#if>"><a href="${BasePath}/mallmanage/tomallconf.kq?type=initmall">Mall配置管理</a></li>
        <li class="<#if type=='ptypemanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage">商品分类</a></li>
        <li class="<#if type=='pmanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryProduct.kq?type=pmanage">商品管理</a></li>
        <li class="<#if type=='binding'>cur</#if>"><a href="">定单管理</a></li>
    </ul>
</div>

<#if type=='initmall'>
<div id="attention" class="r_con_wrap">
    <form id="attention_reply_form" class="r_con_form" method="post" action="${BasePath}/mallmanage/updateAttentionMsg.kq">
        <input type="hidden" name="id" value=""/>
        <input type="hidden" name="type" value="${type}">
	<input type="hidden" id="imgpath"  name="imgpath"  >
	 <div class="rows">
            <label>商家ID</label>
            <span class="input">
		<input id=bizid  type=text name=bizid  readonly value='${bizid}'/>
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows">
            <label>商城名称</label>
            <span class="input">
		<input id=mallname  type=text name=mallname   value='奇新商城'/>
            </span>
            <div class="clear"></div>
        </div>
	<div class="rows">
            <label>客服热线</label>
            <span class="input">
		<input id=cstel  type=text name=cstel   value='13866668888'/>
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows" id="img_msg_row">
            <label>商城状态</label>
            <span class="input">
                <select name='status' readonly>
                <!--  <#if ptList??>
                <#list ptList as item>
                <option value='${item.id}' <#if msg??&&msg.msgid==item.id>selected</#if>><#if item.items?size==1>【单图文】<#else>【多图文】</#if>${item.items[0].title?default('')}</option>
                </#list>
                </#if>  -->           
                <option value='1'  selected>正常</option>
		<!--<option value='2' >锁定</option>
		<option value='3' >试用</option>
		<option value='4' >全开</option> -->         
                </select>
                <!--a href="${BasePath}/ptMessage.kq?type=ptMessage" class="material">升级商城</a-->
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows" id="text_msg_row">
            <label>商城logon</label>
            <span class="input">
	 <div name="div" ><font style="font-size:12px;">选择上传logo图片</font>
	 <input type="file" contentEditable="false" id="upload" name="upload" value="" style="width: 120px"/>
	<input type="button"  value="上传logo" class="btn_green"  id="btnsub" onclick="ajaxFileUploadlogo('upload');"/> 
	 <ul class="slider-statu" id="imgul"></ul>
	 </div>
	    </span>
            <div class="clear"></div>
        </div>
        <div class="rows" id="img_msg_row">
            <label>导航1设置</label>
            <span class="input">
                    <select name='status'>
		 <#if producttypes?? && (producttypes.data)?? >
		 <optgroup label="----商品分类-----"></optgroup>  
                    <#list producttypes.result as ptype>
			<option value="${(ptype.id)}"  >${(ptype.typename)}</option>
		    </#list>   
		</#if>
		<option value='0'>----暂不设置----</option>
                </select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">商品分类管理</a>
            </span>
            <div class="clear"></div>
        </div>
	   <div class="rows" id="img_msg_row">
            <label>导航2设置</label>
            <span class="input">
                    <select name='status'>
		 <#if producttypes?? && (producttypes.data)?? >
		 <optgroup label="----商品分类-----"></optgroup>  
                    <#list producttypes.result as ptype>
			<option value="${(ptype.id)}">${(ptype.typename)}</option>
		    </#list>   
		</#if>
		<option value='0'>----暂不设置----</option>
                </select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">商品分类管理</a>
            </span>
            <div class="clear"></div>
        </div>
	   <div class="rows" id="img_msg_row">
            <label>导航3设置</label>
            <span class="input">
                    <select name='status'>
		 <#if producttypes?? && (producttypes.data)?? >
		 <optgroup label="----商品分类-----"></optgroup>  
                    <#list producttypes.result as ptype>
			<option value="${(ptype.id)}" >${(ptype.typename)}</option>
		    </#list>   
		</#if>
		<option value='0'>----暂不设置----</option>
                </select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">商品分类管理</a>
            </span>
            <div class="clear"></div>
        </div>
	   <div class="rows" id="img_msg_row">
            <label>导航4设置</label>
            <span class="input">
                    <select name='status'>
		 <#if producttypes?? && (producttypes.data)?? >
		 <optgroup label="----商品分类-----"></optgroup>  
                    <#list producttypes.result as ptype>
			<option value="${(ptype.id)}" >${(ptype.typename)}</option>
		    </#list>   
		</#if>
		<option value='0'>----暂不设置----</option>
                </select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">商品分类管理</a>
            </span>
            <div class="clear"></div>
        </div>
	   <div class="rows" id="img_msg_row">
            <label>导航5设置</label>
            <span class="input">
                    <select name='status'>
		 <#if producttypes?? && (producttypes.data)?? >
		 <optgroup label="----商品分类-----"></optgroup>  
                    <#list producttypes.result as ptype>
			<option value="${(ptype.id)}" >${(ptype.typename)}</option>
		    </#list>   
		</#if>
		<option value='0'>----暂不设置----</option>
                </select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">商品分类管理</a>
            </span>
            <div class="clear"></div>
        </div>
	   <div class="rows" id="img_msg_row">
            <label>导航6设置</label>
            <span class="input">
                    <select name='status'>
		 <#if producttypes?? && (producttypes.data)?? >
		 <optgroup label="----商品分类-----"></optgroup>  
                    <#list producttypes.result as ptype>
			<option value="${(ptype.id)}" >${(ptype.typename)}</option>
		    </#list>   
		</#if>
		<option value='0'>----暂不设置----</option>
                </select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">商品分类管理</a>
            </span>
            <div class="clear"></div>
        </div>
      <div class="rows">
            <label></label>
            <span class="input"><input type="submit" class="btn_green" name="submit_button" value="提交保存" /></span>
            <div class="clear"></div>
        </div>
        <input type="hidden" name="do_action" value="wechat.attention_reply">
    </form>
</div>  

<#elseif type='ptypemanage'>
<div id="reply_keyword" class="r_con_wrap">
<form action="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" name="ptypequery" id="ptypequery" method="post">
</form>
<div class="control_btn"><a href="${BasePath}/mallmanage/toAddProductType.kq?type=ptypemanage" class="btn_green btn_w_120">添加商品分类</a></div>
<table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<thead>
    <tr>
        <td width="10%" nowrap="nowrap">序号</td>
        <td width="25%" nowrap="nowrap">分类名称</td>
        <td width="15%" nowrap="nowrap">添加时间</td>
        <td width="35%" nowrap="nowrap">类型</td>
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
							${item.typename?default('')}               
						 </td>
						<td nowrap="nowrap">
							${item.addtime?default('')}      
						</td>
						 <td nowrap="nowrap">
						
						</td>
						    <td class="last" nowrap="nowrap">
							<a href="javascript:toUpdateProductType('${item.id}','${item.typename?default('')}');"><img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改" /></a>
							<a href="" onClick="if(!confirm('删除后不可恢复，继续吗？')){removeProductType('${item.id}');};"><img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除" /></a>
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
        <td width="10%" nowrap="nowrap">货号</td>
        <td width="20%" nowrap="nowrap">商品名称</td>
        <td width="10%" nowrap="nowrap">类型</td>
	<td width="15%" nowrap="nowrap">价格</td>
        <td width="15%" nowrap="nowrap">参考价</td>
	<td width="5%" nowrap="nowrap">状态</td>
        <td width="25%" nowrap="nowrap" class="last">操作</td>
    </tr>
</thead>
<tbody>
	              <#if pageFinder?? && (pageFinder.data)?? >
			 <#list pageFinder.result as item>
			  		<tr id="t${item_index+1}">
			  			  <td nowrap="nowrap">
							${item_index+1}               
						 </td>
						<td nowrap="nowrap">
							${(item.pid)?default("000")}               
						 </td>
						<td nowrap="nowrap">
							${(item.ptitle)}    
						</td>
						 <td nowrap="nowrap" class='replacetag'>
							${(item.ptype)}
						</td>
						<td nowrap="nowrap" >${(item.pric)}</td> 
					        <td nowrap="nowrap" >${(item.opric)}</td> 
						 <td nowrap="nowrap" >${(item.status)}</td> 
						    <td class="last" nowrap="nowrap">
							<a href=""><img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改" /></a>
							<a href="" onClick="if(!confirm('删除后不可恢复，继续吗？')){removeProductType('${item.id}');};"><img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除" /></a>
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
</html>