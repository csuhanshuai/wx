<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>微信公众平台管理系统</title>
<script type="text/javascript">
	var bid="${bid}"; 	
	var BasePath="${BasePath}"; 	
</script>
<link href='${BasePath}/css/global.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='${BasePath}/js/global.js'></script>
<link href='${BasePath}/js/plugin/operamasks/operamasks-ui.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/plugin/operamasks/operamasks-ui.min.js'></script>
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<style type="text/css">body, html{background:url(images/main-bg.jpg) left top fixed no-repeat;}</style>

</head>

<body>


<div id="iframe_page">
    <div class="iframe_content">

<div class="r_nav">
    <ul>
    <li class="<#if type=='ptMessage'>cur</#if>"><a href="${BasePath}/ptMessage.kq?type=ptMessage">图文消息管理</a></li>
    <li class="<#if type=='customUrl'>cur</#if>"><a href="${BasePath}/ptMessage.kq?type=customUrl">自定义URL管理</a></li>
    <li class="<#if type=='systemUrl'>cur</#if>"><a href="${BasePath}/ptMessage.kq?type=systemUrl">系统URL查询</a></li>
<li><a href="${BasePath}/articleManage/queryProductType.kq">文章分类</a></li>
	<li ><a href="${BasePath}/articleManage/queryArticles.kq">文章管理</a></li>
            </ul>
</div>
<div id="material" class="r_con_wrap">
<form id="material_form" method="post" action="addMultiPTMessage.kq?type=ptMessage">
                <script language="javascript">$(document).ready(wechat_obj.material_multi_init);</script>
    <div class="m_lefter multi">
         <div class="first" id="multi_msg_0">
            <div class="info">
                <div class="img">封面图片</div>
                <div class="title">消息标题</div>
            </div>
            <div class="control">
                <a href="#mod"><img src="${BasePath}/images/icon/mod.gif" /></a>
            </div>
            <input type="hidden" name="Title[]" value="" />
            <input type="hidden" name="Url[]" value="" />
            <input type="hidden" name="ImgPath[]" value="" />
        </div>
            <div class="list" id="multi_msg_1">
            <div class="info">
                <div class="title">标题</div>
                <div class="img">缩略图</div>
            </div>
            <div class="control">
                <a href="#mod"><img src="${BasePath}/images/icon/mod.gif" /></a>
                <a href="#del"><img src="${BasePath}/images/icon/del.gif" /></a>
            </div>
            <input type="hidden" name="Title[]" value="" />
            <input type="hidden" name="Url[]" value="" />
            <input type="hidden" name="ImgPath[]" value="" />
        </div>
                            <div class="add"><a href="#add"><img src="${BasePath}/images/icon/add.gif" align="absmiddle" /> 增加一条</a></div>
    </div>
    <div class="m_righter">
        <div class="mod_form">
            <div class="jt"><img src="${BasePath}/images/global/jt.gif" /></div>
            <div class="m_form">
                <span class="fc_red">*</span> 标题<br />
                <div class="input"><input name="inputTitle" value="" type="text" /></div>
                <div class="blank9"></div>
                <span class="fc_red">*</span> 封面图片 <span class="tips">大图尺寸建议：<span class="big_img_size_tips">640*360px</span></span><br />
                <div class="blank6"></div>
                <div><input name="FileUpload" id="MsgFileUpload" type="file" /></div>
                <div class="blank3"></div>
                <span class="fc_red">*</span> 链接页面<br />
                <div class="input">
		
		<select name='inputUrl'>
		<option value=''>--请选择--</option>
		<optgroup label='---------------系统模块链接---------------'></optgroup>
		<#if slinks??  >
			 <#list slinks as item>
					<option value='${item.url}' >${item.linkname}</option>  
			 </#list>				  	
		</#if>    
		<optgroup label='---------------自定义链接---------------'></optgroup>

		<#if clinks??  >
			 <#list clinks as item>
				<option value='${item.url}' >${item.linkname}</option>  
			</#list>				  	
		</#if> 
	
	</select>
	</div>
            </div>
        </div>
    </div>
            <div class="clear"></div>
<div class="button"><input type="submit" class="btn_green" name="submit_button" value="提交保存" /><a href="javascript:history.go(-1); " class="btn_gray">返回</a></div>

</form>
</div>  </div>
<div>
</body>
</html>