// MICRODESAFIOS
// 1) Crie uma função que receba um array composto por números e retorna uma nova matriz (array) 
// com todos os valores divididos pela soma de toda a matriz, usando map() e reduce().
let valoresSoma = [10, 23, 13, 17, 25, 2, 71]
let valoresAdicionados = valoresSoma.reduce((a, b) => a + b)
console.log(valoresAdicionados)
let valoresDivididos = valoresSoma.map(gustavinho => {
    return (gustavinho / valoresAdicionados).toFixed(5)
}); console.log(valoresDivididos)  


// 2) Crie uma função que receba um array de palavras e um número,
// e que retorna uma matriz (array) com apenas as palavras que têm 
// mais do que uma quantidade de letras maior do que o número informado. 
// (verifique como funciona o método filter ())
let funcaoArray = (palavras, n) => {
    return palavras.filter(elemento => {
        return elemento.length > n;
    })
}; console.log(funcaoArray(['Torre', 'Tapeçaria', 'Inconstitucionalíssimamente', 'Lobo', 'Permissão', 'Instabilidade'], 20))


// 3) Crie um array de objetos literais, onde cada objeto será 
// um aluno e terá dois atributos: nome e nota. Crie duas funções 
// que ordenam o array: uma ordenará os alunos em ordem alfabética 
// e a outra o fará por nota, da mais alta para a mais baixa. 
// (Analise qual método seria apropriado para este caso. Recomendamos que você consulte a documentação do MDN: 
// https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Global_Objects/Array)

const alunos = [
    {nome: 'Gustavo', nota: 3},
    {nome: 'Eduardo', nota: 8},
    {nome: 'Marcelo', nota: 13},
    {nome: 'Mangueira', nota: 10},
    {nome: 'Beija-flor', nota: 9.5},
    {nome: 'Nathalia', nota: 12},
    {nome: 'Melina', nota: 11},
    {nome: 'Inimigos do Fim', nota: 5}
]

let nomes = (array) => {
    let resultadoNomes = array.map(elemento =>{
         return elemento.nome
     });
    return resultadoNomes.sort()
}; console.log(nomes(alunos))

let numeros = (array) => {
    let resultadoNumeros = array.map(elemento => {
        return elemento.nota
    });
    return resultadoNumeros.sort((a, b) => b - a)
}; console.log(numeros(alunos))


