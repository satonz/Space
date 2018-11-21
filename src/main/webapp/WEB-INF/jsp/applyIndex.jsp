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

<title>场地借用管理系统</title>

<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script src="${ctx }/js/bootstrap.min.js"></script>
<link href="${ctx }/css/base.css" rel="stylesheet">
<link href="${ctx }/css/apply-index.css" rel="stylesheet">
<link href="${ctx }/css/apply-form.css" rel="stylesheet">
</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="header.jsp" />

	<section id="main">
		<div>
			<aside class="col-sm-2 aside-menu" id="aside">
				<div>
					<h3>所有场地</h3>
				</div>
				<ul class="tree">
					<!-- <li><a href="">所有场地</a></li> -->

					<li><span>教学楼</span>
						<ul>
							<c:forEach items="${classBuildings }" var="building"
								varStatus="status">
								<li><a href="#b${building.buiId }">${building.buiName }</a></li>
							</c:forEach>
						</ul></li>
					<li><span>实验楼</span>
						<ul>
							<c:forEach items="${labBuildings }" var="building"
								varStatus="status">
								<li><a href="#b${building.buiId }">${building.buiName }</a></li>
							</c:forEach>
						</ul></li>
					<li><span>综合楼</span>
						<ul>
							<c:forEach items="${complexBuildings }" var="building"
								varStatus="status">
								<li><a href="#b${building.buiId }">${building.buiName }</a></li>
							</c:forEach>
						</ul></li>
				</ul>
			</aside>

			<div class="col-sm-10 " id="space-list">
				<p class="apply-tip">
					申请须知：<br> 1.认证类型为班级，社团，教师，学院可申请普通教室;<br>
					2.认证类型为教师才能申请1实验室;<br> 3.认证类型为社团，学院才能申请综合楼；
				</p>
				<c:choose>
					<c:when test="${empty sessionScope.loginUser }">
						<!-- 未登录 -->

						<div class="row">
							<!-- <div class="b-title">教学楼</div> -->
							<c:forEach items="${classBuildings }" var="building"
								varStatus="status">
								<div class="building-div">
									<a class="target-fix" id="b${building.buiId }"></a> <span>${building.buiName }</span>
									<p>${building.buiIntroduce }</p>
								</div>
								<div class="row">
									<c:forEach items="${building.rooms }" var="room"
										varStatus="status">
										<div class="col-sm-4">
											<div class="panel panel-warning">
												<div class="panel-heading">
													<span class="bui-name">${building.buiName }
														${room.roomNumber }</span>
													<!-- <span class="label label-success pull-right">可用</span> -->
												</div>
												<div class="panel-body">
													<p>
														<label>类型：</label>普通教室
													</p>
													<p>
														<label>容量：</label> ${room.roomCapacity }座位
													</p>
													<p>
														<a class="btn btn-sm btn-info nologin">申请该场地</a>
														&nbsp;&nbsp;<a class="btn btn-sm btn-warning weekUse"
															data-id="${room.roomId }">未来一周的使用情况</a>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<!-- <div class="b-title">实验楼</div> -->
							<c:forEach items="${labBuildings }" var="building"
								varStatus="status">

								<div class="building-div">
									<a class="target-fix" id="b${building.buiId }"></a> <span>${building.buiName }</span>
									<p>${building.buiIntroduce }</p>
								</div>
								<div class="row">
									<c:forEach items="${building.rooms }" var="room"
										varStatus="status">
										<div class="col-sm-4">
											<div class="panel panel-info">
												<div class="panel-heading">
													<span class="bui-name">${building.buiName }
														${room.roomNumber }</span>
												</div>
												<div class="panel-body">
													<p>
														<label>类型：</label>实验室
													</p>
													<p>
														<label>容量：</label> ${room.roomCapacity }座位
													</p>
													<p>
														<a class="btn btn-sm btn-info  nologin">申请该场地</a>
														&nbsp;&nbsp;<a class="btn btn-sm btn-warning weekUse"
															data-id="${room.roomId }">未来一周的使用情况</a>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<!-- <div  class="b-title">综合楼</div> -->
							<c:forEach items="${complexBuildings }" var="building"
								varStatus="status">
								<a class="target-fix" id="b${building.buiId }"></a>
								<div class="building-div">
									<span>${building.buiName }</span>
									<p>${building.buiIntroduce }</p>
								</div>
								<div class="row">
									<c:forEach items="${building.rooms }" var="room"
										varStatus="status">
										<div class="col-sm-4">
											<div class="panel panel-danger">
												<div class="panel-heading">
													<span class="bui-name">${building.buiName }
														${room.roomNumber }</span>
												</div>
												<div class="panel-body">
													<p>
														<label>类型：</label>综合场地
													</p>
													<p>
														<label>容量：</label> ${room.roomCapacity }座位
													</p>
													<p>
														<a class="btn btn-sm btn-info  nologin">申请该场地</a>
														&nbsp;&nbsp;<a class="btn btn-sm btn-warning weekUse"
															data-id="${room.roomId }">未来一周的使用情况</a>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>

					</c:when>

					<c:otherwise>
						<!-- 已登录 -->

						<div class="row">
							<!-- <div class="b-title">教学楼</div> -->
							<c:forEach items="${classBuildings }" var="building"
								varStatus="status">
								<div class="building-div clearfix">
									<a class="target-fix" id="b${building.buiId }"></a> <span>${building.buiName }</span>
									<p>${building.buiIntroduce }</p>
								</div>
								<div class="row">
									<c:forEach items="${building.rooms }" var="room"
										varStatus="status">
										<div class="col-sm-4">
											<div class="panel panel-info">
												<div class="panel-heading">
													<span class="bui-name">${building.buiName }
														${room.roomNumber }</span>
												</div>
												<div class="panel-body">
													<p>
														<label>类型：</label><span>普通教室</span>
													</p>
													<p>
														<label>容量：</label> <span>${room.roomCapacity }座位</span>
													</p>
													<p>
														<a class="btn btn-sm btn-info applyform"
															data-bid="${building.buiId }"
															data-roomid="${room.roomId }"
															data-url="${ctx }/apply/applyForm"
															data-canapplyurl="${ctx }/apply/canapply">申请该场地</a>
														&nbsp;&nbsp;<a class="btn btn-sm btn-warning weekUse"
															data-id="${room.roomId }">未来一周的使用情况</a>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<!-- <div class="b-title">实验楼</div> -->
							<c:forEach items="${labBuildings }" var="building"
								varStatus="status">

								<div class="building-div clearfix">
									<a class="target-fix" id="b${building.buiId }"></a> <span>${building.buiName }</span>
									<p>${building.buiIntroduce }</p>
								</div>
								<div class="row">
									<c:forEach items="${building.rooms }" var="room"
										varStatus="status">
										<div class="col-sm-4">
											<div class="panel panel-warning">
												<div class="panel-heading">
													<span class="bui-name">${building.buiName }
														${room.roomNumber }</span>
												</div>
												<div class="panel-body">
													<p>
														<label>类型：</label><span>实验室</span>
													</p>
													<p>
														<label>容量：</label> <span>${room.roomCapacity }座位</span>
													</p>
													<p>
														<a class="btn btn-sm btn-info applyform"
															data-bid="${building.buiId }"
															data-roomid="${room.roomId }"
															data-url="${ctx }/apply/applyForm"
															data-canapplyurl="${ctx }/apply/canapply">申请该场地</a>
														&nbsp;&nbsp;<a class="btn btn-sm btn-warning weekUse"
															data-id="${room.roomId }">未来一周的使用情况</a>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<!-- <div  class="b-title">综合楼</div> -->
							<c:forEach items="${complexBuildings }" var="building"
								varStatus="status">
								<a class="target-fix" id="b${building.buiId }"></a>
								<div class="building-div clearfix">
									<span>${building.buiName }</span>
									<p>${building.buiIntroduce }</p>
								</div>
								<div class="row">
									<c:forEach items="${building.rooms }" var="room"
										varStatus="status">
										<div class="col-sm-4">
											<div class="panel panel-success">
												<div class="panel-heading">
													<span class="bui-name">${building.buiName }
														${room.roomNumber }</span>
												</div>
												<div class="panel-body">
													<p>
														<label>类型：</label><span>综合场地</span>
													</p>
													<p>
														<label>容量：</label> <span>${room.roomCapacity }座位</span>
													</p>
													<p>
														<a class="btn btn-sm btn-info applyform"
															data-bid="${building.buiId }"
															data-roomid="${room.roomId }"
															data-url="${ctx }/apply/applyForm"
															data-canapplyurl="${ctx }/apply/canapply">申请该场地</a>
														&nbsp;&nbsp;<a class="btn btn-sm btn-warning weekUse"
															data-id="${room.roomId }">未来一周的使用情况</a>
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>


					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>
	<br>

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="footer.jsp" />

	<!-- 用户未登录提示框 -->
	<div class="modal fade" id="nologin" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h2 class="modal-title">温馨提示</h2>
				</div>
				<div class="modal-body">
					<h3>游客不能申请场地！ 请登录后再操作</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 表单弹出框 -->
	<div class="modal fade " id="applyform" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h2 class="modal-title">场地申请</h2>

				</div>
				<div class="modal-body">
					<jsp:include page="applyForm.jsp" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 申请场所时信息提示 -->
	<div class="modal fade" id="applyMSG" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h2 class="modal-title">温馨提示</h2>
				</div>
				<div class="modal-body">
					<h3 id="apply-message"></h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 未来一周申请情况的提示框 -->
	<div class="modal fade" id="app-week" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h2 class="modal-title">未来一周场地使用的申请情况</h2>
				</div>
				<div class="modal-body">
					<table class="table table-striped" id="app-week-list">
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>


	<script src="${ctx }/js/jquery.treemenu.js"></script>
</body>
<script>
	$(function() {
		$(".tree").treemenu({
			delay : 300
		}).openActive();

	});
</script>
<script>
	$(document)
			.ready(
					function() {
						minHeight = $(window).height();
						$('#aside,#space-list').css("height",
								(minHeight - 70) + "px");

						$('.nologin').click(function() {
							$('#nologin').modal();
						});
						applyform
						$('.applyform')
								.click(
										function() {
											var obj = $(this);
											var canapplyurl = $(this).data(
													'canapplyurl');
											var bid = $(this).data('bid');
											$
													.post(
															canapplyurl,
															{
																"canapplyurl" : canapplyurl,
																"bid" : bid,
															},
															function(data) {

																if (data["logined"] == "no") {
																	$(
																			'#nologin')
																			.modal();
																} else if (data["auth"] == "null") {
																	$(
																			"#apply-message")
																			.html(
																					'您暂未认证，认证后才能申请场地')
																	$(
																			'#applyMSG')
																			.modal();
																} else if (data["status"] == "no") {
																	$(
																			"#apply-message")
																			.html(
																					'您的认证申请暂未通过审核，不可以申请场地')
																	$(
																			'#applyMSG')
																			.modal();
																} else if (data['canapply'] == "no") {
																	$(
																			"#apply-message")
																			.html(
																					'您的认证类型是：'
																							+ data['auth']
																							+ ", 不可以申请该场地")
																	$(
																			'#applyMSG')
																			.modal();
																} else if (data['canapply'] == "yes") {
																	$(
																			'#form-auth-type')
																			.html(
																					data['auth']);
																	var buiName = obj
																			.parent()
																			.parent()
																			.prev()
																			.children(
																					'.bui-name')
																			.html();
																	$(
																			"#form-room-id")
																			.html(
																					buiName);
																	var capacity = obj
																			.parent()
																			.prev()
																			.children(
																					'span')
																			.html();
																	$(
																			'#form-capacity')
																			.html(
																					capacity);
																	var roomtype = obj
																			.parent()
																			.prev()
																			.prev()
																			.children(
																					'span')
																			.html();
																	$(
																			'#form-room-type')
																			.html(
																					roomtype);
																	var now = nowtime();
																	$(
																			"#form-time")
																			.html(
																					now);
																	var roomId = obj
																			.data('roomid');
																	$(
																			"#form-roomId")
																			.val(
																					roomId);
																	$(
																			"#form-buiId")
																			.val(
																					bid);

																	$(
																			'#applyform')
																			.modal();

																} else {

																}
															});

										});
						function nowtime() {//将当前时间转换成yyyymmdd格式
							var mydate = new Date();
							var str = "" + mydate.getFullYear();
							var mm = mydate.getMonth() + 1
							if (mydate.getMonth() > 9) {
								str = str + "-" + mm + "-";
							} else {
								str = str + "-" + "0" + mm + "-";
							}
							if (mydate.getDate() > 9) {
								str += mydate.getDate();
							} else {
								str += "0" + mydate.getDate();
							}
							return str;
						}

						/* 查看未来一周的使用情况 */
						$(".weekUse")
								.click(
										function() {
											var id = $(this).data("id");
											var url = "${ctx}/apply/weekUse/";
											$
													.post(
															url,
															{
																"id" : id,
															},
															function(data) {
																if (data['room'] == "no") {

																} else if (data['apps'] == "error") {

																} else {
																	if (data['apps'].length == 0) {
																		$(
																				"#app-week-list")
																				.html(
																						"未来两周没有申请");
																	} else {
																		var tr = '<tr><th>序号</th><th>开始时间</th><th>结束时间</th></tr>';

																		$
																				.each(
																						data['apps'],
																						function(
																								index,
																								item) {
																							tr = tr
																									+ '<tr><td>'
																									+ index
																									+ '</td><td>'
																									+ getMyDate(item['appStartTime'])
																									+ '</td><td>'
																									+ getMyDate(item['appEndTime'])
																									+ '</td></tr>';
																						});
																		$(
																				"#app-week-list")
																				.html(
																						tr);
																	}
																	$(
																			"#app-week")
																			.modal();
																}

															});
										});

						/* 把后台传来的时间戳格式化 */
						//获得年月日      得到日期oTime  
						function getMyDate(str) {
							var oDate = new Date(str), oYear = oDate
									.getFullYear(), oMonth = oDate.getMonth() + 1, oDay = oDate
									.getDate(), oHour = oDate.getHours(), oMin = oDate
									.getMinutes(), oSen = oDate.getSeconds(), oTime = oYear
									+ '年'
									+ getzf(oMonth)
									+ '月'
									+ getzf(oDay)
									+ '日  '
									+ getzf(oHour)
									+ ':'
									+ getzf(oMin)
									+ ':' + getzf(oSen);//最后拼接时间  
							return oTime;
						}
						;
						//补0操作  
						function getzf(num) {
							if (parseInt(num) < 10) {
								num = '0' + num;
							}
							return num;
						}
					});
</script>

</html>