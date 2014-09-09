<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${content !=null}">
	<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	$(function() {
		CKEDITOR.config.contentsCss = '/css/style.css';
		CKEDITOR.replace( 'editor1' );
		CKEDITOR.plugins.registered['save'] = {
				init : function(editor) {
					var command = editor.addCommand('save', {
						modes : {
							wysiwyg : 1,
							source : 1
						},
						exec : function(editor) {
							editor.updateElement();
							$.ajax({
								type : "POST",
								url : "/management/page/update",
								data : {
									name : "${name}",
									content : CKEDITOR.instances.editor1.getData()
								},
								dataType : "html",
								success : function(data) {
									if(data == 'OK'){
										if(!confirm('儲存完畢，是否繼續編輯')){
											history.back();
										}
									}else{
										alert(data);
									}
								}
							});
						}
					});
					editor.ui.addButton('Save', {
						label : 'My Save',
						command : 'save'
					});
				}
			};
	});
 </script>
</c:if>

<div class="right">
	<c:choose>
		<c:when test="${content !=null}">
			<h2>${title } - 頁面編輯中</h2>
			<textarea  name="editor1">${content}</textarea>
		</c:when>
		<c:otherwise>
			<h1>尚未選取頁面，請從左側選單選取欲編輯之頁面</h1>
		</c:otherwise>
	</c:choose>
</div>
