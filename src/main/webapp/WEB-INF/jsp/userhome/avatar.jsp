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
<script src="${ctx }/js/cropper.min.js"></script>
<script src="${ctx }/js/jquery.cookie.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">
<link href="${ctx }/css/personHome.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx }/css/jquery-labelauty.css">
<link rel="stylesheet" href="${ctx }/css/cropper.min.css">

<style>
    /*头像编辑*/
.avatar-wrapper {
  height: 370px;
  width: 100%;
  margin-top: 15px;
  box-shadow: inset 0 0 5px rgba(0,0,0,.25);
  background-color: #fcfcfc;
  overflow: hidden;
}

.avatar-wrapper img { display: block; height: auto; max-width: 100%;}

/*头像预览*/
.avatar-preview {
  margin-top: 15px;
  margin-right: 15px;
  border: 1px solid #eee;
  border-radius: 4px;
  background-color: #fff;
  overflow: hidden;
  height: 96px;
  width: 96px;
}

.avatar-preview:hover { border-color: #ccf; box-shadow: 0 0 5px rgba(0,0,0,.15);}
</style>
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
		<div class="col-sm-10">
			<div class="" id="crop-avatar">
		    <!-- Current avatar -->
		    
		    <div class="avatar-view" title="Change the avatar">
		    	<h3>当前头像，点击修改头像</h3>
		      <img src="${ctx }${sessionScope.profile.pfAvatar }" alt="Avatar" class="img-responsive" id="current-img">
		    </div>
		    <!-- Cropping modal -->
		    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		      <div class="modal-dialog modal-lg">
		        <div class="modal-content">
		          <form class="avatar-form" action="${ctx }/user/avatarupload/" enctype="multipart/form-data" method="post" accept="image/gif, image/jpeg,image/png">
		            <div class="modal-header">
		              <button type="button" class="close" data-dismiss="modal">&times;</button>
		              <h4 class="modal-title" id="avatar-modal-label">更改头像</h4>
		            </div>
		            <div class="modal-body">
		              <div class="avatar-body">
		
		                <!-- avatar_file(源文件),avatar_data(裁剪参数JSON[x,y,w,h]),avatar-src(源文件路径) -->
		                <div class="avatar-upload">
		                  <input type="hidden" class="avatar-src" name="avatar_src">
		                  <input type="hidden" class="avatar-data" name="avatar_data">
		                  <label for="avatarInput" class="btn btn-primary">选择图片</label>
		                  <input type="file" class="avatar-input" id="avatarInput" name="avatar_file" style="display: none;" accept="image/*">
		                </div>
		
		                <!-- Crop and preview -->
		                <div class="row">
		                  <div class="col-md-9">
		                    <div class="avatar-wrapper"></div>
		                  </div>
		                  <div class="col-md-3">
		                    <div class="avatar-preview preview-lg"></div>
		                    <div class="avatar-preview preview-md"></div>
		                    <div class="avatar-preview preview-sm"></div>
		                  </div>
		                </div>
		
		                <div class="row avatar-btns">
		                  <div class="col-md-9">
		                    <div class="btn-group">
		                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="90" title="Rotate 90 degrees">旋转图片</button>
		                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="15">15deg</button>
		                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="30">30deg</button>
		                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="45">45deg</button>
		                    </div>
		                  </div>
		                  <div class="col-md-3">
		                    <button type="submit" class="btn btn-primary btn-block avatar-save">提交</button>
		                  </div>
		                </div>
		              </div>
		            </div>
		            <!-- <div class="modal-footer">
		              <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div> -->
		          </form>
		        </div>
		      </div>
		    </div><!-- /.modal -->
		
		    <!-- Loading state -->
		    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
		  </div>
        
        </div>
	</section>

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />


	
	<script src="${ctx }/js/mycropper.js">
		$("#current-img").change(function(){
		  var src = $("#current-img").attr("src");
		  $("#aside-img").attr("src",src);
		  $("#navbar-avatar").attr("src",src);
		});
	</script>

</body>
</html>