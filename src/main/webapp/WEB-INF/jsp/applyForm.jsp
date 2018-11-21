<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div id="form-div">
	<h2 class="form-title">场地申请表</h2>
	<p class="form-time" id="form-time"></p>
	<form method="post">
		<fieldset>
			<legend>申请者信息</legend>
			<p>
				<label>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label> <span>
					${loginUser.username }</span>
			</p>

			<p>
				<label>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label> <span>${loginUser.email }</span>
			</p>
			<p>
				<label>认证类型：</label> <span id="form-auth-type"></span>
			</p>
		</fieldset>
		<fieldset>
			<legend>场地信息</legend>
			<p>
				<label>场地编号：</label> <span id="form-room-id"></span>
			</p>
			<p>
				<label>场地类型：</label> <span id="form-room-type"></span>
			</p>
			<p>
				<label>容&nbsp;&nbsp;&nbsp;&nbsp;量：</label> <span id="form-capacity"></span>
			</p>
		</fieldset>
		<fieldset>
			<legend>填写表单</legend>
			<input type="text" hidden="hidden" id="form-buiId" name="buiId"
				value=""> <input type="text" hidden="hidden"
				id="form-roomId" name="roomId" value="">
			<p>
				<label>借用时间：</label><br /> <input type="datetime-local"
					id="form-start-time" name="startTime"> TO <input
					type="datetime-local" id="form-end-time" name="endTime">
			</p>
			<p>
				<label>借用事由：</label>
				<textarea placeholder="借用事由" name="reason" id="form-reason"></textarea>
			</p>
		</fieldset>
		<p id="submite-btn">
			<a id="app-btn" href="javascript:void(0);"
				data-url="${ctx }/apply/applyForm">提交申请</a>
		</p>
	</form>
</div>
<script>
	$(document).ready(
			function() {
				$("#app-btn").click(
						function() {

							var url = $(this).data("url");
							var buiId = $("#form-buiId").val();
							var roomId = $("#form-roomId").val();
							var startTime = $("#form-start-time").val();
							var endTime = $("#form-end-time").val();
							var reason = $("#form-reason").val();

							if (url == "" || buiId == "" || roomId == ""
									|| startTime == "" || endTime == ""
									|| reason == "") {
								$("#apply-message").html('表单未填完整！')
								$('#applyMSG').modal();
								return false;
							}

							var start = new Date(startTime);

							var end = new Date(endTime);

							if (start > end) {
								$("#apply-message").html('开始时间不能大于结束时间！')
								$('#applyMSG').modal();
								return false;
							}
							var now = new Date();
							if (now > start) {
								$("#apply-message").html('开始时间不能小于当前时间！')
								$('#applyMSG').modal();
								return false;
							}

							$.post(url, {
								"buiId" : buiId,
								"roomId" : roomId,
								"startTime" : startTime,
								"endTime" : endTime,
								"reason" : reason,
							}, function(data) {
								if (data['form'] == "no") {
									$("#apply-message").html('表单未填完整！')
									$('#applyMSG').modal();
								} else if (data["login"] == "no") {
									$("#apply-message").html('未登录，游客不可以申请场地！')
									$('#applyMSG').modal();
								} else if (data["auth"] == "no") {
									$("#apply-message").html('您还未认证，不可以申请场地')
									$('#applyMSG').modal();
								} else if (data["status"] == "no") {
									$("#apply-message").html(
											'您的认证申请暂未通过审核，不可以申请场地')
									$('#applyMSG').modal();
								} else if (data["canapply"] == "no") {
									$("#apply-message").html('您的认证类型不可以申请该场地');
									$('#applyMSG').modal();
								} else if (data["startTime"] == "no") {
									$("#apply-message").html('开始时间不能小于当前时间！')
									$('#applyMSG').modal();
								} else if (data["room"] == "no") {
									$("#apply-message").html('该场地不存在！')
									$('#applyMSG').modal();
								} else if (data["existApps"] == "error") {
									$("#apply-message").html('服务器发生了一些错误！')
									$('#applyMSG').modal();
								} else if (data["existApps"] == "no") {
									$("#apply-message").html('时间段与其他申请存在冲突！')
									$('#applyMSG').modal();
								} else if (data["app"] == "no") {
									$("#apply-message").html('服务器发生错误！')
									$('#applyMSG').modal();
								} else if (data['app'] == "yes") {
									$("#apply-message").html('恭喜，申请提交成功！')
									$('#applyMSG').modal();

									$("#form-buiId").val('');
									$("#form-roomId").val('');
									$("#form-start-time").val('');
									$("#form-end-time").val('');
									$("#form-reason").val('');
								}
							});
						});
			});
</script>