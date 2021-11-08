// não é preciso criar as variáveis para realizar o teste da função ao final, bastando preenchê-los no console.log, ao chamar a função.

function podeSubir(altura, acompanhada) {
    if (altura > 1.40 && altura  < 2.00) {
        console.log('Você pode subir!')
    } else if (altura < 1.40 && acompanhada == true ) {
        console.log('Você pode subir, pois, apesar de pequena, está acompanhada.') // Aqui faz a função de acesso autorizado.
    } else if (altura < 1.20) {
        console.log('Você não pode subir, pois não tem a altura mínima exigida.')
    } else {
        console.log('Você não pode subir porque não está acompanhada ou não tem a altura indicada.')
    }
} console.log(podeSubir(2.10, true))