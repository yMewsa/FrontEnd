//1 - Atividade Verificação de Idade

var idade = 51;

if (idade <= 17){
    console.log("Você é menor de idade")
}else if (idade >=18 && idade <= 50){
    console.log("Você é adulto")
}
else{
    console.log("Você é idoso")
}

//2 - Atividade Tabuada 
for (var i = 1; i <= 20; i++) {
    var aux = 5 * i
    console.log(aux)
}

//3 - Atividade Verificação de Numeros Pães
for(let i=1; i<=20; i++){
    // Imprimir numeros pares
    let resto = (i%2); 
    if (resto == 0){
        console.log(i);
    }
}