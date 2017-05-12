<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.wllman.util.*,com.wllman.dao.*,com.wllman.vo.*,java.util.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/amcharts.js"></script>
<script src="js/serial.js"></script>
<script src="js/light.js"></script>
<script src="js/radar.js"></script>
<link href="css/barChart.css" rel='stylesheet' type='text/css' />
<link href="css/fabochart.css" rel='stylesheet' type='text/css' />
<!--clock init-->
<script src="js/css3clock.js"></script>
<!--Easy Pie Chart-->
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<script src="js/jquery.easydropdown.js"></script>
<!--//skycons-icons-->
<style type="text/css">
.content{
  margin:80px;
  padding:30px;
}

.btn{
  
     background: #00C6D7; 
     color:#fff;
     width:80px;
    font-size:10px;
    float:right;
    
}

</style>
</head>
<%
   MessageDao md=new MessageDao();
   List<Message> ms=md.selectMessageByAcceptid(13);
   int mesid=Integer.parseInt(request.getParameter("id"));
   String message=md.getMessageById(mesid);
   md.changeStatus(mesid);
 %>
<body>
        <div class="content">
		<%=message %>	
	    </div>  
	    <hr/>   
	    <input type="button" value="返回"  class="btn" onclick="location.href='message.jsp'" />	
</body>
</html>