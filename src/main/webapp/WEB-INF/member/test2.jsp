<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<head>
<div class="hero">
    <div class="form-box">
      <div class="button-box">
        <div id="btn"></div>
     <!--   <button type="button" class="toggle-btn" onclick=login()>Log In</button>
        <button type="button" class="toggle-btn" onclick="register()">Register</button>-->
      </div>
    <!--  <div class="social-icons">
       <a href="https://postimages.org/" target="_blank"><img src="https://i.postimg.cc/rmj1tdKw/fb.png" alt="fb"/></a>
       <a href="https://postimages.org/" target="_blank"><img src="https://i.postimg.cc/L57ZzjR2/tw.png" alt="tw"/></a>
      <a href="https://postimages.org/" target="_blank"><img src="https://i.postimg.cc/kG5xNnbF/gp.png" alt="gp"/></a>
      </div> -->
      <!--<form id="login" class="form-group">
        <input type="text" class="input-field" placeholder="信箱" required/>
        <input type="text" class="input-field" placeholder="密碼" required/> -->
        <div class="col-lg-6 text-center">
            <!----<h1>邦妮幫你Bunny</h1>---->
             <p>註冊系統</p>
        <form action="../member/memberprofile" method="post" name="form">
  *姓名: <input type="text" name="name"><p>
  *行動電話: <input type="text" name="phone"><p>
  *性別:<select name="gender">
    <option value="male">男生</option>
    <option value="female">女生</option>
   </select><p>
  *年齡: <input type="text" name="age"><p>
  *居住地區: <input type="text" name="livingarea"><p>

    *是否願意登記成為實驗動物領養人?<select name="will">   <option value="yes">願意</option>
        <option value="no">不願意</option>
        <option value="notyet">尚未決定</option></select>
        <p></p>
  <input type="button" value="確認註冊" onclick="check()"> 
 </form>
       <!-- <input type="checkbox" class="check-box"/><span>Remmber Password</span> -->
    <!--  <button type="submit" class="submmit-btn">註冊</button> -->
      </form> 
      <form id="register" class="form-group">
        <input type="text" class="input-field" placeholder="User ID" required/>
        <input type="email" class="input-field" placeholder="Email" required/>
        <input type="text" class="input-field" placeholder="Enter Password" required/>
        <input type="checkbox" class="check-box"/><span>I agree to the termes &amp; conditions</span>
        <button type="submit" class="submmit-btn">Register</button>
      </form>
    </div>
  
  </div> 
  </head>
</html>