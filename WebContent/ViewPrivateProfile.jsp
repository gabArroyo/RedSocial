<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<script src="js/privateProfile/privateProfile.js"></script>
	<script src="js/privateProfile/privateProfileForm.js"></script>
	
	<div class="section privateProfile">
		<h1 class="title is-1">Private Profile</h1>
		<form id="privateProfileForm" action="" method="post">
			<h4 class="subtitle is-4">Change Username</h4>
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="name" id="change-username" value="${user.username}" placeholder="Username" maxlength="100" required>
				</div>
				<c:if test="${user.error[0] == 1}">
					<p class="help is-danger">The username already exists in our DB!</p>
				</c:if>
			</div>
			
			<div>
				<h4 class="subtitle is-4">Change Password</h4>
				<div class="field">
					<p class="control">
						<input class="input" type="password" name="password" id="change-password"
						placeholder="Password" value="" maxlength="100" required>
					</p>
				</div>
				<div class="field">
					<p class="control">
						<input class="input" type="password" name="confirm_password" id="change-confirm-password" value=""
						placeholder="Confirm password" value="" maxlength="100" required>
					</p>
					<p id="change-confirm-password-error" class="help is-danger is-hidden"></p>
				</div>
			</div>
			
			<h4 class="subtitle is-4">Change Email</h4>
			<div class="field">
				<div class="control">
					<input class="input" type="email" name="email" id="change-email" value="${user.email}" placeholder="Email" maxlength="100"
					required>
				</div>
				<c:if test="${user.error[1] == 1}">
					<p class="help is-danger">The email already exists in our DB!</p>
				</c:if>
			</div>

			<h4 class="subtitle is-4">Change Name</h4>
			<div class="field">
				<p class="control">
					<input class="input" type="text" name="name" placeholder="Name" value="${user.name}">
				</p>
			</div>

			<h4 class="subtitle is-4">Change Surname</h4>
			<div class="field">
				<p class="control">
					<input class="input" type="text" name="surname" placeholder="Surname" value="${user.surname}">
				</p>
			</div>

			<h4 class="subtitle is-4">Change Gender</h4>
			<div class="field">
				<p class="control">
					<label for="register-male" class="radio">
						<input type="radio" id="change-male" value="male" name="gender">Male
					</label>
					<label for="register-female" class="radio">
						<input type="radio" id="change-female" value="female" name="gender">Female
					</label>
					<label for="register-other" class="radio">
						<input type="radio" id="change-other" value="other" name="gender">Other
					</label>
				</p>
			</div>

			<h4 class="subtitle is-4">Change Birthday</h4>
			<div class="field is-horizontal">
				<div class="field-body">
					<div class="field">
						<p class="control">
							<input class="input" type="number" name="dob_day" id="change-dob-day" placeholder="Day" min="1"
							max="31" maxlength="2" required>
						</p>
					</div>
					<div class="field">
						<div class="registrationMonth control">
							<span class="select">
								<select name="dob_month" id="change-dob-month" required>
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
							<input class="input" type="number" id="change-dob-year" name="dob_year" placeholder="Year" min="1900" max="2000" maxlength="4" required>
						</p>
					</div>
				</div>
			</div>
			
			<h4 class="subtitle is-4">Change Avatar</h4>
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="avatar" id="change-avatar" value="${user.avatar}" placeholder="Avatar" maxlength="300" required>
				</div>
			</div>

			<h4 class="subtitle is-4">Change Background</h4>
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="background" id="change-background" value="${user.background}" placeholder="Background" maxlength="300" required>
				</div>
			</div>

			<h4 class="subtitle is-4">Change URL</h4>
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="url" id="change-url" value="${user.url}" placeholder="URL" maxlength="300" required>
				</div>
			</div>

			<div class="field">
				<p class="control is-expanded">
					<input id="privateProfileSubmit" type="submit" class="button is-primary is-fullwidth" value="Update Profile">
				</p>
			</div>
		</form>
	</div>