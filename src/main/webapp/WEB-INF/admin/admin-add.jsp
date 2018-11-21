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
		<title>添加管理员</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<c:import url="public.jsp"></c:import>
		<!--导入系统信息样式-->
		<link rel="stylesheet" href="style/index.css" />

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

								<div class="widget wgreen">

									<div class="widget-head">
										<div class="pull-left">添加管理员</div>
										<div class="clearfix"></div>
									</div>

									<div class="widget-content">
										<div class="padd">

											<!-- Form starts.  -->
											<form class="form-horizontal" role="form" method="post" action="${ctx }/admin/add" >
												<div class="form-group text-center">
													${tip}
												</div>
												<div class="form-group">
													<label class="col-lg-4 col-md-4 col-xs-4 control-label">用户名</label>
													<div class="col-lg-8 col-md-8 col-xs-8">
														<input id="name" name="name" type="text" value="${name }" class="form-control" placeholder="用户名">
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 col-md-4 col-xs-4 control-label">邮箱</label>
													<div class="col-lg-8 col-md-8 col-xs-8">
														<input id="email" name="email" type="email" required="required" value="${email }" class="form-control" placeholder="邮箱">
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 col-md-4 col-xs-4 control-label">密码</label>
													<div class="col-lg-8 col-md-8 col-xs-8">
														<input id="password"  type="password" required="required" class="form-control" placeholder="密码">
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 col-md-4 col-xs-4 control-label">确认密码</label>
													<div class="col-lg-8 col-md-8 col-xs-8">
														<input id="pwd" name="pwd" required="required" type="password" class="form-control" placeholder="确认密码">
													</div>
												</div>

												<div class="form-group">
													<div class="col-lg-offset-1 col-lg-1 col-md-offset-1 col-md-1 col-xs-5">
														<button type="submit" class="btn btn-success" onclick="return check()">确认添加</button>
													</div>
												</div>
											</form>
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
		function check() {
			if ($("#name").val() == "") {
				alert("用户名不能为空!");
				return false;
			} 
			if ($("#email").val() == "") {
				alert("邮箱不能为空!");
				return false;
			}
			var password = $("#password").val();
			var pwd = $("#pwd").val();
			if (pwd != password) {
				alert("输入的两次密码不一致!");
				return false;
			} else {
				return true;
			}
		}
	
	</script>

</html>