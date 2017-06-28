$(document).ready(function(){
	$("#privateProfileForm").validate({action: "changeUserInfo",
		submitHandler: function(form) {
			$('#content').load('UpdateUserPrivateProfileController', $("#privateProfileForm").serialize());
		}
	});
});
