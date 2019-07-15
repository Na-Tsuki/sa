
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
					<div class="brand-text brand-big hidden-lg-down">
						信息更改
					</div>
					<div class="brand-text brand-small">
						改
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
		<nav class="side-navbar"> <%@include file="teabar.jsp"%>
		</nav>

		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">

					<!--***** BASIC FORM *****-->
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>配置课表</h3>
						</div>
						<br>
						<form action="scd/add" method="post">
						<input type="hidden"  id="ID" name="schedule.teachTask.ID">
							<div class="row">
								<div class="col-md-6">
									
									<div class="form-group">
                                        <label for="exampleSelect1">上课教室</label>
                                        <select class="form-control"  id="clrselect"  name="schedule.classRoom.ID" >
                                    
                                        </select>
                                    </div>
                                    
										<div class="form-group">
										<label for="exampleInputPassword1">课程名称</label> <input
											type="text" class="form-control" name="schedule.teachtask.course.CourseID" id="course" readonly="readonly">
									</div>
									
									
									
									<div class="form-group">
										<label for="exampleInputPassword1">上课时间</label> <select
											 class="form-control" name="schedule.ClassTime" id="ClassTime">
											<option>周一</option>
											<option>周二</option>
											<option>周三</option>
											<option>周四</option>
											<option>周五</option>
											
											</select>
									</div>
									
									<div class="form-group">
										<label for="exampleInputPassword1">上课节数</label> <select
											 class="form-control" name="schedule.Lesson" id="Lesson">
											<option>一、二节</option>
											<option>三、四节</option>
											<option>五、六节</option>
											<option>七、八节</option>
											<option>九、十节</option>
											
											</select>
									</div>
									
										

								</div>
								
							</div>
							<button type="submit" class="btn btn-general btn-blue mr-2" onclick="tableload()">提交</button>
							<button type="reset" class="btn btn-general btn-white" onclick=" inputreset()">取消</button>
						</form>
					</div>

					<!--***** FORM INPUTS *****-->
					<div class="row">
						<table class="table table-hover"  id="tth">
							<thead>
								<tr class="bg-info text-white">
									<th>序号</th>
									<th>课程名称</th>
									<th>学分</th>
										<th>开课编号</th>
									<th>操作</th>
								</tr>
								
							</thead>
							<tbody>
							
							</tbody>
						</table>
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
					
				$(document).ready(
					function(){
					tableload();
					loadclr();
					});
				
				
				function loadclr(){
					$.ajax({
					url:"clsr/search",
					type:"post",
					dataType:"json",
					success:function(data){
					for(var i=0;i<data.length;i++){
					$("#clrselect").append("<option value='"+data[i].ID+"'>"+data[i].classRoomName+"</option>");
					}
				},
				error:function(){
					alert("教室数据请求失败！");
				}
			});
		}
				 function tableload(){

					 $.ajax({
						url : "scd/search",
						type : "post",
						dataType : "json",
						success : function(data){
						 var trhtml = "";
						for(var i =0;i<data.length;i++){
// 						alert(data[i].course);
						trhtml+="<tr><td>"+(i+1)+"</td><td>";
						trhtml+=data[i].course.course;
						trhtml+="</td><td>";
						trhtml+=data[i].course.credit;
						trhtml+="</td><td >";
						trhtml+=data[i].ID;
						trhtml+="</td><td>";
						 trhtml+="<a href ='javascript:void(0);' onclick='rowselect("+(i+1)+")'>选择</a>&nbsp;&nbsp;"; 
						}
						$("#tth tbody").append( trhtml); 
						}, 
						error : function(){
							alert("error");
						}
					});
				} 
			function rowselect(index) {
				var tb = document.getElementById("tth");				
				$("#course").val(tb.rows[index].cells[1].innerHTML);
				$("#ID").val(tb.rows[index].cells[3].innerHTML);
			}
			function inputreset() {
				$("#exampleInputEmail1").attr("readOnly", false);
			}
			</script>
</body>

</html>