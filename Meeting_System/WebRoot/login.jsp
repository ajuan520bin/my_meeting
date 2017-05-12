

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
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
<!--clock init-->
</head>
<body>
	<!--/login-->

	<div class="error_page">
		<!--/login-top-->

		<div class="error-top">
			<h2 class="inner-tittle page">Meeting</h2>
			<div class="login">
				<h3 class="inner-tittle t-inner">Login</h3>
				<div class="buttons login">
					<ul>

						<div class="clearfix"></div>
					</ul>
				</div>
				<form action="LoginServlet" method="post">
					<input type="text" class="text" value="用户名"
						name="username" onfocus=" this.value='';" onblur="if (this.value == '') {this.value = '用户名';}">
					<input type="password" value="Password" name="password"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Password';}">
					<div class="submit">
						<input type="submit" onclick="myFunction()" value="Login">
					</div>
					<div class="clearfix">
						<span class="sign">Do not have an account ? </span>
					</div>
					<p class="sign">
						<a href="register.jsp">Sign Up</a>
					</p>

					<div class="new">


						<div class="clearfix"></div>
					</div>
				</form>
			</div>


		</div>


		<!--//login-top-->
	</div>

	<!--//login-->
	<!--footer section start-->
	<div class="footer">
		<p>Copyright &copy; 2016.哇啦啦野人 All rights reserved.</p>
	</div>
	<!--footer section end-->
	<!--/404-->
	<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>