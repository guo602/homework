<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function checkRecharge(){
	document.form1.all.value=1;
	form1.submit();
}
</script>
</head>
<body>
<div>
		<h2 align="center">管理员界面·打赏记录</h2>
	</div>
	<div style="width:100%; height:90px">
		<div style="width: 30%; height: 50px; float: left;">
			<form id="form1" name="form1" action="rewardresult">
				<input type="hidden" id="all" name="all" value="3" />
				<table cellpadding="10" width="30%">
					<tr>
						<td><input type="button" id="showrecharge" name="showrecharge"
							value="查询打赏记录" onclick="checkRecharge()"></td>
					</tr>
				</table>
				${result}
			</form>
		</div>
		<div style="width: 70%; height: 50px; float: left;">
			<table cellpadding="10" border="1" width="90%"
				background="img/beijing.jpg">
				<tr>
					<td>交易记录ID</td>
					<td>打赏账户ID</td>
					<td>打赏金额</td>
					<td>打赏时间</td>
					<td>打赏备注</td>
				</tr>
				<c:forEach items="${list}" var="s">
					<tr>
						<td><c:out value="${s.getTid()}" /></td>
						<td><c:out value="${s.getWid()}" /></td>
						<td><c:out value="${s.getVolumn()}" /></td>
						<td><c:out value="${s.getTradetime()}" /></td>
						<td><c:out value="${s.getMemo()}" /></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>