<html><head>
<meta charset="utf-8">

<link rel="stylesheet" href="${BasePath}/css/mc.css">
<link rel="stylesheet" href="${BasePath}/css/dialog.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dialog_min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/main.js"></script>

<title>活动页</title>
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
	
</script>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<style>
.list_exchange li[data-card] figure img {
	width: 280px;
	height: 155px;
}

.list_exchange li[data-card] p {
	padding: 0px 11px;
}

.list_exchange li[data-card] .tbox p {
	padding: 0px;
}
.body .des {
	border-top: 1px dashed #dddddd;
	margin: 10px;
	padding: 10px;
	padding-bottom: 0;
}
.body section {
	height: 212px;
	overflow: hidden;
}
.body li[data-card].on section{
	height:auto;
}
</style>
</head>
<body onselectstart="return true;" ondragstart="return false;"><section id="dialoger"><div class="dialogCover"></div></section>



	<div class="container exchange " style="color:#ff6699">
		<div class="body">
			<ul class="list_exchange">



	<#if activitieslist?? && (activitieslist?size>0) >
	      	<#list activitieslist as item>
				<a href="javascript:isInMemberlevel('<#if item.url!='0'>${item.url?default("")}?bid=${bid?default("")}&openid=${openid?default("")}&activitiesid=${item.id?default("")}<#else>#</#if>','${bid?default("")}','${openid?default("")}','${item.id?default("")}')">
				<li data-card="" onclick="//this.classList.toggle('on');" style="height:315px">
				<header  style="height:59px">
						<ul class="tbox">
							<li>
								<h5>${item.name?default("")}</h5>
								<p>活动截止：${item.endtime?string("yyyy-MM-dd")}</p>
							</li>
						</ul>
					</header>
					<section style="height:212px">
						<div>
							<figure>
								
								<img src="${BasePath}/${item.photourl?default("")}">
								
							</figure>
							<p>${item.description?default("")}</p>
						</div>
					</section>
					
					<#if item.type=='1'>
					<footer style="height:44px">
						<dl class="box">
							<dd>
								<label><big></big></label>
							</dd>
							<dd>
								<a href="javascript:isInMemberlevel('${BasePath}/zjhuodong/zjminweb/addForward.kq?activitiesid=${item.id?default("")}&bid=${bid?default("")}&openid=${openid?default("")}','${bid?default("")}','${openid?default("")}','${item.id?default("")}')">我要报名</a>
							</dd>
						</dl>
					</footer>
					</#if>
					
				</li>
				</a>
					
			</#list>
		<#else>
						<div class="tbox">暂无记录</div>
							
		
		</#if>
		
		
			</ul>
			
		</div>
	
	
	
	
	
	
	
	
	






<style>
footer .nav li.myli>a.on>p, footer .nav li.myli>a.active>p {
	background-position-y: -40px;
}
</style>






	</div>
	<div mark="stat_code" style="width: 0px; height: 0px; display: none;">
	</div>


<script>

	function isInMemberlevel(url,bid,openid,activitiesid)
	{
		$.ajax({
				url: BasePath+"/zj/zjminweb/isInMemberlevel.kq?bid="+bid+"&openid="+openid+"&activitiesid="+activitiesid,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var response = eval("(" +result+")" );
	    		    if(response.result == 'success'){
	    		    	
	    		    	if(url && '#' != url)
	    		    	{
	    		    		window.location.href = url;
	    		    	}
					}
	    		    else
	    		    {
	    		    	alert(response.message,1500);
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!',1500);
	    		    }
			});
	}

</script>

</body></html>