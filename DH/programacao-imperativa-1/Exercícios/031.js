// 1. Crie uma função, que após 5 segundos, dobre o resultado do número passado 
// como parâmetro. Essa função deverá retornar uma Promise. Use o setTimeOut 
// como temporizador.

async function emDobro(num) {
    const calculo = await new Promise( (resolve) => {
        setTimeout(function() {
            resolve(num*2)
        }, 5000)
    })
    return calculo
};

// emDobro(10)

// 2. Crie uma função assíncrona que irá receber um parâmetro x. 
// Crie três variáveis: a, b e c dentro do corpo da função. 
// Cada uma dessas variáveis receberá um await da função do passo anterior. 
// Você deve passar como parâmetros dessa função os números 10, 20 e 30, 
// respectivamente.

async function funcaoAssincrona (a, b, c) {
    const calculoA = await new Promise ( (resolve) => {
        setTimeout(function() {
            resolve(a*2)
        }, 5000)
    })
    const calculoB = await new Promise ( (resolve) => {
        setTimeout(function() {
            resolve(b*2)
        }, 5000)
    })
    const calculoC = await new Promise ( (resolve) => {
        setTimeout(function() {
            resolve(c*2)
        }, 5000)
    })
    console.log(calculoA, calculoB, calculoC)
}

// funcaoAssincrona(10, 20, 30)

async function funcaoAssincrona2 (a, b, c) {
    const calculoA = await emDobro(a)
    const calculoB = await emDobro(b)
    const calculoC = await emDobro(c)
    const sum = await calculoA + calculoB + calculoC
    console.log(sum)
}

funcaoAssincrona2(10, 20, 30)

// 3. Retorne a soma de todos esses elementos, inclusive o 
// parâmetro da função assíncrona.
