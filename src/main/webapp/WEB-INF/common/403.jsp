<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--<link rel="icon" href="../../favicon.ico">-->

<title>404 not found</title>

<link href="${ctx }/css/bootstrap.min.css"	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">

<style >
    #pageNotFound{
        text-align: center;
        font-family: "FZShuTi","STLiti";
        font-size: 30px;
    }
</style>
</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="../jsp/header.jsp" />
	
	<section class="container" id="main">
		<div class="col-sm-3"></div>
		<div class="col-sm-6" id="pageNotFound">
            <br/>
			<img style="width: 300px;" src="http://www.easyicon.net/api/resizeApi.php?id=1161518&size=128" class="img-responsive  center-block"/>
			<br/>
			<p>403~ 资源不可用 ~</p>
			<br/>
			<span>403~ Resource unavailable ~</span>
		</div>
        <div class="col-sm-3"></div>
	</section>
	
	<jsp:include page="../jsp/footer.jsp" />

</body>
<script>
			$(function() {

				/*小屏幕导航点击关闭菜单*/
				$('.navbar-collapse a').click(function() {
					$('.navbar-collapse').collapse('hide');
				});
				new WOW().init();
			})
		</script>
</html>