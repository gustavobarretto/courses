// Fazer uma calculadora com as funções somar, dividir, subtrair e multiplicar.

import dividir from "./modules/dividir.js"
import multiplicar from "./modules/multiplicar.js"
import subtrair from "./modules/subtrair.js"
import somar from "./modules/somar.js"


let init = confirm('Bem vindo à calculadora da DH. Gostaria de realizar algum cálculo?')

let result = 0
let num = 0

while (init) {
    alert('O valor da sua calculadora é ' + result + '.' )
    let operacao = prompt(`A calculadora informa o valor ${result}. Digite (1) somar, (2) dividir, (3) subtrair, (4) multiplicar ou (5) se deseja sair. Digite algumas das opções.`)
    if (operacao == 1) {
        num = parseInt(prompt('Digite o valor: '))
        somar(num)

    } else if (operacao == 2) {
        num = parseInt(prompt('Digite o valor: '))
        dividir(num)

    } else if (operacao == 3) {
        num = parseInt(prompt('Digite o valor: '))
        subtrair(num)

    } else if (operacao == 4) {
        num = parseInt(prompt('Digite o valor: '))
        multiplicar(num)

    } else if (operacao == 5) {
        break

    }
    let init = confirm('Gostaria de realizar mais algum cálculo?')
}
