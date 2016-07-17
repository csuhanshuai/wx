<#include "../system-include.ftl">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content=" />
<meta name="Description" content="" />
<title>网络营销系统-系统管理-系统用户管理</title>
</head>
<script type="text/javascript"  src="${BasePath}/js/system/systemmgmt/systemUser.js"></script>


<body>
<#assign systemUser=login_system_user?default('') >

<div class="main-body" id="main_body">
	<div class="cont-nav ft-sz-12"><span><a href="#">系统管理</a> &gt;账户管理 </span></div>
	<div class="pro-list">
		<div class="mb-btn-fd-bd">
			<div class="mb-btn-fd relative">
				<span class="btn-extrange absolute ft-sz-14">
					<ul class="onselect">
						<li class="pl-btn-lfbg"></li>
						<li class="pl-btn-ctbg">系统用户列表</li>
						<li class="pl-btn-rtbg"></li>
					</ul>
				</span>
			</div>
			<div class="add-newpd ft-sz-12 fl-rt"><a href="../../systemmgmt/systemuser/toAddSystemUser.kq" target="content">&nbsp;&nbsp;增&nbsp;加</a></div>
		</div>
	</div>
	<div class="div-pl">
		
		<form method="get" action="querySystemUserList.kq" name="queryForm" id="queryForm"  >
		<div class="div-pl-hd ft-sz-12">
			<span>真实姓名：</span>
			<input name="username" class="blakn-sl" value="${username?default('')}"/>
			
			<span>登录用户名：</span>
			<input name="loginName" class="blakn-sl" value="${loginName?default('')}"/>
			<a href="javascript:document.queryForm.submit();" class="btn-sh">搜索</a>
		</div>
		</form>
		
		
		<div class="yt-c-div">
            <table cellpadding="0" cellspacing="0" class="ytweb-table">
            <thead>
            <tr>
	            <th>真实姓名 </th>
	            <th>登录用户名</th>
	           <!-- <th>性别 </th>-->
	            <th>手机</th>
	           <!-- <th>是否为供应商</th>-->
	            <!--<th>部门</th>-->
	            <th>电话</th>
	            <th>Email</th>
	            <th>QQ</th>
	            <th>状态</th>
	            <th>操作</th>
            </tr>              
            </thead>
            <tbody>
            
            
              <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr id='Tr${item.id}'>
                    <td>
						${item.username?default("")}                 
                    </td>
                    <td>
                    	${item.loginName?default("")}
                    </td>
                 <!--   <td>
                    	<#if (item.sex == "0")>
							男
						<#elseif (item.sex == "1") >
							女
						</#if>
                    </td>-->
                    <td>
                    	${item.telPhone?default("")}
                    </td>
               <!--     <td>
                    	<#if item.supplierCode??  && (item.supplierCode != "") >是<#else>否</#if>
                    </td>-->
                 <!--    <td>
                    	${item.organizName?default("")}
                    </td>-->
                    <td>
	                   ${item.mobilePhone?default("")}
                    </td>
                    <td>
                    	${item.email?default("")}
                    </td>
                    <td>
                    	${item.qqNum?default("")}
                    </td>
                    <td>
                    	<span id="State${item.id}">
                    	<#if item.state?? && (item.state == "1")>
							正常
						<#elseif item.state?? && (item.state == "2") >
							锁定
						<#else>
							${item.state?default("")}
						</#if>
						</span>
                    </td>
                    
                    </td>
                    <td class="td0" style="text-align:left;">
                    
                    	<a href="../../systemmgmt/systemuser/toUpdateSystemUser.kq?id=${item.id}" target="content" style="padding-right: 5px;padding-left: 5px;">编辑</a>
                    	<#if (item.level)?? && (item.level == "0")>
           					<#if (systemUser != '')  && (systemUser.level)?? && (systemUser.level == "0" )>
           						<a href="javascript:toUpdatePassword('${item.id}');"  style="padding-right: 5px;">修改密码</a>
           					</#if>
						<#else>
							<a href="javascript:removeSystemUser('${item.id}');"  style="padding-right: 5px;">删除</a>
							<a href="javascript:allotUserRole('${item.id}');"  style="padding-right: 5px;">分配角色</a>
							<a href="javascript:toUpdatePassword('${item.id}');"  style="padding-right: 5px;">修改密码</a>
						</#if>
						
						<#if item.state?? && (item.state != "")>
               				<a id="clockUser${item.id}" href="javascript:updateUserState('${item.id}','2');" <#if  (item.state == "2")> style="display: none;padding-right: 5px;"  </#if> >锁定</a>
               				<a id="unClockUser${item.id}" href="javascript:updateUserState('${item.id}','1');"<#if (item.state == "1") > style="display: none;padding-right: 5px;"  </#if> >解锁</a>
              			</#if>
                    	
						
                    </td>
                </tr>
	      		</#list>	
	      	<#else>
	      		<tr><td colspan="8"><div class="yt-tb-list-no">暂无内容</div></td></tr>
			</#if>
            </tbody>
            </table> 
     	</div>
     	
		
		<div class="div-pl-bt">
			<!-- 翻页标签 -->
			<#import "../../common.ftl"  as page>
			<@page.queryForm formId="queryForm" />
			
		</div>
	</div>
</div>
</body>
</html>