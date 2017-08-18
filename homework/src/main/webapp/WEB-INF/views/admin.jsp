<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
<meta name="viewport" content="width=device-width">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/admin.css">

</head>
<body>
	<!--  <div class="blockdis">
	  <div class="col-xs-8">
	     <img alt="网络可能炸了" src="img/jammy.jpg" class="img-circle midimg">
	  </div>
		<h1 style="float:left">管理员界面</h1>
		
	</div>
    -->
	<!-- 模板 -->
	<!-- 标题栏-->
	<div style="background: url(img/bluebeijing.jpg)">
		<div class="container">
			<div class="row clearfix">
				<div class="col-lg-12">
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
						<li><a class="bar" href="traderecord">打赏记录</a></li>
						<li><a class="bar" href="traderecord">充值记录</a></li>
						<li><a class="bar" href="user">返回年会</a></li>


					</ul>



					<div class="row clearfix">
						<div class="col-md-12 column">
							<p></p>
						</div>
					</div>
					<!--幻灯片-->
					<div class="carousel slide" id="carousel-712824">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0"
								data-target="#carousel-712824"></li>
							<li data-slide-to="1" data-target="#carousel-712824"></li>
							<li data-slide-to="2" data-target="#carousel-712824"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="img/ppt112.png" class="img-rounded" />
								<div class="carousel-caption">
									<h4>First</h4>
									<p></p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="img/ppt1.jpg" class="img-rounded"/>								<div class="carousel-caption">
									<h4>Second </h4>
									<p></p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="img/ppt1.jpg" class="img-rounded"/>
								<div class="carousel-caption">
									<h4>Third </h4>
									<p></p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-712824"
							data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left"></span></a> <a
							class="right carousel-control" href="#carousel-712824"
							data-slide="next"><span
							class="glyphicon glyphicon-chevron-right"></span></a>
					</div>

					<!--标题栏-->
					<div class="row clearfix">
						<div class="col-md-12 column">
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-6 column">
									<img alt="140x140" src="img/title1.png"/>
								</div>

								<div class="col-md-3 column"></div>
							</div>
							<div class="row clearfix">
								<div class="col-md-4 column">
									<a href="program"> <img alt="140x140"
										src="img/adminprogram.png" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="program">添加/查找节目</a>
									</div>
								</div>
								<div class="col-md-4 column">
									<a href="wallet"><img alt="140x140"
										src="img/adminwallet.png" class="img-circle midimg" /> </a>
									<div>
										<a class="bigger" href="wallet">激活/锁定/解锁账户</a>
									</div>
								</div>
								<div class="col-md-4 column">
									<a href="addadmin"><img alt="140x140"
										src="img/adminadd.png" class="img-circle midimg" /> </a>
									<div>
										<a class="bigger" href="addadmin">添加/删除用户/管理员</a>
									</div>
								</div>
							</div>
							
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-6 column">
									<img alt="140x140" src="img/title2.png"/>
								</div>
								<div class="col-md-3 column"></div>
							</div>
							<div class="row clearfix" >
								<div class="col-md-4 column">
									<a href="comment"> <img alt="140x140"
										src="img/adminchat.png" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="comment">查找/删除评论记录/禁言用户</a>
									</div>
								</div>
								<div class="col-md-4 column">
									<a href="luckyrain"> <img alt="140x140"
										src="img/adminlucky.gif" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="luckyrain">红包雨开启</a>
									</div>
								</div>
								<div class="col-md-4 column">
									<a href="reward"> <img alt="140x140"
										src="img/adminreward.png" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="reward">节目打赏功能开启</a>
									</div>
								</div>
							</div>
							
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-6 column">
									<img alt="140x140" src="img/title3.png" />
								</div>
								<div class="col-md-3 column"></div>
							</div>
							<div class="row clearfix">
								<div class="col-md-4 column">
									<a href="luckyrecord"> <img alt="140x140"
										src="img/adminluckyrecord.png" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="luckyrecord">红包记录</a>
									</div>
								</div>
								<div class="col-md-4 column">
									<a href="rewardrecord"> <img alt="140x140"
										src="img/adminrewardrecord.png" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="rewardrecord">打赏记录</a>
									</div>
								</div>
								<div class="col-md-4 column">
									<a href="rechargerecord"> <img alt="140x140"
										src="img/adminrechargerecord.png" class="img-circle midimg" />
									</a>
									<div>
										<a class="bigger" href="rechargerecord">充值记录</a>
									</div>
								</div>
							</div>
						</div>
					</div>
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
					<div class="col-md-1 column">WCH</div>
					<div class="col-md-1 column">WYZ</div>
					<div class="col-md-1 column">GY</div>
					<div class="col-md-1 column">ZYQ</div>
					<div class="col-md-1 column"></div>
					<div class="col-md-1 column"></div>
					<div class="col-md-1 column"></div>
					<div class="col-md-1 column"></div>
				</div>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<hr />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>