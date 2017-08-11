<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	 <meta name="viewport" content="width=device-width">
	<title>Home</title>
	  <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<table>
<div class="main" position:relative>
<br>
<h1  class="h1">
	Hello world!  
</h1>

<br>
<a href="admin" class="h" title="管理员界面">管理员界面</a> <br><br>
<a href="chatlogin"  class="h" title="全程冒泡">全程冒泡</a><br><br>
<a href="redlogin"  class="h" title="红包登录">红包登录</a><br><br>

<a href="http://10.10.15.56:8080/homework_chat/gchatreg.html"  class="h" title="聊天室入口">聊天室入口</a>

<br><br>
 
<P  class="h" >  The time on the server is ${serverTime}. </P>
<br>
</div>
</table>
</body>
</html>
