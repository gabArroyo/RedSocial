<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<script src="js/register/register.js"></script>
	<script src="js/register/registerForm.js"></script>
	
	<div id="home" class="home-background columns is-mobile">
	<div class="register-form column is-three-quarters">
		<h1 class="title">Register into Filmit!</h1>
		<form id="registerForm" action="" method="post">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="username" id="register-username" value="${user.username}" placeholder="Username"
					maxlength="30" required>
				</div>
				<c:if test="${user.error[0] == 1}">
					<p class="help is-danger">The user already exists in the DB!</p>
				</c:if>
			</div>
			<div class="field">
				<p class="control">
					<input class="input" type="password" name="password" id="register-password"
					placeholder="Password" value="" maxlength="100" required>
				</p>
			</div>
			<div class="field">
				<p class="control">
					<input class="input" type="password" name="confirm_password" id="register-confirm-password" value=""
						placeholder="Confirm password" value="" maxlength="100" required>
				</p>
				<p id="register-confirm-password-error" class="help is-danger is-hidden"></p>
			</div>
			<div class="field">
				<div class="control">
					<input class="input" type="email"https://www.youtube.com/watch?v=2tN875A3Bj8 name="email" id="register-email" value="${user.email}" placeholder="Email" maxlength="100"
					required>
				</div>
				<c:if test="${user.error[1] == 1}">
					<p class="help is-danger">The email already exists in our DB!</p>
				</c:if>
			</div>
			<div class="field is-horizontal">
				<div class="field-body">
					<div class="field">
						<p class="control">
							<input class="input" type="number" name="dob_day" id="register-dob-day" placeholder="Day" min="1"
							max="31" maxlength="2" required>
						</p>
					</div>
					<div class="field">
						<div class="registrationMonth control">
							<span class="select">
								<select name="dob_month" id="register-dob-month" required>
									<option disabled selected>Month</option>
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
								</select>
							</span>
						</div>
					</div>
					<div class="field">
						<p class="control">
							<input class="input" type="number" id="register-dob-year" name="dob_year" placeholder="Year" min="1900" max="2000" maxlength="4" required>
						</p>
					</div>
				</div>
			</div>
			<hr>
			<div class="field">
				<p class="control">
					<input class="input" type="text" name="name" placeholder="Name">
				</p>
			</div>
			<div class="field">
				<p class="control">
					<input class="input" type="text" name="surname" placeholder="Surname">
				</p>
			</div>
			<div class="field">
				<p class="control">
					<label for="register-male" class="radio">
						<input type="radio" id="register-male" value="male" name="gender">Male
					</label>
					<label for="register-female" class="radio">
						<input type="radio" id="register-female" value="female" name="gender">Female
					</label>
					<label for="register-other" class="radio">
						<input type="radio" id="register-other" value="other" name="gender">Other
					</label>
				</p>
			</div>
			<br>
			<div class="field">
				<p class="control is-expanded">
					<input id="registrationSubmit" type="submit" class="button is-primary is-fullwidth" value="SIGN UP">
				</p>
			</div>
		</form>
	</div>
	</div>
