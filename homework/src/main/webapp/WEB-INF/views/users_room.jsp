<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>帅郭们滴room</title>



</head>
<body>
  <div>
  	充值
            <input type="button" name="sub" id="sub" value="充值" onclick="window.open('recharge')" >
  

  </div>
  <div>
  	节目单
  	<br>

          <c:forEach items="${pro}" var="ep">
             
                <tr>
					<td>${ep.getPro_name()}</td>
					<td>${ep.getPerformer()}</td>
					<td>${ep.getDept()}</td>
					
					<td><input type="button" value="打赏"></td>
					
				</tr><br>

          </c:forEach>

  </div>

  <div>
  	 评论



  </div>

  <div>
  	吐槽

		<form name="form1" action="up_words" >
			
		
			<input type="text" name="words" id="words"  >  
			 
			 
			<input type="button" name="sub" id="sub" value="发送" onclick="submit()">
		</from>
	


  </div>







</body>
</html>
