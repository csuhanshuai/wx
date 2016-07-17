<!doctype html>
<html>
<head>
<#include "web-include.ftl">
<title>${mconf.mallname}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="软小三,优质软件,绿色软件，高性价比，高实用软件">
<meta name="keywords" content="软小三，高效，实用">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable"> 
<meta content="black" name="apple-mobile-web-app-status-bar-style"> 
<meta content="telephone=no" name="format-detection">
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/h5.css">
<style type="text/css">
	.pname{
		display: block;
		//width:92px;/*对宽度的定义,根据情况修改*/
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		//max-width:92px;   /*IE不能解释该属性，而FF可以*/
	}
	.pname:after{
		content:"...";
	}
	
	.checklabel{
		position: absolute;width: 100%;left: 0;border: 1px solid #ff6699;color: #fff;background-color: #ff6699!important;text-align: center;display: inline-block;/* height: 25px; */line-height: 32px;border-radius: 9px;
	}
	
	.nochecklabel{
		background:#ffffff;position: absolute;width: 100%;left: 0;border: 1px solid #ff6699;color: #ff6699;background-color: ;text-align: center;display: inline-block;/* height: 25px; */line-height: 32px;border-radius: 9px;
	}
</style>
<script type="text/javascript">

	function accDiv(arg1, arg2) {
			var t1 = 0, t2 = 0, r1, r2;
			try {
				t1 = arg1.toString().split(".")[1].length
			} catch (e) {
			}
			try {
				t2 = arg2.toString().split(".")[1].length
			} catch (e) {
			}
			with (Math) {
				r1 = Number(arg1.toString().replace(".", ""))
				r2 = Number(arg2.toString().replace(".", ""))
				return parseFloat((r1 / r2) * pow(10, t2 - t1) * 10).toFixed(1);
			}
		}
		
		function trim(str){   
    str = str.replace(/^(\s|\u00A0)+/,'');   
    for(var i=str.length-1; i>=0; i--){   
        if(/\S/.test(str.charAt(i))){   
            str = str.substring(0, i+1);   
            break;   
        }   
    }   
    return str;   
}
		
	function selectValue(index,openid,bid,id)
	{
		var abc = "labelA"+index;
		var labela = document.getElementById(abc);
    	//style = window.getComputedStyle(labela),
    	//display = style.getPropertyValue('background-color');
    	
    	//var colorflag = $("#"+abc).attr("colorflag");
    	var clssna = $("#"+abc).attr("class");
		//alert($("#"+abc).attr("class"));
		
		//if(colorflag == "1")
		
		//设置form值
		var form = document.getElementById("label_form");
		document.getElementById("openid").value = openid;
		document.getElementById("bid").value = bid;
		
		if(trim(clssna) == "nochecklabel")
		{
			//选中
			//$("#"+abc).attr("colorflag","0");
			labela.className ="checklabel";
			//window.location.href = '${BasePath}/zjmall/queryProductByLabel.kq?openid='+ openid + '&bid='+bid + '&labelid='+id+'_1'<#if selectlabelidlist?? && (selectlabelidlist?size>0) ><#list selectlabelidlist as item>+ '&labelid='+'${item.id?default("")}'+'_${item.isselect?default("")}'</#list></#if>;
			document.getElementById("labelid").value = id+'_1'<#if selectlabelidlist?? && (selectlabelidlist?size>0) ><#list selectlabelidlist as item>+ ','+'${item.id?default("")}'+'_${item.isselect?default("")}'</#list></#if>;
		}
		else
		{
			//去选中
			//$("#"+abc).attr("colorflag","1");
			labela.className ="nochecklabel";
			//window.location.href = '${BasePath}/zjmall/queryProductByLabel.kq?openid='+ openid + '&bid='+bid + '&labelid='+id+'_0'<#if selectlabelidlist?? && (selectlabelidlist?size>0) ><#list selectlabelidlist as item>+ '&labelid='+'${item.id?default("")}'+'_${item.isselect?default("")}'</#list></#if>;
			document.getElementById("labelid").value = id+'_0'<#if selectlabelidlist?? && (selectlabelidlist?size>0) ><#list selectlabelidlist as item>+ ','+'${item.id?default("")}'+'_${item.isselect?default("")}'</#list></#if>;
		}
		form.submit();
	}
</script>
</head>

<script>
	var i = 0;
	function getLables()
	{
		if(i%2 == 0)
		{
			i = i+1;
			document.getElementById("lablesdiv").style.display="";
		}
		else
		{
			i = i+1;
			document.getElementById("lablesdiv").style.display="none";
		}
	}
</script>

<body>
<div class="screen_wrap">
<header>
	<div class="lftarea">
		<a href="javascript:history.go(-1);"><img src="${BasePath}/images/app/zjmall/touch/ico-back.png" width="18" alt="" /></a>
	</div>
	<h2 class="title" id="tit">商品展示</h2>
	<!--<div class="sitebar">
		<a href="javascript:getLables();"  id="mainnav"><img src="${BasePath}/images/app/zjmall/touch/ico-menu.png" width="20" alt="menu" /></a>
	</div>-->
	
	
	<div id="lablesdiv" style="display: none;border-radius: 7px;position: absolute;background: #fff;border: 1px #ff6699 solid;right: 0;top: 43px;z-index: 1000;padding: 5px;width: 65px;box-shadow: 0px 5px 8px #CAB3B3;">
          	<ul>
            	<li>
              	<a href="#">商品标签</a>
              	</li>
            </ul>
	</div>
	
	
	
</header>



<!--主导航-->
<div class="shopcart">
		<!--<h2 class="shopcart_site_tt">-->
		<form id="label_form" action="${BasePath}/zjmall/queryProductByLabel.kq" class="" method="post">
			<input id="openid" name="openid" type="hidden" value=""/>
			<input id="bid" name="bid" type="hidden" value=""/>
			<input id="labelid" name="labelid" type="hidden" value=""/>
		</form>
		<#assign index=0/>
		<div style="background: #fff;font-size: 1.2em;line-height: 3em;text-align: center;color: #666;background:#5f5f5f;height:35px ;padding:6px;margin:0 auto;">
		    	<#if labellist?? && (labellist?size>0) >
		        <table>
		    	<tr>
	      		<#list labellist as item>
	      		<td style="width: 65px;">
			   <div style="position: relative;width: auto;height: 20px;/* line-height: 10px; */padding: 0 3.125%;font-size: 12px;margin-bottom: 25px;word-break:break-all;">
			    	<a colorflag="0" id='labelA${item_index+1}' href="javascript:selectValue('${item_index+1}','${openid}','${bid}','${item.id}');" 
			    		class="
							
							<#if selectlabelidlist?? && (selectlabelidlist?size>0) >
								<#assign flag=0/>
								<#list selectlabelidlist as selectlabelid>
									<#if item.id == selectlabelid.id>
										<#assign flag=1/>
										<#if '1' == selectlabelid.isselect>
											checklabel
										<#else>
											nochecklabel
										</#if>
									</#if>
									
								</#list>
								<#if 0 == flag>
									nochecklabel
								</#if>
							<#else>
								nochecklabel
							</#if>


							">
			    		${item.name}
			    	</a>
		    	</div>
		    	</td>
		       </#list>
		       </tr>
		    </table>
		    <#else>
			    <li><a href="#" class="item7">暂无标签</a></li>
		    </#if>
		</div>
		<!--</h2>-->
<!--主导航结束-->
<div class="srch_result_list">
		

		<#if pageFinder?? && (pageFinder.data)?? >
		<ul class="srch_list clearfix" id="commoditylist">
			 <#list pageFinder.result as item>	

				<li>
					<a  href="show.kq?bid=${mconf.bizid}&openid=${openid}&id=${item.id}">
			
						<img  alt="${item.ptitle}" src="${BasePath}/${item.imgpath}">
						<h3 class="pname">${item.ptitle}</h3>
					
					</a>
					<span id="disc_${item_index}" class="disc">7.5折</span>
					<p class="fr">
							<span class="price">
								￥ ${item.pric}
							</span>
							<del>￥ ${item.opric}</del>
					</p>
				</li>
				<script type="text/javascript">
						var saleprice_${item_index}= ${item.pric};
						var publicprice_${item_index}=${item.opric};
						var discount_${item_index} = accDiv(saleprice_${item_index},publicprice_${item_index});
						document.getElementById("disc_${item_index}").innerHTML=discount_${item_index}+"折";
						
				</script>

			</#list>	
			
			</ul>
		<div id="morePageDivId" class="button_area mt5">
	<a class="btn_brown w150" onclick="loadli();" style="color:#ff6699">查看更多</a>
	</div>			  	
		<#else>
			<img src="${BasePath}/images/app/zjmall/touch/ico-shopcart-108.png" width="54" alt="" />
			<p>还没有该标签类的商品哦...</p>
			<a href="${(mconf.url)?default('')}?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}" class="btn_org">去看看别的</a>
		</#if> 

		
		
</div>
</div>
<br/>
<#include "mweb-footer.ftl">
	
</div>
<script type="text/javascript">
window.addEventListener("orientationchange", function() {
// 横竖屏切换
document.location.reload();
}, false);
var current_page =1;
function loadli()

{		current_page = current_page + 1;
		$.ajax({
			'type' : 'post',
			'data' : ({
				'page' : current_page,
				'labelid':'${labelid}',
			}),
			'url' : ('nextQueryProductByLabel.kq'),
			success : function(str) {
				if(str==""&&current_page==1)
				{
				$("#noroduct").css("display","block"); 
				$("#morebut").css("display","none"); 
				return;
				}
				if(str.length<10)
				{ $("#morePageDivId").hide(); return ;}
				var catList = eval("("+str+")");
				addli(catList);
			}
		});
	
}
function addli(catList)
{
			for(var i = 0 ; i < catList.length; i++)
			{
				var tempObj = catList[i];
				var zeko=accDiv(tempObj.pric,tempObj.opric);
				var listr ='<li><a  href="show.kq?bid=${mconf.bizid}&openid=${openid}&id='+tempObj.id+'"><img src="${BasePath}/'+tempObj.imgpath+
				'"   alt="'+tempObj.ptitle+'"/><h3 class="pname">'+tempObj.ptitle+
				'</h3></a><span class="disc" >'+zeko+'折</span><p class="fr"><span class="price">￥'+
				tempObj.pric+'</span><del>￥'+tempObj.opric+'</del></p></li>';
				document.getElementById("commoditylist").insertAdjacentHTML("beforeEnd",listr); 
			}
}
</script>
</body>
</html>
