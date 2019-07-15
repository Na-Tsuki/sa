<%@page import="hjjf.scss.model.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Admin adm = (Admin) request.getSession().getAttribute("admin");
%>
<div class="sidebar-header d-flex align-items-center">
	<div class="avatar">
		<img src="admin/adminphoto/<%=adm.getPhoto()%>.jpg" alt="..."
			class="img-fluid rounded-circle">
	</div>
	<div class="title">
		<h1 class="h4"><%=adm.getAdminName()%></h1>
	</div>
</div>
<hr>
<!-- Sidebar Navidation Menus-->
<ul class="list-unstyled">
	<li><a href="admin/index.jsp"> <i class="icon-home"></i>主页
	</a></li>


	<li class="active"><a href="#forms" aria-expanded="false"
		data-toggle="collapse"> <i class="fa fa-building-o"></i>信息管理
	</a>
		<ul id="forms" class="collapse list-unstyled">
			<li><a href="index">分院信息</a></li>
			<li><a href="department">分系信息</a></li>
			<li><a href="profession">专业信息</a></li>
			<li><a href="course">课程信息</a></li>
			<li><a href="class">班级信息</a></li>
			<li><a href="classroom">教室信息</a></li>
			<li><a href="teacher">老师信息</a></li>
			<li><a href="student">学生信息</a></li>
		</ul></li>

	<li><a href="#pages" aria-expanded="false" data-toggle="collapse">
			<i class="fa fa-file-o"></i>管理员操作
	</a>
		<ul id="pages" class="collapse list-unstyled">
			<li><a href="adminup">信息更改</a></li>
			<li><a href="admpassup">密码更改</a></li>
			<li><a href="Audit">开课审核</a></li>
			<li><a href="admindo">管理员权限</a></li>
			<li><a href="noticepub">发布公告</a></li>
			<li><a href="noticeview">查看公告</a></li>
		</ul></li>


</ul>
