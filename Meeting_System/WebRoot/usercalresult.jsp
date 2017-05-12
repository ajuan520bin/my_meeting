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
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<!-- header-starts -->
				<div class="header-section">
					<!--menu-right-->
					<div class="top_menu">
						<div class="main-search">
							<form>
								<input type="text" value="Search" onFocus="this.value = '';"
									onBlur="if (this.value == '') {this.value = 'Search';}"
									class="text" /> <input type="submit" value="">
							</form>
							<div class="close">
								<img src="images/cross.png" />
							</div>
						</div>
						<div class="srch">
							<button></button>
						</div>
						<script type="text/javascript">
							$('.main-search').hide();
							$('button').click(function() {
								$('.main-search').show();
								$('.main-search text').focus();
							});
							$('.close').click(function() {
								$('.main-search').hide();
							});
						</script>
						<!--/profile_details-->
						<div class="profile_details_left">
							<ul class="nofitications-dropdown">
								<li class="dropdown note dra-down">
									<div id="dd" class="wrapper-dropdown-3" tabindex="1">
										<span>Italy</span>
										<ul class="dropdown">
											<li><a class="deutsch">France</a></li>
											<li><a class="english"> Italy</a></li>
											<li><a class="espana">Brazil</a></li>
											<li><a class="russian">Usa</a></li>

										</ul>
									</div> <script type="text/javascript">
										function DropDown(el) {
											this.dd = el;
											this.placeholder = this.dd
													.children('span');
											this.opts = this.dd
													.find('ul.dropdown > li');
											this.val = '';
											this.index = -1;
											this.initEvents();
										}
										DropDown.prototype = {
											initEvents : function() {
												var obj = this;

												obj.dd.on('click', function(
														event) {
													$(this).toggleClass(
															'active');
													return false;
												});

												obj.opts
														.on(
																'click',
																function() {
																	var opt = $(this);
																	obj.val = opt
																			.text();
																	obj.index = opt
																			.index();
																	obj.placeholder
																			.text(obj.val);
																});
											},
											getValue : function() {
												return this.val;
											},
											getIndex : function() {
												return this.index;
											}
										}

										$(function() {

											var dd = new DropDown($('#dd'));

											$(document)
													.click(
															function() {
																// all dropdowns
																$(
																		'.wrapper-dropdown-3')
																		.removeClass(
																				'active');
															});

										});
									</script>
								</li>
								<li class="dropdown note"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-envelope-o"></i> <span
										class="badge">3</span></a>


									<ul class="dropdown-menu two first">
										<li>
											<div class="notification_header">
												<h3>You have 3 new messages</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/1.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img src="images/in.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in1.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all messages</a>
											</div>
										</li>
									</ul></li>

								<li class="dropdown note"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-bell-o"></i> <span
										class="badge">5</span></a>

									<ul class="dropdown-menu two">
										<li>
											<div class="notification_header">
												<h3>You have 5 new notification</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img src="images/in5.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in8.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all notification</a>
											</div>
										</li>
									</ul></li>
								<li class="dropdown note"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-tasks"></i> <span
										class="badge blue1">9</span></a>
									<ul class="dropdown-menu two">
										<li>
											<div class="notification_header">
												<h3>You have 9 pending task</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Database update</span><span
														class="percentage">40%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar yellow" style="width: 40%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Dashboard done</span><span
														class="percentage">90%</span>
													<div class="clearfix"></div>
												</div>

												<div class="progress progress-striped active">
													<div class="bar green" style="width: 90%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Mobile App</span><span
														class="percentage">33%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar red" style="width: 33%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Issues fixed</span><span
														class="percentage">80%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar  blue" style="width: 80%;"></div>
												</div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all pending task</a>
											</div>
										</li>
									</ul></li>
								<div class="clearfix"></div>
							</ul>
						</div>
						<div class="clearfix"></div>
						<!--//profile_details-->
					</div>
					<!--//menu-right-->
					<div class="clearfix"></div>
				</div>
				<!-- //header-ends -->
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
					</div>
					<!--footer section start-->

					<footer>
						<p>Copyright &copy; 2016.哇啦啦野人 All rights reserved.</p>
					</footer>
					<!--footer section end-->
				</div>
			</div>
			<!--//content-inner-->
			<!--/sidebar-menu-->
			<div class="sidebar-menu">
				<header class="logo">
					<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
					</a> <a href="index.jsp"> <span id="logo">
							<h1>Meeting</h1>
					</span> <!--<img id="logo" src="" alt="Logo"/>-->
					</a>
				</header>
				<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
				<!--/down-->
				<div class="menu">
				<ul id="menu">

					<li id="menu-academico"><a href="#"><i class="fa fa-table"></i>
							<span>个人中心</span><span class="fa fa-angle-right"
							style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="NewsServlet">
									更新通知</a></li>
							<li id="menu-academico-boletim"><a href="MyOrderingServlet">我的预定</a></li>
							<li id="menu-academico-avaliacoes"><a
								href="MyMeetingServlet">我的会议</a></li>

						</ul></li>

					<li id="menu-academico"><a href="#"><i
							class="lnr lnr-book"></i> <span>会议预定</span> <span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="MeetingRoomServlet">查看会议室</a></li>
							<li id="menu-academico-boletim"><a href="h_preseveroom.jsp">预定会议室</a></li>
						</ul></li>
					<li><a href="#"><i class="lnr lnr-envelope"></i> <span>实用工具</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul>
							<li><a href="usercalinput.jsp"><i class="fa fa-inbox"></i>
									个人所得税</a></li>
							<li><a href="userweather.jsp"><i
									class="fa fa-pencil-square-o"></i> 天气预报</a></li>
						</ul></li>
					<li id="menu-academico"><a href="#"><i class="lnr lnr-layers"></i> <span>投票签到</span> <span class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="ShowVoteServlet">进行投票</a></li>
							<li id="menu-academico-boletim"><a href="useraddvote.jsp">发起投票</a></li>
							<li id="menu-academico-boletim"><a href="usersignin.jsp">进行签到</a></li>
							
						</ul></li>
					<li><a href="chart.jsp"><i class="lnr lnr-chart-bars"></i>
							<span>休闲一刻</span> <span class="fa fa-angle-right"
							style="float: right"></span></a>
						<ul>
							<li><a href="game.jsp"><i class="lnr lnr-map"></i>小游戏</a></li>

						</ul></li>
					<li id="menu-comunicacao"><a href="#"><i
							class="fa fa-smile-o"></i> <span>More</span><span
							class="fa fa-angle-double-right" style="float: right"></span></a>
						<ul id="menu-comunicacao-sub">

							<li id="menu-arquivos"><a href="useraboutus.jsp">aboutus</a></li>
						</ul></li>
				</ul>
			</div>
		</div>

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
							$(".page-container").removeClass(
									"sidebar-collapsed").addClass(
									"sidebar-collapsed-back");
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
		<link rel="stylesheet" href="css/vroom.css">
		<script type="text/javascript" src="js/vroom.js"></script>
		<script type="text/javascript" src="js/TweenLite.min.js"></script>
		<script type="text/javascript" src="js/CSSPlugin.min.js"></script>
		<script src="js/jquery.nicescroll.js"></script>
		<script src="js/scripts.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>
</body>
</html>