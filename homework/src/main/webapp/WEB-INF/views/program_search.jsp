<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>节目单查询</title>

<script type="text/javascript">
function check(n){
	
	//读取输入
	var program_name = document.getElementById("program_name").value;
	var program_name = document.getElementById("program_name").value;
	var perfomer = document.getElementById("perfomer").value;
	var starttime = document.getElementById("starttime").value;
	var program_name = document.getElementById("program_name").value;
	
	//检查时间输入的格式,当天的19-22点均可，2018-11-11 21:21:21是可以的
	var patern3 = new RegExp("(\\d{4}|\\d{2})-((0?([1-9]))|(1[1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))[ ]((1|0?)[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");  
	//(\d{4}|\d{2})-((0?([1-9]))|(1[1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))[ ]((1|0?)[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])
	
	//检查开始时间
	if(n==3){
		if(starttime==""){}
		else if(!patern3.exec(starttime)){
		document.getElementById("d3").innerText="开始时间格式不正确，正确格式形如：2018-11-11 21:21:21";
		}else{
		document.getElementById("d3").innerText="";
		}
	}
	return false;
}

</script>

</head>
<body bgcolor="#F4F4F4">
<div>
	<h1 align="center">节目单查询</h1>
</div>
<div>
	<div>
		<h1 align="center">目录</h1>
	</div>
	
	<div>
	
	
	
	
		<!-- 中间右侧主界面 -->
		
		<form id="form1" name="form1" action="program_search" method="get" onsubmit="return check()">
		<!-- get方式传输的数据会显示在地址栏里，不能提交文件（文本形式传输，有长度限制，但传输效率高，方便调试） -->
		<!-- post方法传输的数据不会显示在地址栏里，而把数据封装成数据包，不希望传输的内容显示在地址栏里（如密码）时使用 -->
		
		<p style="color:#FF0000">请输入至少一个查询信息</p>
		
		<table>
		<tr>
			<td>节目编号：<td/>
			<td><input onblur = "check(0)" type="text" id="program_id" name="program_id"></td>
			<td><div id="d0" style="color:#FF0000"></div></td>
		</tr>
		<tr>
			<td>节目名称：<td/>
			<td><input onblur = "check(1)" type="text" id="program_name" name="program_name"></td>
			<td><div id="d1" style="color:#FF0000"></div></td>
		</tr>
		<tr>
			<td>表演者：<td/>
			<td><input onblur = "check(2)" type="text" id="perfomer" name="perfomer"></td>
			<td><div id="d2" style="color:#FF0000"></div></td>
		</tr>
		<tr>
			<td>开始时间：<td/>
			<td><input onblur = "check(3)" type="text" id="starttime" name="starttime"></td>
			<td><div id="d3" style="color:#FF0000"></div></td>
		</tr>
		<tr>
			<td>报送单位：<td/>
			<td><input onblur = "check(4)" type="text" id="department" name="department"></td>
			<td><div id="d4" style="color:#FF0000"></div></td>
		</tr>

		
		<!-- 这是一个不跳转页面的submit -->
		<tr><td><input type="submit"  value="提交"></td></tr>
		<!-- reset把它所在form里面的其他input清空 -->
		<!-- submit把form里面的页面提交给程序 -->
		</table>
		</form>
		
		
		
		
	</div>
</div>
<div>
	<h1 align="center">网页页尾</h1>
</div>

</body>
</html>