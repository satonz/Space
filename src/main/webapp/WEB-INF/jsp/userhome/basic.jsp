<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="space.po.Authentication"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${sessionScope.loginUser}" />
<c:set var="pf" value="${profile}" />
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
	<section id="main" class="container">
		<!-- 侧边导航 -->
		<div class="col-sm-2 ">
			<jsp:include page="aside.jsp"></jsp:include>
		</div>
		<!-- 主体内容 -->
		<div class="col-sm-10">
		<div class="user-info" id="profile">
				<div class="tab-header">
					<span>个人信息</span>
				</div>
				<p>
					<span>用&nbsp;户&nbsp;名&nbsp;:</span> <span>${user.username }</span>
				</p>
				<p>
					<span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</span> <span>${user.email }</span>
				</p>
				<p>
					<span>用户生日：</span> <span> ${pf.pfBirth }</span>
				</p>
				<p>
					<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span> 
					<span>
						<c:choose>
							<c:when test="${pf.pfSex == 'f'}">女</c:when>
							<c:when test="${pf.pfSex =='m'}">男</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</span>
				</p>
				<p>
					<span>手机号码：</span> <span> ${pf.pfPhone }</span>
				</p>
				<p>
					<span>QQ 号码：</span> <span>${pf.pfQq }</span>
				</p>
				<p>
					<span>真实姓名：</span> <span> ${pf.pfRealname }</span>
				</p>
			</div>
		</div>
	</section>

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />


</body>
</html>