<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $("#updateTweetForm").validate({
        submitHandler: function (form) {
            $('.contentLayout').load('AdminController', $("#updateTweetForm").serialize(), function () {
            });
        }
    });

</script>

<form id="updateTweetForm" action="" method="post">
  <input type="hidden" name="tweetID" value="${tweetEdit.tweetId}">
  <div class="field">
    <label class="label">Username</label>
    <div class="control">
      <input class="input" type="text" name="username" id="register-username" value="${tweetEdit.username}"
             placeholder="Username"
             maxlength="30" required disabled>
    </div>
  </div>
  <div class="field">
    <label class="label">Message</label>
    <p class="control">
      <textarea class="textarea" name="content" placeholder="Message">${tweetEdit.content}</textarea>
    </p>
  </div>
  <input type="hidden" name="controller" value="updateTweet">
  <div class="field">
    <p class="control is-expanded">
      <input id="updateTweetSubmit" type="submit" class="button is-primary is-fullwidth" value="UPDATE">
    </p>
  </div>
</form>