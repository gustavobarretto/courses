// Crie uma função que considere o número da conta do cliente, saldo, 
// débito e crédito. Calcule e imprima o saldo atual (saldo atual = saldo
// - débito + crédito). Se saldo atual for maior ou igual a zero,
// imprima a mensagem 'Saldo Positivo', senão imprimir a a mensagem
// 'Saldo Negativo'.

function contaCorrente(saldo, débito, crédito) {
    let saldoAtual = saldo - débito + crédito
    if (saldoAtual < 0) {
        console.log('Seu saldo atual é de R$', saldoAtual.toFixed(2),'e você está com saldo negativo.')
    } else {
        console.log('Seu saldo atual é de R$', saldoAtual.toFixed(2), 'e você está com saldo positivo.')
    }
}
contaCorrente(1000, 248.18, 0)