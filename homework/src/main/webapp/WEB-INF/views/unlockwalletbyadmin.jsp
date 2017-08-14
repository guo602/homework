<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function unlockwallet() {

	var is_submit = 1;
	var itcode = document.form3.itcode.value
	var name = document.form3.name.value
	if (itcode.trim().length == 0) {
		document.getElementById("unlock1").innerHTML = "用户编号不能为空 ";
		is_submit = 0;
	} else {
		if (itcode.length > 10) {
			document.getElementById("unlock1").innerHTML = "用户编号过长，请检查输入是否正确 ";
			is_submit = 0;
		} else {
			document.getElementById("unlock1").innerHTML = "";
		}
	}
	if (name.trim().length == 0) {
		document.getElementById("unlock2").innerHTML = "用户名不能为空 ";
		is_submit = 0;
	} else {
		if (name.length > 10) {
			document.getElementById("unlock2").innerHTML = "用户名过长，请检查输入是否正确";
			is_submit = 0;
		} else {
			document.getElementById("unlock2").innerHTML = "";
		}
	}
	if (is_submit == 1) {
		form3.submit();
	} else {
		return false;
	}
}
</script>
</head>
<body>
<form name="form3" id="form3" action="unlockwallet">
	 
		<h2>解锁用户账户</h2>
		<table>
			<tr>
				<td>请输入用户编号</td>
				<td><input name="itcode" id="itcode"></td>
				<td><div id="unlock1" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>请输入用户名</td>
				<td><input name="name" id="name"></td>
				<td><div id="unlock2" style="color: #FF0000"></div></td>

			</tr>
			<tr>
				<td><input type="button" name="unlock_ok" id="unlock_ok"
					value="确认解锁账户" onclick="unlockwallet()"></td>
				<td></td>
				<td><div style="color: blue">${result}</div></td>
			</tr>
		</table>
	</form>
</body>
</html>