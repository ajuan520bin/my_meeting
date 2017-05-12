<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <!DOCTYPE HTML>
<html>
<head>
<title>Sign Up</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->

<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
<!--clock init-->
</head> 
<body>
								<!--/login-->
								
									   <div class="error_page">
												<!--/login-top-->
												
													<div class="error-top up">
													<h2 class="inner-tittle page">Meeting</h2>
													    <div class="login">
														<h3 class="inner-tittle t-inner">Sign Up</h3>
																<form action="RegisterServlet" method="post">
<input type="text" class="text" value="姓名" name="employeename" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '姓名';}" >	
																<input type="text" class="text" value="用户名" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" >
																		<input type="password" value="Password"  name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
                                                                        <input type="text" class="text" value="电话号码"  name="phone"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '电话号码';}" >
                                                                        <input type="text" class="text" value="电子邮箱" name="email"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '电子邮箱';}" >
                                                                          <input type="text" class="text" value="所在部门" name="departmentid"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '所在部门';}" >
                                                                      
																		
																		<div class="submit"><input type="submit" onclick="myFunction()" value="Sign up" ></div>
																		<div class="clearfix"></div>
																		<div class="new">
																	    <p class="sign up">Do you have an account yet ? <a href="login.jsp"> Login here.</a></p>
																			<div class="clearfix"></div>
																		</div>
																	</form>
														</div>
														
													</div>
													 
												<!--//login-top-->
										   </div>
										  	<!--//login-->
										    <!--footer section start-->
										<div class="footer sign">
										<div class="error-btn">
																													</div>
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