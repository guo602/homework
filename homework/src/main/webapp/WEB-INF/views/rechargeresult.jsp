<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
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
</script>
</head>
<body>
<div>
		<h2 align="center">管理员界面·充值记录</h2>
	</div>
	<div style="width:100%; height:90px">
		<div style="width: 30%; height: 50px; float: left;">
			<form id="form1" name="form1" action="rechargeresult">
				<table cellpadding="10" width="30%">
				    <tr>
						<td>用户编号</td>
						<td><input name="itcode" id="itcode" style="width:80px"></td>
						<td><div id="textit" style="color: #FF0000"></div></td>
					</tr>
					<tr>
						<td>充值金额</td>
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
						    </select>
						</td>
						<td>至</td>
                        <td><select id="maxvol" name="maxvol" >
								<option value="500">5元</option>
								<option value="1000">10元</option>
								<option value="2000">20元</option>
								<option value="5000">50元</option>
								<option value="10000">100元</option>
								<option value="20000">200元</option>
								<option value="50000">500元</option>
								<option value="100000">1000元</option>
								<option value="200000" selected="selected">2000元</option>	
						    </select>
						</td>
					</tr>
					<tr>
				<td>充值时间</td>
				<td><select id="beghour" name="beghour" >
						<option value="19" selected="selected">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
				</select> <select id="begmin" name="begmin" >
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
				<td><select id="endhour" name="endhour" >
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24" selected="selected">24</option>
				</select> <select id="endmin" name="endmin" >
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
						<td><input type="button" id="showrecharge" name="showrecharge"
							value="查询记录" onclick="check()"></td>
					</tr>
				</table>
				${result}
			</form>
		</div>
		<div style="width: 70%; height: 50px; float: left;">
			<table cellpadding="10" border="1" width="90%"
				background="img/beijing.jpg">
				<tr>
					<td>交易记录ID</td>
					<td>充值账户ID</td>
					<td>充值金额</td>
					<td>充值时间</td>
					<td>充值备注</td>
				</tr>
				<c:forEach items="${list}" var="s">
					<tr>
						<td><c:out value="${s.getTid()}" /></td>
						<td><c:out value="${s.getWid()}" /></td>
						<td><c:out value="${s.getVolumn()}" /></td>
						<td><c:out value="${s.getTradetime()}" /></td>
						<td><c:out value="${s.getMemo()}" /></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>