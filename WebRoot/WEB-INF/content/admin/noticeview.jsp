<%@page import="hjjf.scss.model.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<div class="navbar-holder d-flex align-items-center justify-content-between">
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
		<nav class="side-navbar">
			<%@include file="admbar.jsp" %>
</nav>

		<div class="content-inner form-cont">
			<div class="row">
				<div class="col-md-12">

					<!--***** BASIC FORM *****-->
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>公告</h3>
						</div>
						<br>
							

					<!--***** FORM INPUTS *****-->
					<div class="row">
						<table class="table table-hover"  id="tth">
							<thead>
								<tr class="bg-info text-white">
									<th>序号</th>
									<th>编号</th>
									<th>公告标题</th>
									<th>公告内容</th>
									<th>发布时间</th>
									<th>发布人</th>
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
					});
				
				
			
				 function tableload(){

					 $.ajax({
						url : "not/search",
						type : "post",
						dataType : "json",
						success : function(data){
						 var trhtml = "";
						for(var i =0;i<data.length;i++){
						trhtml+="<tr><td>"+(i+1)+"</td><td>";
						trhtml+=data[i].ID;
						trhtml+="</td><td>";
						trhtml+=data[i].noticeTitle;
						trhtml+="</td><td >";
						trhtml+=data[i].noticeContent;
						trhtml+="</td><td >";
						trhtml+=data[i].releaseTime;
						trhtml+="</td><td >";
						trhtml+=data[i].admin.adminName;
						trhtml+="</td><td >";
						trhtml += data[i].remark;
						trhtml+="</td><td>";
						trhtml+="<a href='not/noticelook?notice.ID="
						trhtml+=data[i].ID;
						trhtml+="'>查看</a>&nbsp;&nbsp";
						trhtml+="<a href='not/delete?notice.ID="
						trhtml += data[i].ID;
						trhtml += "'>删除</a></td></tr>";}
						$("#tth tbody").append( trhtml); 
						}, 
						error : function(){
							alert("error");
						}
					});
				} 
			
			</script>
</body>

</html>