<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src="js/tweetsAndUsers/users.js"></script>
<script src="js/tweetsAndUsers/publishTweet.js"></script>

<div class="section publishTweet">
	<form id="publishTweetForm" action="" method="post">
		<h4 class="subtitle is-4">Content</h4>
		<div class="field">
			<p class="control">
				<textarea class="textarea" name="content" placeholder="Textarea"></textarea>
			</p>
		</div>
		<div class="field">
			<p class="control is-expanded">
				<input id="privateProfileSubmit" class="button is-primary is-fullwidth" value="Publish Tweet" type="submit">
			</p>
		</div>
	</form>
</div>