<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width">
<title>Home</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript">
	function admin_login() {
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
		} else {
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


	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<img alt="140x140" src="img/logo.png" class="img-rounded"
							width="250" height="70" />
					</div>
					<div class="col-md-5 column"></div>
					<div class="col-md-3 column">
						<!-- 						<a class="bar" href="traderecord"><button type="button"
								class="btn btn-default">链接</button></a>
 -->
						<div class="row clearfix">
							<div class="col-md-12 column">
								<br>
								<button class="btn btn-primary" data-toggle="modal"
									data-target="#newadmin" id="adminbut">管理员登录</button>
								<div style="color: blue">${result}</div>
								<!-- 模态框（Modal） -->
								<div class="modal fade " id="newadmin" tabindex="-1"
									role="dialog" aria-labelledby="newModalLabel"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content"  style="width:50%">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title" id="newModalLabel">管理员身份确认</h4>
											</div>
											<div class="modal-body">
												<!--											<form name="form1" id="form1" action="adminlogin">
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
															<td><input name="password" id="password"
																type="password"></td>
															<td><div id="newp" style="color: #FF0000"></div></td>
														</tr>
													</table>
												</form>
-->
												<form role="form" name="form1" id="form1"
													action="adminlogin">
													<div class="form-group">
														<label for="itcode">管理员工号</label><input
															class="form-control" name="itcode" id="itcode" />
														<div id="new1" style="color: #FF0000"></div>
													</div>
													<div class="form-group">
														<label for="name">管理员姓名</label><input class="form-control"
															name="name" id="name" />
														<div id="new2" style="color: #FF0000"></div>
													</div>
													<div class="form-group">
														<label for="password">密码</label><input type="password"
															class="form-control" name="password" id="password" />
														<div id="newp" style="color: #FF0000"></div>
													</div>
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
							<img alt="" src="img/ppt3.gif" class="img-rounded" />
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
							<img alt="" src="img/ppt1.png" class="img-rounded" style="" />
							<div class="carousel-caption">
								<h4>Third</h4>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-438683"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="right carousel-control" href="#carousel-438683"
					data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<hr />
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column">WCY</div>
				<div class="col-md-1 column">WYZ</div>
				<div class="col-md-1 column">GY</div>
				<div class="col-md-1 column">ZYQ</div>
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column"></div>
				<div class="col-md-1 column"></div>
			</div>
		</div>
	</div>







	<!-- 
	<a href="initial">初始化数据库</a>
 -->
</body>
</html>
