<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
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
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='${BasePath}/js/wechat.js'></script>

</head>

<body>

<style type="text/css">body, html{background:url(images/main-bg.jpg) left top fixed no-repeat;}</style>
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
            <form id="material_form" method="post" action="${BasePath}/addPTMessage.kq?type=ptMessage">
                            <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
                <div class="m_lefter one">
                    <div class="title">消息标题</div>
                      <div class="img" id="MsgImgDetail">封面图片</div>
                    <div class="txt"></div>
                </div>
                <div class="m_righter">
                    <div class="mod_form">
                        <div class="jt"><img src="${BasePath}/images/global/jt.gif" /></div>
                        <div class="m_form">
                            <span class="fc_red">*</span> 标题<br />
                            <div class="input"><input name="Title" value="" type="text" /></div>
                            <div class="blank20"></div>
                            <span class="fc_red">*</span> 封面图片 <span class="tips">大图尺寸建议：640*360px</span><br />
                            <div class="blank6"></div>
                            <div>
                            
                            <input name="FileUpload" id="MsgFileUpload" type="file" style="display: none;" width="120" height="30">
                            
                            <input type="hidden" name="ImgPath" value="">
                            </div>
                            <div class="blank12"></div>
                            简短介绍<br />
                            <div><textarea name="BriefDescription"></textarea></div>
                            <div class="blank20"></div>
                            <span class="fc_red">*</span> 链接页面<br />
                            <div class="input"><select name='Url'>
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

			    </select><input name="oUrl" value="" type="hidden" /></div>
                        </div>
                    </div>
                </div>
                        <div class="clear"></div>
            <div class="button"><input type="submit" class="btn_green" name="submit_button" value="提交保存" /><a href="javascript:history.go(-1); " class="btn_gray">返回</a></div>
            <input type="hidden" name="MId" value="0" />
            <input type="hidden" name="MaterialType" value="0" />
            <input type="hidden" name="do_action" value="wechat.material">
        </form>
    </div>  </div>
<div>

</body>
</html>