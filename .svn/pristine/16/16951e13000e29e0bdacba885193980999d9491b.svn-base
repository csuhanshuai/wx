<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=480,user-scalable=yes,uc-user-scalable=yes,target-densitydpi=high-dpi"/>
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <link rel="icon" href="share_2.png" mce_href="share_2.png" type="image/x-icon">
    
    <title>杰客大冒险 - JointForce小游戏</title>
<style>
	body{margin:0px; background-color:#434243; color:#6A6A6A;}
	.bandiv{float:left; width:100%; background-color:#DBD1BB;}
		.bandiv div{padding:10px; text-align:left;}
</style>








</head>
<body onload="main()" lang="http://g.3gunman.com" id="0">









<script language="javascript" type="text/javascript" src="/wx/js/jj.js"></script>
<script language="javascript" type="text/javascript" src="/wx/js/node.js"></script>

<script language="javascript" type="text/javascript" src="/wx/js/min.js"></script>






<div style="text-align:center;">
	<canvas id="jsGameScreen"> 
	</canvas> 
</div>

		<script language=javascript>
		
		var mebtnopenurl = 'https://www.jointforce.com/jetchat/app?tail=youxi';
		window.shareData = {
		        "imgUrl": "https://www.jointforce.com/jfoperating/jkdmx/logo.jpg",
		        "timeLineLink": "https://www.jointforce.com/jetchat/app?tail=youxi",
		        "tTitle": "杰客大冒险 - JointForce小游戏",
		        "tContent": "用绳命在玩的游戏"
		};
		
	//	function test(){
	//	alert(1);
         //           var d = 'test';
            //        $.ajax({
            //        url: "checkCanPlay.kq",
            //        contentType: 'application/json',
            //        data: "{'str':'" + d + "'}",
            //        type: 'POST',
            //        success: function (data) {
            //            alert("成功");
             //       }, error: function (a, b, c) {
                        
           //         }
           //     });
		
		

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



		
		function dp_share(t){
			document.title = "我得了" + t + "分！用绳命在玩的游戏，快来挑战一下！";
			document.getElementById("share").style.display="block";
			window.shareData.tTitle = document.title;

			document.getElementById("share").addEventListener("click",function(){
				this.style.display="none"
			})
		}
		function dp_Ranking(){
			//alert("到更多");
			window.location=mebtnopenurl;
		}

  //var form = document.getElementById("myform");
   // 	form.action="${BasePath}/jackgame/addPlayCount.kq";
	//		form.submit();
	
		function showAd(){
		}
		function hideAd(){
		}
		document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		    
		    WeixinJSBridge.on('menu:share:appmessage', function(argv) {
		        WeixinJSBridge.invoke('sendAppMessage', {
		            "img_url": window.shareData.imgUrl,
		            "link": window.shareData.timeLineLink,
		            "desc": window.shareData.tContent,
		            "title": window.shareData.tTitle
		        }, function(res) {
		        	document.location.href = mebtnopenurl;
		        })
		    });

		    WeixinJSBridge.on('menu:share:timeline', function(argv) {
		        WeixinJSBridge.invoke('shareTimeline', {
		            "img_url": window.shareData.imgUrl,
		            "img_width": "640",
		            "img_height": "640",
		            "link": window.shareData.timeLineLink,
		            "desc": window.shareData.tContent,
		            "title": window.shareData.tTitle
		        }, function(res) {
		        $("#myform").submit();
		        	//document.location.href = mebtnopenurl;
		        	
		        });
		    });
		}, false);
		

		function closeshare() {
			document.getElementById("share").style.display = "none";
		}


		

		</script>


<form  id="myformid" action="${BasePath}/jackgame/gameEnd.kq" method="post" style="display: none;float: inherit" >
		<input type="hidden" name="checkcode"/>
		<input type="hidden" name="time"/>
		<input type="hidden" name="score"/>
	</form>
	



</body>
</html>
