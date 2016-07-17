
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta name="description" content="">

<title>猜灯谜游戏开始了</title>
<link href='${BasePath}/js/app/turentable/css.css' rel='stylesheet' type='text/css' />
<script src="${BasePath}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/turentable/jQueryRotate.2.2.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/turentable/jquery.easing.min.js"></script>
<script type="text/javascript">

$(function(){ 
     $("#startbtn").click(function(){ 
        lottery(); 
    }); 
}); 


function lottery(){ 
			
				 $.ajax({ 
				        type: 'POST', 
				        url: 'turn.kq?id=${id?default('')}&activitiesid=${activitiesid?default('')}', 
				        dataType: 'json', 
				        cache: false, 
				        error: function(data){ 
				            document.getElementById("tip").style.display="block";	 
				            return false; 
				        }, 
				        success:function(json){ 	
			
						  var a = random(json[0].min,json[0].max); //角度 
						  
						  //alert(json[0].id+"----"+json[0].min+"---"+json[0].max+"---"+a);
           				  //var p = json.name; //奖项 
						   $("#startbtn").rotate({ 
							 	duration:3000,
							 	angle: 0, 
		            			animateTo:1440+a,
								easing: $.easing.easeOutSine,
								callback: function(){
									alert(json[0].prompt);
									
									var bln = window.confirm("再来一次?"); 
									if(bln){
									lottery();
									}
									
								}
				           });
				      }    
				 });
			}
			
			
	function random(min,max){
    return Math.floor(min+Math.random()*(max-min));
    }
    
    function info(content){
    var newContent=content.replace(/\<BR\>/gi,"\r\n");  
    
    document.write(newContent) ;
    
    }

</script>

</head>
<body class="activity-lottery-winning" >
<div  class="main" >


    <div id="outercont"  >
        
        <div id="inner-cont">
            <div id="inner"><img src="${BasePath}/images/lantern/signon.png" id="startbtn"></div>
        </div>
    </div>
    
    
    
    
    
<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
    <div class="box">
	    <div class="title-green"><span>奖项设置：</span></div>
	         <div class="Detail">
			 <#list aList as item>	
			 	<#if item.isPrize ==1>	
	             <p>${item.name}: 还剩${item.num} 个 </p>
	            </#if>
	          </#list>	           
	    </div>
	</div>
</div>
<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
    <div class="box">
        <div class="title-green">活动说明：</div>
        <div class="Detail">
                   ${info}
        </div>
    </div>
</div>


<div id= "tip" class="boxcontent boxyellow" style=" position:absolute;top:45%;left:50%;width:200px;margin-top:-200px;margin-left:-100px; display:none">
    <div class="box">
	       <div class="title-green"><span>信息提示：</span></div>
	         <div class="Detail">
			     ${prompt}
	         </div>
	</div>
</div>
    
</body>


<script language="javascript">
var tolinkstr=$("a:last").attr("href");
if(tolinkstr.indexOf("?")>=0)
	$("a:last").attr('href',tolinkstr+"&openid=${id?default('')}"); 
else
	$("a:last").attr('href',tolinkstr+"?openid=${id?default('')}"); 
</script>
</html>