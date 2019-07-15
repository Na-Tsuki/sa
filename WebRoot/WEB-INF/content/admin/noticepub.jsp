
<%@page import="hjjf.scss.model.Admin"%>
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

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="img/favicon.ico">

<!-- global stylesheets -->

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-icon-style.css">
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet" href="css/form.css">
</head>

<body>

	<!--====================================================
									 MAIN NAVBAR
======================================================-->
	<header class="header"> <nav class="navbar navbar-expand-lg ">
	<div class="search-box">
		<button class="dismiss">
			<i class="icon-close"></i>
		</button>
		<form id="searchForm" action="#" role="search">
			<input type="search" placeholder="Search Now" class="form-control">
		</form>
	</div>
	<div class="container-fluid ">
		<div
			class="navbar-holder d-flex align-items-center justify-content-between">
			<div class="navbar-header">
				<a href="index.html" class="navbar-brand">
					<div class="brand-text brand-big hidden-lg-down">
						<img src="img/logo-white.png" alt="Logo" class="img-fluid">
					</div>
					<div class="brand-text brand-small">
						<img src="img/logo-icon.png" alt="Logo" class="img-fluid">
					</div>
				</a> <a id="toggle-btn" href="#" class="menu-btn active"> <span></span>
					<span></span> <span></span>
				</a>
			</div>
	</nav> </header>

	<!--====================================================
									PAGE CONTENT
======================================================-->
	<div class="page-content d-flex align-items-stretch">

		<!--***** SIDE NAVBAR *****-->
		<nav class="side-navbar"> 
		<%@include file="admbar.jsp" %>
		</nav>

		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">

					<!--***** BASIC FORM *****-->
					<div class="card form" id="form1">
						<div class="card-header">
					<h4>公告发布</h4>
				</div>
				<br>
				<form action="not/add" method="post">
					<div class="row" style="padding:10px 20px 20px 40px;">
						<div class="col-md-9">
							<div class="form-group row">
								<label for="example-text-input" style="width: 85px;"
									class=" col-form-label">公告标题</label>
								<div class="col-9">
									<input class="form-control" type="text"  id="NoticeTitle" name="notice.NoticeTitle">
								</div>
							</div>
						</div>

						<textarea name="notice.NoticeContent" id="NoticeContent" style="width: 100%;"></textarea>
						<div class="col-md-6">
							<button type="submit" class="btn btn-general btn-white" >发布</button>
							<button type="reset" class="btn btn-general btn-white" >重置</button>
						</div>
					</div>
				</form>

			</div>
		</div>
		</div>

		<texta应的控件替换成编辑器代码--> <!--Global Javascript -->
		<script src="js/jquery.min.js"></script> <script
			src="js/popper/popper.min.js"></script> <script
			src="js/tether.min.js"></script> <script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.cookie.js"></script> <script
			src="js/jquery.validate.min.js"></script> <script
			src="js/chart.min.js"></script> <script src="js/front.js"></script> <script
			src="ckeditor/ckeditor.js"></script> <script type="text/javascript">
				window.onload = function() {
					CKEDITOR
							.replace(
									'NoticeContent',
									{
										 filebrowserImageUploadUrl : 'not/NoticePhoto',
										image_previewText : '&nbsp;',
										width : '100%',
										height:'50%' 
									});
				};
				function prom(){
		        alert("您是否要删除")
			}
			</script>
</body>

</html>