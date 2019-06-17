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
    <table border="1px">
        <tr>
            <td colspan="12" style="text-align: center;"><h3>查看成绩</h3></td>
        </tr>
        <tr>
            <th>学　　号</th>
            <th>姓　　名</th>
            <th>院　　系</th>
            <th>专　　业</th>
            <th>课程名称</th>
            <th>签到分数</th>
            <th>自评分数</th>
            <th>自评评价</th>
            <th>教师评价</th>
            <th>平时成绩</th>
            <th>考核成绩</th>
            <th>最终成绩</th>
        </tr>
        <c:forEach items="${list_stuScore }" var="l">
            <tr>
                <td>${l.sno }</td>
                <td>${l.sname }</td>
                <td>${l.dept }</td>
                <td>${l.major }</td>
                <td>${l.cname }</td>
                <td>${l.signScore }</td>
                <td>${l.selfScore }</td>
                <td>${l.selfComments }</td>
                <td>${l.comments }</td>
                <td>${l.usualScore }</td>
                <td>${l.finalScore }</td>
                <td>${l.score }</td>
            </tr>
        </c:forEach>
     </table>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>