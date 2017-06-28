<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(document).ready(function() {
	$('.profileTweets').load('ListTweetsController', {action: "profileLatestTweets", userID: ${user.userID}});
	
	$(".tweets").click(function(event) {
        $('.profileTweets').load('ListTweetsController', {action: $(this).attr('id'), userID: ${user.userID}});
        $('#profileLatestTweets').removeClass('is-active');
        $('#profileMostPopular').removeClass('is-active');
        $(this).addClass('is-active');
        });
});
</script>
	<div class="profileBackground" style="background-image: url('${user.background}')"></div>
	
	<div class="profileContainer">
		<div class="profile">
			<div class="avatar">
				<img src="${user.avatar}" alt="Avatar from ${user.username}">
			</div>
			
			<div class="profile-info">
				<h1 class="title is-2 username">${user.username}</h1>
				<h2 class="subtitle is-4  name">${user.name} ${user.surname}</h2>
				<p class="subtitle is-6 description">${user.description}</p>
				<p class="subtitle is-6 birthday"><i class="fa fa-birthday-cake" aria-hidden="true"></i> Was born on ${user.birth}</p>
				<p class="subtitle is-6 location"><i class="fa fa-location-arrow" aria-hidden="true"></i> ${user.location}</p>
				<c:if test = "${user.url != ''}">
					<p class="subtitle is-6 link"><i class="fa fa-external-link" aria-hidden="true"></i><a  rel="me nofollow noopener" href="${user.url}">${user.url}</a></p>
				</c:if>
				<p class="subtitle is-5 tweets">Tweets: <a id="">${user.numTweets}</a></p>
				<p class="subtitle is-5 followers">Followers: <a>${user.numFollowers}</a></p>
				<p class="subtitle is-5 follows">Follows: <a>${user.numFollows}</a></p>
				
				<div class="profileFilms">
					<h2 class="subtitle is-5 follows">Favorite films</h2>
					<div class="favfilm card card-content">
						<img src="https://pics.filmaffinity.com/django_unchained-956246347-large.jpg" alt="Image">
						<p class="subtitle is-5 ">Django Unchained </p>
					</div>>
					<a id="showFilms">More films...</a>
				</div>
				<div class="profileActors">
					<h2 class="subtitle is-5 follows">Favorite actors</h2>
					<div class="favfilm card card-content">
							<img src="http://www.ennetflix.mx/media/actors/vin-diesel.jpg" alt="Image">
							<p class="subtitle is-5 "> Vin Diesel </p>
					</div>
					<a id="showActors">More actors...</a>
				</div>
			</div>
		</div>
		
		
		<div class="profileContent">
			<nav class="nav is-mobile has-shadow">
				<a id="profileLatestTweets" class="nav-item tweets is-tab is-active">Latest Tweets</a>
				<a id="profileMostPopular" class="nav-item tweets is-tab">Most Popular Tweets</a>
			</nav>
			<div class="profileTweets">
			</div>
		</div>
		
		<div class="profileRight">
			<div class="usersToFollow">
			</div>
		</div>
	</div>