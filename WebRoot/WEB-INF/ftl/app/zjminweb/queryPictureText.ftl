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
<link href='${BasePath}/css/wechat.css' rel='stylesheet' type='text/css' />

<!--script type='text/javascript' src='${BasePath}/js/app/zj/zjweb.js'></script-->
<!--[if lte IE 9]><script type='text/javascript' src='${BasePath}/js/jquery.watermark-1.3.js'></script>
<![endif]-->
<style type="text/css">body, html{background:url(images/main-bg.jpg) left top fixed no-repeat;}</style>

<script>



var zj_obj={
	material_init:function(){
		$('#material>.list').masonry({itemSelector:'.item', columnWidth:367});
	},	
	material_multi_init:function(){
		var material_multi_list_even=function(){
			$('.multi .first, .multi .list').each(function(){
				var children=$(this).children('.control');
				$(this).mouseover(function(){children.css({display:'block'});});
				$(this).mouseout(function(){children.css({display:'none'});});
				
				children.children('a[href*=#del]').click(function(){
					if($('.multi .list').size()<=1){
						alert('无法删除，多条图文至少需要2条消息！');
						return false;
					}
					if(confirm('删除后不可恢复，继续吗？')){
						$(this).parent().parent().remove();
						$('.multi .first a[href*=#mod]').click();
						$('.mod_form').css({top:37});
					}
				});
				
				children.children('a[href*=#mod]').click(function(){
					var position=$(this).parent().offset();
					var material_form_position=$('#material_form').offset();
					var cur_id='#'+$(this).parent().parent().attr('id');
					$('.mod_form').css({top:position.top-material_form_position.top});
					$('.mod_form input[name=inputTitle]').val($(cur_id+' input[name=Title\\[\\]]').val());
					$('.mod_form input[name=inputDescription]').val($(cur_id+' input[name=Description\\[\\]]').val());
					/*$('.mod_form input[name=inputUrl]').val($(cur_id+' input[name=Url\\[\\]]').val());*/
					$('.mod_form select[name=inputUrl]').find("option[value='"+$(cur_id+' input[name=Url\\[\\]]').val()+"']").attr("selected", true);
					$('.big_img_size_tips').html(cur_id=='#multi_msg_0'?'640*360px':'300*300px');
					$('.multi').data('cur_id', cur_id);
					global_obj.file_upload($('#MsgFileUpload'), $(cur_id+' input[name=ImgPath\\[\\]]'), $(cur_id+' .img'));
				});
				$('.mod_form select[name=inputUrl]').find("option[value='"+$('input[name=Url\\[\\]]').val()+"']").attr("selected", true);
			});
		}
		
		global_obj.file_upload($('#MsgFileUpload'), $('.multi #pic_text0 input[name=ImgPath\\[\\]]'), $('#pic_text0 .img'));
		$('.multi').data('cur_id', '#pic_text0');
		$('.mod_form input').filter('[name=inputTitle]').on('keyup paste blur', function(){
			var cur_id=$('.multi').data('cur_id');
			$(cur_id+' input[name=Title\\[\\]]').val($(this).val());
			$(cur_id+' .title').html($(this).val());
		});
		$('.mod_form input').filter('[name=inputDescription]').on('keyup paste blur', function(){
			var cur_id=$('.multi').data('cur_id');
			$(cur_id+' input[name=Description\\[\\]]').val($(this).val());
			$(cur_id+' .description').html($(this).val());
		});
		$('.mod_form select').filter('[name=inputUrl]').change(function(){
			var cur_id=$('.multi').data('cur_id');
			$(cur_id+' input[name=Url\\[\\]]').val($(this).val());
		});
		
		material_multi_list_even();
		$('a[href=#add]').click(function(){

			$(this).blur();
			if($('.multi .list').size()>=10){
				alert('你最多只可以加入10条栏目链接！');
				return false;
			}
			$('.multi .list, a[href*=#mod], a[href*=#del]').off();
			$('<div class="list  menu-'+ (ptsize%4+ 1) +'" id="id_'+Math.floor(Math.random()*1000000)+'">'+$('.multi .list:last').html()+'</div>').insertAfter($('.multi .list:last'));
			debugger;
			$('.multi .list:last').children('.info').children('.text-cont').children('.title').html('标题').siblings('.description').html('摘要');
			$('.multi .list:last').children('.info').children('.image-cont').children('.img').html('缩略图');
			$('.multi .list:last input').filter('[name=Title\\[\\]]').val('').end().filter('[name=Description\\[\\]]').val('').end().filter('[name=Url\\[\\]]').val('').end().filter('[name=ImgPath\\[\\]]').val('');
			material_multi_list_even();
			ptsize = ptsize + 1;
		});
	},
	
	url_init:function(){
		$('#add_form').submit(function(){
			if(global_obj.check_form($('*[notnull]'))){return false};
			$('#add_form input:submit').attr('disabled', true);
			return true;
		});
	}

}



</script>

</head>

<body>

<div id="iframe_page">
    <div class="iframe_content">

<div class="r_nav">
    <ul>
    <li class="cur"><a href="${BasePath}/zj/queryPictureTexts.kq">栏目设置</a></li>
    <li><a href="${BasePath}/zj/queryScrollPictures.kq">幻灯片管理</a></li>
    <li><a href="${BasePath}/zj/queryBaseInfo.kq">基本信息管理</a></li>
    <li><a href="${BasePath}/zj/getZhaopin.kq">招聘管理</a></li>
	<li><a href="${BasePath}/zj/getAlbum.kq">微相册管理</a></li>
	<li><a href="${BasePath}/zj/getRetailstore.kq">门店管理</a></li>

    </ul>
</div>
<div id="material" class="r_con_wrap">

<style>


#material .multi .list{
	height: 110px;
	list-style: none;
	margin-bottom: 5px;
	position: relative;
	height:130px;
}

#material .multi .list{
	display: block;
	width: 100%;
	
}

#material .multi .list .info{

	height: 100%;


}

#material .multi .list .control{

	height: 100%;
	line-height: 140px;
}

#material .multi .list:nth-child(even) .info .text-cont{
	float: right;
}

#material .multi .list .info .text-cont{
	width: 32%;
	float: left;
	height: 95%;
	overflow: hidden;
}



#material .multi .list .info .text-cont{
	background-color: #218b81;
}

#material .multi .list .info .image-cont{
	width: 68%;
	float: left;
}
#material .multi .list .info .image-cont .img{
	display: block;
	height: 130px;
	width: 100%;
	line-height:125px;
}

#material .multi .list .info .image-cont .img a{
	display: block;
	line-height: 150px;
	height: 130px;
	width: 100%;
}


#material .multi .list .info .text-cont .title{
	line-height: 30px;
	font-size: 1em;
	color: #FFF;
	width: 95%;
	margin: 25px 5px 0px 5px;
}
#material .multi .list .info .text-cont .description{
	line-height: 20px;
	font-size: 0.8em;
	color: #FFF;
	width: 95%;
	margin: 0 5px 0px 5px;
}


#material .multi .menu-1 .info .text-cont{
	background-color: #218b81;
}
#material .multi .menu-2 .info .text-cont{
	background-color: #8019c2;
}
#material .multi .menu-3 .info .text-cont{
	background-color: #1f5a16;
}
#material .multi .menu-4 .info .text-cont{
	background-color: #bc4040;
}

#material .multi .list .info .img img {
max-width: 100%;
max-height: 100%;
height: 100%;
width: 100%;
}
</style>



<form id="material_form" method="post" action="updateMultiPictureText.kq?type=ptMessage">
                <script language="javascript">$(document).ready(zj_obj.material_multi_init);</script>
    <div class="m_lefter multi">
        

            <#list ptList as it>
            <div class="list menu-${it_index%4 + 1}" id="pic_text${it_index}">
                <div class="info">
                <div class="text-cont">
                    <div class="title">${it.title?default('')}</div>
                    
                    <div class="description">${it.description?default('')}</div>
                </div>
                
                <div class="image-cont">
                <div class="img"><img src="${BasePath}/${it.picUrl?default('')}"/></div>
                </div>
                </div>
                <div class="control">
                    <a href="#mod"><img src="${BasePath}/images/icon/mod.gif" /></a>
                    <a href="#del"><img src="${BasePath}/images/icon/del.gif" /></a>
                </div>
                <input type="hidden" name="Title[]" value="${it.title?default('')}" />

                <input type="hidden" name="Url[]" value="${it.url?default('')}" />
                <input type="hidden" name="ImgPath[]" value="${it.picUrl?default('')}" />
                <input type="hidden" name="Description[]" value="${it.description?default('')}" />
            </div>

            </#list>

            <script>var ptsize = ${ptList?size}</script>
           <div class="add"><a href="#add"><img src="${BasePath}/images/icon/add.gif" align="absmiddle" /> 增加一条</a></div>
    </div>
    
    <script type="text/javascript">
	$(function(){
		var height = $("#material .multi").width()*0.68*0.581;
		$("#material .multi .list").height(height);
		$("#material .multi .list .info .image-cont .img").height(height);
	});
</script>

    <div class="m_righter">
        <div class="mod_form">
            <div class="jt"><img src="${BasePath}/images/global/jt.gif" /></div>
            <div class="m_form">
                <span class="fc_red">*</span> 标题<br />
                <div class="input"><input name="inputTitle" value="${ptList[0].title?default('')}" type="text" /></div>
                <span class="fc_red">*</span> 摘要<br />
                <div class="input"><input name="inputDescription" value="${ptList[0].description?default('')}" type="text" /></div>
                <div class="blank9"></div>
                
                <span class="fc_red">*</span> 封面图片 <span class="tips">大图尺寸建议：<span class="big_img_size_tips">640*360px</span></span><br />
                <div class="blank6"></div>
                <div><input name="FileUpload" id="MsgFileUpload" type="file" />
                <input type="hidden" name="ImgPath" value="${ptList[0].picUrl?default('')}">
                </div>
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

		</select></div>
            </div>
        </div>
    </div>
            <div class="clear"></div>
<div class="button"><input type="submit" class="btn_green" name="submit_button" value="提交保存" /><a href="javascript:history.go(-1);" class="btn_gray">返回</a></div>
</form>
</div>  </div>
<div>
</body>
</html>