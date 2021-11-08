// Escreva uma função que considere o número de litros vendidos e o tipo de combustível
// (codificado da seuginte forma: A-álcool, G-gasolina), calcule e imprima o valor a ser
// pago pelo cliente sabendo-se que o preço do litro da gasolina é R$ 5,20 e o preço do
// litro do álcool é R$ 4,20.

function litrosVendidos(litros, combustivel) {
    if (combustivel == 'G') {
        let totalPreco = litros * 5.20
        console.log('O valor total pago pela gasolina é de R$', totalPreco.toFixed(2), '.')
    } else if (combustivel == 'A') {
        let totalPreco = litros * 4.20
        console.log('O valor total pago pelo ácool é de R$', totalPreco.toFixed(2), '.')
    } else {
        console.log('Erro no cálculo. Ou não optou corretamento por A-Álcool ou G-Gasolina.')
    }
    
} litrosVendidos(60, 'a')