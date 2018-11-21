<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<c:set var="buildingType" value=""></c:set>
<c:choose>
	<c:when test="${type == 0 }">
		<c:set var="buildingType" value="教学楼"></c:set>
	</c:when>
	<c:when test="${type == 1 }">
		<c:set var="buildingType" value="实验楼"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="buildingType" value="综合楼"></c:set>
	</c:otherwise>
</c:choose>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<!-- Title and other stuffs -->
		<title>场地管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>
		<!--
        	作者：1242440175@qq.com
        	时间：2017-03-07
        	描述：导入内容样式
        -->
		<link rel="stylesheet" href="../style/building.css" />

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="4"></c:param>
			</c:import>

			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">场地管理</a>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="matter">
					<div class="container">
						<!--
                    	作者：1242440175@qq.com
                    	时间：2017-03-06
                    	描述：主体内容
                    -->
						<div class="row">
							<div class="col-md-8">
								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">快速搜索</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd">
											<div class="form quick-post">
												<!-- Edit profile form (not working)-->
												<form class="form-horizontal">
													<!-- Title -->
													<div class="form-group">
														<input type="hidden" name="type" value="${type }">
														<div class="col-lg-6 col-md-8 col-sm-10 col-xs-8">
															<input type="text" name="retrieval" class="form-control" id="retrieval" value="${retrieval }" placeholder="搜索">
														</div>
														<div class="col-lg-1 col-md-4 col-sm-2 col-xs-4">
															<button type="submit" class="btn btn-success">搜索</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">

								<div class="well" style="margin-top: 50px; font-size: 18px; font-weight: bold; line-height: 50px; padding: 0;">
									<a href="${ctx }/admin/building/toAddBuilding?type=${type }" style="color: black; margin: 0; padding: 12px; display: block;"><img style="height: 50px; width: 50px;" src="../img/icon/icon_building.png" /> <span style="padding-left: 20px;">添加建筑</span> <span class="pull-right"><i class="icon-plus-sign-alt"></i></span></a>
								</div>

							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">
											${buildingType }
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd statement">

											<div class="row">
												<c:forEach var="object" items="${list }">
													
													<div class="col-md-4">
														<div class="well">
															<a href="${ctx }/admin/room/list?buildingId=${object.buiId}" style="display: block; padding: 10px 15px;">
																<h2>建筑名称:${object.buiName}</h2>
																<h3>介绍:${object.buiIntroduce}</h3>
																<h4>类型:${buildingType }</h4>
															</a>
														</div>
													</div>
												</c:forEach>
											</div>

										</div>

										<div class="widget-foot">

											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/building/list?type=${type }&retrieval=${retrieval }"></c:param>
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