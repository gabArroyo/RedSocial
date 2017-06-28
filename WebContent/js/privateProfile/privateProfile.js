$(document).ready(function(){
	$("#privateProfileForm").validate({
		submitHandler: function(form) {
			$('#content').load('UserPrivateProfileController', $("#privateProfileForm").serialize());
		}
	});
});
