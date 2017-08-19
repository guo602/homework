<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打赏管理界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script type="text/javascript">
	function check(value) {
		 var temp="reward"+value;
		 document.getElementById(temp).disabled=true;
         document.form1.pid.value=value;
         form1.submit();
	}
	
	function checkall(){
		form1.submit();
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
								<h3>现场管理</h3>
							</div>
							<div class="panel-heading">
								<a class="bigger" href="luckyrain">开启红包雨 </a>
							</div>
							<div class="panel-footer">
								<a class="bigger" href="">开启节目打赏</a>
							</div>
							<ul class="list-group">
								<li class="list-group-item"><a class="bigger" href="reward">指定节目打赏</a></li>
								<li class="list-group-item"><a class="bigger" href="reward">全部节目打赏</a></li>
							</ul>
							<div class="panel-heading">
								<a class="bigger" href="comment"> 评论区管理</a>
							</div>
						</div>

					</div>
					<div class="col-md-9 column">
						<div class="row clearfix">
							<div class="col-md-10 column">
								<div class="row clearfix">
									<div class="col-md-12 column">
										<table class="table table-hover table-striped"
											cellpadding="10">
											<thead>
												<tr>
													<th>节目编号</th>
													<th>节目名称</th>
													<th>表演者</th>
													<th>开始时间</th>
													<th>开启打赏</th>
												</tr>
											</thead>
											<tbody>
												<%
													int i = 0;
												%>
												<c:forEach items="${list}" var="s">
													<tr class="error">
														<%
															i++;
														%>
														<td><c:out value="${s.getPid()}" /></td>
														<td><c:out value="${s.getPro_name()}" /></td>
														<td><c:out value="${s.getPerformer()}" /></td>
														<td><c:out value="${s.getStart_time()}" /></td>
														<td><input name="reward<%out.print(i);%>"
															id="reward<%out.print(i);%>"
															class="btn btn-primary btn-xs but_in_table" type="button"
															value="节目打赏" onclick="check(<%out.print(i);%>)" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="row clearfix">
										<div class="col-md-12 column">
											<ul class="pagination">
												<li><a href="<c:url value="/openbonus?page=1"/>">首页</a></li>
												<li><a
													href="<c:url value="/openbonus?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

												<c:forEach begin="1" end="${totalPages}" varStatus="loop">
													<c:set var="active" value="${loop.index==page?'active':''}" />
													<li class="${active}"><a
														href="<c:url value="/openbonus?page=${loop.index}"/>">${loop.index}</a>
													</li>
												</c:forEach>
												<li><a
													href="<c:url value="/openbonus?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
												</li>
												<li><a
													href="<c:url value="/openbonus?page=${totalPages}"/>">尾页</a></li>
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
										<form id="form1" name="form1" action="openbonus">
											<input type="hidden" id="pid" name="pid" value="0" />
										</form>
										<button type="button" class="btn btn-primary btn-lg"
											onclick="checkall()">一键开启</button>
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