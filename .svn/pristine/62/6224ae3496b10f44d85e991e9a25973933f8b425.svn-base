<footer>
	<div class="loginbar">
		
				<!--
				<a href="${BasePath}/zjmall/tologin.kq?bid=${(mconf.bizid)?default('')}">登录</a>
				|-->
				<#if zjminweb_member??>
					<a href="${BasePath}/zj/zjminweb/getMember.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">${zjminweb_member.name?default('')}</a>
				<#else>
				<a href="${BasePath}/zj/zjminweb/getMember.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">注册</a>
				</#if>
		
		| <a href="javascript:scroll(0,0)">返回顶端</a>
	</div>
	<section class="nav">
		<a href="${mconf.url}?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">首页</a>
		<a href="${BasePath}/zjmall/mlist.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}&qtype=0&ptflag=1">分类</a>
		<a href="${BasePath}/zjmall/tocart.kq?bid=${(mconf.bizid)?default('')}&openid=${openid?default('')}">购物车</a>
	</section>
	<!--section class="version">
		<p>
			<a href="">关于我们</a>
			|
			<a href="">帮助</a>
			|
			<a href="">微信安全支付</a>
		</p>
	</section-->
	<p class="corg"><#if mconf.cstel??&&mconf.cstel!="">客服热线：${mconf.cstel}</#if ></p>
	<p>${mconf.footword?default('')}</p>
</footer>