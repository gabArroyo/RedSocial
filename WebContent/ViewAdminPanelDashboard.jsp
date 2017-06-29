<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="columns">
  <div class="content adminContent column is-10">
<section class="hero">
  <div class="hero-body">
    <div class="container">
      <nav class="level is-mobile">
        <div class="level-item has-text-centered">
          <div>
            <p class="heading">Tweets</p>
            <p class="title">${stats.numTweets}</p>
          </div>
        </div>
        <div class="level-item has-text-centered">
          <div>
            <p class="heading">Following</p>
            <p class="title">${stats.numFollows}</p>
          </div>
        </div>
        <div class="level-item has-text-centered">
          <div>
            <p class="heading">Followers</p>
            <p class="title">${stats.numFollowers}</p>
          </div>
        </div>
        <div class="level-item has-text-centered">
          <div>
            <p class="heading">Users</p>
            <p class="title">${stats.numUsers}</p>
          </div>
        </div>
      </nav>
    </div>
  </div>
</section>
  </div>
</div>