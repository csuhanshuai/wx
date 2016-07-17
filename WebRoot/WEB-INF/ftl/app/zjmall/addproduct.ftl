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
	
	function labelcheck(type)
	{
		var str=document.getElementsByName("plabel");
		
		var objarray=str.length;
		var chestr="";
		for (i=0;i<objarray;i++)
		{
		  if(str[i].checked == true)
		  {
		   chestr+=str[i].value+",";
		  }
		}
		document.getElementById("selectlabel").value=chestr;
		
		subcheck(type);
	}
</script>
	
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
        <form id="addform" name="addform" class="r_con_form" method="post" role="form" action="<#if flag?? && flag=='mod'>update.kq<#else>addProduct.kq</#if>">
	    <input type="hidden" id="type" name="type" value="${type}"/>	
	    <input type="hidden" id="imgcount"  name="imgcount"  >
	    <input type="hidden" id="imgpath"  name="imgpath"  > 
	    <input type="hidden" id="fristimgh"  name="fristimgh"  > 
	    <input type="hidden" id="fristimgw"  name="fristimgw"  >	
	    <input type="hidden" id="selectlabel"  name="selectlabel"  >
	    <#if flag?? && product?? && flag=='mod'><input type="hidden" id="id" name="id" value="${product.id?default("")}"/>	</#if>
	    <div class="rows">
                <label>产品名称</label>
                <span class="input"> 
		<input id=ptitle  type=text name=ptitle required  value='<#if flag?? && product?? && flag=='mod'>${product.ptitle?default("")}<#else>新款</#if>'/>
		<div class="tips">不超过30个字</div></span>
                <div class="clear"></div>
            </div>
	 <!--div class="rows">
                <label>产品编号</label>
                <span class="input"> 
		<input id=pid type=text name=pid required  value='<#if flag?? && product?? && flag=='mod'>${product.pid?default("")}<#else>P30112801</#if>'/>
		<div class="tips">在外部系统的编号，例如在供应商的编号或条形码等</div></span>
                <div class="clear"></div>
            </div-->
	    <input id=pid type=hidden name=pid required  value='<#if flag?? && product?? && flag=='mod'>${product.pid?default("")}<#else>P800888</#if>'/>
	     <div class="rows">
                <label>产品价格</label>
                <span class="input"> 
		<input id=pric class=textbox type=text name=pric required value='<#if flag?? && product?? && flag=='mod'>${product.pric?default("")}<#else>1</#if>' /> 
		<div class="tips">产品的销售价格</div></span>
                <div class="clear"></div>
            </div>
	<div class="rows">
                <label>参考价格</label>
                <span class="input"> 
		<input id=opric class=textbox type=text name=opric required value='<#if flag?? && product?? && flag=='mod'>${product.opric?default("")}<#else>100</#if>' />
		<div class="tips">产品的参考价格</div></span>
                <div class="clear"></div>
            </div>
            <div class="rows" id="img_msg_row">
                <label>产品类型</label>
                <span class="input">
             <select id=ptype  name=ptype class=selectbox>
			 <#if producttypes?? && (producttypes.data)?? >
			    <#list producttypes.result as ptype>
				<option value="${(ptype.id)}" <#if flag?? && product?? && flag=='mod' && product.ptype == ptype.id>selected</#if>>${(ptype.typename)}</option>
			    </#list>   
			</#if>
		</select>
                <a href="${BasePath}/mallmanage/queryProductType.kq?type=ptypemanage" class="material">产品分类管理</a>
                </span>
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label>产品标签</label>
                <span class="input">
                   <#if productLabels??>
					    <#list productLabels as productlabel>
				           <label><input name="plabel" type="checkbox" value="${productlabel.id}" />${productlabel.name}</label>
					    </#list>   
				   </#if>
		          <!--<div class="tips">商品备注</div>-->
		         </span>
                <div class="clear"></div>
            </div>
            
            <div class="rows" id="img_msg_row">
                <label>产品类别</label>
                <span class="input">
			   <select id=category  name=category class=selectbox>
				<option value="1" <#if flag?? && product?? && flag=='mod' && product.category?? && product.category == '1'>selected="selected"</#if>>实物商品</option>
				<option value="2" <#if flag?? && product?? && flag=='mod' && product.category?? && product.category == '2'>selected="selected"</#if>>虚拟商品</option>
			</select>
		</span>
                <div class="clear"></div>
            </div>
            
		<div class="rows" id="img_msg_row">
                <label>产品状态</label>
                <span class="input">
			<select id=status  name=status class=selectbox>
				<option value="1" <#if flag?? && product?? && flag=='mod' && product.status == '1'>selected="selected"</#if>>新品发布</option>
				<option value="2" <#if flag?? && product?? && flag=='mod' && product.status == '2'>selected="selected"</#if>>近期更新</option>
				<option value="3" <#if flag?? && product?? && flag=='mod' && product.status == '3'>selected="selected"</#if>>降价处理</option>
				<option value="4" <#if flag?? && product?? && flag=='mod' && product.status == '4'>selected="selected"</#if>>停售</option>
			</select>
		</span>
                <div class="clear"></div>
            </div>
	    <div class="rows">
                <label>商品描述</label>
                <span class="input"> 
		<input id=description class=textbox type=text name=description required  value='<#if flag?? && product?? && flag=='mod'>${product.description?default("")}<#else>Nothing</#if>'/> 
		<div class="tips">商品描述信息-（升级后为属性）</div></span>
                <div class="clear"></div>
            </div>
	    <div class="rows">
                <label>商品备注</label>
                <span class="input"> 
		<textarea id=remark name=remark cols=30 rows=5 value=''><#if flag?? && product?? && flag=='mod'>${product.remark?default("")}<#else>Nothing</#if></textarea>
		<div class="tips">商品备注</div></span>
                <div class="clear"></div>
            </div>
	     <div class="rows"  id="imgshow">
                <label>图片上传</label>
                <span class="input"> 
		
		
		<#if flag?? && product?? && flag=='mod'>
		<div id="imgdetail" class="dtl_item dtl_img" style="display:">
                    	<dt>细节展示图：</dt>
                        <dd class="pro_img" id="imglist"></dd>
		<script type="text/javascript">
			var imgurl="${product.imgpath}";		
			urlstr=imgurl.substring(0,imgurl.length-5);
			var count=${product.imgcount};	
			for(var i=1;i<=count;i++)
			{
			$('#imglist').append('<img src="${BasePath}/'+urlstr+i+'.jpg" width="240" alt=""/>'); 

			}
		
		</script>
                    </div>
        </#if>
                    
         <div id="more"></div>   
		<div id="divline" style="text-align:left;margin:0 10px; "> -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --</div>  
		<input type="button"  value="选择图片" id="btnadd" onclick="createInput('more');" />  
		<input type="button"  value="上传图片" id="btnsub" onclick="javascript:flashupload('<#if flag?? && product?? && flag=='mod'>1</#if>')"/>  
		<ul class="slider-statu" id="imgul">
		</ul>
		<script>
			function flashupload(type)
			{
				if(type && type == '1')
				{
					//$('#imgdetail').style.display="none";
					document.getElementById("imgdetail").style.display="none";
				}
				ajaxFileUploadImgs(450,600);
			}
		</script>
		<div class="tips"></div></span>
                <div class="clear"></div>
            </div>
            <div class="rows">
                <label></label>
                <span class="input">			
		<input type="button" class="btn_green" name="submit_button" onclick="javascript:labelcheck('<#if flag?? && product?? && flag=='mod'>1</#if>');"  value="<#if type?? && type=='mod'>修改<#else>提交</#if>保存" /><a href="${BasePath}/mallmanage/queryProduct.kq?type=pmanage" class="btn_gray">返回</a></span>
                <div class="clear"></div>
            </div>
        </form>


    </div>  </div>
<div>
<script>
createInput('more');
</script>
</body>
</html>