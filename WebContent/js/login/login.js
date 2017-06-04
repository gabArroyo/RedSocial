$(document).ready(function() {
	$(document).ready(function(){
	    $("#loginForm").validate({
	    	submitHandler: function(form) {
	    		$('#content').load('LoginController', $("#loginForm").serialize());
	    	}
	    });
	});
});
