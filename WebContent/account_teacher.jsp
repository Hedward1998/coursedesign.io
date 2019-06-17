<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>
<script type="text/javascript">
var oldPwd;
var oldPhone;
var oldEmail;
function remAttr(){
  var btn = document.getElementById("sub");
  var password = document.getElementById("password");
  var phone = document.getElementById("phone");
  var email = document.getElementById("email");
  var changeMsg = document.getElementById("changeMessage");
  if(changeMsg.value == "修改"){
    btn.style.display = "inline";
    $("#password").removeAttr("disabled");
    $("#phone").removeAttr("disabled");
    $("#email").removeAttr("disabled");
    oldPwd = $("#password").val();
    oldPhone = $("#phone").val();
    oldEmail = $("#email").val();
    changeMsg.value = "取消";
  }else{
    btn.style.display = "none";
    password.value = oldPwd;
    phone.value = oldPhone;
    email.value = oldEmail;
    $("#password").attr("disabled","disabled");
    $("#phone").attr("disabled","disabled");
    $("#email").attr("disabled","disabled");
    changeMsg.value = "修改";
  }
}

function showPwd(){
  var pwd = document.getElementById("password");
  var show = document.getElementById("showPassword");
  if(pwd.type == "password"){
    pwd.type = "text"; 
    show.value = "隐藏密码";
  }else{
    pwd.type = "password"; 
    show.value = "显示密码";
  }
}

function checkInput(){
  if($("#password").val()=="" || $("#phone").val()=="" || $("#email").val()==""){
    alert("请将信息填写完整！");
    return false;
  }
  if($("#password").val()==oldPwd && $("#phone").val()==oldPhone && $("#email").val()==oldEmail){
    alert("未做任何修改！");
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
String phone = (String)session.getAttribute("checkPhone");
String email = (String)session.getAttribute("checkEmail");
request.getSession().setAttribute("username", username);
%>
<center>
    <form action="MessageInitServlet" method="post" onsubmit="return checkInput()" id="form">
	    <div id="f_div">
	        <table>
	            <tr>
	               <td style="text-align: center;"><h4>账号信息</h4></td>
	            </tr>
	            <tr>
	               <td>账　号：<input type="text" value="<%=username%>" disabled="disabled" name="username"/></td>
	            </tr>
	            <tr>
	               <td>密　码：<input type="password" value="<%=password%>" disabled="disabled" id="password" name="newPwd"/></td>
	            </tr>
	            <tr>
	               <td>电　话：<input type="text" value="<%=phone%>" disabled="disabled" id="phone" name="phone"/></td>
	            </tr>
	            <tr>
	               <td>邮　箱：<input type="text" value="<%=email%>" disabled="disabled" id="email" name="email"/></td>
	            </tr>
	            <tr>
	               <td><input type="hidden" value="MessageInit" name="type"/></td>
	            </tr>
	            <tr>
	               <td style="text-align: center;">
	                   <input type="button" onclick="remAttr()" value="修改" id="changeMessage"/>
	                   <input type="button" onclick="showPwd()" value="显示密码" id="showPassword"/>
	                   <input type="submit" value="确认" id="sub" style="display: none;"/>
	               </td>
	            </tr>
	        </table>
	    </div>
	</form>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>