<!DOCTYPE html>
<!-- saved from url=(0093)http://mp.yaotu365.com/mobilecolumninfo/0/0.do?libraryid=23&columnid=1097&accountid=22#result -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes">
<title>登录失败</title>
<link href="${BasePath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${BasePath}/css/end.css">
    <style type="text/css">
	.bg{
		width:100%;
		height:100%;
		position:fixed;
		top:0;
		left:0;
		background: #000 url(../images/background.jpg) top center no-repeat !important;
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
		<h1 class="bold">工号或者姓名错误</h1>
    </div>
    <div id="bd" class="panel">
        
		<div id="panel3" class="panel-body js_result" data-id="1">
            <div class="buttons">
                <a href="${BasePath}/lanterngame/checkForward.kq?type=${type}" class="btn_ex btn-success btn-block" >重新登录</a>
            </div>
     
             </div>       
    </div>
</div>
	<div class="footer text-center" id="content">
	</div>
<div class="loads" style="display: none;"><i></i></div>



<div class="hide"></div>

</body></html>