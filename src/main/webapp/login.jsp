<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
</head>
<script type="text/javascript">
	function check() {
		if (form.email.value == "" && form.password.value == "") {
			alert("請輸入信箱密碼");
			return;
		}
		if (form.email.value == "") {
			alert("信箱不能空白");
			return;
		}
		if (form.password.value == "") {
			alert("密碼不能空白");
			return;
		}
		form.submit();
	}
</script>
<body>
	<h2>登入頁面</h2>
	<hr>
	<form action="member/login" method="post" name="form">
		信箱: <input type="text" name="email"><br> 
		密碼: <input type="text" name="password"><br> 
		<input type="button" value="登入" onclick="check()">
	</form>
	<p>
	<a href="member/addmember">註冊新帳號</a>
</body>
</html>