<!DOCTYPE html>
<!-- saved from url=(0093)http://mp.yaotu365.com/mobilecolumninfo/0/0.do?libraryid=23&columnid=1097&accountid=22#result -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="application/x-www-form-urlencoded; charset=UTF-8">
<meta name=“viewport” content=“width=device-width， initial-scale=1.0”>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="Expires" content="-1">  
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes">
<title>游戏结束</title>
<link href="${BasePath}/css/bootstrap.min.css" rel="stylesheet">
<link href='${BasePath}/css/style.css?t=2013122302' rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${BasePath}/css/end.css">
    <style type="text/css">
	.bg{
		width:100%;
		height:100%;
		position:fixed;
		top:0;
		left:0;
		background: #000 url(../images/bj.jpg) top center no-repeat !important;
		background-size:100% 100% !important;
		}
		
    .addthumb {padding-left:0;padding-right:0; height: 50px; overflow: hidden;}
	
	.btn-danger {
		background-color: #f08c86;
		border-color: #f08c86;
		color: #fff;
	}
	.btn-danger:hover, .btn-danger:focus, .btn-danger:active, .btn-danger.active, .open > .dropdown-toggle.btn-danger {
		background-color: #f08c86;
		border-color: #f08c86;
		color: #fff;
	}
	.btn-danger2 {
		background-color: #5a4c4b;
		border-color: #5a4c4b;
		color: #fff;
	}	
	.buttons2{	
		padding-top:5px;
	}
	.btn-danger2:hover, .btn-danger2:focus, .btn-danger2:active, .btn-danger2.active, .open > .dropdown-toggle.btn-danger2 {
		background-color: #5a4c4b;
		border-color: #5a4c4b;
		color: #fff;
	}
	.btn-danger1 {
		font-size: 22px;
		padding: 10px;
	}
.btn-success {
    background-color: #2d892d;
    border-color: #4cae4c;
    color: #fff;
}
.panel {
    background-color: #fff;
    border: 1px solid transparent;
    border-radius: 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
    margin-bottom: 5px;
}

.btn_ex {
    -moz-user-select: none;
    background-image: none;
    border: 1px solid transparent;
    border-radius: 4px;
    cursor: pointer;
    display: inline-block;
    font-size: 14px;
    font-weight: normal;
    line-height: 1.42857;
    margin-bottom: 0;
    padding: 6px 12px;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
}
a:link {
text-decoration: "underline";
}
a:visited {
text-decoration: "underline";
}
a:hover {
text-decoration: "";
}
a:active {
text-decoration: "";
}
.img1 {
 text-align:center; padding-left:50px;
 }
 
    </style>
</head>
<body style="zoom: 1;">
<div class="bg"></div>

<div id="ad0">
</div>
<script>
    function play(url){

        var audio = document.createElement('audio');
        var source = document.createElement('source');
        source.type = "audio/mpeg";
        source.type = "audio/mpeg";
        source.src = url;
        source.autoplay = "autoplay";
        source.controls = "controls";
        audio.appendChild(source);
        audio.play();
        $('.btn').hide();
        $('.stop').show();
    }
</script>


<div class="container">
	
    <div class="text-center header">
		 <style>
		 .header {
				color: #fff;
				margin: 0 0 55px;
			}
		 </style>
		<h1 class="bold">哇哦!游戏结束!</h1>
        <div class="avatar1 text-center">
        </div>
    </div>
    <div id="bd" class="panel">
        
		<div id="panel3" class="panel-body js_result" data-id="1">
		<h1 class="bold text-danger">本次得分:${totalscore?default("")}</h1>
		
            <h1 class="bold text-danger">结束原因</h1>
            <hr>
            <dl>
          
		
                <dd>
                    <p>${tipMsg}</p>
                </dd>
            </dl>
            
            <!--开始-->
            <#if medalflag=="0">
            	<#if bagCount < 3 >
              <div class="paixu">
              
		<div class="title">
			<h3>分数不够${medalscore}分，很遗憾你没得到约章！</h3>
		</div>
		 <hr>
		<div class="paixu">
        	<li>
        	<img src="../images/yue1.jpg" class="img1" >
        </div>
        
        <hr>
		<ul class="weekly-list cls">
			<li>
				<div class="app-show-title">
					<a style="font-size:20px;text-decoration:underline;" href="http://ijfer.chinasoftosg.com/ijferm/pages/qrCodePrd.html">邀请注册“解放号”可获取更多约章.</a>
				</div>
			</li>
		</ul>
	
</div>


<#else   >
    <div class="paixu">
              
		<div class="title">
			<h3>您已经获得3枚约章了，不能再获得了！</h3>
		</div>
		 <hr>
		<div class="paixu">
        	<li>
        	<img src="../images/yue1.jpg" class="img1" >
        </div>
        
        <hr>
		<ul class="weekly-list cls">
			<li>
				<div class="app-show-title">
					<h4><a style="font-size:20px;text-decoration:underline;" href="http://ijfer.chinasoftosg.com/ijferm/pages/qrCodePrd.html" >邀请注册“解放号”可获取更多约章.</a></h4>
				</div>
			</li>
		</ul>
	
</div>
</#if>
<#else>
<div class="paixu">
              
		<div class="title">
			<h3>恭喜你获得1枚约章！</h3>
		</div>
		 <hr>
		<div class="paixu">
        	<li>
        	<img src="../images/yue2.png" class="img1" >
        </div>
        <hr>
		<ul class="weekly-list cls">
			<li>
				<div class="app-show-title">
					<h4><a style="font-size:20px;text-decoration:underline;" href="http://ijfer.chinasoftosg.com/ijferm/pages/qrCodePrd.html" >邀请注册“解放号”可获取更多约章</a></h4>
				</div>
			</li>
		</ul>
	
</div>
</#if>
 <!--结束-->           
          
            
            <div class="buttons">
                <a href="${BasePath}/lanterngame/showTopFive.kq" class="btn_ex btn-success btn-block" >查看排行榜</a>
               
            </div>
             <a href="${BasePath}/lanterngame/checkCanPlay.kq" class="kk" >重新答题</a>
             </div>       
    </div>
</div>
	<div class="footer text-center" id="content">
	</div>
<div class="loads" style="display: none;"><i></i></div>
<script type="text/javascript" src="${BasePath}/js/jquery.js"></script>
<script src="${BasePath}/js/WeixinApi.min.js"></script>


<div class="hide"></div>

</body></html>