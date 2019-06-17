<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>

<style type="text/css">
 #a{
 }
</style>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<center>
    <table border="1px" id="a">
        <tr>
            <td colspan="7" style="text-align: center;">已提交成果学生信息</td>
        </tr>
        <tr>
            <th>课程名称</th>
            <th>课程描述</th>
            <th>学　　号</th>
            <th>姓　　名</th>
            <th>专　　业</th>
            <th>成　　果</th>
            <th>上传时间</th>
        </tr>
        <c:forEach items="${list1 }" var="l1">
            <tr>
                <td>${l1.cname }</td>
                <td>${l1.cdescribe }</td>
                <td>${l1.sno }</td>
                <td>${l1.sname }</td>
                <td>${l1.major }</td>
                <td>
                    <c:url value="DownloadResultFileServlet" var="downurl">
                        <c:param name="filename" value="${l1.fpath }"></c:param>
                    </c:url>
                    <a href="${downurl }">${l1.filename }</a>
                </td>
                <td>${l1.uploadTime }</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" style="text-align: center;">未提交成果学生信息</td>
        </tr>
        <tr>
            <th>课程名称</th>
            <th>课程描述</th>
            <th>学　　号</th>
            <th>姓　　名</th>
            <th>专　　业</th>
            <th> </th>
            <th> </th>
        </tr>
        <c:forEach items="${list2 }" var="l2">
            <tr>
                <td>${l2.cname }</td>
                <td>${l2.cdescribe }</td>
                <td>${l2.sno }</td>
                <td>${l2.sname }</td>
                <td>${l2.major }</td>
                <td> </td>
                <td> </td>
            </tr>
        </c:forEach>
    </table>
        
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>