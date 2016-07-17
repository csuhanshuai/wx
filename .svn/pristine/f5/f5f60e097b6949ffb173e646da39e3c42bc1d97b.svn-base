<!DOCTYPE html>
<!-- saved from url=(0117)http://www.weijuju.com/mobile/mc/cardApplyInfo.jsp?wuid=61892&uid=60135&talker=oNrR5t1G3TuV-V_DdiXvp7nH_6_E&mcid=1704 -->
<html><style type="text/css" id="__360se6_success_css"></style><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
</script>




<link rel="stylesheet" href="${BasePath}/css/mc.css">
<link rel="stylesheet" href="${BasePath}/css/dialog.css">
<script type="text/javascript" src="${BasePath}/js/app/zjmember/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/mymain.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dialog_min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/dater_min.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/main.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/aSelect.js"></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmember/aLocation.js"></script>

<title>填写订单</title>

<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
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
	$().ready(function(){
		
		var sex='1';
		if(!isNaN(sex)){
			$('select[name="sex"]').val(sex);
		}
		
		try{
			var curDate=new Date("1970/1/1");
			new dater({
				selectYear:document.getElementById("selectYear"),
				selectMonth:document.getElementById("selectMonth"),
				selectDate:document.getElementById("selectDate"),
				minDat: new Date("1900/1/1"),
				maxDat: new Date(),
				curDat: curDate			
			}).init();
		}catch(e){
			//do nothing
		}
		
		
		var addr_prov='<#if memberaddress??>${memberaddress.addr_prov?default("")}</#if>';
		var addr_city='<#if memberaddress??>${memberaddress.addr_city?default("")}</#if>';
		var addr_area='<#if memberaddress??>${memberaddress.addr_area?default("")}</#if>';
		var name='<#if memberaddress??>${memberaddress.name?default("")}</#if>';
		var telephone='<#if memberaddress??>${memberaddress.telephone?default("")}</#if>';
		var addre='<#if memberaddress??>${memberaddress.address?default("")}</#if>';
		if(!addr_prov)
		{
			addr_prov = '0';
		}
		
		if(!addr_city)
		{
			addr_city = '0';
		}
		
		if(!addr_area)
		{
			addr_area = '0';
		}
		
		if(name)
		{
			$("#receiver").val(name);
		}
		if(telephone)
		{
			$("#phoneNum").val(telephone);
		}
		if(addre)
		{
			$("#receiveAddr").val(addre);
		}
		
		var sel = aSelect({data: aLocation});
		
		
		
		sel.bind('#selectProvince', addr_prov);
		
		
		sel.bind('#selectCity', addr_city);
		
		
		sel.bind('#selectArea', addr_area);
		
		
		
		
		
		
		
		
	});



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



	function submit1(){
		var form = document.getElementById("form1");
		
		var receiver = form.receiver.value;
		if(receiver.length<2){
			alert("请输入收货人,不少于2个字符", 1500);
			return;
		}
		
		var phoneNum = form.phoneNum.value;
		if(phoneNum.length==0 || !checkTel(form.phoneNum.value)){
			alert("请输入正确的收货人手机号", 1500);
			return;
		}
		
		var receiveAddr = form.receiveAddr.value;
		if(receiveAddr.length==0){
			alert("请输入详细收货人地址", 1500);
			return;
		}
		
		var openid = form.openid.value;
		var bid = form.bid.value;
		
		//var addrProv = form.addr_prov.value;
		//var addrCity = form.addr_city.value;
		//var addrArea = form.addr_area.value;
		var addrProv = $("#selectProvince").find("option:selected").text();
		var addrCity = $("#selectCity").find("option:selected").text();
		var addrArea = $("#selectArea").find("option:selected").text();
		
		var payType = form.payType.value;
		
		var coupon = form.coupon.value;
       
		$.ajax({
			type : 'post',
			data:{
				openid:openid,
				bid:bid,
				receiver:receiver,
				phoneNum:phoneNum,
				addrProv:addrProv,
				addrCity:addrCity,
				addrArea:addrArea,
				receiveAddr:receiveAddr,
				payType:payType,
				coupon:coupon
			},
			dataType:"json",
			url: ('${BasePath}/zjmall/addOrder.kq'),
			success : function(res) {
			
						if(!res) return ;
						
						var str = res.result;
						if(str=="logout"){
							alert("对不起！请您先加入会员！", 1500);
							return;
						}else if(str=="notbalance"){
						    alert("对不起！帐户余额不够，不能选择余额支付，请选择其它支付方式！", 1500);
						    return;
						}else if(str=="success"){
							
							if(payType == '1')
							{
								alert("恭喜您！订单支付成功，请注意查看我的订单状态！", 60000,function(){
								       window.location.href = '${BasePath}/zjmall/myOrder.kq?openid='+ openid + '&bid='+bid;							           
								});
							}
							else if(payType == '2' && res.t)
							{
								var proname = document.getElementById("protitle").value;
							
								alert("恭喜您！订单提交成功，前去支付？", 60000,function(){
								       window.location.href = '${BasePath}/nosecurity/alipay/go.kq?out_trade_no='+ openid + '&subject='+proname + '&order_id='+res.t.orderidtoalipay + '&total_fee='+res.t.alltotalpric;							           
								});
							}
						}else if(str=="invaliduser"){
						    alert("对不起！无效用户，请您先加入会员！", 1500);
						    return;
						}else if(str=="paramisnull"){
						    alert("对不起！输入信息不能为空！", 1500);
						    return;
						}else{
						    alert("对不起！订单提交失败，请联系客服人员！", 1500);
						    return;
						}
					}
		});
	}
	
	function getAddress()
	{
		$.ajax({
				url: BasePath+"/zjmall/zjminweb/getAddress.kq?openid=${openid?default("")}",
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var response = eval("(" +result+")" );
	    		    if(response.result == 'success'){
	    		    	
	    		    	var t = response.t;
	    		    	if(t)
	    		    	{
	    		    		$("#receiver").val(t.receiver);
							$("#phoneNum").val(t.phoneNum);
							$("#Js-address").val(t.receiveAddr);
	    		    	}
	    		    	else
	    		    	{
	    		    		alert("您暂无订单，无法获取最近订单地址", 1500);
	    		    		
	    		    	}
					}
	    		    else
	    		    {
	    		    	alert("您暂无订单，无法获取最近订单地址", 1500);
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('获取失败!',1500);
	    		    }
			});
	}
</script>

	<div class="container info_tx" style="border: 4px solid #FF6699;">
		<div class="body pt_10">
			<ul class="list_ul_card">
				<form id="form1" action="addOrder.kq" method="post">
					<li data-card=""><header class="center">
							<label style="display: inline-block;"><span>&nbsp;</span>填写订单信息</label>
						</header>
						<div class="forms">
							<!-- 隐藏字段 -->
							<input type="hidden" name="openid" value="${openid?default("")}">
							<input type="hidden" name="bid" value="${bid?default("")}">
							<input type="hidden" name="uid" value="${uid?default("")}">
							<input type="hidden" id="protitle" value="<#if productlist?? && (productlist?size>0)><#list productlist as item><#if item_index == 0 >${item.ptitle?default('')}</#if></#list><#if (productlist?size>1) >等商品</#if></#if>">
							<dl>
								<dt>收货人：<a href="javascript:getAddress();"><span style="color:#ff6699;font-size:12px;">获取最近订单地址信息</span></a></dt>
								<dd>
									<input type="text" name="receiver" id="receiver" placeholder="请输入收货人" value="<#if orderaddress??>${orderaddress.receiver?default("")}</#if>" maxlength="30" class="input">
								</dd>
							</dl>
							<dl>
								<dt>收货人联系电话：</dt>
								<dd>
									<input type="text" name="phoneNum" id="phoneNum" placeholder="请输入电话号码" value="<#if orderaddress??>${orderaddress.phoneNum?default("")}</#if>" maxlength="30" class="input">
								</dd>
							</dl>
							<!-- 系统字段地址是否必填-->
						    <dl>
								<dt>地区:</dt>
								<dd>
									<div class="box select_box">
										<div>
											<select name="addr_prov" class="select" id="selectProvince" selectedindex="0"><option value="">请选择</option><option value="110000">北京</option><option value="120000">天津</option><option value="130000">河北省</option><option value="140000">山西省</option><option value="150000">内蒙古自治区</option><option value="210000">辽宁省</option><option value="220000">吉林省</option><option value="230000">黑龙江省</option><option value="310000">上海</option><option value="320000">江苏省</option><option value="330000">浙江省</option><option value="340000">安徽省</option><option value="350000">福建省</option><option value="360000">江西省</option><option value="370000">山东省</option><option value="410000">河南省</option><option value="420000">湖北省</option><option value="430000">湖南省</option><option value="440000">广东省</option><option value="450000">广西壮族自治区</option><option value="460000">海南省</option><option value="500000">重庆</option><option value="510000">四川省</option><option value="520000">贵州省</option><option value="530000">云南省</option><option value="540000">西藏自治区</option><option value="610000">陕西省</option><option value="620000">甘肃省</option><option value="630000">青海省</option><option value="640000">宁夏回族自治区</option><option value="650000">新疆维吾尔自治区</option><option value="710000">台湾省</option><option value="810000">香港特别行政区</option><option value="820000">澳门特别行政区</option><option value="990000">海外</option></select>
										</div>
										<div>
											<select name="addr_city" class="select" id="selectCity"><option value="">请选择</option></select>
										</div>
										<div>
											<select name="addr_area" class="select" id="selectArea"><option value="">请选择</option></select>
										</div>
									</div>
								</dd>
							</dl>
							<dl>
								<dt>详细地址:</dt>
								<dd>
								    <div>
									<input type="text" name="receiveAddr" id="Js-address" value="<#if orderaddress??>${orderaddress.receiveAddr?default("")}</#if>" placeholder="请输入详细地址" maxlength="100" class="input">
								    </div>
								</dd>
							</dl>
							<dl>
								<dt>支付方式:</dt>
								<dd>
								   <select name="payType" class="select">
								       <option value="">请选择支付方式</option>
									   <#list payTypeList as payType>
											<option value="${payType.id}">${payType.name}</option>
										</#list>
									</select>
								</dd>
							</dl>
							<dl>
								<dt>优惠券:</dt>
								<dd>
								   <select name="coupon" class="select">
								       <option value="">请选择优惠券</option>
									   <#list couponList as coupon>
											<option value="${coupon.id}">${coupon.name}【满${coupon.usablerange}减${coupon.money}】</option>
										</#list>
									</select>
								</dd>
							</dl>     

							
							
							
							
							<header class="center">
							<label >订单总金额：&yen;${mpric}</label>
						    </header>
							
							
							
							
							
							
						</div></li>
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
				wuid:'389',
				talker:'ozdP9jkM7FWtT83sFd87jvt1V0eM',
				uid:'120',
				phone:tel,
				mcid : 4
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
				action:'bindForUpdate',
				wuid:'389',
				talker:'ozdP9jkM7FWtT83sFd87jvt1V0eM',
				uid:'120',
				phone:bindPhone,
				code:code
			},
			dataType:"json",
			success: function(res){
				if(res.success){
					alert('绑定实体卡成功', 1500);
					location.href = "/mobile/mc/cardMain.jsp?uid=120&wuid=389&talker=ozdP9jkM7FWtT83sFd87jvt1V0eM";
				}else if(1 == res.statu){
					alert('验证码无效', 1500);
				}else if(2 == res.statu){
					alert('找不到对应实体卡', 1500);
				}else if(3 == res.statu){
					alert('您还没有领过会员卡', 1500);
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




</body></html>