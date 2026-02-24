//  Calculadora Simples em JavaScript
// Usar o prompt
var prompt = require("prompt-sync")(); //Import da Biblioteca

// Funções de Cálculo

// Adição
function soma(a, b) {
  return a + b;
}

// Subtração
function sub(a, b) {
  return a - b;
}

// Multiplicação
function multip(a, b) {
  return a * b;
}

// Divisão
function div(a, b) {
  return a / b;
}

// Menu
function menu() {
  let operacao;
  let numero1;
  let numero2;
  let resultado;
  console.log("===Calculadora Simples===");
  console.log("| 1. Soma                ");
  console.log("| 2. Subtração           ");
  console.log("| 3. Multiplicação       ");
  console.log("| 4. Divisão             ");
  console.log("=========================");
  console.log("===Escolha a operação====");
  operacao = prompt();
  numero1 = Number(prompt("Digite o primeiro número: "));
  numero2 = Number(prompt("Digite o segundo número:"));

  // Switch case
  switch (operacao) {
    case "1":
      resultado = soma(numero1, numero2);
      console.log("Resultado: " + resultado);
      break;
    case "2":
      resultado = sub(numero1, numero2);
      console.log("Resultado: " + resultado);
      break;
    case "3":
      resultado = multip(numero1, numero2);
      console.log("Resultado: " + resultado);
      break;

    case "4":
      if (numero2 == 0) {
        console.log("Não dividiras por 0");
        resultado = null;
      } else {
        resultado = div(numero1, numero2)
        console.log("Resultado: " + resultado);
    }
    break;

    default:
        console.log("Operação Invalida")
        resultado = null;
      break;
  } //Fim do Switch
} 

var continuar = true;
while (continuar){
    menu();
    let escolha = prompt("||1. Continuar || 2. Sair | ")
    if (escolha == 2){
        continuar = false;
        console.log("Saindo...")
    }
}