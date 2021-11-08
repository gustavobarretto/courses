let filmes = ['Star Wars', 'Clube da Luta', 'O Poderoso Chefão', 'Top Gun', 'Interestelar']

let filmesMaiusculas = [filmes[0].toUpperCase(),
filmes[1].toUpperCase(),
filmes[2].toUpperCase(),
filmes[3].toUpperCase(),
filmes[4].toUpperCase(),
]

let filmesMaiusculos = () => {
    for(i=0; i<filmes.length; i++)
     {
        console.log(filmes.length)
        filmes[i].toUpperCase
        return console.log(filmes)
    }
} 
filmesMaiusculos()

//console.log(filmesMaiusculas)
let cartoons = ["toy story", "Procurando Nemo", "kung-fu panda", "wally", "fortnite"]

let filmesCartoons = filmes // nesse caso, nós colamos os arrays aqui. Dá pra fazer uma cópia de um array criando uma variável.
//console.log(filmesCartoons)

function addCartons(indice) {
    filmes.push(cartoons[indice])
    filmesMaiusculas.push(cartoons[indice])
}
addCartons(0)
addCartons(1)
addCartons(2)
addCartons(3)
addCartons(4)

//console.log(filmes)
//console.log(filmesMaiusculas)


