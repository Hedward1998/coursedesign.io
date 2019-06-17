<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
    <center>
        <form action="ChooseCourseServlet" method="get" id="form">
	        <table border="1px">
	           <tr>
	               <td colspan="6" style="text-align: center;"><h4>选题</h4></td>
	           </tr>
	           <tr>
	               <th>选　　择</th>
                   <th>课程名称</th>
                   <th>课程描述</th>
                   <th>教师名称</th>
                   <th>可选人数</th>
                   <th>课程文件</th>
	           </tr>
	           <c:forEach items="${list }" var="l">
	               <tr>
	                   <td>
	                       <input type="radio" name="radio1" value="${l.cno }"/>
	                   </td>
	                   <td>${l.name }</td>
                       <td>${l.describe }</td>
                       <td>${l.tname }</td>
                       <td>${l.number }</td>
                       <td>
                            <c:url value="DownLoadCourseFile" var="downurl">
                                <c:param name="filename" value="${l.fpath }"></c:param>
                            </c:url>
                            <a href="${downurl }">${l.filename }</a><br/>
                       </td>
	               </tr>
	           </c:forEach>
	        </table>
	        <input type="submit" value="选课" />
        </form>
    </center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>