<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网络入场券</title>
<link href="${ctx }/css/bootstrap.min.css"	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>w
<style type="text/css">
#ticket-all {
	width: 800px;
	height: 450px;
	margin: 15px auto;
	padding: 10px;
	border: #999 solid 1px;
	border-radius: 8px;
	/* background-image: url("${ctx }${ticket.activity.actImgPath}");
	background-size: 100% 100%; */
}

#print-body {
	width: 100%;
	height: 100%;
	/* background: rgba(70, 70, 70, 0.7); */
	color: #222;
	line-height: 35px;
	font-size: 16px;
}
</style>
</head>
<body>
	<h2 class="text-center">${ticket.activity.actTitle }-入场券</h2>

	<div id="ticket">

		<div id="ticket-all">
			<div id="print-body">

				<p>
					<label>活动名称：</label><span>${ticket.activity.actTitle }</span>
				</p>
				<p>
					<label>活动简介：</label><span>${ticket.activity.actIntroduce }</span>
				</p>
				<p>
					<label>开始时间：</label><span>${ticket.activity.actStartTime }</span>
				</p>
				<p>
					<label>活动地点：</label><span>${ticket.activity.room.building.buiName }
						${ticket.activity.room.roomNumber }</span>
				</p>
				<p>
					<label>入场券所有者：</label><span>${ticket.user.username }</span>
				</p>
				<p>
					<label>入场券编号：</label><span>${ticket.ticketId }</span>
				</p>
				<p>
					<label>报名时间：</label><span>${ticket.ticketTime }</span>
				</p>


			</div>
		</div>
	</div>

	<div class="text-center">
		<a class="btn btn-primary" id="print">打印</a>
	</div>

</body>
<script src="${ctx }/js/jquery.printarea.js"></script>
<script>
	$(window).ready(function() {
		$("#print").click(function() {
			/* $("#ticket").printArea();*/
			window.print();
		});
	});
</script>
</html>