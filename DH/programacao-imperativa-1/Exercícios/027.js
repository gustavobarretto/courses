// Parte I
// Crie um objeto aluno que tenha como atributos: nome (string), quantidade de faltas (number) e notas (array de números). 
// Crie um construtor para ele e importe-o como o módulo aluno.
const Aluno = require('./027/mod-aluno')
const { addAluno } = require('./027/mod-curso')
let alunos = [
    new Aluno('Gustavo', 2, [7, 8, 10]),
    new Aluno('Pedro', 5, [7.7, 7.7, 7.7]),
    new Aluno('Eduardo', 0, [5.9, 7, 8.3])
]
module.exports = alunos
console.log(alunos[0].med)

// Parte II
// Nosso objeto aluno terá o método calcularMedia que retorna a média de suas notas. 
// Também terá um método chamado faltas, que simplesmente aumenta o número de faltas em 1.
alunos[2].falta()
console.log(alunos[2])

// Parte III
// Em um arquivo diferente, crie o objeto literal curso que tem como atributos: nome do curso (string), 
// nota de aprovação (number), faltas máximas (number) e uma lista de estudantes (um array composto pelos alunos criados no passo 1).
let curso = require('./027/mod-curso')
curso.listaEstudantes = alunos
console.log(curso)

// Parte IV
// Crie o método que permite adicionar alunos à lista do curso, ou seja, quando chamamos nosso método em nosso objeto curso,
// deverá adicionar um aluno a mais na propriedade lista de estudantes do objeto curso.

curso.addAluno('Claudio', 3, [6.6, 7, 7.3])
console.log(curso)

// Parte V
// Crie um método para o objeto curso que receba um aluno (como parâmetro) e retorne true se ele aprovou no curso ou false 
// em caso de reprovação. Para ser aprovado, o aluno tem que ter uma média igual ou acima da nota de aprovação e ter menos 
// faltas que faltas máximas. Se tiver a mesma quantidade, tem que estar 10% acima da nota de aprovação.

console.log(alunos[0].calcularMedia())
console.log(alunos)
console.log(curso.aprovacao('Pedro'))

// Parte VI
// Crie um método para o objeto curso que percorra a lista de estudantes e retorne um array de booleanos com os
// resultados se os alunos aprovaram ou não.
console.log(curso.listaEstudantes)
curso.listaAprovacao()

// Parte VII
// Importe o módulo estudantes.js, que contém uma lista de alunos, dentro do arquivo que contém o objeto curso. 
// Substitua o conteúdo da propriedade lista de estudantes, pela lista de estudantes do arquivo estudantes.js e 
// garanta que sigam funcionando todos os métodos corretamente. (revisar que o arquivo tenha todos os métodos corretamente).