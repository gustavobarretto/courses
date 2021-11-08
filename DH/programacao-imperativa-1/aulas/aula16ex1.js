// promise = função assíncrona
// promise = criamos
// nome.then...

// 1a PROMISE
function f1(x) {
    return new Promise (resolve => {
        setTimeout(_=> resolve(77 + x), 1000)
    })
}

// 2a PROMISE
function f2(x) {
    return new Promise (resolve => {
        setTimeout(_=> resolve(22 + x), 1000)
    })
}

// 3a PROMISE
function f3(x) {
    return new Promise (resolve => {
        setTimeout(_=> resolve(14 * x), 1000)
    })
}


// Utilizando as PROMISES
console.time('Tempo: ')

f1(10).then(x => {
    console.log('Olá');
    return f2(x)
}).then (x => {
    console.log('Javascript')
    return f3(x)
}).then (result => {
    console.log(result);
    console.timeEnd('Tempo: ')
})

// Utilizando a simplificação da lógica.
// async - assíncrona
// await - espera quando está dentro de um async

async function executar() {
    let numero = await f1(10)
    console.log(numero);
    console.log('Olá');
    numero = await f2(numero);
    console.log('Javascript');
    var result = await f3(numero);
    console.log('Resultado: ', result);
}

// Chamando a função EXECUTAR()
executar();