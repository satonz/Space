<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="account-container">
	<div class="thumbnail">
		<!-- 没有头像 -->
		<img src="${ctx }${sessionScope.profile.pfAvatar }" id="aside-img"
			class="img-responsive">
	</div>
	<p>${user.username }</p>
</div>
<div>
	<ul class="aside-li">
		<c:choose>
			<c:when test="${current == null || current == 'index' }">
				<li><a href="${ctx }/user/index" class="current">基本信息</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ctx }/user/index">基本信息</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${current == 'edit' }">
				<li><a href="${ctx }/user/edit" class="current">修改信息</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ctx }/user/edit">修改信息</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${current == 'auth' }">
				<li><a href="${ctx }/user/auth" class="current">我的认证</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ctx }/user/auth">我的认证</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${current == 'avatar' }">
				<li><a href="${ctx }/user/avatar" class="current">修改头像</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ctx }/user/avatar">修改头像</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${current == 'editpass' }">
				<li><a href="${ctx }/user/editpass" class="current">修改密码</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ctx }/user/editpass">修改密码</a></li>
			</c:otherwise>
		</c:choose>
		<!-- <c:choose>
		   <c:when test="${current == 'editemail' }">  
		         <li><a href="${ctx }/user/editemail"  class="current">修改邮箱</a></li>
		   </c:when>
		   <c:otherwise> 
			     <li><a href="${ctx }/user/editemail">修改邮箱</a></li>
		   </c:otherwise>
		</c:choose> -->

	</ul>
	<hr>
</div>