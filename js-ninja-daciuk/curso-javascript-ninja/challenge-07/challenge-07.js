/*
Crie um array com 5 items (tipos variados).
*/
const array = [1, true, {nome: 'Gustavo'}, function soma(x, y) { return x + y; }, 'Barretto']

/*
Crie uma função chamada `addItem`, que irá adicionar itens no array criado.
A função deverá retornar o array atualizado.
*/
function addItem (arr, item) {
    arr.push(item);
    return arr;
}

/*
Adicione um novo array ao array criado no início do desafio, com ao menos 3
itens de tipos diferentes, mostrando o resultado no console.
*/
console.log(addItem(array, [false, function () {}, 'Novo array']))

/*
Mostre no console o segundo elemento desse último array, criado acima, com a
frase:
"O segundo elemento do segundo array é [ELEMENTO]."
*/
console.log('O segundo elemento deste array é ' + array[1])

/*
Mostre no console quantos itens tem o primeiro array criado, com a frase:
"O primeiro array tem [QUANTIDADE DE ITENS] itens."
*/
console.log('O primeiro array criado tem ' + array.length + ' itens.')

/*
Agora mostre no console quantos itens tem o segundo array criado, com a frase:
"O segundo array tem [QUANTIDADE DE ITENS] itens."
*/
console.log('O segundo array criado tem ' + array[5].length + ' itens.')

/*
Utilizando a estrutura de repetição `while`, mostre no console todos os números
pares entre 10 e 20, inclusive esses 2.
*/
console.log( 'Números pares entre 10 e 20:' );
let counter = 10;
while (counter <= 20) {
    counter % 2 === 0 ? console.log(counter) : '';
    counter++;
}

/*
Na mesma ideia do exercício acima: mostre agora os números ímpares.
*/
console.log( 'Números ímpares entre 10 e 20:' );
let counterOdd = 10
while (counterOdd <= 20) {
    counterOdd % 2 !== 0 ? console.log(counterOdd) : '';
    counterOdd++;
}

/*
Repita os mesmos exercícios feitos acima, mas agora usando o loop "for".
Só vamos mudar o range:
- No primeiro "for", mostre os números pares entre 100 e 120, inclusive eles;
- No segundo "for", mostre os números ímpares entre 111 e 125, inclusive eles.
*/
console.log( 'Números pares entre 100 e 120:' );
let counterHundred = 100;
while (counterHundred <= 120) {
    counterHundred % 2 === 0 ? console.log(counterHundred) : '';
    counterHundred++;
}

console.log( 'Números ímpares entre 111 e 125:' );
let counterHundredOdd = 111;
while (counterHundredOdd <= 125) {
    counterHundredOdd % 2 !== 0 ? console.log(counterHundredOdd) : '';
    counterHundredOdd++;
}