var password = document.querySelector('#change-password');
var confirmPassword = document.querySelector('#change-confirm-password');

function isSamePassword(password, confirmPassword) {
  if (password.value != confirmPassword.value)
    return false;
  return true;
}

  function validatePassword() {
      var error = document.querySelector('#change-confirm-password-error');
      error.innerText = 'Password doesn\'t match';
      if (isSamePassword(password, confirmPassword)) {
          confirmPassword.classList.remove('is-danger');
          error.classList.add('is-hidden');
          document.getElementById('privateProfileSubmit').disabled=false;
          return true;
      } else {
          confirmPassword.classList.add('is-danger');
          error.classList.remove('is-hidden');
          document.getElementById('privateProfileSubmit').disabled=true;
      }
      return false;
  }
  password.addEventListener('keyup', validatePassword);
  confirmPassword.addEventListener('keyup', validatePassword);