<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
		    <ul>
	<li class="cur"><a href="${BasePath}/zj/getActivities.kq?type=1">活动报名</a></li>

            </ul>
		</div>

<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zjhuodong/getBaomingList.kq" name="qcust" id="qcust" method="post">
	    <input type="hidden" name="activitiesid" id="activitiesid" value="${baoming.activitiesid?default('')}"/>
		<table border="0" cellpadding="5" cellspacing="0">
	        <tr>
	            <td>姓名 <input type="text" name="name" id="name" value="${baoming.name?default('')}" size="25" class="form_input" notnull /></td>
	            <td>电话 <input type="text" name="mobile" id="mobile" value="${baoming.mobile?default('')}" size="25" class="form_input" notnull /></td>
	            <td>
	              <input type="button" class="submit" value="查询" name="submit_btn" id="submit_btn" onclick="queryList()">&nbsp;&nbsp;&nbsp;&nbsp;
	              <a href="${BasePath}/zjhuodong/getBaomingListToExcel.kq" >导出Excel</a>
	            </td>
	        </tr>
	     </table>
	    <!--
	     <a href="${BasePath}/zjhuodong/addBaomingForward.kq" class="btn_green btn_w_120">活动报名</a>
	     -->
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">联系人名称</td>
                <td  nowrap="nowrap">联系人电话</td>
                <td  nowrap="nowrap">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>	
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.name?default("")}</td>
	                <td>${item.mobile?default("")}</td>
	                <td>
	                   <a href="#" onclick="javascript:upateHd('${item.id}','${item.activitiesid}')" >修改</a>
	                   <a href="#" onclick="javascript:del('${item.id}','${item.activitiesid}')">删除</a>
	                </td>
	            </tr>
	        </#list>	
	    <#else>
		    <tr><td colspan="4"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if> 
        </tbody>
    </table>
<div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="qcust" />
</div> 
</div> 
</div>
</body>
<script>

function del(id,actid)
{
    if(confirm("确认删除这个活动？"))
	{
		window.location.href="${BasePath}/zjhuodong/deleteBaomingById.kq?id="+id+"&activitiesid="+actid;
	}
	
}

function upateHd(id,actid)
{
    window.location.href="${BasePath}/zjhuodong/updateBaomingBefore.kq?id="+id+"&activitiesid="+actid;
}

function queryList()
{
/*
    if(document.getElementById("name").value == "" && document.getElementById("mobile").value == "")
    {
        alert("请输入查询条件！");
        return;
    }
    */
    document.getElementById("qcust").submit();	 
}
</script>
</html>