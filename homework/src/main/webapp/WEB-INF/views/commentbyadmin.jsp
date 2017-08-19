<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论区管理界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/admin.css">

<script type="text/javascript">
	function check() {
		var is_submit = 1
		var bh = document.form1.beghour.value;
		var bm = document.form1.begmin.value;
		var eh = document.form1.endhour.value;
		var em = document.form1.endmin.value;
		if (bh > eh) {
			is_submit = 0;
			document.getByElement("time").innerText = "开始时间晚于截止时间，请重新选择"
		} else {
			if (bh == eh && bm > em) {
				is_submit = 0;
				document.getByElement("time").innerText = "开始时间晚于截止时间，请重新选择"
			}
		}
		if (is_submit == 1) {
			form1.submit();
		}
	}
	function lock_delete() {
		form2.submit();
	}
</script>
</head>
<body>



</body>

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
								<a class="bigger" href="luckyrain">开启红包雨 </a>
							</div>
							<div class="panel-footer">
								<a class="bigger" href="">评论区管理</a>
							</div>
							<ul class="list-group">
								<li class="list-group-item"><a class="bigger" href="comment">查找评论记录</a></li>
								<li class="list-group-item"><a class="bigger" href="comment">禁言用户</a></li>
								<li class="list-group-item"><a class="bigger" href="comment">删除评论</a></li>
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
									<div class="col-md-12 column">
										<form name="form2" id="form2" action="lock_delete">
											<table class="table table-hover table-striped"
												cellpadding="10">
												<thead>
													<tr>
														<td>发言ID</td>
														<td>用户ID</td>
														<td>用户发言</td>
														<td>发言时间</td>
														<td>删除发言</td>
														<td>禁言用户</td>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${list}" var="s">
														<tr>
															<td><c:out value="${s.getHid()}" /></td>
															<td><c:out value="${s.getUid()}" /></td>
															<td><c:out value="${s.getWord()}" /></td>
															<td><c:out value="${s.getHistorytime()}" /></td>
															<td><input type="checkbox" name="delete" id="delete" 
																value="${s.getHid()}">删除</td>
															<td><input type="checkbox" name="lock" id="lock" 
																value="${s.getUid()}">禁言</td>
														</tr>

													</c:forEach>
												</tbody>
											</table>
										</form>
									</div>
									<div class="row clearfix">
									<div class="col-md-12 column">
										<ul class="pagination">
											<li><a href="<c:url value="/program?page=1"/>">首页</a></li>
											<li><a
												href="<c:url value="/program?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

											<c:forEach begin="1" end="${totalPages}" varStatus="loop">
												<c:set var="active" value="${loop.index==page?'active':''}" />
												<li class="${active}"><a
													href="<c:url value="/program?page=${loop.index}"/>">${loop.index}</a>
												</li>
											</c:forEach>
											<li><a
												href="<c:url value="/program?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
											</li>
											<li><a href="<c:url value="/program?page=${totalPages}"/>">尾页</a></li>
										</ul>
		
									</div>
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
											data-target="#find">查找评论记录</button>

										<div style="color: blue">${result}</div>

										<!-- 模态框（Modal） -->
										<div class="modal fade " id="find" tabindex="-1" role="dialog"
											aria-labelledby="newModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="newModalLabel">查找评论记录</h4>
													</div>
													<div class="modal-body">
														<form name="form1" id="form1" action="findlist">
															<h3>搜索评论区历史记录</h3>
															<table>
																<tr>
																	<td>请输入用户编号</td>
																	<td><input name="itcode" id="itcode"
																		style="width: 150px"></td>
																	<td><div id="textit" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>请输入关键字词</td>
																	<td><input name="keyword" id="keyword"
																		style="width: 150px"></td>
																	<td><div id="textkey" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>请选择时间</td>
																	<td><select id="beghour" name="beghour"
																		style="width: 75px">
																			<option value="19" selected="selected">19</option>
																			<option value="20">20</option>
																			<option value="21">21</option>
																			<option value="22">22</option>
																			<option value="23">23</option>
																	</select> <select id="begmin" name="begmin" style="width: 75px">
																			<option value="00" selected="selected">00</option>
																			<option value="05">05</option>
																			<option value="10">10</option>
																			<option value="15">15</option>
																			<option value="20">20</option>
																			<option value="25">25</option>
																			<option value="30">30</option>
																			<option value="35">35</option>
																			<option value="40">40</option>
																			<option value="45">45</option>
																			<option value="50">50</option>
																			<option value="55">55</option>
																	</select></td>
																	<td>&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;</td>
																	<td><select id="endhour" name="endhour"
																		style="width: 75px">
																			<option value="19">19</option>
																			<option value="20">20</option>
																			<option value="21">21</option>
																			<option value="22">22</option>
																			<option value="23">23</option>
																			<option value="24" selected="selected">24</option>
																	</select> <select id="endmin" name="endmin" style="width: 75px">
																			<option value="00" selected="selected">00</option>
																			<option value="05">05</option>
																			<option value="10">10</option>
																			<option value="15">15</option>
																			<option value="20">20</option>
																			<option value="25">25</option>
																			<option value="30">30</option>
																			<option value="35">35</option>
																			<option value="40">40</option>
																			<option value="45">45</option>
																			<option value="50">50</option>
																			<option value="55">55</option>
																	</select></td>
																	<td><div id="time" style="color: red"></div></td>
																</tr>
																<tr>
																	<td>请选择查询数量</td>
																	<td><select id="number" name="number"
																		style="width: 155px">
																			<option value="10">10</option>
																			<option value="30">30</option>
																			<option value="50">50</option>
																			<option value="100">100</option>
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
															onclick="check()">确认查找评论</button>
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
										<button class="btn btn-primary btn-lg"  onclick="lock_delete()">删除或禁言</button>
										<div style="color: blue">${result1}</div>
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