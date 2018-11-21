<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="space.po.Building"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<!-- Title and other stuffs -->
		<title>新增房间</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>

	</head>

	<body>
		<%
			Building building = (Building)request.getAttribute("building");
			String buildingType = building.getBuiId() == 0 ? "教学楼" : (building.getBuiId() == 1? "实验楼" : "综合楼");
			String buildingName = building.getBuiName();
		%>
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
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 修改房间信息</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">修改房间信息</a>
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

							<div class="col-md-12">

								<div class="widget wgreen">

									<div class="widget-head">
										<div class="pull-left">修改<%=buildingType %><%=buildingName %>的房间信息</div>
										<div class="widget-icons pull-right">
											<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
											<a href="#" class="wclose"><i class="icon-remove"></i></a>
										</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">
										<div class="padd">

											<!-- Form starts.  -->
											<form class="form-horizontal" role="form" action="update" >
												<input name="roomId" type="hidden" value="${requestScope.room.roomId }">
												<div class="form-group text-center">
													<label class="col-lg-12 control-label">${requestScope.tip }</label>
												</div>
												<div class="form-group">
													<label class="col-lg-4 control-label" style="width: 110px;">所属建筑类型</label>
													<div class="col-lg-8">
														<input type="text" class="form-control" placeholder="所属建筑类型" value="<%=buildingType %>" disabled="disabled">
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 control-label" style="width: 110px;">所属建筑名称</label>
													<div class="col-lg-8">
														<input type="text" class="form-control" placeholder="所属建筑名称" value="<%=buildingName %>" disabled="disabled">
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 control-label" style="width: 110px;">房间编号</label>
													<div class="col-lg-8">
														<input name="number" required="required" type="text" class="form-control" placeholder="房间编号" value="${requestScope.room.roomNumber}">
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label" style="width: 110px;">房间容量</label>
													<div class="col-lg-8">
														<input name="capacity" type="text" class="form-control" placeholder="房间容量" value="${requestScope.room.roomCapacity }">
													</div>
												</div>


												<div class="form-group">
													<div class="col-lg-offset-1 col-lg-1 col-md-offset-1 col-md-1 col-xs-5">
														<button type="submit" class="btn btn-default">确认修改</button>
													</div>
													<div class="col-lg-offset-1 col-lg-1 col-md-offset-1 col-md-1 col-xs-5">
														<a href="list?buildingId=<%=building.getBuiId() %>" class="btn btn-default">结束修改</a>
													</div>
												</div>

											</form>
										</div>
									</div>
									<div class="widget-foot">
										<!-- Footer goes here -->
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