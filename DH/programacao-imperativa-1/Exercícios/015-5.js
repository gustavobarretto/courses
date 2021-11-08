// As maçãs custam R$ 1,30 cada se forem comparadas menos de uma
// dúzia R$ 1,00 se forem compradas pelo menos 12. Crie uma função
// que através do parâmetro "quantidade" calcule e imprima o custo
// total da compra.

function precoMacas(quantidade) {
    if (quantidade >= 12) {
        let valorTotal = quantidade * 1
        console.log('O valor total da compra das maçãs será R$', valorTotal.toFixed(2), '.')
    } else {
        let valorTotal = quantidade * 1.3
        console.log('O valor total da compra das maçãs será R$', valorTotal.toFixed(2), '.')
    }
}
precoMacas(10)