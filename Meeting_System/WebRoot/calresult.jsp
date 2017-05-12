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
	<div class="
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
							<h2 class="inner-tittle">计算结果</h2>
						</ol>

					</div>
					<div class="graph">

						<h3 class="sub-tittle">你的工资情况如下：</h3>
						<ul class="timeline">
							<li>
								<div class="timeline-badge info">
									<i class="fa fa-smile-o"></i>
								</div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h4 class="timeline-title"><%=request.getAttribute("laborage").toString()%>元
										</h4>
									</div>
									<div class="timeline-body">
										<p>
											你的税前总工资为
											<%=request.getAttribute("laborage").toString()%>元
										</p>
									</div>
								</div>
							</li>

							<li>
								<div class="timeline-badge primary">
									<i class="fa fa-star-o"></i>
								</div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h4 class="timeline-title"><%=request.getAttribute("gongzi").toString()%>元
										</h4>
									</div>
									<div class="timeline-body">
										<p>
											你的税后总工资<%=request.getAttribute("gongzi").toString()%>元 = 总工资<%=request.getAttribute("laborage").toString()%>元
											- 个人所得税<%=request.getAttribute("Tax").toString()%>元
										</p>
									</div>
								</div>
							</li>



							<li>
								<div class="timeline-badge danger">
									<i class="fa fa-times-circle-o"></i>
								</div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h4 class="timeline-title"><%=request.getAttribute("total5").toString()%>元
										</h4>
									</div>
									<div class="timeline-body">

										<p>
											你的五险一金<%=request.getAttribute("total5").toString()%>元 = 养老<%=request.getAttribute("yanglao").toString()%>元
											+ 医疗<%=request.getAttribute("yilao").toString()%>元 + 失业<%=request.getAttribute("shiye").toString()%>元
											+ 工伤<%=request.getAttribute("gongshang").toString()%>元 + 生育<%=request.getAttribute("shengyu").toString()%>元
											+ 公积金<%=request.getAttribute("gongjijin").toString()%>元
										</p>
									</div>
								</div>
							</li>

							<li>
								<div class="timeline-badge success">
									<i class="fa fa-check-circle-o"></i>
								</div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h4 class="timeline-title">
											个人所得税：<%=request.getAttribute("Tax").toString()%>元
										</h4>
									</div>
									<div class="timeline-body">
										<p>个人所得税计算公式 应纳税所得额 = 工资收入金额 － 各项社会保险费 － 起征点(3500元)</p>
										<p>应纳税额 = 应纳税所得额 x 税率 － 速算扣除数</p>
										<p>说明：如果计算的是外籍人士（包括港、澳、台），则个税起征点应设为4800元。</p>
									</div>
								</div>
							</li>
						</ul>

						<!--/candile-->

						<!--/charts-->
						<!--//outer-wp-->
				
		<script src="js/bootstrap.min.js"></script>
</body>
</html>