<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆！</title>

<style type="text/css">
html{
        height: 100%;
    }
    #body{
        padding: 0;
        margin: 0;
        background: url('img/login.jpg');
        background-size: 100% 100%;
        
    }


* {

  padding: 0;

  margin: 0;

  font-family: "微软雅黑";

}

/*右边登陆框开始*/

.gcs-login {

  position: absolute;

  right: 50%;
  top: 50%;
  margin-right: -235px;
  margin-top: -200px;

  box-sizing: border-box;

  width: 470px;

  height: 400px;
  
  opacity: 0.9;

  background-color: #E6E6E6;

  z-index: 100;

}

.gcs-login .gcs-login-panel{

 height: 360px;

  position:absolute;

  margin:auto;

  left: 0;

  right: 0;

  top:0;

  bottom: 0;

}

.gcs-login .login-title {

  text-align: center;

  color: #62a8ea;

}

.gcs-login .login-title h2 {

  letter-spacing: 10px;

}

.gcs-login-container {

  width: 100%;

  box-sizing: border-box;

  width: 100%;

  margin: 20px 0 0;

  text-align: center;

}

.gcs-login .input {

  border: 1px solid white;

  display: inline-block;

  box-sizing: border-box;

  width: 80%;

  height: 46px;

  padding-left: 10px;

  margin: 0 auto;

  font-size: 14px;

  outline: none;

  color:  #76838f;

}

.gcs-login .gcs-login-validation{

  width:80%;

  margin: 0 auto;

  position: relative;

}

.gcs-login .validation-input{

  position: absolute;

  width: 250px;

  left: 0px;

}

.gcs-login img.validation-img{

  position: absolute;

  cursor:pointer;

  width: 125px;

  height: 45px;

  right: 0px;

}

.gcs-login .input:focus {

  outline: none;

  border: 1px solid #62a8ea;

}

.gcs-login .btn-login {

  background-color: #62a8ea;

 border: none;

  width: 80%;

  height: 45px;

  line-height: 45px;

  color: white;

  cursor: pointer;

  font-size: 16px;

  font-weight: bold;

}

.gcs-login .btn-login:hover{

  opacity: 0.9;

}

/*右边登陆框结束*/

</style>
</head>
<body id="body">
<div class='gcs-login'>

   <div class="gcs-login-panel">

<div class="login-title">

<h2>用户登陆</h2>

</div>

<div class="gcs-login-container">

  <input type="text" class="input" placeholder="请输入用户名" />

</div>

<div class="gcs-login-container">

  <input type="password"  class="input" placeholder="请输入密码"/>

</div>

<div class="gcs-login-container">

<div class="gcs-login-validation">

<input type="text"  class="input validation-input" placeholder="请输入验证码"/>

<img class="validation-img" src="../img/captcha.png" title="看不清楚？点击换一张">

</div>

</div>

<br />

<br />

<div class="gcs-login-container">

<input type="button" value="立即登录" class="btn-login" />

</div>

</div>

</div>
</body>
</html>