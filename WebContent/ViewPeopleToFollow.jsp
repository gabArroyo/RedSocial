<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
$(document).ready(function() {
    $(".followButton").click(function(event) {
    	$('.usersToFollow').load('FollowUserController', {userID: $(this).attr('id')});
        });
    });
</script>

<section class="userListProfile">
	<c:forEach var="user" items="${userList}">
	<div class="card card-content user">
		<div class="avatar">
			<figure class="avatar image is-96x96">
				<a id="${user.userId}" class="linkToUser" >
				<img src="${user.avatar}" alt="Image">
				</a>
			</figure>
		</div>
		<div class="infoUser">
			<p class="title is-4">${user.username}</p>
		</div>
		<c:if test="${not empty sessionUser}">
		<div class="buttons">
			<a class="followButton button is-primary" id="${user.userId}">Follow</a>
		</div>
		</c:if>
	</div>
    </c:forEach>
</section>
