// Estrutura de Dados

// Condicionais (If Else // Switch Case)

// IF - ELSE
var precoProduto = 150;
// Se o preço do produto >= 100 - desconto de 10%
if (precoProduto >= 100){
    console.log("Valor a pagar: "+(precoProduto*0.9));
}else{
    console.log("Valor a pagar: "+(precoProduto));
}

// Condicional Intermediaria (else if)
// preco > 200 15% desconto // preco > 100 10% desconto

if (precoProduto >= 200){
    console.log("Total a pagar: "+(precoProduto*0.85))   
} else if (precoProduto >= 100) {
    console.log("Valor a pagar: "+(precoProduto*0.9))
} else {
    console.log("Valor a pagar: "+precoProduto)
}

dia = 5
switch (dia) {
    case 1:
        console.log("Hoje é Domingo yepii")
        break;
    case 2:
        console.log("Hoje é segunda AAAAA")
        break;
    case 3:
        console.log("Hoje é terça buu")
        break;
    case 4:
        console.log("Hoje é quarta nhe")
        break;
    case 5:
        console.log("Hoje é quinta hehe")
        break;
    case 6:
        console.log("Hoje é sexta uhuuu")
        break;
    case 7:
        console.log("Hoje é sabado")
        break;
    default:
        console.log("Hoje é um dia que eu n sei")
        break;
}

// Estrutura de Repetição (For While)

// For (Por determinadas vezes)
for(let i=0; i<=100; i++){
    console.log(i);
}

// While (Incontáveis)
var continuar = true;
var numEscolhido = 3;
var contador = 0;
while(continuar){
    contador++;
    let numeroSorteado = Math.round(Math.random()*10);
    if(numeroSorteado == numEscolhido){
        continuar = false;
        console.log("Acertouu yepi")
        console.log("Tentativas = "+contador)
    }
}

// Funções (Function)
// Ações especificas - podem ser chamadas a qualquer momento dentro do código

function ola (nome){ //Função com retorno
    return "Olá, "+nome;
}

function hello (nome){ //Function Void
    console.log("Helloooo, "+nome)
}

// Chamando as funções
console.log(ola("Diogo"));

hello("Diogo")