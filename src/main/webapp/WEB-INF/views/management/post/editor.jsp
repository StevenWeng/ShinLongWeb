<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div class="right">
	<div class="blog-post">
		<form role="form" action="/management/post/update" method="post">
			<div class="form-group">
				<label for="title">標題</label> <input type="text"
					class="form-control" id="title" name="title" placeholder="Title"
					value="${post.title }" />
			</div>
			<div class="form-group">
				<label for="publishTs">發佈日期</label> <input type="text"
					class="form-control" id="publishTs" name="publishTs"
					placeholder="yyyy/MM/dd"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${post.publishTs }" />" />
			</div>
			<div class="form-group">
				<label for="context">文章內容</label>
				<textarea id="context" name="context" class="form-control" rows="3">${post.context }</textarea>
			</div>

			<p class="text-right">
				<a href="javascript:history.back()" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
