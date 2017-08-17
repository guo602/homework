<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>节目单管理界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/admin.css">



<script type="text/javascript">
	function check() {
		var is_submit = 1
		//读取输入
		var program_name = document.getElementById("program_name").value;
		var perfomer = document.getElementById("performer").value;
		var starttime = document.getElementById("starttime").value;
		var department = document.getElementById("department").value;

		//检查时间输入的格式,当天的19-22点均可，2018-11-11 21:21:21是可以的
		var patern3 = new RegExp(
				"(\\d{4}|\\d{2})-((0?([1-9]))|(1[1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))[ ]((1|0?)[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");

		//非空检查
		//检查节目名
		if (program_name == "") {
			document.getElementById("d1").innerText = "节目名不能为空";//输入为空时
			is_submit = 0
		} else {
			document.getElementById("d1").innerText = "";
		}

		//检查表演者
		if (perfomer == "") {
			document.getElementById("d2").innerText = "表演者不能为空";//输入为空时
			is_submit = 0
		} else {
			document.getElementById("d2").innerText = "";
		}

		//检查开始时间
		if (starttime == "") {
			document.getElementById("d3").innerText = "开始时间不能为空";
			is_submit = 0
		} else if (!patern3.exec(starttime)) {
			document.getElementById("d3").innerText = "开始时间格式不正确，正确格式形如：2018-11-11 21:21:21";
			is_submit = 0
		} else {
			document.getElementById("d3").innerText = "";
		}

		//检查报送单位
		if (department == "0") {
			document.getElementById("d4").innerText = "报送单位不能为空";
			is_submit = 0
		} else {
			document.getElementById("d4").innerText = "";
		}

		if (is_submit == 1) {
			form1.submit();
		}
		return false;
	}

	function checkfind() {
		var id = document.getElementById("program_id1").value
		var name = document.getElementById("program_name1").value
		var dept = document.getElementById("department1").value
		var is_submit = 1
		if (id == "" && name == "" && dept == "0") {
			document.getElementById("warn").innerText = "请输入至少一个查询信息";
			is_submit = 0
		}
		if (is_submit == 1) {
			form2.submit();
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
						<div >
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
					<li><a class="bar" href="luckyrain">红包雨</a></li>
					<li><a class="bar" href="reward">节目打赏</a></li>
					<li><a class="bar" href="luckyrecord">红包记录</a></li>
					<li><a class="bar" href="rewardrecord">打赏记录</a></li>
					<li><a class="bar" href="rechargerecord">充值记录</a></li>
					<li><a class="bar" href="user">返回年会</a></li>


				</ul>
				<div class="row clearfix">
					<div class="col-md-12 column">
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
								<a class="bigger" href="wallet">账户管理 </a>
							</div>
							<div class="panel-footer">
								<a class="bigger" href="">节目单管理</a>
							</div>
							<ul class="list-group">
								<li class="list-group-item"><a class="bigger"
									href="program_1">添加节目</a></li>
								<li class="list-group-item"><a class="bigger"
									href="program_2">查找节目</a></li>
								<li class="list-group-item"><a class="bigger" href="">删除节目</a></li>
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
									<div class="col-md-12 column" style="height:450px;overflow:scroll;">
										<table class="table table-hover table-striped" cellpadding="10">
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
											data-target="#insert">添加节目</button>
										<div>
											<c:if test="${sign1=='ok'}">
												<img src="img/right.png" width="70" height="50" />
											</c:if>

											<c:if test="${sign1=='no'}">
												<img src="img/cross.png" width="40" height="50" />
											</c:if>
										</div>
										<div style="color: blue">${result}</div>

										<!-- 模态框（Modal） -->
										<div class="modal fade " id="insert" tabindex="-1"
											role="dialog" aria-labelledby="newModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="newModalLabel">添加节目</h4>
													</div>
													<div class="modal-body">
														<form id="form1" name="form1" action="program_insert">
															<table>

																<tr>
																	<td>节目名称：</td>
																	<td><input type="text" id="program_name"
																		name="program_name"></td>
																	<td><div id="d1" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>表演者：</td>
																	<td><input type="text" id="performer"
																		name="performer"></td>
																	<td><div id="d2" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>开始时间：</td>
																	<td><input type="text" id="starttime"
																		name="starttime"></td>
																	<td><div id="d3" style="color: #FF0000"></div></td>
																</tr>

																<tr>
																	<td>报送单位：</td>
																	<td><select id="department" name="department">
																			<option value="1">技术部</option>
																			<option value="2">后勤部</option>
																			<option value="3">营销部</option>
																			<option value="0" selected="selected">无限制</option>
																	</select></td>
																	<td><div id="d4" style="color: #FF0000"></div></td>
																</tr>
															</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="check()">确认添加节目</button>
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
											data-target="#find">查找节目</button>
										<div>
											<c:if test="${sign=='ok'}">
												<img src="img/right.png" width="70" height="50" />
											</c:if>
											<c:if test="${sign=='no'}">
												<img src="img/cross.png" width="40" height="50" />
											</c:if>
										</div>
										<div style="color: blue">${result1}</div>
										<!-- 模态框（Modal） -->
										<div class="modal fade" id="find" tabindex="-1" role="dialog"
											aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="myModalLabel">查找节目</h4>
													</div>
													<div class="modal-body">
														<form id="form2" name="form2" action="program_search">
															<div id="warn" style="color: red"></div>
															<table>
																<tr>
																	<td>节目编号：</td>
																	<td><input type="text" id="program_id1"
																		name="program_id1"></td>
																</tr>
																<tr>
																	<td>节目名称：</td>
																	<td><input type="text" id="program_name1"
																		name="program_name1"></td>
																</tr>
																<tr>
																	<td>报送单位：</td>
																	<td><select id="department1" name="department1">
																			<option value="1">技术部</option>
																			<option value="2">后勤部</option>
																			<option value="3">营销部</option>
																			<option value="0" selected="selected">无限制</option>
																	</select></td>
																</tr>

															</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="checkfind()">确认查找节目</button>
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
									<div class="col-md-12 column"></div>
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
</body>

</html>