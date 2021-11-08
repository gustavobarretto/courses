// Prática de Arrow Functions com Recursividade
// Criar uma função que calcula o fatorial usando loop (for)

let valor = 1
let fatorial = n => {
    if(n == 0) {
        console.log('O fatorial de ' + n + ' é ' + valor + '.')
    }
    for (i = n; i >= 0; i--) {
        if(i < n) {
            valor *= i
            if(i == 1) {
                return console.log('O fatorial de ' + n + ' é ' + valor + '.')
            }
        } else {
            valor *= i
        } 
    } 
}


// Recriar esta mesma função usando recursividade (sem o uso de for)
let resultado = 1
let fatorial2 = n => {
    resultado = resultado * n
    n--
    if(n == 1) {
        return console.log(resultado)
    } else {
        fatorial2(n)
    }

}; fatorial2(10)
