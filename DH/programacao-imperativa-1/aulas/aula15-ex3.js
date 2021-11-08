const fs = require('fs');
const { prependOnceListener } = require('process');
console.log(1);

// Armazenando uma cópia do objeto Promise, isto é, instanciando Promise. 
// É um instrutor e por isso que tem letras maiúsculas.
const lerArquivo = arq => new Promise((resolve, reject) => {
    fs.readFile(arq, (err, content) => {
        if(err != null) {
            reject(err);
        } else {
            resolve(content)
        }
    })
})
console.log(2)

// Utilizando a Promise
lerArquivo('./letras.txt').then(content => {
    console.log(String(content))
}).catch(err => {
    console.log(err)
})

// Possíveis estados da Promise: prependOnceListener, realizado com sucesso e realizado com fracasso.
// A utilização da Promise se dá em eventos que não se tem a resposta no presente, somente no futuro.