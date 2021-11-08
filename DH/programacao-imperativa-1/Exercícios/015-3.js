// Com base no atual e no ano de nascimento de uma pessoa,
// imprimir uma mensagem que diga se ela poderá ou não votar na
// próxima eleição (não é necessário considerar o mês em que a pessoa
// nasceu).

function votacao(anoNascimento) {
    let idade = 2021 - anoNascimento
    if (idade >= 16) {
        console.log('Você pode votar, pois tem', idade, 'anos.')
    } else {
        console.log('Você ainda não pode votar, pois tem', idade, 'anos.')
    }
} votacao(2007)