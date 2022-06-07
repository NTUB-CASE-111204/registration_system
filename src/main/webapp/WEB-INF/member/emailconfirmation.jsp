<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>註冊系統</title>
    <link href="register.css" rel="stylesheet" type="text/css" />
    <script src="register.js"> </script>
</head>
<script type="text/javascript">
	function check(){
		if(form.password.value!=form.checkpassword.value){
			alert("密碼請輸入相同");
			return;
		}
		if(form.email.value==""||form.password.value==""||form.checkpassword.value==""){
			alert("欄位不可空白"); 
			return;
		}
		form.submit();
	}
</script>
<body>
	<h2>信箱驗證</h2>
	<hr>
	<form action="../member/emailconfirmation" method="post" name="form">
		*信箱: <input type="text" name="email"><p>
		*密碼: <input type="text" name="password"><p>
		*密碼確認: <input type="text" name="checkpassword"><p>
		<input type="button" value="確認" onclick="check()">
	</form>
</body>
</html>