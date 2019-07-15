<%@page import="hjjf.scss.model.Teacher"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Teacher tea = (Teacher) request.getSession()
			.getAttribute("teacher");
%>


<div class="sidebar-header d-flex align-items-center">
	<div class="avatar">
		<img src="teacher/teacherphoto/<%=tea.getPhoto()%>.jpg" alt="..."
			class="img-fluid rounded-circle">
	</div>
	<div class="title">
		<h1 class="h4"><%=tea.getName()%></h1>
	</div>
</div>
<hr>
<!-- Sidebar Navidation Menus-->
<ul class="list-unstyled">
	<li><a href="admin/index.jsp"> <i class="icon-home"></i>主页
	</a></li>

	<li><a href="#pages" aria-expanded="false" data-toggle="collapse">
			<i class="fa fa-file-o"></i>教师操作
	</a>
		<ul id="pages" class="collapse list-unstyled">
			<li><a href="teacherup">信息更改</a></li>
			<li><a href="teapassup">密码更改</a></li>
			<li><a href="teachtask">开课</a></li>
			<li><a href="schedule">配置课表</a></li>
			<li><a href="score">评分</a></li>
		</ul></li>


</ul>

