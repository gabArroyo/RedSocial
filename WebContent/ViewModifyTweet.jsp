<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script>
$(document).ready(function(){
	$("#editTweetForm").validate({
		submitHandler: function(form) {
			$('#content').load('ModifyPublishedTweetController', $("#editTweetForm").serialize());
		}
	});
});
</script>

<div class="section editTweet">
	<form id="editTweetForm" action="" method="post">
		<h4 class="subtitle is-4">Content</h4>
		<div class="field">
			<p class="control">
				<textarea class="textarea" name="content" placeholder="" >${tweet.content}</textarea>
				<input name="tweetID" style="display: none" value="${tweet.tweetID}">
			</p>
		</div>
		<div class="field">
			<p class="control is-expanded">
				<input id="privateProfileSubmit" class="button is-primary is-fullwidth" value="Edit Tweet" type="submit">
			</p>
		</div>
	</form>
</div>