<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"
	import="Factory.spFactory" import="Model.member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>success</title>
</head>
<body>
	<%
		member o = (member)session.getAttribute("member");
		String name = o.getName();
	%>
	<h2>會員  <%= name %>  成功登入</h2>
	<hr>
	<!-- a href="../page/center">中央控制</a-->
</body>
</html>