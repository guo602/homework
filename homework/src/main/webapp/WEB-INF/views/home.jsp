<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	  <link rel="stylesheet" type="text/css" href="css/gchatlg.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="admin" title="管理员界面">管理员界面</a> <br><br>
<a href="chatlogin" title="聊天室登录">聊天室登录</a><br><br>
<a href="http://localhost:8080/homework_chat/gchatreg.html" title="另一个项目的聊天室入口">另一个项目的聊天室入口</a>

<br><br>
 <div class="cellphone">
      <label>随便说点什么吧</label>
      <input name="nc"  placeholder="ICU">
      <span class="help1">但要注意敏感词汇</span>
    </div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
