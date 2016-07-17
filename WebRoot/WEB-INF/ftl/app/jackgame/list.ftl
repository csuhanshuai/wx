<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	var BasePath="${BasePath}";
</script>

<link rev="stylesheet" rel="stylesheet" type="text/css" href="${BasePath}/css/thickbox.css"  media="screen" />





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"  src="${BasePath}/js/common/thickbox/thickbox.js"></script>

<title>微信公众平台管理系统</title>

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>

<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<style>
.blakn-sl{width:172px;float:left;border:#7f9db9 solid 1px;margin-right:10px;height:18px;}
.div-pl-hd{}
.div-pl-hd{height:auto;overflow:auto;}/*rewrite*/
.div-pl-hd span{display:block;height:20px;width:auto;float:left; line-height:20px;margin-right:5px;}
.div-pl-hd .timer-con{margin-right:15px;}
.ft-sz-12{font-size:12px;}
.btn-sh{width:57px;height:23px; background:url(../images/ecsystem/btn-affirm-bg.gif) no-repeat; border:0; line-height:23px; text-align:center; cursor:pointer;float:left;margin-right:10px;}
</style>
</head>

<body>



<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li class="cur">游戏查询</li>
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/jackgame/listJakeGameRecord.kq" name="qcust" id="qcust" method="post">
	    <!--<a href="${BasePath}/jackgame/listJakeGameRecord.kq" class="btn_green btn_w_120">游戏查询</a>-->
	    <div class="div-pl-hd ft-sz-12">
			<span>工号：</span>
			<input name="jobNumber" class="blakn-sl" value="">
			
			<span>姓名：</span>
			<input name="empName" class="blakn-sl" value="">
			<a href="javascript:document.qcust.submit();" class="btn-sh">搜索</a>
		</div>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td width="5%" nowrap="nowrap">序号</td>
                <td width="10%" nowrap="nowrap">工号</td>
                <td width="10%" nowrap="nowrap">姓名</td>
		        <td width="10%" nowrap="nowrap">微信号</td>
		        <td width="10%" nowrap="nowrap">开始时间</td>
		        <td width="10%" nowrap="nowrap">结束时间</td>  
		          <td width="10%" nowrap="nowrap">分数</td>   
            </tr>
        </thead>
        <tbody>
                    
    <#if pageFinder?? && (pageFinder.data)?? >
	      		<#list pageFinder.result as item>		
	      		<tr id='Tr${item.id}'>
					 <td>${item_index+1}</td>
					 <td>${item.jobNumber?default("")}</td>
		             <td>${item.empName?default("")}</td>
		             <td>${item.openId?default("")} </td>
					 <td>${item.beginTime?default("")}</td>
					 <td>${item.endTime?default("")}</td>
					 <td>${item.score?default("")}</td>                             
                </tr>
	      		</#list>	
	      	<#else>
	      		<tr><td colspan="9"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if>
                   
                </tbody>
    </table>
    <div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="qcust" />

</body>
<script type="text/javascript">
	function getActivitiesDetail(id)
	{
		showThickBox("活动信息明细",BasePath+"/actInfoManage/getActInfoDetailForward/"+id+".kq?TB_iframe=true&height=450&width=750",false);
	}
</script>
</html>