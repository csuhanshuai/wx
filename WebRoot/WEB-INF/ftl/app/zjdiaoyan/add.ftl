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


<div id="wechar_zhaopin" class="r_con_wrap">
            <form id="material_form" method="post" action="${BasePath}/addPTMessage.kq?type=ptMessage">
                   <script language="javascript">$(document).ready(wechat_obj.material_one_init);</script>
                    <div class="mod_form">
                        <div class="m_form">
                            <div>
	                            <input name="FileUpload" id="MsgFileUpload" type="file" style="display: none;" width="120" height="30">
	                            
	                            <input type="hidden" name="ImgPath" value="">
                            </div>
                        </div>
                        <input type="button" class="btn_green" onclick="showUrl()" value="提交保存" />
                    </div>     
        </form>
    </div>  
    </div>
<div>

</body>
<script>
function showUrl()
{
alert(document.forms[0].ImgPath.value);
return;
}
</script>
</html>