<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

				<div class="row">
					<div class="col-md-6">
						<img src="${ctx }/${act.actImgPath }" class="img-responsive">
					</div>
					<div class="col-md-6">
						<p class="act-table"><label>活动名称：</label><span>${act.actTitle }</span></p>
						<p class="act-table" ><label>活动简介：</label><span>${act.actIntroduce }</span></p>
						<p class="act-table"><label>开始时间：</label><span>${act.actStartTime }</span></p>
						<p class="act-table"><label>结束时间：</label><span>${act.actEndTime }</span></p>
						<p class="act-table"><label>座位数量：</label><span>${act.actTicket }</span></p>
						<a class="btn btn-lg btn-success" id="show-detail">查看活动完整信息 </a>
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-12 comms">
						<hr>
						<!--评论框-->
						<div class="panel panel-info">
						    <div class="panel-heading">
						        <h4 id="comment_title">新的评论</h4>
						    </div>
						    <div class="panel-body">
						        <div class="comments_nav">
						                <div class="row">
						                    <textarea class="commTextPane" id="commTextPane" name="comment" placeholder="发表你的评论"></textarea>
						                </div>
						                <div class="row">
						                    <div class="form-actions comment_button">
						                        <a class="btn btn-info pull-right" id="submit_btn" data-url="${ctx }/act/comment/" data-id="${act.actId }">提交</a>
						                        <span class="btn btn-default pull-right" id="reset_btn">清空</span>
						                    </div>
						                </div>
						        </div>
						    </div>
						</div>

						<hr>
						<h4>所有评论</h4>
						<hr />
						<ul class="comm-list" id="comm-list">
							<c:forEach items="${act.comments }" var="comm" varStatus="status">
							<li class="row">
								<div class="comment">
									<div class="comm-header col-xs-3 col-sm-3 col-md-2">
										<span class="thumbnail">
									      	<img src="${ctx }${comm.user.profile.pfAvatar }" alt="...">
									    </span>
										<center><label>${comm.user.username }</label></center>
									</div>
									<div class="comm-body col-xs-9 col-sm-9 col-md-10">
										<div class="comm-content">
											${comm.commentContent }
										</div>
										<div class="comm-footer">
											<p>${comm.commentTime }
												&nbsp;&nbsp;<a  class="replybtn" >回复&nbsp;<span class="glyphicon glyphicon-send"></span></a>
											</p>
											<p hidden="hidden">
												<textarea class="replyTextarea" rows="" cols="" placeholder="回复："></textarea>
												<a data-commid="${comm.commentId }" data-url="${ctx }/act/reply/" class="btn btn-sm btn-info  pull-right sendreply">发表</a>
											</p>
										</div>
										<div class="replys"> 
											<ul>
												<c:forEach items="${comm.replies }" var="reply" varStatus="status">
													<li>
														<div>
															<img src="${ctx }${reply.user.profile.pfAvatar }" alt="...">
															<a> ${reply.user.username }</a>
															<span> ${reply.replyContent }</span>
														</div>
														<p>${reply.replyTime }</p>
													</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
								
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
	
		
		<div class="modal fade " id="act-detail"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document" style="width:80%">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h2 class="modal-title text-center" style="color:red;">${act.actTitle }</h2>
                            
                        </div>
                        <div class="modal-body">
                        	<div class="modal-act-detail">
                        		${act.actDetail }
                        		
                        	</div>
                        	
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div>
            

	<c:choose>
		<c:when test="${empty sessionScope.loginUser }">
					<script>
						$(document).ready(function(){
							$("#show-detail").click(function(){
					        	$("#act-detail").modal();
					     	});
							$("#reset_btn").click(function(){
					        	 $('#commTextPane').val('');
					        });
							
					        $("#submit_btn").click(function(){
					        	$.toast({
								    heading: '温馨提示',
								    text: '登录后才能评论',
								    showHideTransition: 'fade',
								    icon: 'info'
								})
					        }); 
					        
					        $(".replybtn").click(function(){
					        	$.toast({
								    heading: '温馨提示',
								    text: '登录后才能回复',
								    showHideTransition: 'fade',
								    icon: 'info'
								})
					        }); 
						});
						</script>
		</c:when>
		<c:otherwise>
				<script>
					$(document).ready(function(){
						 $("#show-detail").click(function(){
					        	$("#act-detail").modal();
					     });
						 
						$("#reset_btn").click(function(){
				        	 $('#commTextPane').val('');
				        });
						
				        $("#submit_btn").click(function(){
				            var content = $("#commTextPane").val();
				            if(content == ''){
				            	$.toast({
								    heading: '提交失败',
								    text: '请输入评论内容后再提交！',
								    showHideTransition: 'fade',
								    icon: 'error'
								})
				                return false;
				            }
				            var id = $("#submit_btn").data('id');
				            var url = $("#submit_btn").data('url');
				            
				            $.post(url,
				                {
				                    "content": content,
				                    "id":id,
				                },
				                function(data){
				                	if(data["logined"]=="no"){
				                		$.toast({
										    heading: '温馨提示',
										    text: '登录后才能评论',
										    showHideTransition: 'fade',
										    icon: 'error'
										})
				                	}else if(data['act'] == "no"){
				                		$.toast({
										    heading: '温馨提示',
										    text: '该活动不存在',
										    showHideTransition: 'fade',
										    icon: 'error'
										})
				                	}else{
				                		$.toast({
					    				    heading: '评论成功',
					    				    text: '评论内容为：'+content,
					    				    showHideTransition: 'slide',
					    				    icon: 'success'
					    				})
					    				var username = $('#username').text();
				                		var d = new Date();
				                		var narbarAvatar = $("#navbar-avatar").attr("src");
				                		var newComm = '<li class="row"><div class="comment">'+
										'<div class="comm-header col-xs-3 col-sm-3 col-md-2"><span class="thumbnail"><img src="'+
										narbarAvatar + '" alt="..."></span><center>'+
									    username + '</center></div><div class="comm-body col-xs-9 col-sm-9 col-md-10"><div class="comm-content">'+
										content + '</div><div class="comm-footer"><p>'+
										d + '&nbsp;&nbsp;<a href=""  class="replybtn">回复</a></p></div><div class="replys">'+
										'<ul></ul></div></div></div></li>';
									
									
										$('#comm-list').prepend(newComm);
										
					                    $('#commTextPane').val('');
				                	}
				            });
				        });
				        
				        $(".replybtn").click(function(){
				        	$(this).parent().next().toggle(500);
				        }); 
				        $(".sendreply").click(function(){
				        	var contentobj = $(this).prev();
				        	var obj = $(this);
				        	var content = $(this).prev().val();
				        	if(content == ''){
				        		$.toast({
								    heading: '发表失败',
								    text: '请输入回复内容后再提交！',
								    showHideTransition: 'fade',
								    icon: 'error'
								})
				        	}else{
				        		var commid = $(this).data('commid');
				        		var url = $(this).data('url');

				        		$.post(url,
						                {
						                    "content": content,
						                    "commid":commid,
						                },
						                function(data){
						                	if(data["logined"]=="no"){
						                		$.toast({
												    heading: '温馨提示',
												    text: '登录后才能评论',
												    showHideTransition: 'fade',
												    icon: 'error'
												})
						                	}else if(data['comm'] == "no"){
						                		$.toast({
												    heading: '温馨提示',
												    text: '所回复的评论不存在',
												    showHideTransition: 'fade',
												    icon: 'error'
												})
						                	}else if(data['reply']=="yes"){
						                		$.toast({
							    				    heading: '回复成功',
							    				    text: '回复内容为：'+content,
							    				    showHideTransition: 'slide',
							    				    icon: 'success'
							    				})
							    				var username = $('#username').text();
						                		var d = new Date();
						                		var narbarAvatar = $("#navbar-avatar").attr("src");
						                		var newReply = '<li><div><img src="' + narbarAvatar +'" alt="..."><a>'+
				                				username + '</a><span>'+
				                				content + '</span></div><p>'+
				                				d + '</p></li>';
										
				                				obj.parent().parent().next().children(":first").append(newReply);
						                		
												contentobj.val('');
						                	}else{
						                		$.toast({
												    heading: '温馨提示',
												    text: '系统发生了一些错误',
												    showHideTransition: 'fade',
												    icon: 'error'
												})
						                	}
						            });
				        	}
				        });
				        
				       
					});
					</script>
		</c:otherwise>
	</c:choose>
