<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Model.member"%>
<% 
	String[] memberinfo = (String[])session.getAttribute("memberinfo");	
	String verification = memberinfo[2];
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>verificationcode</title>
</head>
<script type="text/javascript">
	function check(){
		if(form.verification.value==""){
			alert("欄位不可空白"); 
			return;
		}
		if(form.verification.value!=<%= verification%>){
			alert("驗證碼輸入錯誤")
			return;
		}
		form.submit();
	}
</script>
<body>
	<h2>輸入驗證碼</h2>
	<hr>
	<form action="../member/verificationcode" method="post" name="form">
		*驗證碼: <input type="text" name="verification" size="4"><p>
		<input type="button" value="確認" onclick="check()">
	</form>
</body>
</html>