const pratos = ["Pipoca", "Macarrão", "Carne", "Feijão", "Brigadeiro"]
const tempos = [10, 8, 15, 12, 8]
let microondas = function (prato, segundos) {
        if(isNaN(segundos)){
            return "Este tempo informado não é um número"
        }
        for (let i = 0; i < pratos.length; i++) {
            if (pratos[i] == prato) {
                if (segundos >= tempos[i] && segundos < (tempos[i] * 2)) { 
                    return "Prato pronto, bom apetite!"
                }
                else if (segundos >= tempos[i]*2 && segundos < (tempos[i] * 3)) { 
                    return "O prato queimou!"
                }
                else if (segundos >= tempos[i] * 3) { 
                    return "Kabumm"
                }
                else if (segundos < tempos[i]) {
                    return "Tempo insuficiente"
                }
            }
        }
        return "Prato inexistente"
    }
console.log(microondas("Pipoca", 12))
