let totalRounds = 0;
let resultUsr = 0;
let resultPC = 0;

function displayPlay (msg) {
    const display = document.querySelector('[class=resultado]')
    display.textContent = msg
}

const clearBoard = () => {
    totalRounds = 0;
    resultPC = 0;
    resultUsr = 0;
    document.querySelector('[class=round]').textContent = totalRounds
}

const coutingRound = (round) => {
    
    if (round == 1 || round == -2) {
        resultUsr += 1
        
    } else if (round == 0) {
        
    } else {
        resultPC += 1
    }
    totalRounds +=1
    document.querySelector('[class=round]').textContent = totalRounds

    if(totalRounds == 3) {
        if(resultPC > resultUsr) {
            displayPlay('O computador venceu de ' + resultPC + ' a ' + resultUsr)
            
        } else if (resultPC < resultUsr) {
            displayPlay('Você venceu de ' + resultUsr + ' a ' + resultPC)
            
        } else {
            displayPlay('Deu empate! Você e o computador ficaram com os mesmos pontos!')
        }
        clearBoard()
    }
} 

const displayWait =_=> {
    displayPlay('Carregando...')
}

const play = userPlay => {

    displayWait()

    setTimeout( () => {
        displayPlay('Você selecionou ' + document.querySelector(`[class='${userPlay}']`).textContent)
    }, 2000)

    const computerPlay = Math.floor((Math.random() * 3) + 1);
    const round = userPlay - computerPlay;

    displayWait()

    setTimeout( () => {
        displayPlay('O PC selecionou ' + document.querySelector(`[class='${computerPlay}']`).textContent)
    }, 4000)

    displayWait()

    setTimeout( () => {
        if (round == 1 || round == -2) {
            displayPlay('Você ganhou!')
        } else if (round == 0) {
            displayPlay('Empate!')
        } else {
            displayPlay('Você perdeu!')
        }
    }, 6000)

    setTimeout( () => {
        coutingRound(round)
    }, 8000)  
}