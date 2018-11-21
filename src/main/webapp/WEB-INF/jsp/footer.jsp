<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer style="    background: #014899">
	<p>&copy; Copyright 2018&nbsp; 高校场地管理系统</p>
</footer>
<script>
	$(document).ready(function() {
		minHeight = $(window).height();
		$('#main').css("min-height", (minHeight-70) + "px");
	});
</script>