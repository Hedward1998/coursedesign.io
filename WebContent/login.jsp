<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
    html{
        height: 100%;
    }
    #body{
        padding: 0;
        margin: 0;
        background: url('img/login.jpg');
        background-size: 100% 100%;/*加了是全页面缩放图片；不加是缩小窗口，显示部分图片*/
    }
    
    *{/*清除默认边距，初始化*/
        padding: 0;
        margin: 0;
        font-family: "微软雅黑";
    }
    
    .login-div{
        position: absolute;
        width: 400px;
        height: 380px;
        right: 50%;
        top: 50%;
        margin-right: -235px;
        margin-top: -200px;
        box-sizing: border-box;
        opacity: 0.8;
        background-color: #E6E6E6;
        z-index: 100;
    }
    
    .login-div .login-div-panel{
        height: 360px;
        position: absolute;
        margin: auto;
        left: 0;
        right: 0;
        top: 0;
        bottom: 0;
    }
    
    .login-div .login-title {
        text-align: center;
        color: #62A8EA;
    }
    
    .login-div .login-title h2{
        letter-spacing: 10px; 
    }
    
    .login-container{
        width: 100%;
        box-sizing: border-box;
        width: 100%;
        margin: 30px 0 0;
        text-align: center;
    }
    
    .login-div .input{
        border: 1px solid white;
        display: inline-block;
        box-sizing: border-box;
        width: 80%;
        height: 46px;
        padding-left: 10px;
        margin: 0 auto;
        font-size: 14px;
        outline: none;
        color: #76838F;
    }
    
    .login-div .login-validation{
        width: 80%;
        margin: 0 auto;
        position: relative;
    }
    
    .login-div .validation-input{
        position: absolute;
        width: 224px;
        left: 0px;
    }
    
    .login-div img.validation-img{
        position: absolute;
        width: 96px;
        cursor: pointer;
        height: 46px;
        right: 0px;
    }
    
    .login-div .input:FOCUS {
        outline: none;
        border: 1px solid #62A8EA;
    }
    
    .login-div .btn-login{
        background-color: #62A8EA;
        border: none;
        width: 40%;
        height: 45px;
        line-height: 45px;
        color: white;
        cursor: pointer;
        font-size: 16px;
        font-weight: bold;
    }
    
    .login-div .btn-forget{
        background-color: #62A8EA;
        border: none;
        width: 40%;
        height: 45px;
        line-height: 45px;
        color: white;
        cursor: pointer;
        font-size: 16px;
        font-weight: bold;
    }
    
    .login-div .btn-login:HOVER {
        opacity: 0.9;
    }
    
    .login-div .btn-forget:HOVER {
        opacity: 0.9;
    }
    
</style>
<script type="text/javascript">
    function checkInput() {
      if($("#username").val()==""){
        alert("账号不能为空！");
        return false;
      }
      if($("#password").val()==""){
        alert("密码不能为空！");
        return false;
      }
      if($("#code").val()==""){
        alert("验证码不能为空！");
        return false;
      }
      return true;
    }
    
    function fun() {
      var password = document.getElementById("password").value;
      $("#form").submit();
    }
    
    function turn() {
      document.getElementById("img").src = "ImageServlet?nocache=" + new Date().getTime();
    }
    
    function forgetPassword() {
      if(confirm("忘记密码？")){
        window.location.href = 'forget-password.jsp';
      }
    }
</script>
</head>
<body id="body">
<div class="login-div">
    <div class="login-div-panel">
        <form action="LoginServlet" method="post" onsubmit="return checkInput()" id="from">
            <div class="login-title">
                <h2>用户登录</h2>
            </div>
            <div class="login-container">
                <input type="text" class="input" id="uername" name="username" placeholder="请输入用户名"/>
            </div>
            <div class="login-container">
                <input type="password" class="input" id="password" name="password" value = "${password }" placeholder="请输入密码"/>
            </div>
            <div class="login-container">
                <div class="login-validation">
                    <input type="text" class="input validation-input" id="code" name="code" placeholder="请输入验证码"/>
                    <img alt="加载失败" class="validation-img" src="ImageServlet" title="点击刷新" onclick="turn()" id="img"/>
                </div>
            </div>
            <br/>
            <br/>
            <div class="login-container">
                <input type="submit" class="btn-login" value="登　录" />
                <input type="button" class="btn-forget" onclick="forgetPassword()" value="忘记密码">
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>