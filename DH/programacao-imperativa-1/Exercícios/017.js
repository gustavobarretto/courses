// EXERCÍCIO 'TERCEIRIZANDO FUNÇÕES' // callbacks

// Nesse caso, deve-se usar andar e parar como function principal para que seja executado.
const acaoCarro = callback => callback
const andar = () => console.log('O carro está andando')
const parar = () => console.log('O carro parou')
andar(acaoCarro)
parar(acaoCarro)

// Nesse caso, as arrow functions parar e andar podem ser executadas entre () para utilizar a arrow function acaoCarro2 como function principal.
const acaoCarro2 = callback => console.log(callback)
const andar2 = () => 'O carro está andando'
const parar2 = () => 'O carro parou'
acaoCarro2(andar2())
acaoCarro2(parar2())

// Caso não seja colocado os parênteses, o retorno da function acaoCarro2 será declarar do que se trata a constante andar2, informando que seria uma function.
acaoCarro2(andar2)
acaoCarro2(parar2)

// Para que acaoCarro3 execute a function parar3 e andar3 sem parênteses, é preciso que a callback já tenha os parênteses dentro da function.
const acaoCarro3 = callback => console.log(callback())
const andar3 = () => 'O carro está andando'
const parar3 = () => 'O carro parou'
acaoCarro3(andar3)
acaoCarro3(parar3)
 


