<%@page import="bean.Sign"%>
<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
#chooseTime{
    text-align: center;
}
</style>
<script type="text/javascript">
function check(){
  var time = $("#choose_time").val();
  window.location.href = 'SelectSignServlet?choose_time=' + time;
}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
  String timeSign = (String)request.getSession().getAttribute("timeSign");
%>
<center>
    <h4>考勤管理</h4>
    <div id="chooseTime">
	    <%-- <font color="green">请选择时间:</font>
	    <input type="text" onclick="WdatePicker()" readonly="readonly" name="time" id="time"/>
	    --%>
	    
        <input type="date"  value="2019-05-13" min="2019-05-13" max="2019-05-17" id="choose_time"/>
	    <button id="check" onclick="check()">确认</button>
	    <br/><br/>
    </div>
</center>
<center>
	    <table border="1px">
	        <tr>
	            <td colspan="4" style="text-align: center;"><h4><%=timeSign %>签到情况</h4></td>
	        </tr>
	        <tr>
	            <th>学　　号</th>
	            <th>姓　　名</th>
	            <th>签到情况</th>
	            <th>签退情况</th>
	        </tr>
	        <c:forEach items="${list_sign }" var="l">
	            <tr>
	                <td>${l.sno }</td>
	                <td>${l.sname }</td>
	                <td>${l.signInStatus }</td>
	                <td>${l.signOutStatus }</td>
	            </tr>
	        </c:forEach>
	    </table>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>