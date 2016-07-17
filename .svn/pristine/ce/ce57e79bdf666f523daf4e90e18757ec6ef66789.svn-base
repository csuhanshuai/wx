
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="title" content="无线建站系统">
<meta name="description" content="">
<meta name="keywords" content="">
<title>奇新无线建站系统</title>

<#include "../../base.ftl">
<script src="${BasePath}/js/app/zjmall/producttype.js"></script>
</head>

<body style="min-height: 660px; cursor: auto;" class="edit">
<#include "../../navigator.ftl">
<div class="container-fluid">
  <div class="row-fluid">
	<#include "../../left.ftl">
    <!--/span-->
   <div class="container-fluid">
	<div class="row-fluid">
		
		<div class="span8">
			<fieldset>
					 <legend>商品分类</legend> 
			</fieldset>
			<form action="queryProductType.kq" name="queryForm" id="queryForm" method="post">
			</form>
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							分类名称
						</th>
						<th>
							添加时间
						</th>
						
						<th>
							编辑
						</th>
					</tr>
				</thead>
				<tbody>
				<#if pageFinder?? && (pageFinder.data)?? >
			  		<#list pageFinder.result as item>
			  		<tr>
			  			<td>
							${item_index+1}               
			            </td>
			            <td>
							${item.typename?default('')}               
			            </td>
			            <td>
							${item.addtime?default('')}      
						</td>
			           
			            <td class="td0">
			        		<a href="javascript:toUpdateProductType('${item.id}','${item.typename?default('')}');">编辑</a>
							<a href="javascript:removeProductType('${item.id}');" >删除</a>
			            </td>
			        </tr>
			  		</#list>	
			  	
			  	<#else>
			  		<tr><td colspan="4"><div class="yt-tb-list-no">暂无内容</div></td></tr>
				</#if>
				
					
					
				</tbody>
			</table>
			
					<div class="div-pl-bt">
			<!--
			<div class="div-pl-bt-deal">
				<input type="checkbox" name="" />
				<span>全选</span>
				<a href="#">批量删除</a>
			</div>
			-->
			<!-- 翻页标签 -->
			<#import "../app-common.ftl"  as page>
			<@page.queryForm formId="queryForm" />
			
		</div>
		</div>
		<div class="span4">
			<form role="form" action="addProductType.kq" method="post">
			    <input type="hidden" id="id"/>
				<fieldset>
					 <legend>新增或编辑商品分类</legend> 
					 <label>分类名称：</label><input id="typename" name="typename" type="text" /> <span class="help-block">这里填写帮助信息.</span>
					 
					<div id="tips" style="display:none" class="alert alert-success">成功</div><br>
					 <button type="button" class="btn" onclick="saveProductType();">保存</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>

 
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


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="12" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">信息提示</h4>
      </div>
      <div id="tipcontent" class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="12" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="deleteModalLabel">信息提示</h4>
      </div>
      <div id="deletetipcontent" class="modal-body">
        确定删除该信息么?
      </div>
      <div class="modal-footer">
        <button type="button" id="okbtn" class="btn btn-default" data-dismiss="modal">确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>