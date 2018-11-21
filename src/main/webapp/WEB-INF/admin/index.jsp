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
		<title>首页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>
		<!--导入系统信息样式-->
		<link rel="stylesheet" href="${ctx }/admin/style/index.css" />

	</head>
	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>


		<div class="content">

			<!-- 左边菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="1"></c:param>
			</c:import>

			<!-- 内容 -->
			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<span class="divider">/</span>
						<a href="#" class="bread-current">控制台</a>
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
										<div class="pull-left">未来7天使用信息</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<table class="table table-striped table-bordered table-hover" style="table-layout: fixed;">
											<thead>
												<tr>
													<c:forEach var="date" items="${dates }">
														<th class="text-center">
															<fmt:formatDate value="${date}"  pattern="yyyy-MM-dd"/>
														</th>
													</c:forEach>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>
														<c:forEach var="application" items="${applications0 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd HH:mm"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime}" pattern="yyyy-MM-dd HH:mm"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
													<td>
														<c:forEach var="application" items="${applications1 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
													<td>
														<c:forEach var="application" items="${applications2 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
													<td>
														<c:forEach var="application" items="${applications3 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
													<td>
														<c:forEach var="application" items="${applications4 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
													<td>
														<c:forEach var="application" items="${applications5 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
													<td>
														<c:forEach var="application" items="${applications6 }">
															<div class="well">
																<h4>地点:${application.space }</h4>
																<h4>申请人:${application.username }</h4>
																<h4>使用时间:</h4>
																<h4>
																	<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd"/>
																 <br>至<br> 
																 	<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd"/>
																 </h4>
															</div>
														</c:forEach>
													</td>
												</tr>
											</tbody>
										</table>
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