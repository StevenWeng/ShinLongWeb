<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="left-content">
	<div class="newlist">
		<h2>最新消息</h2>
		<ul>
			<c:forEach items="${postsInLeft }" var="post">
				<li>
					<div class="news">
						<h4>${post.title }</h4>
						<p align="right">
							<a href="/post/detail/${post.id }">(詳細內容)</a>
						</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<c:forEach items="${coupons }" var="coupon">
		<div class="coupon-list">
			<a href="${coupon.pdfPath }" target="_blank">
				<img width="200" alt="${coupon.title }" src="${coupon.thumbImagePath }" />
			</a>
		</div>
	</c:forEach>
</div>