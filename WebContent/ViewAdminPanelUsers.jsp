<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  ul.options-users {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
  }

  .options-users li {
    float: left;
  }

  .options-users li a {
    display: block;
    color: white;
    text-align: center;
    padding: 16px;
    text-decoration: none;
  }

</style>

<script>
    function execAction(type, userId) {
        $(".contentLayout").load("AdminController", {controller: type, action: userId});
    }
</script>
<table class="table">
  <thead>
  <tr>
    <th>#</th>
    <th>UserName</th>
    <th>Email</th>
    <th>Verified</th>
    <th>Options</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${userList}">
    <tr>
      <th>${user.userID}</th>
      <th>${user.username}</th>
      <th>${user.email}</th>
      <th><c:if test="${user.userType == '1'}"><i class="fa fa-check-circle" aria-hidden="true"></i> </c:if></th>
      <th>
        <div class="block">
          <a onclick="execAction('editUser', ${user.userID})" style="color: #ffffff !important;" class="button is-warning">Edit</a>
          <a onclick="execAction('removeUser', ${user.userID})" style="color: #ffffff !important;"  class="button is-danger">Delete</a>
        </div>
      </th>
    </tr>
  </c:forEach>
  </tbody>
</table>