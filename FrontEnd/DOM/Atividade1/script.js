// Lógica de Funcionamento da Lista de Tarefas

// Criar um ouvinte para a tarefa
let btnEnviar = document.getElementById("btnEnviar"); //Obj para controlar o botão
let tarefa = document.getElementById("tarefa");

btnEnviar.addEventListener(
    "click", criarTarefa
);

// Criar função para criar tarefa
function criarTarefa(){
    let texto = tarefa.value.trim();
    // Verificar se tarefa não esta vazia
    if(texto==""){
        return;
    }
    // Se não estiver vazia
    let li = document.createElement("li"); //Criação de um list item
    li.innerHTML = texto+'<button onclick="removerTarefa(this)" class="btnRemove">Remover</button>'
    // Adicionar li -> ul
    let ul = document.getElementById("lista");
    ul.appendChild(li); //Adicionando li a ul via hierarquia
    // Limpando o campo do input
    tarefa.value = "";
}

function removerTarefa(botao){
    botao.parentElement.remove(); //Remove a tarefa da lista
}

// Estilizando pelo DOM
document.body.style.backgroundColor = "#f1eded";
document.body.style.textAlign = "center";
document.body.style.fontFamily = "Arial";

let container = document.querySelector(".container");
container.style.width = "50%";
container.style.backgroundColor = "pink";
container.style.margin = "auto";
container.style.borderRadius = "15px";

tarefa.style.width = "50%";
tarefa.style.padding = "10px";
tarefa.style.borderRadius = "5px";

btnEnviar.style.padding = "6px 10px";
btnEnviar.style.border = "nome";
btnEnviar.style.background = "lilac";
// btnEnviar.style.color = "white";
btnEnviar.style.borderRadius = "5px";
btnEnviar.style.cursor = "pointer";

let lista = document.getElementById("lista");
lista.style.listStyle = "none";

