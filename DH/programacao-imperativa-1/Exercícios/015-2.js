// Considere duas notas referentes a avaliações efetuadas por um aluno.
// Calcule a média a média e imprima uma mensagem que diga se o aluno foi ou não aprovado (considerar média igual ou maior que 6 o aluno é aprovado)
// Imprima também a média calculada.

function mediaAluno(n1, n2) {
    if ((n1 + n2) / 2 >= 6) {
        let media = (n1 + n2) / 2 
        console.log('Parabéns, você foi aprovado com a média', media,'!')
    } else {
        console.log('Infelizmente, você foi reprovado.')
    }
} mediaAluno(7.6, 5.5)