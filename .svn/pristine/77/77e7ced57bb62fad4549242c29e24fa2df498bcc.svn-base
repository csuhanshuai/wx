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
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/goods.css">
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
function addtocart(id,openid)
{
  <!--获得选择商品数量的值-->
  var number = document.all.inpProNum.value;
$.ajax({
			'type' : 'post',
			'url' : ('${BasePath}/zjmall/addtocart.kq?id='+id+'&openid='+openid+'&number='+number),
			success : function(str) {
						if(!str) return ;
						if(str=="logout")
							alert("对不起！请您先加入会员！");
						else
							alert(str);
					}
		});
}

function proNumOperate(type)
{
	var number = document.all.inpProNum.value;
	if(type == '0' && parseInt(number) > 1)
	{
		document.all.inpProNum.value = parseInt(number)-1;
	}
	else if(type == '1')
	{
		document.all.inpProNum.value = parseInt(number)+1;
	}

}

//立即购买
function nowToOrder(id,openid,bid)
{
    var number = document.all.inpProNum.value;
    window.location.href = '${BasePath}/zjmall/nowToOrder.kq?id='+id+'&openid='+ openid + '&bid='+bid+'&number='+number;
}
</script>
</head>

<body>
<div class="screen_wrap">
<header>
	<div class="lftarea">
		<a href="javascript:history.go(-1);">
		<img src="${BasePath}/images/app/zjmall/touch/ico-back.png" width="18" alt="" /></a>
	</div>
	<h2 class="title" id="tit">商品详情</h2>
	<!--<div class="sitebar">
		<a href="#"  id="mainnav">
		<img src="${BasePath}/images/app/zjmall/touch/ico-menu.png" width="20" alt="menu" /></a>
	</div>-->
</header>

<!--主导航-->
<div class="navmenu" id="ygnavmenu">
	<i class="corner"></i>
	<h2>${mconf.mallname}</h2>
	<div class="bd">
		<ul>
			<li ><a href="/touch" class="item1">主页</a></li>
			<li ><a href="/touch/sell" class="item2">促销专区</a></li>
			<li ><a href="/touch/tehui" class="item3">今日特惠</a></li>
			<li ><a href="/touch/top100" class="item4">TOP 100</a></li>
			<li ><a href="/touch/xinpin" class="item5">每日新品</a></li>
			<li ><a href="/touch/brand" class="item6">品牌馆</a></li>
			<li ><a href="/touch/fenlei" class="item7">分类浏览</a></li>
			<li ><a href="/touch/my/myIndex.sc" class="item8">我的优购</a></li>
		</ul>
	</div>
</div>	
<!--主导航结束-->
    <!--商品详情 start-->
    <#if product?? >
    <section class="prodtl">
    	<div class="prodtl_hd">
            <div class="d_item prodtl_info">
                <div class="hd">
                	<div class="pro_img tac jsShowBigProImg rel">
               			<a href="javascript:void(0);">
	                	    <img src="${BasePath}/${product.imgpath}" width="240"  />
	                		<!--i class="ico_eye">查看大图</i-->
                		</a>
                	</div>
                    <p class="pro_brand">${product.ptitle}</p>
                    <h1>${product.ptitle}</h1>
                </div>
                <div class="bd">
                    <ul class="pro_sku clearfix">
                        <li class="marketprice">市场价：<del>&yen;${product.opric}</del></li>
                        <li>商品编号：<strong>${product.id}</strong></li>
                       		<li>特惠价：<span class="price">&yen;${product.pric}</span></li>
                       		<li class="discount">折扣：
				<span class="price"><em id="disc_${product.id}">3.5</em><strong>折</strong></span></li>
				<script type="text/javascript">
						var discount_${product.id} = accDiv(${(product.pric)},${(product.opric)});
						document.getElementById("disc_${product.id}").innerHTML=discount_${product.id};
						
				</script>
                    </ul>
                </div>
            </div>
            <!--<div class="d_item prodtl_act">
		            	<div class="hd">
		                	<h2>限时抢</h2>
		                    <p><span class="price">限时特惠</span>
				
				    <em class="time">还剩8天8小时8分钟</em></p>
				</div>
				
		                <div class="bd">
		                	<h3>促销详情:</h3>
													
		                    <dl class="prodtl_actdtl">
		                    	<dt><i></i>活动明细</dt>
		                        <dd>不支持使用优惠券</dd>
		                        <dt><i></i>活动条件</dt>
		                        <dd>活动会员对象：全部会员</dd>
		                        <dd>活动时间：<span class="time">2013-11-11 0:00~2014-1-11 0:00</span></dd>
		                    </dl>
		                </div>
            </div>-->
       <div class="d_item prodtl_opt">
            <!--	<dl class="opt_item opt_color">
                	<dt>颜色</dt>
                    <dd class="jsCheckColor">
					<a class="checked" href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-Black.jpg" width="30" alt="黑色" /><i></i></a>
					<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-Blue.jpg" width="30" alt="蓝色" /><i></i></a>
                        		<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-Gray.jpg" width="30" alt="灰色" /><i></i></a>
                        		<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-Green.jpg" width="30" alt="绿色" /><i></i></a>
                        		<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-Purple.jpg" width="30" alt="紫色" /><i></i></a>
                        		<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-White.jpg" width="30" alt="白色" /><i></i></a>
                        		<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-red.jpg" width="30" alt="红色" /><i></i></a>
                        		<a  href="">
					<img src="${BasePath}/images/app/zjmall/touch/s-Yellow.jpg" width="30" alt="黄色" /><i></i></a>
                         <a class="checked"><img src="images/temp/60.jpg" width="30" alt="产品图" /><i></i></a>
                    </dd>
                </dl>-->
                <dl class="opt_item opt_cm">
                    <dt>款型</dt>
                    <dd class="jsCheckCm">
				<a nos="99840143004"><span>标准</span></a>
		    <input type="hidden" name="" id="sizeNo" />
                    </dd>
                </dl>
                <dl class="opt_item opt_num">
                	<dt>数量</dt>
                    <dd>
                    	<a class="plut" href="javascript:proNumOperate('0');"><span>-</span></a>
                         <input type="number" name="" value="1" maxlength="1" id="inpProNum" readonly/>
                        <a class="add" href="javascript:proNumOperate('1');"><span>+</span></a>
                    </dd>
                </dl>
		
				<#if labels??>
				<dl class="opt_item opt_num">
                	<dt>标签</dt>
                    <dd>
                    	<table>   
  						<tr>
					    <#list labels as productlabel>
					    	<td style="width: 55px;">
						        <div style="position: relative;width: 50px;height: 20px;/* line-height: 10px; */padding: 0 3.125%;font-size: 12px;margin-bottom: 25px;word-break:break-all;">
			            			<a href="${BasePath}/zjmall/queryProductByLabel.kq?labelid=${productlabel.id}&openid=${openid}&bid=${bid}" style="position: absolute;width: 100%;left: 0;box-shadow: 0 -1px 0 0 #ff6699 inset;color: #fff;background-color: #ff6699!important;text-align: center;display: inline-block;/* height: 25px; */line-height: 32px;border-radius: 9px;">${productlabel.name}</a>
			        			</div>
		        			</td>
					    </#list>   
				   		</tr>   
  						</table>
                    </dd>
                </dl>
                </#if>
                
                <div class="opt_tx jsOptTx">
				<!--<span>本商品需要订货</span>
                     <a class="collect jsAddFav" no="/touch/my/addFavorite.sc?commodityNo=99840143" href="javascript:void(0)"></a>
                    <a class="online" href="javascript:void(0)" style="visibility:hidden"></a>
                    <a class="ishare jsIshare" href="javascript:void(0)"></a>-->
                </div>
                <div class="prodtl_buy"><a class="btn_org" href="javascript:nowToOrder('${product.id}','${openid}','${bid}')" id="buy">立即购买</a>
                <a class="btn_brown" href="javascript:addtocart('${product.id}','${openid}')" id="addShop" style="color:#dd6699">加入购物车</a></div>
                <section class="waptip none">
                    <div class="hd">温馨提示</div>
                    <div class="bd">
                        <p>请选择颜色、型号</p>
                    </div>
                    <div class="ft">
                        <a href="" class="btn_org">知道了</a>
                    </div>
                </section>
            </div>
        </div>      
 
        
        <div class="prodtl_bd jsTab">
        	<ul class="tab_hd">
                <li class="trg1 curr"><a><span>详情</span></a></li>
		<!--li class="" callback="bindComment" ajaxurl="/touch/commentList?productid=99840143"><a><span>评论</span></a></li>
                <li class="" ajaxurl="/touch/recommend?productid=99840143"><a><span>相关推荐</span></a></li-->
            </ul>
            <div class="tab_bd">
            	<div class="tab_item prodtl_dtl">
                	<dl class="dtl_item">
                    	<dt>商品详情：</dt>
                        <dd>
                        	<ul class="prodesc_lst clearfix">
				<li>${product.description}</li>

                            </ul>
                        </dd>
                    </dl>
                    <!--dl class="dtl_item">
                    	<dt>产品描述：</dt>
                        <dd> </dd>
                    </dl-->
                    <dl class="dtl_item dtl_img">
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
                    </dl>
                </div>
                <div class="tab_item prodtl_cmmt none">
                                                    正在获取信息，请稍等...
                </div>
            	<div class="tab_item prodtl_tj none">
            	             正在获取信息，请稍等...
                </div>
            </div>
        </div>
    </section>
    </#if>	
    <!--商品详情 end-->
<#include "mweb-footer.ftl">
</div>
</body>
</html>