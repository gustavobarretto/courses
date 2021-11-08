// EXERCÍCIO 'MEU CARDÁPIO'

function Restaurante(nomeRestaurante, cardapio) {
    nomeRestaurante = 'Belanápole'
    cardapio = ['Ravioli', ' Fettuccine', ' Lasanha', ' Pizza', ' Bruschetta', ' Espaguete.']
    function bemVindo() {
        console.log('Sejam bem-vindos ao ' + nomeRestaurante + ', cujo cardápio de hoje é: ' + cardapio)
    } bemVindo()
} 
Restaurante()

// testando o exercício com a arrow function
const Restaurante2 = (nomeRestaurante2, cardapio2) => {
    nomeRestaurante2 = 'Belanápole'
    cardapio2 = ['Ravioli', ' Fettuccine', ' Lasanha', ' Pizza', ' Bruschetta', ' Espaguete.']
    bemVindo = () => console.log('Sejam bem-vindos ao ' + nomeRestaurante2 + ', cujo cardápio de hoje é: ' + cardapio2)
    bemVindo()
} 
Restaurante2()
