<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
$(document).ready(function() {
	$('#navigationCategories').load('NavController', {action: "userCategories"});
	
    $(".menu").click(function(event) {
        $('#content').load('LogoutController', function(){
        	$('#navigation').load('NavController');
        	$('#navigationCategories').empty();	
        	});
        });
    });
</script>

<a class="button is-primary nav-button menu nav-item" id="LogoutController" href=#> Logout </a>