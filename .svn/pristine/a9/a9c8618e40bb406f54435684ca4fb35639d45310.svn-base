<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">

<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<meta name="apple-mobile-web-app-capable" content="yes">
<link rel="stylesheet" href="${BasePath}/css/a.css">
<link rel="stylesheet" href="${BasePath}/css/b.css">
<link rel="stylesheet" href="${BasePath}/css/c.css">
<link rel="stylesheet" href="${BasePath}/css/swj.css">
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>
<script type='text/javascript' src='${BasePath}/js/app/swj/swj.js?time=45'></script>
<title>支付提示</title>
<style>


#bookBody .pb_5 {
	padding-bottom: 10px !important;
}
</style>
</head>
<body>
		<div id="bookBody" class="body">
		<div style="position: relative;z-index:9999"><img src="${BasePath}/images/tab_logo.png" style="width: 100%;"></div>
		<!-- 这里显示折扣信息-->
		<div class="floatDiscount" id="discountInfo"></div>
        <div style="margin-top:-25px;background:#010101;">
        <div style=" background:#010101; height:20px;">
	       </div>
        <div style="width:60%; margin:auto;"><a><img src="${BasePath}/images/pic8.jpg" style="width:100%;"></a></div>
        </div>
        
        <div style="background:#010101;">
        
        <div style=" position: absolute;"><img src="${BasePath}/images/pic9_2.jpg" style="width:100%"></div>
        <div style=" color:#000010; font-size:14px; position: absolute; line-height:22px; padding-top:15px; padding-left:26px;">
               订票姓名：<span style="font-weight:bold">${(order.uName)!""}</span><br>
               身份证号：<span style="font-weight:bold">${(order.idCard)!""}</span><br>
                日期时间：<span style="font-weight:bold">
                <#if order.dateStr??>
                ${(order.dateStr)?substring(4,order.dateStr?length)}
                </#if>
                </span><br>
		预订数量：<span style="font-weight:bold">${(order.total)!""}张</span><br>
		座位区域：<span style="font-weight:bold">${(order.areaName)!''}</span><br>
		合计金额：<span style="font-weight:bold">人民币${(((order.finalPrice)!0))?c}元</span>
        </div>
        </div>
        
        <div style=" background:#010101; padding-bottom:40px; padding-top:170px;">
        <div style="width:90%; margin:auto; color:#cd8445; font-size:16px; line-height:30px;">
取票时间：表演时间提前1小时；<br>
取票地点：澳门新濠天地「水舞间」售票处；位置是由系统自动排位，无法自选，供应商保证一定连位。<br>
注：预订成功后，不可以更改和取消预订,另24小时内发送短信通知座位编号。
        </div>
        </div>      
        </div>
        <div style=" background:#010101; height:80px;">
	       </div>
	       <script type="text/javascript">
	   	var discountInfoEl = $("#discountInfo");
	   	getDiscountInfo(discountInfoEl);
	   </script>
</body></html>