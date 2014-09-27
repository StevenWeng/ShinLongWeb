<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.dropdown-toggle').dropdown();
	});
</script>

<div class="right">
	<h2>優惠券管理</h2>
	<p class="text-right">
		<a href="/management/coupon/create" class="btn btn-success ">建立優惠券</a>
	</p>
	<div class="tablelist">
		<table class="table table-hover" width="568px">
			<tr class="tablehead">
				<th width="20%">起始時間</th>
				<th width="20%">結束時間</th>
				<th>標題</th>
				<th width="30%">操作</th>
			</tr>
			<c:forEach items="${coupons }" var="coupon">
				<tr class="tablerow">
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${coupon.startDate }" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${coupon.endDate }" /></td>
					<td>${coupon.title }</td>
					<td>
						<div class="dropdown">
						<span>
						  <a data-toggle="dropdown" id="optDrop" class="btn btn-success " href="#">操作<span class="caret"></span></a>
						  <ul class="dropdown-menu" id="optMenu" role="menu" aria-labelledby="optDrop">
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="/management/coupon/edit/${coupon.id }">編輯</a></li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="/management/coupon/delete?id=${coupon.id }">刪除</a></li>
						  </ul>
						</span>
						<span>
						  <a data-toggle="dropdown" id="prvDrop" class="btn btn-success " href="#">預覽<span class="caret"></span></a>
						  <ul class="dropdown-menu" id="prvMenu" role="menu" aria-labelledby="prvDrop">
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="${coupon.imagePath }" target="_blank">預覽圖片</a> </li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="${coupon.thumbImagePath }" target="_blank">預覽縮圖</a> </li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="${coupon.pdfPath }" target="_blank">預覽列印</a> </li>
						  </ul>
						 </span>
						</div>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
