<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 公共样式 -->
<link href="${ctx}/admin/style/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx}/admin/style/font-awesome.css">
<link href="${ctx}/admin/style/style.css" rel="stylesheet">

<!-- 公共js -->
<!--  <script type="text/javascript" src="${ctx }/admin/js/jquery-3.1.1.min.js"></script> -->
<script type="text/javascript" src="${ctx }/admin/js/jquery.js"></script>
<script src="${ctx}/admin/js/bootstrap.js"></script>
<script type="text/javascript" src=""></script>
<script src="${ctx}/admin/js/custom.js"></script>

