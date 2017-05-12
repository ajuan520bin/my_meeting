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
	<%
			MeetingRoomDao mrd = new MeetingRoomDao();
			List<Meetingroom> mrs = mrd.selectMeetingrooms();
			session.setAttribute("rooms", mrs);
		%>
<!--//skycons-icons-->
</head>
<body>
						<%
						String date=(String)session.getAttribute("date");
						//System.out.println("sss"+date);
						
						 %>
						 	</form>
			<div class="graph">
				<table class="table">

					<tr class="success">
						<td>
							会议室
						</td>
						<td>
							9:00-10:00
						</td>
						<td>
							10:00-11:00
						</td>
						<td>
							11:00-12:00
						</td>
						<td>
							13:00-14:00
						</td>
						<td>
							14:00-15:00
						</td>
						<td>
							15:00-16:00
						</td>
						<td>
							16:00-17:00
						</td>
						<td>
							17:00-18:00
						</td>
					</tr>
					<%
						int i = 0;
						String tt = "";
					%>

					<%
						String state = "可用";
						MeetingDao md = new MeetingDao();
					
						System.out.println("test"+date);
						for (int k = 0; k < mrs.size(); k++) {
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
						<td><%=mrs.get(k).getRoomid()%><%=mrs.get(k).getRoomname()%></td>
						<%
							if (md.ifRoomEmptyByTime("09:00:00",
										"10:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("10:00:00",
										"11:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("11:00:00",
										"12:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("13:00:00",
										"14:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("14:00:00",
										"15:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("15:00:00",
										"16:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("16:00:00",
										"17:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
						<%
							if (md.ifRoomEmptyByTime("18:00:00",
										"19:00:00", mrs.get(k).getRoomid(),date)) {
									state = "<div style='color:red' >占用</div>";
								} else {
									state = "可用";
								}
						%>
						<td><%=state%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
						 

				</body>
</html>