/* Template strings
são strings que permitem expressões embutidas. 
Você pode utilizar string multi-linhas e 
interpolação de string com elas.*/
//Função para a criação de cards
let title = ""
let usuario = document.getElementById("title")
usuario.focus()


function criarCard() {
    title = document.getElementById("title").value
    let cardSection = document.getElementById("card");
    title = title.trim()
    if (title == "") {
        cardSection.innerHTML += `<div>O campo de título não pode estar vazio</div>`
        cardSection.style.color = "red"
    } else {
        cardSection.innerHTML += `<div><h2>${title}</h2></div>`;
        cardSection.style.color = "white"
    }
}

usuario.addEventListener('keydown', function() {
    title = document.getElementById("title").value
    if (title.length >= 8) {
        usuario.blur()
    } else {
        console.log(title.length)
    }
})