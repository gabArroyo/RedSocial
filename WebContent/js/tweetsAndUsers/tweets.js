$(".likeButton").click(function(event) {
	$('#content').load('TweetController', {action: $(this).attr('id')});
});

$(".favButton").click(function(event) {
	$('#content').load('TweetController', {action: $(this).attr('id')});
});

$(".replyButton").click(function(event) {
	$('#content').load('TweetController', {action: $(this).attr('id')});
});