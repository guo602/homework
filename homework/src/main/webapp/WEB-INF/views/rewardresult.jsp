<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打赏记录界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script>
function checkreward() {
	var is_submit = 1
	var bh = document.form1.beghour.value;
	var bm = document.form1.begmin.value;
	var eh = document.form1.endhour.value;
	var em = document.form1.endmin.value;
	var minv = document.form1.minvol.value;
	var maxv = document.form1.maxvol.value;
	if (bh > eh) {
		is_submit = 0;
		document.getByElement("time1").innerText = "开始时间晚于截止时间，请重新选择"
	} else {
		if (bh == eh && bm > em) {
			is_submit = 0;
			document.getByElement("time1").innerText = "开始时间晚于截止时间，请重新选择"
		}
	}
	if (minv > maxv) {
		document.getByElement("money1").innerText = "金额下限大于上限，请重新选择"
		is_submit = 0;
	}
	if (is_submit == 1) {
		form1.submit();
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
								<h3>晚会现场</h3>
							</div>
							<div class="panel-heading">
								<a class="bigger" href="luckyresult">红包记录 </a>
							</div>
							<div class="panel-footer">
								<a class="bigger" href="rewardrecord">打赏记录</a>
							</div>
							<div class="panel-heading">
								<a class="bigger" href="rechargerecord">充值记录 </a>
							</div>
						</div>

					</div>
					<div class="col-md-9 column">
						<div class="row clearfix">
							<div class="col-md-10 column">
								<div class="row clearfix">
									<div class="col-md-12 column">
										<table class="table table-hover " cellpadding="10" background="img/beijing.jpg">
											<thead>
												<tr>
													<th>记录ID</th>
													<th>账户ID</th>
													<th>金额</th>
													<th>时间</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="s">
													<tr >
														<td><c:out value="${s.getTid()}" /></td>
														<td><c:out value="${s.getWid()}" /></td>
														<td><c:out value="${s.getVolumn()}" /></td>
														<td><c:out value="${s.getTradetime()}" /></td>
														<td><c:out value="${s.getMemo()}" /></td>
													</tr>

												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="row clearfix">
										<div class="col-md-12 column">
											<ul class="pagination">
												<li><a href="<c:url value="/rewardrecord?itcode=${itcode}&minvol=${minvol}&maxvol=${maxvol}&beghour=${beghour}&begmin=${begmin}&endhour=${endhour}&endmin=${endmin}&page=1"/>">首页</a></li>
												<li><a
													href="<c:url value="/rewardrecord?itcode=${itcode}&minvol=${minvol}&maxvol=${maxvol}&beghour=${beghour}&begmin=${begmin}&endhour=${endhour}&endmin=${endmin}&page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

												<c:forEach begin="1" end="${totalPages}" varStatus="loop">
													<c:set var="active" value="${loop.index==page?'active':''}" />
													<li class="${active}"><a
														href="<c:url value="/rewardrecord?itcode=${itcode}&minvol=${minvol}&maxvol=${maxvol}&beghour=${beghour}&begmin=${begmin}&endhour=${endhour}&endmin=${endmin}&page=${loop.index}"/>">${loop.index}</a>
													</li>
												</c:forEach>
												<li><a
													href="<c:url value="/rewardrecord?itcode=${itcode}&minvol=${minvol}&maxvol=${maxvol}&beghour=${beghour}&begmin=${begmin}&endhour=${endhour}&endmin=${endmin}&page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
												</li>
												<li><a
													href="<c:url value="/rewardrecord?itcode=${itcode}&minvol=${minvol}&maxvol=${maxvol}&beghour=${beghour}&begmin=${begmin}&endhour=${endhour}&endmin=${endmin}&page=${totalPages}"/>">尾页</a></li>
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
											data-target="#findb">条件搜索</button>

										<!-- 模态框（Modal） -->
										<div class="modal fade " id="findb" tabindex="-1"
											role="dialog" aria-labelledby="newModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="newModalLabel">打赏记录搜索</h4>
													</div>
													<div class="modal-body" style="text-align: center;">
														<form id="form1" name="form1" action="rewardresult">
															<table cellpadding="10" width="30%">
																<tr>
																	<td>用户编号</td>
																	<td><input name="itcode" id="itcode"
																		style="width: 80px"></td>
																	<td><div id="textit" style="color: #FF0000"></div></td>
																</tr>
																<tr>
																	<td>打赏金额</td>
																	<td><select id="minvol" name="minvol">
																			<option value="0" selected="selected">0元</option>
																			<option value="500">5元</option>
																			<option value="1000">10元</option>
																			<option value="2000">20元</option>
																			<option value="5000">50元</option>
																			<option value="10000">100元</option>
																			<option value="20000">200元</option>
																			<option value="50000">500元</option>
																			<option value="100000">1000元</option>
																			<option value="200000">2000元</option>
																	</select></td>
																	<td>至</td>
																	<td><select id="maxvol" name="maxvol">
																			<option value="500">5元</option>
																			<option value="1000">10元</option>
																			<option value="2000">20元</option>
																			<option value="5000">50元</option>
																			<option value="10000">100元</option>
																			<option value="20000">200元</option>
																			<option value="50000">500元</option>
																			<option value="100000">1000元</option>
																			<option value="200000" selected="selected">2000元</option>
																	</select></td>
																	<td><div id="money" style="color: red"></div></td>
																</tr>
																<tr>
																	<td>打赏时间</td>
																	<td><select id="beghour" name="beghour">
																			<option value="19" selected="selected">19</option>
																			<option value="20">20</option>
																			<option value="21">21</option>
																			<option value="22">22</option>
																			<option value="23">23</option>
																	</select> <select id="begmin" name="begmin">
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
																	<td><select id="endhour" name="endhour">
																			<option value="19">19</option>
																			<option value="20">20</option>
																			<option value="21">21</option>
																			<option value="22">22</option>
																			<option value="23">23</option>
																			<option value="24" selected="selected">24</option>
																	</select> <select id="endmin" name="endmin">
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
															</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="checkreward()">确认查询</button>
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
										<div style="color: blue">${result1}</div>
										<div>
											<c:if test="${sign1=='ok'}">
												<img src="img/right.png" width="70" height="50" />
											</c:if>

											<c:if test="${sign1=='no'}">
												<img src="img/cross.png" width="40" height="50" />
											</c:if>
										</div>
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

