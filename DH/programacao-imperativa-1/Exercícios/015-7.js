// Faça um programa que considere: quantidade atual em estoque,
// quantidade máxima em estoque e quantidade mínima em estoque de
// um produto. Calcule e imprima a quantidade média (quantidade
// média = (quantidade máxima + quantidade mínima) / 2). Se a
// quantidade em estoque for maior ou igual a quantidade média,
// imprima a mensagem 'Não efetuar compra', senão imprima a mensagem
// 'Efetuar compra'.

function quantidadeMediaEstoque(quantidadeAtualEstoque, quantidadeMaxima, quantidadeMinima) {
    let quantidadeMediaEstoque = (quantidadeMinima + quantidadeMaxima) / 2
    if (quantidadeMediaEstoque <= quantidadeAtualEstoque) {
        console.log('Efetuar compra, considerando que a quantidade média é', quantidadeMediaEstoque, 'e a quantidade atual é', quantidadeAtualEstoque, '.')
    } else {
        console.log('Não efetuar compra, considerando que a quantidade média é', quantidadeMediaEstoque, 'e a quantidade atual é', quantidadeAtualEstoque, '.')
    }
} quantidadeMediaEstoque(26558, 13547, 48512)