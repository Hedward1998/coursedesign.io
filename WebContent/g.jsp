<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
    function getTime1() {
        var time;
        var day;
        var d = new Date();
        time = d.getFullYear() + '年'+ (d.getMonth()+1) + '月' + d.getDate() + '日' + d.getHours() +':' + d.getMinutes() + ':' + d.getSeconds();
        day='星期' + '天一二三四五六'.charAt(new Date().getDay());
        document.getElementById("info").innerHTML = time + ' ' + day;
    }
    
    function getTime() {
      alert("runing");
        var date = new Date();
var year = date.getFullYear() // 年
alert(year);
alert("run.");
var month = date.getMonth() + 1; // 月
var day  = date.getDate(); // 日
//var hour = date.getHours(); // 时
//var minutes = date.getMinutes(); // 分
//var seconds = date.getSeconds() //秒
//var week = '星期' + '天一二三四五六'.charAt(new Date().getDay());
var time = year +'/'+month+'/'+day;
        document.getElementById("info").innerHTML = time;
    }
                      
</script>
</head>
<body onload="getTime1()">
<%
    String name = (String)session.getAttribute("username");
%>
<center><h1>欢迎<%=name %>使用课程管理系统</h1></center>



<script>
document.write("Hello World!");
    
</script>

<span id="info"></span>
</body>

</html>