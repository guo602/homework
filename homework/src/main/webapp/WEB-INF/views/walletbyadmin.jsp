<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form1" id="form1" action="walletbyadmin">
	    <h2>激活用户账户</h2>
		<table>
			<tr>
				<td>请输入用户编号</td>
				<td><input name="itcode" id="itcode"></td>
					<td><div id="new1" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>请输入用户名</td>
				<td><input name="name" id="name"></td>
					<td><div id="new1" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td><input type="submit" name="new_ok" id="new_ok" value="确认激活账户"></td>
			</tr>
			
		</table>
	</form>
	
	<form name="form2" id="form2" action="walletbyadmin">
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
				<td><input type="submit" name="lock_ok" id="lock_ok" value="确认锁定账户"></td>
			</tr>
		</table>
	</form>
	
	<form name="form2" id="form2" action="walletbyadmin">
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
				<td><input type="submit" name="unlock_ok" id="unlock_ok" value="确认解锁账户"></td>
			</tr>
		</table>
	</form>
</body>
</html>