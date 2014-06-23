<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<a href="register">注册新用户</a>
	<br>
	<c:forEach items="${users }" var="um">
		<a href="${um.value.username }">${um.value.username }</a>
		<a href="${um.value.username}/update">修改信息</a>
		<a href="${um.value.username}/delete">删除信息</a>
		<br>
	</c:forEach>
	<h1>Count:${message }</h1>
</body>
</html>