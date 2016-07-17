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
<link href='${BasePath}/css/app/zjmall/mall.css' rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${BasePath}/js/upload/ajaxfileupload.js" ></script>
<script src="${BasePath}/js/app/zjmall/skin.js"></script>
<script type="text/javascript">
	var bid="${mconf.bizid}"; 	
	var skinid="${mconf.skinid}"; 
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
<div class="r_con_wrap" id="home">
	<div class="m_lefter">
<!---- ----       左侧                     -------------->
	<div id="shop_skin_index">
		<#include "skinmodel1.ftl">
	</div>
<!---- ----       左侧 end                    -------------->
	</div>
	<div class="m_righter">
	<!---- ----       右侧                     -------------->
		<form id="home_form">
		   <script language="javascript">$(document).ready(skin_obj.material_one_init);</script>
			<div id="setbanner" style="display: block;">
		
		<#if skins??>
			<#list skins as item>
				<div class="item" name="div${item_index}" id="div${item_index}" <#if item_index!=0>style="display:none"</#if>>
						
				<#if item.settype==1>

		<!---- ----------       imageset begin        -------------->
					<div class="rows">
						<div class="b_l">
							<strong>图片设置</strong>
							<span class="tips">${item.description}</span>
							<br>
							<div class="blank6"></div>
							<div class="input">
							<input name="MsgFileUpload${item_index}" id="MsgFileUpload${item_index}" type="file" style="display: none;" width="120" height="30">
                            				</div>
						</div>					
						<div class="b_r" id="MsgImgDetail${item_index}" name="MsgImgDetail${item_index}" countid='${item_index}'>
						</div>
					</div>
					
	<!---- ----------        imageset end        -------------->	
	<#elseif item.settype==2>
	<!---- ----------        txt end        -------------->		
					<div class="rows">
						<div class="b_l">
							<strong>导航设置</strong>
							<span class="tips">${item.description}</span>
							<br>
							<div class="blank6"></div>
							<div class="input">
							<span class="fc_red">*</span>链接标题&nbsp;&nbsp;
							<input name="text${item_index}" id="text${item_index}" type="text"   value="${navlis[item_index].setkey}" onchange="setvaluetotraget(this,${item_index})">								
							</div>
						</div>					
					</div>						
	<!---- ----------        txt end        -------------->
	</#if>
					<div class="blank9"></div>
					<div class="rows url_select" style="display: block;">
						<div ><span class="fc_red">*</span>
						链接页面
						<br>
						<select name="setvalue${item_index}" id="setvalue${item_index}">
						<optgroup label="---------------分类导航---------------"></optgroup>
							<#if linklis??>
								    <#list linklis as link>
										<option value="${(link.value)}"  <#if navlis[item_index].setvalue==link.value>selected</#if> >${(link.lab)}</option>
								    </#list>   
							</#if>
						</select>
						</div>
					</div>
					<input type="hidden" value="${navlis[item_index].skinid}" name="skinid${item_index}" id="skinid${item_index}">
					<input type="hidden" value="${navlis[item_index].navindex}" name="navindex${item_index}" id="navindex${item_index}">
					<input type="hidden" value="${navlis[item_index].id}" name="navid${item_index}" id="navid${item_index}">
					<input type="hidden" value="${navlis[item_index].setkey}" name="setkey${item_index}" id="setkey${item_index}">
					<div class="clear"></div>
				</div>
		</#list>
	</#if>
			
	
			</div>
	</form>
			<div class="button">
			<input type="button" value="提交保存" name="submit_button" onclick="navsetsave();" class="btn_green">
			</div>
<!---- ----       右侧   end                  -------------->
	</div>
	<div class="clear"></div>
</div>
</div>  </div>
</body>

</html>