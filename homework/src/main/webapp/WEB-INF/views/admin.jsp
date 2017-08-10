<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
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
</head>
<body >
	<div>
		<h1 align="center">管理员界面</h1>
	</div>
	<div>
	    <div style="width: 30%;"></div>
		<div id="admin" style="width: 30%; height: 50px; float: left;">
			<table  bgcolor="#F4F4F4" width="200px" align="center" >
				<tr>
					<td>准备工作</td>
				</tr>
				<tr>
					<td><a href="program" title="节目管理">节目单管理</a></td>
				</tr>
				<tr>
					<td><a href="wallet" title="账户激活">手动激活账户</a></td>
				</tr>
				<tr>
					<td>现场管理</td>
				</tr>
				<tr>
					<td><a href="comment" title="评论区管理">评论区管理</a></td>
				</tr>
				<tr>
					<td><a href="luckyrain" title="红包雨管理">红包雨管理</a></td>
				</tr>
				<tr>
					<td><a href="reward" title="打赏管理">打赏管理</a></td>
				</tr>
				<tr>
					<td>收尾工作</td>
				</tr>
				<tr>
					<td><a href="luckyrecord" title="红包记录">红包记录</a></td>
				</tr>
				<tr>
					<td><a href="rewardrecord" title="打赏记录">打赏记录</a></td>
				</tr>
				<tr>
					<td><a href="rechargerecord" title="充值记录">充值记录</a></td>
				</tr>
			</table>
		</div>
		<div style="width: 70%; height: 50px; float: left;bgcolor:#F4F4F4;"></div>
	</div>
</body>
</html>