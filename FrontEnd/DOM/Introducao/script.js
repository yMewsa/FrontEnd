// DOM -> Document Object Model
// Script de Manipulação DOM

// getElementById -> Variavel Simples - Id é sempre única
let titulo = document.getElementById("titulo"); //Busca no html o elemento com a Id correspondente 
console.log(titulo); //Mostra a informção de Id
titulo.innerText = "Outro Titulo para o Site"; //Modifica o conteúdo da ID

// getElementByTagName -> Vetor(Array) de elementos
let paragrafo = document.getElementsByTagName("p"); //Html -> p
paragrafo[0].innerText="Exemplo de Parágrafo Modificado por DOM"; //Modificar elemento
paragrafo[1].style.color = "red"; //Modificar o Style do elemento

// getElementByClassName -> Vetor de elementos
let descricao = document.getElementsByClassName("descricao");
// Modificar elementos do array
for(let i=0; i<descricao.length;i++){
    descricao[i].style.color = "clue"
}

// querySelector -> Variavel Simples = seleciona sempre o primeiro elemento com o seletor
let p = document.querySelector("p");
// Modificar a fonte
p.style.fontWeight = "bold";

// querySelectorAll -> Vetor de elementos -> seleciona todos os elementos
let descricaoAll = document.querySelectorAll(".descricao");
descricaoAll.forEach(e => e.style.fontWeight = "bold");

// Eventos Listener 
// Chamar pelo nome da função
function MudarCorFundo(){
    let body = document.querySelector("body");
    body.style.backgroundColor = "pink";
}

// Chamar diretamente no script o ouvinte 
document.getElementById("btnColor").addEventListener("click",OutraCor)

function OutraCor(){
    let body = document.querySelector("body");
    body.style.backgroundColor = "cyan";
}