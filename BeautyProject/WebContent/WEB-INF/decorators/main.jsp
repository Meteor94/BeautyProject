<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title><decorator:title default="欢迎使用XXX管理系统" /></title>
<decorator:head />
</head>
<body>
	<h1>
		<decorator:title />
	</h1>
	<div>
		<a href="register">注册新用户</a>|<a href="users">用户列表</a>
	</div>
	<hr />
	<decorator:body />
	<div align="center"
		style="width: 100%; border-top: 1px solid; float: left; margin-top: 10px;">
		CopyRight@2014<br /> XXX管理系统
	</div>
</body>
</html>