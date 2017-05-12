<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 





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
</head>
<body>
	
				<div class="outter-wp">
					<!--custom-widgets-->
					<div class="custom-widgets"></div>
					<!--//custom-widgets-->
					<!--/candile-->
					<!--div class="candile"-->
					<div class="graph">


						<script>
							$(function() {
								$('.tabs nav a').on('click', function() {
									show_content($(this).index());
								});

								show_content(0);

								function show_content(index) {
									// Make the content visible
									$('.tabs .context.visible').removeClass(
											'visible');
									$(
											'.tabs .context:nth-of-type('
													+ (index + 1) + ')')
											.addClass('visible');

									// Set the tab to selected
									$('.tabs nav.second a.selected')
											.removeClass('selected');
									$(
											'.tabs navnav.second a:nth-of-type('
													+ (index + 1) + ')')
											.addClass('selected');
								}
							});
						</script>
						<form action="OrderMeetingServlet" method="post">
							会议名称： <input type="text" name="meetingname"><br> <br>
							会议说明： <input type="text" name="description"><br> <br>



							<table class="table">

								<tr class="success">

									<td>Employeeid</td>
									<td>EmployeeName</td>
									<td>UserName</td>
									<td>Phone</td>
									<td>E-mail</td>
									<td>select</td>

								</tr>
								<%
									int i = 0;
									String tt = "";
								%>
								<c:forEach items="${requestScope.list}" var="emp">
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
										<td>${emp.employeeid}</td>
										<td>${emp.employeename}</td>
										<td>${emp.username}</td>
										<td>${emp.phone}</td>
										<td>${emp.email}</td>
										<td><input type="checkbox" value="${emp.employeeid}" name="XXX" /></td>
									</tr>
								</c:forEach>
							</table>
							<button type="submit" class="btn purple">提交</button>
						</form>
					</div>
					<!--/candile-->

					<!--/charts-->
					<!--//outer-wp-->
				</div>
				<!--footer section start-->

			
		
		
</body>
</html>