<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<script language="javascript" type="text/javascript"
	src="JavaScript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function myfun() {

		var obj = document.getElementById("btn1");
		//alert(obj);
		obj
				.insertAdjacentHTML("afterEnd",
						"<br><input type = text name = XXX>");
	}
</script>

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
	<div class="page-con
				<div class="outter-wp">
					<!--custom-widgets-->
					<div class="custom-widgets"></div>
					<!--//custom-widgets-->
					<!--/candile-->
					<!--div class="candile"-->
					<div class="sub-heard-part">
						<ol class="breadcrumb m-b-0">
							<li><a href="index.html">Home</a></li>
							<li class="active">发布投票</li>
						</ol>
						<h2 class="inner-tittle">发布投票</h2>
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
						<div class="grid-1">
							<div class="form-body">
								<form class="form-horizontal" action="AddVoteServlet"
									method="post">
									<div class="form-group">
										<label class="col-sm-2 control-label">添加投票</label>
										<div class="col-sm-9">
											<input type="text" name="votename">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">添加描述</label>
										<div class="col-sm-9">
											<input type="text" name="description">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">Starttime:</label>
										<div class="col-sm-9">
											<input class="Wdate" type="text" id="starttime"
												name="starttime"
												onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">Endtime:</label>
										<div class="col-sm-9">
											<input class="Wdate" type="text" id="endtime" name="endtime"
												onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
										</div>
									</div>




									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label"></label>
										<div class="col-sm-9">

											<input type="button" id="btn1" name="btn1" onclick="myfun()"
												value="添加选项"> <br>

											<button type="submit" class="btn purple">添加投票</button>
											<button type="reset" class="btn yellow">重置</button>



										</div>
									</div>
								</form>
							</div>
						</div>
						<!--/candile-->

						<!--/charts-->
						<!--//outer-wp-->
					</div>
					<!--footer section start-->

				<script src="js/bootstrap.min.js"></script>
</body>
</html>