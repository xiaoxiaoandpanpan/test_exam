<%@page import="org.apache.coyote.ErrorState"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getAttribute("javax.servlet.error.status_code") %>
	${pageContext.errorData.statusCode}
 ${pageContext.errorData.requestURI}
 ${requestScope["javax.servlet.error.message"]}
  
</body>
</html>