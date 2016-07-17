<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=1.0, user-scalable=yes" />
<title>猜灯谜</title>
</head>
<style>
*{margin:0; padding:0; border:0; font-size:5vw; line-height:7vw; font-family:"微软雅黑";}
a, img, input, th, select { border:0;}
a { text-decoration:none;}
.top{width:100%; height:100%; float:left; background:#06F; text-align:center;}
.top img{max-width:100%; height:100px; border:0;max-height:250px}
.titel{width:96%; padding:0 2%; font-size:7vw; height:100%; float:left; margin-top:15vw;}
.djs{float:right;}
.djs span{color:#F00; font-weight:bold; padding:0 2vw;}
.connt{width:96%; padding:0 2%; height:100%; float:left; margin-top:3vw;}
.connt h1{line-height:16vw; font-size:8vw;}
.kk{width:100%; height:20vw; float:left;}
.bottom{width:96%; height:13vw; line-height:9vw; position:fixed; background:#06F; color:#FFF; font-size:5vw; left:0; bottom:0; padding:3vw 2% 0 2%; }
.suru{width:62%; height:9vw; line-height:9vw; border:0; border-radius:2vw; margin-left:2vw;}
.an{width:20%; height:9vw; float:right; color:#FFF; border-radius:2vw; border:solid 0.5vw #FFFFFF; background:none; }
</style>
<body style="background:#ffffc5;">
<audio controls="controls" loop="loop" autoplay="autoplay" hidden="hidden">
  	<source src="../music/app/lanterngame/piano.mp3" type="audio/mpeg" />
	Your browser does not support the audio element.
  </audio>
	<#if quizTopics??>
	<#list quizTopics as item>
	<div class="top">
	<img id="imgdefa" src="${BasePath}/${item.imgUrl?default("images/dmban.png")}" >
	<!--<img src="" >-->
	</div>
		<form id="answerform" name="answerform" action="${BasePath}/lanterngame/answerTopic.kq" method="get">
		<div id="light" class="white_content">
				<div id="num"></div>
				<#if lastCount??>
				<#if lastCount != 0>
						<p>上题回答不正确</p>
				</#if></#if>
							 <p class="titel">${item.title?default("")}<br />(本题${item.topicScore?default("5")}分)</p><p class="djs" id="num"></p><br>
							 <p class="connt">${item.content?default("")}</p>
							 <div class="kk"></div>
							 <input type="hidden" name="replyId" value="${replyId}" />
		      		</#list>	
		      	<#else>
		      		<div class="yt-tb-list-no">暂无内容</div>
				</#if>
			<br>
			<div class="bottom">答案
			  <input type="text" name="result" id="textfield" class="suru" value="" onkeydown="return banInputSapce(event);" onKeyup="return inputSapceTrim(event,this);">
			  <input type="button" name="button2" id="button2" value="提交" class="an" onclick="vali()">
			</div>
			
		</form>
		
		<form id="goNext" name="goNext" action="${BasePath}/lanterngame/goNext.kq" method="post">
		</form>
</body>

<script>
function vali(){
	document.getElementById("answerform").submit();
	}
Date.prototype.Format = function (fmt) { //author: meizz 
    	var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
	 	
	 	secs = "${maxSubmitTime}"; // 设置多少秒
wait = secs * 1000;
document.getElementById("num").disabled =true;
for(i=1;i<=(wait/1000);i++) {
window.setTimeout("doUpdate(" + i + ")", i * 1000);
}
window.setTimeout("Timer()", wait);

function doUpdate(num) {
if(num == (wait/1000)) {
document.getElementById("num").innerHTML = " ";
document.getElementById("goNext").submit();
} else {
wut = (wait/1000)-num;
document.getElementById("num").innerHTML = wut + "秒";
}
}

function Timer() {
document.getElementById("num").disabled =false;
}

function Trim(str,is_global) 
{ 
var result; 
result = str.replace(/(^\s+)|(\s+$)/g,""); 
if(is_global.toLowerCase()=="g") 
{ 
result = result.replace(/\s/g,""); 
} 
return result; 
} 

function inputSapceTrim(e,this_temp) 
{ 
this_temp.value = Trim(this_temp.value,"g"); 
var keynum; 
if(window.event) // IE 
{ 
keynum = e.keyCode 
} 
else if(e.which) // Netscape/Firefox/Opera 
{ 
keynum = e.which 
} 
if(keynum == 32){ 
return false; 
} 
return true; 
} 

function banInputSapce(e) 
{ 
var keynum; 
if(window.event) // IE 
{ 
keynum = e.keyCode 
} 
else if(e.which) // Netscape/Firefox/Opera 
{ 
keynum = e.which 
} 
if(keynum == 32){ 
return false; 
} 
return true; 
} 

</script>
</html>