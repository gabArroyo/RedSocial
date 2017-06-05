$(document).ready(function(){
	$("#registerForm").validate({
		submitHandler: function(form) {
			$('#content').load('RegisterController', $("#registerForm").serialize(), function(){
				$('#navigation').load('NavController');});
		}
	});
});
