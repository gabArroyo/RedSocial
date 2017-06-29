<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src="js/tweetsAndUsers/users.js"></script>
<script src="js/tweetsAndUsers/tweets.js"></script>

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
						<a class="likeButton" id="${tweet.userId}"><i class="fa fa-heart" aria-hidden="true"></i> ${tweet.numLikes}</a>
        				<a class="favButton" id="${tweet.userId}"><i class="fa fa-star" aria-hidden="true"></i> ${tweet.numFavs}</a>
        				<a class="replyButton" id="${tweet.userId}"><i class="fa fa-reply" aria-hidden="true"></i></a>
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
						<a class="likeButton" id="${tweet.userId}"><i class="fa fa-heart" aria-hidden="true"></i> ${tweet.numLikes}</a>
        				<a class="favButton" id="${tweet.userId}"><i class="fa fa-star" aria-hidden="true"></i> ${tweet.numFavs}</a>
        				<a class="replyButton" id="${tweet.userId}"><i class="fa fa-reply" aria-hidden="true"></i></a>
        				<span>${tweet.date}</span>
        			</div>
        		</div>
        	</c:when>
        </c:choose>
    </c:forEach>
</section>