<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function lockwallet() {

	var is_submit = 1;
	var itcode = document.form2.itcode.value
	var name = document.form2.name.value
	if (itcode.trim().length == 0) {
		document.getElementById("lock1").innerHTML = "用户编号不能为空 ";
		is_submit = 0;
	} else {
		if (itcode.length > 10) {
			document.getElementById("lock1").innerHTML = "用户编号过长，请检查输入是否正确 ";
			is_submit = 0;
		} else {
			document.getElementById("lock1").innerHTML = "";
		}
	}
	if (name.trim().length == 0) {
		document.getElementById("lock2").innerHTML = "用户名不能为空 ";
		is_submit = 0;
	} else {
		if (name.length > 10) {
			document.getElementById("lock2").innerHTML = "用户名过长，请检查输入是否正确";
			is_submit = 0;
		} else {
			document.getElementById("lock2").innerHTML = "";
		}
	}
	if (is_submit == 1) {
		form2.submit();
	} else {
		return false;
	}
}


</script>
</head>
<body>
    	<form name="form2" id="form2" action="lockwallet">
		<h2>锁定用户账户</h2>
		<table>
			<tr>
				<td>请输入用户编号</td>
				<td><input name="itcode" id="itcode"></td>
				<td><div id="lock1" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>请输入用户名</td>
				<td><input name="name" id="name"></td>
				<td><div id="lock2" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td><input type="button" name="lock_ok" id="lock_ok"
					value="确认锁定账户" onclick="lockwallet()"></td>
				<td></td>
				<td><div style="color: blue">${result}</div></td>
			</tr>
		</table>
	</form>
</body>
</html>