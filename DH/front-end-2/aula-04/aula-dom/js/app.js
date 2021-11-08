let numeros = document.querySelectorAll('#numeros li');

for(let i = 0; i < numeros.length; i++) {
    // <Li> os textos da tag li estão passandos num loop.
    console.log(numeros[i].innerText)
}