<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    $("#updateForm").validate({
        submitHandler: function (form) {
            $('.contentLayout').load('AdminController', $("#updateForm").serialize(), function () {
            });
        }
    });


</script>
<form id="updateForm" action="" method="post">
  <input type="hidden" name="userID" value="${userEdit.userID}">

  <div class="field">
    <div class="control">
      <input class="input" type="text" name="username" id="register-username" value="${userEdit.username}"
             placeholder="Username"
             maxlength="30" required>
    </div>
    <c:if test="${user.error[0] == 1}">
      <p class="help is-danger">The user already exists in the DB!</p>
    </c:if>
  </div>
  <div class="field">
    <div class="control">
      <input class="input" type="email" name="email" id="register-email" value="${userEdit.email}" placeholder="Email"
             maxlength="100"
             required>
    </div>
    <c:if test="${user.error[1] == 1}">
      <p class="help is-danger">The email already exists in our DB!</p>
    </c:if>
  </div>
  <hr>
  <div class="field">
    <p class="control">
      <input class="input" type="text" name="name" value="${userEdit.name}" placeholder="Name">
    </p>
  </div>
  <div class="field">
    <p class="control">
      <input class="input" type="text" name="surname" value="${userEdit.surname}" placeholder="Surname">
    </p>
  </div>
  <div class="field">
    <p class="control">
      <label for="register-male" class="radio">
        <input type="radio" id="register-male" value="Male"
        <c:if test="${userEdit.gender == 'Male'}"> checked </c:if> name="gender"> Male
      </label>
      <label for="register-female" class="radio">
        <input type="radio" id="register-female" value="Female"
        <c:if test="${userEdit.gender == 'Female'}"> checked </c:if> name="gender"> Female
      </label>
      <label for="register-other" class="radio">
        <input type="radio" id="register-other" value="Other"
        <c:if test="${userEdit.gender == 'Other'}"> checked </c:if> name="gender"> Other
      </label>
    </p>
  </div>
  <div class="field">
    <p class="control">
      <label class="checkbox">
        <input type="checkbox" name="userType" value="1" <c:if test="${userEdit.userType == '1'}"> checked </c:if>> Verified
      </label>
    </p>
  </div>

  <br>
  <input type="hidden" name="controller" value="updateUser">
  <div class="field">
    <p class="control is-expanded">
      <input id="updateSubmit" type="submit" class="button is-primary is-fullwidth" value="UPDATE">
    </p>
  </div>
</form>