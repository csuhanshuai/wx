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

<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<div id="iframe_page">
    <div class="iframe_content">
        <div class="r_nav">
    <ul>
	<li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li class="cur"><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	
   </ul>
</div>

<div id="material" class="r_con_wrap">
            <form id="material_form" method="post" action="${BasePath}/zj/addPhoto.kq?almid=${almid}">
                            <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
                <div class="m_lefter one">
                    <div class="title">图片预览</div>
                      <div class="img" id="MsgImgDetail">封面图片</div>
                    <div class="txt"></div>
                </div>
                <div class="m_righter">
                    <div class="mod_form">
                        <div class="jt"><img src="${BasePath}/images/global/jt.gif" /></div>
                        <div class="m_form">
                        	<span class="fc_red">*</span> 上传到<br />
                            <div class="input">
                            <select name='Url'>
							    <!--<option value=''>--请选择--</option>
								<optgroup label='---------------自定义链接---------------'></optgroup>-->
							
									<#if albumlist??  >
										 <#list albumlist as item>
											<option value='${item.id}' <#if almid==item.id>selected="selected"</#if>>${item.name}</option>  
										</#list>				  	
									</#if> 

						    </select>
                            <div class="blank20"></div>
                            <span class="fc_red">*</span> 上传图片 <span class="tips">大图尺寸建议：640*360px</span><br />
                            <div class="blank6"></div>
                            <div>
                            
                            <input name="FileUpload" id="MsgFileUpload" type="file" style="display: none;" width="120" height="30">
                            
                            <input type="hidden" name="ImgPath" value="">
                            
                            </div>
                            <div class="blank12"></div>作为封面<br />
                             <span class="tips">
                             <input class="radio" name="iscovers" type="radio" value="1" checked="true"/>是
                             <input class="radio" name="iscovers" type="radio" value="0" />否
                             </span>
                            
                            <div class="blank12"></div>照片描述<br />
                            <div><textarea name="description"></textarea></div>
                            <div class="blank20"></div>
                            
						    <input name="oUrl" value="" type="hidden" />
			    </div>
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