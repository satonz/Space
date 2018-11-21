<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<!-- Title and other stuffs -->
		<title>查看日志</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="8"></c:param>
			</c:import>

			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">查看日志</a>
					</div>
					<div class="clearfix"></div>
				</div>
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

								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">查看日志文件</div>
										<div class="widget-icons pull-right">
											<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
											<a href="#" class="wclose"><i class="icon-remove"></i></a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd">

											<div class="error-log">
												${requestScope.content }
											</div>

										</div>
										<div class="widget-foot">
											<!-- Footer goes here -->
										</div>
									</div>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="clearfix"></div>

		</div>

		<!-- 底部 -->
		<c:import url="foot.jsp"></c:import>

	</body>

</html>