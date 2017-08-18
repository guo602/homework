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
function openrain(){
	form1.submit();
}

function openlucky(){
	form2.submit();
}

function closelucky(){
	form3.submit();
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
					<li><a class="bar" href="traderecord">打赏记录</a></li>
					<li><a class="bar" href="traderecord">充值记录</a></li>
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
								<h3>现场管理</h3>
							</div>
							<div class="panel-heading">
								<a class="bigger" href="comment">评论区管理 </a>
							</div>
							<div class="panel-footer">
								<a class="bigger" href="">红包雨+抢红包</a>
							</div>
							<ul class="list-group">
								<li class="list-group-item"><a class="bigger"
									href="luckyrain">开启红包雨</a></li>
								<li class="list-group-item"><a class="bigger"
									href="luckyrain">开启抢红包</a></li>
								<li class="list-group-item"><a class="bigger"
									href="luckyrain">关闭抢红包</a></li>
							</ul>
							<div class="panel-heading">
								<a class="bigger" href="reward">开启节目打赏 </a>
							</div>
						</div>

					</div>
					<div class="col-md-9 column">
						<div class="row clearfix">
							<div class="col-md-10 column">
								<div class="row clearfix">
									<div class="col-md-12 column"></div>
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
											data-target="#newrain">开启红包雨</button>
										<div style="color: blue">${result}</div>
										<!-- 模态框（Modal） -->
										<div class="modal fade" id="newrain" tabindex="-1"
											role="dialog" aria-labelledby="newModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="newModalLabel">开启红包雨</h4>
													</div>
													<div class="modal-body">
														<form name="form1" id="form1" action="lucky_on">
															<table class="table table-hover table-striped">
																<tbody>
																	<tr>
																		<td><input type="radio" name="round" id="round"
																			value="1">开启第一轮红包雨</td>
																	</tr>
																	<tr>
																		<td><input type="radio" name="round" id="round"
																			value="2">开启第二轮红包雨</td>
																	</tr>
																	<tr>
																		<td><input type="radio" name="round" id="round"
																			value="3">开启第三轮红包雨</td>
																	</tr>
																	<tr>
																		<td><input type="radio" name="round" id="round"
																			value="4">开启第四轮红包雨</td>
																	</tr>
																	<tr>
																		<td><input type="radio" name="round" id="round"
																			value="5">开启第五轮红包雨</td>
																	</tr>
				
																</tbody>
															</table>

														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="openrain()">确认开启红包雨</button>
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
									    <form name="form2" id="form2" action="admin_rob_red_open"></form>
										<button type="button" class="btn btn-primary btn-lg" onclick="openlucky()" >开启抢红包</button>
										<div style="color: blue">${result1}</div>
									</div>

								</div>
								<div class="row clearfix">
									<div class="col-md-12 column">
										<img src="img/fenge.png" width="100px" />
									</div>
								</div>
								<div class="row clearfix">
									<div class="col-md-12 column">
									    <form name="form3" id="form3" action="admin_rob_red_close"></form>
										<button type="button" class="btn btn-primary btn-lg" onclick="closelucky()" >关闭抢红包</button>
										<div style="color: blue">${result2}</div>
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