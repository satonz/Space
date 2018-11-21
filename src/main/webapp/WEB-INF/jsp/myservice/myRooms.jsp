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

</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="../header.jsp" />


	<section id="main" class="container" style="margin-top: 118px">

		<h3>我申请的场地</h3>
		<hr>

		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#pass" data-toggle="tab"> 已通过</a></li>

			<li><a href="#noPass" data-toggle="tab">不通过</a></li>
			<li><a href="#noDeal" data-toggle="tab">未处理</a></li>

		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="pass">
				<div class="row">
					<br>
					<c:forEach items="${apps }" var="theApp">

						<c:if test="${theApp.appStatus == true }">
							<div class="panel panel-success">
								<div class="panel-heading">${theApp.room.building.buiName }
									${theApp.room.roomNumber }</div>
								<div class="panel-body">
									<p>
										<label>开始使用时间：</label>${theApp.appStartTime }
									</p>
									<p>
										<label>使用结束时间：</label>${theApp.appEndTime }
									</p>
									<p>
										<label>申请使用说明：</label>${theApp.appInfo }
									</p>

								</div>
							</div>
						</c:if>

					</c:forEach>
				</div>
			</div>
			<div class="tab-pane fade in" id="noPass">
				<div class="row">
					<br>
					<c:forEach items="${apps }" var="theApp">

						<c:if
							test="${theApp.appStatus == false and theApp.appIsDealed == true }">
							<div class="panel panel-warning">
								<div class="panel-heading">${theApp.room.building.buiName }
									${theApp.room.roomNumber }</div>
								<div class="panel-body">
									<p>
										<label>开始使用时间：</label>${theApp.appStartTime }
									</p>
									<p>
										<label>使用结束时间：</label>${theApp.appEndTime }
									</p>
									<p>
										<label>申请使用说明：</label>${theApp.appInfo }
									</p>

								</div>
							</div>
						</c:if>

					</c:forEach>
				</div>
			</div>
			<div class="tab-pane fade in" id="noDeal">
				<div class="row">
					<br>
					<c:forEach items="${apps }" var="theApp">

						<c:if test="${theApp.appIsDealed == false }">
							<div class="panel panel-default">
								<div class="panel-heading">${theApp.room.building.buiName }
									${theApp.room.roomNumber }</div>
								<div class="panel-body">
									<p>
										<label>开始使用时间：</label>${theApp.appStartTime }
									</p>
									<p>
										<label>使用结束时间：</label>${theApp.appEndTime }
									</p>
									<p>
										<label>申请使用说明：</label>${theApp.appInfo }
									</p>

								</div>
							</div>
						</c:if>

					</c:forEach>
				</div>
			</div>
		</div>


	</section>

	<jsp:include page="../footer.jsp" />
</body>

</html>