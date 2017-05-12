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

function check() {
	if (confirm("确认修改？")) {
         return true;
	}
	return false;
}

</script>
		<%
			MeetingRoomDao mrd = new MeetingRoomDao();
			int id = Integer.parseInt((String) request.getParameter("id"));
			List<Meetingroom> mr = mrd.selectOneRoom(id);
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

			<form name="myform" action="modifyRoom" onsubmit="return check()"
				method="post">
				<table class="table">
					<tr class="success">
						<td>
							房间号
						</td>
						<td>
							会议室名称
						</td>
						<td>
							可容纳人数
						</td>
						<td>
							是否可用
						</td>
						<td>
							具体描述
						</td>

						<td colspan="2">
							修改
						</td>
					</tr>
					<tr>
						<input type="hidden" name="id" value=<%=mr.get(0).getRoomid()%> />
						<td>
							<input type="text" name="num" value=<%=mr.get(0).getRoomnum()%> />
						</td>
						<td>
							<input type="text" name="name"
								value=<%=mr.get(0).getRoomname()%> />
						</td>
						<td>
							<input type="text" name="capacity"
								value=<%=mr.get(0).getCapacity()%> />
						</td>
						<td>
							<input type="text" name="status"
								value=<%=mr.get(0).getStatus()%> />
						</td>
						<td>
							<input type="text" name="description"
								value=<%=mr.get(0).getDescription()%> />
						</td>
						<td>
							<input type="submit" value="确认修改"
								 />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>