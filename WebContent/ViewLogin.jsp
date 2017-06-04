<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" session="false" import="models.BeanLogin" session="false"%>

  <script src="js/login/loginFormEvaluator.js"></script>
  <script src="js/login/login.js"></script>

<div class="login-form column is-three-quarters">
  <h1 class="title">Log into Filmit!</h1>
  <form id="loginForm" action="" method="post">
    <div class="field">
      <div class="control">
        <input class="input" type="text" name="userOrEmail" id="login-username" placeholder="Username" maxlength="30" required>
          <c:if test="${login.error[0] == 1}">
               <p id="login-username-error" class="help is-danger">El usuario indicado no existe en la base de datos! </p>
          </c:if>

        <p id="login-username-error" class="help is-danger is-hidden"></p>
      </div>
    </div>
    <div class="field">
      <div class="control">
        <input class="input" type="password" name="password" id="login-password" placeholder="Password"
        maxlength="100" required>
        <c:if test="${login.error[1] == 1}">
          <p id="login-password-error" class="help is-danger is-hidden"></p>
        </c:if>
      </div>
    </div>
    <div class="field">
      <p class="control is-expanded">
        <input type="submit" class="button is-primary is-fullwidth" value="SIGN IN">
      </p>
    </div>
  </form>
</div>
