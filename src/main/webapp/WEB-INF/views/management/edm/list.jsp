<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/jquery-pageBar.js"></script>
<script type="text/javascript">
	$(function(){
		$('.dropdown-toggle').dropdown();
		$('.page').pageBar({
			'pageNo' : ${pageNo},
			'pageSize' : ${pageSize},
			'totalPages' : ${totalPages}
		});
	});
</script>

<div class="right">
	<h2>EDM管理</h2>
	<p class="text-right">
		<a href="/management/edm/create" class="btn btn-success ">建立EDM</a>
	</p>
	<div class="tablelist">
		<table class="table table-hover" width="568px">
			<tr class="tablehead">
				<th width="20%">時間</th>
				<th>標題</th>
				<th width="40%">操作</th>
			</tr>
			<c:forEach items="${edms }" var="edm">
				<tr class="tablerow">
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${edm.publishTs }" /></td>
					<td>${edm.title }</td>
					<td>
						<div class="dropdown">
						  	<a data-toggle="dropdown" class="btn btn-success " href="#">操作<span class="caret"></span></a>
							  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							    <li role="presentation"><a role="menuitem" tabindex="-1" href="/management/edm/edit/${edm.id }">編輯</a></li>
							    <li role="presentation"><a role="menuitem" tabindex="-1" href="/management/edm/delete?id=${edm.id }" >刪除</a></li>
							  </ul>
							<a href="${edm.imagePath }" target="_blank"	class="btn btn-success ">預覽</a> 
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<form action="/management/edm/list" method="post" id="mainPage">
			<div class="page"></div>
		</form>
	</div>
</div>
