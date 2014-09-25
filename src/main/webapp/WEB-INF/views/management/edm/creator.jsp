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
		<form role="form" action="/management/edm/create" enctype="multipart/form-data"
		 method="post">
			<div class="form-group">
				<label for="title">標題</label> <input type="text"
					class="form-control" id="title" name="title" placeholder="Title"
					value="" />
			</div>
			<div class="form-group">
				<label for="publishTs">發佈日期</label> <input type="text"
					class="form-control" id="publishTs" name="publishTs"
					placeholder="yyyy-MM-dd" value="" />
			</div>
			<div class="form-group">
				<label for="imageFile">EDM 檔案上傳</label> <input type="file"
					id="imageFile" name="imageFile" />
			</div>

			<p class="text-right">
				<input type="submit" class="btn btn-success" value="儲存" /> <a
					href="javascript:history.back()" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
