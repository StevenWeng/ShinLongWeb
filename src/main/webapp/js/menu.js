$(function() {
	$('#menu ul li')
	.mouseenter(function() {
    	$(this).addClass("menuselect");
 	})
  	.mouseleave(function() {
    	$(this).removeClass("menuselect");
  	});
});