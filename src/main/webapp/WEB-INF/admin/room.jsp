<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="space.po.Building"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<!-- Title and other stuffs -->
		<title>查看房间</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<!-- Main content starts -->

		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="4"></c:param>
			</c:import>
			
			<!-- Main bar -->
			<div class="mainbar">

				<!-- Page heading -->
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>

					<!-- Breadcrumb -->
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<!-- Divider -->
						<span class="divider">/</span>
						<a href="#" class="bread-current">场地管理</a>
					</div>

					<div class="clearfix"></div>

				</div>
				<!-- Page heading ends -->

				<!-- Matter -->

				<div class="matter">
					<div class="container">
						<!--
                    	作者：1242440175@qq.com
                    	时间：2017-03-06
                    	描述：主体内容
                    -->
						<div class="row">
							
							<div class="col-md-4">

								<div class="well" style="margin-top: 50px; font-size: 18px; font-weight: bold; line-height: 50px; padding: 0;">
									<a href="${ctx }/admin/room/toAddRoomPage?buildingId=${buildingId}" style="color: black; margin: 0; padding: 12px; display: block;"><img style="height: 50px; width: 50px;" src="../img/icon/icon_space.png" /> <span style="padding-left: 20px;">添加房间</span> <span class="pull-right"><i class="icon-plus-sign-alt"></i></span></a>
								</div>

							</div>
							
							<div class="col-md-3">

								<div class="well" style="margin-top: 50px; font-weight: bold; padding: 0;">
									<!-- ${ctx }/admin/building/delete?buildingId=${buildingId} -->
									<a href="javascript:if(confirm('确实要删除吗?这会删除该建筑相关的所有信息哦！'))location='${ctx }/admin/building/delete?buildingId=${buildingId}'" class="btn btn-danger" style=" color: #CCCCCC; font-size: 18px !important; line-height: 50px; margin: 0; padding: 12px; display: block;"><span style="padding-left: 20px;">删除该建筑<i class="icon-remove"></i></span> </a>
								</div>

							</div>
						</div>

						<div class="row">
							<div class="col-md-12">

								<div class="widget">

									<div class="widget-head">
										<div class="pull-left">房间</div>
										<div class="widget-icons pull-right">
											<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
											<a href="#" class="wclose"><i class="icon-remove"></i></a>
										</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">

										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>所属建筑类型</th>
													<th>所属建筑</th>
													<th>房间号</th>
													<th>房间容量</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="count" value="${page.pageSize * (page.currentPage - 1) }"></c:set>
												<c:forEach var="object" items="${list }">
													<c:set var="count" value="${count + 1}"></c:set>
													
													<tr>
														<td>${count }</td>
														<td>${buildingType }</td>
														<td>${buildingName }</td>
														<td>${object.roomNumber}</td>
														<td>${object.roomCapacity}</td>
														<td>
															<a href="${ctx }/admin/room/toEditPage?roomId=${object.roomId }" class="btn btn-xs btn-warning"><i class="icon-pencil"></i> </a>
															<a href="javascript:if(confirm('确实要删除吗?这会删除该房间相关的所有信息哦！'))location='${ctx }/admin/room/delete?retrieval=${retrieval }&buildingId=${buildingId }&page=${page.currentPage }&roomId=${object.roomId }'" class="btn btn-xs btn-danger"><i class="icon-remove"></i> </a>
														</td>
													</tr>
													
												</c:forEach>
												
											</tbody>
										</table>

										<div class="widget-foot">

											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/room/list?retrieval=${retrieval }"></c:param>
											</c:import>
											

											<div class="clearfix"></div>

										</div>

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

		<!-- 底部 -->
		<c:import url="foot.jsp"></c:import>
	</body>

</html>