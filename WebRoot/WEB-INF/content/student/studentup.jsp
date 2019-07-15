
<%@page import="hjjf.scss.model.Student"%>
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
					<div class="brand-text brand-big hidden-lg-down">信息更改</div>
					<div class="brand-text brand-small">改</div>
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
		<nav class="side-navbar"> <%@include file="stubar.jsp"%>
		</nav>
		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">

					<!--***** BASIC FORM *****-->
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>学生信息更改</h3>
						</div>
						<br>
						<form action="stu/selfup" method="post">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="exampleInputEmail1">班级</label> <input type="text"
											class="form-control" id="ClassName" name="student.ClassName"
											value="<%=stu.getClasss().getClassID()%>" readonly="readonly">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">学号</label> <input type="text"
											class="form-control" id="StuID" name="student.StuID"
											value="<%=stu.getStuID()%>" readonly="readonly">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">姓名</label> <input
											type="text" class="form-control" name="student.Name" id="Name"
											value="<%=stu.getName()%>">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">性别</label> <input
											type="text" class="form-control" name="student.Sex" id="Sex"
											value="<%=stu.getSex()%>">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">生日</label> <input
											class="form-control" type="date" id="Birth" name="student.Birth"
											value="<%=stu.getBirth()%>">
									</div>
									<div class="form-group">
										<label for="exampleTextarea">备注</label> <input
											class="form-control" id="exampleTextarea" name="student.Remark"
											value="<%=stu.getRemark()%>" />
									</div>



									<button type="submit" class="btn btn-general btn-blue mr-2"
										onclick="tableload()">更改</button>

									<button type="reset" class="btn btn-general btn-white"
										onclick=" inputreset()">清空</button>
								</div>
						</form>


						<form class="col-md-6" action="stu/execute"
							enctype="multipart/form-data" method="post">


							<div class="form-group row">
								<label for="example-datetime-local-input" style="width:85px;"
									class=" col-form-label"></label>
								<div class="card hovercard">
									<div class="avatar">
										<img id="pic" alt=""
											src="student/studentphoto/<%=stu.getPhoto()%>.jpg"
											style="width:40mm;height: 52mm;">
									</div>
								</div>
							</div>
							<div class="form-group row">

								<div class="col-9">
									<div class="input-group image-preview">
										<input placeholder="" type="text" id="filename"
											class="form-control image-preview-filename"
											readonly="readonly"> <span class="input-group-btn">
											<div class="btn btn-default image-preview-input">
												<span class="glyphicon glyphicon-folder-open"></span> <span
													class="image-preview-input-title">打开</span> <input
													type="file" accept=" image/jpg" name="image"
													onchange="ImgShowPreview(this)" />

											</div>


										</span> &nbsp<input type="submit" value="上传照片" />
									</div>
								</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!--Global Javascript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/popper/popper.min.js"></script>
	<script src="js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/front.js"></script>


	<!--Core Javascript -->
	<script type="text/javascript">
		function inputreset() {
			$("#exampleInputEmail1").attr("readOnly", false);
		}
		function ImgShowPreview(source) {
			var file = source.files[0];
			if (window.FileReader) {
				var fr = new FileReader();
				console.log(fr);
				var pic = document.getElementById('pic');
				var filename = document.getElementById('filename');
				fr.onloadend = function(e) {
					pic.src = e.target.result;
				};
				fr.readAsDataURL(file);
				pic.style.display = 'block';
				filename.value = file.name;
			}
		}
	</script>
</body>

</html>