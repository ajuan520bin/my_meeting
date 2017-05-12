<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.wllman.util.*,com.wllman.dao.*,com.wllman.vo.*,java.util.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	 <style type="text/css">
  
  /* 整体设置 */
*{margin:0px;padding:0px;}
 
/**
 * 设置日历的大小
 */
.calendar{
  width: 240px;
  height: 400px;
  display: block;
  margin:30px;
  padding:50px;
  display:inline;
  
}

.box{
  border:1px solid #000;
  width: 740px;
  height: 800px;
  margin-left:80px;
  margin-top:20px;
}
.content{
  color:#000;
  width: 500px;
  height: 400px;
  margin:30px;
 
}
 
/**
 * 设置日历顶部盒子
 */
.calendar .calendar-title-box{
  position: relative;
  width: 100%;
  height: 36px;
  line-height: 36px;
  text-align:center;
  border-bottom: 1px solid #ddd;
}
 
/**
 * 设置上个月的按钮图标
 */
.calendar .prev-month {
  position: absolute;
  top: 12px;
  left: 0px;
  display: inline-block;
  width: 0px;
  height: 0px;
  border-left: 0px;
  border-top: 6px solid transparent;
  border-right: 8px solid #999;
  border-bottom: 6px solid transparent;
  cursor: pointer;
}
 
/**
 * 设置下个月的按钮图标
 */
.calendar .next-month {
  position: absolute;
  top: 12px;
  right: 0px;
  display: inline-block;
  width: 0px;
  height: 0px;
  border-right: 0px;
  border-top: 6px solid transparent;
  border-left: 8px solid #999;
  border-bottom: 6px solid transparent;
  cursor: pointer;
}
 
 
/* 设置日历表格样式 */
.calendar-table{
  width: 100%;
  border-collapse: collapse;
  text-align:center;
}
 
/* 表格行高 */
.calendar-table tr{
  height: 30px;
  line-height: 30px;
}
 
/* 当前天 颜色特殊显示 */
.currentDay {
  color: #fff;
  background:#D9EDF7;
}

.currentDay:hover{

   background:#F2DEDE;
}

th{
color:#00CAE0;
}
 
/* 本月 文字颜色 */
.currentMonth {
  color: #fff;
}
 
/* 其他月颜色 */
.otherMonth{
  color: #ede;
}

.btn{
     background-color: Transparent; 
     border-style: none;    
     outline: none;    
}

.btn:hover{
     color:  #00CAE0
}
  
  </style>
  
		<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!-- Bootstrap Core CSS -->
		
	
		<!-- Bootstrap Core CSS -->
	    
	
</head>
	<body>
 
			<p><b><pre>     会议室使用情况</pre></b></p><br/>
			<p><pre>             会议室月视图</pre></p>
   <div class='box'>
  <div class='calendar' id='calendar'></div>
  <div class='content' name='content'></div>
   </div>
 <script src="js/test.js"></script>
	
	</body>
</html>



