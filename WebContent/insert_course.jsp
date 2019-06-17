<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_teacher.jsp" flush="true"></jsp:include>
<script type="text/javascript">
function checkInput(){
  if($("#cName").val() == "" || $("#major").val() == "" || $("#cNumber").val() ==""){
    alert("请将信息填写完整！");
    return false;
  }
  return true;
}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<%
  String tno =  (String)session.getAttribute("username");
  request.getSession().setAttribute("tno", tno);
%>
<center>
    <form action="InsertCourseServlet" method="post" onsubmit="return checkInput()">
	  <table>
	        <tr>
               <td style="text-align: center;" colspan="2"><h4>发布课题</h4></td>
            </tr>
            <tr>
               <td>课题名称：</td><td><input type="text" id="cName" name="cName"/></td>
            </tr>
            <tr>
               <td>课题描述：</td><td colspan="3"><textarea rows="3" cols="19" id="cDescribe" name="cDescribe"></textarea></td>
            </tr>
            <tr>
               <td>专　　业：</td><td><input type="text" id="major" name="major"/></td>
            </tr>
            <tr>
               <td>限选人数：</td><td><input type="text" id="cNumber" name="cNumber"/><br/></td>
            </tr>
            <tr>
               <td>
                  <input type="hidden" value="InsertCourse" name="type"/><br/>
               </td>
            </tr>
            <tr>
               <td colspan="2" style="text-align: center;"><input type="submit" value="确认"/><br/></td>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>