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

		<style type="text/css">
.cell {
	width: 150px;
}

.btn{
   width:150px;
}
</style>

<script language="javascript">
function is_leap(year) {
	return (year % 100 == 0 ? res = (year % 400 == 0 ? 1 : 0)
			: res = (year % 4 == 0 ? 1 : 0));
} //是否为闰年

function nextmonth(){
 ynow=document.getElementById('month')-1;

}
function getinfo(id){
 
   var starttime=ynow+"-"+mnow+"-"+dnow+" 00:00:00";
   var endtime=ynow+"-"+mnow+"-"+dnow+" 23:59:59";
}
function premonth(){
alert("te");
}
var nstr = new Date(); //当前Date资讯
var ynow = nstr.getFullYear(); //年份
var mnow = nstr.getMonth(); //月份
var dnow = nstr.getDate(); //今日日期
var n1str = new Date(ynow, mnow, 1); //当月第一天Date资讯
var firstday = n1str.getDay(); //当月第一天星期几
var m_days = new Array(31, 28 + is_leap(ynow), 31, 30, 31, 30, 31, 31, 30, 31,
		30, 31); //各月份的总天数
var tr_str = Math.ceil((m_days[mnow] + firstday) / 7); //表格所需要行数


document.write("<input type='button'  value='上一月' onclick='premonth()'/>");
document.write("<input type='button' id='ynow' value="+ynow+ "' />");
document.write("<div id='month' class='btn' "+">"+mnow+"</div>"+"&nbsp");
document.write("<div id='day' "+">"+dnow+"</div>"+"&nbsp");
document.write("<input type='button' value='下一月' onclick='nextmonth()'/>");


//打印表格第一行（有星期标志）
document.write("<table border='1' align='center' width='220' cellspacing='0'><tr><td align='center'>日</td><td align='center'>一</td><td align='center'>二</td><td align='center'>三</td><td align='center'>四</td><td align='center'>五</td><td align='center'>六</td></tr>");

for (i = 0; i < tr_str; i++) { //表格的行
	document.write("<tr class='cell'>");
	for (k = 0; k < 7; k++) { //表格每行的单元格
		idx = i * 7 + k; //单元格自然序列号
		date_str = idx - firstday + 1; //计算日期
		(date_str <= 0 || date_str > m_days[mnow]) ? date_str = "&nbsp;"
				: date_str = idx - firstday + 1; 
		document.write("<td>" + "<input type='button' id="+date_str+" "+"value=" + date_str
				+ " onclick='getinfo(this.id)' />" + "</td>");
	}
	document.write("</tr>"); //表格的行结束
}
document.write("</table>");

//表格结束
</script>
	</head>
	<body>

	</body>
</html>