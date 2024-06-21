const btnCalcular = document.querySelector("#calcular");

btnCalcular.addEventListener("click", () => {
  const alunos = document.querySelectorAll(".aluno");

  alunos.forEach((aluno) => {
    const nota1 = Number(aluno.querySelector(".nota1").textContent);
    const nota2 = Number(aluno.querySelector(".nota2").textContent);
    const nota3 = Number(aluno.querySelector(".nota3").textContent);
    const nota4 = Number(aluno.querySelector(".nota4").textContent);

    const media = (nota1 + nota2 + nota3 + nota4) / 4;

    aluno.querySelector(".media").textContent = media.toFixed(1);

    if (media < 6) {
      console.log("dasdasdaddasdasadas")
      aluno.classList.add('bg-danger', 'text-light');
    }
  });
});
