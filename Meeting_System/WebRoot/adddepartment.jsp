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
						<form action="AddDepartmentServlet" method="post">


							<label class="control-label">&nbsp;&nbsp;&nbsp;部门名称</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="vali-form">
								<div class="col-md-6 form-group1">
									<input type="text" name="departmentname"><br>
								</div>
								<br></br> <br></br> &nbsp;
								<button type="submit" class="btn blue">提交</button>
								&nbsp;
								<button type="reset" class="btn green">重置</button>

							</div>
							<div class="graph">
								<table class="table">

									<tr class="success">
										<td>departmentid</td>
										<td>departmentname</td>
										<td colspan="2">
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
											<td>${emp.departmentid}</td>
											<td>${emp.departmentname}</td>
											<td><a
												href="DeleteDepartmentServlet?departmentid=${emp.departmentid}">删除</a></td>
										</tr>
									</c:forEach>
								</table>
						</form>

				</body>
</html>