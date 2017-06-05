<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<script type="text/javascript">
$(document).ready(function() {
    $(".menu").click(function(event) {
        $('#content').load('ContentMainController', {controller: "Home", action: $(this).attr('id')});
        });
});
</script>

<a id="ViewLoginForm" class="button is-primary nav-button menu nav-item" href=#>
	LOGIN
</a>
<a id="ViewRegisterForm" class="button is-primary nav-button menu nav-item" href=#>
	SIGN UP
</a>