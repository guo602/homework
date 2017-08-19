<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width">
<title>Home</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript">
function newadmin() {
	var is_submit = 1;
	var itcode = document.form1.itcode.value
	var name = document.form1.name.value
	var pass = document.form1.password.value
	if (itcode.trim().length == 0) {
		document.getElementById("new1").innerHTML = "用户编号不能为空 ";
		is_submit = 0;
	} else {
		if (itcode.length > 10) {
			document.getElementById("new1").innerHTML = "用户编号过长，请检查输入是否正确 ";
			is_submit = 0;
		} else {
			document.getElementById("new1").innerHTML = "";
		}
	}
	if (name.trim().length == 0) {
		document.getElementById("new2").innerHTML = "用户名不能为空 ";
		is_submit = 0;
	} else {
		if (name.length > 10) {
			document.getElementById("new2").innerHTML = "用户名过长，请检查输入是否正确";
			is_submit = 0;
		} else {
			document.getElementById("new2").innerHTML = "";
		}
	}
	if (pass.trim().length == 0) {
		document.getElementById("newp").innerHTML = "密码不能为空 ";
		is_submit = 0;
	}else{
			document.getElementById("newp").innerHTML = "";

	}
	if (is_submit == 1) {
		form1.submit();
	} else {
		return false;
	}
}
</script>
</head>
<body>
	<table>
		<div class="main" position:relative>
			<br>
			<h1 class="h1">Hello world!</h1>

			<br> <a href="admin" class="h" title="管理员界面">管理员界面</a> <br>
			<br> <a href="chatlogin" class="h" title="全程冒泡">全程冒泡</a><br>
			<br> <a href="redlogin" class="h" title="红包登录">红包登录</a><br>
			<br> <a
				href="http://10.10.15.56:8080/homework_chat/gchatreg.html" class="h"
				title="聊天室入口">聊天室入口</a> <br> <br>

			<P class="h">The time on the server is ${serverTime}.</P>
			<br>
		</div>
	</table>


	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-5 column"></div>
					<div class="col-md-3 column">
						<a class="bar" href="traderecord"><button type="button" class="btn btn-default">链接</button></a>
						
						<div class="row clearfix">
							<div class="col-md-12 column">
								<button class="btn btn-primary" data-toggle="modal"
									data-target="#newadmin" id="adminbut">管理员登录</button>
								<div style="color: blue">${result}</div>
								<!-- 模态框（Modal） -->
								<div class="modal fade " id="newadmin" tabindex="-1"
									role="dialog" aria-labelledby="newModalLabel"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title" id="newModalLabel">管理员身份确认</h4>
											</div>
											<div class="modal-body">
												<form name="form1" id="form1" action="admin_login">
													<table>
														<tr>
															<td>管理员工号</td>
															<td><input name="itcode" id="itcode"></td>
															<td><div id="new1" style="color: #FF0000"></div></td>
														</tr>
														<tr>
															<td>管理员姓名</td>
															<td><input name="name" id="name"></td>
															<td><div id="new2" style="color: #FF0000"></div></td>
														</tr>
														<tr>
															<td>密码</td>
															<td><input name="password" id="password" type="password"></td>
															<td><div id="newp" style="color: #FF0000"></div></td>
														</tr>
													</table>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
												<button type="button" class="btn btn-primary"
													onclick="admin_login()">登录</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="carousel slide" id="carousel-438683">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-438683"></li>
						<li data-slide-to="1" data-target="#carousel-438683"></li>
						<li data-slide-to="2" data-target="#carousel-438683"
							class="active"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="img/ppt1.png" class="img-rounded" />
							<div class="carousel-caption">
								<h4>First</h4>
								<p></p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/ppt2.jpg" class="img-rounded" />
							<div class="carousel-caption">
								<h4>Second</h4>
								<p></p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/ppt3.gif" class="img-rounded" style="" />
							<div class="carousel-caption">
								<h4>Third</h4>
								<p></p>
							</div>
						</div>
					</div>
					<div class="item active">
						<img alt="" src="v3/default2.jpg" />
						<div class="carousel-caption"></div>
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-438683"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="right carousel-control" href="#carousel-438683"
					data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
	</div>






</body>
</html>
