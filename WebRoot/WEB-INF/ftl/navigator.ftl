<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container-fluid">
      <button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="brand" href="#"><!--img src="${BasePath}/images/logo.jpg"-->微信平台定制化管理系统<span class="label">BETA</span></a>
      <div class="nav-collapse collapse">
      	<ul class="nav" id="menu-layoutit">
          <li class="divider-vertical"></li>
          <li>
          <!--
            <div class="btn-group" data-toggle="buttons-radio">
              <button type="button" id="edit" class="btn btn-primary active"><i class="icon-edit icon-white"></i>编辑</button>
              <button type="button" class="btn btn-primary" id="devpreview"><i class="icon-eye-close icon-white"></i>布局编辑</button>
              <button type="button" class="btn btn-primary" id="sourcepreview"><i class="icon-eye-open icon-white"></i>预览</button>
            </div>
            <div class="btn-group">
              <button type="button" class="btn btn-primary" data-target="#downloadModal" rel="/build/downloadModal" role="button" data-toggle="modal"><i class="icon-chevron-down icon-white"></i>下载</button>
              <button class="btn btn-primary" href="/share/index" role="button" data-toggle="modal" data-target="#shareModal"><i class="icon-share icon-white"></i>保存</button>
              <button class="btn btn-primary" href="#clear" id="clear"><i class="icon-trash icon-white"></i>清空</button>
            </div>
            <div class="btn-group">
								<button class="btn btn-primary" href="#undo" id="undo" ><i class="icon-arrow-left icon-white"></i>撤销</button>
								<button class="btn btn-primary" href="#redo" id="redo" ><i class="icon-arrow-right icon-white"></i>重做</button>
			</div>
			-->
          </li>
        </ul>
        <ul class="nav pull-right">
         <li><a href="/">欢迎您!&nbsp;<#if systemUser??>${systemUser.username?default('')}</#if></a></li>
          <li><a href="${BasePath}/toIndex.kq">网站首页</a></li>
           <li><a href="${BasePath}/logout.kq">退出</a></li>
               	  <li>
               	  <div class="btn-group">
               	  <!--
               	  <span><iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=dodgepudding&repo=layoutit&type=watch&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="80px" height="20px"></iframe></span>
			      <span><iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=dodgepudding&repo=layoutit&type=fork&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="80px" height="20px"></iframe></span>
			      -->
			      </div>
			      </li>
          </ul>
      </div>
      <!--/.nav-collapse --> 
    </div>
  </div>
</div>