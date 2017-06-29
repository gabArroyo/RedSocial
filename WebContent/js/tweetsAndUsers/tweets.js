$(".likeButton").click(function(event) {
	$.get('LikeTweetController', {tweetID: $(this).attr('id')});
});