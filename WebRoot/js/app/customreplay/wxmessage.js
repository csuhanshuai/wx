﻿function toUpdateMessage(a,b,c){$("#question").val(b);$("#answer").val(c);$("#id").val(a)}function removeMessage(a){$("#okbtn").on("click",function(b){window.location.href="removeMessage.kq?id\x3d"+a});$("#deleteModal").modal({keyboard:!0})}
function saveMessage(){var a=$("#id").val(),b=$("#question").val(),c=$("#answer").val(),e=$("#type").val(),d;null!=a&&""!=a?(d="updateMessage.kq",a={id:a,question:b,answer:c,type:e}):(d="addMessage.kq",a={question:b,answer:c,type:e});ajaxRequest(d,a,function(a){a&&(a=a.replace(/(^\s*)|(\s*$)/g,""),"success"==a?($("#question").val(""),$("#answer").val(""),$("#id").val(""),$("#tips").css("display","block"),$("#tipcontent").text("\u4fdd\u5b58\u6210\u529f"),$("#myModal").modal({keyboard:!1}),$("#myModal").on("hidden.bs.modal",
function(a){window.location.reload()})):($("#tips").css("display","block"),$("#tips").text(a)))})}function submitForm(){var a=document.forms[0];a.target="content";a.submit();window.top.TB_remove()}function ajaxRequest(a,b,c){$.ajax({type:"POST",url:a,data:b,cache:!0,success:c})};