<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>发布活动</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>

	</head>

	<body>
		<form method="post" enctype="multipart/form-data"></form>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">
			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="5"></c:param>
			</c:import>
			<!-- 内容主体 -->
			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 活动详情</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">活动详情</a>
					</div>
					<div class="clearfix"></div>
				</div>
				<!-- 内容 -->
				<div class="matter">
					<div class="container">
						<!--
                    	作者：1242440175@qq.com
                    	时间：2017-03-06
                    	描述：主体内容
                    -->
						<div class="row">

							<div class="col-md-12">

								<div class="widget wgreen">

									<div class="widget-head">
										<div class="pull-left">查看活动详情</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">
										<div class="padd">

											<!-- Form starts.  -->
											<form class="form-horizontal" role="form" >

												<div class="form-group">
													<label class="col-lg-4 control-label">活动标题</label>
													<div class="col-lg-8">
														${activity.actTitle }
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label">活动简介</label>
													<div class="col-lg-8">
														${activity.actIntroduce }
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label" >开始时间</label>
													<div class="col-lg-8">
														<fmt:formatDate value="${activity.actStartTime }" pattern="yyyy-MM-dd HH:mm"/>
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 control-label" >结束时间</label>
													<div class="col-lg-8">
														<fmt:formatDate value="${activity.actEndTime }" pattern="yyyy-MM-dd HH:mm"/>
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 col-md-6 control-label">入场券数量</label>
													<div class="col-lg-2 col-md-2">
														${activity.actTicket }
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-lg-4 col-md-4 control-label">活动场地</label>
													<div class="col-lg-8 col-md-8" style="margin-bottom: 10px;">
														${space }
													</div>
													
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label">宣传主图片</label>
													<div class="col-lg-8">
														<a href="javascript:;" class="file">
														    <img id="img" src="${ctx }${activity.actImgPath }" />
														</a>
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label">海报内容</label>
													<div class="col-lg-8">
														${activity.actDetail }
													</div>
												</div>

											</form>
										</div>
									</div>
								</div>

							</div>

							<div class="col-md-12">
								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">持票人</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>账号名称</th>
													<th>获票时间</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="count" value="0"></c:set>
												<c:forEach var="object" items="${tickets }">
													<c:set var="count" value="${count + 1}"></c:set>
													<tr>
														<td>${count }</td>
														<td>${object.user.username }</td>
														<td>
															<fmt:formatDate value="${object.ticketTime }" pattern="yyyy-DD-dd HH:mm:ss" />
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										</div>
									</div>
								</div>
							</div>
						

						</div>

					</div>

					<!-- Matter ends -->

				</div>

				<!-- Mainbar ends -->
				<div class="clearfix"></div>

			</div>
			<!-- Content ends -->

		</div>
		<!-- 底部 -->
		<c:import url="foot.jsp"></c:import>
		
	</body>

</html>