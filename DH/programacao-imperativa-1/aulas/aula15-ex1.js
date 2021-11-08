// fs = file system
const fs = require('fs');

// LEIA O ARQUIVO DE FORMA SÍNCRONA
const arq = fs.readFileSync('./letras.txt', 'utf-8')

console.log(arq)

console.log(1)
console.log(2)
console.log(3)