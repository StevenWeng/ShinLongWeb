<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		$('p :submit').prop( "disabled", true );
		$('#username').focusout(function() {
			var username = $(this).val();
			$.get("/management/user/isExist/" + username, function(data) {
				if(data.result == 'ok'){
					$('#errorMsg').text('');
					$('#usernameDiv').removeClass('has-error');
					$('#usernameDiv').addClass('has-success');
					$('p :submit').prop( "disabled", false );
				}else{
					$('#errorMsg').text('該帳號已存在，請輸入其他帳號');
					$('#usernameDiv').removeClass('has-success');
					$('#usernameDiv').addClass('has-error');
					$('p :submit').prop( "disabled", true );
				}
			});
		});
	});
</script>

<div class="right">
	<div class="blog-post">
		<form role="form" action="/management/user/create" method="post">
			<div class="form-group" id="usernameDiv">
				<label for="username">使用者帳號 <span id="errorMsg"></span>
				</label> <input type="text" class="form-control" id="username"
					name="username" placeholder="Username" value="" />
			</div>
			<div class="form-group">
				<label for="password">使用者密碼</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Password" value="" />
			</div>

			<p class="text-right">
				<input type="submit" class="btn btn-success" value="儲存" /> <a
					href="/management/user/list" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
