<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<form name="form1" id="form1" action="findlist">
		<h3>搜索评论区历史记录</h3>
		<table>
			<tr>
				<td>请输入用户编号</td>
				<td><input name="itcode" id="itcode" style="width: 150px"></td>
				<td><div id="textit" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>请输入关键字词</td>
				<td><input name="keyword" id="keyword" style="width: 150px"></td>
				<td><div id="textkey" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>请选择时间</td>
				<td><select id="beghour" name="beghour" style="width: 75px">
						<option value="12" selected="selected">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
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
				<td><select id="endhour" name="endhour" style="width: 75px">
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
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
				<td><select id="number" name="number" style="width: 155px">
						<option value="10">10</option>
						<option value="30">30</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="0" selected="selected">无限制</option>

				</select></td>

			</tr>

			<tr>
				<td><input type="button" name="ok" id="ok" value="确认搜索"
					onclick="check()"></td>
				<td><div style="color: blue">${result}</div></td>

			</tr>
		</table>
	</form>
	<form name="form2" id="form2" action="lock_delete">
		<input type="button" name="yes" id="yes" value="确认删除或禁言"
			onclick="lock_delete()">
		<div style="color: blue">${result1}</div>
		<table cellpadding="10" border="1" width="90%">
			<tr>
				<td>发言ID</td>
				<td>用户ID</td>
				<td>用户发言</td>
				<td>发言时间</td>
				<td>删除发言</td>
				<td>禁言用户</td>
			</tr>
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

		</table>

	</form>

</body>
</html>