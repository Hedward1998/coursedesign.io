<%@page import="bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
    Student s = (Student)request.getSession().getAttribute("student");
    String sno = s.getSno();
    String name = s.getSname();
    String sex = s.getSex();
    int age = s.getAge();
    String dept = s.getDept();
    String major = s.getMajor();
    int grade = s.getGrade();
    int classno = s.getClassno();
%>

<center><h4>【<%=name %>】个人信息</h4>
    <table>
        <tr>
            <td>学号：</td>
            <td><input type="text" value="<%=sno %>" disabled="disabled"/></td>
        </tr><tr>
            <td>姓名：</td>
            <td><input type="text" value="<%=name %>" disabled="disabled"/></td>
        </tr><tr>
            <td>性别：</td>
            <td><input type="text" value="<%=sex %>" disabled="disabled"/></td>
        </tr><tr>
            <td>年龄：</td>
            <td><input type="text" value="<%=age %>" disabled="disabled"/></td>
        </tr><tr>
            <td>学院：</td>
            <td><input type="text" value="<%=dept %>" disabled="disabled"/></td>
        </tr><tr>
            <td>专业：</td>
            <td><input type="text" value="<%=major %>" disabled="disabled"/></td>
        </tr><tr>
            <td>年级：</td>
            <td><input type="text" value="<%=grade %>" disabled="disabled"/></td>
        </tr><tr>
            <td>班级：</td>
            <td><input type="text" value="<%=classno %>" disabled="disabled"/></td>
        </tr>
    </table>
</center>

</body>
</html>