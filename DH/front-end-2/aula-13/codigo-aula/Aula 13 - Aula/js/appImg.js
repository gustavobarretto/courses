//Função para a criação de cards
let urlImg = ""
let imagemTexto = document.getElementById("url_img")
window.onload = imagemTexto.focus()

function createCard() {

    urlImg = document.getElementById("url_img").value


    let cardSection = document.getElementById("card");
    cardSection.innerHTML += `<div> <img src="${urlImg}"></div>`;
}

imagemTexto.addEventListener('keydown', function(event) {
    if (imagemTexto.value.length >= 12 && event.key != "Backspace") {
        imagemTexto.blur()
        document.querySelector("button").focus()
    }
})