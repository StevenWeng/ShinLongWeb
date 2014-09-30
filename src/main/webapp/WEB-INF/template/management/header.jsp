<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<img class="logo" src="/images/LOGO.png" /> <img class="marklisr"
		src="/images/mzl.hkubauab.png" />
	<h1 class="blog-title">後台管理系統</h1>
	<p class="lead blog-description">SHIN LONG PHARMACY</p>
	<p class=" text-right"><security:authentication property="principal.username"/> 您好！
		<a href="/logout"> 登出</a>
	</p>
</div>