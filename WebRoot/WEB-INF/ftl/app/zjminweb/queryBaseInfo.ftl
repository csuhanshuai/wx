<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript">
	var bid="${bid}"; 	
	var BasePath="${BasePath}"; 
	  var code = ${code?default('-1')}
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
<style type="text/css">body, html{background:url(${BasePath}/images/main-bg.jpg) left top fixed no-repeat;}</style>
<link href='${BasePath}/css/app/zj/other/other.css' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/app/zjmall/mall.css' rel='stylesheet' type='text/css' />
<script src="${BasePath}/js/app/zjmall/qxmall.js"></script>
        
        
        <script>
        
        
jQuery.extend({


    createUploadIframe: function (id, uri) {
        //create frame
        var frameId = 'jUploadFrame' + id;
        var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
        if (window.ActiveXObject) {
            if (typeof uri == 'boolean') {
                iframeHtml += ' src="' + 'javascript:false' + '"';

            }
            else if (typeof uri == 'string') {
                iframeHtml += ' src="' + uri + '"';

            }
        }
        iframeHtml += ' />';
        jQuery(iframeHtml).appendTo(document.body);

        return jQuery('#' + frameId).get(0);
    },
    createUploadForm: function (id, fileElementId, data) {
        //create form	
        var formId = 'jUploadForm' + id;
        var fileId = 'jUploadFile' + id;
        var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');
        if (data) {
            for (var i in data) {
                if (data[i].name != null && data[i].value != null) {
                    jQuery('<input type="hidden" name="' + data[i].name + '" value="' + data[i].value + '" />').appendTo(form);
                } else {
                    jQuery('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
                }
            }
        }
        var oldElement = jQuery('#' + fileElementId);
        var newElement = jQuery(oldElement).clone();
        jQuery(oldElement).attr('id', fileId);
        jQuery(oldElement).before(newElement);
        jQuery(oldElement).appendTo(form);



        //set attributes
        jQuery(form).css('position', 'absolute');
        jQuery(form).css('top', '-1200px');
        jQuery(form).css('left', '-1200px');
        jQuery(form).appendTo('body');
        return form;
    },

    ajaxFileUpload: function (s) {
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout		
        s = jQuery.extend({}, jQuery.ajaxSettings, s);
        var id = new Date().getTime()
        var form = jQuery.createUploadForm(id, s.fileElementId, (typeof (s.data) == 'undefined' ? false : s.data));
        var io = jQuery.createUploadIframe(id, s.secureuri);
        var frameId = 'jUploadFrame' + id;
        var formId = 'jUploadForm' + id;
        // Watch for a new set of requests
        if (s.global && !jQuery.active++) {
            jQuery.event.trigger("ajaxStart");
        }
        var requestDone = false;
        // Create the request object
        var xml = {}
        if (s.global)
            jQuery.event.trigger("ajaxSend", [xml, s]);
        // Wait for a response to come back
        var uploadCallback = function (isTimeout) {
            var io = document.getElementById(frameId);
            try {
                if (io.contentWindow) {
                    xml.responseText = io.contentWindow.document.body ? io.contentWindow.document.body.innerHTML : null;
                    xml.responseXML = io.contentWindow.document.XMLDocument ? io.contentWindow.document.XMLDocument : io.contentWindow.document;

                } else if (io.contentDocument) {
                    xml.responseText = io.contentDocument.document.body ? io.contentDocument.document.body.innerHTML : null;
                    xml.responseXML = io.contentDocument.document.XMLDocument ? io.contentDocument.document.XMLDocument : io.contentDocument.document;
                }
            } catch (e) {
                jQuery.handleError(s, xml, null, e);
            }
            if (xml || isTimeout == "timeout") {
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if (status != "error") {
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jQuery.uploadHttpData(xml, s.dataType);
                        // If a local callback was specified, fire it and pass it the data
                        if (s.success)
                            s.success(data, status);

                        // Fire the global callback
                        if (s.global)
                            jQuery.event.trigger("ajaxSuccess", [xml, s]);
                    } else
                        jQuery.handleError(s, xml, status);
                } catch (e) {
                    status = "error";
                    jQuery.handleError(s, xml, status, e);
                }

                // The request was completed
                if (s.global)
                    jQuery.event.trigger("ajaxComplete", [xml, s]);

                // Handle the global AJAX counter
                if (s.global && ! --jQuery.active)
                    jQuery.event.trigger("ajaxStop");

                // Process result
                if (s.complete)
                    s.complete(xml, status);

                jQuery(io).unbind()

                setTimeout(function () {
                    try {
                        jQuery(io).remove();
                        jQuery(form).remove();

                    } catch (e) {
                        jQuery.handleError(s, xml, null, e);
                    }

                }, 100)

                xml = null

            }
        }
        // Timeout checker
        if (s.timeout > 0) {
            setTimeout(function () {
                // Check to see if the request is still happening
                if (!requestDone) uploadCallback("timeout");
            }, s.timeout);
        }
        try {

            var form = jQuery('#' + formId);
            jQuery(form).attr('action', s.url);
            jQuery(form).attr('method', 'POST');
            jQuery(form).attr('target', frameId);
            if (form.encoding) {
                jQuery(form).attr('encoding', 'multipart/form-data');
            }
            else {
                jQuery(form).attr('enctype', 'multipart/form-data');
            }
            jQuery(form).submit();

        } catch (e) {
            jQuery.handleError(s, xml, null, e);
        }

        jQuery('#' + frameId).load(uploadCallback);
        return { abort: function () { } };

    },

    uploadHttpData: function (r, type) {
        var data = !type;
        if (!type)
            data = r.responseText;
        if (type == "xml")
            data = r.responseXML;
        //data = type == "xml" || data ? r.responseXML : r.responseText;
        // If the type is "script", eval it in global context
        if (type == "script")
            jQuery.globalEval(data);
        // Get the JavaScript object, if JSON is used.
        if (type == "json") {
            ////////////Fix the issue that it always throws the error "unexpected token '<'"///////////////  
            data = r.responseText;
            var start = data.indexOf(">");
            if (start != -1) {
                var end = data.indexOf("<", start + 1);
                if (end != -1) {
                    data = data.substring(start + 1, end);
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////  
            eval("data = " + data);
        }
        // evaluate scripts within html
        if (type == "html")
            jQuery("<div>").html(data).evalScripts();

        return data;
    },

    handleError: function (s, xhr, status, e) {
        // If a local callback was specified, fire it
        if (s.error) {
            s.error.call(s.context || s, xhr, status, e);
        }

        // Fire the global callback
        if (s.global) {
            (s.context ? jQuery(s.context) : jQuery.event).trigger("ajaxError", [xhr, s, e]);
        }
    }
})
        

			function uploadFile(){
        			var file_id = this.id;
        			 $.ajaxFileUpload({
						 url: BasePath+'/uploadImageFile.kq',
						 secureuri: false,
						 fileElementId: file_id,
						 data:{
						 	bid:bid,
						 	do_action:'msgFileUpload',
						 },
						 type:'POST',
						 dataType:'json',
						 success: function (data, status) {
						 	var id = this.fileElementId;
						 	var index = id.substring(id.length-1);
						 	$("#item-img-"+index).attr("src",BasePath+"/"+data.imgpath);
						 	$("#item-img-value-"+index).attr("value",data.imgpath);
						 	$("#"+id).change(uploadFile);
						 	$("#cnt-wrapper-"+index).show();
						 }
					 });
        		}

        	$(function(){
        		if(code==0){
        			alert("操作成功!");
        		}
        		if(code==1){
        			alert("操作失败!");
        		}
        		$("input[name=FileUpload]").change(uploadFile);
        	});
        </script>
</head>

<body>

<div id="iframe_page">
    <div class="iframe_content">

<div class="r_nav">
    <ul>
    <li ><a href="${BasePath}/zj/queryPictureTexts.kq">栏目设置</a></li>
    <li ><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li class="cur" ><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
    <li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>
	</ul>
</div>
<div id="attention" class="r_con_wrap">
    <form id="attention_reply_form" class="r_con_form" method="post" action="${BasePath}/zj/updateBaseInfo.kq">
        <input type="hidden" name="id " value="${biList[0].id}" />
        <input type="hidden" id="skinid"  name="skinid" value=''${(biList[0].modelid)?default("1")}'' >
        <div class="rows">
            <label>开发者</label>
            <span class="input">
                <input class="form_input" name="developer" value="${biList[0].developer}"/>
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows">
            <label>URL</label>
            <span class="input">
               <select name='dvlUrl'>
		<option value=''>--请选择--</option>
		<optgroup label='---------------系统模块链接---------------'></optgroup>
		<#if slinks??  >
			 <#list slinks as item>
					<option value='${item.url}' <#if biList[0]??&&biList[0].dvlUrl==item.url>selected</#if>>${item.linkname}</option>  
			 </#list>				  	
		</#if>    
		<optgroup label='---------------自定义链接---------------'></optgroup>

		<#if clinks??  >
			 <#list clinks as item>
				<option value='${item.url}' <#if biList[0]??&&biList[0].dvlUrl?default('')==item.url>selected</#if>>${item.linkname}</option>  
				
			</#list>				  	
		</#if> 

		</select>
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows">
            <label>页脚</label>
            <span class="input">
                <input class="form_input" name="footer" value="${biList[0].footer}"/>
            </span>
            <div class="clear"></div>
        </div>

   <div class="rows" id="text_msg_row">
            <label>模板选择</label>
            <span class="input">
	   <div id="skin" >
		 <ul class="slider-statu" id="imgul">
			<#if imList??>
				<#list imList as item>
					<li <#if biList[0]??&&biList[0].modelid?default('')==item.id> class="cur"</#if> onclick="changskin(${item.id},this)">
						<div title="点击选择微商城风格" sid="${item_index+1}" class="item">
							<div class="img">
							<img style="width:100%;height:auto;" src="${BasePath}/${item.imgurl}" ></div>
							<div class="title">风格${item_index+1}</div>
						</div>
					</li>
				</#list>
			</#if>			
		 </ul>
	   </div>
	       </span>
           <div class="clear"></div>
    </div>

        
                 <div class="rows">
            <label>背景图片</label>
            <span class="input">
                <img style="max-width: 70px;max-height: 70px;"  src="${BasePath}/${biList[0].backgroundUrl?default('')}" id="item-img-0" />
                <input type="hidden" name="backgroundUrl" id="item-img-value-0" value="${biList[0].backgroundUrl?default('')}">
            	<div class="item-head" style="display: inline-block;width: 310px;">
                <input type="file" name="FileUpload" class="fileUpload" id="fileUpload-0" />
                <div class="wn-upload">
                </div>
                <span class="upload-tip">建议尺寸：640像素 * 425像素</span>
            </div>
            </span>
            <div class="clear"></div>
        </div>
        <div class="rows">
            <label></label>
            <span class="input"><input type="submit" class="btn_green" name="submit_button" value="提交保存" /></span>
            <div class="clear"></div>
        </div>
        <input type="hidden" name="do_action" value="wechat.attention_reply">
    </form>
</div>  </div>
<div>
</body>
</html>