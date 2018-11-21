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
		<title>查看主评论</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 导入公共样式及js -->
		<c:import url="public.jsp"></c:import>
		
		<!-- 导入jq toast插件样式及js -->
		<link href="${ctx }/css/jquery.toast.min.css" rel="stylesheet">
		<script src="${ctx }/js/jquery.toast.min.js"></script>
	

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">
			<!-- 菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="5"></c:param>
			</c:import>
			
			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<!-- Divider -->
						<span class="divider">/</span>
						<a href="#" class="bread-current">一级评论</a>
					</div>
					<div class="clearfix"></div>
				</div>

				<!-- 内容主体 -->
				<div class="matter">
					<div class="container">
					<!--
                   	作者：1242440175@qq.com
                   	时间：2017-03-06
                   	描述：主体内容
                    -->
                    	<!-- 搜索框 -->
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
												<!-- Edit profile form (not working)-->
												<form class="form-horizontal" method="post" action="${ctx }/admin/comment/list">
													<input type="hidden" name="aType" value="${aType }">
													<div class="form-group">
														<div class="col-lg-10 col-md-9 col-sm-10 col-xs-8" style="margin-bottom: 10px;">
															<input name="retrieval" type="text" class="form-control" id="title" placeholder="搜索评论内容" value="${retrieval }">
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
										<div class="pull-left">一级评论列表</div>
										<div class="widget-icons pull-right">
											<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
											<a href="#" class="wclose"><i class="icon-remove"></i></a>
										</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">

										<table class="table table-striped table-bordered table-hover" style="table-layout: fixed;">
											<thead>
												<tr>
													<th width="5%">#</th>
													<th width="20%">活动标题</th>
													<th width="35%">评论内容</th>
													<th width="15%">作者</th>
													<th width="15%">评论时间</th>
													<th width="10%">操作</th>
												</tr>
											</thead>
											<tbody>
											<c:set var="count" value="${page.pageSize * (page.currentPage - 1) }"></c:set>
											<c:forEach var="object" items="${list }">
												<c:set var="count" value="${count + 1 }"></c:set>
												<tr>
													<td>${count }</td>
													<td>${object.actTitle }</td>
													<td>${object.content }</td>
													<td>${object.userName }</td>
													<td>
														<fmt:formatDate value="${object.time }" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
													<td>
														<a onclick="deleteComment(this, ${object.id})" href="javascript:void(0)" class="btn btn-xs btn-danger"><i class="icon-remove"></i> </a>
													</td>
												</tr>
											</c:forEach>


											</tbody>
										</table>

										<div class="widget-foot">
											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/comment/list?retrieval=${retrieval }"></c:param>
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
		
		<!-- 底部 -->
		<c:import url="foot.jsp"></c:import>

	</body>
	<script type="text/javascript">
		function deleteComment(element, id) {
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