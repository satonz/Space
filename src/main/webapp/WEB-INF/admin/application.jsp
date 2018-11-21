<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>审查申请信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 导入公共样式及js -->
		<c:import url="public.jsp"></c:import>
		<!-- 导入jq toast插件样式及js -->
		<link href="${ctx }/css/jquery.toast.min.css" rel="stylesheet">
		<script src="${ctx }/js/jquery.toast.min.js"></script>

	</head>
	<body>
		<!-- 头部 -->
		<c:import url="head.jsp"></c:import>
		<div class="content">
			<!-- 菜单 -->
			<c:import url="left.jsp">
				<c:param name="number" value="3"></c:param>
			</c:import>
			<div class="mainbar">
				<div class="page-head">
					<h2 class="pull-left"><i class="icon-home"></i> 首页</h2>
					<div class="bread-crumb pull-right">
						<a href="index.html"><i class="icon-home"></i> 首页</a>
						<!-- Divider -->
						<span class="divider">/</span>
						<a href="#" class="bread-current">申请管理</a>
					</div>
					<div class="clearfix"></div>
				</div>

				<!-- 内容主体 -->
				<div class="matter">
					<div class="container">
					<!--
                   	作者：1242440175@qq.com
                   	时间：2017-03-06
                   	描述：主体内容
                    -->
                    	<!-- 搜索框 -->
						<div class="row">
							<div class="col-md-12">
								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">快速搜索</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<div class="padd">
											<div class="form quick-post">
												<!-- Edit profile form (not working)-->
												<form class="form-horizontal" method="post" action="${ctx }/admin/application/list">
													<input type="hidden" name="buildingType" value="${buildingType }">
													<div class="form-group">
														<div class="col-lg-8 col-md-6 col-sm-10 col-xs-8" style="margin-bottom: 10px;">
															<input name="retrieval" type="text" class="form-control" id="title" placeholder="搜索姓名/名称" value="${retrieval }">
														</div>
														<div class="col-lg-2 col-md-3 col-sm-10 col-xs-8">
															<select name="type" class="form-control">
																<c:choose>
																	<c:when test="${type==0 }">
																		<option selected="selected" value="0">未处理</option>
																		<option value="1">已通过</option>
																		<option value="2">未通过</option>
																	</c:when>
																	<c:when test="${type==1 }">
																		<option value="0">未处理</option>
																		<option selected="selected" value="1">已通过</option>
																		<option value="2">未通过</option>
																	</c:when>
																	<c:otherwise>
																		<option value="0">未处理</option>
																		<option value="1">已通过</option>
																		<option selected="selected" value="2">未通过</option>
																	</c:otherwise>
																</c:choose>
															</select>
														</div>
														<div class="col-lg-1 col-md-3 col-sm-2 col-xs-4">
															<button type="submit" class="btn btn-success">搜索</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="widget">
									<div class="widget-head">
										<div class="pull-left">场地申请管理</div>
										<div class="clearfix"></div>
									</div>
									<div class="widget-content">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>申请人</th>
													<th>申请用途</th>
													<th>申请场地</th>
													<th>开始使用时间</th>
													<th>结束使用时间</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
											<c:set var="count" value="${page.pageSize * (page.currentPage - 1) }"></c:set>
											<c:forEach var="application" items="${list }">
												<c:set var="count" value="${count + 1 }"></c:set>
												<tr>
													<td>${count }</td>
													<td>${application.username }</td>
													<td>${application.content }</td>
													<td>${application.space }</td>
													<td>
													<fmt:formatDate value="${application.startTime }" pattern="yyyy-MM-dd HH:mm"/>
													</td>
													<td>
														<fmt:formatDate value="${application.endTime }" pattern="yyyy-MM-dd HH:mm"/>
													</td>
													<td>
														<c:if test="${type == 0 || type == 2 }">
															<a onclick="updateApplication(this, ${application.id}, 0, '')" href="javascript:void(0)" class="btn btn-xs btn-success"><i class="icon-ok"></i> </a>
														</c:if>
														<c:if test="${type !=2 }">
															<!--  
															<a onclick="updateApplication(this, ${application.id}, 1)" href="javascript:void(0)"  class="btn btn-xs btn-danger"><i class="icon-remove"></i> </a>
															-->
															<button id="${application.id }"  class="btn btn-xs btn-danger" onclick="showModal(${application.id})"><i class="icon-remove"></i> </a>
														</c:if>
													</td>
												</tr>
											</c:forEach>


											</tbody>
										</table>

										<div class="widget-foot">
											<c:import url="page.jsp">
												<c:param name="url" value="${ctx }/admin/application/list?type=${type }&retrieval=${retrieval }"></c:param>
											</c:import>
											<div class="clearfix"></div>
										</div>
									</div>
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

		<!-- 底部 -->
		<c:import url="foot.jsp"></c:import>
		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
		        <div class="modal-content">
		        
		        	<form action="" class="form-horizontal" role="form">
		        		<input type="hidden" name="a_id" id="a_id">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                <h4 class="modal-title" id="myModalLabel">请输入不通过申请理由</h4>
			            </div>
			            
							<div class="form-group" style="margin-top: 20px">
								<label for="lastname" class="col-sm-2 control-label">备注</label>
								<div class="col-sm-10">
									<input type="text" name="content" class="form-control" id="content" 
										   placeholder="备注">
								</div>
							</div>
							
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			                <button type="button" id="refuse" class="btn btn-primary" onclick="refuseApplication()">提交更改</button>
			            </div>
		           </form>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>

	</body>
	<script type="text/javascript">
		function updateApplication(element, id, status, content) {
			$.post("update",
					{
						"id": id,
						"status": status,
						"content":content,
					},
					function (data) {
						if (data['status'] == 'TRUE') {
							$(element).parent().parent().remove();
							$.toast({
		    				    heading: '操作结果',
		    				    text: '操作成功',
		    				    showHideTransition: 'slide',
		    				    icon: 'success'
		    				})
						} else {
							$.toast({
								heading: '操作结果',
		    				    text: '操作失败!' + data['tip'],
							    showHideTransition: 'fade',
							    icon: 'error'
							})
						}
					});
		}
		function refuseApplication() {
			var btnId = $("#a_id").val();
			var btn =$("#" + btnId);
			var content = $("#content").val();
			$('#myModal').modal('hide');
			updateApplication(btn, btnId, 1, content);
			
		}
		function showModal(id) {
			$("#a_id").val(id);
			$('#myModal').modal('show');
		}
		
	</script>
	

</html>