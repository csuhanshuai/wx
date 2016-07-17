<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
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
                <li class="cur"><a href="${BasePath}/zj/getSignin.kq">微签到</a></li>
            </ul>
		</div>


<script language="javascript">$(document).ready(wechat_obj.url_init);</script>
<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getSignin.kq" name="qcust" id="qcust" method="post">
		<a href="${BasePath}/zj/addSigninForward.kq" class="btn_green btn_w_120">增加微签到</a>
    </form>
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
        <thead>
            <tr>
                <td  nowrap="nowrap">序号</td>
                <td  nowrap="nowrap">微签到名称</td>
                <td  nowrap="nowrap">内容URL</td>
                <td  nowrap="nowrap">录入时间</td>
                <td  nowrap="nowrap">二维码</td>
                <td  nowrap="nowrap">状态</td>
                <td  nowrap="nowrap" class="last">操作</td>
            </tr>
        </thead>
        <tbody>
                    
		<#if pageFinder?? && (pageFinder.data)?? >
	      	<#list pageFinder.result as item>	
	      		<tr>
					<td colspan="9" id="showtr${item_index+1}" style="display: none;color:#31708f;background-color:#d9edf7;border-color:#bce8f1;" >

						${item.url?default("")}
		
					 </td>
				</tr>
	            <tr>
	                <td nowrap="nowrap">${item_index+1}  </td>
	                <td>${item.name?default("")}</td>
	                <td>
	                
	                <a class="popalink"   href="javascript:showlink('showtr${item_index+1}')"   
 title="此链接可用于微官网、自定义URL等" >链接</a>
	                </td>
	                <td>
	                	${item.intime?string('yyyy-MM-dd')}
	                </td>
	                <td>
	                <a href="${BasePath}/${item.path?default("")}" target="_blank"><img src="${BasePath}/${item.path?default("")}" style="width:30px;height:30px;"></a>
	                
	                </td>
	                <td>
	                	<#if item.status=='0'>
					 		正常
					 	<#elseif item.status=='1'>
					 		已停用
					 	<#else>
					 	--
					 	</#if>
	                
	                </td>
	                <td class="last" nowrap="nowrap">
	                	<a href="${BasePath}/zj/getSigninrecord.kq?signinid=${item.id}" >签到明细</a>
	                	<#if item.status=='0'>
		                	<a href="${BasePath}/zj/updateSignin.kq?id=${item.id}&status=1" >停用</a>
					 	<#else>
					 	--
					 	</#if>
	                </td>
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
    
	</div>  
</div>


<script>
	
	function changeDefaultValue(value)
	{
	     if(value == "0")
		 {
			 document.getElementById("condition").placeholder = "请输入会员卡号";
		 }
		 else if(value == "1")
		 {
			 document.getElementById("condition").placeholder = "请输入手机号";
		 }
	}
	
  function showlink(obj)
  {

	$('#'+obj).toggle(200); 
	
  }
	
</script>
</body>
</html>