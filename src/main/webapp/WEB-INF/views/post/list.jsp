<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript" src="/js/jquery-pageBar.js"></script>
<script type="text/javascript">
	$(function(){
		$('.page').pageBar({
			'pageNo' : ${pageNo},
			'pageSize' : ${pageSize},
			'totalPages' : ${totalPages}
		});
	});
</script>

<div class="right">
	<h2>營養保健</h2>
	<div class="tablelist">
		<table width="568px">
			<tr class="tablehead">
				<th width="20%">時間</th>
				<th>標題</th>
			</tr>
			<c:forEach items="${posts }" var="post">
				<tr class="tablerow">
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${post.publishTs }" /></td>
					<td>${post.title }</td>
				</tr>
			</c:forEach>
		</table>
		<form action="/post/list" method="post" id="mainPage">
			<div class="page"></div>
		</form>
	</div>
</div>
