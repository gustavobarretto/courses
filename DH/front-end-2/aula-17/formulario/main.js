/*Estrutura para iterar com uma lista obtida através de uma API*/
/*fetch('https://jsonplaceholder.typicode.com/posts').then((response) => response.json())
    .then((json) => json.map((json) => console.log(json)))
*/

//Cadastro

const createCard = (user) => {
    const card = document.getElementById('card').innerHTML += 
    `<p>Usuário ${user} cadastrado com sucesso!</p>`
}

createCard('Gustavo')


const form = document.forms.form;

form.addEventListener('submit', (e) => {
    e.preventDefault()

    const { name, password } = form;

    fetch('https://jsonplaceholder.typicode.com/posts', {
            method: 'POST',
            body: JSON.stringify({
                usuario: name.value,
                senha: password.value,
                userId: 1,
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
        .then((response) => response.json())
        .then((json) => {
            console.log(json)
            
            

            
        }).catch((erro) => console.log("Algo de errado não está certo."))
})

