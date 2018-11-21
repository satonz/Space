<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">
			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="4"></c:param>
			</c:import>
			<!-- Main bar -->
			<div class="mainbar">

				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 新增房间</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">新增房间</a>
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
										<div class="pull-left">在实验楼8B下新增房间</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">
										<div class="padd">
	
											<!-- Form starts.  -->
											<form class="form-horizontal" role="form" action="save" >
											
												<div class="form-group text-center">
													${tip}
												</div>
											
												<input name="buildingId" type="hidden" value="${param.buildingId }">
												<div class="form-group text-center">
													<label class="col-lg-12 control-label">${param.tip }</label>
												</div>
												<div class="form-group">
													<label class="col-lg-4 control-label">房间编号</label>
													<div class="col-lg-8">
														<input name="number" required="required" type="text" class="form-control" placeholder="房间编号">
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label">房间容量</label>
													<div class="col-lg-8">
														<input name="capacity" required="required" type="text" class="form-control" placeholder="房间容量">
													</div>
												</div>


												<div class="form-group">
													<div class="col-lg-offset-1 col-lg-1 col-md-offset-1 col-md-1 col-xs-5">
														<button type="submit" class="btn btn-default">确认新增</button>
													</div>
													<div class="col-lg-offset-1 col-lg-1 col-md-offset-1 col-md-1 col-xs-5">
														<a class="btn btn-default" href="${ctx }/admin">结束新增</a>
													</div>
												</div>

											</form>
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