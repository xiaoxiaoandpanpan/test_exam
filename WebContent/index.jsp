<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Login.do" method="post">
	<table border="0">
		<tbody>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" placeholder="name" id="username" name="username" /></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" placeholder="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2" >
					<input type="submit" value="提交">
				</td>
			</tr>
		</tbody>
		
	</table>
	</form>
</body>
</html>