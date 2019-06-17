<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<center>
    <h4>选题情况</h4>
    <table border="1px">
        <tr>
            <td colspan="6" style="text-align: center;">选我课题的同学</td>
        </tr>
        <tr>
            <th>学　　号</th>
            <th>姓　　名</th>
            <th>院　　系</th>
            <th>专　　业</th>
            <th>年　　级</th>
            <th>课题名称</th>
        </tr>
        <c:forEach items="${list_stu1 }" var="l1">
            <tr>
                <td>${l1.sno }</td>
                <td>${l1.sname }</td>
                <td>${l1.dept }</td>
                <td>${l1.major }</td>
                <td>${l1.grade }</td>
                <td>${l1.cname }</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" style="text-align: center;">未选题同学</td>
        </tr>
        <tr>
            <th>学　　号</th>
            <th>姓　　名</th>
            <th>院　　系</th>
            <th>专　　业</th>
            <th>年　　级</th>
            <th> </th>
        </tr>
        <c:forEach items="${list_stu2 }" var="l2">
            <tr>
                <td>${l2.sno }</td>
                <td>${l2.sname }</td>
                <td>${l2.dept }</td>
                <td>${l2.major }</td>
                <td>${l2.grade }</td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
    <br/><br/>
    <h4>课题信息</h4>
    <table border="1px">
        <tr>
            <td colspan="4" style="text-align: center;">课题信息</td>
        </tr>
        <tr>
            <th>课题名称</th>
            <th>课题描述</th>
            <th>专　　业</th>
            <th>可选人数</th>
        </tr>
        <c:forEach items="${list_c }" var="l3">
            <tr>
                <td>${l3.name }</td>
                <td>${l3.describe }</td>
                <td>${l3.major }</td>
                <td>${l3.number }</td>
            </tr>
        </c:forEach>
    </table>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>