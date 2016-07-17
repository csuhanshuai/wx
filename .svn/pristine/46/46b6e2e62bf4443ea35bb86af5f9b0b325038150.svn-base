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
				<li><a href="${BasePath}/zj/getSignin.kq">微签到</a></li>
            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
    <div class="alert alert-info">
		<p><span class="bold">注意：每个“微调研”活动最多能新建20个题目</p>
	</div>
	<form action="${BasePath}/zjdiaoyan/getDiaoyanList.kq" name="qcust" id="qcust" method="post">
	   <input type="hidden" name="relationDiaoyanId" value="${relationDiaoyanId}"/>
	    <#if questionlist?size< 20>
	       <a href="${BasePath}/zjdiaoyan/setquession.kq?relationDiaoyanId=${relationDiaoyanId}" class="btn_green btn_w_120">新增题目</a>
	   </#if>
	   <a href="${BasePath}/zjdiaoyan/getDiaoyanList.kq" class="btn_gray">返回</a>
	 
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">题目名称</td>
                <td  nowrap="nowrap">最多可选择答案的个数</td>
                <td  nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if questionlist?? && (questionlist?size>0) >
	      	<#list questionlist as item>		
				<tr>
					<td>${item_index+1}</td>
					<td>${item.questionName?default("")}</td>
					<td>${item.anwserMaxNum}</td>
					<td>
					   [<a href="${BasePath}/zjdiaoyan/updateTitleBefore.kq?id=${item.id}&relationDiaoyanId=${relationDiaoyanId}">修改</a>][<a href="#" onclick="delTitle('${item.id}','${relationDiaoyanId}')">删除</a>]   
					 </td>
				</tr>
			</#list>
		<#else>
            <tr>
                <td colspan="9">
                    <div class="yt-tb-list-no">暂无内容</div>
                </td>
            </tr>
		</#if>
        </tbody>
    </table>
    </form>
<div class="blank20"></div>
</div>  
</div>
</body>
<script>
function delTitle(id,relId)
{
    if(confirm("确认删除这个活动？"))
	{
		window.location.href="${BasePath}/zjdiaoyan/deleteTitleById.kq?id="+id+"&relationDiaoyanId=" +relId;
	}
}


</script>
</html>