<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		用户名：<form:input path="username" />
		<form:errors path="username" />
		<br />
		密码：<form:password path="password" />
		<form:errors path="password" />
		<br />
		Email:<form:input path="email" />
		<br />
		<input type="submit" value="注册" />
	</form:form>
</body>
</html>