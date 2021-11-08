console.log(1);

// Assíncrona
const fs = require('fs');
fs.readFile('./letras.txt', (err, contents) => {
    console.log(2);
    console.log(String(contents));
    console.log('Erro:', err);
});
console.log(3)
console.log(4)