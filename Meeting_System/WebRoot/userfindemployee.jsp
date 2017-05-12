<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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

						<div class="login">
							<h3>预定会议</h3>
							<div class="buttons login">
								<ul>

									<div class="clearfix"></div>
								</ul>
							</div>
							<form action="EmployeeServlet" method="post">
								<p>EmployeeName:</p>

								<div class="col-md-6 form-group1">
									<input type="text" name="employeename" />
								</div>

								<p>&nbsp;&nbsp;
								<p>
								<p>&nbsp;&nbsp;
								<p>
								<p>UserName:</p>

								<div class="col-md-6 form-group1">
									<input type="text" name="username" />
								</div>
								<p>&nbsp;&nbsp;
								<p>
								<p>&nbsp;&nbsp;
								<p>
								<p>Status:</p>

								<div class="col-md-6 form-group1">
									<input type="text" name="status" />
								</div>

								<p>&nbsp;&nbsp;
								<p>
								<p>&nbsp;&nbsp;
								<p>
								<p>&nbsp;&nbsp;
								<p>
								<div class="col-md-6 form-group1">
									<input type="submit" value="Search" class="btn" />
								</div>

							</form>


							<div class="new">


								<div class="clearfix"></div>
							</div>
							</form>
						</div>


					</div>
				</div>
				<!--/candile-->

				<!--/charts-->
				<!--//outer-wp-->
			</div>
			<!--footer section start-->

			
</body>
</html>