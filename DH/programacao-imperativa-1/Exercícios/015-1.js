// exercícios extras enviados. São 10 exercícios. 15-1 a 15-10.
// 1o exercício: Criar uma função para verificar se um número é par ou ímpar. Um número é par quando na divisão por 2 o resto é 0.

function parImpar(n) {
    if (n % 2 == 0) {
        console.log('Este número é par.')
    } else {
        console.log('Este número é ímpar.')
    }
}
parImpar(38)