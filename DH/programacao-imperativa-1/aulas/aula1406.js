let calculoIMC = (altura, peso) => (peso / (altura*altura)).toFixed(2)

let calculoIMC2 = (altura, peso) => {
    let valor = peso / (altura*altura)
    if (valor < 18.5) {
        console.log('Você está abaixo do peso. Seu IMC é ' + valor.toFixed(2) + '.')
    } else if (valor >= 18.5 && valor <= 25) {
        console.log('Você está no peso ideal. Seu IMC é ' + valor.toFixed(2) + '.')
    } else if (valor > 25 && valor <= 40) {
        console.log('Você está com sobrepeso. Seu IMC é ' + valor.toFixed(2) + '.')
    } else if (valor > 40) {
        console.log('Você está com obsedidade. Seu IMC é ' + valor.toFixed(2) + '.')
    }
}

console.log(calculoIMC(1.50, 70))

calculoIMC2(1.50, 70)
