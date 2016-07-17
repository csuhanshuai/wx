<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var BasePath="${BasePath}";
</script>

<title>微信公众平台管理系统</title>

<link rev="stylesheet" rel="stylesheet" type="text/css" href="${BasePath}/css/thickbox.css"  media="screen" />
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type="text/javascript"  src="${BasePath}/js/common/thickbox/thickbox.js"></script>
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>

<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />



</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>


<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li class="<#if type=='questionList'>cur</#if>"> <a href="${BasePath}/lanterngame/listQuestion.kq">竞猜题目管理</a></li>
	<li class="<#if type=='queryGameList'>cur</#if>"> <a href="${BasePath}/lanterngame/queryGameList.kq">游戏查询</a></li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/lanterngame/listQuestion.kq" name="qcust" id="qcust" method="post">
		<table border="0" cellpadding="5" cellspacing="0">
	        <tr>       
		        <td>        
		        <a href="${BasePath}/lanterngame/toAddQuestion.kq" class="btn_green btn_w_120">新增考题</a>
				<!--<input type="button" class="btn_green" value="导出Excel" name="toExcel_btn"  id="toExcel_btn">	
				-->
				</td>
	        </tr>
	    </table>
	    <div style="height:10px;"> </div>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">标题</td>
		        <td width="10%" nowrap="nowrap">内容</td>
		        <td width="10%" nowrap="nowrap">正确答案</td> 
		        <td width="10%" nowrap="nowrap">最长答题时间</td>
		        <td width="10%" nowrap="nowrap">题目分数</td>
		        <td width="10%" nowrap="nowrap">操作</td>
            </tr>
        </thead>
        <tbody>
        
        
       <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
			 <tr id='Tr${item.id}'>
			 				 <input type="hidden" >
							 <td>${item_index+1}</td>
							 <td>${item.title?default("")}</td>
							 <td>${item.content?default("")}</td>
							 <td>${item.rightTitle?default("")}</td>
							 <td>${item.maxSubmitTime?default("")}秒</td>
							 <td>${item.topicScore?default("")}</td>
							 <td nowrap="nowrap" class="left last">
								<a href="javascript:getTopDetail('${item.id}');">详情</a>&nbsp;&nbsp;
								<a href="${BasePath}/lanterngame/toAddQuestion.kq?type=mod&questionID=${item.id}">
								<img src="${BasePath}/images/icon/mod.gif" align="absmiddle" alt="修改">
								</a>&nbsp;&nbsp;
								<a href="${BasePath}/lanterngame/deleteQuestion.kq?type=mod&questionID=${item.id}"  target="content" onclick="if(!confirm('确认删除该记录吗?')){return false};">
							    	<img src="${BasePath}/images/icon/del.gif" align="absmiddle" alt="删除">
							    </a>
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
<@page.queryForm formId="qcust" />    

<script type='text/javascript' >
	function getTopDetail(questionId)
	{	
		showThickBox("考题信息明细",BasePath+"/lanterngame/getQuestionDetailForward/"+questionId+".kq?TB_iframe=true&height=300&width=750",false);
	}
</script>    
    
</body>
</html>
<script type="text/javascript" >
$(document).ready(function() {
	$("#addButton").click(function(){	 
		document.getElementById("qcust").submit();
	})

	// 发达ajax请求
	function ajaxRequest(url, reqParam, callback) {
	 $.ajax({ 
			type : 'POST',
			url : url,
			data : reqParam,
			cache : true,
			success : callback
		});
	}
</script>