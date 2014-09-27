<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		var edmTitle = $('.carousel').find('div .active').attr('edmTitle');
		$('#edmTitle').text(edmTitle);
		$('.carousel').carousel();
		$('.carousel').on('slid.bs.carousel', function () {
			edmTitle = $(this).find('div .active').attr('edmTitle');
			$('#edmTitle').text(edmTitle);
		});
	});
</script>

<div class="right">
	<h2>促銷優惠專區</h2>
	<hr/>
	<h3 id="edmTitle"></h3>
	<div id="carousel-edm-generic" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<c:forEach items="${edms }" var="edm" varStatus="loop">
				<c:choose>
					<c:when test="${loop.index == 0}">
						<li data-target="#carousel-edm-generic" data-slide-to="${loop.index }" class="active"></li>
					</c:when>
					<c:otherwise>
						<li data-target="#carousel-edm-generic" data-slide-to="${loop.index }"></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ol>
		<!-- Wrapper for slides -->
  		<div class="carousel-inner">
  			<c:forEach items="${edms }" var="edm" varStatus="loop">
				<c:choose>
					<c:when test="${loop.index == 0}">
						<div class="item active" edmTitle="${edm.title }">
							<a href="${edm.imagePath }" target="_blank">
								<img src="${edm.thumbImagePath }" alt="${edm.title }">
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="item" edmTitle="${edm.title }">
							<a href="${edm.imagePath }" target="_blank">
								<img src="${edm.imagePath }" alt="${edm.title }">
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-edm-generic" role="button" data-slide="prev">
		  <span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#carousel-edm-generic" role="button" data-slide="next">
		  <span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	
	<div class="row">
		<hr/>
		<c:forEach items="${coupons }" var="coupon">
			<div class="col-md-5 coupon-list">
				<a href="${coupon.pdfPath }" target="_blank">
					<img width="200" alt="${coupon.title }" src="${coupon.thumbImagePath }" />
				</a>
			</div>
		</c:forEach>
	</div>
	
</div>
