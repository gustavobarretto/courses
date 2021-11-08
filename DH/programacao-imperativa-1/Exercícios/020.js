// Arrow Functions (com parâmetros)

let fizzBuzz = (n1, n2) => {
    for(i = 0; i <= 100; i++) {
        if(i % n1 == 0 && i % n2 != 0) {
            console.log('Fizz!')
        } else if (i % n2 == 0 && i % n1 != 0) {
            console.log('Buzz!')
        } else if (i % n1 == 0 && i % n2 == 0) {
            console.log('FizzBuzz!')
        } else {
            console.log(i)
        } 
    } console.log('Fim da brincadeira!')
} 

fizzBuzz(2, 3)

// Na sugestão otimizada da questão, acrescenta-se a mensagem como parâmetro.
let fizzBuzz2 = (n1, mensagem1, n2, mensagem2) => {
    for(i = 0; i <= 100; i++) {
        if(i % n1 == 0 && i % n2 != 0) {
            console.log(mensagem1)
        } else if (i % n2 == 0 && i % n1 != 0) {
            console.log(mensagem2)
        } else if (i % n1 == 0 && i % n2 == 0) {
            console.log(mensagem1 + ' e ' + mensagem2)
        } else {
            console.log(i)
        } 
    } console.log('Fim da brincadeira!')
} 

fizzBuzz2(2, 'Múltiplo de 2!', 3, 'Múltiplo de 3!')