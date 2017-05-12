<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
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
	
							
				<!-- //header-ends -->
				<div class="outter-wp">
					<!--custom-widgets-->
					<div class="custom-widgets"></div>
					<!--//custom-widgets-->
					<!--/candile-->
					<!--div class="candile"-->

					<div class="sub-heard-part">
						<ol class="breadcrumb m-b-0">
							<li><a href="index.html">Home</a></li>
							<li class="active">预定会议室</li>
						</ol>
						<h2 class="inner-tittle">预定会议室</h2>
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
						<form action="AvailableRoomServlet" method="post">
							<!--/Accordion-->
							<div class="accordion">

								<div class="panel-group tool-tips graph-form" id="accordion"
									role="tablist" aria-multiselectable="true">
									<div class="panel-default">
										<div class="panel-heading" role="tab" id="headingOne">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapseOne"
													aria-expanded="false" aria-controls="collapseOne"
													class="collapsed"> Starttime： </a>
											</h4>
										</div>
										<div id="collapseOne" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingOne"
											aria-expanded="false" style="height: 0px;">
											<div class="panel-body">
												<input class="Wdate" type="text" id="starttime"
													name="starttime"
													onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
											</div>
										</div>
									</div>
									<div class="panel-default">
										<div class="panel-heading" role="tab" id="headingTwo">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapseTwo"
													aria-expanded="false" aria-controls="collapseTwo"
													class="collapsed"> Endtime： </a>
											</h4>
										</div>
										<div id="collapseTwo" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingTwo"
											aria-expanded="false" style="height: 0px;">
											<div class="panel-body">
												<input class="Wdate" type="text" id="endtime" name="endtime"
													onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
											</div>
										</div>
									</div>
									<div class="panel-default">
										<div class="panel-heading" role="tab" id="headingThree">
											<h4 class="panel-title">
												<a class="collapsed" role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapseThree"
													aria-expanded="false" aria-controls="collapseThree">
													Capacity： </a>
											</h4>
										</div>
										<div id="collapseThree" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingThree"
											aria-expanded="false" style="height: 0px;">
											<div class="panel-body">
												<input type="text" name="capacity" />
											</div>
										</div>
									</div>

									<button type="submit" class="btn green two">Search</button>
								</div>
							</div>
							<!--//Accordion-->
						</form>
					</div>
					<!--/candile-->

					<!--/charts-->
					<!--//outer-wp-->
				</div>
				<!--footer section start-->

			

		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->

	<script type="text/javascript" src="js/vroom.js"></script>
	<script type="text/javascript" src="js/TweenLite.min.js"></script>
	<script type="text/javascript" src="js/CSSPlugin.min.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>