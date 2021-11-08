// Criar uma função que verifique se um valor é positivo, negativo ou zero.

function descobrirValor(n) {
    if (n > 0) {
        console.log('O valor', n, 'é positivo.')
    } else if (n < 0) {
        console.log('O valor', n, 'é negativo.')
    } else {
        console.log('Ou o valor é zero ou não é um número.')
    }
} descobrirValor('-25')