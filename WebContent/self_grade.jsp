<%@page import="bean.Sc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function checkInput(){
  if($("#score").val() == "" || $("#comments").val() == ""){
    alert("请将信息填写完整！");
    return false;
  }
  if(0 > $("#score").val() || $("#score").val() < 0){
    alert("请输入正确的自评分数！");
    return false;
  }
  return true;
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
  //提取信息显示
  Sc sc = (Sc)request.getSession().getAttribute("scResult");
  String cname = sc.getCname();
  String cdescribe = sc.getCdescribe();
  String tname = sc.getTname();
  String filename = sc.getFilename();
  String fpath = sc.getFpath();
  
%>
<center>
    <h4>成绩自评</h4>
    <form action="SelfGradeServlet" method="get" onsubmit="return checkInput()">
        <table border="1px">
	        <tr>
	            <th>课程名</th>
	            <th>课程描述</th>
	            <th>教师名</th>
	            <th>文件名</th>
	        </tr>
	        <tr>
	            <td><%=cname %></td>
	            <td><%=cdescribe %></td>
	            <td><%=tname %></td>
	            <td>
	                <c:url value="DownloadResultFileServlet" var="downurl">
	                    <c:param name="filename" value="<%=fpath %>"></c:param>
	                </c:url>
	                <a href="${downurl }"><%=filename %></a>
	            </td>
	        </tr>
        </table><br/>
       你的自评分数：<input type="text" name="score" id="score"/><br/><br/>
             你的自评评语：<textarea rows="3" cols="22" id="comments" name="comments"></textarea><br/><br/>
        <input type="submit"  value="确认"/>
    </form>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>