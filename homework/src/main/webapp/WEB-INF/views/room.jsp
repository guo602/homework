<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>room</title>
	  <link rel="stylesheet" type="text/css" href="css/room.css">
	  <style type="text/css">
    body{
         background-image: url(img/jammy.jpg);
           background-size:100% 100%;};
    </style>

    <script>
function showTalk()
{
  var str;
  str=document.getElementById("textareatucao").value;

  var xmlhttp;
  if (window.XMLHttpRequest)
  {
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp=new XMLHttpRequest();
  }
  else
  {
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
      document.getElementById("textareatucao").value="";
    }
  }
  xmlhttp.open("GET","URL?e="+str,true);
  xmlhttp.send();
}
</script>
</head>
    <body>
    <div class="big"><div class="zone">
        <div class="z1">
        评论弹幕
        </div>
        <div class="z2">
        <table>发评论<br>&nbsp;&nbsp;<textarea
        ID="textareatucao"  style="width:85% ; height:70%;">
                 </textarea>
                 &nbsp;<button ID="z2tc" onclick="showTalk()">吐槽</button>
           </table>      
        </div>
    </div>
    <div class="zone">
        <div class="z3">
        节目单
        </div>
        <div class="z4">
                         红包
        <div class ="redimg">
        <img src="img/maopaored.jpg"  alt="红包冒泡" width="80"  height="100" />
        <div>
        </div>
        
        
    </div>
  </div>
</body>
</html>
