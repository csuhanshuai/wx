<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<title>网络营销系统-系统管理-角色</title>

<#include "../system-include.ftl">
<script type="text/javascript"  src="${BasePath}/js/system/systemmgmt/role.js"></script>

</head>

<body id="pagesbody">
<div class="main-body" id="main_body">
	<div class="cont-nav ft-sz-12"><span><a href="#">系统管理</a> &gt; 角色列表 </span></div>
	<div class="pro-list">
		<div class="mb-btn-fd-bd">
			<div class="mb-btn-fd relative">
				<span class="btn-extrange absolute ft-sz-14">
					<ul class="onselect">
						<li class="pl-btn-lfbg"></li>
						<li class="pl-btn-ctbg">角色列表</li>
						<li class="pl-btn-rtbg"></li>
					</ul>
				</span>
			</div>
			<div class="add-newpd ft-sz-12 fl-rt"><a href="javascript:toAddRole();">添加角色</a></div>
		</div>
	</div>
	<div class="div-pl">
		
		<form action="queryRoleList.kq" name="queryForm" id="queryForm" method="get">
		<div class="div-pl-hd ft-sz-12">
			<span>角色名称：</span>
			<input name="roleName" class="blakn-sl" value="${roleName?default('')}"/>
			<a href="javascript:document.queryForm.submit();" class="btn-sh">搜索</a>
		</div>
		</form>
		
		<div class="yt-c-div">
			<table cellpadding="0" cellspacing="0" class="ytweb-table">
			    <thead>
			    <tr>
				    <th>角色名称</th>
				    <th>创建时间</th>
				    <th>备注</th>
				    <th>操作</th>
			    </tr>              
			    </thead>
			    <tbody>
			    
			     <#if pageFinder?? && (pageFinder.data)?? >
			  		<#list pageFinder.result as item>
			  		<tr>
			            <td>
							${item.roleName?default('')}               
			            </td>
			            <td>
							<#if item.roleCreatedate ??>
								${item.roleCreatedate?string("yyyy-MM-dd")}
							</#if>
						</td>
			            <td>${item.remark?default('')}</td>
			            <td class="td0">
			        		<a href="javascript:toUpdateRole('${item.id}');" >编辑</a>
							<a href="javascript:removeRole('${item.id}');" >删除</a>
							<a href="javascript:allotRoleResource('${item.id}');" >分配资源</a>
			            </td>
			        </tr>
			  		</#list>	
			  	
			  	<#else>
			  		<tr><td colspan="4"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>
			  		
			    </tbody>
		    </table> 
		</div>
		
		
		<div class="div-pl-bt">
			<!--
			<div class="div-pl-bt-deal">
				<input type="checkbox" name="" />
				<span>全选</span>
				<a href="#">批量删除</a>
			</div>
			-->
			<!-- 翻页标签 -->
			<#import "../../common.ftl"  as page>
			<@page.queryForm formId="queryForm" />
			
		</div>
	</div>
</div>
</body>
</html>

