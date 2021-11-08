// exercício de aprendizagem do twitch
let estacao = 'Verão'

switch (estacao) {
    case 'Verão':
        console.log('Que calor, hein?!')
        break;
    case 'Inverno':
        console.log('Frio demais!')
        break;
    case 'Outono':
        console.log('É a estação em que as folhas caem.')
        break;
    case 'Primavera':
        console.log('O momento em que as flores crescem.')
    default:
        console.log('Preencha a variável corretamente. Aparentemente, não diz respeito a nenhuma estação.') // funciona como 'Ops, estação inválida'.
}