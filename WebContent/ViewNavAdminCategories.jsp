<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<script>

$(document).ready(function() {
    $(".catMenu").click(function(event) {
    	$('.adminContent').load('AdminController', {controller: $(this).attr('id')});
        });
    });
</script>

<nav class="categories nav is-mobile has-shadow">
      <a id="home" class="catMenu item active"><i class="fa fa-home"></i> <span
              class="name">Dashboard</span></a>
      <a id="users" class="catMenu item users"><i class="fa fa-user"></i> <span
              class="name">Users</span></a>
      <a id="tweets" class="catMenu item users"><i class="fa fa-twitter"></i> <span
              class="name">Tweets</span></a>
</nav>