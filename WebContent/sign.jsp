<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head_student.jsp" flush="true"></jsp:include>
<style type="text/css">
    #sign{
         margin-left: 50px; 
    }
</style>
<script type="text/javascript">
var d;
var year;
var month;
var day;
var hours;
var minutes;

function getT(){
  d = new Date();
  year = d.getFullYear();
  month = d.getMonth() + 1;
  day = d.getDate();
  hours = d.getHours();
  minutes = d.getMinutes();
  if(hours < 10)
    hours = "0" + hours;
  if(minutes < 10)
    minutes = "0" + minutes;
  document.getElementById('msg').innerHTML = '';
  
}

//课程设计时间:2019-5-13 --- 2019-5-17
/*
 idea1:把课程设计时间，上课时间通过变量设置出来，通过老师指定时间；
 时间处理方式:hh:mm ---> hhmm  比较大小 判断是否在签到时间区间内
 
时间：
08:00 ---> 0800
08:04 ---> 0804 正常
08:16 ---> 0816 迟到
08:20 ---> 0820

18:20 ---> 1820
18:26 ---> 1826 早退 
18:35 ---> 1835 正常
18:40 ---> 1840

8:00--8:05    8:06-- 8:20   15:00--15:05  15:06--15:20
11:30--11:45  11:46--11:50  18:20--18:35  18:36--18:40
*/



function signIn(){//在签到时间，按钮触发跳转SignServlet，不在提示信息
  if(year == 2019 && month == 5 && 13 <= day && day <= 17){
    if(hours == 8 || hours == 15){
      if(0 <= minutes && minutes <= 20){
        document.getElementById('msg').innerHTML = '正在签到...';
        window.location.href = 'SignServlet?signType=' + "signIn";
      }else
        alert("未在签到时间！");
    }else
      alert("未在签到时间！");
  }else{
    alert("未在课程设计时间！");
  }
}

function signOut(){
  if(year == 2019 && month == 5 && 13 <= day && day <= 17){
    if((hours == 11 && 30 <= minutes && minutes <= 50) || (hours == 18 && 20 <= minutes && minutes <= 40)){
      document.getElementById('msg').innerHTML = '正在签退...';
      window.location.href = 'SignServlet?signType=' + "signOut";//传递signType参数
    }
    else
      alert("未在签退时间！");
  }else{
    alert("未在课程设计时间！");
  }
}

window.onload = function(){getT();}
</script>
</head>
<body style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
<div style="text-align: center;">
    <pre style="font-family: '宋体';font-size: 15px;background-color: #d9edf7;">
	友情提示
	签到时间： 8:00-- 8:20  15:00--15:20
	签退时间：11:30--11:50  18:20--18:40
	(签到时间开始5分钟后，签到将被视为迟到；
	 签退时间结束5分钟前，签退将被视为早退！)
	</pre>
	<div id="sign">
	<button onclick="signIn()" id="sign_in">签到</button>&nbsp;&nbsp;&nbsp;
	<button onclick="signOut()" id="sign_out">签退</button>
	</div>
</div>
<span id="msg"></span>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
