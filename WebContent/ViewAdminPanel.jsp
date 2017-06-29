<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    clickController('')
    function clickController(type) {
        $('.adminContent').load("AdminController", {controller: type});
    }
</script>
<div class="columns">
  <div class="column is-2 aside hero is-fullheight is-hidden-mobile">
    <div class="main">
      <a onclick="clickController('home')" class="item active"><i class="fa fa-home"></i> <span
              class="name">Dashboard</span></a>
      <a onclick="clickController('users')" class="item users"><i class="fa fa-user"></i> <span
              class="name">Users</span></a>
      <a onclick="clickController('tweets')" class="item users"><i class="fa fa-twitter"></i> <span
              class="name">Tweets</span></a>
    </div>
  </div>
  <div class="content adminContent column is-10">

  </div>
</div>