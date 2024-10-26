(() => {
  'use strict'

  const forms = document.querySelectorAll('.needs-validation');

  Array.from(forms).forEach(form => {
    const passwordInput = form.querySelector('input[name="senha-registro"]');
    const confirmPasswordInput = form.querySelector('input[name="senha-confirmar-registro"]');

    form.addEventListener('submit', event => {
      confirmPasswordInput.setCustomValidity("");

      // Checa se as senhas correspondem.
      if (!form.checkValidity() || passwordInput.value !== confirmPasswordInput.value) {
        event.preventDefault();
        event.stopPropagation();

        // Adiciona uma mensagem de erro e uma borda vermelha caso as senhas não correspondam
        if (passwordInput.value !== confirmPasswordInput.value) {
          confirmPasswordInput.setCustomValidity("As senhas não correspondem.");
          passwordInput.classList.add('border-red');
          confirmPasswordInput.classList.add('border-red');
        } else {
          passwordInput.classList.remove('border-red');
          confirmPasswordInput.classList.remove('border-red');
        }
      }

      form.classList.add('was-validated');
    }, false);

    // Remove a mensagem de erro e a borda vermelha ao corrigir as senhas
    confirmPasswordInput.addEventListener('input', () => {
      if (confirmPasswordInput.value === passwordInput.value) {
        confirmPasswordInput.setCustomValidity("");
        passwordInput.classList.remove('border-danger');
        confirmPasswordInput.classList.remove('border-danger');
      } else {
        confirmPasswordInput.setCustomValidity("As senhas não correspondem.");
        passwordInput.classList.add('border-danger');
        confirmPasswordInput.classList.add('border-danger');
      }
    });
  });
})();
