<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1"
        />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="description" content="微俱聚 微信营销" />
        <link href="${BasePath}/css/app/zj/common.css" rel="stylesheet">
        <link href="${BasePath}/css/app/zj/site.css" rel="stylesheet">
        <link href="${BasePath}/css/app/zj/swipeslide.css" rel="stylesheet">
        <style>
            .bgcolor { background-color: rgb(255, 0, 255); } .fontcolor { color: rgb(255,
            0, 255); }
        </style>
        <script src="${BasePath}/js/app/zj/zepto.min.js" type="text/javascript">
        </script>
        <script src="${BasePath}/js/app/zj/swipeslide.js" type="text/javascript">
        </script>
        <title>
            微官网
        </title>
    </head>
    
    <body>
        <div id="page">            
            <div id="image" class="swipe" style="visibility: visible;">
                <div class="swipe-wrap" data-id="0">
                    <#list spList as it>
                        <div class="swipe-item">
                            <a href="${BasePath}/${it.url?default('')}?bid=${bid?default('')}&openid=${openid?default('')}">
                                <img align="absmiddle" src="${BasePath}/${it.picUrl?default('')}">
                            </a>
                            <div class="bottom">
                                <div class="title">
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
            <style>
                #mainmenu{ background: none; border: none; width: 95%; } #mainmenu li{
                height: 110px; list-style: none; margin-bottom: 5px; position: relative;
                } #mainmenu li:nth-child(even) .text-cont{ float: right; } #mainmenu li
                a{ display: block; width: 100%; height: 100%; } #mainmenu li .text-cont{
                width: 32%; float: left; height: 100%; overflow: hidden; } #mainmenu li
                .image-cont{ width: 68%; float: left; } #mainmenu li .image-cont img{ display:
                block; height: 110px; width: 100%; } #mainmenu li .title{ line-height:
                30px; font-size: 1em; color: #FFF; width: 95%; margin: 25px 5px 0px 5px;
                } #mainmenu li .summary{ line-height: 20px; font-size: 0.8em; color: #FFF;
                width: 95%; margin: 0 5px 0px 5px; } #mainmenu li.menu-1 .text-cont{ background-color:
                #218b81; } #mainmenu li.menu-2 .text-cont{ background-color: #8019c2; }
                #mainmenu li.menu-3 .text-cont{ background-color: #1f5a16; } #mainmenu
                li.menu-4 .text-cont{ background-color: #bc4040; }
            </style>
            <div id="mainmenu" class="fn-clear">
                <ul>
                    <#list ptList as pt>
                        <li class="menu-${pt_index%4 + 1}">
				<#if pt.url??&&(pt.url?index_of("?")>-1) >
					 <a href="${pt.url?default('')}&bid=${bid?default('')}&openid=${openid?default('')}&isshow=1&qtype=0">
				<#else>
					  <a href="${pt.url?default('')}?bid=${bid?default('')}&openid=${openid?default('')}&isshow=1&qtype=0">
				</#if>
				<div class="text-cont">
                                    <p class="title">
                                        ${pt.title?default('')}
                                    </p>
                                    <p class="summary">
                                        ${pt.description?default('')}
                                    </p>
                                </div>
                                <div class="image-cont">
                                    <img src="${BasePath}/${pt.picUrl?default('')}">
                                </div>
                            </a>
                        </li>
                    </#list>
                </ul>
            </div>
            <script type="text/javascript">
                $(function() {
                    var height = $("#mainmenu").width() * 0.68 * 0.581;
                    $("#mainmenu li").height(height);
                    $("#mainmenu li .image-cont img").height(height);
                });
            </script>
            <div id="footer">
                ${biList[0].footer?default('')}
            </div>
        </div>
        <p class="page-url">
            <a class="page-url-link" href="${BasePath}/${biList[0].dvlUrl?default('')}?bid=${bid?default('')}&openid=${openid?default('')}"
            target="_blank">
                ${biList[0].developer?default('')}
            </a>
        </p>
        <div id="toTop" style="position: fixed; display: none; bottom: 0px; left: 10px; z-index: 998; opacity: 0.8;">
            <a onclick="javascript:window.scrollTo(0,0);" href="javascript:void(0);">
                <img align="absmiddle" style="width: 46px; height: 46px;" src="${BasePath}/images/app/zj/topplus.png">
            </a>
        </div>
        <link rel="stylesheet" href="${BasePath}/css/app/zj/menu4.css" />
        <div class="plug-div-4-placeholder">
        </div>
        <div class="plug-div" style="-webkit-transform:translate3d(0,0,0)">
            <ul class="top_menu">
                <li style="width:70%;float:left;height:45px;">
                    <a href="${BasePath}/zj/zjminweb/minweb_index.kq?bid=${bid?default('')}&openid=${openid?default('')}">
                        <span>
                        </span>
                    </a>
                </li>
                <li style="width:30%;float:left;text-align:right;height:45px;">
                    <a href="http://api.map.baidu.com/marker?location=<#if membercard??>${membercard.latitude?default('22.545331')}</#if>,<#if membercard??>${membercard.longitude?default('113.952072')}</#if>&amp;title=<#if membercard??>${membercard.shopname?default("")}</#if>&amp;content=<#if membercard??>${membercard.shopname?default("")}</#if>&amp;output=html">
                        <span class="homemenu_text icon icon-160-28">
                            地址
                        </span>
                    </a>
                </li>
            </ul>
        </div>
        <script type="text/javascript">
            $(".plug-div a.more").click(function() {
                $(this).parent().find("ul").toggle();
            });
        </script>
    </body>
    <script type="text/javascript">
        $(function() {
            $('#image').swipeSlide({
                autoPlay: 3,
                delay: 0.4
            });
        });
    </script>
    <script type="text/javascript">
        document.addEventListener('WeixinJSBridgeReady',
        function onBridgeReady() {
            window.shareData = {
                "imgUrl": "${BasePath}/images/app/zj/79ed77fd-3c66-44c2-9bf3-bf3bd906a3fd.jpg",
                "shareLink": "${BasePath}/zj/zjminweb/minweb_index.kq?bid=${bid?default('')}&openid=${openid?default('')}",
                "title": "欢迎关注奇新时代!",
                "content": "欢迎关注奇新时代!"
            };

            // 发送给好友
            WeixinJSBridge.on('menu:share:appmessage',
            function(argv) {
                WeixinJSBridge.invoke('sendAppMessage', {
                    "img_url": window.shareData.imgUrl,
                    "img_width": "640",
                    "img_height": "640",
                    "link": window.shareData.shareLink,
                    "desc": window.shareData.content,
                    "title": window.shareData.title
                },
                function(res) {
                    //_report('send_msg', res.err_msg);
                })
            });

            // 分享到朋友圈
            WeixinJSBridge.on('menu:share:timeline',
            function(argv) {
                WeixinJSBridge.invoke('shareTimeline', {
                    "img_url": window.shareData.imgUrl,
                    "img_width": "640",
                    "img_height": "640",
                    "link": window.shareData.shareLink,
                    "desc": window.shareData.content,
                    "title": window.shareData.title
                },
                function(res) {
                    //_report('timeline', res.err_msg);
                });
            });

            // 分享到微博
            WeixinJSBridge.on('menu:share:weibo',
            function(argv) {
                WeixinJSBridge.invoke('shareWeibo', {
                    "content": window.shareData.content,
                    "url": window.shareData.shareLink,
                },
                function(res) {
                    //_report('weibo', res.err_msg);
                });
            });
        },
        false);
    </script>
    <style>
        body,#mainmenu{ background: rgb(255, 255, 255); }
    </style>

</html>