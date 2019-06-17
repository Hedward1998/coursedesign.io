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
    <table border="1px" id="a">
        <tr>
            <td colspan="9" style="text-align: center;">评分</td>
        </tr>
        <tr>
            <th>学　　号</th>
            <th>姓　　名</th>
            <th>专　　业</th>
            <th>课程名称</th>
            <th>成　　果</th>
            <th>签到分数</th>
            <th>自评分数</th>
            <th>自评评价</th>
            <th>评　　分</th>
        </tr>
        <c:forEach items="${list_score }" var="l">
            <tr>
                <td>${l.sno }</td>
                <td>${l.sname }</td>
                <td>${l.major }</td>
                <td>${l.cname }</td>
                <td>
                    <c:url value="DownloadResultFileServlet" var="downurl">
                        <c:param name="filename" value="${l.fpath }"></c:param>
                    </c:url>
                    <a href="${downurl }">${l.filename }</a>
                </td>
                <td>${l.signScore }</td>
                <td>${l.selfScore }</td>
                <td>${l.selfComments }</td>
                <td>
                    <c:url value="set_result_score.jsp" var="setScore">
                        <c:param name="sno" value="${l.sno }"></c:param>
                    </c:url>
                    <a href="${setScore }">评　　分</a>
                </td>
            </tr>
        </c:forEach>
     </table>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>