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

table {
	text-align: center;
}
-->
</style>
<script>
	function check() {
		form1.submit()
	}
</script>
</head>
<body>
	<div>
		<h2 align="center">管理员界面·红包记录</h2>
	</div>
	<div style="width: 100%; height: 90px">
		<div style="width: 30%; height: 50px; float: left;">
			<form id="form1" name="form1" action="luckyresult">
				<table>
					<tr>
						<td>请输入用户编号</td>
						<td><input name="itcode" id="itcode" style="width: 150px"></td>
						<td><div id="textit" style="color: #FF0000"></div></td>
					</tr>
					<tr>
						<td>请选择红包雨</td>
						<td><input type="radio" name="round" id="round" value="1">第一轮红包雨</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="round" id="round" value="2">第二轮红包雨</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="round" id="round" value="3">第三轮红包雨</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="round" id="round" value="4">第四轮红包雨</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="round" id="round" value="5">第五轮红包雨</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="round" id="round" value="0"
							checked="checked">显示所有记录</td>
					</tr>
					<tr>
						<td>请选择查询数量</td>
						<td><select id="number" name="number" style="width: 155px">
								<option value="10">10</option>
								<option value="30">30</option>
								<option value="50">50</option>
								<option value="100">100</option>
								<option value="0" selected="selected">无限制</option>

						</select></td>

					</tr>
					<tr>
						<td><input type="button" name="ok" id="ok" value="确认搜索"
							onclick="check()"></td>
						<td><div style="color: blue">${result}</div></td>

					</tr>
				</table>
			</form>
		</div>
		<div style="width: 70%; height: 50px; float: left;">
			<table cellpadding="10" border="1" width="90%"
				background="img/beijing.jpg">
				<tr>
					<td>红包ID</td>
					<td>账户ID</td>
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

