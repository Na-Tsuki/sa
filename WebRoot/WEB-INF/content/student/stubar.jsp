<%@page import="hjjf.scss.model.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Student stu=(Student)request.getSession().getAttribute("student");
 %>
<div class="sidebar-header d-flex align-items-center">
			<div class="avatar">
				<img src="student/studentphoto/<%=stu.getPhoto()%>.jpg" alt="..."
					class="img-fluid rounded-circle">
			</div>
			<div class="title">
				<h1 class="h4"><%=stu.getName()%></h1>
			</div>
		</div>
		<hr>
		<!-- Sidebar Navidation Menus-->
		<ul class="list-unstyled">
			<li><a href="admin/index.jsp"> <i class="icon-home"></i>主页
			</a></li>
			<li><a href="#pages" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-file-o"></i>学生操作
			</a>
				<ul id="pages" class="collapse list-unstyled">
					<li><a href="studentup">信息更改</a></li>
					<li><a href="stupassup">密码更改</a></li>
					<li><a href="CourseSchedule">学生选课</a></li>
				</ul></li>


		</ul>