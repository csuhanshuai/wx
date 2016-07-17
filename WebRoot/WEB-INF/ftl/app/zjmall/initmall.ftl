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
<script src="${BasePath}/js/app/zjmall/qxmall.js"></script>
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
<div id="attention" class="r_con_wrap">
    <form id="attention_reply_form" class="r_con_form" method="post" action="${BasePath}/mallmanage/addmallconf.kq?type=initmall">
        <input type="hidden" id="bizid" name="bizid" value='${bizid}'/>
        <input type="hidden" id="type" name="type" value="${type}">
	<input type="hidden" id="skinid"  name="skinid" value=''${(mconf.skinid)?default("1")}'' >
	 <div class="rows">
            <label>商城链接</label>
            <span class="input">
		<a href="${(mconf.url)?default("")}?bid=${bizid}" target="_blank">${(mconf.url)?default("")}?bid=${bizid}</a>
		<div class="tips">（说明：商城外链可配置在微官网，图文消息，自定义菜单）</div>
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows">
            <label>商城名称</label>
            <span class="input">
		<input id=mallname  type=text name=mallname   disabled="disabled" value='${(mconf.mallname)?default("")}'/>
            </span>
            <div class="clear"></div>
        </div>
	<div class="rows">
            <label>商家电话</label>
            <span class="input">
		<input id=cstel  type=text name=cstel   disabled="disabled"  value='${(mconf.cstel)?default("075588886666")}'/>
            <div class="tips">（在订单详情页中，显示商家电话）</div>
	    </span>
            <div class="clear"></div>
        </div>
	  <div class="rows">
            <label>版权信息</label>
            <span class="input">
		<input id="footword"  type=text name="footword"   disabled="disabled" value='${(mconf.footword)?default("版权所有 @2014")}'/>
               <div class="tips">（显示在商城底部，可以是广告词或商家口号）</div>
	    </span>
            <div class="clear"></div>
        </div>
        <div class="rows" id="img_msg_row">
            <label>商城状态</label>
            <span class="input">
			正常<div class="tips">（特殊情况可以暂时关闭商城访问）</div>
            </span>
            <div class="clear"></div>
        </div>
	<div class="rows">
            <label>定单超时取消</label>
            <span class="input">
		<input id=outtimeset  type=text name=outtimeset   disabled="disabled"  value='${mconf.outtimeset?default("24")}'/>
           <div class="tips">（单位：小时，如：24小时内未支付，自动取消用户订单）</div>
	    </span>
            <div class="clear"></div>
        </div>
        <!-- div class="rows" id="text_msg_row">
            <label>风格选择</label>
            <span class="input">
	    <div id="skin" >
		 <ul class="slider-statu" id="imgul">
			<#if skin??>
				<#list skin as item>
					<li <#if mconf??&&mconf.skinid==(item_index+1)> class="cur"</#if> onclick="changskin(${item_index+1},this)">
						<div title="点击选择微商城风格" sid="${item_index+1}" class="item">
							<div class="img">
							<img style="width:100%;height:auto;" src="${BasePath}/${item}" ></div>
							<div class="title">风格${item_index+1}</div>
						</div>
					</li>
				</#list>
			</#if>			
		 </ul>
	 </div>
	    </span>
            <div class="clear"></div>
        </div-->
      <div class="rows">
            <label></label>
            <span class="input">
	    <input type="button"  id="butc" class="btn_green" name="butc" onclick="changetoupdate();" value="修改" />
	    <input type="submit"  id="buts" class="btn_green" name="buts" value="提交" style="display:none"/>
	    </span>
            <div class="clear"></div>
        </div>
        <input type="hidden" name="do_action" value="wechat.attention_reply">
    </form>
</div>  
</div>  </div>
</body>
<script language="javascript">
if($("#mallname").val()==""){changetoupdate();}
if("oklab"=="${oklab?default('')}"){	alert("提交成功！");}
  
</script>
</html>