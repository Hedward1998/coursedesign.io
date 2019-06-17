<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
<script type="text/javascript">
function checkInput(){
  if($("#file").val() == null || $("#file").val() == ""){
    alert("请上传课题文件！");
    return false;
  }
  return true;
}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<center>
    <form action="UploadResultServlet" method="post" enctype="multipart/form-data" onsubmit="return checkInput()">
        <table>
            <tr>
               <td style="text-align: center;"><h4>上传课程设计成果文件</h4></td>
            </tr>
            <tr>
               <td><br/><input type="file" id="file" name="file"/><br/></td>
            </tr>
            <tr>
               <td><input type="hidden" value="uploadStudent" name="type"/></td>
            </tr>
            <tr>
               <td><input type="submit" value="确认"/></td>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>