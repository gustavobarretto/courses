const form = document.createElement('form');
const formText = document.createTextNode('Formulário');

form.appendChild(formText);

const element = document.querySelector('[class=container]');
element.appendChild(form)


// const createForm = () => {
//     const elementsList = [document.createElement('form'), document.createElement('h3'),
//                           document.createElement('div'), document.createElement('p'),
//                           ]
//     const elementTextList = [document.createTextNode('Formulário'),
//                              document.createTextNode('Usuário')]
    
//     elementsList[1].appendChild(elementTextList[0]);

//     const element = document.querySelector('[class=container');
//     element.appendChild(elementsList[1])

    
// }

// document.querySelector('[class=form-access]').addEventListener('click', createForm)


