<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0119)http://103.245.209.72/gq/gqft/toAddEmployee.kq?bid=402881834613589501461361b7d20009&openid=ojQt4jusbOTpGi21t8tQaeJP0hLA -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">

<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<meta name="apple-mobile-web-app-capable" content="yes">
<link rel="stylesheet" href="${BasePath}/css/app/zj/a.css">
<link rel="stylesheet" href="${BasePath}/css/app/zj/b.css">
<link rel="stylesheet" href="${BasePath}/css/app/zj/c.css">

<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script src="${BasePath}/js/jquery.deparam.js"></script>
<script src="${BasePath}/js/bootstrap_datepicker.js"></script>
<script src="${BasePath}/js/category.js"></script>
<title>招聘信息</title>
<style>
img {
	width: 100% !important;
}

#bookBody .pb_5 {
	padding-bottom: 10px !important;
}
tr
{
	height:30px;
}
</style>
</head>
<body onselectstart="return true;" ondragstart="return false;">
		<div id="bookBody" class="body" style="height:100%">
		

<#if zhaopinlist??>
	      		<#list zhaopinlist as item>	
		
		
		<header>
				<h2 class="title" id="tit">${item.name?default("")}</h2>
		</header>
		<section>
		
		<div class="pb_5 pl_10 pr_10" style="background:#949495;padding-top:10px;">
		<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
			 <div class="box" style="background:#ffffff;">
					<div class="Detail">
							<table>
								    <tr>
								        <td>性别要求：
								        	<#if item.sex=='1'>
										 		不限
										 	<#elseif item.sex=='2'>
										 		男
										 	<#elseif item.sex=='3'>
										 		女
										 	<#else>
										 	--
										 	</#if>
								        </td>
								    </tr>
								    <tr>
								        <td>招聘人数：${item.numbers?default("")}</td>	
								    </tr>
								    <tr>
								        <td>年龄要求：${item.age?default("")}</td>
								    </tr>
								    <tr>
								        <td>雇佣形式：
								         <#if item.workingtype=='0'>
										 		不限
										 <#elseif item.workingtype=='1'>
										 		全职
										 <#elseif item.workingtype=='2'>
										 		兼职
										 <#else>
										 	--
										 </#if></td>	
								    </tr>
								    <tr>
								        <td>工作年限：${item.workingnum?default("")}</td>
								    </tr>
								    <tr>
								        <td>薪资待遇：${item.pay?default("")}</td>	
								    </tr>
								    <tr>
								        <td>工作地点： ${item.workingplace?default("")}</td>
								    </tr>
								    <tr>
								        <td>学历要求：
								   			<#if item.education=='0'>
										 		不限
										 	<#elseif item.education=='1'>
										 		大专
										 	<#elseif item.education=='2'>
										 		大专
										 	<#elseif item.education=='3'>
										 		本科
										 	<#elseif item.education=='4'>
										 		硕士
										 	<#else>
										 	--
										 	</#if>      
								        以上</td>	
								    </tr>
								    <tr>
								        <td colspan="2">截止日期： ${item.endtime?default("")}</td>
								    </tr>
							</table>
					</div>
			  </div>
			</div>
		</div>
		<div class="pb_5 pl_10 pr_10" style="background:#949495;">
		<div class="boxcontent boxyellow" style="max-width: 640px;margin: auto;">
			 <div class="box" style="background:#ffffff;">
					<div class="title-green">职位描述：</div>
					<div class="Detail">
							${item.description?default("")}<br>
					</div>
			  </div>
			</div>
		</div>
		
		<!--
		<div class="pb_5 pl_10 pr_10">
			<div style="margin: 10px; text-align: center;">
					<a id="bsubmit" href="" class="btn_submit" style="margin: 10px auto; text-align: center;">立即应聘</a>
				</div>
		</div>
		-->
		


	      		</#list>	
	      	<#else>
	      		<tr><td colspan="2"><div class="yt-tb-list-no">暂无内容</div></td></tr>
		</#if>
		
		
		
	</div>
	<script type="text/javascript">
	 
 	$(document).ready(function() {
 			var params = $.deparam(window.location.search.slice(1));
 		
	 		var nowTemp = new Date();
	 		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
	 		var ndate = $('#dateline').datepicker({
	 				format:"yyyy-mm-dd",
	 			 	onRender: function(date) {
	 				//   return date.valueOf() < now.valueOf() ? 'disabled' : '';
	 				}
	 		}).on("changeDate", function(date){
	 				ndate.datepicker('hide');
	 		});
	 		
	 		
	 		$("#bsubmit").click(function(){
	 			var form = document.getElementById("form1");
				var obj = {
							weixinId:'ojQt4jusbOTpGi21t8tQaeJP0hLA',
							name : '',
							mobilePhone : '',
							dealer : '',
							area:'',
							idNumber:'',
							buyDate : '',
							isBuy:''
				          };
				
			

				if ('undefined' !== typeof (form.name)) {
					obj.name = form.name.value;
					if (obj.name.length <= 0) {
						alert("请输入您的真实姓名");
						return;
					};

				}
				if ('undefined' !== typeof (form.area)) {
					obj.area = form.area.value;
					if (obj.area.length <= 0) {
						alert("请输入所在地");
						return;
				  };
				}
				if ('undefined' !== typeof (form.dealer)) {
					obj.dealer = form.dealer.value;
					if (obj.dealer.length <= 0) {
						alert("请输入经销商");
						return;
				 };

				}
				if ('undefined' !== typeof (form.mobilePhone)) {
					form.mobilePhone.value=form.mobilePhone.value.replace(/\D/g,'');
					obj.mobilePhone = form.mobilePhone.value;
					if (obj.mobilePhone.length <= 7) {
						alert("请输入正确的电话号码");
						return;
					};

				}
				
				if ('undefined' !== typeof (form.idNumber)) {
					form.idNumber.value=form.idNumber.value.replace(/[^\w\.\/]/ig,'');
					obj.idNumber = form.idNumber.value;
					if (obj.idNumber.length <= 17) {
						alert("请输入正确的身份证号码");
						return;
					};

				}
				if ('undefined' !== typeof (form.buyDate)) {
					obj.buyDate = form.buyDate.value;
					if (obj.buyDate.length <= 7) {
						alert("请输入购买日期");
						return;
					};
				}
				if ('undefined' !== typeof (form.isBuy)) {
					obj.isBuy = form.isBuy.value;
					if (form.isBuy.value =='undefined') {
						alert("请选择是否购买创酷");
						return;
					};
				}	
				var $btn = $("#bsubmit");
				if($btn.hasClass("disabled")) return;
				$btn.addClass("disabled");
				
				ajaxRequest("/gq/gqft/getEmployeeByMobilePhone.kq",{"mobilePhone":obj.mobilePhone},
				function(data){					
				if(data==1){
					ajaxRequest("/gq/gqft/addEmployee.kq",obj,
					function(data){					
						if(data==1){
							alert("提交成功！");
							WeixinJSBridge.call('closeWindow');
						}else{
							alert("网络忙，提交失败，请稍后再试！");
							return false; 
						}
						
					});
				}else{
				alert("您已经参加过了，请勿重复提交！");
				WeixinJSBridge.call('closeWindow');
				}
					
				});
				
			});

		});
		
		
		// 发达ajax请求
	function ajaxRequest(url, reqParam, callback,error) {
		 $.ajax({ 
			type : 'POST',
			url : url,
			data : reqParam,
			dataType:'text',
			cache : true,
			success : callback
		});
	}

</script>

	<div mark="stat_code" style="width: 0px; height: 0px; display: none;">
	</div>

<div class="datepicker dropdown-menu"><div class="datepicker-days" style="display: block; "><table class=" table-condensed"><thead><tr><th class="prev">‹</th><th colspan="5" class="switch">April 2014</th><th class="next">›</th></tr><tr><th class="dow">Su</th><th class="dow">Mo</th><th class="dow">Tu</th><th class="dow">We</th><th class="dow">Th</th><th class="dow">Fr</th><th class="dow">Sa</th></tr></thead><tbody><tr><td class="day disabled old">30</td><td class="day disabled old">31</td><td class="day disabled">1</td><td class="day disabled">2</td><td class="day disabled">3</td><td class="day disabled">4</td><td class="day  active">5</td></tr><tr><td class="day ">6</td><td class="day ">7</td><td class="day ">8</td><td class="day ">9</td><td class="day ">10</td><td class="day ">11</td><td class="day ">12</td></tr><tr><td class="day ">13</td><td class="day ">14</td><td class="day ">15</td><td class="day ">16</td><td class="day ">17</td><td class="day ">18</td><td class="day ">19</td></tr><tr><td class="day ">20</td><td class="day ">21</td><td class="day ">22</td><td class="day ">23</td><td class="day ">24</td><td class="day ">25</td><td class="day ">26</td></tr><tr><td class="day ">27</td><td class="day ">28</td><td class="day ">29</td><td class="day ">30</td><td class="day  new">1</td><td class="day  new">2</td><td class="day  new">3</td></tr><tr><td class="day  new">4</td><td class="day  new">5</td><td class="day  new">6</td><td class="day  new">7</td><td class="day  new">8</td><td class="day  new">9</td><td class="day  new">10</td></tr></tbody></table></div><div class="datepicker-months" style="display: none; "><table class="table-condensed"><thead><tr><th class="prev">‹</th><th colspan="5" class="switch">2014</th><th class="next">›</th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Feb</span><span class="month">Mar</span><span class="month active">Apr</span><span class="month">May</span><span class="month">Jun</span><span class="month">Jul</span><span class="month">Aug</span><span class="month">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody></table></div><div class="datepicker-years" style="display: none; "><table class="table-condensed"><thead><tr><th class="prev">‹</th><th colspan="5" class="switch">2010-2019</th><th class="next">›</th></tr></thead><tbody><tr><td colspan="7"><span class="year old">2009</span><span class="year">2010</span><span class="year">2011</span><span class="year">2012</span><span class="year">2013</span><span class="year active">2014</span><span class="year">2015</span><span class="year">2016</span><span class="year">2017</span><span class="year">2018</span><span class="year">2019</span><span class="year old">2020</span></td></tr></tbody></table></div></div><div class="datepicker dropdown-menu"><div class="datepicker-days" style="display: block; "><table class=" table-condensed"><thead><tr><th class="prev">‹</th><th colspan="5" class="switch">May 2014</th><th class="next">›</th></tr><tr><th class="dow">Su</th><th class="dow">Mo</th><th class="dow">Tu</th><th class="dow">We</th><th class="dow">Th</th><th class="dow">Fr</th><th class="dow">Sa</th></tr></thead><tbody><tr><td class="day undefined old">27</td><td class="day undefined old">28</td><td class="day undefined old">29</td><td class="day undefined old">30</td><td class="day undefined">1</td><td class="day undefined">2</td><td class="day undefined">3</td></tr><tr><td class="day undefined">4</td><td class="day undefined">5</td><td class="day undefined">6</td><td class="day undefined">7</td><td class="day undefined">8</td><td class="day undefined">9</td><td class="day undefined">10</td></tr><tr><td class="day undefined">11</td><td class="day undefined">12</td><td class="day undefined">13</td><td class="day undefined">14</td><td class="day undefined">15</td><td class="day undefined">16</td><td class="day undefined">17</td></tr><tr><td class="day undefined">18</td><td class="day undefined">19</td><td class="day undefined">20</td><td class="day undefined">21</td><td class="day undefined">22</td><td class="day undefined">23</td><td class="day undefined">24</td></tr><tr><td class="day undefined">25</td><td class="day undefined active">26</td><td class="day undefined">27</td><td class="day undefined">28</td><td class="day undefined">29</td><td class="day undefined">30</td><td class="day undefined">31</td></tr><tr><td class="day undefined new">1</td><td class="day undefined new">2</td><td class="day undefined new">3</td><td class="day undefined new">4</td><td class="day undefined new">5</td><td class="day undefined new">6</td><td class="day undefined new">7</td></tr></tbody></table></div><div class="datepicker-months" style="display: none; "><table class="table-condensed"><thead><tr><th class="prev">‹</th><th colspan="5" class="switch">2014</th><th class="next">›</th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Feb</span><span class="month">Mar</span><span class="month">Apr</span><span class="month active">May</span><span class="month">Jun</span><span class="month">Jul</span><span class="month">Aug</span><span class="month">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody></table></div><div class="datepicker-years" style="display: none; "><table class="table-condensed"><thead><tr><th class="prev">‹</th><th colspan="5" class="switch">2010-2019</th><th class="next">›</th></tr></thead><tbody><tr><td colspan="7"><span class="year old">2009</span><span class="year">2010</span><span class="year">2011</span><span class="year">2012</span><span class="year">2013</span><span class="year active">2014</span><span class="year">2015</span><span class="year">2016</span><span class="year">2017</span><span class="year">2018</span><span class="year">2019</span><span class="year old">2020</span></td></tr></tbody></table></div></div></body></html>