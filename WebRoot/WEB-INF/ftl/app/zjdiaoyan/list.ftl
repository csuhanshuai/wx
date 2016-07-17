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
				
				
				<li class="cur"><a href="${BasePath}/zjdiaoyan/getDiaoyanList.kq">微调研</a></li>

            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
    <div class="alert alert-info">
		<p><span class="bold">注意：</span>当前活动配额为5个。如活动配额满请删除已结束活动</p>
		<p><span class="bold">注意：</span>如果手动停止活动那么数据将不会保留</p>
	</div>
	<#if (diaoyanlist?size < 5) >
		<form action="${BasePath}/zjdiaoyan/getDiaoyanList.kq" name="qcust" id="qcust" method="post">
			<a href="${BasePath}/zjdiaoyan/addDiaoyanForward.kq" class="btn_green btn_w_120">新增</a>
	    </form>
    </#if>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
		<!--
                <td  nowrap="nowrap">公共账号</td>
		-->
                <td  nowrap="nowrap">活动名称</td>
                <td  nowrap="nowrap">关键字</td>
                <td  nowrap="nowrap">活动时间</td>
                <td  nowrap="nowrap">状态</td>
                <td  nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if diaoyanlist?? && (diaoyanlist?size>0) >
	      	<#list diaoyanlist as item>		
				<tr>
					<td>${item_index+1}</td>
					<!--
					<td>${item.openId?default("")}</td>
					-->
					<td>${item.activeName}</td>
					<td>${item.keyword}</td>
					<td>${item.activeStartTime} 至 ${item.activeEndTime}</td>
					<td>
					   <#if item.status=='0'>
					 		未开始
					 	<#elseif item.status=='1'>
					 		进行中
					 	<#elseif item.status=='2'>
					 	    已结束
					 	<#elseif item.status=='3'>
					 	    已终止
					 	</#if>
					</td>
					<td>
					    <#if item.status=='0'>
					       [<a href="${BasePath}/zjdiaoyan/updatediaoyanBefore.kq?id=${item.id}">修改</a>][<a href="${BasePath}/zjdiaoyan/addquestion.kq?id=${item.id}">设置题目</a>][<a href="#" onclick="delDiaoyan('${item.id}')">删除</a>]
					    <#elseif item.status=='1'>
					       [<a href="${BasePath}/zjdiaoyan/viewdiaoyanById.kq?id=${item.id}">查看</a>][<a href="${BasePath}/zjdiaoyan/statdiaoyan.kq?id=${item.id}">统计图表</a>][<a href="#" onclick="stopDiaoyan('${item.id}')">停止</a>]
					    <#elseif item.status=='2'>
					       [<a href="${BasePath}/zjdiaoyan/viewdiaoyanById.kq?id=${item.id}">查看</a>][<a href="${BasePath}/zjdiaoyan/statdiaoyan.kq?id=${item.id}">统计图表</a>][<a href="#" onclick="delDiaoyan('${item.id}')">删除</a>]
					    <#elseif item.status=='3'>
					       [<a href="${BasePath}/zjdiaoyan/viewdiaoyanById.kq?id=${item.id}">查看</a>][<a href="${BasePath}/zjdiaoyan/statdiaoyan.kq?id=${item.id}">统计图表</a>][<a href="#" onclick="delDiaoyan('${item.id}')">删除</a>]
					    </#if>   
					 </td>
				</tr>
			</#list>
		<#else>
            <tr>
                <td colspan="6">
                    <div class="yt-tb-list-no">暂无内容</div>
                </td>
            </tr>
		</#if>
        </tbody>
    </table>
<div class="blank20"></div>
</div>  
</div>
</body>
<script>
function delDiaoyan(id)
{
    if(confirm("确认删除这个活动？"))
	{
		window.location.href="${BasePath}/zjdiaoyan/deletediaoyanById.kq?id=" + id;
	}
}

function stopDiaoyan(id)
{
   if(confirm("确认停止这个活动？(请注意活动停止后数据将不保留)"))
   {
		window.location.href="${BasePath}/zjdiaoyan/stopdiaoyanById.kq?id="+id;
	}
}

</script>
</html>