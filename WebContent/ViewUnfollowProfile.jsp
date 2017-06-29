<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(document).ready(function() {
    $(".unfollowButton").click(function(event) {
    	$('.followProfile').load('UnfollowUserProfileController', {userID: $(this).attr('id')});
    });
    });
</script>

<div class="buttons">
	<a class="unfollowButton button is-primary" id="${followID}">Unfollow</a>
</div>