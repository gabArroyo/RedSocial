var password = document.querySelector('#register-password');
var confirmPassword = document.querySelector('#register-confirm-password');

function isSamePassword(password, confirmPassword) {
  if (password.value != confirmPassword.value)
    return false;
  return true;
}

  function validatePassword() {
      var error = document.querySelector('#register-confirm-password-error');
      error.innerText = 'Password doesn\'t match';
      if (isSamePassword(password, confirmPassword)) {
          confirmPassword.classList.remove('is-danger');
          error.classList.add('is-hidden');
          document.getElementById('registrationSubmit').disabled=false;
          return true;
      } else {
          confirmPassword.classList.add('is-danger');
          error.classList.remove('is-hidden');
          document.getElementById('registrationSubmit').disabled=true;
      }
      return false;
  }
  password.addEventListener('keyup', validatePassword);
  confirmPassword.addEventListener('keyup', validatePassword);