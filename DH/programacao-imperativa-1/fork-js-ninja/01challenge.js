// Declarar uma variável chamada `myvar`, sem valor.
let myvar = ''
console.log(myvar)

// Após declarada, atribua o valor 10 à variável `myvar`.
myvar = 10
console.log(myvar)

// Declare uma nova variável chamada `soma`, e adicione uma instrução somando os valores 15 e 8.
let soma = (a, b) => a + b;
console.log(soma(15, 8))

// Atribua à variável `soma` todo o valor dela, somando 1, usando o operador de soma abreviado.
let somaAbreviado = (a, b) => {
    a++;
    return a + b;
}
console.log(somaAbreviado(15, 8))

// Atribua à variável `soma` todo o valor dela, multiplicando por 3, usando o operador de multiplicação abreviado.
let somaMultiplicado = (a, b) => {
    a++;
    c = a + b;
    return c*3;
}
console.log(somaMultiplicado(15, 8))

// Qual é o valor da variável `soma` até aqui?
console.log('O valor da variável até aqui seria ' + somaMultiplicado(15, 8) + '.')

// Declare uma variável chamada `souninja`, atribuindo à ela o valor booleano que representa `verdadeiro`.
let souNinja = true;

// Declare uma variável chamada `comida` que recebe um array com os valores 'arroz', 'feijão' e 'ovo'.
let comida = ['arroz', 'feijão', 'ovo']

// Digite a instrução que imprime o valor de 'feijao', que está na variável `comida`.
console.log(comida[1])

// Digite o código que verifica se a variável `soma' é igual a variável `myvar` (testando também o tipo).
if(myvar == somaMultiplicado(15, 8)) {
    console.log(souNinja)
} else {
    console.log(false)
}

// Digite o código que verifica se a variável `myvar` é menor ou igual à variável `soma`.
if(myvar <= somaMultiplicado(15,8)) {
    console.log(souNinja)
} else {
    console.log(false)
}

// Crie uma função chamada `divisao` que receba como parâmetro dois números, e retorne o resultado da divisão entre eles.
let divisao = (a, b) => a / b;
console.log(divisao(18, 3))

// Invoque a função criada acima, passando os parâmetros 10 e 2.
console.log(divisao(10, 2))