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
		if(form.name.value==""||form.phone.value==""||form.gender.value==""||form.age.value==""||
				form.livingarea.value==""){
			alert("欄位不可空白"); 
			return;
		}
		form.submit();
	}
</script>
<body>
	<div class="hero">
    	<div class="form-box">
    
			<h2>新增帳號</h2><hr>
			<form action="../member/memberprofile" method="post" name="form">
				*姓名: <input type="text" name="name"><p>
				*行動電話: <input type="text" name="phone"><p>
				*性別:<select name="gender">
						<option value="male">男生</option>
						<option value="female">女生</option>
					</select><p>
				*年齡: <input type="text" name="age"><p>
				*居住地區: <input type="text" name="livingarea"><p>
				*是否願意登記成為實驗動物領養人?<select name="adopter">   
					<option value="yes">願意</option>
			        <option value="no">不願意</option>
			        <option value="notyet">尚未決定</option></select>
		        <p></p>
				<input type="button" value="確認" onclick="check()">	
			</form>
		</div>
	</div>
</body>
</html>