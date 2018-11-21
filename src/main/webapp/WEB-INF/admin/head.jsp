<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
	<div class="conjtainer">
		<!-- 导航开始 -->
		<nav class="collapse navbar-collapse bs-navbar-collapse"
			role="navigation">

			<ul class="nav navbar-nav pull-right">
				<li class="dropdown pull-right">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-user"></i> ${sessionScope.admin.name }<b class="caret"></b></a>

					<ul class="dropdown-menu">
					<li><a href="${ctx }/admin/toAddAdmin"><i class="icon-edit"></i> 添加管理员</a></li>
						<li><a href="${ctx }/admin/toPwdReset"><i class="icon-key"></i> 修改密码</a></li>
						<li><a href="${ctx }/admin/logout"><i class="icon-off"></i> 退出</a></li>
					</ul>
				</li>
			</ul>
		</nav>

	</div>
</div>

<!-- Header 开始 -->
<header>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="logo">
					<h1>
						<a href="#">Space<span class="bold"></span></a>
					</h1>
					<p class="meta">后台管理系统</p>
				</div>
			</div>

			<!-- Button section -->
			<div class="col-md-5">

				<!-- Buttons -->
				<ul class="nav nav-pills">
					<!--
                            	作者：1242440175@qq.com
                            	时间：2017-03-08
                            	描述：展示子ul，需要为a标签绑定data-toggle="dropdown"
                            	即<a class="dropdown-toggle" href="#" data-toggle="dropdown" >
                            -->
					<li class="dropdown dropdown-big"><a class="dropdown-toggle"
						href="#"> <i class="icon-comments"></i> 认证申请 <span
							class="label label-info">${statisticalInformation.studentAuthentication + statisticalInformation.teacherAuthentication + statisticalInformation.clubAuthentication + statisticalInformation.collegeAuthentication }</span>
					</a></li>

					<li class="dropdown dropdown-big"><a class="dropdown-toggle"
						href="#"> <i class="icon-envelope-alt"></i> 申请场地 <span
							class="label label-primary">${statisticalInformation.claApplications + statisticalInformation.labApplications + statisticalInformation.comApplication  }</span>
					</a></li>

					<li class="dropdown dropdown-big"><a class="dropdown-toggle"
						href="#"> <i class="icon-user"></i> 留言 <span
							class="label label-success">${statisticalInformation.message }</span>
					</a></li>

				</ul>

			</div>
			<!-- Data section -->

			<div class="col-md-3">
				<div class="header-data">

					<!-- Traffic data -->
					<div class="hdata">
						<div class="mcol-left">
							<!-- Icon with red background -->
							<i class="icon-signal bred"></i>
						</div>
						<div class="mcol-right">
							<!-- Number of visitors -->
							<p>
								<a href="#">${statisticalInformation.historyVisitors }</a> <em>历史</em>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>

					<!-- Members data -->
					<div class="hdata">
						<div class="mcol-left">
							<i class="icon-user bblue"></i>
						</div>
						<div class="mcol-right">
							<p>
								<a href="#">${statisticalInformation.todayVisitors }</a> <em>今天</em>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>

				</div>
			</div>

		</div>
	</div>
</header>