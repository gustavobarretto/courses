alert('Olá, visitante'); // O código alert() para a execução do site.

alert('Que bom clicou em Ok!');

let resultado = confirm('Deseja realmente excluir este cliente?');

console.log(resultado); // Esse resultado chega é exposto no console do navegador.

let nome = prompt('Digite seu nome: ');

alert('Olá ' + nome);

document.querySelector('h1').innerText += ' ' + nome;
