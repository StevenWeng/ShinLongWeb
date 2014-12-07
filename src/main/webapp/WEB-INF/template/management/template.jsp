<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" href="/css/style.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"
	media="screen" />
<link rel="icon" href="/images/favicon.ico" type="image/x-icon" /> 
<link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />
<script language="javascript" src="/js/jquery-1.11.1.js"></script>
<script language="javascript" src="/js/menu.js"></script>
</head>
<body>

	<div id="wrap">

		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />



		<div id="content">


			<tiles:insertAttribute name="rightContent" />
			<tiles:insertAttribute name="leftContent" />
			<div style="clear: both;"></div>
		</div>

		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>