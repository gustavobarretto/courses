const fs = require('fs');

// FORMA CONVENCIONAL

const emPromessa = () => new Promise(function (resolve, rejected) {
    fs.readFile('file.json', (err, content) => {
        resolve(JSON.parse(content))
        rejected(err)
    })
});

emPromessa()
.then(content => {
    console.log(content)
})

// FORMA COM PROMISSES
// Uma PROMISE é um objeto que representa a eventual conclusão ou falha de uma operação assíncrona.
// Como a maioria das pessoas consomem promises já criadas, este guia explicará o consumo de promises
// desenvolvidas antes de explicar como criá-las.
// Essencialmente, uma promise é um objeto retornado par ao qual você adiciona callbacks, em vez de 
// passar callbacks para uma função.
// https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Guide/Using_promises

const nomeVariavel = ms => new Promise(resolve => setTimeout(resolve, ms)); // ms = Parâmetro. resolve = 

nomeVariavel().then(() => console.log(4));
Promise.resolve().then(() => console.log(2)).then(() => console.log(3));
console.log(1); // 1, 2, 3, 4




