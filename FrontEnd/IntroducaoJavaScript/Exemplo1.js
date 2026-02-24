// Introdução JavaScript

// Tipos de Dados (Escopo, Tipagem)

// Tipo String
var nome = "Larissa"; //Declaração da Variavel Nome
nome = "Rian"; //Redefinindo o valor
var nome = "Ismael"; //Redeclarando o valor

// Tipo Number
let idade = 25; //Declarando a Idade
idade = 30; //Redefinindo o valor
//let idade = 40; //Não pode redeclarar LET

// Tipo Number
const PI = 3.14;
// PI = 3.33; // Erro de valor
// const PI = 4.56; // Não pode redeclarar

//  Tipo Boolean
var aprovado = true;

//  Tipo Undefined
var media;

// Tipo Null - Vazio
var info = null;

// Print
console.log("Nome: " +nome);
console.log("Idade: " +idade);
console.log("PI: " +PI);
console.log("Aprovado: " +aprovado);
console.log("Media: " +media);
console.log("Informação: " +info);

var nota1 = 5;
var nota2 = 8;

console.log("Aprovação: "+nota1>7 && nota2>7); //False
console.log("Aprovação: "+nota1>7 || nota2>7) //True
console.log("Negação: "+!true); //False
