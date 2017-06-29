<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(document).ready(function() {
    $(".tweets").click(function(event) {
        $('#content').load('ListTweetsController', {action: $(this).attr('id')});
        });
});
</script>

<script src="js/tweetsAndUsers/users.js"></script>
<script src="js/tweetsAndUsers/tweets.js"></script>


<nav class="categories">
	<a id="latestTweets" class="nav-item tweets is-tab ${category == 'latestTweets' ? 'is-active' : ''}">Latest Tweets</a>
    <a id="mostPopularTweets" class="nav-item tweets is-tab ${category == 'mostPopularTweets' ? 'is-active' : ''}">Most Popular Tweets</a>
    <a id="latestTweetsActors" class="nav-item tweets is-tab ${category == 'latestTweetsActors' ? 'is-active' : ''}">Tweets from Actors</a>
</nav>

<section class="section tweetList">
	<c:forEach var="tweet" items="${tweets}">
		<c:choose>
			<c:when test = "${tweet.userType == 0}">
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
						<a class="likeButton" id="like-${tweet.userId}"><i class="fa fa-heart" aria-hidden="true"></i> ${tweet.numLikes}</a>
        				<a class="favButton" id="numFavs-${tweet.userId}"><i class="fa fa-star" aria-hidden="true"></i> ${tweet.numFavs}</a>
        				<a class="replyButton" id="reply-${tweet.userId}"><i class="fa fa-reply" aria-hidden="true"></i></a>
        				<span>${tweet.date}</span>
        			</div>
        		</div>
        	</c:when>
        	<c:when test="${tweet.userType == 1}">
        		<div class="card card-content tweet actorTweet">
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
						<a class="likeButton" id="like-${tweet.userId}"><i class="fa fa-heart" aria-hidden="true"></i> ${tweet.numLikes}</a>
        				<a class="favButton" id="numFavs-${tweet.userId}"><i class="fa fa-star" aria-hidden="true"></i> ${tweet.numFavs}</a>
        				<a class="replyButton" id="reply-${tweet.userId}"><i class="fa fa-reply" aria-hidden="true"></i></a>
        				<span>${tweet.date}</span>
        			</div>
        		</div>
        	</c:when>
        </c:choose>
    </c:forEach>
</section>