$(document).ready(function() {
	$(document).ready(function(){
		$("#registerForm").validate({
			submitHandler: function(form) {
				$('#content').load('RegisterController', $("#registerForm").serialize());
			}
		});
	});
});
