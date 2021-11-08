// Com base em dois valores, imprima uma das três mensagens a seguir:
// 'Números iguais', caso os números sejam iguais;
// 'Primeiro é maior', caso o primeiro seja maior que o segundo;
// 'Segundo maior', caso o segundo seja maior que o primeiro.

function comparativoNumeros(primeiroNumero, segundoNumero) {
    if (primeiroNumero > segundoNumero) {
        console.log('O número', primeiroNumero, 'é o primeiro número e é maior que o segundo, que é', segundoNumero,'.')
    } else if (primeiroNumero < segundoNumero) {
        console.log('O número', segundoNumero, 'é o segundo número e é maior que o primeiro, que é', primeiroNumero, '.')
    } else {
        console.log('Ou os números são iguais ou você não informou números.')
    }
} comparativoNumeros(11, 11)