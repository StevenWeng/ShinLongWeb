<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="/css/signin.css" media="screen" />
        <title>後台登入</title>
    </head>
    <body>
    	<div class="container">
	
	      <form class="form-signin" role="form" method="post" action="j_spring_security_check">
	        <h2 class="form-signin-heading">Please sign in</h2>
	        <input type="text" class="form-control" name="j_username" placeholder="Username" required="" autofocus=""/>
	        <input type="password" class="form-control" name="j_password" placeholder="Password" required=""/>
	        <label class="checkbox">
	          <input type="checkbox" name="_spring_security_remember_me" value="remember-me"/> Remember me
	        </label>
	        <c:if test="${param.error != null}">
	            <p class="bg-danger">帳號或密碼有誤！</p>
	        </c:if>
	        <input class="btn btn-lg btn-primary btn-block" type="submit" value="登入"></input>
	      </form>
	
	    </div>
        
        
    </body>
</html>