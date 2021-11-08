// const funcionalidade = require("../funcionalidad.js");

// const id = 'resultado';
// const type = 'span';
// const value = '10';
// const el = document.createElement('span');
// el.setAttribute('id', id);
// el.innerHTML = value;
// document.body.appendChild(el);
// var opera = '5'
// var operb = '2'
// var oper = "+"

// describe('Testando as funções', () => {
//     test('Testando somar', () => {
//         funcionalidade.operando_a = "10"
//         funcionalidade.operando_b = "5"
//         funcionalidade.operacao = "+"
//         funcionalidade.resolver;
//         const res = document.getElementById('resultado').value
//         expect(res).toBe("15")

//     })})


// describe('Testando as funções', () => {

//     test('Testando limpar', () => {
//         expect(funcionalidade.limpar).toBe(undefined)

//     })

//     test('Testando somar', () => {
//         funcionalidade.operando_a = "10"
//         funcionalidade.operando_b = "5"
//         funcionalidade.operacao = "+"
//         funcionalidade.resolver
//         expect(funcionalidade.resultado.textContent).toBe(15);


//     })
    
// })


// describe('Validate function Limpiar', () => {
//     test('Limpiar', () =>{
//         const validateElement = document.getElementById(id);
//         expect(validateElement).toBeDefined();
//         expect(validateElement.innerHTML).toBe("10");
//         limpiar();
//         expect(validateElement.innerHTML).toBe("");
//         validateElement.innerHTML = value;
//     }});

// describe('Validate function Resetear', () => {
//     test('Resetear', () =>{
//         const ret = setVars(opera,operb,oper)
//         const validateElement_2 = document.getElementById(id);
//         expect(validateElement_2).toBeDefined();
//         expect(validateElement_2.innerHTML).toBe("10");
//         expect(ret[0]).toBe("5");
//         expect(ret[1]).toBe("2");
//         expect(ret[2]).toBe("+");
//         resetear();
//         const ret2 = setVars()
//         expect(validateElement_2.innerHTML).toBe("");
//         expect(ret2[0]).toBe(0);
//         expect(ret2[1]).toBe(0);
//         expect(ret2[2]).toBe("");
//         validateElement_2.innerHTML = value;
//     });
// })

// const { limpar, resetar, resolver, init } = require('../funcionalidad.js');
// const { expect } = require('@jest/globals');

// const id = 'resultado';
// const type = 'span';
// const value = '10';
// const el = document.createElement('span');
// el.setAttribute('id', id);
// el.innerHTML = value;
// document.body.appendChild(el);
// var opera = '5'
// var operb = '2'
// var oper = "+"

// describe('Validate function Resetear', () => {
//     test('Resetear', () =>{
//         const ret = setVars(opera,operb,oper)
//         const validateElement_2 = document.getElementById(id);
//         expect(validateElement_2).toBeDefined();
//         expect(validateElement_2.innerHTML).toBe("10");
//         expect(ret[0]).toBe("5");
//         expect(ret[1]).toBe("2");
//         expect(ret[2]).toBe("+");
//         resetear();
//         const ret2 = setVars()
//         expect(validateElement_2.innerHTML).toBe("");
//         expect(ret2[0]).toBe(0);
//         expect(ret2[1]).toBe(0);
//         expect(ret2[2]).toBe("");
//         validateElement_2.innerHTML = value;
//     });
// })

// describe('Validate function Limpiar', () => {
//     test('Limpiar', () =>{
//         const validateElement = document.getElementById(id);
//         expect(validateElement).toBeDefined();
//         expect(validateElement.innerHTML).toBe("10");
//         limpiar();
//         expect(validateElement.innerHTML).toBe("");
//         validateElement.innerHTML = value;
//     })})

const { init, limpar, resetar, resolver } = require("../funcionalidad.js");

describe('Teste de saída de dados ', () => {
    it('Saída soma', () => {

        init();
        limpar();
        resolver(1, 2);
        expect(document.getElementById("resultado").innerHTML).toBe("3");
    });
});








// describe('Validate function Limpiar', () => {
//     test('Limpar', () =>{
//         const validateElement = document.getElementById('resultado');
//         expect(validateElement).toBeDefined();
//         expect(validateElement.innerHTML).toBe("10");
//         limpar();
//         expect(validateElement.innerHTML).toBe("");
    
//     })})






