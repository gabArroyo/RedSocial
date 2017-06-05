<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
$(document).ready(function() {
    $(".menu").click(function(event) {
		$('#navigation').load('LogoutController', {content: $(this).attr('id')});
        $('#content').load('LogoutController', {content: $(this).attr('id')+"Main"});
        });
    });
</script>

<a class="button is-primary nav-button menu nav-item" id="LogoutController" href=#> Logout </a>