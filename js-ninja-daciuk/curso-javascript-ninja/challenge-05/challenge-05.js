/*
Crie uma variável qualquer, que receba um array com alguns valores aleatórios
- ao menos 5 - (fica por sua conta os valores do array).
*/
let array = [1, 'gustavo', true, null, {}];

/*
Crie uma função que receba um array como parâmetro, e retorne esse array.
*/
function myFunction(arg) {
    return arg
}

console.log(myFunction(array));

/*
Imprima o segundo índice do array retornado pela função criada acima.
*/
console.log(myFunction(array[1]));

/*
Crie uma função que receba dois parâmetros: o primeiro, um array de valores; e o
segundo, um número. A função deve retornar o valor de um índice do array que foi passado
no primeiro parâmetro. O índice usado para retornar o valor, deve ser o número passado no
segundo parâmetro.
*/
function myFunction2 (array, index) {
    return array[index]
}

/*
Declare uma variável que recebe um array com 5 valores, de tipos diferentes.
*/
let array2 = [{nome: 'gustavo', sobrenome: 'barretto', idade: 30}, 'pessoas', true, undefined, 25]

/*
Invoque a função criada acima, fazendo-a retornar todos os valores do último
array criado.
*/
console.log(myFunction(array2))

/*
Crie uma função chamada `book`, que recebe um parâmetro, que será o nome do
livro. Dentro dessa função, declare uma variável que recebe um objeto com as
seguintes características:
- esse objeto irá receber 3 propriedades, que serão nomes de livros;
- cada uma dessas propriedades será um novo objeto, que terá outras 3
propriedades:
    - `quantidadePaginas` - Number (quantidade de páginas)
    - `autor` - String
    - `editora` - String
- A função deve retornar o objeto referente ao livro passado por parâmetro.
- Se o parâmetro não for passado, a função deve retornar o objeto com todos
os livros.
*/
function book (param) {
    let books = { HarryPotter: { quantidadePaginas: 300, autor: 'JK Rowling', editora: 'Fontes' },
                  GameOfThrones: { quantidadePaginas: 800, autor: 'George G Martin', editora: 'Leya' },
                  SenhorDosAneis: { quantidadePaginas: 1200, autor: 'Tolkien', editora: 'Sextante' } 
                }
 
    if (!param) {
        return books;
    }
    return books[param]
}

/*
Usando a função criada acima, imprima o objeto com todos os livros.
*/
console.log('Livros')
console.log(book());

/*
Ainda com a função acima, imprima a quantidade de páginas de um livro qualquer,
usando a frase:
"O livro [NOME_DO_LIVRO] tem [X] páginas!"
*/
console.log('O livro Harry Potter e a Pedra Filosofal têm ' + book('HarryPotter').quantidadePaginas + ' páginas!')

/*
Ainda com a função acima, imprima o nome do autor de um livro qualquer, usando
a frase:
"O autor do livro [NOME_DO_LIVRO] é [AUTOR]."
*/
console.log('O autor do livro Game of Thrones é ' + book('GameOfThrones').autor);

/*
Ainda com a função acima, imprima o nome da editora de um livro qualquer, usando
a frase:
"O livro [NOME_DO_LIVRO] foi publicado pela editora [NOME_DA_EDITORA]."
*/
console.log('O livro Senhor dos Aneis foi publicado pela editora ' + book('SenhorDosAneis').editora)