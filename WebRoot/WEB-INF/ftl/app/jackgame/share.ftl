<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<meta content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport" />
	
	<meta content="yes" name="apple-mobile-web-app-capable" />
	
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	
	<meta content="telephone=yes" name="format-detection" />
	
	<meta content="email=no" name="format-detection" />

<title>No机会界面</title>

</head>
 
<body>
<script>

function share(){
document.getElementById("share").style.display = "";
}

function closeshare() {
			document.getElementById("share").style.display = "none"
		}

</script>
<div id=share style="display:none;position:absolute;top:0px;left:0px;width:100%;height:100%;z-index:10000;">
	<p style="text-align: right; padding-left: 10px;">
		<img onclick="closeshare()" src="/wx/images/2001.png" style="max-width: 280px;top:0px; padding-right: 25px;"></img>
	</p>
</div>


<button onclick="share()" value="">分享到朋友圈</button>


</body>
</html>