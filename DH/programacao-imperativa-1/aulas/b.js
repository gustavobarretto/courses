function calcular (numA, numB, operacao) {
    if (operacao=='+') {
        return numA+numB;
    } if (operacao=='-') {
        return numA-numB 
    } if (operacao=='*') {
        return numA*numB
    } if (operacao=='/' && numB!=0) {
        return numA/numB
    } else {
        return 'Impossível dividir!'
    }
    
} 
let resultado = calcular(12, 0,'/')
console.log('Resultado='+resultado)