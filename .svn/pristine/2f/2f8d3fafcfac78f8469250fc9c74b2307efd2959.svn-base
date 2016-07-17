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
<script>
	function changeDefaultValue(value)
	{
	     if(value == "0")
		 {
			 document.getElementById("condition").placeholder = "请输入工号";
		 }
		 else if(value == "1")
		 {
			 document.getElementById("condition").placeholder = "请输入姓名";
		 }
	}
</script>


</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>



<div id="url" class="r_con_wrap">
    
    
    <div style="height:10px;"> </div>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
		        <td width="10%" nowrap="nowrap">答题工号</td>
		        <td width="10%" nowrap="nowrap">员工姓名</td> 
		        <td width="10%" nowrap="nowrap">题目</td>
		        <td width="10%" nowrap="nowrap">答案</td>
		        <td width="10%" nowrap="nowrap">答题花费时间</td>
		         <td width="10%" nowrap="nowrap">得分</td>
            </tr>
        </thead>
        <tbody>
       <#if quizTopicReplyList??>
		      		<#list quizTopicReplyList as item>		
			 <tr id='Tr${item.id}'>
							 <td>${item_index+1}</td>
							 <td>${item.replyJobNumber?default("")}</td>
							 <td>${item.empName?default("")}</td>
							 <td>${item.topicTitle?default("")}</td>
							 <td>${item.answerResult?default("")}</td>
							 <td>${item.replySpendTime?default("")}秒</td>
							 <td>${item.score?default("")}</td>
		                </tr>
		      		</#list>	
		      	<#else>
		     <tr><td colspan="8"><div class="yt-tb-list-no">暂无内容</div></td></tr>
	    </#if>
	     </tbody>
    </table>
    <div class="blank20"></div>
    
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