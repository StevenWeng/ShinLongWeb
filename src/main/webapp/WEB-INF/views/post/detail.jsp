<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div class="right">
	<div class="blog-post">
		<h2 class="blog-post-title">${post.title }</h2>
		<p class="blog-post-meta">
			<fmt:formatDate pattern="yyyy-MM-dd" value="${post.publishTs }" />
		</p>
		<div class="tablelist">
			<hr />
			${post.context }
			<hr />
			<p class="text-right"><a href="javascript:history.back()" class="btn btn-success">返回上一頁</a></p>
		</div>
	</div>
</div>
