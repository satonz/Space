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

<title>活动详情</title>
<link
	href="${ctx }/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${ctx }/js/jquery.min.js"></script>
<script	src="${ctx }/js/bootstrap.min.js"></script>

<link href="${ctx }/css/base.css" rel="stylesheet">
<link href="${ctx }/css/activity-detail.css" rel="stylesheet">
<link href="${ctx }/css/jquery.toast.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${ctx }/css/barrager.css">

<script src="${ctx }/js/jquery.toast.min.js">
	
</script>
<script type="text/javascript" src="${ctx }/js/jquery.barrager.min.js"></script>
</head>

<body>
	<!-- 使用动态include指令导入头部 -->
	<jsp:include page="header.jsp" />

	<section id="main">
		<section class="row">
			<div class="col-sm-12" id="fore-pane" >
				<div class="col-sm-12 text-center">
					<h2>正在进行中: ${act.actTitle }</h2>
				</div>
				<div class="col-sm-6 text-center">
					<br>
					<h2>入场券 ${act.actTicket } 张</h2>
					<h2>已报名人数 ${ticketNum } 张，剩余 ${ act.actTicket-ticketNum } 张</h2>
					<br> <a class="btn btn-lg btn-warning"
						data-url="${ctx }/act/signup/" data-id="${act.actId }" id="signup"><span
						class="h1">我要报名</span></a>
				</div>
				<div class="col-sm-6 text-center">
					<br>
					<h2>填写弹幕</h2>
					<hr>
					<div class="row " id="barrage-form">
						<p>
							<input type="text" placeholder="弹幕文字信息" id="barr-info" />
						</p>
						<p>
							<a class="btn btn-primary  btn-lg" id="barr-send"
								data-id="${act.actId }" data-url="${ctx }/act/barrage/"> 发送
								<span class="glyphicon glyphicon-send"></span>
							</a> <a class="btn btn-warning btn-lg" id="barr-clear"> 清除 <span
								class="glyphicon glyphicon-remove-circle"></span></a>
								
						</p>
					</div>
				</div>
			</div>
		</section>
		<div class="container">
			<jsp:include page="actComments.jsp" />
		</div>
	</section>


	<jsp:include page="footer.jsp" />
</body>
<script>
	$(function() {
		/*小屏幕导航点击关闭菜单*/
		$('.navbar-collapse a').click(function() {
			$('.navbar-collapse').collapse('hide');
		});
	})
</script>

<script>
	$(document)
			.ready(
					function() {
						/* 报名 */
						$("#signup").click(function() {

							if ($(this).attr("disabled")) {
								return false;
							}
							var url = $(this).data("url");
							var id = $(this).data("id");
							var obj = $(this);
							$.post(url, {
								"id" : id,
							}, function(data) {
								if (data['login'] == 'no') {
									$.toast({
										heading : '温馨提示',
										text : '游客不能报名活动！请登录后再报名',
										showHideTransition : 'fade',
										icon : 'error'
									});
									obj.attr('disabled', true);
								} else if (data['act'] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '该活动不存在',
										showHideTransition : 'fade',
										icon : 'error'
									});
									obj.attr('disabled', true);
								} else if (data['actticket'] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '该活动不需要入场券',
										showHideTransition : 'fade',
										icon : 'error'
									});
									obj.attr('disabled', true);
								} else if (data['nosignup'] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '您已报名过该活动不可以再重复报名',
										showHideTransition : 'fade',
										icon : 'error'
									});
									obj.attr('disabled', true);
								} else if (data['signup'] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '该活动入场券已被抢光',
										showHideTransition : 'fade',
										icon : 'error'
									});
									obj.attr('disabled', true);
								} else if (data['error'] == "error") {
									$.toast({
										heading : '温馨提示',
										text : '服务器发生了一些错误',
										showHideTransition : 'fade',
										icon : 'error'
									});

								} else if (data['signup'] == "yes") {
									$.toast({
										heading : '温馨提示',
										text : "恭喜，报名成功！",
										showHideTransition : 'slide',
										icon : 'success'
									})
									obj.attr('disabled', true);
								}
							});

						});

						/* 写弹幕 */
						$("#barr-clear").click(function() {
							$("#barr-info").val('');
						});
						$("#barr-send").click(function() {

							var info = $("#barr-info").val();
							if (info == '') {
								$.toast({
									heading : '温馨提示',
									text : '未输入弹幕内容',
									showHideTransition : 'fade',
									icon : 'error'
								});
								return false;
							}
							var url = $(this).data('url');
							var id = $(this).data('id');
							$.post(url, {
								"id" : id,
								"info" : info,
							}, function(data) {
								if (data['login'] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '游客不可以发送弹幕',
										showHideTransition : 'fade',
										icon : 'error'
									});
								} else if (data["form"] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '表单未填完整',
										showHideTransition : 'fade',
										icon : 'error'
									});
								} else if (data["act"] == "no") {
									$.toast({
										heading : '温馨提示',
										text : '该活动不存在',
										showHideTransition : 'fade',
										icon : 'error'
									});
								} else if (data["barr"] == "yes") {
									$.toast({
										heading : '温馨提示',
										text : "弹幕发送成功！",
										showHideTransition : 'slide',
										icon : 'success'
									});
									$("#barr-info").val('');
									/* sendBarrage(info); */
								} else {
									$.toast({
										heading : '温馨提示',
										text : '服务器发生了一些错误',
										showHideTransition : 'fade',
										icon : 'error'
									});
								}
							});
						});

						//获取一个从 min到max之间的随机数
						var getRandNum = function(min, max) {
							return parseInt(Math.random() * (max - min + 1)
									+ min);
						}

						var imgsNum = 9; //弹幕头像数量

						var barrimgs = new Array();
						var path = "${ctx}/images/barrimgs/";
						for (var i = 1; i <= imgsNum; i++) {
							barrimgs[i] = path + i + ".jpg"; //弹幕头像数组
						}
						
						var colors = ["red","orange","yellow","#FF6600","#009966","#fff"];
						
						//发送弹幕到屏幕
						var sendBarrage = function(info) {
							var bodyHeight = $(document.body).height() - 10;	//当前文档高度
							
							var imgPath = barrimgs[getRandNum(1,imgsNum)];
							var randSpeed = getRandNum(5,30);
							var randHeight = getRandNum(10,bodyHeight);
							var randColor = colors[getRandNum(0,colors.length)];
							var item = {
								img : imgPath, //图片 
								info : info, //文字 
								/*  href:'#', *///链接 
								close : false, //显示关闭按钮 
								speed : randSpeed, //延迟,单位秒,默认8 
								bottom : randHeight, //距离底部高度,单位px,默认随机 
								color : randColor, //颜色,默认白色 
								old_ie_color : '#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
							}

							$('body').barrager(item);
						}
						
						 
						/* 该活动最新的N条弹幕 */
						var lastnbarr = function(){
						
							$.post("${ctx}/act/lastnbarr/",
									{
										"id": "${ act.actId}",
									},function(data){
										
										if(data['act']=="no"){
											$.toast({
												heading : '温馨提示',
												text : '该活动不存在',
												showHideTransition : 'fade',
												icon : 'error'
											});
											return false;
										}else if(data['lastN'] == "error"){
											
											$.toast({
												heading : '温馨提示',
												text : '服务器发生了一些错误',
												showHideTransition : 'fade',
												icon : 'error'
											});
											return false;
										}
										//每条弹幕发送间隔
										var looper_time=2*1000;
										var items=data;
										//弹幕总数
										var total=data['lastN'].length;
										
										//先执行一次
										
										$.each(data["lastN"],function(index,item){
											//延时执行
											setTimeout(function () {
												//发布一个弹幕
												sendBarrage(item['barrInfo']);
											}, index * looper_time); 
										});
									}); 
							}
						//轮询 实现实时弹幕
						var realTimeBarr = function(){
						
							//每条弹幕发送间隔		轮询查询时间
							var looper_time=2*1000;
							//是否首次执行
							var run_once=true;
							do_barrager();
							 
							function do_barrager(){
							  if(run_once){
							      //如果是首次执行,则设置一个定时器,并且把首次执行置为false
							      looper=setInterval(do_barrager,looper_time);                
							      run_once=false;
							  }
							  //获取
							  $.post("${ctx }/act/realTimeBarr/",
									{
										"id": "${act.actId }",
									},function(data){
										if(data['act']=="no"){
											$.toast({
												heading : '温馨提示',
												text : '该活动不存在',
												showHideTransition : 'fade',
												icon : 'error'
											});
											return false;
										}else if(data['actMaxBarr'] == "no"){
											
											return false;
										}else if(data['maxId'] == "no"){
											
											return false;
										}else if(data['realTimeBass'] == "error"){
											$.toast({
												heading : '温馨提示',
												text : '服务器发生了一些错误',
												showHideTransition : 'fade',
												icon : 'error'
											});
											return false;
										}
										//每条弹幕发送间隔
										/* var looper_time=1*1000; */
										/* var items=data; */
										//弹幕总数
										var total=data['realTimeBass'].length;
										
										//先执行一次
										
										$.each(data["realTimeBass"],function(index,item){
											//发布一个弹幕
											sendBarrage(item['barrInfo']);
										});
									}); 
									
							}
						}
						
						lastnbarr();//执行获取最新的N条弹幕
						realTimeBarr();//执行实时弹幕
					});

			</script>

</html>