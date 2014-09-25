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
		$("#startDate").datepicker();
		$("#endDate").datepicker();
	});
</script>

<div class="right">
	<div class="blog-post">
		<form role="form" action="/management/coupon/update" enctype="multipart/form-data"
		 method="post">
			<input type="hidden" name="id" value="${coupon.id }" />
			<div class="form-group">
				<label for="title">標題</label> <input type="text"
					class="form-control" id="title" name="title" placeholder="Title"
					value="${coupon.title }" />
			</div>
			<div class="form-group">
				<label for="startDate">開始日期</label> <input type="text"
					class="form-control" id="startDate" name="startDate"
					placeholder="yyyy-MM-dd"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${coupon.startDate }" />" />
			</div>
			<div class="form-group">
				<label for="endDate">結束日期</label> <input type="text"
					class="form-control" id="endDate" name="endDate"
					placeholder="yyyy-MM-dd"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${coupon.endDate }" />" />
			</div>
			<div class="form-group">
				<label for="imageFile">優惠券圖檔上傳</label> 
				<a href="${coupon.imagePath }"	target="_blank" class="btn btn-success ">預覽目前圖檔</a> 
				<input type="file"	id="imageFile" name="imageFile" />
			</div>
			<div class="form-group">
				<label for="thumbImageFile">優惠券縮圖圖檔上傳</label> 
				<a href="${coupon.thumbImagePath }"	target="_blank" class="btn btn-success ">預覽目前縮圖圖檔</a> 
				<input type="file"	id="thumbImageFile" name="thumbImageFile" />
			</div>

			<p class="text-right">
				<input type="submit" class="btn btn-success" value="儲存" /> <a
					href="javascript:history.back()" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
