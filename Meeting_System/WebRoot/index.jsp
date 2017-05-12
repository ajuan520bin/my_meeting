<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<link
			href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
			rel="stylesheet">
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js">
</script>
		<script
			src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js">
</script>
		<script type="application/x-javascript">

addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
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

		<script src="js/ajax.js">
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

		<!--//skycons-icons-->
		<script type="text/javascript">
		var XMLHttpReq;  
        //创建XMLHttpRequest对象         
        function createXMLHttpRequest() {  
            if(window.XMLHttpRequest) { //Mozilla 浏览器  
                XMLHttpReq = new XMLHttpRequest();  
            }  
            else if (window.ActiveXObject) { // IE浏览器  
                try {  
                    XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");  
                } catch (e) {  
                    try {  
                        XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");  
                    } catch (e) {}  
                }  
            }  
        }  
        //发送请求函数  
        function sendRequest() {
        	//alert("test");
            createXMLHttpRequest();  
            var url = "ajax.jsp";  
            XMLHttpReq.open("GET", url, true);  
            XMLHttpReq.onreadystatechange = processResponse;//指定响应函数  
            XMLHttpReq.send(null);  // 发送请求  
        }  
        // 处理返回信息函数  
        function processResponse() {  
            if (XMLHttpReq.readyState == 4) { // 判断对象状态  
                if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息  
                    DisplayHot();  
                    setTimeout("sendRequest()", 1000);  
                } else { //页面不正常  
                    window.alert("您所请求的页面有异常。");  
                }  
            }  
        }  
        var now_name=0;
        var name=0;
        function DisplayHot() {  
            name = XMLHttpReq.responseXML.getElementsByTagName("name")[0].firstChild.nodeValue;  
            if(now_name<name){
                alert("你有新的消息！请查看！");
            }
          //  var count = XMLHttpReq.responseXML.getElementsByTagName("count")[0].firstChild.nodeValue;  
            now_name=name;
            document.getElementById("num").innerHTML = name;      
           // document.getElementById("count").innerHTML = count;   
        }  	
		</script>
	</head>
	<body onload=sendRequest()>
		
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
										class="text" />
									<input type="submit" value="">
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
											<span>中文</span>
											<ul class="dropdown">
												<li>
													<a class="deutsch">France</a>
												</li>
												<li>
													<a class="english"> Italy</a>
												</li>
												<li>
													<a class="espana">Brazil</a>
												</li>
												<li>
													<a class="russian">Usa</a>
												</li>

											</ul>
										</div>
										<script type="text/javascript">
function DropDown(el) {
	this.dd = el;
	this.placeholder = this.dd.children('span');
	this.opts = this.dd.find('ul.dropdown > li');
	this.val = '';
	this.index = -1;
	this.initEvents();
}
DropDown.prototype = {
	initEvents : function() {
		var obj = this;

		obj.dd.on('click', function(event) {
			$(this).toggleClass('active');
			return false;
		});

		obj.opts.on('click', function() {
			var opt = $(this);
			obj.val = opt.text();
			obj.index = opt.index();
			obj.placeholder.text(obj.val);
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

	$(document).click(function() {
		// all dropdowns
			$('.wrapper-dropdown-3').removeClass('active');
		});

});
</script>
									</li>
									<li class="dropdown note">
										<a href="messageshow.jsp" Target="myiframe"><img
												style="width: 20px; height: 20px" src="images/mail.png" />
											<span class="badge" id="num">4</span> </a>
									</li>
									<div class="clearfix"></div>
									<!--//profile_details-->
							


								<script>
$(function() {
	$('.tabs nav a').on('click', function() {
		show_content($(this).index());
	});

	show_content(0);

	function show_content(index) {
		// Make the content visible
		$('.tabs .context.visible').removeClass('visible');
		$('.tabs .context:nth-of-type(' + (index + 1) + ')')
				.addClass('visible');

		// Set the tab to selected
		$('.tabs nav.second a.selected').removeClass('selected');
		$('.tabs navnav.second a:nth-of-type(' + (index + 1) + ')').addClass(
				'selected');
	}
});
</script>
								<iframe name="myiframe" id="myiframe" src="" frameborder=0
									width="100%" height="700px" scrolling="yes" onload="">
								</iframe>

							</div>

						</div>
						<!--footer section start-->

						<footer>
						<p>
							Copyright &copy; 2017.我们仨 All rights reserved.
						</p>
						</footer>
						<!--footer section end-->
					</div>
				</div>
				<!--//content-inner-->
				<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo">
					<a href="#" class="sidebar-icon"><img
							style="width: 20px; height: 20px" src="images/menu.png" /></span> </a>
					<a href="index.jsp"> <span id="logo">
							<h1>
								Meeting
							</h1> </span> <!--<img id="logo" src="" alt="Logo"/>--> </a>
					</header>
					<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
					<!--/down-->
					<div class="down">
						<a href="index.jsp"><img src="images/admin.jpg"> </a>
						<a href="index.jsp"><span class=" name-caret">${employeename}</span>
						</a>
						<p>
							System Administrator in Company
						</p>
						<ul>
							<li>
								<a class="tooltips" href="index.jsp"><span>个人设置</span><i
									class="lnr lnr-user"></i> </a>
							</li>
							<li>
								<a class="tooltips" href="index.jsp"><span>设置</span><i
									class="lnr lnr-cog"></i> </a>
							</li>
							<li>
								<a class="tooltips" href="index.jsp"><span>退出</span><i
									class="lnr lnr-power-switch"></i> </a>
							</li>
						</ul>
					</div>
					<!--//down-->
					<div class="menu">
						<ul id="menu">

							<li id="menu-academico">
								<a href="#"><img style="width: 20px; height: 20px"
										src="images/man-user.png" />&nbsp;&nbsp; <span>个人中心</span></span> </a>
								<ul id="menu-academico-sub">
									<li id="menu-academico-avaliacoes">
										<a href="NewsServlet" Target="myiframe"> 更新通知</a>
									</li>
									<li id="menu-academico-boletim">
										<a href="MyOrderingServlet" Target="myiframe">我的预定</a>
									</li>
									<li id="menu-academico-avaliacoes">
										<a href="MyMeetingServlet" Target="myiframe">我的会议</a>
									</li>

								</ul>
							</li>
							<li id="menu-academico">
								<a href="#"><img style="width: 20px; height: 20px"
										src="images/group.png" />&nbsp;&nbsp; <span>查看会议室</span> </span> </a>
								<ul id="menu-academico-sub">
									<li id="menu-academico-avaliacoes">
										<a href="getday.jsp" Target="myiframe">日视图</a>
									</li>
									<li id="menu-academico-boletim">
										<a href="getweek.jsp" Target="myiframe">周视图</a>
									</li>
									<li id="menu-academico-boletim">
										<a href="monthofroom.jsp" Target="myiframe">月视图</a>
									</li>

								</ul>
							</li>

							<li id="menu-academico">
								<a href="#"><img style="width: 20px; height: 20px"
										src="images/classroom.png" />&nbsp;&nbsp; <span>会议室预定</span>
								</a>
							</li>
							<li>
								<a href="#"><img style="width: 20px; height: 20px"
										src="images/old-fashion-briefcase.png" />&nbsp;&nbsp; <span>实用工具</span></span>
								</a>
								<ul>
									<li>
										<a href="calinput.jsp" Target="myiframe"><i
											class="fa fa-inbox"></i> 个人所得税</a>
									</li>
									<li>
										<a href="weather.jsp" Target="myiframe"><i
											class="fa fa-pencil-square-o"></i> 天气预报</a>
									</li>


								</ul>
							</li>
							<li id="menu-academico">
								<a href="#"><img style="width: 20px; height: 20px"
										src="images/vote.png" />&nbsp;&nbsp; <span>投票签到</span></span> </a>
								<ul id="menu-academico-sub">
									<li id="menu-academico-avaliacoes">
										<a href="ShowVoteServlet" Target="myiframe">进行投票</a>
									</li>
									<li id="menu-academico-boletim">
										<a href="addvote.jsp" Target="myiframe">发起投票</a>
									</li>
									<li id="menu-academico-boletim">
										<a href="signin.jsp" Target="myiframe">进行签到</a>
									</li>

								</ul>
							</li>
							<li>
								<a href="chart.jsp"><img style="width: 20px; height: 20px"
										src="images/wule.png" />&nbsp;&nbsp; <span>休闲一刻</span> </a>
								<ul>
									<li>
										<a href="game.jsp" Target="myiframe"><i
											class="lnr lnr-map"></i>小游戏</a>
									</li>

								</ul>
							</li>
							<li id="menu-comunicacao">
								<a href="#"><img style="width: 20px; height: 20px"
										src="images/more.png" />&nbsp;&nbsp; <span>More</span> </a>
								<ul id="menu-comunicacao-sub">

									<li id="menu-arquivos">
										<a href="aboutus.jsp" Target="myiframe">aboutus</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>

				<div ccxz lass="clearfix"></div>
			</div>
			<script>
var toggle = true;

$(".sidebar-icon").click(
		function() {
			if (toggle) {
				$(".page-container").addClass("sidebar-collapsed").removeClass(
						"sidebar-collapsed-back");
				$("#menu span").css( {
					"position" : "absolute"
				});
			} else {
				$(".page-container").removeClass("sidebar-collapsed").addClass(
						"sidebar-collapsed-back");
				setTimeout(function() {
					$("#menu span").css( {
						"position" : "relative"
					});
				}, 400);
			}

			toggle = !toggle;
		});
</script>
			<!--js -->
			<link rel="stylesheet" href="css/vroom.css">
			<script type="text/javascript" src="js/vroom.js">
</script>
			<script type="text/javascript" src="js/TweenLite.min.js">
</script>
			<script type="text/javascript" src="js/CSSPlugin.min.js">
</script>
			<script src="js/jquery.nicescroll.js">
</script>
			<script src="js/scripts.js">
</script>

			<!-- Bootstrap Core JavaScript -->
			<script src="js/bootstrap.min.js">
</script>
	</body>
</html>