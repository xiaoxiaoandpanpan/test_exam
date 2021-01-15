<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/calendar-blue.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}

.text2 {
	width: 450px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
</style>
<!-- 
<script>
	function InputM() {
		var evalue = document.getElementsByName("knowledge");
		var falg = false;
		for (var i = 0; i < evalue.length; i++) {
			if (evalue[i].checked) {
				falg = true;
			}
		}
		if (!falg) {
			alert("请选择科目内容！");
			return false;
		}
		if (isNotNull("testname") == true && testTime()
				&& isNum("sinnum") == true && isNum("scores1") == true
				&& isNum("multcho") == true && isNum("scores2") == true
				&& isNum("judg") == true && isNum("scores3") == true
				&& isNum("ring") == true && isNotNull("control_date") == true)
			return true;
		else
			return false;
	}

	function isNum(eeId) {
		var a = document.getElementById(eeId).value.replace(/(^\s*)|(\s*$)/g,
				"");
		if (a == null || a == "") {
			alert("输入不能为空！");
			return false;
		}
		if ((eeId == "sinnum" && a == 0) || (eeId == "scores1" && a == 0)) {
			alert("单选题必选！");
			return false;
		}
		var re = /^[0-9]*$/;
		if (re.test(a)) {
			return true;
		} else {
			alert("考试时间和题目分值、数量输入只能是大于等于0的整数!");
			return false;
		}
	}

	function diffDate(end) {
		var evalue = document.getElementById(end).value;
		var dB = new Date(evalue.replace(/-/g, "/"));
		if (new Date() > Date.parse(dB)) {
			return false;
		}
		return true;
	}

	function testTime() {
		var evalue = document.getElementById("control_date").value;
		if (evalue == null || evalue == "" || evalue == 0) {
			alert("日期输入不能为空！");
			return false;
		}
		var ret = diffDate("control_date");
		if (ret == false) {
			alert("考试截止时间选择不能小于当前时间！");
			return false;
		}

		return true;
	}

	function showErrorMsg(msg, eeId) {
		document.getElementById(eeId).style.display = "";
		document.getElementById(eeId).innerHTML = msg;
	}

	function isNotNull(uuid) {
		var value = document.getElementById(uuid).value;
		if (value == null || value == "" || value == 0) {
			alert("输入不能为空！");
			return false;
		} else {
			return true;
		}
	}
	function isNotZ(uuid) {
		var value = document.getElementById(uuid).value;
		if (value == null || value == "") {
			return false;
		} else {
			return true;
		}
	}
	function maxQueCount() {
		var sin = document.getElementById("sinnum").value;
		var mult = document.getElementById("multcho").value;
		var judg = document.getElementById("judg").value;
		alert("sin:" + sin);
		if (sin > 5) {
			alert("题库数量不够，单选题所出题目请不要超过5个题！");
			return false;
		}
		if (mult > 2) {
			alert("题库数量不够，单选题所出题目请不要超过2个题！");
			return false;
		}
		if (judg > 2) {
			alert("题库数量不够，单选题所出题目请不要超过2个题！");
			return false;
		}
		return true;
	}
</script> -->
</head>

<body onload="YearMonthDay()">
	<form id="form1" name="form1" class="word_darkGrey" method="post"
		onsubmit="return InputM();"
		action='<%=path%>/testAddServlet'>
		<div class="text2">
			<p>
				<label>考试科目为： <select name="courseid" id="courseid">
						<c:forEach var="course" items="${courseList }">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
				</select>
				</label>
			</p>

			<p>
				试卷名称为： <label> <input type="text" name="testname"
					id="testname" onblur="isNotNull('testname');" />
				</label> <br />
			</p>
			<%
				Date date = new Date();
			%>
			<p>
				考试截止时间为： <label><input name="enddate" type="text"
					id="control_date" size="20" maxlength="10" readonly="readonly"
					value='' />
					 </label><br />
			</p>

			<p>
				单项选择题（共<input name="sinscores" id="sinscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					name="sinnum" type="text" id="sinnum" size="5"
					onblur="isNotNull('sinnum');" /></label> 道小题 <br />
			</p>
			<p>
				考试时间：<label><input name="testtime" id="testtime" value="45"
					type="text" size="5" onblur="isNotNull('testtime')" /></label>分钟
			</p>

			<p>
				面向班级：
				<c:forEach var="stuclass" items="${classesList}">
					<input type="checkbox" name="classCheck" value="${stuclass.id}" checked="checked"/>${stuclass.name}
				</c:forEach>
			</p>
			<p align="center">
				<input type="submit" class="btn_grey" value="自动出题" />&nbsp;&nbsp;&nbsp;&nbsp;<br />
			</p>
		</div>
	</form>
	<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script>
Calendar.setup({
inputField : "control_date",
ifFormat : "%Y-%m-%d %H:%M:%S",
showsTime : true,
timeFormat : "24"
});
</script>
	</p>
</body>${hint }
</html>