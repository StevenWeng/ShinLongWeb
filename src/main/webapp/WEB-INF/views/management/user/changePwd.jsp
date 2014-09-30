<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('p :submit').prop("disabled", true);
		$('#passwordAgain').focusout(function() {
			var passwordAgain = $(this).val();
			var password = $('#password').val();
			if(password == passwordAgain){
				// TODO class
				$('#errorMsg').text('');
				$('#passwordAgainDiv').removeClass('has-error');
				$('p :submit').prop("disabled", false);
			}else{
				// TODO class
				$('#errorMsg').text('密碼兩次輸入不同，請重新輸入');
				$('#passwordAgainDiv').addClass('has-error');
				$('#password').val('');
				$(this).val('');
				$('p :submit').prop("disabled", true);
			}
		});
	});
</script>

<div class="right">
	<div class="blog-post">
		<form role="form" action="/management/user/changePwd" method="post">
			<p class="bg-danger">${errorMsg }</p>
			<h3>您正在修改 ${user.username } 的密碼</h3>
			<input type="hidden" name="id" id="id" value="${user.id }"/>
			<div class="form-group">
				<label for="oldPassword">原始密碼 </label> <input type="password"
					class="form-control" id="oldPassword" name="oldPassword"
					placeholder="Old Password" value="" />
			</div>
			<div class="form-group">
				<label for="password">新密碼</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="New Password" value="" />
			</div>
			<div class="form-group" id="passwordAgainDiv">
				<label for="passwordAgain">再次輸入新密碼 <span id="errorMsg"></span></label> <input type="password"
					class="form-control" id="passwordAgain" name="passwordAgain"
					placeholder="New Password Again" value="" />
			</div>
			
			<p class="text-right">
				<input type="submit" class="btn btn-success" value="儲存" /> <a
					href="/management/user/list" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
