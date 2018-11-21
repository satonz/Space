<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<!-- Title and other stuffs -->
		<title>查看公告</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="">
		
		<c:import url="public.jsp"></c:import>
		
		<!-- 导入jq toast插件样式及js -->
		<link href="${ctx }/css/jquery.toast.min.css" rel="stylesheet">
		<script src="${ctx }/js/jquery.toast.min.js"></script>

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="6"></c:param>
			</c:import>

			<!-- Main bar -->
			<div class="mainbar">

				<!-- Page heading -->
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<!-- Divider -->
						<span class="divider">/</span>
						<a href="#" class="bread-current">公告管理</a>
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
										<div class="pull-left">快速搜索</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd">
											<div class="form quick-post">
												<!-- Edit profile form (not working)-->
												<form class="form-horizontal" method="post" action="${ctx }/admin/notice/list">
													<!-- Title -->
													<div class="form-group">
														<div class="col-lg-10 col-md-9 col-sm-10 col-xs-8">
															<input name="retrieval" type="text" class="form-control" id="title" placeholder="搜索" value="${retrieval }">
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
										<div class="pull-left">公告列表</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">

										<table class="table table-striped table-bordered table-hover" style="table-layout: fixed;">
											<thead>
												<tr>
													<th width="5%">#</th>
													<th width="25%">公告标题</th>
													<th width="35%">公告内容</th>
													<th width="20%">发布时间</th>
													<th width="15%">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="index" value="${page.pageSize * (page.currentPage - 1) + 1 }"/>
												<c:forEach var="notice" items="${notices }">
													<tr>
														<td>${index }</td>
														<td><p>${notice.noticeTitle }</p></td>
														<td><p>${notice.noticeContent }</p></td>
														<td>
															<fmt:formatDate value="${notice.noticeTime }" pattern="yyyy-MM-dd  HH:mm"/>
														</td>
														<td>
															<a onclick="deleteNotice(this, ${notice.noticeId})" href="javascript:void(0)" class="btn btn-xs btn-danger"><i class="icon-remove"></i> </a>
														</td>
													</tr>
													<c:set var="index" value="${index + 1 }"/>
												</c:forEach>

											</tbody>
										</table>

										<div class="widget-foot">

											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/notice/list?retrieval=${retrieval }"></c:param>
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
	<script type="text/javascript">
		function deleteNotice(element, id) {
			$.post("delete",
					{
						"id": id,
					},
					function (data) {
						if (data['status'] == 'TRUE') {
							$(element).parent().parent().remove();
							$.toast({
		    				    heading: '操作结果',
		    				    text: '删除成功',
		    				    showHideTransition: 'slide',
		    				    icon: 'success'
		    				})
						} else {
							$.toast({
								heading: '操作结果',
		    				    text: '删除失败',
							    showHideTransition: 'fade',
							    icon: 'error'
							})
						}
					});
		}
	</script>

</html>