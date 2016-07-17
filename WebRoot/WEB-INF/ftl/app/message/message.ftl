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
    <li class="<#if type=='ptMessage'>cur</#if>"><a href="${BasePath}/ptMessage.kq?type=ptMessage">图文消息管理</a></li>
    <li class="<#if type=='customUrl'>cur</#if>"><a href="${BasePath}/queryLink.kq?type=customUrl">自定义URL管理</a></li>
    <li class="<#if type=='systemUrl'>cur</#if>"><a href="${BasePath}/querysysLink.kq?type=systemUrl">系统URL查询</a></li>
    <li><a href="${BasePath}/articleManage/queryProductType.kq">文章分类</a></li>
	<li ><a href="${BasePath}/articleManage/queryArticles.kq">文章管理</a></li>
            </ul>
</div>
<#if type=='ptMessage'>
<!--link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js?t=2013122302'></script-->
<form action="${BasePath}/ptMessage.kq?type=ptMessage" name="queryForm" id="queryForm" method="post">
</form>
<div id="material" class="r_con_wrap">
            <script type='text/javascript' src='${BasePath}/js/masonry.min.js?t=2013122302'></script>
        <script language="javascript">$(window).load(wechat_obj.material_init);</script>
        <div class="list">
            <div class="item first_item">
                <div>
                    <div><a href="${BasePath}/toAddPTMessage.kq?type=ptMessage&single=true"></a></div>
                    <a href="${BasePath}/toAddPTMessage.kq?type=ptMessage&single=true">+单图文消息</a>
                </div>
                <div class="multi">
                    <div><a href="${BasePath}/toAddMultiPTMessage.kq?type=ptMessage&single=false"></a></div>
                    <a href="${BasePath}/toAddMultiPTMessage.kq?type=ptMessage&single=false">+多图文消息</a>
                </div>
            </div>
            <#if pageFinder?? && (pageFinder.data)?? >
            <#list pageFinder.result as item>
            <#if (item.items)??&&item.items?size==1>
                
                    <div class="item one">
                    <div class="title">${item.items[0].title?default('')}</div>
                    <div>${item.addtime?default('')}</div>
                    <div class="img"><img src="${item.items[0].picUrl?default('')}"/>${item.items[0].picUrl?default('')}</div>
                                    <div class="mod_del">
                    <div class="mod"><a href="${BasePath}/toUpdatePTMessage.kq?type=ptMessage&id=${item.id}"><img src="${BasePath}/images/icon/mod.gif" /></a></div>
                    <div class="del"><a href="${BasePath}/deletePTMessage.kq?type=ptMessage&id=${item.id}" onClick="if(!confirm('删除后不可恢复，继续吗？')){return false};"><img src="${BasePath}/images/icon/del.gif" /></a></div>
                        </div>
                    </div>
             
            <#elseif (item.items)??&&(item.items?size>1)>
            <div class="item multi">
                <div class="time">${item.addtime?default('')}</div>
                <div class="first">
                    <div class="info">
                        <div class="img"><img src="${item.items[0].picUrl?default('')}"/></div>
                        <div class="title">${item.items[0].title?default('')}</div>
                    </div>
                </div>
                <#list item.items as it>
                <#if it_index!=0>
                <div class="list">
                    <div class="info">
                        <div class="title">${it.title?default('')}</div>
                        <div class="img"><img src="${it.picUrl?default('')}"/></div>
                    </div>
                </div>
                </#if>
                </#list>
                
                <div class="mod_del">
                    <div class="mod"><a href="${BasePath}/toUpdateMultiPTMessage.kq?type=ptMessage&id=${item.id}"><img src="http://static.ptweixin.com/member/images/ico/mod.gif" /></a></div>
                     <div class="del"><a href="${BasePath}/deletePTMessage.kq?type=ptMessage&id=${item.id}" onClick="if(!confirm('删除后不可恢复，继续吗？')){return false};"><img src="http://static.ptweixin.com/member/images/ico/del.gif" /></a></div>
                </div>
                </div>
            </#if>
            </#list>
            </#if>
            
                
                <div class="clear"></div>
        </div>
        <div class="blank12"></div>
        <!-- 翻页标签 -->
        <#import "../app-common.ftl"  as page>
        <@page.queryForm formId="queryForm" />
    </div>  
    </div>
<div>
<#elseif type='customUrl'>

<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
        <form id="add_form" class="add_form " method="post" action="addLink.kq?m=material&a=url">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
                <td>名称 <input type="text" name="linkname" value="" size="25" class="form_input" notnull /></td>
                <td>Url <input type="text" name="url" value="" size="40" class="form_input" notnull /></td>
                <td><input type="submit" class="submit" value="添加URL" name="submit_btn"></td>
            </tr>
        </table>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="10%" nowrap="nowrap">序号</td>
                <td width="30%" nowrap="nowrap">名称</td>
                <td width="50%" nowrap="nowrap">Url</td>
                <td width="10%" nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
	<#if links??  >
			 <#list links as item>
                    <tr>
                <td nowrap="nowrap">${item_index+1}  </td>
                <td>${item.linkname} </td>
                <td><a href="${item.url} " target="_blank">${item.url}</a></td>
                <td class="last" nowrap="nowrap">
                 <a href="removeLink.kq?id=${item.id}" onClick="if(!confirm('删除后不可恢复，继续吗？')){return false};"><img src="http://static.ptweixin.com/member/images/ico/del.gif" align="absmiddle" alt="删除" /></a>
                </td>
            </tr>
             </#list>				  	
	</#if> 
                   
                </tbody>
    </table>
    <div class="blank20"></div>
    <div id="turn_page"><font class='page_noclick'><<上一页</font>&nbsp;<font class='page_item_current'>1</font>&nbsp;<font class='page_noclick'>下一页>></font></div>
</div>  </div>
<div>
<#elseif type='systemUrl'>
<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
    <div class="type">
<#if links??  >
			 <#list links as item>
 <a  <#if item.showpage?? >
			<#if item.type == "1">
				href="${baseappeurl+item.url}"  target="_blank"	
			<#else> 
				href="${item.url}"  target="_blank"
			</#if>
 
 <#else >
 href="javascript:return false;"</#if>   class="cur">${item.linkname} </a>

	 <#if (item_index+ 1) == 8> 
		<#break>
	</#if>
</#list>				  	
</#if> 
                   

</div>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="10%" nowrap="nowrap">序号</td>
                <td width="20%" nowrap="nowrap">名称</td>
                <td width="60%" nowrap="nowrap" class="last">Url</td>
		<td width="10%" nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
<#if links??  >
			 <#list links as item>

                                <tr>
                        <td nowrap="nowrap">${item_index+1} </td>
                        <td nowrap="nowrap">${item.linkname}</td>
                        <td nowrap="nowrap">
			<#if item.type == "1">
				${baseappeurl+item.url}
			<#else> 
				${item.url}  
			</#if>
			</td>
			<td nowrap="nowrap" class="left last">  
			<!--<a href="${BasePath}/removesysLink.kq?id=${item.id?default("")}" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，如果已关联到微信图文消息则会导致部分图文无法访问，继续删除吗？')){return false};">删除</a>--></td>
                    </tr>
         </#list>				  	
</#if>     
</tbody>
    </table>
</div>  </div>
<div>
</#if>

<div style="display:none;"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1000137483'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1000137483' type='text/javascript'%3E%3C/script%3E"));</script></div>
</body>
</html>