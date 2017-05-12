<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.wllman.util.*,com.wllman.dao.*,com.wllman.vo.*,java.util.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<script language="javascript" type="text/javascript"
			src="JavaScript/My97DatePicker/WdatePicker.js">
</script>
		<script type="text/javascript" src="js/laydate.js">
</script>
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
		<%
			MeetingRoomDao mrd = new MeetingRoomDao();
			List<Meetingroom> mrs = mrd.selectMeetingrooms();
			System.out.println("*****");
			session.setAttribute("rooms", mrs);
		%>
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
					<li>
						<a href="index.html">Home</a>
					</li>
					<li class="active">
						会议日视图
					</li>
				</ol>
				<h2 class="inner-tittle">
					会议室使用情况查看
				</h2>
			</div>
			<form action="handlerDate" Target="dayiframe" method="post">
				<div class="box">
					<div class="demo1">
						<input class="laydate-icon" id="demo" name="demo" value="2017-5-8">
						<input type="submit" value="查询当前日" />
					</div>

				</div>
			</form>
			<iframe name="dayiframe" id="dayiframe" src="" frameborder=0
				width="100%" height="700px" scrolling="yes" onload="">
			</iframe>
		</div>
		<script type="text/javascript">
!function() {
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate( {
		elem : '#demo'
	});//绑定元素
}();

//日期范围限制
var start = {
	elem : '#start',
	format : 'YYYY-MM-DD',
	min : laydate.now(), //设定最小日期为当前日期
	max : '2099-06-16', //最大日期
	istime : true,
	istoday : false,
	choose : function(datas) {
		end.min = datas; //开始日选好后，重置结束日的最小日期
	end.start = datas //将结束日的初始值设定为开始日
}
};

var end = {
	elem : '#end',
	format : 'YYYY-MM-DD',
	min : laydate.now(),
	max : '2099-06-16',
	istime : true,
	istoday : false,
	choose : function(datas) {
		start.max = datas; //结束日选好后，充值开始日的最大日期
}
};
laydate(start);
laydate(end);
</script>
	</body>
</html>