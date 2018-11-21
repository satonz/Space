<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 使用此分页需要两个属性space.admin.vo.Page page 和 url  -->

<ul class="pagination pull-right">
	<c:if test="${page.currentPage > 1 }">
		<li>
			<a href="${param.url}&page=${page.currentPage - 1}">上一页</a>
		</li>
	</c:if>

	<c:if test="${page.totalPage > 5 }">
		<c:set var="start" value="${page.currentPage - 2 > 1 ? page.currentPage - 2: 1 }"/>
		<c:set var="start" value="${page.totalPage - page.currentPage >= 2 ? start : page.totalPage - 5}"/>
		<c:forEach var="index" begin="${start }" end="${start + 4 }" step="1">
			
			<c:choose>
				<c:when test="${index == page.currentPage }">
					<li>
						<a href="${param.url}&page=${index}" class="btn btn-active">${index}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="${param.url}&page=${index}">${index}</a>
					</li>
				</c:otherwise>
			</c:choose>
			<c:set var="index" value="${index + 1 }"></c:set>
		</c:forEach>
	</c:if>
	

	<c:if test="${page.totalPage <= 5 }">
		<c:forEach var="start" begin="1" end="${page.totalPage }" step="1">
			<c:choose>
				<c:when test="${start == page.currentPage }">
					<li>
						<a href="${param.url}&page=${start}" class="btn btn-active" >${start}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="${param.url}&page=${start}" >${start}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
	<c:if test="${page.currentPage < page.totalPage}">
		<li>
			<a href="${param.url}&page=${page.currentPage + 1}">下一页</a>
		</li>
	</c:if>
</ul>