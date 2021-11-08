// exercício LISTA DE COMPRAS

let listaDeCompras = ['Macarrão', 'Maionese', 'Ketchup', 'Salsicha', 'Pão hot-dog', 'Mostarda', 'Batata palha', 'Molho de tomate', 'Tomate']
console.log(listaDeCompras)
console.log('O método join une todos os elementos do array. Veja abaixo:')
console.log(listaDeCompras.join())
console.log('O método pop elimina o último elemento do array, no caso, o tomate. Veja abaixo:')
console.log(listaDeCompras.pop())
console.log(listaDeCompras)
console.log('O método push adiciona um na última elemento do array, conforme abaixo. Veja a adição da cebola:')
console.log(listaDeCompras.push('Cebola'))
console.log(listaDeCompras)
console.log('O método shift elimina o primeiro elemento do array, no caso, o macarrão. Veja abaixo:')
console.log(listaDeCompras.shift())
console.log(listaDeCompras)
console.log('O método unshift adiciona um ou mais elementos no início do array. Adicionaremos o milho e o queijo ralado, conforme abaixo:')
console.log(listaDeCompras.unshift('Milho', 'Queijo Ralado'))
console.log(listaDeCompras)

console.log(`Para servir um cachorro quente, primeiro você abre o ${listaDeCompras[5]+listaDeCompras[4]} e coloca a ${listaDeCompras[4]}`)
