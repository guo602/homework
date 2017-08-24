<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红包记录界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script>
	function check() {
		form1.submit()
	}
</script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<img alt="140x140" src="img/logo.png" class="img-rounded" width="250" height="70"/>
					</div>
					<div class="col-md-6 column">
						<div>
							<h3>
								看节目，发家致富
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
					<li><a class="bar" href="goBackToChat">返回年会</a></li>


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
										<table class="table table-hover " cellpadding="10" background="img/beijing.jpg"  >
											<thead>
												<tr>
													<th>红包ID</th>
													<th>账户ID</th>
													<th>红包金额</th>
													<th>红包轮次</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="s">
													<tr>
														<td><c:out value="${s.getRid()}" /></td>
														<td><c:out value="${s.getWid()}" /></td>
														<td><c:out value="${s.getLucky_money()}" /></td>
														<td><c:if test="${s.getRound()<10}">
																<c:out value="第${s.getRound()}轮红包雨" />
															</c:if>
															<c:if test="${s.getRound()>10}">
																<c:out value="第${s.getRound()/100}轮抢红包" />
															</c:if>
														</td>
													</tr>

												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="row clearfix">
										<div class="col-md-12 column">
											
											<ul class="pagination">
												<li><a href="<c:url value="/luckyresult?itcode=${itcode}&round=${round}&number=${number }&page=1"/>">首页</a></li>
												<li><a
													href="<c:url value="/luckyresult?itcode=${itcode}&round=${round}&number=${number }&page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

												<c:forEach begin="1" end="${totalPages}" varStatus="loop">
													<c:set var="active" value="${loop.index==page?'active':''}" />
													<li class="${active}"><a
														href="<c:url value="/luckyresult?itcode=${itcode}&round=${round}&number=${number }&page=${loop.index}"/>">${loop.index}</a>
													</li>
												</c:forEach>
												<li><a
													href="<c:url value="/luckyresult?itcode=${itcode}&round=${round}&number=${number }&page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
												</li>
												<li><a
													href="<c:url value="/luckyresult?itcode=${itcode}&round=${round}&number=${number }&page=${totalPages}"/>">尾页</a></li>
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
											data-target="#findby">条件搜索</button>

										<!-- 模态框（Modal） -->
										<div class="modal fade " id="findby" tabindex="-1"
											role="dialog" aria-labelledby="newModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="newModalLabel">条件搜索</h4>
													</div>
													<div class="modal-body" style="text-align: center;">
														<form role="form" id="form1" name="form1" action="luckyresult">
															<div class="form-group">
																<label for="itcode">请输入用户编号</label><input
																	class="form-control" id="itcode" name="itcode"
																	style="width: 30%; display: inline;" />
																<div id="textit" style="color: #FF0000"></div>
															</div>
															<div class="form-group">
																<label for="itcode">请选择红包雨</label><input type="radio" 
																	name="round" id="round" value="1"
																	style="width: 1000%; display: inline;" />第一轮红包雨
																<input type="radio" 
																	name="round" id="round" value="2"
																	style="width: 100%; display: inline;" />第二轮红包雨
																<input type="radio" 
																	name="round" id="round" value="3"
																	style="width: 100%; display: inline;" />第三轮红包雨
																<input type="radio" 
																	name="round" id="round" value="4"
																	style="width: 100%; display: inline;" />第四轮红包雨
																<input type="radio" 
																	name="round" id="round" value="5"
																	style="width: 100%; display: inline;" />第五轮红包雨	
																<input type="radio" 
																	name="round" id="round" value="0"
																	style="width: 100%; display: inline;" />显示所有记录
																	
																<div id="textit" style="color: #FF0000"></div>
															</div>
															<div class="form-group">
																<label for="number">请选择查询数量</label><select id="number" name="number"
																		style="width: 155px;display: inline;"
																		class="form-control">
																			<option value="10">10</option>
																			<option value="30">30</option>
																			<option value="50">50</option>
																			<option value="100">100</option>
																			<option value="0" selected="selected">无限制</option>

																	</select>
															</div>
														
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary"
															onclick="check()">确认查询</button>
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
										<div style="color: blue">${result}</div>
										<div>
											<c:if test="${sign=='ok'}">
												<img src="img/right.png" width="70" height="50" />
											</c:if>

											<c:if test="${sign=='no'}">
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

