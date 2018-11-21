<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--<link rel="icon" href="../../favicon.ico">-->

		<title>活动详情</title>
		<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${ctx }/js/jquery.min.js"></script>
		<script	src="${ctx }/js/bootstrap.min.js"></script>
		<link href="${ctx }/css/base.css" rel="stylesheet">
		<link href="${ctx }/css/activity-detail.css" rel="stylesheet">
		<link href="${ctx }/css/jquery.toast.min.css" rel="stylesheet">
		
	<script src="${ctx }/js/jquery.toast.min.js">
	</script>
	</head>

	<body>
		<!-- 使用动态include指令导入头部 -->
		<jsp:include page="header.jsp" />
	
		<section id="main">
			<div class="container">
				<div class="row">
					<ol class="breadcrumb">
						  <li><a href="${ctx}/index">首页</a></li>
						  <li><a href="${ctx}/act/actList">所有活动</a></li>
						  <li class="active">${act.actTitle }</li>
					</ol>
				</div>
				
				<jsp:include page="actComments.jsp" />
			</div>
		</section>
		
		<jsp:include page="footer.jsp" />
</body>
		<script>
			$(function() {
				/*小屏幕导航点击关闭菜单*/
				$('.navbar-collapse a').click(function() {
					$('.navbar-collapse').collapse('hide');
				});
				
				
			})
		</script>
</html>