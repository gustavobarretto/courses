let f1 = function(x) {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            resolve(2 * x)
        }, 5000)
    })
}

async function executar(num) {
    let resultado = await f1(num)
    console.log(resultado)
}

executar(10)

let f2

async function executar(x) {
    let resultado 
}