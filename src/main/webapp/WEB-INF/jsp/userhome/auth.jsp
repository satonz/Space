<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="space.po.Authentication"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${sessionScope.loginUser}" />
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--<link rel="icon" href="../../favicon.ico">-->

<title>场地借用管理系统</title>

<link href="${ctx }/css/bootstrap.min.css"	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">
<link href="${ctx }/css/personHome.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx }/css/jquery-labelauty.css">
<link type="text/css" rel="stylesheet"
	href="${ctx}/css/fileinput.min.css" />
<script type="text/javascript" src="${ctx}/js/fileinput.min.js"></script>
<script type="text/javascript" src="${ctx}/js/zh.js"></script>

</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="../header.jsp" />

	<!--个人主页-->
	<section id="main" class="container" >
		<!-- 侧边导航 -->
		<div class="col-sm-2 ">
			<jsp:include page="aside.jsp"></jsp:include>
		</div>
		<!-- 主体内容 -->
		<div class="col-sm-10 tab-content">
			<div>
				<div class="user-info">

					<div class="tab-header">
						<span>我的认证</span>
					</div>
					<!--如果还没有认证-->
					<c:choose>
						<c:when test="${empty authentication }">
							<div class="alert alert-warning">
								<p>您还没有认证呢！填写表单认证吧</p>
							</div>
							<!--认证表单-->
							<form action="${ctx }/user/auth" method="post"
								enctype="multipart/form-data" class="user-info"
								style="border-left: 0;">
								<div id="ul-radio">
									<span>认证类型:</span>
									<ul class="dowebok">
										<li><input type="radio" name="infType" checked="checked"
											data-labelauty="班级" value="${Authentication.INF_CLASS }">班级</li>
										<li><input type="radio" name="infType"
											data-labelauty="教师" value="${Authentication.INF_TEACHER }">教师</li>
										<li><input type="radio" name="infType"
											data-labelauty="社团"
											value="${Authentication.INF_ASSOCIATION }">社团</li>
										<li><input type="radio" name="infType"
											data-labelauty="院系" value="${Authentication.INF_INSTITUTE }">院系</li>
									</ul>
								</div>
								<p>
									<span>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</span> <input
										type="text" name="infName" id="input-infName">
								</p>
								<p>
									<span>认证综述：</span>
									<textarea rows="5" cols="30" name="infIntroduce"
										id="input-infIntroduce"></textarea>
								</p>
								<!-- <div>
									<span class="a-upload" style="margin-right: 35px;"> <input
										type="file" id="auth-file1" multiple="multiple" name="file">上传证件
									</span>
									<div class="changeImg">
										<img id="auth-img1" src="" />
									</div>
								</div> -->
								<p>
									<span>上传证件：必须能证明本人或团体身份，共两张，要求图片清晰，可看清身份证上的文字</span> <span>支持jpg、jpeg、png、gif格式，大小不超过2.0M</span>
								</p>
								<div class="row">

									<input id="authimg" name="authimg" type="file"
										class="projectfile" multiple="multiple"> <input
										id="authimgs" type="text" name="authimgs" hidden="hidden">
								</div>
								<br> <br>
								<p id="form-tip" hidden="hidden" style="color: red;"></p>
								<p>
									<span> <a class="btn btn-success"
										style="min-width: 150px;" id="auth-btn" type="submit"
										data-url="${ctx }/user/auth/"> <span
											class="glyphicon glyphicon-hand-down"></span>&nbsp;提交
									</a>
									</span>
								</p>
							</form>
						</c:when>


						<c:otherwise>
							<p>
								<span>是否已处理：</span> <span>${authentication.infIsDealed }</span>
							</p>
							<p>
								<span>认证状态：</span> <span>${authentication.infStatus }</span>
							</p>
							<p>
								<span>认证类型：</span> <span>${Authentication.getTypeToString(authentication.infType) }</span>
							</p>
							<p>
								<span>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</span> <span>${authentication.infName }</span>
							</p>
							<p>
								<span>认证综述：</span> <span>${authentication.infIntroduce }</span>
							</p>
							<p>
								<span>认证图片：</span>
								
							</p>
							<p>
								<c:forEach items="${authimgs }" var="img">
									<div>
										<img
										src="${ctx }/fileController/getImage?fileName=${img.imgPath }"
										class="img-responsive">
									</div>
								</c:forEach>
							<p>
							<c:if test="${authentication.infIsDealed == true && authentication.infStatus == false }">
								<p>
									<a href="${ ctx }/user/authAgain" class="btn btn-warning">再次认证</a>
								<p>
							</c:if>
						
						</c:otherwise>
					</c:choose>
				</div>

			</div>
		</div>
	</section>
	

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />
	<script>
		/* 此方法已废弃 */
		$("#auth-file1").change(function() {
			var objUrl = getObjectURL(this.files[0]);

			if (objUrl) {
				$("#auth-img1").attr("src", objUrl);
			}
		});

		function getObjectURL(file) {

			var url = null;
			if (window.createObjectURL != undefined) {
				url = window.createObjectURL(file);
			} else if (window.URL != undefined) {
				url = window.URL.createObjectURL(file);
			} else if (window.webkitURL != undefined) {
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
		//表单完整性验证 及 ajax提交
		$("#auth-btn").click(
				function() {
					var infName = $("#input-infName").val();
					var authimgs = $("#authimgs").val();
					var infIntroduce = $("#input-infIntroduce").val();
					var infType = $("input[name='infType']:checked").val();
					
					
					if (infName == "" || authimgs == "" || infIntroduce == ""
							|| infType == "") {
						$("#form-tip").html("表单未填完整！");
						$("#form-tip").show(300);
						return false;
					}
					$("#form-tip").hide(300);
					var url = $(this).data('url');
					$.post(url, {
						"infName" : infName,
						"authimgs" : authimgs,
						"infIntroduce" : infIntroduce,
						"infType" : infType,
					}, function(data) {
						if(data["login"] == "no"){
							$("#form-tip").html("未登录，游客不可以申请认证！");
							$("#form-tip").show(300);
							return false;
						}else if(data=["auth1"]=="no"){
							$("#form-tip").html("你已经认证过了，不可以再认证！");
							$("#form-tip").show(300);
							return false;
						}
						else if(data=["auth"]=="no"){
							$("#form-tip").html("由于一些原因，认证失败！");
							$("#form-tip").show(300);
							return false;
						}else if(data=[""]=="no"){
							$("#form-tip").html("图片信息保存失败，认证失败！");
							$("#form-tip").show(300);
							return false;
						}else{
							
							$("#form-tip").html("认证申请提交成功！");
							$("#form-tip").show(300);
							
							$("#input-infName").val('');
							$("#authimgs").val('');
							$("#input-infIntroduce").val('');
							
						}
					});

				});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#authimg").fileinput({
				language : 'zh',
				uploadUrl : "${ctx}/user/authimg/",
				autoReplace : true,
				maxFileCount : 3,
				allowedFileExtensions : [ "jpg", "png", "gif" ],
				browseClass : "btn btn-primary", //按钮样式 
				previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
			}).on("fileuploaded", function(e, data) {
				var res = data.response;
				var path = $("#authimgs").val();
				if (path == "") {
					path = res.success;
				} else {
					path = path + ";" + res.success;
				}
				$("#authimgs").attr("value", path);
			});

		});
	</script></
							body>
</html>