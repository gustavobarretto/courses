// const -> VARIÁVEL DE MEMÓRIA CONSTANTE.
// let -> VARIÁVEL DE MEMÓRIA

// DADOS PRIMÁRIOS -> string, integer, float, boolean
// DADOS DE REFERÊNCIA -> objetos, arrays

// métodos e funções e encapsulamento

const name = "Gustavo";

function pegarSobrenome () {
  const sobrenome = "Barretto"; // essa variável existe apenas localmente em pegarSobrenome()
  return sobrenome;
}

const person = {
  name: "Gustavo",
  age: 21,
  envelhecer: function(anosDeVida) {
    return 21 + anosDeVida;
  },
  caracteristicas: [
    "loiro",
    "alto",
    "musculoso"
  ]
  
}



const lista = [{ 
  name: "Gustavo",
  age: 30
}, 
"Raissa",
function() {
  console.log("Passei por aqui!")
}
]
              //0  1  2  3  4  5
const lista2 = [1, 2, 3, 4, 5, 6]
