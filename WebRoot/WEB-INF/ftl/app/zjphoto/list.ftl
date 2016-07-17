<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众平台管理系统</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/bootstrap.min.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/bootstrap-combined.min.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js?t=2013122302'></script>
<!--[if lte IE 9]>
<script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js?t=2013122302'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">栏目设置</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
	<li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getPhotos.kq?almid=<#if album?? >${album.id?default("")}</#if>" name="qcust" id="qcust" method="post">
	<p>
		<#if album?? >
			相册：${album.name}
		<#else>
			获取相册名称失败
		</#if>
	</p>
	
	<a class="btn btn-primary" href="${BasePath}/zj/addPhotoForward.kq?almid=${album.id?default("")}">上传照片</a>
    </form>
    
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="thumbnails">
			
<#if pageFinder?? && (pageFinder.data)?? >
	<#list pageFinder.result as item>	
				<li class="span4">
					<div class="thumbnail" style="width: 80%;">
					
						<img alt="200x100" src="<#if item.url??>${BasePath}/${item.url}<#else>${BasePath}/images/app/zj/untitled.png</#if>"/>
						
						
						<div class="caption">
							<p>
								<a class="btn" href="${BasePath}/zj/removePhoto.kq?id=${item.id?default("")}&almid=<#if album??>${album.id?default("")}</#if>" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，继续删除吗？')){return false};">删除</a>
							</p>
						</div>
						
						
					</div>
				</li>
	</#list>	
<#else>
	<div class="yt-tb-list-no">暂无内容</div>
</#if>

			</ul>
		</div>
	</div>
</div>
    

    <div class="blank20"></div>
<!-- 翻页标签 -->
<#import "../app-common.ftl"  as page>
<@page.queryForm formId="qcust" />

</body>
</html>