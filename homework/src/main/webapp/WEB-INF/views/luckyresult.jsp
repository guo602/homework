<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<!--
body {
	line-height: 200%
}

a:link {
	text-decoration: none;
	color: blue
}

a:active {
	text-decoration: blink
}

a:hover {
	text-decoration: none;
	color: red
}

a:visited {
	text-decoration: none;
	color: blue;
}
table{
    text-align:center;
}
-->
</style>
<script>
	function firstone() {
		document.form1.round.value = "1";
		form1.submit();
	}
	function secondone() {
		document.form1.round.value = "2";
		form1.submit();
	}
	function thirdone() {
		document.form1.round.value = "3";
		form1.submit();
	}
	function allone() {
		document.form1.round.value = "0";
		form1.submit();
	}
</script>
</head>
<body>
	<div>
		<h2 align="center">管理员界面·红包记录</h2>
	</div>
	<div style="width:100%; height:90px">
		<div style="width: 30%; height: 50px; float: left;">
			<form id="form1" name="form1" action="luckyresult">
				<input type="hidden" id="round" name="round" value="0" />
				<table cellpadding="10" width="30%">
					<tr>
						<td><input type="button" id="first" name="first"
							value="first lucky rain" onclick="firstone()"></td>
					</tr>
					<tr>
						<td><input type="button" id="second" name="second"
							value="second lucky rain" onclick="secondone()"></td>
					</tr>
					<tr>
						<td><input type="button" id="third" name="third"
							value="third lucky rain" onclick="thirdone()"></td>
					</tr>
					<tr>
						<td><input type="button" id="all" name="all"
							value="all lucky rain" onclick="allone()"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="width: 70%; height: 50px; float: left;">
			<table cellpadding="10" border="1" width="90%"
				background="img/beijing.jpg">
				<tr>
					<td>红包记录ID</td>
					<td>用户账户ID</td>
					<td>红包金额</td>
					<td>红包轮次</td>
				</tr>
				<c:forEach items="${list}" var="s">
					<tr>
						<td><c:out value="${s.getRid()}" /></td>
						<td><c:out value="${s.getWid()}" /></td>
						<td><c:out value="${s.getLucky_money()}" /></td>
						<td><c:out value="第${s.getRound()}轮红包雨" /></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

