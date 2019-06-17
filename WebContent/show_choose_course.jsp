<%@page import="bean.Sc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
<script type="text/javascript">
function cancel(){
  if(confirm("是否退选？")){
    window.location.href = 'CancelCourseServlet?type='+"cancelCourse";
  }
}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
    Sc sc = (Sc)request.getSession().getAttribute("sc");
	String cname = sc.getCname();
	String cdescribe = sc.getCdescribe();
	String tname = sc.getTname();
	String filename = sc.getFilename();
	String fpath = sc.getFpath();
%>
<center>
    <h4>你的课程设计选题情况：</h4>
    <table border="1px">
         <tr>
              <th>课程名称</th>
              <th>课程描述</th>
              <th>教师名称</th>
              <th>课程文件</th>
              <th>　　　　</th>
         </tr>
         <tr>
              <td><%=cname %></td>
              <td><%=cdescribe %></td>
              <td><%=tname %></td>
              <td>
                  <c:url value="DownLoadCourseFile" var="downurl">
                      <c:param name="filename" value="<%=fpath %>"></c:param>
                  </c:url>
                  <a href="${downurl }"><%=filename %></a>
              </td>
              <td><button id="quit" onclick="cancel()">退选</button></td>
         </tr>
     </table>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>