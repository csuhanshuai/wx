<!doctype html>
<html style="background: #ff6699;">
<head>
<#include "web-include.ftl">
<title>我的订单</title>
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
</style>
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/common.css" />
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/style.css" />
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/mall_v1.css" />
<link rel="stylesheet" href="${BasePath}/css/app/zjmall/myorderdetail.css" />
<style type="text/css">
</style>
<script type="text/javascript">
try{
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
        WeixinJSBridge.call('hideToolbar');
        WeixinJSBridge.call('hideOptionMenu');
    });
    
    
    
    function pay(orderid,openid,bid)
    {
    	$.ajax({
				url: "${BasePath}/mallmanage/zjmall/payOrder.kq?orderid=" + orderid + "&openid="+ openid +"&bid=" + bid,
	    		    type: "POST",
	    		    date: "",
	    		    datetype: "json",
	    		    async: false,
	    		    timeout: 1000,
				success: function(result){
	    		    var res = eval("(" +result+")" );
	    		    if(res.result == 'success'){
						
							if(res.t && res.t.order)
							{
								var proname = document.getElementById("protitle").value;
								window.location.href = '${BasePath}/nosecurity/alipay/go.kq?out_trade_no='+ openid + '&subject='+proname + '&order_id='+res.t.order.id + '&total_fee='+res.t.order.totalMoney;							           
							}
							else
							{
								window.location.href = '${BasePath}/zjmall/myOrder.kq?openid='+ openid + '&bid='+bid;
							}

					}
	    		    else
	    		    {
	    		    	alert(response.message,1500);
	    		    }	
	    		    	
	    		    },
	    		    error: function(){
	    		    	alert('操作失败!',1500);
	    		    }
			});
    
    
    
    }
    
    
    
    
}catch(e){

}
</script>

</head>
<body style="background: #fff;">
    <section class="section_1">
       	<div style="word-break:break-all;"><p style="color:#ff6699;">订单号<span class="orderId">${order.id}</span><span class="">(<#if (order.status) == 0> 未支付<#elseif (order.status) == 1>已支付<#elseif (order.status) == 2>已发货<#elseif (order.status) == 3>已完成<#else>未知状态</#if>)</span></p></div>
    </section>
    <div style="height:15px;">&nbsp;</div>
    <section>
            <div class="gList">
            <div class="J_product_list">
            <#list orderDetailList as orderDetail>
               <div class="item">
                    <p class="img_wrap"><a href="show.kq?id=${orderDetail.pid}&bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}" class="J_ytag"><img src="${BasePath}/${orderDetail.imgPath}" width="70"></a></p>
                    <p class="tt"><a href="javascript:;" class="J_ytag">${orderDetail.ptitle}</a></p>
                    <p class="num">x<span>${orderDetail.buyNum}</span></p>
                    <p class="price">&yen;${orderDetail.totalMoney}</p>
                </div>
             </#list>
             <input type="hidden" id="protitle" value="<#if orderDetailList?? && (orderDetailList?size>0)><#list orderDetailList as item><#if item_index == 0 >${item.ptitle?default('')}</#if></#list><#if (orderDetailList?size>1) >等商品</#if></#if>">
            </div>
            </div>
    </section>
    
    
    <section>
        <article>
            <div class="orderInfo" >
                <!--<p>快递费：<span class="delivery_price"></span></p>-->
                <!--<p class="point_con">积分使用：<span class="point"></span> 积分抵消 <span class="point_price"></span> 元 </p>-->
                <p>下单时间：<span style="color:#c73d00;font-weight: bold;">${order.orderTime?default('')}</span> </p>
                <p>总金额：<span class="totalprice" style="color:#c73d00;font-weight: bold;">￥${order.totalMoney?default('')}</span> (<span class="paytype"><#if (order.payType?default('')) == "1"> 余额支付<#elseif (order.payType?default('')) == "2">支付宝<#else>其它支付</#if></span>)</p>
                <p>优惠金额：<span class="receiver_name">￥${orderDetailList[0].totalMoney?default(0) - order.totalMoney?default(0)} </span></p>
                <p>收货人：<span class="receiver_name">${order.receiver?default('')}</span></p>
                <p>联系电话：<span class="receiver_tel">${order.phoneNum?default('')}</span></p>
                <p>收货地址:<span class="receiver_addr">${order.receiveAddr?default('')}</span></p>
                <p>备注：<span class="remark"></span></p>
            </div>
        </article>
    </section>
    <!--
    <section>
        <article class="follow">
            <h2>快递公司：<span class="delivery">${order.expcompany?default('')}</span></h2> 
            <h2>快递单号：<span class="delivery">${order.expNum?default('')}</span></h2>
        </article>
    </section>
	-->
    <section >
            <#if (order.status) == 0>
		        <div class="order_con">
		        <a href="javascript:pay('${order.id}','${openid?default('')}','${bid?default('')}');" class="pay">支付</a>
		        <a href="${BasePath}/mallmanage/zjmall/cancelOrder.kq?orderid=${order.id}&openid=${openid?default('')}&bid=${bid?default('')}" class="cancel">取消订单</a>
		        </div>
            <#elseif (order.status) == 1 || (order.status) == 2>
		        <div class="confirm_con">
		            <a href="${BasePath}/mallmanage/zjmall/confirmOrder.kq?orderid=${order.id}&openid=${openid?default('')}&bid=${bid?default('')}" class="confirm_btn">确认收货</a>
		        </div>
		    <#else>
		    	<div class="confirm_con">
		            <a href="javascript:history.go(-1);" class="confirm_btn">返回</a>
		        </div>
		    </#if>
            
    </section>
    <section class="confirm" style="">
    </section>
    <div style="height:40px;">&nbsp;</div>
    <script type="text/x-template" id="goods_list_tpl">
        <div class="gList">
            <div class="J_product_list">
                <!-- 这里如果for 循环即可 -->
                {{#each goodslist as goods}}
                <div class="item">
                    <p class="img_wrap"><a href="javascript:;" class="J_ytag"><img src="{{window.res_path_prefix + goods.cover}}" width="70"></a></p>
                    <p class="tt"><a href="javascript:;" class="J_ytag">{{goods.name}}&nbsp;&nbsp;{{#if goods.category}}({{goods.category}}){{/if}}{{#if goods.category2}}({{goods.category2}}){{/if}}</a></p>
                    <p class="num">x<span>{{goods.count}}</span></p>
                    <p class="price">&yen;{{goods.total_price}}</p>
                </div>
                {{/each}}
            </div>
        </div>
    </script>
    <script type="text/javascript" src="${BasePath}/js/app/zj/zepto.min.js"></script>
    <script type="text/javascript" src="${BasePath}/js/app/zjmall/myorder/jquery.template.js"></script>
    <script type="text/javascript" src="${BasePath}/js/app/zjmall/myorder/cookie.min.js"></script>
    <script type="text/javascript" src="${BasePath}/js/app/zjmall/myorder/naroto.js"></script>
    <script type="text/javascript" src="${BasePath}/js/app/zjmall/myorder/jquery.deparam.js"></script>
    <script type="text/javascript" src="${BasePath}/js/app/zjmall/myorder/toolbar.js"></script>
    <script type="text/javascript">
        var goods = {};
        var params = $.deparam(window.location.search.slice(1));
        var orderId = params["orderId"];
        var wuid = params["wuid"];
        var shopId = params["shopId"] || "";
        var cbdId = params["cbdId"] || "";
        // var talker = params["talker"];
        
        // 导航条
        initToolbar(5268, 88, shopId, cbdId);
        var wxPay = function(){
        	// 微信支付
            $.ajax({
                url: "/mobile/lightmall/order",
                data: {
                    orderId: orderId,
                    wuid: wuid,
                    action: "findWxPay"
                },
                dataType: "json",
                success: function(data){
                    if (window.WeixinJSBridge) {
                        WeixinJSBridge.invoke('getBrandWCPayRequest',{
                            "appId" : data.wxPayData.appId, //公众号名称，由商户传入
                            "timeStamp" : data.wxPayData.timeStamp, //时间戳
                            "nonceStr" : data.wxPayData.nonceStr, //随机串
                            "package" : data.wxPayData.packageStr,//扩展包
                            "signType" : data.wxPayData.signType, //微信签名方式:1.sha1
                            "paySign" : data.wxPayData.sign //微信签名
                        },function(res){
                            if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                                var dialog = new Naroto.Dialog();
                                dialog.confirm('支付成功', "确定", "我的订单");
                                dialog.onConfirm = function() {
                                    window.location.href = "orderlist.jsp?wuid=" + 5268 + "&shopId=" + shopId + "&cbdId=" + cbdId;
                                };
                                dialog.onCancel = function() {
                                    window.location.href = "orderlist.jsp?wuid=" + 5268 + "&shopId=" + shopId + "&cbdId=" + cbdId;
                                };
                            } else {
                                Naroto.Dialog.alert("尚未完成支付");
                            }
                        }); 
                    }
                }
            });
        };
        
        var cancel = function() {
        	// 微信支付
            $.ajax({
                url: "/mobile/lightmall/order",
                data: {
                	orderid: orderId,
                    status: 5,
                    wuid: wuid,
                    action: "updateUserStatus"
                },
                dataType: "json",
                success: function(data) {
                	if (data.ret == 0) {
                		alert("您已成功取消订单");
                	} else if (data.ret == -1008){
                		alert("取消订单失败");
                	}
                	window.location.reload();
                }
            });
        };
        
        var confirm = function() {
        	// 确认收货
            $.ajax({
                url: "/mobile/lightmall/order",
                data: {
                    orderid: orderId,
                    status: 4,
                    wuid: wuid,
                    action: "updateUserStatus"
                },
                dataType: "json",
                success: function(data) {
                    if (data.ret == 0) {
                        alert("您已确认订单");
                    } else if (data.ret == -1008){
                        alert("确认订单失败");
                    }
                    window.location.reload();
                }
            });
        };
        
        var getExpressMessage = function(express_num) {
        	// 确认收货
            $.ajax({
                url: "/mobile/lightmall/order",
                data: {
                	express_num: express_num,
                    wuid: wuid,
                    action: "getExpressMessage"
                },
                dataType: "json",
                success: function(data) {
                    if (data.ret == 0 && data.express_msg) {
                        $(".express_msg").html(data.express_msg);
                    }
                }
            });
        };
        
        $(document).ready(function(){
            $.ajax({
                url: "/mobile/lightmall/order",
                data: {
                    orderId: orderId,
                    action: "findById"
                },
                dataType: "json",
                success: function(data){
                    if (data && data.ret == 0) {
                        var order = data.parorder;
                        $(".orderId").html(order.id);
                        $(".total_price,.totalprice").html("&yen;" + order.total_price);
                        var pay_type_txt = ""
                        if (order.pay_type == 0) {
                            pay_type_txt = "支付宝";
                        } else if (order.pay_type == 4) {
                            pay_type_txt = "银联";
                        } else if (order.pay_type == 3) {
                            pay_type_txt = "货到付款";
                        } else if (order.pay_type == 2) {
                            pay_type_txt = "支付宝";
                        } else if (order.pay_type == 1) {
                        	pay_type_txt = "财付通";
                        }
                        $(".paytype").html(pay_type_txt);
                        
                        var goods_list_tpl = document.getElementById("goods_list_tpl").text;
                        var goodslist = JSON.parse(order.goodslist);
                        var goods_list_html = $.template(goods_list_tpl).render({goodslist:goodslist});
                        $(".goodslist").html(goods_list_html);
                        
                        var status_txt = "";
                        var nowContent = "";
                        if (order.status == 0) {
                            if (3 == order.pay_type) {
                                status_txt = "货到付款";
                            } else {
                                status_txt = "待支付";
                                nowContent = "您的订单已经通过审核";
                            }
                        } else if (order.status == 2) {
                            status_txt = "已付款/待发货";
                            nowContent = "我们正在为您准备发货";
                        } else if (order.status == 3) {
                            if (3 == order.pay_type) {
                                status_txt = "已发货";
                            } else {
                                status_txt = "已付款/已发货";
                            }
                            nowContent = "您的商品已发货";
                        } else if (order.status == 4) {
                            status_txt = "交易完成";
                        } else if (order.status == 5) {
                            status_txt = "已取消";
                            nowContent = "您的订单已作废";
                        } else if (order.status == 6) {
                        	status_txt = "已退货";
                        	nowContent = "你的订单已退货";
                        }
                        
                        $(".nowS").html(order.buy_time + " " + nowContent);
                        
                        if (order.status == 0) {
                        	if (order.pay_type == 0 || order.pay_type == 1 || order.pay_type == 4) {
                        		$(".order").show();
                        		// 支付宝 / 财付通
                                $(".order .pay").on("click", function(){
                                    window.location.href = "pay_dispatcher.jsp?tradeno=" + order.id;
                                });
                        	} else if (order.pay_type == 2) {
                        		$(".order").show();
                        		$(".order .pay").on("click", function(){
                        			wxPay();
                        		});
                        	} else if (order.pay_type == 3) {
                                $(".order .pay").hide();
                                $(".order").show();
                            }
                        } else if (order.status == 3) {
                        	$(".confirm").show();
                        }
                        $(".cancel").on("click", function(){
                        	var dialog = new Naroto.Dialog();
                            dialog.confirm('确认取消订单？', "确定", "返回");
                            dialog.onConfirm = function() {
                                cancel();
                            };
                            dialog.onCancel = function() {
                                
                            };
                        });
                        $(".confirm_btn").on("click", function(){
                        	var dialog = new Naroto.Dialog();
                            dialog.confirm('确认收货？', "确定", "返回");
                            dialog.onConfirm = function() {
                                confirm();
                            };
                            dialog.onCancel = function() {
                                
                            };
                        });
                        $(".status").html(status_txt);
                        if (order.delivery_price != 0) {
	                        $(".delivery_price").html("&yen;" + order.delivery_price);
                        } else {
                        	$(".delivery_price").html("商家承担运费");
                        }
                        $(".receiver_name").html(order.client_name);
                        if (order.address) {
                            $(".receiver_addr").html(order.address);
                            $(".receiver_addr_con").show();
                        }
                        if (order.delivery_time) {
                        	$(".get_goods_time").html(order.delivery_time);
                        	$(".get_goods_con").show();
                        }
                        if (order.point) {
                        	$(".orderInfo .point").html(order.point);
                        	$(".orderInfo .point_price").html(order.point_price);
                        	$(".orderInfo .point_con").show();
                        }
                        if (order.remark) {
                        	$(".remark").html(order.remark);
                        	$(".remark_con").show();
                        }
                        $(".receiver_tel").html(order.tel);
                        $(".total_count").html("共" + order.total_count + "件");
                        if (order.delivery_num || order.express_num) {
                            $(".delivery_con").show();
                            $(".delivery").html(order.delivery_num + "&nbsp;" + order.express_num);
                            if (order.express_num) {
                            	getExpressMessage(order.express_num);
                            }
                        }
                        
                        
                            $(".contact_tel_con").show();
                            $(".contact_tel").html('0755-86159062');
                                                
                    } else {
                        alert("服务器繁忙，请稍后重试");
                    }
                }
            });
            
        });
    </script>
</body>
</html>