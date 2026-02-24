const prompt = require("prompt-sync")();

let continuar = true;
let nome = "Nome_Padrão";
let lista = [];

do {
  console.log("\n===========================");
  console.log("| 1. Cadastrar Nome       |");
  console.log("| 2. Cadastrar Notas      |");
  console.log("| 3. Calcular Média       |");
  console.log("| 4. Sair                 |");
  console.log("===========================");

  let op = prompt("Escolha: ");

  switch (op) {
    case "1":
      nome = prompt("Insira o nome do aluno: ");
      console.log(`Nome ${nome} cadastrado com sucesso!`);
      break;

    case "2":
      let numNotas = parseInt(prompt("Insira a quantidade de notas: "));
      lista = []; // Zera a lista para o novo aluno
      for (let i = 0; i < numNotas; i++) {
        let nota = parseFloat(
          prompt(`Informe a nota n°${i + 1} do aluno ${nome}: `),
        );
        lista.push(nota);
      }
      break;

    case "3":
      if (lista.length === 0) {
        console.log("Erro: Nenhuma nota cadastrada!");
      } else {
        let soma = lista.reduce(
          (acumulador, valorAtual) => acumulador + valorAtual,
          0,
        );
        let media = soma / lista.length;
        console.log(`A média do aluno ${nome} é: ${media.toFixed(2)}`);
      }
      break;

    case "4":
      continuar = false;
      console.log("[Saindo...]");
      break;

    default:
      console.log("Operação inválida!");
      break;
  }
} while (continuar);
