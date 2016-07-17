<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta name="description" content="">

<title>幸运大转盘活动开始了</title>
<link href='${BasePath}/js/app/turentable/css.css' rel='stylesheet' type='text/css' />
 <style type="text/css">
        #container{
            display: -moz-box;
            display: -webkit-box;
            -moz-box-orient:vertical;
            -webkit-box-orient: vertical;
            width: 370px;
            height: 80px;
            overflow-y: scroll;

        }
        #head2{
            display: -moz-box;
            display: -webkit-box;
            -moz-box-orient:horizontal;
            -webkit-box-orient: horizontal;
        }
        #context{
            display: -moz-box;
            display: -webkit-box;
            -moz-box-orient: horizontal;
            -webkit-box-orient: horizontal;
             margin-top: 5px;
             
        }
        #text-a{
        	background-color: green;
            height: 20px;
            width: 120px;
            font-size: 1em;
            -moz-box-align: center;
             -webkit-box-align: center;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
             color: white;
              padding-left: 20px;
        }
         #text-b{
           height: 20px;
           width: 120px;
           font-size: 1em;
           -moz-box-align: center;
           -webkit-box-align: center;
           -moz-box-sizing: border-box;
           -webkit-box-sizing: border-box;
           padding-left: 10px;
        }
        
          #text-c{
           height: 20px;
           width: 150px;
           font-size: 1em;
           -moz-box-align: center;
           -webkit-box-align: center;
           -moz-box-sizing: border-box;
           -webkit-box-sizing: border-box;
           padding-left: 10px;
        }
           #text-d {
           color: white;
           background-color: green;
           height: 20px;
           width: 150px;
           font-size: 1em;
           -moz-box-align: center;
           -webkit-box-align: center;
           -moz-box-sizing: border-box;
           -webkit-box-sizing: border-box;
           padding-left: 10px;
        }
         #text-e {
           color: white;
           background-color: green;
           height: 20px;
           width: 80px;
           font-size: 1em;
           -moz-box-align: center;
           -webkit-box-align: center;
           -moz-box-sizing: border-box;
           -webkit-box-sizing: border-box;
           padding-left: 10px;
        }
        
         #text-f {
           height: 20px;
           width: 80px;
           font-size: 1em;
           -moz-box-align: center;
           -webkit-box-align: center;
           -moz-box-sizing: border-box;
           -webkit-box-sizing: border-box;
           padding-left: 10px;
        }
    </style>
<script src="${BasePath}/js/jquery-1.9.1.min.js"></script>


<script type="text/javascript" src="${BasePath}/js/app/turentable/jQueryRotate.2.2.js"></script> 
<script type="text/javascript" src="${BasePath}/js/app/turentable/jquery.easing.min.js"></script>

<script type="text/javascript">
$(function(){ 
    $(function(){
		var tiemer = "";
		var time = 4000;//每次点击三秒后才能再次点击
		var fun = function bClick(){
			lottery();	
			$("#startbtn").unbind("click");
			tiemer = setTimeout(function(){
				$("#startbtn").click(fun);
			},time);
	};
		$("#startbtn").click(fun);
	})
}); 


function lottery(){ 

	 $.ajax({ 
	        type: 'POST', 
	        url: 'turnGame.kq?id=${id?default('')}&activitiesid=${activitiesid?default('')}', 
	        dataType: 'json', 
	        cache: false, 
	        error: function(data){ 
	            document.getElementById("tip").style.display="block";	 
	            return false; 
	        }, 
	        success:function(json){ 
	          if(json[0].noActivi!=undefined){
	              alert("不在活动时间");
	          }else if(json[0].noChance!=undefined){
	              alert("约章数不够");
	          }else if(json[0].systemBusy!=undefined){
	          		alert("系统繁忙，请稍后再试!");
	          }
	          else{
		          var a = random(json[0].min,json[0].max); 
				   $("#startbtn").rotate({ 
					 	duration:3000,
					 	angle: 0, 
            			animateTo:3600+a,
						easing: $.easing.easeOutSine,
						callback: function(){
							document.getElementById("badgeCount").innerHTML=json[0].badgeCount;
							document.getElementById("chance").innerHTML=json[0].chanceCount;
							if(document.getElementById("awardCount"+json[0].id)!=null){
								document.getElementById("awardCount"+json[0].id).innerHTML=json[0].num;
							}
						
							var isPrize=json[0].isPrize;
							if(isPrize==1){
								alert("恭喜获得"+json[0].prompt);
							}else{
								alert(json[0].prompt);
							}
						}
		           });
	          }
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

		
     $(function(){
			$(".bk").each(function(){
    			$(this).html("***"+$(this).html().substr(8,10));
  			});	
		});
</script>

</head>
<body class="activity-lottery-winning" >
<div  class="main" >


    <div id="outercont"  >
        <div id="outer-cont">
            <div id="outer"><img src="${BasePath}/js/app/turentable/disk180-4.png"></div>
        </div>
        <div id="inner-cont">
            <div id="inner"><img src="${BasePath}/js/app/turentable/start.png" id="startbtn"></div>
        </div>
    </div>
    
    
    
    
<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
    <div class="box">
    	<div > &nbsp;&nbsp;您还有<span id="badgeCount">${badgeCount}</span>枚约章 , 还有<span id="chance">${chance}</span>次抽奖机会   </div>
	</div>
</div>   	
<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
    <div class="box">
	    <div class="title-green"><span>奖项设置：</span></div>
	         <div class="Detail">
			 <#list aList as item>
	             <p>${item.name}:&nbsp&nbsp还剩<span id="awardCount${item.id}">${item.num}</span> 个 </p>
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

<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
   <div id="container">
        <div id="head2">
            <div id="text-e">奖励项目</div>
            <div id="text-a">姓名</div>
            <div id="text-d">获奖日期</div>
        </div>
         <#if lorryRecord??>
		      <#list lorryRecord as item>
      			<div id="context">
            		<div id="text-f">${item.award?default("")}</div>
            		<div id="text-b">${item.empName?default("")}(<span id="jobnumber" class="bk">${item.jobNumber?default("")})</div>
            		<div id="text-c">${item.gotAwardTime?default("")}</div>
        		</div>
        	</#list>	
		<#else>
			<div class="yt-tb-list-no">暂无内容</div>
		 </#if>
    </div>
</div>

<div id= "tip" class="boxcontent boxyellow" style=" position:absolute;top:45%;left:50%;width:200px;margin-top:-200px;margin-left:-100px; display:none">
    <div class="box">
	       <div class="title-green"><span>信息提示：</span></div>
	         <div class="Detail">
			    <a href="${BasePath}/lanterngame/checkForward.kq?type=4">${prompt}</a>
	         </div>	
	</div>
</div>
    
</body>
</html>