let nomeJogador = 'Gustavo', golsJogador = 0, precoEmDolares = 10000

function fazerGols() {
    return golsJogador += 1
}

fazerGols()
fazerGols()
fazerGols()

if (golsJogador > 0) {
    console.log('GOL!!!! Feito pelo jogador', nomeJogador, '!!')
}

console.log('O jogador fez', golsJogador, 'e ganhou', precoEmDolares, '!!!!')