<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新密码</title>
<style type="text/css">
    .f_div{
        text-align: center;
    }
</style>
<script type="text/javascript">
function checkInput(){
  var password = document.getElementById("oldPwd").value;
  if($("#newPwd").val()=="" || $("#surePwd").val()==""){
    alert("请将信息填写完整！");
    return false;h
  }
  if($("#newPwd").val() != $("#surePwd").val()){
    alert("两次输入的密码不一致！");
    return false;
  }
  if($("#newPwd").val() == password){
    alert("不能和原密码一致！");
    return false;
  }
  return true;
}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
String username = (String)session.getAttribute("checkName");
String password = (String)session.getAttribute("checkPwd");
%>
<form action="MessageInitServlet" method="post" onsubmit="return checkInput()" id="form">
    <div id="f_div">
        <table>
            <tr>
               <td>更新密码：</td>
            </tr>
            <tr>
               <td>账　号：<input type="text" value="<%=username%>" disabled="disabled" name="username"/></td>
            <tr>
            <tr>
               <td>旧密码：<input type="text" value="<%=password%>" disabled="disabled" id="oldPwd"/></td>
            </tr>
            <tr>
               <td>新密码：<input type="password" id="newPwd" name="newPwd"/></td>
            </tr>
            <tr>
               <td>请确认：<input type="password" id="surePwd"/></td>
            </tr>
            <tr>
               <td><input type="hidden" value="PasswordInit" name="type"/></td>
            </tr>
            <tr>
               <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>