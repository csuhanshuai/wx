<!DOCTYPE html>
<!-- saved from url=(0117)http://www.weijuju.com/mobile/mc/cardApplyInfo.jsp?wuid=61892&uid=60135&talker=oNrR5t1G3TuV-V_DdiXvp7nH_6_E&mcid=1704 -->
<html><style type="text/css" id="__360se6_success_css"></style><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">

<link rel="stylesheet" href="css/mc.css">
<link rel="stylesheet" href="css/dialog.css">
<script type="text/javascript" src="js/app/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/app/zjmember/mymain.js"></script>
<script type="text/javascript" src="js/app/zjmember/dialog_min.js"></script>
<script type="text/javascript" src="js/app/zjmember/dater_min.js"></script>
<script type="text/javascript" src="js/app/zjmember/main.js"></script>
<script type="text/javascript" src="js/app/zjmember/aSelect.js"></script>
<script type="text/javascript" src="js/app/zjmember/aLocation.js"></script>

<title>会员卡</title>

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

	

	<script>

	$().ready(function(){
		
		try{
			new dater({
				selectYear:document.getElementById("selectYear"),
				selectMonth:document.getElementById("selectMonth"),
				selectDate:document.getElementById("selectDate"),
				minDat: new Date("1900/1/1"),
				maxDat: new Date(),
				curDat: new Date("1970/01/01")				
			}).init();
		}catch(e){
			//do nothing
		}
		
		var sel = aSelect({data: aLocation});
		sel.bind('#selectProvince', '0');
		sel.bind('#selectCity', '0');
		sel.bind('#selectArea', '0');
				
	});


	function bd(){
		var d = new iDialog();
		d.open({
			classList: "valid_phone bd",
			title:"",
			close:"",
			content:'<ul class="list_ul_card">\
				<form id="form2" action="javascript:;" method="post">\
					<li data-card>\
						<table>\
							<tr class="input wrapInput">\
								<td>\
									<label class="pre" style="color:#333333;"> 实体卡手机号：</label> \
								</td>\
								<td style="width:100%;">\
									<input type="tel" name="entry_telephone" placeholder="请输入手机号码" maxlength="15" class="input" />\
								</td>\
							</tr>\
							<tr class="input wrapInput">\
								<td style="width:100%;">\
									<input type="number" placeholder="验证码：" name="entry_checkcode" maxlength="10" class="input" />\
								</td>\
								<td>\
								<input type="button" onclick="getCardVCode(this, event,\'form2\', \'entry_telephone\' , \'getBindValidCode\');" class="button vcode" value="获取验证码" />\
								</td>\
							</tr>\
						</table>\
					</li>\
				</form>\
			</ul>',
			btns:[
					{id:"", name:"确定", onclick:"fn.call();", fn: function(self){
						//alert("queding");
						bind(self);
					}},
					{id:"", name:"取消", onclick:"fn.call();", fn: function(self){
						self.die();
					}}
				]
		});
	}

	function submit1(){
		
		var form = document.getElementById("form1");
		
		if(form.username.value.length<2){
			alert("请输入姓名,不少于2个字符", 1500);
			return;
		}
		if(form.telephone.value.length==0){
			alert("请输入正确的手机号", 1500);
			return;
		}
		
		if(form.address){
			if(!form.addr_prov.value || !form.addr_city.value || !form.addr_area.value){
				alert("请输入地区", 1500);
				return;
			}
			if(form.address.value.length==0){
				alert("请输入详细地址", 1500);
				return;
			}
		}	
		
		//校验自定义字段
		var $defined=$('div#defined dl');
		if($defined.length>0){
			var validPass=true;
			$defined.each(function(index){
				var $self=$(this);
				var $el=$self.find('input').length>0?$(this).find('input'):$(this).find('select');
				if(($el.is('input') && $el.val().length==0) || ($el.is('select') && $el.prop('selectedIndex')==0)){
					var tipName=$self.find('dt').html();
					tipName=tipName.substring(0,tipName.length-1);
					alert("请输入"+tipName, 1500);
					validPass=false;
					return validPass;
				}
			});
			if(!validPass){
				return;
			}
		}
		
		//校验验证码
		var $vcode=$('div#vcode dl');
		if($vcode.length>0){
			if($vcode.find('input').val()==0){
				alert("请输入验证码", 1500);
				return;
			}
		}
		
		loading(true);
		$.ajax({
			url: "/mobile/mcard?action=saveCardInfo&todo=add&wuid=61892&uid=60135&mcid=1704&talker=oNrR5t1G3TuV-V_DdiXvp7nH_6_E",
			type:"POST",
			data:$("#form1").serialize(),
			dataType:"json",
			success: function(res){
				if(res.success){
					var target = '';
					if(target){
						location.href = decodeURIComponent(target);
					}else{
						location.href="cardMain.jsp?wuid=61892&uid=60135&mcid=1704&talker=oNrR5t1G3TuV-V_DdiXvp7nH_6_E";
					}
				}else{
					loading(false);
					if(res.result=='errorValidCode'){
						alert('验证码不正确',1500);						
					}else if(res.result=='inValidPhone'){
						alert('提交失败，该手机号码已被占用',1500);		
					}else{
						alert('提交失败',1500);						
					}
				}
			}
		});

	}
</script>

	<div class="container info_tx">
		<div class="body pt_10">
			<ul class="list_ul_card">
				<form id="form1" action="javascript:;" method="post">
					<li data-card="">
					    <header class="center">
							<label style="display: inline-block;"><span>&nbsp;</span>填写会员卡资料</label>
						</header>
						<div class="forms">
							<dl>
								<dt>姓 名：</dt>
								<dd>
									<input type="text" name="username" placeholder="请输入姓名" maxlength="30" class="input">
								</dd>
							</dl>
							<dl>
								<dt>手 机：</dt>
								<dd>
									<input type="text" name="telephone" placeholder="请输入手机号码" maxlength="30" class="input">
								</dd>
							</dl>
							<!-- 自定义字段-->
							<div id="defined">

							</div>
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
	<script type="text/javascript">
var intervalId,buttonObj,bindPhone;
//发送下一条短信需要间隔的秒数
var seconds = 60;
function getCardVCode(clickObj, evt, formId, teleName , action){
	var form = document.getElementById(formId);
	var tel = $.trim(form[teleName].value);
	if(tel.length==0){
		alert("请输入手机号码", 1000);return;
	}
	if(!/^[0-9]{8,20}$/.test(tel)){
		alert("请输入正确格式的手机号码", 1000);return;
	}
	clickObj.setAttribute("disabled", "disabled");
	clickObj.value = "正在发送，请稍候...";
	$.ajax({
		url: "/mobile/mcard",
		type:"get",
		data:{
			action:action,
			wuid:'61892',
			talker:'oNrR5t1G3TuV-V_DdiXvp7nH_6_E',
			uid:'60135',
			phone:tel,
			mcid : 1704
		},
		dataType:"json",
		success: function(res){
			if(res.success){
				clickObj.value = '验证码发送成功';
				buttonObj = clickObj;
				bindPhone = res.phone;
				intervalId = setInterval("ticker()",1000);
			}else{
				if('errorNum'==res.result){
					alert('手机号码不正确', 1500);					
				}else if(1 == res.statu){
					alert('发送失败,暂无短信流量包。' , 1500);
				}else if(2 == res.statu){
					alert('您发送过于频繁，请稍后再尝试。');
				}else if(3 == res.statu){
					alert('获取验证码失败', 1500);		
				}
				clickObj.removeAttribute("disabled");
				clickObj.value = "获取验证码";
				seconds = 60;
			}
		}
	});
}
var binding;
//实体卡绑定
function bind(){
	if(binding){
		return ;
	}
	var form = document.getElementById("form2");
	var tel = $.trim(form['entry_telephone'].value);
	if(tel.length==0){
		alert("请输入手机号码", 1000);return;
	}
	if(!/^[0-9]{8,20}$/.test(tel)){
		alert("请输入正确格式的手机号码", 1000);return;
	}
	
	var code = $.trim(form['entry_checkcode'].value);
	if(code.length==0){
		alert("请输入验证码。",1500);
		return;
	}
	
	loading(true);
	$.ajax({
		url: "/mobile/mcard",
		type:"post",
		data:{
			action:'bind',
			wuid:'61892',
			talker:'oNrR5t1G3TuV-V_DdiXvp7nH_6_E',
			uid:'60135',
			phone:bindPhone,
			code:code
		},
		dataType:"json",
		success: function(res){
			if(res.success){
				alert('绑定实体卡成功', 1500);
				location.href = "/mobile/mc/cardMain.jsp?uid=60135&wuid=61892&talker=oNrR5t1G3TuV-V_DdiXvp7nH_6_E";
			}else if(1 == res.statu){
				alert('验证码无效', 1500);
			}else if(2 == res.statu){
				alert('找不到对应实体卡', 1500);
			}else if(3 == res.statu){
				alert('已经领过会员卡', 1500);
			}else if(4 == res.statu){
				alert('无任何会员卡可供领取', 1500);
			}
		},
		complete: function(){
			binding = false;
			loading(false);
		}
	});
}
function ticker(){
	seconds --;
	if(seconds > 55){
		//提示消息显示5秒钟
	}else if(seconds>0){
		buttonObj.value = seconds+"秒后可重新获取";
	}else{
		clearInterval(intervalId);
		buttonObj.removeAttribute("disabled");
		buttonObj.value = "获取验证码";
		seconds = 60;
		buttonObj = null;
	}
}
</script>
	<div mark="stat_code" style="width: 0px; height: 0px; display: none;">
	</div>




</body></html>