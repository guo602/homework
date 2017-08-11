<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(value) {
		 var temp="reward"+value;
		 document.getElementById(temp).disabled=true;
         document.form1.pid.value=value;
         form1.submit();
	}
</script>
</head>
<body>
	<div>
		<h2 align="center">管理员界面·开启打赏</h2>
	</div>
	<div style="width: 100%; height: 90px">
		<div style="width: 30%; height: 50px; float: left;"></div>
		<div style="width: 70%; height: 50px; float: left;">
			<form id="form1" name="form1" action="openbonus">
			     <input type="hidden" id="pid" name="pid" value="0" />
			     <p><input name="reward" id="reward" type="button"
								value="开启全部节目打赏功能" onclick="check(0)" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    ${result}
				</p>
				<table cellpadding="10" border="1" width="90%">
					<tr>
						<td>节目ID</td>
						<td>节目名称</td>
						<td>表演者</td>
						<td>开始时间</td>
						<td>开启打赏</td>
					</tr>
					<%
						int i = 0;

					%>
					<c:forEach items="${list}" var="s">
						<tr>
						    <%i++; %>
							<td><c:out value="${s.getPid()}" /></td>
							<td><c:out value="${s.getPro_name()}" /></td>
							<td><c:out value="${s.getPerformer()}" /></td>
							<td><c:out value="${s.getStart_time()}" /></td>
							<td><input name="reward<%out.print(i);%>" id="reward<%out.print(i);%>" type="button"
								value="开启节目打赏" onclick="check(<%out.print(i);%>)" /></td>
							
						</tr>

					</c:forEach>
					<tr></tr>

				</table>
			</form>
		</div>
	</div>
</body>
</html>