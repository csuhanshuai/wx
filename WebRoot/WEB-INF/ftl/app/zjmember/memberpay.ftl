<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
		      <form action="">
			       <table>
			           <tr>
			               <td width="20%"><input type="radio" name="byType" value="0" checked="checked" onclick="changeDefaultValue(this.value)"/>会员卡号</td>
			               <td width="80%"><input type="radio" name="byType" value="1" onclick="changeDefaultValue(this.value)"/>手机号</td>
			           </tr>
			           <tr>
			               <td colspan="2">&nbsp;</td>
			           </tr>
			           <tr>
			               <td width="20%"><input type="text" value="请输入会员卡号" id="number" name="number" size="30"/></td>
			               <td><input type="button" value="查询" onclick="searchMemberInfo()"/></td>
			           </tr>
			       </table>
			       <br>
			       <div style="display: none" id="memberInfo">
			            <table width="100%">
			                 <tr>
			                      <td>会员卡号：00001</td>
			                      <td>微信号：wxzhangsan</td>
			                  </tr>
			                  <tr>
			                      <td>姓名：张三</td>
			                      <td>手机号：13012345678</td>
			                  </tr>
			                  <tr>    
			                      <td>可用金额：300000</td>
			                      <td>积分：300000</td>
			                   </tr>  
			                   <tr align="right"> 
			                      <td colspan="2"><a href="queryPayRecord()">消费记录查看</a></td>
			                  </tr>
			            </table>
			       </div>   
			    </form>
  </body>
  <script type="text/javascript">
      //改变默认值
       function changeDefaultValue(value)
       {
           if(value == "0")
           {
               document.getElementById("number").value = "请输入会员卡号";
           }
           else
           {
               document.getElementById("number").value = "请输入手机号";
           }
       }
       //查询会员信息
       function searchMemberInfo()
       {
          if(validate)
          {
               document.getElementById("memberInfo").style.display = "";
          }
       }
       
       //查询消费记录
       function queryPayRecord()
       {
           if(validate)
           {
              openwin("${BasePath}/app/zjmember/payinfolist.html",500,500);
           }
       }
       
       //验证是否有输入卡号或手机号
       function validate()
       {
           if(document.getElementById("number").value == "" || document.getElementById("number").value == null)
           {
               alert("请输入会员卡号或手机号！");
               return false;
           }
           return true;
       }
       
       //打开消费信息页面
       function queryPayRecord()
       {
           openwin("${BasePath}/app/zjmember/payinfolist.kq",500,500);
       }
       
    /**
	    打开新窗口,隐藏工具栏
	**/
	function openwin(url,height,width) 
	{
	    window.open (url, "_blank", "height=" + height + ", width=" + width + ",top=120,left=160, toolbar=no, menubar=no,  scrollbars=yes, resizable=no, location=no, status=no")
	}
	
	/**
		弹出模态窗口
	**/
	function showModelWin(url,params,height,width,left,top)
	{
		var va= window.showModalDialog(url,params,"dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px");
		return va;
	}
       
  </script>
</html>
