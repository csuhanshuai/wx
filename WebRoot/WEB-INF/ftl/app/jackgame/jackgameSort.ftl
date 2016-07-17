<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="application/x-www-form-urlencoded; charset=UTF-8">
<meta name=“viewport” content=“width=device-width， initial-scale=1.0”>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="Expires" content="-1">           
<title>排名</title>
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/lanterngame.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/style.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='../css/sort.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='../css/SpryCollapsiblePanel.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='../css/share.css?t=2013122302' rel='stylesheet' type='text/css' />

<script type='text/javascript' src='${BasePath}/js/jquery-1.6.2.min.js'></script>	
<script type='text/javascript' src='${BasePath}/js/WeixinApi.min.js'></script>	
	<script type="text/javascript">
	  var BasePath="${BasePath}"; 
	  function hide(){
	  	$("#sharebj").css("display","none");
	  	$("#point").css("display","none");
	  }
	</script>
	
	<style type="text/css">
* { padding: 0; margin: 0; }
.am-share { font-size: 14px; border-radius: 0; bottom: 0; left: 0; position: fixed; text-align: center; -webkit-transform: translateY(100%); -ms-transform: translateY(100%); transform: translateY(100%); -webkit-transition: -webkit-transform 300ms; transition: transform 300ms ; width: 100%; z-index: 1110; }
.am-modal-active { transform: translateY(0px);  -webkit-transform: translateY(0); -ms-transform: translateY(0); transform: translateY(0) }
.am-modal-out { z-index: 1109; -webkit-transform: translateY(100%); -ms-transform: translateY(100%); transform: translateY(100%) }
.sharebg { background-color: rgba(0, 0, 0, 0.6); bottom: 0; height: 100%; left: 0; opacity: 0; position: fixed; right: 0; top: 0; width: 100%; z-index: 1100; display:none; }
.sharebg-active { opacity: 1; display:block; }

</style>
</head>
	
	<body >
	
	<iframe  width="0" height="0" id="myiframe"></iframe>
	<form id="myform"  method="post" target="myiframe"></form>
	<header class="head">
	    <div class="top_0"></div>
    	<div class="top_1">杰克大冒险排行榜</div>
    	<div class="top_2"></div>
    </header>
    <nav><img style="width:100%; height:30%;" class="banner" src="../images/logo2.png"/></nav>
	  <div class="s-index-side">

		<div class="title">
			<h3>游戏排名Top3</h3>
			<span class="s-index-icon game-top10-icon">icon图标</span>
		</div>
		  <div class="paixu">
		  <li><li><div class="xu"><div class="xuan1"><a>序号</a></div></div>
        	<li><div class="xu"><div class="xuan1"><a>姓名</a></div></div>
        	<div class="xu"><div class="xuan2"><a>分数</a></div></div>
        	<div class="xu"><div class="xuan3"><a>时间</a></div></div>
        </div>
        
        <#if topThree??>
		      <#list topThree as item>
					<ul class="weekly-list cls">
						<li>
							<div class="app-show-title">
							<span style="padding-left:0; width:65px; text-align:center; float:left; float:left; color:#F90; font-weight:bold">${item_index+1}</span>
							<span  style="padding-left:0; width:110px; text-align:center; float:left;">${item.empName?default("")}(<span id="jobnumber" class="bk">${item.jobNumber}</span >)</span>&nbsp;&nbsp;&nbsp;
							<span  style="padding-left:0; width:52px; text-align:center; float:left;">&nbsp;&nbsp;${item.score?default("")}</span>
							<span  style="padding-left:0; width:80px; text-align:center; float:left;">&nbsp;&nbsp;${item.updateDate?default("")}</span>
							</div>
						</li>
					</ul>
					
				</#list>	
		  <#else>
		      <div class="yt-tb-list-no">暂无内容</div>
		  </#if>	
</div>
 
	  
	   <div class="s-index-side">

		<div class="title">
			<h3>自己的最好成绩</h3>
			<span class="s-index-icon game-top10-icon">icon图标</span>
		</div>
		
		<div class="paixu">
		  
        	<li>
        	<div class="xu"><div class="xuan2"><a>分数</a></div></div>
        	<div class="xu"><div class="xuan3"><a>时间</a></div></div>
        </div>
        
        <#if myBest??>
		      <#list myBest as item>
		<ul class="weekly-list cls">
			<li>
				<div class="app-show-title">
					
					&nbsp;&nbsp;<span class="markto">${item.score?default("")}</span>
				
					<span class="markto">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.updateDate?default("")}</span>
				</div>
			</li>
		</ul>
		
		</#list>	
		  <#else>
		      <div class="yt-tb-list-no">暂无内容</div>
		  </#if>
  
</div>

  <div class="s-index-side">

		<div class="title">
			<h3>自己的本次成绩</h3>
			<span class="s-index-icon game-top10-icon">icon图标</span>
		</div>
		
		<div class="paixu">
		  
        	<li>
        	<div class="xu"><div class="xuan2"><a>分数</a></div></div>
        	<div class="xu"><div class="xuan3"><a>时间</a></div></div>
        </div>
        <#if myCurrentScore??>
		      <#list myCurrentScore as item>
		<ul class="weekly-list cls">
			<li>
				<div class="app-show-title">
					
					&nbsp;&nbsp;<span class="markto">${item.score?default("")}</span>
					<span class="markto">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.updateDate?default("")}</span>
				</div>
			</li>
		</ul>
		
		</#list>	
		  <#else>
		      <div class="yt-tb-list-no">暂无内容</div>
		  </#if>
  
</div>
      

	  <div class="buttons">
                <a href="javascript:void(0)"  class="btn_ex" onclick="toshare()">分享给朋友(圈)</a>
            </div>
             <br>
          <div class="buttons buttons2">
                <a href="${BasePath}/lanterngame/checkForward.kq?type=2" class="btn_ex btn-danger btn-danger2 btn-block">继续游戏</a>
            </div>   
           
        
	  <div style="display:none" class="point" id="point" onclick="hide()">
	         <nav><img  class="banner" src="../images/point.png"/></nav>
	   </div>
	   <div class="sharebg" id="sharebj"  onclick="hide()"></div>
	 
	 
	 
	 
	</body>
	<script type="text/javascript">
	 document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		
	window.shareData = {
		"imgUrl": '',
	};

	// 发送给好友
	WeixinJSBridge.on('menu:share:appmessage', function (argv) {
		WeixinJSBridge.invoke('sendAppMessage', {
			
		}, function (res) {
			<!--_report('send_msg', res.err_msg);-->
		})
	});

	// 分享到朋友圈
	WeixinJSBridge.on('menu:share:timeline', function (argv) {
		WeixinJSBridge.invoke('shareTimeline', {
			
		}, function (res) {
			<!--_report('send_msg', res.err_msg);-->
		});
	});

	// 分享到微博
	WeixinJSBridge.on('menu:share:weibo', function (argv) {
		WeixinJSBridge.invoke('shareWeibo', {
			"content": window.shareData.wContent,
			"url": window.shareData.weiboLink
		}, function (res) {
			<!--_report('send_msg', res.err_msg);-->
		});
	});
}, false);

	
	function onBridgeReady(){
 WeixinJSBridge.call('showOptionMenu');
}

if (typeof WeixinJSBridge == "undefined"){
    if( document.addEventListener ){
        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
    }else if (document.attachEvent){
        document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
    }
}else{
    onBridgeReady();
}
	
		
     $(function(){
				//$(".bk").html("*"+$(".bk").html().substr(1,2));
				$(".bk").each(function(){
    			$(this).html("***"+$(this).html().substr(8,10));
  				});
			});
     
	
	function toshare(){
		$(".am-share").addClass("am-modal-active");	
		if($(".sharebg").length>0){
			$(".sharebg").addClass("sharebg-active");
		}else{
			$("body").append('<div class="sharebg"></div>');
			$(".sharebg").addClass("sharebg-active");
		}
	$(".point").show();
	 $("#sharebj").css("display","block");
	  var form = document.getElementById("myform");
    	form.action="${BasePath}/jackgame/addPlayCount.kq";
			form.submit();
	}
</script>




</html>