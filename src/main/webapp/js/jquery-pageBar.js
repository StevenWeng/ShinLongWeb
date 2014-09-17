;
(function($) {
	// plugin pageBar
	$.fn.pageBar = function(options) {
		/*
		 * Create some defaults, extending them with any options that were
		 * provided
		 */
		var settings = $.extend({
			'pageNo' : 1,
			'pageSize' : 10,
			'totalPages' : 10
		}, options);

		return this
				.each(function() {
					// Tooltip plugin code here
					var pageBar = $(this);
					var pageNo = settings.pageNo;
					var pageSize = settings.pageSize;
					var totalPages = settings.totalPages;

					if (pageNo == 1) {
						$(pageBar)
								.append(
										'<span class="disabled">&nbsp;&lt;&nbsp;&nbsp;最前頁</span>'
												+ '<span class="disabled">&lt;&lt;</span>');
					} else {
						$(pageBar)
								.append(
										'<a href="javascript:void(0)" class="first">&nbsp;&lt;&nbsp;&nbsp;最前頁</a>'
												+ '<a href="javascript:void(0)" class="pre">&lt;&lt;</a>');
					}

					if (pageNo > 6) {
						$(pageBar).append('...');
					}
					// for
					// alert(pageNo + 5 > totalPages ? totalPages : pageNo + 5);
					for (i = pageNo <= 5 ? 1 : pageNo - 5; i <= (pageNo + 5 > totalPages ? totalPages
							: pageNo + 5); i++) {
						if (i != pageNo) {
							$(pageBar).append(
									'<a href="javascript:void(0)" class="turnPage">'
											+ i + '</a>');
						} else {
							$(pageBar).append(
									'<span class="current">' + i + '</span>');
						}
					}

					if (pageNo + 7 < totalPages) {
						$(pageBar).append('...');
						$(pageBar).append(
								'<a href="javascript:void(0)" class="turnPage">'
										+ (totalPages - 1) + '</a>');
						$(pageBar).append(
								'<a href="javascript:void(0)" class="turnPage">'
										+ totalPages + '</a>');
					}

					if (pageNo == totalPages) {
						$(pageBar)
								.append(
										'<span class="disabled">&gt;&gt;</span>'
												+ '<span class="disabled">最後頁&nbsp&nbsp&gt;&nbsp</span>');
					} else {
						$(pageBar)
								.append(
										'<a href="javascript:void(0)" class="next">&gt;&gt;</a>'
												+ '<a href="javascript:void(0)" class="last">最後頁&nbsp&nbsp&gt;&nbsp</a>');
					}
					$(pageBar).append(
							'<input type="hidden" id="pageNo" name="pageNo" value="'
									+ pageNo + '"/>');
					$(pageBar).append(
							'<input type="hidden" id="pageSize" name="pageSize" value="'
									+ pageSize + '"/>');

					$('.turnPage').each(function() {
						$(this).click({
							page : $(this).html()
						}, setPageNo);
					});
					$('.first').click({
						page : 1
					}, setPageNo);
					$('.pre').click({
						page : pageNo - 1
					}, setPageNo);
					$('.next').click({
						page : pageNo + 1
					}, setPageNo);
					$('.last').click({
						page : totalPages
					}, setPageNo);
				});
	};

	$.fn.staticPageBar = function(options) {
		var settings = $.extend({
			'pageSize' : 10,
			'countingClass' : 'counting'
		}, options);

		return this
				.each(function() {
					var count = 0;

					$('.' + settings.countingClass).each(function() {
						if(count>=settings.pageSize){
							$(this).hide();
						}
						count++;
					});

					var pageBar = $(this);
					var pageNo = $('#pageNo').val() == null ? 1 : $('#pageNo')
							.val();
					var pageSize = settings.pageSize;
					var totalPages = Math.floor(count / pageSize);
					if (count % pageSize != 0) {
						totalPages += 1;
					}
					settings.totalPages = totalPages;

					// alert(pageNo + ' ' + pageSize +' '+ totalPages);

					if (pageNo == 1) {
						$(pageBar)
								.append(
										'<span class="disabled first">&nbsp;&lt;&nbsp;&nbsp;最前頁</span>'
												+ '<span class="disabled pre">&lt;&lt;</span>');
					} else {
						$(pageBar)
								.append(
										'<a href="javascript:void(0)" class="first">&nbsp;&lt;&nbsp;&nbsp;最前頁</a>'
												+ '<a href="javascript:void(0)" class="pre">&lt;&lt;</a>');
					}

					if (pageNo > 6) {
						$(pageBar).append('...');
					}
					// for
					// alert(pageNo + 5 > totalPages ? totalPages : pageNo + 5);
					for (i = pageNo <= 5 ? 1 : pageNo - 5; i <= (pageNo + 5 > totalPages ? totalPages
							: pageNo + 5); i++) {
						if (i != pageNo) {
							$(pageBar).append(
									'<a href="javascript:void(0)" class="turnPage">'
											+ i + '</a>');
						} else {
							$(pageBar).append(
									'<span class="current">' + i + '</span>');
						}
					}

					if (pageNo + 7 < totalPages) {
						$(pageBar).append('...');
						$(pageBar).append(
								'<a href="javascript:void(0)" class="turnPage">'
										+ (totalPages - 1) + '</a>');
						$(pageBar).append(
								'<a href="javascript:void(0)" class="turnPage">'
										+ totalPages + '</a>');
					}

					if (pageNo == totalPages) {
						$(pageBar)
								.append(
										'<span class="disabled next">&gt;&gt;</span>'
												+ '<span class="disabled last">最後頁&nbsp&nbsp&gt;&nbsp</span>');
					} else {
						$(pageBar)
								.append(
										'<a href="javascript:void(0)" class="next">&gt;&gt;</a>'
												+ '<a href="javascript:void(0)" class="last">最後頁&nbsp&nbsp&gt;&nbsp</a>');
					}
					$(pageBar).append(
							'<input type="hidden" id="pageNo" name="pageNo" value="'
									+ pageNo + '"/>');
					$(pageBar).append(
							'<input type="hidden" id="pageSize" name="pageSize" value="'
									+ pageSize + '"/>');

					$('.turnPage').each(function() {
						$(this).click({
							settings : settings,
							oriPage : $('#pageNo').val(),
							page : $(this).html()
						}, showStaticPage);
					});
					$('.first').click({
						settings : settings,
						oriPage : $('#pageNo').val(),
						page : 1
					}, showStaticPage);
					$('.pre').click({
						settings : settings,
						oriPage : $('#pageNo').val(),
						page : parseInt($('#pageNo').val()) - 1
					}, showStaticPage);
					$('.next').click({
						settings : settings,
						oriPage : $('#pageNo').val(),
						page : parseInt($('#pageNo').val()) + 1
					}, showStaticPage);
					$('.last').click({
						settings : settings,
						oriPage : $('#pageNo').val(),
						page : totalPages
					}, showStaticPage);

				});

	};
})(jQuery);

function showStaticPage(event) {
	var ori = $('#pageNo').val();
	var page = event.data.page;
//	alert(ori + ' ' + page);
	$('span.current').each(function(){
		var pre = $(this).prev();
		$(this).remove();
		pre.after('<a href="javascript:void(0)" class="turnPage">'
				+ ori + '</a>');
		pre.next().click({
			settings : event.data.settings,
			page : pre.next().html()
		}, showStaticPage);
	});
	$('.turnPage').each(
			function() {
				if($(this).html() == page){
					var pre = $(this).prev();
					$(this).remove();
					pre.after('<span class="current">' + page + '</span>');
				}
			});
	$('#pageNo').val(page);
	//========控制資料顯示=======
	
	var pageSize = event.data.settings.pageSize;
	var startIdx = pageSize * (page -1);
	var endIdx = pageSize * page;
	$('.' + event.data.settings.countingClass).hide();
	var idx = 0;
	$('.' + event.data.settings.countingClass).each(function() {
		if(idx>=startIdx && idx < endIdx){
			$(this).fadeIn("slow");
		}
		idx++;
	});
	
	//=====控制最前頁、最後頁按鈕===
//	alert(event.data.settings.totalPages);
	
	$('.first').unbind('click');
	$('.pre').unbind('click');
	$('.next').unbind('click');
	$('.last').unbind('click');
	if(page == 1){
		$('.first').replaceWith('<span class="disabled first">&nbsp;&lt;&nbsp;&nbsp;最前頁</span>');
		$('.pre').replaceWith('<span class="disabled pre">&lt;&lt;</span>');
	}else{
		$('.first').replaceWith('<a href="javascript:void(0)" class="first">&nbsp;&lt;&nbsp;&nbsp;最前頁</a>');
		$('.pre').replaceWith('<a href="javascript:void(0)" class="pre">&lt;&lt;</a>');
		$('.first').click({
			settings : event.data.settings,
			page : 1
		}, showStaticPage);
		$('.pre').click({
			settings : event.data.settings,
			page : parseInt($('#pageNo').val()) - 1
		}, showStaticPage);
	}
	if(page == event.data.settings.totalPages){
		$('.next').replaceWith('<span class="disabled next">&gt;&gt;</span>');
		$('.last').replaceWith('<span class="disabled last">最後頁&nbsp&nbsp&gt;&nbsp</span>');
	}else{
		$('.next').replaceWith('<a href="javascript:void(0)" class="next">&gt;&gt;</a>');
		$('.last').replaceWith('<a href="javascript:void(0)" class="last">最後頁&nbsp&nbsp&gt;&nbsp</a>');
		$('.next').click({
			settings : event.data.settings,
			page : parseInt($('#pageNo').val()) + 1
		}, showStaticPage);
		$('.last').click({
			settings : event.data.settings,
			page : event.data.settings.totalPages
		}, showStaticPage);
	}
	
	return;
}

function setPageNo(event) {
	setPageSubmit(event.data.page);
	return;
}
function setPageSubmit(page){
	if($('#pageNo') && page) $('#pageNo').val(page);
	$('#mainPage').submit();
    return;
}