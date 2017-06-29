$(document).ready(function() {
	$(".linkToUser").click(function(event) {
        $('#content').load('LoadUserPublicProfileController', {userID: $(this).attr('id')});
	});
});
