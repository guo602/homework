<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	  <link rel="stylesheet" type="text/css" href="../css/gchatlg.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="admin" title="管理员界面">管理员界面</a> <br>
<a href="chatlogin" title="聊天室登录">聊天室登录</a>

 <div class="cellphone">
      <label>昵称</label>
      <input name="nc"  placeholder="请输入你的昵称">
      <span class="help1">注意敏感词汇</span>
    </div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
