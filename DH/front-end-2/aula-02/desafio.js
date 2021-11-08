// Faça o desafio para pedra, papel e tesoura.

const userPlay = prompt('Digite 1 para pedra, 2 para papel ou 3 para tesoura')
const computerPlay = Math.floor((Math.random() * 3) + 1);


const plays = () => {
    let play = userPlay - computerPlay;
        if (play == 1 || play == -2) {
            console.log('Você ganhou!')
        } else if (play == 0) {
            console.log('Empate!')
        } else {
            console.log('Você perdeu!')
        }
}

