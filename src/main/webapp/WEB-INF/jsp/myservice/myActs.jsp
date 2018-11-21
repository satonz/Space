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
<link href="${ctx }/css/myacts.css" rel="stylesheet">

</head>
<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="../header.jsp" />

	<div id="main" class="container" style="margin-top: 118px">
		<h3>我参加的活动</h3>
		<hr>
		<c:forEach items="${tickets }" var="ticket" varStatus="status">
			<section>
				<div class="row">
					<div class="col-md-6 ">
						<img src="${ctx }${ticket.activity.actImgPath}"
							class="img-responsive " alt=" " />
					</div>
					<div class="col-md-6 ">
						<h3 class="act-title">${ticket.activity.actTitle }</h3>
						<p class="act-intro">活动简介： ${ticket.activity.actIntroduce }</p>
						<p>活动开始时间： ${ticket.activity.actStartTime }</p>
						<p>活动结束时间： ${ticket.activity.actEndTime }</p>
						<a class="btn btn-info view-more"
							href="${ctx }/act/detail/${ticket.activity.actId}" role="button">查看详情&raquo;</a>
						<a href="${ctx }/myservice/printTicket/?tid=${ticket.ticketId}" target="_blank" class="btn btn-success" role="button">打印入场券</a>
					</div>
				</div>
			</section>

			<hr>
		</c:forEach>
	</div>
	


	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />
	
		

</body>
</html>