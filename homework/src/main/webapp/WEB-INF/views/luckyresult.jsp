<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
    function first(){
    	document.form1.round.value="1";
    	form1.submit();
    }
    function second(){
    	document.form1.round.value="2";
    	form1.submit();
    }
    function third(){
    	document.form1.round.value="3";
    	form1.submit();
    }

</script>
</head>
<body>
	<div>
		<form id="form1" name="form1" action="luckyresult">
		    <input type="hidden" id="round" name="round" /> 
			<table>
				<tr>
					<td><input type="button" id="first" name="first"
						value="first lucky rain" onclick="first()"/></td>
				</tr>
				<tr>
					<td><input type="button" id="second" name="second"
						value="second lucky rain" onclick="second()"/></td>
				</tr>
				<tr>
					<td><input type="button" id="third" name="third"
						value="third lucky rain" onclick="third()"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<table>
			<c:forEach items="${list}" var="s">
				<tr>
					<td><c:out value="${s.tid}" /></td>
					<td><c:out value="${s.itcode}" /></td>
					<td><c:out value="${s.username}" /></td>
					<td><c:out value="${s.volumn}" /></td>
					<td><c:out value="${s.tradetime}" /></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>