<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"
	media="screen" />
<title>HELLO</title>
</head>
<body ng-app>
	<h1>登入使用者 <security:authentication property="principal.username"></security:authentication>  </h1>
	<h1>
		<tiles:getAsString name="header"></tiles:getAsString>
	</h1>
	<h1>Hello ${user }</h1>
	<h1>WorkDir ${workDir }</h1>
	{{ 9999 }}

	<br> {{ 9999+1 }}

	<br> {{ 9*9 }}

	<br> {{ 'Hello World' }}

	<div class="form-group">
		<label class="col-sm-2 control-label">數量:</label>
		<input type="number" ng-model="quantity" ng-init="quantity = 1" class="form-control">
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">單價:</label>
		<input type="number" ng-model="price" ng-init="price = 299" class="form-control">
	</div>
	<p> 總價: <mark>{{ quantity * price }}</mark></p>
</body>
</html>