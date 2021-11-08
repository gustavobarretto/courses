// Exercício Integrador
// Temos que fazer um sistema para um Agricultor controlar suas vendas. 
// Ele tem um controle de vendas em um caderno, onde os produtos estão organizados por nome, preço e quantidade vendida. 
// Portanto, crie um array de objetos literais com essas informações. 
// No sistema, você tem que adicionar uma função (ou várias) que realize os seguintes passos:
// 1. Calcular o lucro total de todos os produtos;
// 2. Permitir pesquisar um produto pelo nome e calcular seu lucro total;
// 3. Permite receber um valor e indicar todos os produtos que venderam mais que esse valor;
// 4. Classifique todos os produtos pela quantidade de dinheiro que geraram.
// 5. Encontre um produto e atribua a ele um novo valor (reutilize o código que permite encontrar o produto pelo nome).
// 6. Calcule o lucro total após pagar 45% do lucro em impostos.

let produtos = [
    {
        nome: 'Couve-flor',
        preco: 9.99,
        quantidadeVendida: 13
    },
    {
        nome: 'Alface',
        preco: 5.99,
        quantidadeVendida: 11
    },
    {
        nome: 'Pepino',
        preco: 3.99,
        quantidadeVendida: 35
    },
    {
        nome: 'Picles',
        preco: 13.99,
        quantidadeVendida: 2
    },
    {
        nome: 'Berinjela',
        preco: 3.99,
        quantidadeVendida: 81
    },
];

// 1. Calcular o lucro total de todos os produtos.
let lucroTotal = 0
produtos.forEach(produto => {
    let auxiliar = produto.preco * produto.quantidadeVendida;
    lucroTotal += auxiliar
}); console.log(`O valor total é de R$ ${lucroTotal.toFixed(2)}!`)

// 2. Permitir pesquisar um produto pelo nome e calcular seu lucro total
let produtoLucro = produtos.filter(pesquisaProduto => {
    return pesquisaProduto.nome == 'Berinjela' ? console.log(`O valor total do produto é de R$${pesquisaProduto.preco * pesquisaProduto.quantidadeVendida}.`) : '';
}); produtoLucro

// 3. Permitir receber um valor e indicar todos os produtos que venderam mais que esse valor.
let valorVenda = produtos.filter(pesquisaValor =>{
    return pesquisaValor.preco < 10  ? console.log(`O produto ${pesquisaValor.nome} foi vendido por R$${pesquisaValor.preco}`) : '';
}); valorVenda

// 4. Classifique todos os produtos pela quantidade de dinheiro que geraram.

let classificarPorDinheiroGerado = produtos.sort((a, b) => {
    return (b.preco * b.quantidadeVendida) - (a.preco * a.quantidadeVendida)
}); console.log(classificarPorDinheiroGerado)

// 5. Encontre um produto e atribua a ele um novo valor (reutilize o código que permite encontrar o produto pelo nome).
let produtoValor = produtos.filter(pesquisaProduto => {
    if(pesquisaProduto.nome == 'Berinjela') {
        console.log(`O produto ${pesquisaProduto.nome} de valor R$${pesquisaProduto.preco} está tendo seu valor alterado.`)
        pesquisaProduto.preco = 8.99
        console.log(`O novo valor do produto ${pesquisaProduto.nome} é de R$${pesquisaProduto.preco}.`)
    }
}); produtoValor

// 6. Calcule o lucro total após pagar 45% do lucro de impostos.
console.log(`O lucro total descontando os impostos é de R$${(lucroTotal * 0.55).toFixed(2)}.`)



