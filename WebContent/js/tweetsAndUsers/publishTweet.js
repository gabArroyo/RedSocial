$(document).ready(function(){
	$("#publishTweetForm").validate({
		submitHandler: function(form) {
			$('#content').load('PublishTweetController', $("#publishTweetForm").serialize());
		}
	});
});