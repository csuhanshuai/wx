
<!DOCTYPE html>
<!-- saved from url=(0106)http://103.245.209.72//zj//zj/zjminweb/addMemberForward.kq?openid=333&bid=40288ae845df5fe30145df6522c30004 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css" id="__360se6_success_css"></style>
<meta charset="utf-8">
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
</script>




<link rel="stylesheet" href="${BasePath}/css/mc.css">
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>

<title>微信上墙</title>


<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<style>
.select {
	width: 100%;
}

.list_ul_card .forms dt {
	padding: 5px;
}
</style>
</head>
<body onselectstart="return true;" ondragstart="return false;">
<div class="container info_tx" style="border: 4px solid #FF6699;">
<br>					
	<div style="width:100%;height:50px;text-align:center">
	    <b>微信抽奖 </b>
	</div>
	<div style="text-align:center">
	       <input type="text" id="mobilePrefix"/>
	       <input type="text" id="mobileMiddle"/>
	       <input type="text" id="mobileBottom"/>
	</div>

	<div id="out" style="display:none;margin-top:50px;margin-left:30px;margin-right:30px;">
		<fieldset>
			<legend>
				中奖结果
			</legend>
			<marquee style="display:;text-align:center;" id='awardResult' behavior="scroll" direction="up" width="100%" height="100" 
			scrollamount="3" onmouseover="this.stop()" onmouseout="this.start()"> 
					<b>13012345678</b><br>
					<b>13012345678</b><br>
					<b>13012345678</b><br>
			</marquee>
		</fieldset>	
	</div>
	
	<div style="width:100%;height:50px;text-align:center;margin-top:50px">
	    <input type="button" id="begincj" value="开始抽奖" onclick="begincj()"/>
	    <input type="button" id="stopcj" value="停止抽奖" onclick="stopcj()" style="display:none"/>
	</div>
</div>
</body>
<script>

var prefix1 = new Array();
var index = 0;
prefix1[index++] = "130";
prefix1[index++] = "131";
prefix1[index++] = "132";
prefix1[index++] = "133";
prefix1[index++] = "134";
prefix1[index++] = "135";
prefix1[index++] = "136";
prefix1[index++] = "137";
prefix1[index++] = "138";
prefix1[index++] = "139";
prefix1[index++] = "150";
prefix1[index++] = "151";
prefix1[index++] = "152";
prefix1[index++] = "153";
prefix1[index++] = "154";
prefix1[index++] = "155";
prefix1[index++] = "156";
prefix1[index++] = "157";
prefix1[index++] = "158";
prefix1[index++] = "159";

var isRunning = false; 

function begincj()
{
   isRunning = true;
   document.getElementById("begincj").style.display="none";
   document.getElementById("stopcj").style.display="";
   cj();
}

function cj()
{
    var mobilePrefixTxt = document.getElementById("mobilePrefix");
	var mobileMiddleTxt = document.getElementById("mobileMiddle");
	var mobileBottomTxt = document.getElementById("mobileBottom");
	var mobileStr = prefix1[Math.ceil(Math.random() * prefix1.length) - 1];
	for (var i = 0; i < 8; i++) 
	{
		mobileStr += "" + Math.ceil(Math.random() * 10 - 1) + "";
	}
	mobilePrefixTxt.value = mobileStr.substring(0, 3);
	mobileMiddleTxt.value = mobileStr.substring(3, 7);
	mobileBottomTxt.value = mobileStr.substring(7, 11);
    //已停止运行，并且抽奖结果已经抽出
	if (!isRunning) 
	{
		showResult(mobileStr);
		return;
	} 
	else 
	{
		setTimeout("cj()", 50);
	}
}
var mobileBuffer = "";

function stopcj()
{
    isRunning = false;
    $.ajax({
             url:BasePath+"/zjsqcj/getZhongjiangMobile.kq",
             type:"post",
             async:false,
             timeout:1000,
             success:function(result)
             {
                mobileBuffer = result;
             }
    });
    document.getElementById("stopcj").style.display="none";
    
    
}

//显示抽奖结果
function showResult() {
	var mobilePrefixTxt = document.getElementById("mobilePrefix");
	var mobileMiddleTxt = document.getElementById("mobileMiddle");
	var mobileBottomTxt = document.getElementById("mobileBottom");
	var outDiv = document.getElementById("out");
	awardResult.style.display = "block";
	outDiv.style.display = "block";
	mobilePrefixTxt.value = "";
	mobileMiddleTxt.value = "";
	mobileBottomTxt.value = "";
	awardResult.innerHTML = "<b>中奖号码为：</b><br><br><br><b><p class='STYLE3'>" + mobileBuffer + "</p></b>";
}
</script>
</html>