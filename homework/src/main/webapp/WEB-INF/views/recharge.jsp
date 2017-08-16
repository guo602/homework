<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>土豪求做友</title>




</head>
<body>

<br>

<form name="formre"  action="recharge2" >
<strong>充值${amount}元软妹币，确定吗？</strong>
<input name="amount" type="hidden" value="${amount}">
<input type="submit" value="YES">
</form>



</body>
</html>
