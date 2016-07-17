<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var BasePath="${BasePath}";
	var searchType="${searchType}";
	var conditionValue="${conditionValue}";
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
<script>
	function changeDefaultValue(value)
	{
		 var condition=document.getElementById("condition");
	     if(value == "0"){
			 if(searchType=='empName'){
			 	condition.value="";
			 	condition.placeholder = "请输入工号";
			 }else{
			 	if(conditionValue!=""){
			 		condition.value=conditionValue;
			 	}else{
			 		condition.value="";
			 		condition.placeholder = "请输入工号";
			 	}
			 }
		 }else if(value == "1"){
		 	if(searchType=='jobNumber'||searchType==''){
			 	condition.value="";
			 	condition.placeholder = "请输入姓名";
			 }else{
			 	if(conditionValue!=""){
			 		condition.value=conditionValue;
			 	}else{
			 		condition.value="";
			 		condition.placeholder = "请输入姓名";
			 	}
			 }
		 }
	}
</script>


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
	<form id="qcust" class="add_form " method="post" action="${BasePath}/lanterngame/queryGameList.kq">
        <table border="0" cellpadding="5" cellspacing="0">
        	<tr>
		        <td colspan="2">
			        <input  type="radio" name="searchType" value="jobNumber"  <#if searchType=='jobNumber'||searchType==''>checked="checked"</#if> onclick="changeDefaultValue(0)">
			        <span>工号</span>
			        <input  type="radio" name="searchType" value="empName" <#if searchType=='empName'>checked="checked"</#if> onclick="changeDefaultValue(1)">
			        <span>姓名</span>
		        </td>
		    </tr>
            <tr>
                <td><input type="text" id="condition"  placeholder="请输入工号" name="condition" value="${conditionValue}"   size="25" class="form_input" notnull /></td>
                <td><input type="submit" class="submit" value="查询" name="submit_btn">&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>
    
    
    <div style="height:10px;"> </div>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">工号</td>
		        <td width="10%" nowrap="nowrap">姓名</td>
		        <td width="10%" nowrap="nowrap">微信号</td> 
		        <td width="15%" nowrap="nowrap">开始时间</td>
		        <td width="15%" nowrap="nowrap">结束时间</td>
		        <td width="10%" nowrap="nowrap">分数</td>
		        <td width="10%" nowrap="nowrap">操作</td>
            </tr>
        </thead>
        <tbody>
        <#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>		
	 			<tr id='Tr${item.id}'>
	 				 <input type="hidden" >
					 <td>${item_index+1}</td>
					 <td>${item.jobNumber?default("")}</td>
					 <td>${item.empName?default("")}</td>
					 <td>${item.wxNumber?default("")}</td>
					 <td>${item.beginTime?default("")}</td>
					 <td>${item.endTime?default("")}</td>
					 <td>${item.score?default("")}</td>
					 <td align="center">
						<a href="javascript:getTopDetail('${item.id}');">详情</a>
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
	function getTopDetail(gameId)
	{	
		showThickBox("答题明细",BasePath+"/lanterngame/queryTopicListofOneGame/"+gameId+".kq?TB_iframe=true&height=300&width=750",false);
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