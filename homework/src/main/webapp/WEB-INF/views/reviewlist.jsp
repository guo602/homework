 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8"> 
	
</head>

<body>





<div style="{ text-align:left;height:520px;}">
	<c:forEach items="${history}" var="eh" >

		
		 
    <div class="talklog" ><b style="font-size:28px; color:#0000CD;">${eh.word}</b>

 </div>
 
		
	</c:forEach>
</div>





</body>
</html>