<%@page import="bean.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
    Teacher t = (Teacher)request.getSession().getAttribute("teacher");
    String tno = t.getTno();
    String name = t.getTname();
    String sex = t.getSex();
    String title = t.getTitle();
%>

<center><h4>【<%=name %>】个人信息</h4>
    <table>
        <tr>
            <td>教师号：</td>
            <td><input type="text" value="<%=tno %>" disabled="disabled"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" value="<%=name %>" disabled="disabled"/></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="text" value="<%=sex %>" disabled="disabled"/></td>
        </tr>
        <tr>
            <td>职称：</td>
            <td><input type="text" value="<%=name %>" disabled="disabled"/></td>
        </tr>
    </table>
</center>
</body>
</html>