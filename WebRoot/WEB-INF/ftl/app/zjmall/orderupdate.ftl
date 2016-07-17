<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${BasePath}/js/upload/ajaxfileupload.js" ></script>
<script type="text/javascript" src="${BasePath}/js/app/zjmall/qxmall.js" ></script>
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
</script>
</head>

<body>

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
<div class="r_nav">
    <ul>
           <li class="<#if type=='initmall'>cur</#if>"><a href="${BasePath}/mallmanage/tomallconf.kq?type=initmall">基础设置</a></li>
	<li class="<#if type=='navset'>cur</#if>"><a href="${BasePath}/mallmanage/tonavset.kq?type=navset">导航设置</a></li>
	<li class="<#if type=='ptypemanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage">商品分类</a></li>
	<li class="<#if type=='plabelmanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryLabel.kq?type=plabelmanage">商品标签</a></li>
        <li class="<#if type=='pmanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryProduct.kq?type=pmanage">商品管理</a></li>
        <li class="<#if type=='omanage'>cur</#if>"><a href="${BasePath}/mallmanage/queryOrder.kq?type=omanage">订单管理</a></li>
    </ul>
</div>
<div id="reply_keyword" class="r_con_wrap">
        <form id="updateform" name="updateform" class="r_con_form" method="post" role="form" action="updateOrder.kq">
	    <input type="hidden" id="type" name="type" value="${type}"/>	
	    <#if order??>	
	    <input type="hidden" id="uid" name="uid" value="${order.uid}"/>
	    <div class="rows">
                <label>订单号</label>
                <span class="input"> 
		<input id="id"  type=text name="id" value='${order.id}' readonly="true" />
            </div>
	     <div class="rows">
                <label>收货人</label>
                <span class="input"> 
		        <input id=receiver class=textbox type=text name=receiver required value='${order.receiver}' readonly="true"/>
		        <div class="clear"></div>
            </div>
	     <div class="rows">
                <label>收货人详细地址</label>
                <span class="input"> 
		<input id=receiveAddr class=textbox type=text name=receiveAddr required value='${order.receiveAddr}' readonly="true" />
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label>收货人联系电话</label>
                <span class="input"> 
		<input id=phoneNum class=textbox type=text name=phoneNum required value='${order.phoneNum}' readonly="true"/>
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label>下单时间</label>
                <span class="input"> 
		<input id=orderTime class=textbox type=text name=orderTime required value='${order.orderTime}' readonly="true"/>
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label>快递公司</label>
                <span class="input"> 
		<input id=expCompany class=textbox type=text name=expCompany required value='${(order.expCompany)?default("")}' />
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label>快递单号</label>
                <span class="input"> 
		<input id=expNum class=textbox type=text name=expNum required value='${(order.expNum)?default("")}' />
                <div class="clear"></div>
            </div>
            
		<div class="rows" id="img_msg_row">
                <label>订单状态</label>
                <span class="input">
			<select id=status  name=status class=selectbox>
			    <option value="0" selected="selected">未支付</option>
				<option value="1" >已支付</option>
				<option value="2">已发货</option>
				<option value="3" >已完成</option>
			</select>
		</span>
                <div class="clear"></div>
            </div>
	    
            <div class="rows">
                <label></label>
                <span class="input">			
		<input type="button" class="btn_green" name="submit_button" onclick="subcheck()"  value="提交保存" /><a href="${BasePath}/mallmanage/queryOrder.kq?type=omanage" class="btn_gray">返回</a></span>
                <div class="clear"></div>
            </div>
            </#if>
        </form>


    </div>  </div>
<div>
<script>
createInput('more');

function subcheck()
{
	  $("#updateform").submit();		
}
</script>
</body>
</html>