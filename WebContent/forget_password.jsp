<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forget Password</title>
<script type="text/javascript">
function checkInput(){
  if($("#username").val()=="" || $("#phone").val()=="" || $("#email").val()==""){
    alert("请将信息填写完整！");
    return false;
  }
  return true;
}

function back() {
  window.location.href = 'login.jsp';
}
</script>
</head>
<body>
<form action="forgetPasswordServlet" method="post" onsubmit="return checkInput()" id="form">
    <div id="f_div">
        <table>
            <tr>
               <td>忘记密码：</td>
            </tr>
            <tr>
               <td>账　号：<input type="text" id="username" name="username"/></td>
            <tr>
            <tr>
               <td>电　话：<input type="text"  id="phone" name="phone"/></td>
            </tr>
            <tr>
               <td>邮　箱：<input type="text" id="email" name="email"/></td>
            </tr>
            <tr>
               <td><input type="submit" value="提交"/>
               <input type="button" onclick="back()" value="取消"/></td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>