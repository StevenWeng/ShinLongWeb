<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css"
	rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/jquery.ui.datepicker-zh-TW.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#publishTs").datepicker();
	});
</script>

<div class="right">
	<div class="blog-post">
		<form role="form" action="/management/edm/update" enctype="multipart/form-data"
		 method="post">
			<input type="hidden" name="id" value="${edm.id }" />
			<div class="form-group">
				<label for="title">標題</label> <input type="text"
					class="form-control" id="title" name="title" placeholder="Title"
					value="${edm.title }" />
			</div>
			<div class="form-group">
				<label for="publishTs">發佈日期</label> <input type="text"
					class="form-control" id="publishTs" name="publishTs"
					placeholder="yyyy-MM-dd"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${edm.publishTs }" />" />
			</div>
			<div class="form-group">
				<label for="imageFile">EDM 檔案上傳</label> 
				<a href="${edm.imagePath }"	target="_blank" class="btn btn-success ">預覽目前圖片</a> 
				<input type="file"	id="imageFile" name="imageFile" />
			</div>

			<p class="text-right">
				<input type="submit" class="btn btn-success" value="儲存" /> <a
					href="javascript:history.back()" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
