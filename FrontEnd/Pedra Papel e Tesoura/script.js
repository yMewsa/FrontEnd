// Declarações 
let user;
let comp;

// 

// Lógica pedra papel e tesoura
if (user == comp) {
  return "Empate! Tente novamente";
} else if (comp == 1 && user == 2) {
  return "Parabens, você ganhou! :)";
} else if (comp == 2 && user == 3) {
  return "Parabens, você ganhou! :)";
} else if (comp == 3 && user == 1) {
  return "Parabens, você ganhou! :)";
} else {
  return "Que pena! Você perdeu :(";
}
