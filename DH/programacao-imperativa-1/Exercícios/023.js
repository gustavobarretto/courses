// 1. Crie um array de números pares, e utilizando a função .map() nesse array, 
// crie um novo array com apenas números ímpares.

let pares = [2, 4, 6, 8, 10]
let impares = pares.map(n =>  n + 1)
console.log(impares)


// 2. Crie um array de nomes, que possua dois índices com o nome Maria. 
// Utilize o .filter() para obter apenas esses dois índices com o nome Maria.
let nomes = ['Eduardo', 'Marcelo', 'Maria', 'Gustavo', 'De Araújo', 'Nader', 'Maria', 'Barretto']
let marias = nomes.filter(pesquisa =>  pesquisa == 'Maria')
console.log(marias)


// 3. Crie um array de números e utilize a função .reduce() para devolver uma string com os números formatados. 
// Exemplo [1,5,9,3,7] => “1 – 5 – 9 – 3 – 7”
let numerosF = [5, 4, 3, 2, 1]
// É possível utilizar o .reduce para a realização de um fatorial SE 
// forem listados os números a serem multiplicados.
let fatorial = numerosF.reduce((resultado, multiplicacao) => {
    return resultado * multiplicacao
}); console.log('O fatorial de 5 é ' + fatorial + '.')

let stringFormatados = [5, 4, 3, 2, 1]
let formatacao = stringFormatados.reduce((acumulador, numeros) => {
    return acumulador + ' - ' + numeros
}); console.log(formatacao)

// 4. Crie um array de animais, após isso passe por cada índice utilizando o 
// .forEach() e imprima a frase “O animal é NOME_DO_ANIMAL”.
let randomAnimals = ['Macaco', 'Javali', 'Peixe', 'Foca', 'Urso Polar', 'Papagio', 'Tucano']
randomAnimals.forEach(animal => console.log('O animal é ' + animal + '!'))




