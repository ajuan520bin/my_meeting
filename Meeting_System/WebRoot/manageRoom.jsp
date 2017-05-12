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
		<script src="js/jquery-1.10.2.min.js">
</script>
		<script src="js/amcharts.js">
</script>
		<script src="js/serial.js">
</script>
		<script src="js/light.js">
</script>
		<script src="js/radar.js">
</script>
		<link href="css/barChart.css" rel='stylesheet' type='text/css' />
		<link href="css/fabochart.css" rel='stylesheet' type='text/css' />
		<!--clock init-->
		<script src="js/css3clock.js">
</script>
		<!--Easy Pie Chart-->
		<!--skycons-icons-->
		<script src="js/skycons.js">
</script>

		<script src="js/jquery.easydropdown.js">
</script>

<script type="text/javascript">
function del(id){
  if(confirm("确认删除？")){
     location.href="deleteRoom?id="+id;
  }
}
</script>
<style type="text/css">
.btn{
  
     background: #002561; 
     color:#fff;
     width:80px;
    font-size:10px;
    
}

</style>
		<%
			MeetingRoomDao mr = new MeetingRoomDao();
			List<Meetingroom> mrs = mr.selectMeetingrooms();
		%>
		<!--//skycons-icons-->
	</head>
	<body>

		<!-- //header-ends -->
		<div class="outter-wp">
			<!--custom-widgets-->
			<div class="custom-widgets"></div>
			<!--//custom-widgets-->
			<!--/candile-->
			<!--div class="candile"-->
			<div class="sub-heard-part">
				<ol class="breadcrumb m-b-0">
					<li>
						<a href="index.html">Home</a>
					</li>
					<li class="active">
						会议室管理
					</li>
				</ol>
				<h2 class="inner-tittle">
					会议室管理
				</h2>
			</div>
			<form action="AddRoom" methon="post">
				<table class="table">
					<tr class="success">
						<td>
							房号
						</td>
						<td>
							名称
						</td>
						<td>
							可容纳人
						</td>
						<td>
							状态
						</td>
						<td>
							具体信息
						</td>
						<td colspan="2">
							操作
						</td>

					</tr>
					<tr class="info">
					</tr>
					<tr class="success">
						<td>
							<input type="text" name="num" />
						</td>
						<td>
							<input type="text" name="name" />
						</td>
						<td>
							<input type="text" name="capacity" />
						</td>
						<td>
							<input type="text" name="status" />
						</td>
						<td>
							<input type="text" name="description" />
						</td>
						<td colspan="2">
							<input type="submit" value="    增   加       " />
						</td>
					</tr>
				</table>
			</form>
			<hr />

			<table class="table">
				<tr class="success">
					<td>
						房号
					</td>
					<td>
						名称
					</td>
					<td>
						可容纳人
					</td>
					<td>
						是否可用
					</td>
					<td>
						具体信息
					</td>
					<td colspan="2">
						操作
					</td>

				</tr>
				<tr class="info">
				</tr>



				<%
					int i = 0;
					String tt = "";
				%>
				<%
					for (int j = 0; j < mrs.size(); j++) {
				%>

				<%
					i++;
						int temp = i % 4;
						if (temp == 0) {
							tt = "active";
						} else if (temp == 1) {
							tt = "info";
						} else if (temp == 2) {
							tt = "warning";
						} else if (temp == 3) {
							tt = "danger";
						} else if (temp == 4) {
							tt = "success";
						}
				%>
				<tr class=<%=tt%>>
					<td><%=mrs.get(j).getRoomnum()%></td>
					<td><%=mrs.get(j).getRoomname()%></td>
					<td><%=mrs.get(j).getCapacity()%></td>
					<td><%=mrs.get(j).getStatus()%></td>
					<td><%=mrs.get(j).getDescription()%></td>
					<td>
						<input type="button" value="删除" class="btn"
							onclick="del(<%=mrs.get(j).getRoomid()%>)" />
					</td>
					<td>
						<input type="button" value="修改" class="btn"
							onclick="location.href='modifyRoom.jsp?id=<%=mrs.get(j).getRoomid()%>'" />
					</td>
					<!-- <td><a href="JumpToOrderServlet?roomid=${emp.roomid}">选择</a></td> -->
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</body>
</html>