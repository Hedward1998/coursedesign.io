<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Message</title>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
  String flag = (String)session.getAttribute("flag");
%>
<script type="text/javascript">
onload = function() {
   setInterval(go,1000);
};
var x = 4;
var msg;
function go(){
   x--;
   if(x > 0){
      msg = "请稍候，" + x + "秒后自动跳转！";
      document.getElementById("show").innerHTML = msg;
   }
   else{
      if(<%=flag%> === 1)
        window.location.href = 'password_init.jsp';
      else
        window.location.href = 'message_init.jsp';
   }
}
        
</script>
<span id="show">Please wait...</span>

</body>
</html> 