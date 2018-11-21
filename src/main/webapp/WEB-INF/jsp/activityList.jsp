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

<title>场地借用管理系统</title>

<link href="${ctx }/css/bootstrap.min.css"	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">
<link href="${ctx }/css/activity-detail.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx }/css/animate.css">
</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="header.jsp" />

<div id="main" class="container" >
	<div class="panel panel-success">
		  <div class="panel-heading">
		    <h2 class="panel-title">您当前的位置： <a href="${ctx}/index">首页</a>  /  往期活动</h2>
		  </div>
		  
		    <ul class="list-group act-list">
		    	<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>活动名称</label><label class="pull-right">活动时间</label></li>
		    	<c:forEach items="${passActs }" var="act" varStatus="status">
				  	<li class="list-group-item"><span class="glyphicon glyphicon-grain"></span>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx}/act/detail/${act.actId}">${act.actTitle }</a><span class="pull-right">${act.actStartTime }</span></li>
				</c:forEach>
				  
			</ul>
		  
	</div>

		<div class="row">
			<nav id="pager">
				<ul class="pager">
					<li class="previous"><a href="#"><span
									aria-hidden="true">&larr;</span> 下一页</a></li>
					<li class="next"><a href="#">上一页 <span
							aria-hidden="true">&rarr;</span></a></li>
				</ul>
			</nav>
		</div>
</div>
	
	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="footer.jsp" />


</body>
<script>
			$(function() {

				/*小屏幕导航点击关闭菜单*/
				$('.navbar-collapse a').click(function() {
					$('.navbar-collapse').collapse('hide');
				});
				new WOW().init();
			})
		</script>
</html>