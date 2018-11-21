<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>查看日志</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<c:import url="public.jsp"></c:import>

	</head>
	<body>
		<!-- 导入头部 -->
		<c:import url="head.jsp"></c:import>
		<!-- 中间部分 -->
		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="8"></c:param>
			</c:import>
			
			<!-- 内容 -->
			<div class="mainbar">

				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>

					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">日志管理</a>
					</div>

					<div class="clearfix"></div>

				</div>
				<!-- Page heading ends -->

				<!-- 主体内容 -->
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
										<div class="pull-left">快速搜索</div>
										<div class="widget-icons pull-right">
											<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
											<a href="#" class="wclose"><i class="icon-remove"></i></a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd">
											<div class="form quick-post">
												<!-- 搜索栏 -->
												<form class="form-horizontal" action="${ctx }/admin/log/list" method="post">
													<input name="type" type="hidden" value="${param.type }">
													<div class="form-group">
														<div class="col-lg-10 col-md-9 col-sm-10 col-xs-8">
															<input name="retrieval" type="text" class="form-control" id="title" placeholder="搜索" value="${param.retrieval }">
														</div>
														<div class="col-lg-2 col-md-3 col-sm-2 col-xs-4">
															<button type="submit" class="btn btn-success">搜索</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">

								<div class="widget">

									<div class="widget-head">
										<div class="pull-left">日志列表</div>
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
													<th>日志名称</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="count" value="${page.pageSize * (page.currentPage - 1) }"></c:set>
												<c:forEach var="string" items="${files }">
													<c:set var="count" value="${count + 1 }"></c:set>
													<tr>
														<td>${count }</td>
														<td><a href="get?fileName=${string }">${string }</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

										<div class="widget-foot">
											<!-- 导入分页 -->
											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/log/list?type=${param.type}&retrieval=${param.retrieval}"></c:param>
											</c:import>
											<div class="clearfix"></div>
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

		<!-- 导入底部 -->
		<c:import url="foot.jsp"></c:import>

	</body>

</html>