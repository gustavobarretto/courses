// Objetivos
// Nesta aula, iremos aplicar nossos conhecimentos, em exercícios, como forma de
// aquecimento para a “Prática Guiada” que ocorrerá em nosso encontro ao vivo.
// Vamos imaginar um cenário de um e-commerce, onde há diversas operações existentes,
// como pesquisar por produtos, adicioná-los ao carrinho e realizar uma compra.
// No VS Code, resolva as seguintes situações em JavaScript.
// Os exercícios possuem soluções que vocês poderão consultar. A ideia é que essa atividade
// sirva como aquecimento para a Prática Guiada, por isso pratique bastante. Tente fazer
// todos os exercícios antes de analisar o código com as respostas:
// 1. Crie uma variável produtos, que contenha um array de objetos, com no
// mínimo 3 itens. Dentro da variável, liste produtos disponíveis, informando os
// seguintes detalhes: Nome do Produto, Valor do Produto, Qualidade do
// Produto e Status.
// A informação Qualidade do Produto deve ser um número que irá de 0 a 10.
// A informação Status deve ser um Booleano, indicando se o produto está
// disponível em estoque.

let produtos = [
    {
        nome: 'Monitor Asus 144hz',
        valor: 1444.45,
        qualidade: 9,
        status: true
    },
    {
        nome: 'Mouse Logitech PRO',
        valor: 699.99,
        qualidade: 10,
        status: true
    },
    {
        nome: 'Teclado Multilaser',
        valor: 49.99,
        qualidade: 5,
        status: false
    },
    {
        nome: 'Fone de Ouvido HyperX',
        valor: 399.99,
        qualidade: 8,
        status: false
    }
]


// 2. Em seguida, um usuário deseja filtrar os produtos, com base em alguns
// critérios. Selecione todos os produtos que tenham:
// Valor entre 482 e 1600;
// Qualidade superior a 60;
// Status como disponível.
// O resultado do filtro deve ser armazenado na variável carrinho.
let carrinho = []
let valorTotal = 0
let nomes = []
let precos = []
let busca = produtos.filter(produto => {
    if(produto.qualidade > 6 && produto.valor > 482 && produto.valor < 1600 && produto.status == true) {
        carrinho.push(produto)
        valorTotal += produto.valor
        nomes.push(produto.nome)
        precos.push(produto.valor)

    }
});

// 3. Por fim, é necessário exibir todos os itens presentes no carrinho, com seus
// nomes e preços correspondentes, e no final um valor total, resultante da
// somatória de todos os produtos.

console.log(`O seu carrinho contêm os produtos ${nomes} de valores ${precos}, respectivamente, totalizando um valor de R$${valorTotal}.`)