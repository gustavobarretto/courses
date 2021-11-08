//Criação do formulário:

var formulario = document.createElement("form");
formulario.setAttribute('class', 'formulario');
document.body.appendChild(formulario);



//Seleção do formulário:

var form = document.querySelector(".formulario");

//Inserção do Título:

var titulo = document.createElement("h1");
var tituloText = document.createTextNode("Login");

titulo.appendChild(tituloText);
form.appendChild(titulo);

//Inserção de divs para manipulação dos inputs:

var usuario = document.createElement("input");
var divUsuario = document.createElement("div");
usuario.setAttribute("placeholder", "Nome de Usuário");
divUsuario.setAttribute("id", "Usuario");
usuario.setAttribute("type", "number")
divUsuario.appendChild(usuario);
form.appendChild(divUsuario);

var email = document.createElement("input");
var divEmail = document.createElement("div");
email.setAttribute("placeholder", "Email");
email.setAttribute("type", "email");
divEmail.setAttribute("id", "Email");
divEmail.appendChild(email);
form.appendChild(divEmail);

var senha = document.createElement("input");
var divSenha = document.createElement("div");
senha.setAttribute("placeholder", "Senha");
senha.setAttribute("type", "password");
divSenha.setAttribute("id", "Senha");
divSenha.appendChild(senha);
form.appendChild(divSenha);

//Radio buttons
let botaoRadio = document.createElement('input');
botaoRadio.setAttribute('type', 'radio');
botaoRadio.setAttribute('name', 'Verificador')
form.appendChild(botaoRadio)




//Inserção dos botões:

var botaoEnviar = document.createElement("button");
var botaoTextoEnviar = document.createTextNode("Enviar");
botaoEnviar.setAttribute("type", "submit");
botaoEnviar.appendChild(botaoTextoEnviar);
form.appendChild(botaoEnviar);

var botaoCancelar = document.createElement("button");
var botaoTextoCancelar = document.createTextNode("Cancelar");
botaoCancelar.setAttribute("type", "reset");
botaoCancelar.appendChild(botaoTextoCancelar);
form.appendChild(botaoCancelar);

//Sugestão de estilização:

formulario.style.display = "flex";
formulario.style.maxWidth = "300px";
formulario.style.textAlign = "center";
formulario.style.flexDirection = "column";
formulario.style.display = "inline-block";
document.body.style.textAlign = "center";

//Cancela o envio
botaoCancelar.onclick = function() {
    confirm("Você têm certeza de que deseja cancelar o envio?")
}

//Cancela a ação reset padrão do botão 
botaoEnviar.addEventListener('click', function(event) {
    event.preventDefault()
});

//Muda a cor do título ao passar o mouse por cima do objeto
titulo.addEventListener('mouseover', function() {
    titulo.style.color = "teal"
})

//Muda a cor do título sair do mouse sobre o objeto
titulo.addEventListener('mouseout', function() {
    titulo.style.color = "slategray"
})

//Desabilita quando o mouse não está sobre o campo e algo é digitado
let mouseUsuario = false
let mouseEmail = false
let mouseSenha = false

divUsuario.addEventListener('keydown', function() {
    if (!mouseUsuario) {
        usuario.disabled = true
    }
})

divEmail.addEventListener('keydown', function() {
    if (!mouseEmail) {
        email.disabled = true
    }
})

divSenha.addEventListener('keydown', function() {
    if (!mouseSenha) {
        senha.disabled = true
    }
})

//Desabilita o campo quando o mouse sai sobre ele
divUsuario.addEventListener('mouseout', function() {
    usuario.disabled = true
    mouseUsuario = false
})

divEmail.addEventListener('mouseout', function() {
    email.disabled = true
    mouseEmail = false
})

divSenha.addEventListener('mouseout', function() {
    senha.disabled = true
    mouseSenha = false
})

//Habilita o campo quando o mouse está sobre ele
divUsuario.addEventListener('mouseover', function() {
    usuario.disabled = false
    mouseUsuario = true
})

divEmail.addEventListener('mouseover', function() {
    email.disabled = false
    mouseEmail = true
})

divSenha.addEventListener('mouseover', function() {
    senha.disabled = false
    mouseSenha = true
})
