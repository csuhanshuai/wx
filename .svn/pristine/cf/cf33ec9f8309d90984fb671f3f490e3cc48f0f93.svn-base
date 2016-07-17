<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>我的微相册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${BasePath}/css/app/zj/common.css">
<link rel="stylesheet" href="${BasePath}/css/app/zj/photo.css">
<link rel="stylesheet" href="${BasePath}/css/app/zj/photoswipe.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/klass.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/code.photoswipe.jquery-3.0.5.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/jquery.lazyload.js"></script>
<script type="text/javascript">
(function(window, PhotoSwipe){
document.addEventListener('DOMContentLoaded', function(){
var options = {},
instance = PhotoSwipe.attach( window.document.querySelectorAll('#Gallery a'), options );
}, false);
}(window, window.Code.PhotoSwipe));
</script>
<script type="text/javascript"> 
jQuery(document).ready( 
	function($){ 
		$("img").lazyload({ 
		placeholder : "路径/grey.gif", 
		effect      : "fadeIn" 
	}); 
}); 
</script> 

<style>
#main {
	padding: 11px 0 10px 0;
	margin:0 auto;
}
#Gallery {
	list-style-type: none;
	position: relative; 
	margin: 0;
}
#Gallery li {
	width: 140px;
	background-color: #ffffff;
	border: 1px solid #ffffff;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	display: none;
	cursor: pointer;
	padding: 4px;
	
	box-shadow:0 0 2px 0 rgba(0, 0, 0, 0.1);
	-moz-box-shadow:0 0 2px 0 rgba(0, 0, 0, 0.1);
	-webkit-box-shadow:0 0 2px 0 rgba(0, 0, 0, 0.1);
}

#Gallery li img {
	display: block;
	width:100%
}
#Gallery li p {
	color: #666;
	font-size: 12px;
	margin: 5px 0 0 0px;
	white-space: nowrap;
	text-overflow:ellipsis;
	overflow:hidden;
	text-align:center
}
#Gallery ali:nth-child(3n) {
	height: 175px;
}

#Gallery ali:nth-child(4n-3) {
	padding-bottom: 30px;
}

#Gallery ali:nth-child(5n) {
	height: 250px;
}
.plugback {
	position: fixed;
	bottom: 0;
	right: 0;
	z-index: 19000;
}
.plugbg {
	width: 36px;
	height: 36px;
	border-radius: 36px;
	position: absolute;
	bottom: 16px;
	right: 16px;
	z-index: 999;
	-moz-box-shadow: 0 0 0 4px #FFFFFF, 0 2px 5px 4px rgba(0, 0, 0, 0.25);
	-webkit-box-shadow: 0 0 0 4px #FFFFFF, 0 2px 5px 4px rgba(0, 0, 0, 0.25);
	box-shadow: 0 0 0 4px #FFFFFF, 0 2px 5px 4px rgba(0, 0, 0, 0.25);
	background-color: #DE1A04;
}
.plugbg span {
	display: block;
	width: 28px;
	height: 28px;
	background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAYAAACohjseAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAHmSURBVGhD7do/RMRhHMfxIyIi4oiIpoiIpmhqimhqiqZoamqK1qamiGhqampqimi9temmiKaIiIjIXe+P59sl193v+V3L7/v0vHmGy/P8fF/9O36/q+VyuVwuV4Ha7fZoq9Uat5dpJRirwZqzL6UTqDrrlp9gOzkgoElWUziVFBDPFKD7QAslAwQyw3owV6ckgCBmWY9m+pF7IIYFEM+B051rIMMvYngJlN9zC2TwZdabOXrmEsjQqzE45Q7IwOusd5u/MFdAht1kfdjsUbkBMut2GLlcLoAMuWvzVrUxG7V84PbtIlVuMCC4Q7tA1SsPBHdshz0UD2TzELizcM5NcUA2DoM7D2dcVQxkk3CXYb+7+gOBjbCubbPHCoEnttFr/YHaALIR9rqs+G/Qfk1v7IC3ioHKkFd2yFNxQMVm/Te9COfcFA9UHNCbvaf3w3LAr0Ce2gWq3mBABfLILlLlBgcqkAd2oar2N6DiInvhWuXim+PqnsyOzR2dK6Bi4C1W9I0nd0DF0BuxSJdAxeBrrML7o26BiuFXWH3vcLsGKgxLIF4Dpzv3QAWi51OmJIAKyzyYp8D6LhmgAtP1pDcpoAI0zeo8q08OqHDp0xZ3yQIVtglwzWSBCpw+8VS3l7lc7l9Uq30CYANiTWVFDNwAAAAASUVORK5CYII=");
	background-size: 28px 28px;
	text-indent: -999px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -14px;
	margin-left: -14px;
	overflow: hidden;
}
</style>
<style>
.page-url-link{
	color: gray;
}
</style></head>

<body id="photo">
<div class="plugback">
	<a href="${BasePath}/zj/zjminweb/getAlbumList.kq">
		<div class="plugbg themeStyle">
		<span class="plugback"></span>
		</div>
	</a>
</div>
<div id="main" role="main" style="height: 117px;">
	
	<ul id="Gallery" class="gallery">

<#if photolist?? && (photolist?size>0) >
	<#list photolist as item>
	
		<li style="position: absolute; left: 223px; top: 0px; display: list-item;"><a href="${BasePath}/${item.url}"><img src="${BasePath}/${item.url}" alt="${item.description}"></a></li>
		
	</#list>	
<#else>
	<div class="yt-tb-list-no">暂无内容</div>
</#if>
	</ul>
	
</div>


<!--
<p class="page-url"><a href="http://www.weijuju.com" target="_blank" class="page-url-link">此功能由“微俱聚”平台提供</a></p>
-->



<script type="text/javascript" src="${BasePath}/js/app/zj/jquery.imagesloaded.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zj/jquery.wookmark.min.js"></script>
<script type="text/javascript">
  (function ($){
    $('#Gallery').imagesLoaded(function() {
      // Prepare layout options.
      var options = {
        autoResize: true, // This will auto-update the layout when the browser window is resized.
        container: $('#main'), // Optional, used for some extra CSS styling
        offset: 4, // Optional, the distance between grid items
        itemWidth: 150 // Optional, the width of a grid item
      };

      // Get a reference to your grid items.
      var handler = $('#Gallery li');

      // Call the layout function.
      handler.wookmark(options);

     
    });
  })(jQuery);
</script>

</body></html>