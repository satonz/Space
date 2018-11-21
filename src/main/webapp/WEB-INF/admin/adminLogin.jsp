<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="${ctx }/admin/style/font-awesome.css" />
	<link rel="stylesheet" href="${ctx }/admin/style/bootstrap.css" />
	<link href="${ctx }/admin/css/login.css" rel="stylesheet" type="text/css">
</head>

<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">Space后台管理系统登录界面</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="${ctx }/admin/login" method="post">
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper" style="text-align: center; padding: 0;">
							${param.tip }
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper">
							<label for="email" class="control-label fa-label"><i class="fa fa-user fa-medium icon-user"></i></label>
							<input type="email" class="form-control" id="email" name="email" placeholder="Email" value="admin@163.com">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium icon-lock"></i></label>
							<input type="password" class="form-control" id="password" name="password" placeholder="Password">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<input type="submit" value="Log in" class="btn btn-info">
							
						</div>
					</div>
				</div>
				<hr>

			</form>
			<div class="text-center">
				<a href="" class="templatemo-create-new">首页<i class="fa fa-arrow-circle-o-right"></i></a>
			</div>
		</div>
	</div>
</body>

</html>