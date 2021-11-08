let nomeJogador = 'Gustavo', golsJogador = 0, precoEmDolares = 10000

function fazerGols() {
    return golsJogador += 1
}

fazerGols()
fazerGols()
fazerGols()

function hatTrick() {
    return precoEmDolares * 1.1
}

if (golsJogador > 0 && golsJogador != 3) {
    console.log('GOL!!!! Feito pelo jogador', nomeJogador, '!!')
} else if (golsJogador == 3) {
    hatTrick()
    console.log('O jogador fez um hat-trick!! Ele ganhou', hatTrick(), '!!!')
}

console.log('O jogador fez', golsJogador, 'gols e ganhou', precoEmDolares, '!!!!')