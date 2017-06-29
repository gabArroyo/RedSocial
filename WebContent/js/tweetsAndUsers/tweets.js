$(".likeButton").click(function(event) {
	$('#content').load('LikeTweetController', {action: $(this).attr('id')});
});