
<%@page import="hjjf.scss.util.util"%>
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
							<h3>开课表</h3>
						</div>
						<br>
						<form>
							<div class="row">

								<div class="col-md-6">
									<div class="form-group">
										<label for="exampleSelect1">所属分院</label> <select
											class="form-control" id="colselect" name="CollegeID"
											onchange="loaddeps()">

										</select>
									</div>
									<div class="form-group">
										<label for="exampleSelect1">所属系部</label> <select
											class="form-control" id="depselect" name="DepartmentID" onchange="loadpros()">

										</select>
									</div>
									<div class="form-group">
										<label for="exampleSelect1">所属专业</label> <select
											class="form-control" id="proselect"
											name="profession.ProfessionID" onchange="loaddep()">

										</select>
									</div>

									<div class="form-group">
										<label for="exampleSelect1">学年</label> <input
											class="form-control" id="proselect" name="teachtask.stuyear"
											onchange="loadpros()" value="<%=util.getcoursetime()%>"
											readonly="readonly">
									</div>

									<!-- 	
					<button type="submit" class="btn btn-general btn-blue mr-2" onclick="tableload()">提交</button>
							<button type="reset" class="btn btn-general btn-white" onclick=" inputreset()">取消</button> -->
						</form>
					</div>
				</div>

				<!--***** FORM INPUTS *****-->
				<div class="row">
					<table class="table table-hover" id="deptab">
						<thead>
							<tr class="bg-info text-white">
								<th>序号</th>
								<th>课程编号</th>
								<th>课程名称</th>
								<th>学时</th>
								<th>学分</th>
								<th>课程安排</th>
								<th>分院名称</th>
								<th>系部名称</th>
								<th>专业名称</th>
								<th>备注</th>
								<th>操作</th>
							</tr>

						</thead>
						<tbody>

						</tbody>
					</table>
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
			$(document).ready(loadcols());

			function loadcols() {

				$.ajax({
					url : "col/search",
					type : "post",
					dataType : "json",
					success : function(data) {

						for (var i = 0; i < data.length; i++) {
							$("#colselect")
									.append(
											"<option value='"+data[i].collegeID+"'>"
													+ data[i].collegeName
													+ "</option>");
						}
						loaddeps();
					},
					error : function() {
						alert("分院数据请求失败！");
					}
				});
			}

			function loaddeps() {
				var id = $("#colselect").find("option:selected").val();
				$.ajax({
					url : "dep/search",
					type : "post",
					dataType : "json",
					data : {
						"department.college.CollegeID" : id
					},
					success : function(data) {
						$("#depselect").html("");
						for (var i = 0; i < data.length; i++) {
							$("#depselect").append(
									"<option value='"+data[i].departmentID+"'>"
											+ data[i].departmentName
											+ "</option>");
						}
						loadpros();
					},
					error : function() {
						alert("分院数据请求失败！");
					}
				});
			}

			function loadpros() {

				var id = $("#depselect").find("option:selected").val();
				$.ajax({
					url : "pro/search",
					type : "post",
					dataType : "json",
					data : {
						"profession.department.DepartmentID" : id
					},
					success : function(data) {
						$("#proselect").html("");
						for (var i = 0; i < data.length; i++) {
							$("#proselect").append(
									"<option value='"+data[i].professionID+"'>"
											+ data[i].professionName
											+ "</option>");
						}
						loaddep();
					},
					error : function() {
						alert("分院数据请求失败！");
					}
				});
			}

			function loaddep() {
				var id = $("#proselect").find("option:selected").val();
				$
						.ajax({
							url : "cou/search",
							type : "post",
							dataType : "json",
							data : {
								"course.profession.ProfessionID" : id
							},
							success : function(data) {
								$("#deptab tbody").html("");
								var trhtml = "";
								for (var i = 0; i < data.length; i++) {
									trhtml += "<tr><th scope='row'>";
									trhtml += i + 1;
									trhtml += "</th><td>";
									trhtml += data[i].courseID;
									trhtml += "</td><td>";
									trhtml += data[i].course;
									trhtml += "</td><td>";
									trhtml += data[i].studyTime;
									trhtml += "</td><td>";
									trhtml += data[i].credit;
									trhtml += "</td><td>";
									trhtml += data[i].curriculumTime;
									trhtml += "</td><td>";
									trhtml += $("#colselect").find(
											"option:selected").text();
									trhtml += "</td><td>";
									trhtml += $("#depselect").find(
											"option:selected").text();
									trhtml += "</td><td>";
									trhtml += $("#proselect").find(
											"option:selected").text();
									trhtml += "</td><td>";
									trhtml += data[i].remark;
									trhtml += "</td><td><a href='ttk/add?teachtask.course.CourseID="
											+ data[i].courseID
											+ " '>开课</a>&nbsp;&nbsp;<a href='ttk/delete?&teachtask.course.CourseID="
									trhtml += data[i].courseID;
									trhtml += "'>取消</a></td></tr>";
								}
								$("#deptab tbody").append(trhtml);
							},
							error : function() {
								alert("error");
							}
						});
			}
			function rowselect(index) {
				var tb = document.getElementById("deptab");
				$("#exampleInputEmail1").val(tb.rows[index].cells[1].innerHTML);
				$("#Course").val(tb.rows[index].cells[2].innerHTML);
				$("#StudyTime").val(tb.rows[index].cells[3].innerHTML);
				$("#Credit").val(tb.rows[index].cells[4].innerHTML);
				$("#CurriculumTime").val(tb.rows[index].cells[5].innerHTML);
				$("#exampleTextarea").val(tb.rows[index].cells[9].innerHTML);
				$("#exampleInputEmail1").attr("readOnly", true);
			}
			function inputreset() {
				$("#exampleInputEmail1").attr("readOnly", false);
			}
		</script>
</body>

</html>
