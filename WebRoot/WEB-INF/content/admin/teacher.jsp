
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
		<nav class="side-navbar"> <%@include file="admbar.jsp"%>

		</nav>

		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">

					<!--***** BASIC FORM *****-->
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>教师信息</h3>
						</div>
						<br>
						<form id="form" action="tea/add" method="post">
							<div class="row">

								<div class="col-md-6">
									<div class="form-group">
										<label for="exampleSelect1">所属分院</label> <select
											class="form-control" id="colselect" name="teacher.college.CollegeID"
											onchange="loaddep()">

										</select>
									</div>

									<div class="form-group">
										<label for="exampleInputEmail1">工号</label> <input type="text"
											class="form-control" id="exampleInputEmail1" name="teacher.TeacherID">

									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">姓名</label> <input
											type="text" class="form-control" name="teacher.Name" id="Name">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">性别</label> <select
											class="form-control" id="Sex" name="teacher.Sex">
											<option>男</option>
											<option>女</option>
										</select>

									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">生日</label> <input
											class="form-control" type="date" value="2011-08-19"
											id="example-date-input" name="teacher.Birth">
									</div>


								</div>
								<div class="col-md-6">

									<div class="form-group">
										<label for="exampleTextarea">备注</label>
										<textarea class="form-control" id="exampleTextarea" rows="2"
											name="teacher.Remark"></textarea>
									</div>

								</div>

								<button type="submit" class="btn btn-general btn-blue mr-2"
									onclick="tableload()">提交</button>
								<button type="reset" class="btn btn-general btn-white"
									onclick=" inputreset()">取消</button>
						</form>
					</div>

					<!--***** FORM INPUTS *****-->
					<div class="row">
						<table class="table table-hover" id="deptab">
							<thead>
								<tr class="bg-info text-white">
									<th>序号</th>
									<th>工号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>生日</th>
									<th>所属分院</th>
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
						$("#colselect").append(
								"<option value='"+data[i].collegeID+"'>"
										+ data[i].collegeName + "</option>");
					}
					loaddep();
				},
				error : function() {
					alert("分院数据请求失败！");
				}
			});
		}

		function loaddep() {
			var id = $("#colselect").find("option:selected").val();
			$
					.ajax({
						url : "tea/search",
						type : "post",
						dataType : "json",
						data : {
							"teacher.college.CollegeID" : id
						},
						success : function(data) {
							$("#deptab tbody").html("");
							var trhtml = "";
							for (var i = 0; i < data.length; i++) {
								trhtml += "<tr><th scope='row'>";
								trhtml += i + 1;
								trhtml += "</th><td>";
								trhtml += data[i].teacherID;
								trhtml += "</td><td>";
								trhtml += data[i].name;
								trhtml += "</td><td>";
								trhtml += data[i].sex;
								trhtml += "</td><td>";
								trhtml += data[i].birth;
								trhtml += "</td><td>";
								trhtml += $("#colselect").find(
										"option:selected").text();
								trhtml += "</td><td>";
								trhtml += data[i].remark;
								trhtml += "</td><td><a href='javascript:void(0)' onclick='rowselect("
										+ (i + 1)
										+ ")'>选择</a>&nbsp;&nbsp;<a href='tea/delete?&TeacherID="
								trhtml += data[i].teacherID;
								trhtml += "'>删除</a></td></tr>";
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
			$("#Name").val(tb.rows[index].cells[2].innerHTML);
			$("#Sex").val(tb.rows[index].cells[3].innerHTML);
			$("#example-date-input").val(tb.rows[index].cells[4].innerHTML);
			$("#exampleTextarea").val(tb.rows[index].cells[6].innerHTML);
			$("#exampleInputEmail1").attr("readOnly", true);
			form.action = "tea/update";
		}
		function inputreset() {
			$("#exampleInputEmail1").attr("readOnly", false);
		}
	</script>
</body>

</html>
