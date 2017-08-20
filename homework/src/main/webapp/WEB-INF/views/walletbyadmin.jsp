<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户管理界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script type="text/javascript">
	function newwallet() {
		var is_submit = 1;
		var itcode = document.form1.itcode.value
		var name = document.form1.name.value
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
		if (is_submit == 1) {
			form1.submit();
		} else {
			return false;
		}
	}
	function lockwallet() {

		var is_submit = 1;
		var itcode = document.form2.itcode1.value
		var name = document.form2.name1.value
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
	function unlockwallet() {

		var is_submit = 1;
		var itcode = document.form3.itcode2.value
		var name = document.form3.name2.value
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
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<img alt="140x140" src="img/sss.img" class="smaimg img-rounded " />
					</div>
					<div class="col-md-6 column">
						<div>
							<h3>
								Example page header <small>Subtext for header</small>
							</h3>
						</div>
					</div>
					<div class="col-md-2 column"></div>
				</div>
				<ul class="nav nav-pills nav-justified bar">
					<li class="active"><a id="home" class="bar" href="#">Home</a></li>
					<li class="dropdown"><a class=" bar dropdown-toggle"
						data-toggle="dropdown" href="program">节目单 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a class="bar" href="program_1">插入节目单</a></li>
							<li><a class="bar" href="program_2">查找节目单</a></li>
							<li><a class="bar" href="program_3">修改节目单</a></li>
						</ul></li>
					<li class="dropdown"><a class="bar" class="dropdown-toggle"
						data-toggle="dropdown" href="wallet">账户<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="newbyadmin">激活账户</a></li>
							<li><a href="lockbyadmin">锁定账户</a></li>
							<li><a href="unlockbyadmin">解锁账户</a></li>
						</ul></li>
					<li class="dropdown"><a class=" bar dropdown-toggle"
						data-toggle="dropdown" href="addadmin">用户 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a class="bar" href="newadminby">添加管理员</a></li>
							<li><a class="bar" href="adduser">添加用户</a></li>
							<li><a class="bar" href="deleteby">删除用户</a></li>
						</ul></li>
					<li><a class="bar" href="comment">评论区</a></li>
					<li><a class="bar" href="luckyrain">红包发放</a></li>
					<li><a class="bar" href="reward">节目打赏</a></li>
					<li><a class="bar" href="luckyrecord">红包记录</a></li>
					<li><a class="bar" href="rewardrecord">打赏记录</a></li>
					<li><a class="bar" href="rechargerecord">充值记录</a></li>
					<li><a class="bar" href="user">返回年会</a></li>


				</ul>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<p></p>
						<p></p>
						<hr />
					</div>
				</div>

				<div class="row clearfix">
					<div class="col-md-3 column">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<img src="img/fenge.png" width="150px" />
							</div>
						</div>
						<div class="panel panel-info">
							<div class="panel-footer">
								<h3>准备活动</h3>
							</div>
							<div class="panel-heading">
								<a class="bigger" href="program">节目单 </a>
							</div>
							<div class="panel-footer">
								<a class="bigger" href="">账户管理 </a>
							</div>
							<ul class="list-group">
								<li class="list-group-item"><a class="bigger"
									href="newbyadmin">激活账户</a></li>
								<li class="list-group-item"><a class="bigger"
									href="lockbyadmin">锁定账户</a></li>
								<li class="list-group-item"><a class="bigger"
									href="unlockbyadmin">解锁账户</a></li>
							</ul>
							<div class="panel-heading">
								<a class="bigger" href="addadmin">用户管理 </a>
							</div>
						</div>

					</div>
					<div class="col-md-9 column">
						<div class="row clearfix">
							<div class="col-md-10 column">
								<div class="row clearfix">
									<div class="col-md-12 column">
										<!--  <table class="table table-hover table-striped">
											<thead>
												<tr>
													<th>节目编号</th>
													<th>节目名称</th>
													<th>表演者</th>
													<th>开始时间</th>
													<th>报送单位</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="s">
													<tr class="error">
														<td><c:out value="${s.getPid()}" /></td>
														<td><c:out value="${s.getPro_name()}" /></td>
														<td><c:out value="${s.getPerformer()}" /></td>
														<td><c:out value="${s.getStart_time()}" /></td>
														<td><c:out value="${s.getDept_id()}" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										-->
									</div>
								</div>
							</div>
							<div class="col-md-2 column">
								<div class="row clearfix">
									<div class="col-md-12 column">
										<img src="img/fenge.png" width="100px" />
									</div>
								</div>
								<div class="row clearfix">

									<div class="col-md-12 column">
										<button class="btn btn-primary btn-lg" data-toggle="modal"
											data-target="#newwallet">激活账户</button>
										<div style="color: blue">${result}</div>
										<!-- 模态框（Modal） -->
										<div class="modal fade" id="newwallet" tabindex="-1"
											role="dialog" aria-labelledby="newModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="newModalLabel">激活用户账户</h4>
													</div>
													<div class="modal-body">
														<form name="form1" id="form1" action="newwallet">
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
																	<td><div id="new2" style="color: #FF0000"></div></td>
																</tr>
																<!-- <tr>
																	<td><input type="button" name="new_ok" id="new_ok"
																		value="确认激活账户" onclick="newwallet()"></td>
																	<td></td>
																	<td><div style="color: blue">${result}</div></td>
																</tr>
																 -->

															</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="newwallet()">确认激活账户</button>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
										<!-- /.modal -->
									</div>
								</div>


								<div class="row clearfix">
									<div class="col-md-12 column">
										<img src="img/fenge.png" width="100px" />
									</div>
								</div>
								<div class="row clearfix">
									<div class="col-md-12 column">
										<button class="btn btn-primary btn-lg" data-toggle="modal"
											data-target="#lockwallet">锁定账户</button>
										<div style="color: blue">${result1}</div>
										<!-- 模态框（Modal） -->
										<div class="modal fade" id="lockwallet" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="myModalLabel">锁定用户账户</h4>
													</div>
													<div class="modal-body">
														<form name="form2" id="form2" action="lockwallet">
															<h2>锁定用户账户</h2>
															<table>
																<tr>
																	<td>请输入用户编号</td>
																	<td><input name="itcode1" id="itcode1"></td>
																	<td><div id="lock1" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>请输入用户名</td>
																	<td><input name="name1" id="name1"></td>
																	<td><div id="lock2" style="color: #FF0000"></div></td>
																</tr>

															</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="lockwallet()">确认锁定账户</button>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
										<!-- /.modal -->


									</div>

								</div>
								<div class="row clearfix">
									<div class="col-md-12 column">
										<img src="img/fenge.png" width="100px" />
									</div>
								</div>
								<div class="row clearfix">
									<div class="col-md-12 column">
										<button class="btn btn-primary btn-lg" data-toggle="modal"
											data-target="#unlockwallet">解锁账户</button>
										<div style="color: blue">${result2}</div>
										<!-- 模态框（Modal） -->
										<div class="modal fade" id="unlockwallet" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="myModalLabel">锁定用户账户</h4>
													</div>
													<div class="modal-body">
														<form name="form3" id="form3" action="unlockwallet">

															<h2>解锁用户账户</h2>
															<table>
																<tr>
																	<td>请输入用户编号</td>
																	<td><input name="itcode2" id="itcode2"></td>
																	<td><div id="unlock1" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>请输入用户名</td>
																	<td><input name="name2" id="name2"></td>
																	<td><div id="unlock2" style="color: #FF0000"></div></td>

																</tr>
															</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="unlockwallet()">确认解锁账户</button>
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
					<div class="row clearfix">
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
						<div class="col-md-1 column"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>