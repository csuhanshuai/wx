
<!DOCTYPE html>
<!-- saved from url=(0106)http://103.245.209.72//zj//zj/zjminweb/addMemberForward.kq?openid=333&bid=40288ae845df5fe30145df6522c30004 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css" id="__360se6_success_css"></style>
<meta charset="utf-8">
<script type="text/javascript">
	var BasePath="${BasePath}"; 
	var bid="${bid}";	
</script>




<link rel="stylesheet" href="${BasePath}/css/mc.css">
<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>

<title>活动报名</title>


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
<body onselectstart="return true;" ondragstart="return false;"><section id="dialoger"><div class="dialogCover"></div></section>



<script>
var flag = false;
function checkTel(tel)
{
   var mobile = /^1[3|5|8]\d{9}$/ , phone = /^0\d{2,3}-?\d{7,8}$/;
   return mobile.test(tel) || phone.test(tel);
}

function checkNum(num)
{
   var number = /^\d+$/;
   return number.test(num);
}

function submit1()
{
	
	var form = document.getElementById("form1");
	
	if(form.name.value.length<2){
		alert("请输入姓名,不少于2个字符", 1500);
		return;
	}
	if(form.mobile.value.length==0 || !checkTel(form.mobile.value)){
		alert("请输入正确的手机号", 1500);
		return;
	}
		$.ajax({
		    url:BasePath+"/zjhuodong/zjminweb/checkMobile.kq?mobile="+form.mobile.value + "&bid=" + bid,
			type:"post",
			async:false,
			timeout:1000,
			success:function(result)
			{
			    if(result == 'exist')
			    {
				   alert("该号码已经报名！");
				   flag = true;
			    }
			    else if(result == "noExist")
			   {
				   flag = false;
			   }
			   
			}
		});
		
		if(flag)
		{
		   return;
		}
		
		form.submit();
	}
</script>

	<div class="container info_tx" style="border: 4px solid #FF6699;">
	   <div style="width:100%;height:50px;text-align:center;background-color: #FFCCFF">
	                        <br>
						    <b>活动报名</b>
		</div>
		<div class="body pt_10">
		    
			<ul class="list_ul_card">
				<form id="form1" action="${BasePath}/zjhuodong/zjminweb/addBaoming.kq" method="post">
				    <input type="hidden" name="activitiesid" value="${activitiesid}"/>
				    <input type="hidden" name="bid" value="${bid}"/>
					<li data-card="">
						<div class="forms">
							<!-- 隐藏字段 -->
							<dl>
								<dt>姓 名：</dt>
								<dd>
									<input type="text" name="name" placeholder="请输入姓名" value="" maxlength="30" class="input">
								</dd>
							</dl>
							<dl>
								<dt>手 机：</dt>
								<dd>
									<input type="text" name="mobile" placeholder="请输入手机号码" value="" maxlength="30" class="input">
								</dd>
							</dl>
							
						</div>
						</li>
					<ul class="add_op">
						<li style="padding: 10px 0 0;"><a href="javascript:submit1();" style="width: 100%;">提&nbsp;&nbsp;&nbsp;交</a>
						</li>
						
					</ul>
				</form>
			</ul>
		</div>
	</div>
	<div mark="stat_code" style="width: 0px; height: 0px; display: none;">
	</div>
</body>
</html>