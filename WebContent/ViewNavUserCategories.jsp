<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
$(document).ready(function() {
    $(".catMenu").click(function(event) {
    	$('#content').load('ContentMainController', {controller: $(this).attr('id'), action: $(this).attr('id')});
        $('#latestTweets').removeClass('is-active');
        $('#personalTimeline').removeClass('is-active');
        $('#publicProfile').removeClass('is-active');
        $('#publishTweet').removeClass('is-active');
        $('#personalPage').removeClass('is-active');
        $('#personalFollowers').removeClass('is-active');
        $('#personalFollow').removeClass('is-active');
        $(this).addClass('is-active');
        });
    });
</script>

<nav class="categories nav is-mobile has-shadow">
	<a id="latestTweets" class="nav-item catMenu is-tab">Latest Tweets</a>
	<a id="personalTimeline" class="nav-item catMenu is-tab">Personal Timeline</a>
	<a id="publicProfile" class="nav-item catMenu is-tab is-active">Public Profile</a>
	<a id="publishTweet" class="nav-item catMenu is-tab">Publish and See Your Tweets</a>
	<a id="personalPage" class="nav-item catMenu is-tab">Personal Page</a>
	<a id="personalFollowers" class="nav-item catMenu is-tab">Followers</a>
	<a id="personalFollow" class="nav-item catMenu is-tab">Followed Users</a>
</nav>