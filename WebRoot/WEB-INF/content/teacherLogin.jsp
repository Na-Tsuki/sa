
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">

<title>教师登录</title>
<link rel="shortcut icon" href="img/favicon.ico">

<!-- global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-icon-style.css">
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet" href="css/pages/login.css">
</head>

<body>

	<!--====================================================
                        PAGE CONTENT
======================================================-->
	<section class="hero-area">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 ">
				<div class="contact-h-cont">
					<h3 class="text-center">
						<img src="img/logo.png" class="img-fluid" alt="">
					</h3>
					<br>
					<form action="tea/login" method="post">
						<div class="form-group">
							<label for="username">工号</label> <input type="text"
								class="form-control" id="username" placeholder="Enter Username"
								name="teacher.TeacherID">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">密码</label> <input
								class="form-control" type="password" value="hunter2"
								id="example-password-input" name="teacher.Password">
						</div>
						<button type="submit" class="btn btn-general btn-blue"
							role="button">
							<i fa fa-right-arrow></i>登录
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!--Global Javascript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>