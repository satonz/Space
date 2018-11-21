<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx"
	value="http://${header['host']}${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>发布活动</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:import url="public.jsp"></c:import>
<!--
        	作者：1242440175@qq.com
        	时间：2017-03-08
        	描述：导入图片上传相关文件
        -->
<style>
.file {
	position: relative;
	display: inline-block;
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 4px;
	padding: 4px 12px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
}

.file input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
	width: 100%;
	height: 100%;
}

.file:hover {
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}
</style>


<!-- 导入百度UEditor插件 -->
<script type="text/javascript" charset="utf-8"
	src="../../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../../ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="../../ueditor/lang/zh-cn/zh-cn.js"></script>

</head>

<body>
	<form method="post" enctype="multipart/form-data"></form>
	<!-- 头部 -->
	<c:import url="head.jsp"></c:import>

	<div class="content">
		<!-- 左边菜单 -->
		<c:import url="left.jsp">
			<c:param name="number" value="5"></c:param>
		</c:import>
		<!-- 内容主体 -->
		<div class="mainbar">
			<div class="page-head">
				<h2 class="pull-left">
					<i class="icon-home"></i> 发布活动
				</h2>
				<div class="bread-crumb pull-right">
					<a href="index.html"><i class="icon-home"></i> 首页</a> <span
						class="divider">/</span> <a href="#" class="bread-current">发布活动</a>
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- 内容 -->
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
									<div class="pull-left">填写表单</div>
									<div class="widget-icons pull-right">
										<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
										<a href="#" class="wclose"><i class="icon-remove"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="widget-content">
									<div class="padd">

										<!-- Form starts.  -->
										<form class="form-horizontal" role="form">

											<div class="form-group">
												<label class="col-lg-4 control-label">活动标题</label>
												<div class="col-lg-8">
													<input id="title" type="text" class="form-control"
														placeholder="活动标题" required="required">
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-4 control-label">活动简介</label>
												<div class="col-lg-8">
													<textarea id="introduce" class="form-control" rows="3"
														placeholder="活动简介" required="required"></textarea>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-4 control-label">开始时间</label>
												<div class="col-lg-3 col-md-4">
													<input id="startTime" type="datetime-local"
														class="form-control" placeholder="活动开始时间"
														required="required">
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-4 control-label">结束时间</label>
												<div class="col-lg-3 col-md-4">
													<input id="endTime" type="datetime-local"
														class="form-control" placeholder="活动结束时间"
														required="required">
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-4 col-md-6 control-label">入场券数量</label>
												<div class="col-lg-2 col-md-2">
													<input id="tickets" type="number" class="form-control"
														value="0">
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-3 col-md-6 control-label">选择场地</label>
												<div class="col-lg-3 col-md-3" style="margin-bottom: 10px;">
													<select id="buildingType" class="form-control"
														required="required" onchange="changeBuildingType()">
														<option value="0">教学楼</option>
														<option value="1">实验楼</option>
														<option value="2">综合楼</option>
													</select>
												</div>
												<div class="col-lg-3 col-md-3" style="margin-bottom: 10px;">
													<select id="buildingId" class="form-control"
														required="required" onchange="changeBuildingId()">
														<option>选择建筑</option>

													</select>
												</div>
												<div class="col-lg-3 col-md-3" style="margin-bottom: 10px;">
													<select id="roomId" class="form-control"
														required="required">
														<option>选择房间</option>

													</select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-4 control-label">宣传主图片</label>
												<div class="col-lg-8">
													<a href="javascript:;" class="file"> <input type="file"
														id="file" required="required"> <img id="img"
														src="../img/img_bg.jpg" />
													</a>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-4 control-label">海报内容</label>
												<div class="col-lg-8">

													<!-- 百度UEditor插件 -->
													<script id="editor" type="text/plain"
														style="width: 100%; height: 500px;"></script>

												</div>
											</div>

											<div class="form-group">
												<div class="col-lg-offset-1 col-lg-9">
													<button id="submit" type="button" class="btn btn-default">发布</button>
												</div>
											</div>

										</form>
									</div>
								</div>
								<div class="widget-foot">
									<!-- Footer goes here -->
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

	</div>
	<!-- 底部 -->
	<c:import url="foot.jsp"></c:import>


</body>

<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');
</script>
<script>
	var ctx = "${ctx}";
	$(document).ready(
			function() {

				$(".file").on(
						"change",
						"input[type='file']",
						function() {
							var formData = new FormData($('form')[0]);
							formData.append("file", $(this).get(0).files[0]);

							var imgPath = $(this).val();
							if (imgPath == "") {
								alert("请选择上传图片！");
								return;
							}
							//判断上传文件的后缀名
							var strExtension = imgPath.substr(imgPath
									.lastIndexOf('.') + 1);
							if (strExtension != 'jpg' && strExtension != 'gif'
									&& strExtension != 'png'
									&& strExtension != 'bmp'
									&& strExtension != 'jpeg') {
								alert("请选择图片文件");
								return;
							}
							$.ajax({
								url : "../file/upload",
								type : "POST",
								data : formData,
								processData : false, // 告诉jQuery不要去处理发送的数据
								contentType : false, // 告诉jQuery不要去设置Content-Type请求头
								success : function(data) {
									$("#img").attr("src", ctx + data[1]);
								},
								error : function(XMLHttpRequest, textStatus,
										errorThrown) {
									alert("上传失败，请检查网络后重试");
								}
							});
						})

				//提交表单
				$("#submit").click(function() {
					var title = $("#title").val();
					var introduce = $("#introduce").val();
					var startTime = $("#startTime").val();
					var endTime = $("#endTime").val();

					if (startTime == "") {
						alert("活动开始时间不能为空");
						return;
					}
					if (endTime == "") {
						alert("活动开始时间不能为空");
						return;
					}
					if (endTime <= startTime) {
						alert("活动结束时间应该大于活开始时间");
						return;
					}

					var tickets = $("#tickets").val();
					var roomId = $("#roomId").val();
					var imgPath = $("#img")[0].src;
					var detail = UE.getEditor('editor').getContent();

					if (roomId == "选择房间") {
						alert("房间不能为空");
						return;
					}

					$.ajax({
						type : "post",
						url : "save",
						//要发送的数据，格式为{'val1':"1",'val2':"2"}
						data : JSON.stringify({
							title : title,
							introduce : introduce,
							startTime : startTime,
							endTime : endTime,
							tickets : tickets,
							roomId : roomId,
							imgPath : imgPath,
							detail : detail,
						}),
						dataType : "json",//后台返回处理数据的格式
						contentType : "application/json",
						success : function(data) {
							if (data[0] == "TRUE") {
								window.location = "list";
							} else {
								alert("未知错误");
							}
						},
						error : function(msg) {
							alert("未知错误");
						},
					})
				})
			});
</script>
<script type="text/javascript">
	//建筑类型改变
	function changeBuildingType() {
		var buildingType = document.getElementById("buildingType").value;
		var buildingId = document.getElementById("buildingId");
		var roomId = document.getElementById("roomId");
		$.ajax({
			type : "post",
			url : "../building/getBuildingsByType",
			data : {
				'type' : buildingType
			},
			dataType : "json",//后台返回处理数据的格式
			success : function(data) {
				var obj = eval(data);
				buildingId.options.length = 0;
				roomId.options.length = 0;
				buildingId.options.add(new Option("选择建筑", "选择建筑"));
				roomId.options.add(new Option("选择房间", "选择房间"));
				if (obj.length == 0) {
					alert("还没有该类型的建筑");
					buildingId.options.add(new Option("选择房间", "选择房间"));
				} else {
					for (var n = 0; n < obj.length; n++) {
						buildingId.options.add(new Option(obj[n].buiName,
								obj[n].buiId));
					}
				}
			},
			error : function(msg) {
				alert("未知错误");
			},
		})
	}
	//建筑ID改变
	function changeBuildingId() {
		var buildingId = document.getElementById("buildingId").value;
		var roomId = document.getElementById("roomId");
		$.ajax({
			type : "post",
			url : "../room/getRoomsByBuildingId",
			data : {
				'buildingId' : buildingId
			},
			dataType : "json",//后台返回处理数据的格式
			success : function(data) {
				var obj = eval(data);
				roomId.options.length = 0;
				if (obj.length == 0) {
					alert("该建筑还没有房间");
					roomId.options.add(new Option("选择房间", "选择房间"));
				} else {
					for (var n = 0; n < obj.length; n++) {
						roomId.options.add(new Option(obj[n].roomNumber,
								obj[n].roomId));
					}
				}
			},
			error : function(msg) {
				alert("未知错误");
			},
		})
	}
</script>
</html>