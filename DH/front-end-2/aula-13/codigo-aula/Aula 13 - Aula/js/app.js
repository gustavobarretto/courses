//Função para a criação de cards
let elements = 0
let urlImg = ""
let title = ""
let description = ""



function createCard() {
    title = document.getElementById("title").value
    description = document.getElementById("description").value
    urlImg = document.getElementById("url_img").value


    let cardSection = document.getElementById("card");
    cardSection.innerHTML += `<div> <img src="${urlImg}">
                                    <h2>${title}</h2>
                                    <p>${description}<p> </div>`;
}