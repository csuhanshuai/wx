
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
	    <b>微信上墙 </b>
	</div>
	
	<div style="width:100%;height:50px;text-align:right">
	    <b><input type="radio" name="second" value="10" onclick="changeTime(this.value)" checked="checked"/>10s</b><br>
	    <b><input type="radio" name="second" value="20" onclick="changeTime(this.value)"/>20s</b><br>
	    <b><input type="radio" name="second" value="30" onclick="changeTime(this.value)"/>30s</b><br>
	</div>
	
	<div id="out" style="margin-top:50px;margin-left:30px;margin-right:30px;">
	   <fieldset id="fs">
			<marquee style="display:none;text-align:center;" id='awardResult' behavior="scroll" direction="up" width="100%" height="300" 
			scrollamount="3"> 
				
			</marquee>
			<div width="100%" height="300" id="test" style="text-align:center">
			    
			</div>
	   </fieldset>	
	</div>
	
	<div style="width:100%;height:50px;text-align:center;margin-top:50px">
	    <a href="${BasePath}/zjsqcj/choujiang.kq">抽奖</a>
	</div>
</div>
</body>
<script>
var pageNum = 0;
var mobileBuffer = "";
var maxPageNum = "${totalPage}";
var gamenumber = "${gamenumber}";
var t = 10;
var marpref="<marquee style='text-align:center;' id='awardResult' behavior='scroll' direction='up' width='100%' height='300' scrollamount='3'>";
				
var marfix="</marquee>";

function changeTime(time)
{
   t = time;
}
changePage();
function changePage()
{
    if(parseInt(pageNum) >= parseInt(maxPageNum))
    {
       pageNum = 1;
    }
    else
    {
        pageNum++;
    }
    $.ajax({
             url:BasePath+"/zjshagnqiang/geSqList.kq?pageNum=" + pageNum + "&gamenumber=" + gamenumber,
             type:"post",
             async:false,
             timeout:1000,
             success:function(result)
             {
                mobileBuffer = result;
             }
    });
  //  $("#test").html(mobileBuffer);
   // $("#awardResult").show();
   // $("#awardResult").html(mobileBuffer);
   
    $("#fs").html(marpref+mobileBuffer+marfix);
    
    setTimeout("changePage()", t * 1000);
}
</script>
</html>