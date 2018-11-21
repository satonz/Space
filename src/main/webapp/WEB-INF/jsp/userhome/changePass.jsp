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
			<div role="tabpanel" class="tab-pane" id="changePasswd">
				<form action="" method="post">
					<div class="user-info">
						<div class="tab-header">
							<span>修改密码</span>
						</div>
						<p>
							<span> <label for="id_old_password">当前密码</label>
							</span> <span> <input id="id_old_password" name="old_password"
								type="password" />
							</span>
							<span id="old-tip"  hidden="hidden" class="error"></span>
						</p>
						<p>
							<span> <label for="id_new_password1">新的密码：</label>
							</span> <span> <input id="id_new_password1" name="new_password1"
								type="password" />
							</span>
							<span id="new1-tip" hidden="hidden" class="error"></span>
						</p>
						<p>
							<span> <label for="id_new_password2">确认密码：</label>
							</span> <span> <input id="id_new_password2" name="new_password2"
								type="password" />
							</span>
							<span id="new2-tip" hidden="hidden" class="error"></span>
						</p>
						<div>
							<p>
								<span id="final-tip" class="error" hidden="hidden"></span>
							</p>
						</div>
						<p>
							<span>
								<a class="btn btn-success" style="min-width: 150px;" id="submit-btn" data-url="${ctx }/user/editpass/">
									<span class="glyphicon glyphicon-hand-down"></span>&nbsp;提交
								</a>
							</span>
						</p>
					</div>
				</form>
			</div>
				
		</div>
	</section>

	<!-- 使用动态include指令导入底部版权栏 -->
	<jsp:include page="../footer.jsp" />


	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#submit-btn").click(function(){
			var old_password = $("#id_old_password").val();
			var new_password1 = $("#id_new_password1").val();
			var new_password2 = $("#id_new_password2").val();
			if(old_password == ""){
				$("#old-tip").html("提示信息：未输入密码！")
				$("#old-tip").show(300);
				return false;
			}else{
				$("#old-tip").hide(300);
			}
			if(new_password1 == ""){
				
				$("#new1-tip").html("提示信息：新密码不能为空！")
				$("#new1-tip").show(300);
				return false;
			}else{
				$("#new1-tip").hide(300);
			}
			if(new_password2 == ""){
				$("#new2-tip").html("提示信息：新密码不能为空！")
				$("#new2-tip").show(300);
				return false;
			}else{
				$("#new2-tip").hide(300);
			}
			if(new_password2 != new_password1){
				$("#new2-tip").html("提示信息：两次新密码不一致！")
				$("#new2-tip").show(300);
				return false;
			}else{
				$("#new2-tip").hide(300);
			}
			var url = $(this).data('url');
			$.post(url,
	                {
	                    "old_password": old_password,
	                    "new_password1":new_password1,
	                    "new_password2":new_password2,
	                },
	                function(data){

	                	if(data['login']=='no'){
	                		$('#final-tip').html('提示信息：您还暂未登录！');
	                		$('#final-tip').addClass("error");
	                		$('#final-tip').show(300);
	                	}else if(data['form'] == "no"){
	                		$('#final-tip').html('提示信息：表单未填完整！');
	                		$('#final-tip').addClass("error");
	                		$('#final-tip').show(300);
	                	}else if(data['old'] == "no"){
	                		
	                		$('#final-tip').html('提示信息：密码错误！');
	                		$('#final-tip').addClass("error");
	                		$('#final-tip').show(300);
	                	}else if(data["new"] == "no"){
	                		$('#final-tip').html('提示信息：两次新密码不一致！');
	                		$('#final-tip').addClass("error");
	                		$('#final-tip').show(300);
	                	}else if(data['op'] == "no"){
	                		$('#final-tip').html('提示信息：新密码保存失败！');
	                		$('#final-tip').addClass("error");
	                		$('#final-tip').show(300);
	                	}else if(data['op']=='yes'){
	                		$('#final-tip').html('提示信息：成功修改密码！');
	                		$('#final-tip').removeClass("error");
	                		$('#final-tip').addClass("success");
	                		$('#final-tip').show(300);
	                		
	                		$("#id_old_password").val('');
	            			$("#id_new_password1").val('');
	            			$("#id_new_password2").val('');
	                	}else{
	                		$('#final-tip').html('提示信息：未知错误！');
	                		$('#final-tip').removeClass("success");
	                		$('#final-tip').addClass("error");
	                		$('#final-tip').show(300);
	                		
	                	}
	            });
			
		});
	});
	
	</script>
</body>
</html>