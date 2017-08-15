<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增节目单</title>


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
</script>
</head>

<body bgcolor="#F4F4F4">
	<div>
		<h1 align="center">新增节目单</h1>
	</div>
	<div>
		<div style="width: 30%; height: 450px; float: left;">
			<h1 align="center">目录</h1>
		</div>

		<div style="width: 70%; height: 450px; float: left;">
			<!-- 中间右侧主界面 -->

			<form id="form1" name="form1" action="program_insert">
				<!-- get方式传输的数据会显示在地址栏里，不能提交文件（文本形式传输，有长度限制，但传输效率高，方便调试） -->
				<!-- post方法传输的数据不会显示在地址栏里，而把数据封装成数据包，不希望传输的内容显示在地址栏里（如密码）时使用 -->

				<table>

					<tr>
						<td>节目名称：</td>
						<td><input type="text" id="program_name" name="program_name"></td>
						<td><div id="d1" style="color: #FF0000"></div></td>
					</tr>
					<tr>
						<td>表演者：</td>
						<td><input type="text" id="performer" name="performer"></td>
						<td><div id="d2" style="color: #FF0000"></div></td>
					</tr>
					<tr>
						<td>开始时间：</td>
						<td><input type="text" id="starttime" name="starttime"></td>
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

					<!-- 这是一个不跳转页面的submit -->
					<tr>
						<td><input type="button" value="提交" onclick="check()"></td>
					</tr>
					<!-- reset把它所在form里面的其他input清空 -->
					<!-- submit把form里面的页面提交给程序 -->
				</table>
				<p>
					${result}
					<c:if test="${sign=='ok'}">
						<img src="img/right.png" width="70" height="50" />
					</c:if>
					<c:if test="${sign=='no'}">
						<img src="img/cross.png" width="40" height="50" />
					</c:if>
				</p>
			</form>


		</div>
	</div>

	<div>
		<h1 align="center">网页页尾</h1>
	</div>

</body>
</html>