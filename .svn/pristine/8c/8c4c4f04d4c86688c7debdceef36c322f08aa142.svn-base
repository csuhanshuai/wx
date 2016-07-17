
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="title" content="无线营销后台管理系统">
<meta name="description" content="">
<meta name="keywords" content="">
<title>无线营销后台管理</title>

<#include "base.ftl">
<style>
.demo1 {
margin-left: 0px;
margin-top: 10px;
padding: 0px 0px 0px;
border: 1px solid #DDDDDD;
border-radius: 4px;
position: relative;
word-wrap: break-word;
}
</style>
</head>

<body style="min-height: 660px; cursor: auto;" class="edit">
<#include "navigator.ftl">
<div class="container-fluid">
  <div class="row-fluid">
  <div class="">
  <div class="sidebar-nav">
    
  
  
  <#list login_system_user_resources as item>
      <#if item.isleaf=='0'&&item.id??&&item.id!="">
      <ul class="nav nav-list accordion-group">
          <li class="nav-header">
          <div class="pull-right popover-info"><i class="icon-question-sign "></i>
          <div class="popover fade right">
            <div class="arrow"></div>
            <h3 class="popover-title">功能</h3>
            <div class="popover-content">在这里设置您的微信公众账号功能, 如果您需要了解更多信息，请访问<a target="_blank" href="javascript:void();">帮助中心.</a></div>
          </div>
        </div>
          <i class="icon-plus icon-white"></i>${item.menuName}
          </li>
          <li style="display: none;" class="rows" id="estRows">
               <ul>
                  <#list login_system_user_resources as child>
                  <#if child.id??&&child.id!="">
        
                  <#if child.structure?substring(0,child.structure?last_index_of('-'))==item.structure>
                  <li><a href="${BasePath}${child.memuUrl}"  target="content">${child.menuName}</a></li>
                  </#if>   
                  </#if>
                  </#list>
              </ul>
          </li>
      </ul>   
      </#if>
  </#list>
  
   
    
  </div>
</div>
    <!--/span-->
    <iframe id="content" name="content" class="demo1 ui-sortable" style="min-height: 880px;min-width:1024px;"></iframe>

 
    <!--/span-->
    
  </div>
  <!--/row--> 
</div>
<!--/.fluid-container--> 
<div class="modal hide fade" role="dialog" id="editorModal">
  <div class="modal-header"> <a class="close" data-dismiss="modal">×</a>
    <h3>编辑</h3>
  </div>
  <div class="modal-body">
    <p>
      <textarea id="contenteditor"></textarea>
    </p>
  </div>
  <div class="modal-footer"> <a id="savecontent" class="btn btn-primary" data-dismiss="modal">保存</a> <a class="btn" data-dismiss="modal">关闭</a> </div>
</div>
<div class="modal hide fade" role="dialog" id="downloadModal">
  <div class="modal-header"> <a class="close" data-dismiss="modal">×</a>
    <h3>下载</h3>
  </div>
  <div class="modal-body">
    <p>已在下面生成干净的HTML, 可以复制粘贴代码到你的项目.</p>
    <div class="btn-group">
      <button type="button" id="fluidPage" class="active btn btn-info"><i class="icon-fullscreen icon-white"></i> 自适应宽度</button>
      <button type="button" class="btn btn-info" id="fixedPage"><i class="icon-screenshot icon-white"></i> 固定宽度</button>
    </div>
    <br>
    <br>
    <p>
      <textarea></textarea>
    </p>
  </div>
  <div class="modal-footer"> <a class="btn" data-dismiss="modal">关闭</a> </div>
</div>
<div class="modal hide fade" role="dialog" id="shareModal">
  <div class="modal-header"> <a class="close" data-dismiss="modal">×</a>
    <h3>保存</h3>
  </div>
  <div class="modal-body">保存成功</div>
  <div class="modal-footer"> <a class="btn" data-dismiss="modal">Close</a> </div>
</div>

</body>
</html>