<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>用户管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 导入公共样式及js -->
		<c:import url="public.jsp"></c:import>

	</head>

	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>

		<div class="content">
			<!-- 菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="7"></c:param>
			</c:import>
			
			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<!-- Divider -->
						<span class="divider">/</span>
						<a href="#" class="bread-current">用户管理</a>
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
												<form class="form-horizontal" method="post" action="${ctx }/admin/user/list">
													<div class="form-group">
														<div class="col-lg-8 col-md-6 col-sm-10 col-xs-8" style="margin-bottom: 10px;">
															<input name="retrieval" type="text" class="form-control" id="title" placeholder="用户名搜索" value="${retrieval }">
														</div>
														<div class="col-lg-2 col-md-3 col-sm-10 col-xs-8">
															<select name="type" class="form-control">
																<c:choose>
																	<c:when test="${type==0 }">
																		<option selected="selected" value="0">全部</option>
																		<option value="1">学生</option>
																		<option value="2">老师</option>
																		<option value="3">社团</option>
																		<option value="4">学院</option>
																	</c:when>
																	<c:when test="${type==1 }">
																		<option value="0">全部</option>
																		<option selected="selected" value="1">学生</option>
																		<option value="2">老师</option>
																		<option value="3">社团</option>
																		<option value="4">学院</option>
																	</c:when>
																	<c:when test="${type==1 }">
																		<option value="0">全部</option>
																		<option value="1">已通过</option>
																		<option selected="selected" value="2">老师</option>
																		<option value="3">社团</option>
																		<option value="4">学院</option>
																	</c:when>
																	<c:when test="${type==1 }">
																		<option value="0">全部</option>
																		<option value="1">学生</option>
																		<option value="2">老师</option>
																		<option selected="selected" value="3">社团</option>
																		<option value="4">学院</option>
																	</c:when>
																	<c:otherwise>
																		<option value="0">全部</option>
																		<option value="1">学生</option>
																		<option value="2">老师</option>
																		<option value="3">社团</option>
																		<option selected="selected" value="4">学院</option>
																	</c:otherwise>
																</c:choose>
															</select>
														</div>
														<div class="col-lg-1 col-md-3 col-sm-2 col-xs-4">
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
										<div class="pull-left">用户管理</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">

										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>用户名</th>
													<th>邮箱</th>
													<th>认证状态</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
											<c:set var="count" value="${page.pageSize * (page.currentPage - 1) }"></c:set>
											<c:forEach var="object" items="${list }">
												<c:set var="count" value="${count + 1 }"></c:set>
												<tr>
													<td>${count }</td>
													<td>${object.userName }</td>
													<td>${object.account }</td>
													<td>${object.realName }</td>
													<td>

													</td>
												</tr>
											</c:forEach>
											<c:if test="${count == (page.pageSize * (page.currentPage - 1) + 1) }">
												<tr>
													暂无数据
												</tr>
											</c:if>			
											</tbody>
										</table>

										<div class="widget-foot">
											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/user/list?type=${type }&retrieval=${retrieval }"></c:param>
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

		<!-- Footer starts -->
		<c:import url="foot.jsp"></c:import>
		<!-- Footer ends -->

	</body>

</html>