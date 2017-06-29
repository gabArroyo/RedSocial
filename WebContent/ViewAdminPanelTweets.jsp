<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function execAction(type, actionId) {
        $(".contentLayout").load("AdminController", {controller: type, action: actionId});
    }
</script>

<table class="table">
  <thead>
  <tr>
    <th>#</th>
    <th>UserName</th>
    <th>Tweet</th>
    <th>Options</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="tweet" items="${tweetList}">
    <tr>
      <th>${tweet.tweetId}</th>
      <th>${tweet.username}</th>
      <th>${tweet.content}</th>
      <th>
        <div class="block">
          <a onclick="execAction('editTweet', ${tweet.tweetId})" style="color: #ffffff !important;"  class="button is-warning">Edit</a>
          <a onclick="execAction('removeTweet', ${tweet.tweetId})" style="color: #ffffff !important;" class="button is-danger">Delete</a>
        </div>
      </th>
    </tr>
  </c:forEach>
  </tbody>
</table>