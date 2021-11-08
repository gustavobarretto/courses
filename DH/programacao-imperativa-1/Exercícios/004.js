let nome = 'Ana Paula', idade = 26, peso = 55, altura = 1.62, plano = true, imc = peso / (altura * altura)

console.log('Nome:', nome)
console.log('Idade:', idade)
console.log('Peso:', peso)
console.log('Altura:', altura)
console.log('Plano:', plano)
console.log('IMC:', imc.toFixed(2))

if ( imc < 18.5 ) {
    console.log(nome, 'está abaixo da magreza.')
} else if ( imc >= 18.5 && imc < 25 ) {
    console.log(nome, 'está com peso normal.')
    
} else if ( imc >= 25 && imc < 30) {
    console.log(nome, 'está com sobrepeso.')

} else if ( imc >= 30 && imc < 40 ) {
    console.log(nome, 'está com obesidade.')
    
} else if ( imc >= 40 ) {
    console.log(nome, 'está com obesidade grave.')
}
