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
			var password = $('#passwordAgain').val();
			if(password == passwordAgain){
				// TODO class
				$('p :submit').prop("disabled", false);
			}else{
				// TODO class
				$('#errorMsg').text('新密碼兩次輸入不同，請確認後重新輸入');
				$('p :submit').prop("disabled", true);
			}
		});
	});
</script>

<div class="right">
	<div class="blog-post">
		<form role="form" action="/management/user/changePwd" method="post">
			<h3>您正在修改 ${user.username } 的密碼</h3>
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
				<label for="passwordAgain">再次輸入新密碼</label> <input type="password"
					class="form-control" id="passwordAgain" name="passwordAgain"
					placeholder="New Password Again" value="" />
			</div>
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<span id="errorMsg">${errorMsg }</span> 
			</div>
			<p class="text-right">
				<input type="submit" class="btn btn-success" value="儲存" /> <a
					href="javascript:history.back()" class="btn btn-success">返回</a>
			</p>
		</form>
	</div>
</div>
