<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping | Error Page</title>
</head>
<body>
	<h1>Error occurred :(</h1>
	<hr>
	<c:choose>
	<c:when test="${empty errorMessage }">
		${exception }
	</c:when>
	<c:otherwise>
		${errorMessage }
	</c:otherwise>
	</c:choose>
	<br>
	<br>
	<a href="/Project2/index">Back to Home Page</a>
</body>
</html>