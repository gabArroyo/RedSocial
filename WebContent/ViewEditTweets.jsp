<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(document).ready(function() {
	$(".editTweet").click(function(event) {
		$('#content').load('EditPublishedTweetController', {tweetID: $(this).attr('id')});
	});
	$(".deleteTweet").click(function(event) {
		$('#content').load('DeletePublishedTweetController', {tweetID: $(this).attr('id')});
	});
});
</script>

<script src="js/tweetsAndUsers/users.js"></script>
<script src="js/tweetsAndUsers/tweets.js"></script>

<section class="section tweetList">
	<c:forEach var="tweet" items="${tweets}">
		<div class="card card-content tweet">
			<div class="media">
				<div class="media-left">
					<figure class="avatar image is-96x96">
						<a id="${tweet.userId}" class="linkToUser" >
							<img src=<c:out value="${tweet.avatar}"/> alt="Avatar from ${tweet.username}">
						</a>
					</figure>
				</div>
    			<div class="media-content">
    				<p class="title is-4">${tweet.username}</p>
    			</div>
    		</div>
    		<div class="comment">
    			<p>${tweet.content}</p>
    		</div>
			<div class="tweetInfo">
				<a class="editTweet" id="${tweet.tweetId}"><i class="fa fa-pencil" aria-hidden="true"></i>Edit Tweet</a>
   				<a class="deleteTweet" id="${tweet.tweetId}"><i class="fa fa-times" aria-hidden="true"></i> Delete Tweet</a>
   				<span>${tweet.date}</span>
   			</div>
        </div>
    </c:forEach>
</section>