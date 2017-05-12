<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<link rel="stylesheet" href="css/demo.css" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script language="javascript" type="text/javascript"
	src="JavaScript/My97DatePicker/WdatePicker.js"></script>
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

					<div class="sub-heard-part">
						<ol class="breadcrumb m-b-0">
							<li><a href="index.html">Home</a></li>
							<li class="active">点击签到</li>
						</ol>
						<h2 class="inner-tittle">点击签到</h2>
					</div>
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


						<div class="graph">
							<div class="clock" id="clock2"></div>
							<script
								src="http://www.5iweb.com.cn/statics/js/jquery.1.7.1.min.js"
								type="text/javascript"></script>

							<script type="text/javascript" src="js/clock-1.1.0.min.js"></script>
							<script>
								var clock = $("#clock").clock(), data = clock
										.data('clock');

								// data.pause();
								// data.start();
								// data.setTime(new Date());

								var d = new Date();
								d.setHours(9);
								d.setMinutes(51);
								d.setSeconds(20);

								var clock1 = $("#clock1").clock({
									width : 210,
									height : 305,
									theme : 't2',
									date : d
								});

								var clock2 = $("#clock2").clock({
									width : 150,
									height : 220,
									theme : 't3'
								});
							</script>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<form action="SigninServlet" method="post">
								<button type="submit" class="btn blue">点击签到</button>
							</form>

						</div>


						<div class="graph">
							<table class="table">

								<tr class="success">
									<td>signintime</td>
									<td>ip</td>

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

										<td>${emp.starttime}</td>
										<td>${emp.ip}</td>

									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<!--/candile-->

					<!--/charts-->
					<!--//outer-wp-->
				</div>
				<!--footer section start-->

				
</body>
</html>