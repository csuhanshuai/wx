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

</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    
	<li><a href="">投票信息管理</a></li>
	
   </ul>
</div>



<div id="url" class="r_con_wrap">
	<!--<form action="${BasePath}/zj/getZhaopin.kq" name="qcust" id="qcust" method="post">
            <a href="${BasePath}/zj/addZhaopinForward.kq">
		<input type="button" class="btn_green" value="新增" name="submit_btn"  id="submit_btn">
		</a>
		
		<a class="btn_green btn_w_120">投票详细信息列表</a>
    </form>-->
    <table border="0" cellpadding="5" cellspacing="0" class="r_con_table">
<thead>
    <tr>
        <td width="5%" nowrap="nowrap">序号</td>
        <td width="5%" nowrap="nowrap">编号</td>
	    <td width="10%" nowrap="nowrap">姓名</td>
        <td width="25%" nowrap="nowrap">标题</td>
	    <td width="5%" nowrap="nowrap">联系人</td>
	    <td width="30" nowrap="nowrap">联系人号码</td>
	    <td width="5%" nowrap="nowrap">获票</td>
	    
        <td width="10%" nowrap="nowrap" class="last">操作</td>
    </tr>
</thead>
<tbody>
	<#if voteApplys?? >
			  		<#list voteApplys as item>
			  		<tr>
			  			  <td nowrap="nowrap">
							${item_index+1}               
						 </td>
						<td nowrap="nowrap">
							${item.code?default('')}               
						 </td>
						<td nowrap="nowrap">
							${item.name?default('')}      
						</td>
						<td nowrap="nowrap">
							${item.title?default('')}      
						</td>
						<td nowrap="nowrap">
							${item.linkMan?default('')}      
						</td>
						<td nowrap="nowrap">
							${item.linkMobelNumber?default('')}      
						</td>
						<td nowrap="nowrap">
							${item.voteCount?default('')}
						</td>
						
						    <td class="last" nowrap="nowrap">
						    <!--<a href="javascript:getVoteDetail('${item.id}');">详情</a>&nbsp;&nbsp;-->
						    <a href="${BasePath}/vote/getVoteDetail.kq?id=${item.code}">票数详情</a>&nbsp;&nbsp;
						    </td>
					</tr>
			  		</#list>				  	
					<#else>
					<tr><td colspan="5"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>  
					
    </tbody>
</table>
<div class="blank20"></div>


</div>  </div>
</body>
<script>
	function getVoteDetail(id){
	alert(id);
	alert(BasePath+"/vote/getVoteDetail.kq?id="+id);
		//showThickBox("投票信息明细",BasePath+"/vote/getVoteDetail/"+id+".kq?TB_iframe=true&height=300&width=750",false);
		showThickBox("投票信息明细",BasePath+"/vote/getVoteDetail.kq?id="+id+"&TB_iframe=true&height=300&width=750",false);
		
	}

</script>
</html>