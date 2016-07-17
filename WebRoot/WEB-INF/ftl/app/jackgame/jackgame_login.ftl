<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<meta content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport" />
	
	<meta content="yes" name="apple-mobile-web-app-capable" />
	
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	
	<meta content="telephone=yes" name="format-detection" />
	
	<meta content="email=no" name="format-detection" />

<title>Jack大冒险登录界面</title>

<link rel="stylesheet" type="text/css" href="/wx/css/jackgamestyle.css" />
<link rel="stylesheet" type="text/css" href="/wx/css/animate.css" />


<script type="text/javascript" src="/wx/js/jquery.min.js"></script>	  
	  
</head>
 
<body>
	
<canvas id="christmasCanvas" style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;" width="1285" height="100%"></canvas>



<script type="text/javascript">

	 var snow = function() {
    if(1==1) {
      $("body").append('<canvas id="christmasCanvas" style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;"></canvas>');
      var b = document.getElementById("christmasCanvas"), a = b.getContext("2d"), d = window.innerWidth, c = window.innerHeight;
      
      b.width = d;
      b.height = c;
      for(var e = [], b = 0;b < 70;b++) {
        e.push({x:Math.random() * d, y:Math.random() * c, r:Math.random() * 4 + 1, d:Math.random() * 70})
      }
      var h = 0;
      window.intervral4Christmas = setInterval(function() {
        a.clearRect(0, 0, d, c);
        a.fillStyle = "rgba(255, 255, 255, 0.6)";
        a.shadowBlur = 5;
        a.shadowColor = "rgba(255, 255, 255, 0.9)";
        a.beginPath();
        for(var b = 0;b < 70;b++) {
          var f = e[b];
          a.moveTo(f.x, f.y);
          a.arc(f.x, f.y, f.r, 0, Math.PI * 2, !0)
        }
        a.fill();
        h += 0.01;
        for(b = 0;b < 70;b++) {
          if(f = e[b], f.y += Math.cos(h + f.d) + 1 + f.r / 2, f.x += Math.sin(h) * 2, f.x > d + 5 || f.x < -5 || f.y > c) {
            e[b] = b % 3 > 0 ? {x:Math.random() * d, y:-10, r:f.r, d:f.d} : Math.sin(h) > 0 ? {x:-5, y:Math.random() * c, r:f.r, d:f.d} : {x:d + 5, y:Math.random() * c, r:f.r, d:f.d}
          }
        }
      }, 70)
    }
  }
  snow();
  
  function loginCheck()
{

	var userId=document.getElementById("userId");

	var userName=document.getElementById("userName");
	if(userId.value=="")
	{
		alert("请输入工号");
		userId.focus();
		return false;
	}
	if(userName.value=="")
	{
		alert("请输入姓名");
		return false;
	}
	alert("登录成功,欢迎您"+document.getElementById('userName').value);
	
return true;
}
  
</script>

<h1 align="center" >登陆界面</h1>

<div class="login_frame"></div>

<div class="LoginWindow">
<form id="loginform" name="loginform" action="" method="post"  onsubmit="return loginCheck()">
	<div>
		<div class="login">
			<p><input type="text" name="userId" id="userId" placeholder="工号" value=""></p>
			<p><input type="text" name="userName" id="userName" placeholder="姓名" value=""></p>
			<p class="login-submit"><button type="submit" class="login-button" id ="submit" >登录</button></p>
		</div>
	
	</div>
	</form>
</div>
	



</body>
</html>