<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>学生模式</title>
<style type="text/css">
  #div_top{
    background-color: #D0D0D0;
    position: relative;
    height: 150px;
    background: url("img/top.png") no-repeat;
    background-size: 100% 150px;
  }
  #showMsg{
    margin-left: auto;
    margin-right: 5px;
    text-align: right;
    width: 200px;
    margin-top: 70px;
    float: right;
    font-size: 15px;
    color: #f5f5f5;
  }
  #top{
    width: 600px;
    position: absolute;
    display: block;
    text-align: center;
    left: 50%;
    margin-left: -235px;
    margin-top: 30px;
    font-family: "华文行楷";
  }
  
  .dropdown-menu > li > a {
    font-family: "宋体";
    font-size: 18px;
  }
</style>
<script type="text/javascript">
function getTime() {
  var time;
  var week;
  var d = new Date();
  var year = d.getFullYear();
  var month = d.getMonth() + 1;
  var day = d.getDate();
  var hours = d.getHours();
  var minutes = d.getMinutes();
  var seconds = d.getSeconds();
  if(hours < 10)
    hours = "0" + hours;
  if(minutes < 10)
    minutes = "0" + minutes;
  if(seconds < 10)
    seconds = "0" +seconds;
  time = year + '年'+ month + '月' + day + '日' + hours +':' + minutes + ':' + seconds;
  week='星期' + '天一二三四五六'.charAt(new Date().getDay());
  document.getElementById("datetime").innerHTML = time;
  document.getElementById("week").innerHTML = week;
  
  $(function () {
    $(".dropdown").mouseover(function () {
        $(this).addClass("open");
    });

    $(".dropdown").mouseleave(function(){
        $(this).removeClass("open");
    });
  })
}
setInterval("getTime()", 500);



function sure() {
  if(confirm("是否注销？")){
    window.location.href = 'login.jsp';
  }
}
window.onload = function(){getTime();}
</script>
</head>
<body>
<%
  String name = (String)session.getAttribute("name");
  String account = (String)session.getAttribute("username");
%>
<div id="div_top" >
    <div id="top"><h1 style="font-size: 45px;">攀枝花学院课程设计管理系统</h1></div>
    <div id="showMsg">
	  <div id="datetime"></div>
      <div id="week"></div>
           学生：[<%=account %>]<%=name %><br/>
      <a id="quit" onclick="sure()" style="color: #f5f5f5;">注销</a>
    </div>
</div>
<div class="collapse navbar-collapse" style="text-align: center;background-color: rgb(204, 204, 204);font-family: '宋体';font-size: 18px;" id="menu">
    <ul class="nav nav-tabs" style="display: inline-block;float: none">
        <li class="active"><a style="background-color: rgb(204, 204, 204);" href="first_student.jsp" >首页</a></li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人信息 <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="account_student.jsp">账号信息</a></li>
                <li class="divider"></li>
                <li><a href="ShowBasicMessageServlet">基本信息</a></li>
                <li class="divider"></li>
            </ul>
        </li>
        <li><a href="sign.jsp">签到</a></li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">课题 <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="ShowCourseServlet">选题</a></li>
                <li class="divider"></li>
                <li><a href="CancelCourseServlet">查看结果</a></li>
                <li class="divider"></li>
            </ul>
        </li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">成果 <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="SelectIsChooseCourseServlet">成果上传</a></li>
                <li class="divider"></li>
                <li><a href="CheckResultServlet">成绩自评</a></li>
                <li class="divider"></li>
                <li><a href="ShowScoreServlet">成绩查看</a></li>
                <li class="divider"></li>
            </ul>
        </li>
    </ul>
 </div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>