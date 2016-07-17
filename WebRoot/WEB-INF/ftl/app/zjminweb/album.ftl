<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>我的微相册</title>

<meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="${BasePath}/css/app/zj/common.css" rel="stylesheet">
<link href="${BasePath}/css/app/zj/photo.css" rel="stylesheet">
<script src="${BasePath}/js/app/zj/zepto.min.js" type="text/javascript"></script>
<style>
.page-url-link{
	color: gray;
}
</style></head>

<body style="background-color:#ff6699">
<div id="photo">
	<h4 style=" color:#ffffff;text-algin:left;text-indent:12px;">我的微相册</h4>
	
	<ul class="chatPanel fn-clear">
		
		
		
		
<#if albumlist?? && (albumlist?size>0) >
	<#list albumlist as item>	
	
		<li class="media mediaFullText" data-index="0">
			<a href="${BasePath}/zj/zjminweb/getPhotoList.kq?almid=${item.id}">
				<div class="mediaPanel">
					<div class="mediaHead">
						<div class="clr"></div>
					</div>
					<div class="mediaImg" style="width: auto;">
					
					
						<#if photolist?? && (photolist?size>0) >
							<#assign havaphotoflag="0"/>
							<#if photolist?? && (photolist?size>0) >
								<#list photolist as photo>
			 						<#if photo?? && (photo.almid==item.id)>
			 							<#assign havaphotoflag="1"/>
			 						</#if>
								</#list>
							</#if>
							<#if havaphotoflag!='1'>
								<img class="cover" src="${BasePath}/images/app/zj/untitled.png">
							<#else>
								<#if coverslist?? && (coverslist?size>0) >
									<#assign flag="0"/>
									<#list coverslist as photo>
				 					<#if photo?? && (photo.almid==item.id) && photo.iscovers=='1' >
				 						<img class="cover" src="${BasePath}/${photo.url}">
				 						<#assign flag="1"/>
									</#if>
									</#list>
									<#if flag!='1'>
										<div class="img" id="MsgImgDetail">无封面</div>
									</#if>
								<#else>
									<div class="img" id="MsgImgDetail">无封面</div>
								</#if>
							</#if>
						<#else>
							<img class="cover" src="${BasePath}/images/app/zj/untitled.png">
						</#if>
					
						
						</div>
					<div class="mediaFooter">
						<span class="mesgIcon right"></span><span class="bt">${item.name}</span>
						<div class="clr"></div>
					</div>
				</div>
			</a>
		</li>



	</#list>	
<#else>
	<div class="yt-tb-list-no">暂无内容</div>
</#if>



		
	</ul>
	
	

<!--
<p class="page-url"><a class="page-url-link" href="http://www.weijuju.com" target="_blank">此功能由“微俱聚”平台提供</a></p>
-->



</div>

</body></html>