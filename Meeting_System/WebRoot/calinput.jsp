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
	<div class="pag
				<div class="outter-wp">
					<!--custom-widgets-->
					<div class="custom-widgets"></div>
					<!--//custom-widgets-->
					<!--/candile-->
					<!--div class="candile"-->
					<div class="sub-heard-part">
						<ol class="breadcrumb m-b-0">
							<li><a href="index.html">主页</a></li>
							<li class="active">个人所得税</li>
							<h2 class="inner-tittle">个人所得税计算器</h2>
						</ol>
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
						<table>
							<tr>
								<td><a class="control-label">税前月薪计算税后月薪</a></td>
								<td>&nbsp;&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp;&nbsp;
									<div class="onoffswitch">
										<input type="checkbox" name="onoffswitch"
											class="onoffswitch-checkbox" id="myonoffswitch" checked>
										<label class="onoffswitch-label" for="myonoffswitch">
											<span class="onoffswitch-inner"></span> <span
											class="onoffswitch-switch"></span>
										</label>
									</div>&nbsp;&nbsp;&nbsp;
								</td>
								<td>&nbsp;&nbsp;&nbsp;</td>
								<td><a class="control-label">税后月薪反推税前月薪</a></td>
							</tr>
						</table>

						<form action="IncomeTaxServlet" method="post">



							<label class="control-label">&nbsp;&nbsp;&nbsp;月薪</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="vali-form">
								<div class="col-md-6 form-group1">
									<input type="text" name="laborage" value="10000"><br>
								</div>
							</div>


							<p>&nbsp;&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp;&nbsp;</p>

							<label class="control-label">起征金额</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="vali-form">
								<div class="col-md-6 form-group1">
									<input type="text" name="startpoint" value="3500"><br>
								</div>
							</div>


							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>

							&nbsp;
							<button type="submit" class="btn blue">提交</button>
							&nbsp;
							<button type="reset" class="btn green">重置</button>
						</form>

					</div>
					<!--/candile-->

					<!--/charts-->
					<!--//outer-wp-->
				</div>
				<!--footer section start-->

				
</body>
</html>