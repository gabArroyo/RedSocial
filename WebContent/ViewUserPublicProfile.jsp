<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<nav class="categories nav is-mobile has-shadow">
		<a class="nav-item is-tab is-active">Latest Tweets</a>
		<a class="nav-item is-tab">Most Popular Tweets</a>
		<a class="nav-item is-tab">Tweets from Actors</a>
		<a class="nav-item is-tab">Latest Films</a>
	</nav>
	
	<div class="profileBackground" style="background-image: ${user.background}"></div>
	
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
				<p class="subtitle is-6 location"><i class="fa fa-location-arrow" aria-hidden="true"></i> ${user.location == "" ? "In an unknown place" : "Lives in user.location"}</p>
				<p class="subtitle is-6 link"><i class="fa fa-external-link" aria-hidden="true"></i><a  rel="me nofollow noopener" href="${user.url}">${user.url}</a></p>
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
				<a id="profileLatestTweets" class="nav-item is-tab is-active">Latest Tweets</a>
				<a id="profileMostPopular" class="nav-item is-tab">Most Popular Tweets</a>
			</nav>
			<div class="profileTweets">
			
			
			</div>
		</div>
		
		
		<div class="profileRight">
			<section class="userListProfile">
				<h2 class="subtitle is-4">Other users</h2>
				<div class="card card-content user">
					<div class="avatar">
						<figure class="avatar image is-96x96">
							<img src="https://randomuser.me/api/portraits/women/17.jpg" alt="Image">
						</figure>
						<div class="infoUser">
							<p class="title is-4">freeBonnie</p>
							<p class="subtitle is-6">bonnie freeman</p>
						</div>
					</div>
					<div class="buttons">
						<a class="button is-primary">Follow</a>
					</div>
				</div>
			</section>
		</div>
	</div>