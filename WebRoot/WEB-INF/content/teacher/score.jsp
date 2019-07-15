
<%@page import="hjjf.scss.model.Teacher"%>
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
		<nav class="side-navbar"> <%@include file="teabar.jsp"%>
		</nav>

		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">

					<!--***** BASIC FORM *****-->
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>课程评分</h3>
						</div>
						<br>
						<form action="cous/update" method="post">
							<input type="hidden" id="ID" name="courseSchedule.ID">
							<div class="row">
								<div class="col-md-6">

									<div class="form-group">
										<label for="exampleInputPassword1">课程名称</label> <input
											type="text" class="form-control" name="courseSchedule.teachtask.course.CourseID" id="course"
											readonly="readonly">
									</div>



									<div class="form-group">
										<label for="exampleInputPassword1">评分一</label> <input
											type="text" class="form-control" name="courseSchedule.ScoreOne"
											id="ScoreOne">
									</div>


									<div class="form-group">
										<label for="exampleInputPassword1">评分二</label> <input
											type="text" class="form-control" name="courseSchedule.ScoreTwo"
											id="ScoreTwo">
									</div>


									<div class="form-group">
										<label for="exampleInputPassword1">评分三</label> <input
											type="text" class="form-control" name="courseSchedule.ScoreThree"
											id="ScoreThree">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">总分</label> <input
											type="text" class="form-control" name="courseSchedule.TotalScore"
											id="TotalScore">
									</div>

								</div>
							</div>

							<button type="submit" class="btn btn-general btn-blue mr-2"
								onclick="tableload()">提交</button>
							<button type="reset" class="btn btn-general btn-white"
								onclick=" inputreset()">取消</button>

						</form>
					</div>

				</div>
		</div>




	<!--***** FORM INPUTS *****-->
	<div class="row">
		<table class="table table-hover" id="tth">
			<thead>
				<tr class="bg-info text-white">
					<th>序号</th>
					<th>学年</th>
					<th>课程名称</th>
					<th>教师姓名</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody>

			</tbody>
		</table>
	</div>		</div>
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
		$(document).ready(function() {
			tableload();
		});

		function tableload() {

			$
					.ajax({
						url : "cous/scoresearch",
						type : "post",
						dataType : "json",
						success : function(data) {
							var trhtml = "";
							for (var i = 0; i < data.length; i++) {
								trhtml += "<tr><td>" + (i + 1) + "</td><td>";
								trhtml += data[i].teachTask.curricula;
								trhtml += "</td><td>";
								trhtml += data[i].teachTask.course.course;
								trhtml += "</td><td >";
								trhtml += data[i].teachTask.teacher.name;
								trhtml += "</td><td style='display:none'>";
								trhtml += data[i].ID;
								trhtml += "</td><td >";
								trhtml += "<a href ='javascript:void(0);' onclick='rowselect("
										+ (i + 1) + ")'>评分</a></td></tr>";
							}
							$("#tth tbody").append(trhtml);
						},
						error : function() {
							alert("error");
						}
					});
		}
		function rowselect(index) {
			var tb = document.getElementById("tth");
			$("#course").val(tb.rows[index].cells[2].innerHTML);
			$("#ID").val(tb.rows[index].cells[4].innerHTML);
		}
		function inputreset() {
			$("#exampleInputEmail1").attr("readOnly", false);
		}
	</script>
</body>

</html>