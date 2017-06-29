<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<script>
    clickController('');
    function clickController(type) {
        $('.contentLayout').load("AdminController", {controller: type});
    }
</script>

<nav class="categories nav is-mobile has-shadow">
      <a id="home"  onclick="clickController('home')" class="catMenu item active"><i class="fa fa-home"></i> <span
              class="name">Dashboard</span></a>
      <a id="users"  onclick="clickController('users')"  class="catMenu item users"><i class="fa fa-user"></i> <span
              class="name">Users</span></a>
      <a id="tweets"  onclick="clickController('tweets')" class="catMenu item users"><i class="fa fa-twitter"></i> <span
              class="name">Tweets</span></a>
</nav>