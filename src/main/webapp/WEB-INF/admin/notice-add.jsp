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
		<title>发布公告</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>


		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="6"></c:param>
			</c:import>

			<!-- 主体内容 -->
			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 发布公告</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">发布公告</a>
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

								<div class="widget wgreen">

									<div class="widget-head">
										<div class="pull-left">填写公告内容</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">
										<div class="padd">

											<!-- Form starts.  -->
											<form class="form-horizontal" role="form" method="post" action="${ctx }/admin/notice/publish" >
												
												<div class="form-group text-center">
													<label class="col-lg-12 control-label">${param.tip }</label>
												</div>
												
												<div class="form-group">
													<label class="col-lg-4 control-label">公告标题</label>
													<div class="col-lg-8">
														<input name="title" required="required" type="text" class="form-control" placeholder="公告标题">
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-4 control-label">公告内容</label>
													<div class="col-lg-8">
														<textarea name="content" required="required" class="form-control" placeholder="公告内容"></textarea>
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
				<div class="clearfix"></div>

			</div>
			<!-- Content ends -->
		</div>
		<!-- 底部 -->
		<c:import url="foot.jsp"></c:import>
	</body>
</html>