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
		<title>系统信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>
		
		<!--导入系统信息样式-->
		<link rel="stylesheet" href="${ctx }/admin/style/index.css" />

	</head>

	<body>

		<c:import url="head.jsp"></c:import>

		<!-- Main content starts -->
		<div class="content">

			<c:import url="left.jsp"></c:import>

			<!-- Main bar -->
			<div class="mainbar">

				<!-- Page heading -->
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>

					<!-- Breadcrumb -->
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<!-- Divider -->
						<span class="divider">/</span>
						<a href="#" class="bread-current">系统设置</a>
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

								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">系统信息</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd">

											<div class="error-log" style="height: auto;">

												<div class="result-wrap">
													<div class="result-title">
														<h1>系统基本信息</h1>
													</div>
													<div class="result-content">
														<ul class="sys-info-list">
															<li>
																<label class="res-lab">操作系统</label><span class="res-info">${systemInformation.osName}</span>
															</li>
															<li>
																<label class="res-lab">版本</label><span class="res-info">${systemInformation.osVersion}</span>
															</li>
															<li>
																<label class="res-lab">系统时间</label><span class="res-info">${systemInformation.osTime}</span>
															</li>
															<li>
																<label class="res-lab">JAVA版本</label><span class="res-info">${systemInformation.javaVersion}</span>
															</li>
															<li>
																<label class="res-lab">JAVA平台</label><span class="res-info">${systemInformation.sunDesktop}</span>
															</li>
															<li>
																<label class="res-lab"></label><span class="res-info"></span>
															</li>
															<li>
																<label class="res-lab">服务器域名/IP</label><span class="res-info">${systemInformation.osIp}</span>
															</li>
															<li>
																<label class="res-lab"></label><span class="res-info"></span>
															</li>
															<li>
																<label class="res-lab">服务器名称</label><span class="res-info">${systemInformation.serverName}</span>
															</li>
															<li>
																<label class="res-lab">开放端口</label><span class="res-info">${systemInformation.serverPort}</span>
															</li>
															<li>
																<label class="res-lab">窗口IP</label><span class="res-info">${systemInformation.serverHost}</span>
															</li>
															<li>
																<label class="res-lab">服务器协议</label><span class="res-info">${systemInformation.serverProtocol}</span>
															</li>
															<!--  
															<li>
																<label class="res-lab"></label><span class="res-info"></span>
															</li>
															<li>
																<label class="res-lab">企业邮箱</label><span class="res-info">暂无<a href="">绑定</a></span>
															</li>
															-->
														</ul>
													</div>
												</div>
												<div class="result-wrap">
													<div class="result-title">
														<h1>使用帮助</h1>
													</div>
													<div class="result-content">
														<ul class="sys-info-list">
															<li>
																<label class="res-lab">遇到问题请联系：</label><span class="res-info">admin@admin.com</span>
															</li>

														</ul>
													</div>
												</div>
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

				<!-- Matter ends -->

			</div>

			<!-- Mainbar ends -->
			<div class="clearfix"></div>

		</div>
		<!-- Content ends -->

		<c:import url="foot.jsp"></c:import>

	</body>

</html>