<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function(){
	});
</script>

<div class="right">
	<h2>使用者管理</h2>
	<p class="text-right">
		<a href="/management/user/create" class="btn btn-success ">建立使用者</a>
	</p>
	<div class="tablelist">
		<table class="table table-hover" width="568px">
			<tr class="tablehead">
				<th>使用者帳號</th>
				<th width="30%">操作</th>
			</tr>
			<c:forEach items="${users }" var="user">
				<tr class="tablerow">
					<td>${user.username }</td>
					<td><a href="/management/user/changePwd/${user.id }"
						class="btn btn-success ">修改密碼</a> <a
						href="/management/user/delete?id=${user.id }"
						class="btn btn-success ">刪除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
