function imcCalculo(peso, altura){
    return peso / (altura ** 2)
}
console.log(imcCalculo(80, 1.80).toFixed(2))

const imc = (peso, altura) => peso / (altura ** 2)

console.log(imc(80, 1.80).toFixed(1))