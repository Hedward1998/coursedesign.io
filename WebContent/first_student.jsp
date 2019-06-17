<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
    String name = (String)session.getAttribute("name");
%>
<center><h1>欢迎<%=name %>使用课程设计管理系统</h1></center>

</body>
</html>