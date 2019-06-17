<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>
<script type="text/javascript">
function back(){
  if(confirm("是否返回?")){
    window.location.href='show_student_self_grade.jsp';
  }
}
function checkInput(){
  if($("#usualScore").val() == "" || $("#finalScore").val() == ""  || $("#comments").val() == ""){
    alert("请将信息填写完整！");
    return false;
  }
  if(0 > $("#usualScore").val() || $("#usualScore").val() < 0 || 0 > $("#finalScore").val() || $("#finalScore").val() < 0){
    alert("请输入正确的评分！");
    return false;
  }
  if(confirm("是否提交?")){
    return true;
  }
}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
  String sno = request.getParameter("sno");
  request.getSession().setAttribute("sno", sno);
%>
<center>
    <form action="SetResultScoreServlet" method="get" onsubmit="return checkInput()">
	    <table>
	        <tr>
                <td style="text-align: center;" colspan="2"><h3>评分</h3></td>
            </tr>
            <tr>
                <td>平时成绩:</td><td><input type="text" name="usualScore" id="usualScore"/></td>
            </tr>
            <tr>
                <td><br/>考核成绩:</td><td><br/><input type="text" name="finalScore" id="finalScore"/></td>
            </tr>
            <tr>
                <td><br/>教师评语:</td><td><br/><textarea rows="3" cols="19" id="comments" name="comments"></textarea></td>
            </tr>
            <tr>
                <td>
	                <br/><input type="submit" value="确认"/>
                </td>
                <td>
                    <br/><button onclick="back()">返回</button>
                </td>
            </tr>
	    </table>
    </form>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>

