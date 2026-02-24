// Funções de String
const mensagem = "   JavaScript é Incrível!   ";

// 1. Tamanho (inclui espaços)
console.log(mensagem.length); // 28

// 2. Limpeza (Remove espaços do início e fim - Trim)
console.log(mensagem.trim()); // "JavaScript é Incrível!"

// 3. Maiúsculas e Minúsculas (Normalização)
const textoLimpo = mensagem.trim();
console.log(textoLimpo.toUpperCase()); // "JAVASCRIPT É INCRÍVEL!"
console.log(textoLimpo.toLowerCase()); // "javascript é incrível!"

// 4. Substituição (Replace)
console.log(textoLimpo.replace("Incrível", "Poderoso")); // "JavaScript é Poderoso!"

// 5. Cortar texto (Slice)
// slice(inicio, fim)
console.log(textoLimpo.slice(0, 10)); // "JavaScript"

// 6. Transformar em Array (Split)
const tags = "JS,Frontend,React";
console.log(tags.split(",")); // ["JS", "Frontend", "React"]

// 7. Verificar conteúdo (Includes)
console.log(textoLimpo.includes("Java")); // true
