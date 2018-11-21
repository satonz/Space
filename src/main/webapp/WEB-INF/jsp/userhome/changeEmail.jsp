<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="space.po.Authentication"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${sessionScope.loginUser}" />
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--<link rel="icon" href="../../favicon.ico">-->

<title>场地借用管理系统</title>

<link href="${ctx }/css/bootstrap.min.css"	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">
<link href="${ctx }/css/personHome.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx }/css/jquery-labelauty.css">
</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="../header.jsp" />

	<!--个人主页-->
	<section id="main" class="container" >
		<!-- 侧边导航 -->
		<div class="col-sm-2 ">
			<jsp:include page="aside.jsp"></jsp:include>
		</div>
		<!-- 主体内容 -->
		<div class="col-sm-10">
			<div role="tabpanel" class="tab-pane user-info" id="changeEmail">
				<div class="tab-header">
					<span>修改邮箱</span>
				</div>
				<form action="." method="post">
					<br> <br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-envelope"></span></span> <input type="email"
							id="email" class="form-control" maxlength="254" name="email"
							placeholder="请输入你的注册邮箱"> <span class="input-group-btn"><button
								class="btn btn-success" type="submit">下一步</button> </span>
					</div>

				</form>
			</div>
				
		</div>
	</section>

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />



</body>
</html>