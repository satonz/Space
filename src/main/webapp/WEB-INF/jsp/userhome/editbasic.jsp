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
	<section id="main" class="container" >
		<!-- 侧边导航 -->
		<div class="col-sm-2 ">
			<jsp:include page="aside.jsp"></jsp:include>
		</div>
		<!-- 主体内容 -->
		<div class="col-sm-10">
		<div role="tabpanel" class="tab-pane" id="changeProf">
				<form action="" method="post" enctype="multipart/form-data">
					<div class="user-info">
						<div class="tab-header">
							<span>修改信息</span>
						</div>
						<p>
							<span>用户生日：</span> <input type="date" value="${pf.pfBirth }" name="birth"><!-- name="pfBirth" -->
						</p>
						<p>
							<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span> <span>
								<c:choose>
									<c:when test="${pf.pfSex == 'm'}">
										<span><input type="radio" name="pfSex" checked="checked" value="m" /> 男<br /></span>
									</c:when>
									<c:otherwise>
										<span><input type="radio" name="pfSex" value="m" /> 男<br /></span>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${pf.pfSex == 'f'}">
										<span><input type="radio" name="pfSex" checked="checked" value="f" /> 女<br /></span>
									</c:when>
									<c:otherwise>
										<span><input type="radio" name="pfSex" value="f" /> 女<br /></span>
									</c:otherwise>
								</c:choose>
								</span>
						</p>
						<p>
							<span>手机号码：</span> <input	type="text" value="${pf.pfPhone }" name="pfPhone">
						</p>
						<p>
							<span>QQ 号码：</span> <input	type="text" value="${pf.pfQq }" name="pfQq">
						</p>
						<p>
							<span>真实姓名：</span> <input	type="text" value="${pf.pfRealname }" name="pfRealname">
						</p>
						
						<p>
							<button class="btn btn-warning" style="min-width: 150px;"
								type="submit">
								<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;保存
							</button>
						</p>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />



</body>
</html>