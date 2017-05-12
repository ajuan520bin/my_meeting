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
		<script type="application/x-javascript">
</script>
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

<script type="text/javascript" language="javascript" >
 
  function display(id){
  
  var temp="info"+id;
  
  document.getElementById(temp).style.display="block"; 
  }
  function disappear(id){
  var temp="info"+id;
document.getElementById(temp).style.display="none"; 
  }
 
 </script>
		<%
		    String date=(String)request.getParameter("demo");
		    System.out.println(date);
			MeetingDao md = new MeetingDao();
			List<String> week = WeekCal.mondayToSunday(date);
			MeetingRoomDao mrd = new MeetingRoomDao();
			List<Meetingroom> mrs = mrd.selectMeetingrooms();
		%>
	
<style type="text/css">

.link {
	position: relative;
}

.meetinginfo {
	display: none;
	color:#fff;
	width:250px;
	padding:10px;
	text-align: left;	
	position: absolute;
	background:#66cccc;
	z-index:50;
}

</style>
	</head>
	<body>

		</form>
		<div class="graph">
			<table class="table">

				<tr class="success">
					<td>
						会议室
					</td>
					<td>
						周一<%=week.get(0).toString()%>
					</td>
					<td>
						周二<%=week.get(1).toString()%>
					</td>
					<td>
						周三<%=week.get(2).toString()%>
					</td>
					<td>
						周四<%=week.get(3).toString()%>
					</td>
					<td>
						周五<%=week.get(4).toString()%>
					</td>
					<td>
						周六<%=week.get(5).toString()%>
					</td>
					<td>
						周日<%=week.get(6).toString()%>
					</td>
				</tr>
				<%
					int i = 0;
					String tt = "";
				%>

				<%
					for (int k = 0; i < mrs.size(); k++) {
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
					<td><%=mrs.get(k).getRoomid()%>
						<%=mrs.get(k).getRoomname()%>
					</td>
					<%
						for (int day = 0; day < 7; day++) {
								List<Meeting> meetings = new ArrayList<Meeting>();
								meetings = md.RoomInfoByDay(week.get(day).toString(), mrs
										.get(k).getRoomid());
					%>
					<td>
						<%
							for (int j = 0; j < meetings.size(); j++) {
						%>
						<div class="link">
							<a href="#" onmouseover="display(this.id)" id="<%=meetings.get(j).getMeetingid() %>" 
							onmouseout="disappear(this.id)">
								<%=meetings.get(j).getMeetingname()%></a>
								<%String info="info"+meetings.get(j).getMeetingid(); %>
							 <div class="meetinginfo" id="<%=info %>" onmouseover="display()" onmouseout="disappear()">
								<%=meetings.get(j).toString()%>
							</div>
						</div>
						<%
							}
						%>
					</td>

					<%
						}
						}
					%>
				
			</table>
		</div>


	</body>
</html>



