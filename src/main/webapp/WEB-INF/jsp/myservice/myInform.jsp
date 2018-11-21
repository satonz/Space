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
<title>我的通知</title>

<link rel="stylesheet" href="${ctx }/css/timeline.css" />
<link href="${ctx }/css/bootstrap.min.css"	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">

<link href="${ctx }/css/jquery.toast.min.css" rel="stylesheet">

<script src="${ctx }/js/jquery.toast.min.js">
	
</script>

<style type="text/css">
h2.top_title {
	border-bottom: none;
	background: none;
	text-align: center;
	line-height: 32px;
	font-size: 20px
}

h2.top_title span {
	font-size: 12px;
	color: #666;
	font-weight: 500
}

.empty-content {
	margin-top: 100px;
	font-size: 60px;
	text-align: center;
	color: #ccc;
}
.cd-timeline-content p{
	font-size: 16px;
	line-height: 25px;
}
</style>
</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="../header.jsp" />

	<section id="main" class="container" style="margin-top: 118px">
		<br>
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#sys" data-toggle="tab"> 评论通知 <span
					class="label label-warning"></span></a></li>

			<li><a href="#comm" data-toggle="tab">系统通知&nbsp;<span
					class="label label-warning"></span></a></li>

		</ul>
		<div id="myTabContent" class="tab-content" >
			<div class="tab-pane fade in active" id="sys">
				<section id="cd-timeline" class="cd-container">
					<c:if test="${empty comminforms }">
						<div class="empty-content">没有评论通知！</div>
					</c:if>

					<c:forEach items="${comminforms }" var="commInf" varStatus="status">
						<c:choose>
							<c:when test="${status.index % 2 == 0}">
								<div class="cd-timeline-block">
									<div class="cd-timeline-img cd-movie"></div>

									<div class="cd-timeline-content">
										<c:choose>
											<c:when test="${commInf.isReaded() }">
												<div>
													<span class="label label-success">已读</span>
												</div>
											</c:when>
											<c:otherwise>
												<div>
													<span class="label label-warning">未读</span>
												</div>
											</c:otherwise>
										</c:choose>

										<p>
											${commInf.user.username } 在 活动《 <a
												href="${ctx }/act/detail/${commInf.comment.activity.actId }">${commInf.comment.activity.actTitle }</a>》
											中回复了您的评论 :<a> ${commInf.comment.commentContent }</a>

										</p>
										<span class="cd-date"> ${commInf.comminformTime }</span>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="cd-timeline-block">
									<div class="cd-timeline-img cd-picture"></div>

									<div class="cd-timeline-content">
										<c:choose>
											<c:when test="${commInf.isReaded() }">
												<div>
													<span class="label label-success">已读</span>
												</div>
											</c:when>
											<c:otherwise>
												<div>
													<span class="label label-warning">未读</span>
												</div>
											</c:otherwise>
										</c:choose>
										<p>
											${commInf.user.username } 在 活动《 <a
												href="${ctx }/act/detail/${commInf.comment.activity.actId }">${commInf.comment.activity.actTitle }</a>
											》 中回复了您的评论 : <a> ${commInf.comment.commentContent }</a>

										</p>
										<span class="cd-date"> ${commInf.comminformTime }</span>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</section>
			</div>
			<div class="tab-pane fade" id="comm">
				<section id="cd-timeline" class="cd-container">
					<c:if test="${empty sysinforms }">
						<div class="empty-content">没有系统通知！</div>
					</c:if>
					<c:forEach items="${sysinforms }" var="sys" varStatus="status">
						<c:choose>
							<c:when test="${status.index % 2 == 0}">
								<div class="cd-timeline-block">
									<div class="cd-timeline-img cd-movie"></div>

									<div class="cd-timeline-content">
										<c:choose>
											<c:when test="${sys.isReaded() }">
												<div>
													<span class="label label-success">已读</span>
												</div>
											</c:when>
											<c:otherwise>
												<div>
													<span class="label label-warning">未读</span>
												</div>
											</c:otherwise>
										</c:choose>
										<p>${sys.sysinformInfo }</p>
										<span class="cd-date"> ${sys.sysinformTime }</span>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="cd-timeline-block">
									<div class="cd-timeline-img cd-picture"></div>
									<div class="cd-timeline-content">
										<c:choose>
											<c:when test="${sys.isReaded() }">
												<div>
													<span class="label label-success">已读</span>
												</div>
											</c:when>
											<c:otherwise>
												<div>
													<span class="label label-warning">未读</span>
												</div>
											</c:otherwise>
										</c:choose>
										<p>${sys.sysinformInfo }</p>
										<span class="cd-date"> ${sys.sysinformTime }</span>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</section>
			</div>

		</div>
	</section>

	<jsp:include page="../footer.jsp" />
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