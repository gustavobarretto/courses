// SPREAD OPERATOR
// Exercício "VER NÚMEROS"
// 1:
// Crie um array numerosPrimos e atribua alguns valores a ele que correspondam ao seu nome. 
// Além disso, crie outro array, desta vez chamado numeros, que deve conter os valores do 
// array numerosPrimos adicionados através do spread, juntos com outros números.

let numerosPrimos = [2, 3, 5, 7, 11, 13, 17, 19, 23]
let numeros = [1, 3, 9, 15, 16, 18, 21]

let numerosTotais = [...numerosPrimos, ...numeros]
console.log(numerosTotais)

// 2:
// Crie uma função maiorNumero() que receba N parâmetros, e retorne o menor número entre eles,
// utilizando a função Math.min(). Uma observação importante é que a função Math.min() NÃO deve
// receber um array como parâmetro, sendo portanto, necessário expandir os valores.

function maiorNumero(n) {
    n = [35, 6, 8, 23, 2, 1, 11, 28, 21, 12, 15]
    console.log(Math.min(...n))
}

maiorNumero()
