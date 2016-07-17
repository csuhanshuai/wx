<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<script type="text/javascript">
	var BasePath="${BasePath}"; 	
</script>

<link href='${BasePath}/css/global.css?t=2013122302' rel='stylesheet' type='text/css' />
<link href='${BasePath}/css/main.css?t=2013122302' rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${BasePath}/js/jquery-1.7.2.min.js"></script>

<title>调研</title>

<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=no,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<style>
.select {
	width: 100%;
}

.list_ul_card .forms dt {
	padding: 5px;
}
</style>
</head>
<body >
	<div class="container info_tx" style="border: 4px solid #FF6699;margin-left:18%;margin-right:18%">
	
		<div class="body pt_10" style="height:100%;width:100%;background-color: #FFCCFF">
			    <div style="width:100%;height:50px;text-align:center;background-color: #FFCCFF">
	                        <br>
						    <b>活动调研</b>
		        </div>
				<form id="form1" action="${BasePath}/zjdiaoyan/zjminweb/dydatisave.kq" method="post" >
				<ul class="list_ul_card" style="margin-left:10;margin-right:10">
					<#if titleInfo?? && (titleInfo?size>0) >
				      	<#list titleInfo as item>
				      	        <input type="hidden" id="${item.id}ok" value="${item.anwserMaxNum}"/>		
				      	        <br>
							    <span><b>${item.questionName}</b></span>
							    <br>
							    <br>
							    <input type="checkbox" name="${item.id}" id="${item.selectAid}" value="${item.selectAtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectA}
							    <br>
							    <br>
							    <input type="checkbox" name="${item.id}" id="${item.selectBid}" value="${item.selectBtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectB}
							    <br>
							    <br>
	
							    <#if item.selectC?? && (item.selectC?length > 0)>
					             <input type="checkbox" name="${item.id}" id="${item.selectCid}" value="${item.selectCtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectC}
					             <br>
							     <br>
				                </#if>
							    <#if item.selectD?? && (item.selectD?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectDid}" value="${item.selectDtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectD}
							    <br>
							    <br>
							    </#if>
							    <#if item.selectE?? && (item.selectE?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectEid}" value="${item.selectEtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectE}
							    <br>
							    <br>
							    </#if>
							    <#if item.selectF?? && (item.selectF?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectFid}" value="${item.selectFtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectF}
							    <br>
							    <br>
							    </#if>
							    <#if item.selectG?? && (item.selectG?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectGid}" value="${item.selectGtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectG}
							    <br>
							    <br>
							    </#if>
							    <#if item.selectH?? && (item.selectH?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectHid}" value="${item.selectHtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectH}
							    <br>
							    <br>
							    </#if>
							    <#if item.selectI?? && (item.selectI?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectIid}" value="${item.selectItimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectI}
							    <br>
							    <br>
							    </#if>
							    <#if item.selectJ?? && (item.selectJ?length > 0)>
							    <input type="checkbox" name="${item.id}" id="${item.selectJid}" value="${item.selectJtimes}" onclick="checkSelect(this.id,this.name,this.value)">${item.selectJ}
							    <br>
							    <br>
							    </#if>
							    <hr/>
							 
						  </#list> 
					 <#else>
			             <p> <font color="red">该调研还未设置题目！</font></p>
			        </#if>
			        </ul>
			        <#if titleInfo?? && (titleInfo?size>0) >
						 <input type="button" onclick="finishedDati()" value="提&nbsp;&nbsp;&nbsp;交" style="border-color:transparent;border-style:none;color:white;font-size:20;margin-left:10;margin-right:10;width:97%;height:40;background-color:#FF6699"/>	
					</#if>
				<input type="hidden" name="resultStr" value=""/>	
				</form>
		</div>
	</div>

</body>
<script>
var resultStr = "";
function checkSelect(id,name,value)
{
    var maxName = name + "ok";
    var maxNum = $("#" + maxName).val();
    var selectCount = $("input[type=checkbox][name='"+name+"']:checked").length;   
    var signleStr = "";
    //检查是否已超过最大数
    if(selectCount > maxNum)
    {
       $("#" + id).attr("checked",false);
       alert("已超过最大选择数");
       return;
    }
    else
    {
        if(parseInt(value) >= 0)
        {
            if($("#" + id).attr("checked") == "checked")
            {
                value = parseInt(value) + 1;
                resultStr += id + "=" + value + ";" ;
            }
            else
            {
                resultStr = resultStr.replace(id + "=" +value+ ";" , "");
                value = parseInt(value) - 1;
            }
            $("#"+id).val(value);
        }
    }
}

function finishedDati()
{
    if(resultStr == "")
    {
       alert("您还没完成调研");
       return;
    }
    document.forms[0].resultStr.value = resultStr;
    document.forms[0].submit();
}
</script>
</html>
