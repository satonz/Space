<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
	<div class="sidebar-dropdown">
		<a href="#">导航</a>
	</div>

	<ul id="nav">
		<li>
			<c:choose>
				<c:when test="${param.number == 1 }">
					<a href="${ctx }/admin" class="open"><i class="icon-home"></i> 首页</a>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/admin"><i class="icon-home"></i> 首页</a>
				</c:otherwise>
			</c:choose>
		</li>
		<li class="has_sub">
			<c:choose>
				<c:when test="${param.number == 2 }">
					<a href="#" class="subdrop"><i class="icon-credit-card"></i> 认证管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul style="display: block;">
				</c:when>
				<c:otherwise>
					<a href="#"><i class="icon-credit-card"></i> 认证管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
				</c:otherwise>
			</c:choose>
				<li>
					<a href="${ctx }/admin/authentication/list?aType=1">班级认证&nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.studentAuthentication > 0 }">
						<span class="label label-danger">
						${statisticalInformation.studentAuthentication}
						</span>
					</c:if>
					</a>
				</li>
				<li>
					<a href="${ctx }/admin/authentication/list?aType=2">教师认证 &nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.teacherAuthentication > 0 }">
						<span class="label label-danger">
						${statisticalInformation.teacherAuthentication }
						</span>
					</c:if>
					</a>
				</li>
				<li>
					<a href="${ctx }/admin/authentication/list?aType=3">社团认证&nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.clubAuthentication > 0 }">
						<span class="label label-danger">
						${statisticalInformation.clubAuthentication }
						<span class="label label-danger">
					</c:if>
					</a>
				</li>
				<li>
					<a href="${ctx }/admin/authentication/list?aType=4">学院认证&nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.collegeAuthentication > 0 }">
						<span class="label label-danger">
						${statisticalInformation.collegeAuthentication }
						</span>
					</c:if>
					</a>
				</li>
			</ul>
		</li>
		<li class="has_sub">
			
			<c:choose>
				<c:when test="${param.number == 3 }">
					<a href="#" class="subdrop"><i class="icon-envelope-alt"></i> 申请管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul style="display: block;">
				</c:when>
				<c:otherwise>
					<a href="#"><i class="icon-envelope-alt"></i> 申请管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
				</c:otherwise>
			</c:choose>
				<li>
					<a href="${ctx }/admin/application/list?buildingType=0">教室 申请&nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.claApplications > 0 }">
						<span class="label label-danger">${statisticalInformation.claApplications}</span>
					</c:if>
					</a>
				</li>
				<li>
					<a href="${ctx }/admin/application/list?buildingType=1">实验室申请&nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.labApplications > 0 }">
						<span class="label label-danger">${statisticalInformation.labApplications}</span>
					</c:if>
					</a>
				</li>
				<li>
					<a href="${ctx }/admin/application/list?buildingType=2">综合楼申请&nbsp;&nbsp;&nbsp;
					<c:if test="${statisticalInformation.comApplication > 0 }">
						<span class="label label-danger">${statisticalInformation.comApplication}</span>
					</c:if>
					</a>
				</li>
			</ul>
		</li>
		<li class="has_sub">
			<c:choose>
				<c:when test="${param.number == 4 }">
					<a href="#" class="subdrop"><i class="icon-building"></i> 场地管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul style="display: block;">
				</c:when>
				<c:otherwise>
					<a href="#"><i class="icon-building"></i> 场地管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
				</c:otherwise>
			</c:choose>
				<li>
					<a href="${ctx }/admin/building/list?type=0">教学楼</a>
				</li>
				<li>
					<a href="${ctx }/admin/building/list?type=1">实验楼</a>
				</li>
				<li>
					<a href="${ctx }/admin/building/list?type=2">综合楼</a>
				</li>
			</ul>
		</li>
		<li class="has_sub">
			<c:choose>
				<c:when test="${param.number == 5 }">
					<a href="#" class="subdrop"><i class="icon-group"></i> 活动管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul style="display: block;">
				</c:when>
				<c:otherwise>
					<a href="#"><i class="icon-group"></i> 活动管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
				</c:otherwise>
			</c:choose>
			
				<li>
					<a href="${ctx }/admin/activity/list">查看全部活动</a>
				</li>
				<li>
					<a href="${ctx }/admin/comment/list">查看一级评论</a>
				</li>
				<li>
					<a href="${ctx }/admin/reply/list">查看二级评论</a>
				</li>
				<li>
					<a href="${ctx }/admin/activity/toAddActivityPage">发布活动</a>
				</li>
			</ul>
		</li>
		
		<li class="has_sub">
			<c:choose>
				<c:when test="${param.number == 6 }">
					<a href="#" class="subdrop"><i class="icon-group"></i> 公告管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul style="display: block;">
				</c:when>
				<c:otherwise>
					<a href="#"><i class="icon-group"></i> 公告管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
				</c:otherwise>
			</c:choose>
			
			
				<li>
					<a href="${ctx }/admin/notice/list">查看公告</a>
				</li>
				<li>
					<a href="${ctx }/admin/notice/toPulishPage">发布公告</a>
				</li>

			</ul>
		</li>

		<li>
			<c:choose>
				<c:when test="${param.number == 7 }">
					<a href="${ctx }/admin/user/list" class="subdrop"><i class="icon-user"></i>用户管理</a>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/admin/user/list"><i class="icon-user"></i>用户管理</a>
				</c:otherwise>
			</c:choose>
			
		</li>
		
		<!--  
		<li class="has_sub">
			<c:choose>
				<c:when test="${param.number == 8 }">
					<a href="#" class="subdrop"><i class="icon-file-alt"></i> 查看日志 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul style="display: block;">
				</c:when>
				<c:otherwise>
					<a href="#"><i class="icon-file-alt"></i> 查看日志 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
				</c:otherwise>
			</c:choose>
			
			
				<li>
					
					<a href="${ctx }/admin/log/list?type=0">普通日志</a>
				</li>
				<li>
					<a href="${ctx }/admin/log/list?type=1">错误日志</a>
				</li>
			</ul>
		</li>
		-->
		
		<li>
			<c:choose>
				<c:when test="${param.number == 9 }">
					<a href="${ctx }/admin/setting" class="subdrop"><i class="icon-wrench"></i>基本设置</a>
				</c:when>
				<c:otherwise>
					<a href="${ctx }/admin/setting"><i class="icon-wrench"></i>基本设置</a>
				</c:otherwise>
			</c:choose>
			
		</li>
	</ul>
</div>
