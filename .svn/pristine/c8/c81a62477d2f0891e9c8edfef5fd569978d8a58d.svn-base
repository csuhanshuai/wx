<!DOCTYPE HTML>
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

<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
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
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">栏目设置</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
	<li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>


<div id="url" class="r_con_wrap">
	<form action="${BasePath}/zj/getAlbum.kq" name="qcust" id="qcust" method="post">
            <a href="${BasePath}/zj/addAlbumForward.kq" class="btn_green btn_w_120">新增相册</a>
    </form>
    
    <br/>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="thumbnails">
			
<#if pageFinder?? && (pageFinder.data)?? >
	<#list pageFinder.result as item>	
				<li class="span4">
					<div class="thumbnail" style="width: 80%;">
					
					<a href='${BasePath}/zj/getPhotos.kq?almid=${item.id?default("")}'>
					
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
								<img alt="200x100" style="width:200;heigth=200" src="${BasePath}/images/app/zj/untitled.png"/>
							<#else>
								<#if coverslist?? && (coverslist?size>0) >
									<#assign flag="0"/>
									<#list coverslist as photo>
				 					<#if photo?? && (photo.almid==item.id) && photo.iscovers=='1' >
				 						<img alt="200x100" style="width:200;heigth=200" src="${BasePath}/${photo.url}"/>
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
							<img alt="200x100" style="width:200;heigth=200" src="${BasePath}/images/app/zj/untitled.png"/>
						</#if>
					
						
						</a>
						
						
						<div class="caption">
							<p>
								<a href='${BasePath}/zj/getPhotos.kq?almid=${item.id?default("")}'>${item.name?default("")}</a>
							</p>
							<p>
								<a class="btn btn-primary" href="${BasePath}/zj/addPhotoForward.kq?almid=${item.id?default("")}">上传照片</a>
								<a class="btn" href="${BasePath}/zj/removeAlbum.kq?id=${item.id?default("")}" target="content" onclick="if(!confirm('非专业人士请谨慎操作，删除后不可恢复，继续删除吗？')){return false};">删除</a>
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