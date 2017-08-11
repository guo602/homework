<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>节目单查询</title>

<script type="text/javascript">
	function check(n) {

		//读取输入
		var program_name = document.getElementById("program_name").value;
		var program_name = document.getElementById("program_name").value;
		var perfomer = document.getElementById("perfomer").value;
		var starttime = document.getElementById("starttime").value;
		var program_name = document.getElementById("program_name").value;

		//检查时间输入的格式,当天的19-22点均可，2018-11-11 21:21:21是可以的
		var patern3 = new RegExp(
				"(\\d{4}|\\d{2})-((0?([1-9]))|(1[1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))[ ]((1|0?)[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
		//(\d{4}|\d{2})-((0?([1-9]))|(1[1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))[ ]((1|0?)[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])

		//检查开始时间
		if (n == 3) {
			if (starttime == "") {
			} else if (!patern3.exec(starttime)) {
				document.getElementById("d3").innerText = "开始时间格式不正确，正确格式形如：2018-11-11 21:21:21";
			} else {
				document.getElementById("d3").innerText = "";
			}
		}
		return false;
	}
</script>

<script>
	function fun_program_id() {
		document.form1.round.value = "1";
		form1.submit();
	}
	function fun_program_name() {
		document.form1.round.value = "2";
		form1.submit();
	}
	function fun_perfomer() {
		document.form1.round.value = "3";
		form1.submit();
	}
	function fun_starttime() {
		document.form1.round.value = "4";
		form1.submit();
	}
	function fun_department() {
		document.form1.round.value = "5";
		form1.submit();
	}
</script>
</head>
<body bgcolor="#F4F4F4">
	<div id="container">
		<div id="header">
			<h1 align="center">节目单查询</h1>
		</div>
		<div id="page" class="clearfix">
			<div style="width: 30%; height: 450px; float: left;">
				<h1 align="center">目录</h1>
			</div>

			<div style="width: 70%; height: 220px; float: left;">
				<!-- 中间右侧主界面 -->

				<form id="form1" name="form1" action="program_search" method="get">
					<!-- get方式传输的数据会显示在地址栏里，不能提交文件（文本形式传输，有长度限制，但传输效率高，方便调试） -->
					<!-- post方法传输的数据不会显示在地址栏里，而把数据封装成数据包，不希望传输的内容显示在地址栏里（如密码）时使用 -->

					<p style="color: black">请输入至少一个查询信息</p>

					<table>
						<tr>
							<td>节目编号：
							<td />
							<td><input type="text" id="program_id" name="program_id"></td>
						</tr>
						<tr>
							<td>节目名称：
							<td />
							<td><input type="text" id="program_name" name="program_name"></td>
						</tr>
						<tr>
							<td>表演者：
							<td />
							<td><input type="text" id="perfomer" name="perfomer"></td>
						</tr>
						<tr>
							<td>开始时间：
							<td />
							<td><input type="text" id="starttime" name="starttime"></td>
						</tr>
						<tr>
							<td>报送单位：
							<td />
							<td><input type="text" id="department" name="department"></td>
						</tr>


						<!-- 这是一个不跳转页面的submit -->
						<tr>
							<td><input type="submit" value="提交"></td>
						</tr>
						<!-- reset把它所在form里面的其他input清空 -->
						<!-- submit把form里面的页面提交给程序 -->
					</table>
				</form>
			</div>
			<div>
				<div style="width: 70%; height: 230px; float: left;">
					<table cellpadding="10" border="0" width="90%"
						background="img/beijing.jpg">
						<tr>
							<td>节目编号</td>
							<td>节目名称</td>
							<td>表演者</td>
							<td>开始时间</td>
							<td>报送单位</td>
						</tr>
						<c:forEach items="${list}" var="s">
							<tr>
								<td><c:out value="${s.getPid()}" /></td>
								<td><c:out value="${s.getPro_name()}" /></td>
								<td><c:out value="${s.getPerformer()}" /></td>
								<td><c:out value="${s.getStart_time()}" /></td>
								<td><c:out value="${s.getDept_id()}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div id="footer">
				<h1 align="center">网页页尾</h1>
			</div>
		</div>
</body>
</html>