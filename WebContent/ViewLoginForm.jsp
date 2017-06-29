<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" session="false"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

  <script src="js/login/login.js"></script>
  
  <div id="home" class="home-background columns is-mobile">
	 <div class="login-form column is-three-quarters">
	 	<h1 class="title">Log into Filmit!</h1>
	 	<form id="loginForm" action="" method="post">
	 		<div class="field">
	 			<div class="control">			
	 				<input class="input" type="text" name="userOrEmail" id="login-username" 
	 				value="${userLogin.userOrEmail}" placeholder="Username" maxlength="30" required>
	 			</div>
	 			<c:if test="${userLogin.error[0] == 1}">
	 				<p class="help is-danger">The user doesn't exist on the DB! </p>
	 			</c:if>
	 		</div>
	 		<div class="field">
	 			<div class="control">
	 				<input class="input" type="password" name="password" id="login-password" placeholder="Password" maxlength="100" required>
	 			</div>
	 			<c:if test="${userLogin.error[1] == 1}">
	 				<p class="help is-danger">The password doesn't match the account's one.</p>
	 			</c:if>
	 		</div>
	 		<div class="field">
	 			<p class="control is-expanded">
	 				<input type="submit" class="button is-primary is-fullwidth" value="SIGN IN">
	 			</p>
	 		</div>
	 	</form>
	 </div>
  </div>
