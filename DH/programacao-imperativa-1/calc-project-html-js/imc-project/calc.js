
const calcular = document.getElementById('calcular');

const imc = () => {
    const nome = document.getElementById('nome').value;
    const altura = document.getElementById('altura').value;
    const peso = document.getElementById('peso').value;
    const resultado = document.getElementById('resultado');
    
    if(nome != '' && altura != '' && peso != '') {
        if(altura > 100) {
            alert('Preencha em metros e não em centímetros!')
        }
        let valorIMC = (peso / (altura * altura)).toFixed(2)
        if(valorIMC < 18.5) {
            resultado.textContent = nome + ' está abaixo do peso, pois seu IMC é ' + valorIMC + '.'; 
        } else if(valorIMC < 25) {
            resultado.textContent = nome + ' está com o peso ideal, pois seu IMC é ' + valorIMC + '.';
        } else if(valorIMC < 30) {
            resultado.textContent = nome + ' está com sobrepeso, pois seu IMC é ' + valorIMC + '.';
        } else if(valorIMC < 40) {
            resultado.textContent = nome + ' está com obesidade, pois seu IMC é ' + valorIMC + '.';
        } else if(valorIMC > 40) {
            resultado.textContent = nome + ' está com obesidade mórbida, pois seu IMC é ' + valorIMC + '.';
        }
        
    } else {
        resultado.textContent = 'Algum campo está vazio.'
    }


}

calcular.addEventListener('click', imc);