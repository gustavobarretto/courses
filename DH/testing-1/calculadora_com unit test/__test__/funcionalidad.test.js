const { limpar, resetar, setVars, resolver, init } = require('../funcionalidad.js');
const { expect } = require('@jest/globals');

const id = 'resultado';
const type = 'span';
const value = '10';
const el = document.createElement('span');
el.setAttribute('id', id);
el.innerHTML = value;
document.body.appendChild(el);
var oper_a = '5'
var oper_b = '2'
var oper = "+"
//add buttons to init() test
const one = document.createElement('button');
one.setAttribute('id', 'um');
one.innerHTML = "1";
document.body.appendChild(one);

const two = document.createElement('button');
two.setAttribute('id', 'dois');
two.innerHTML = "2";
document.body.appendChild(two);

const three = document.createElement('button');
three.setAttribute('id', 'tres');
three.innerHTML = "3";
document.body.appendChild(three);

const four = document.createElement('button');
four.setAttribute('id', 'quatro');
four.innerHTML = "4";
document.body.appendChild(four);

const five = document.createElement('button');
five.setAttribute('id', 'cinco');
five.innerHTML = "5";
document.body.appendChild(five);

const six = document.createElement('button');
six.setAttribute('id', 'seis');
six.innerHTML = "6";
document.body.appendChild(six);

const seven = document.createElement('button');
seven.setAttribute('id', 'sete');
seven.innerHTML = "7";
document.body.appendChild(seven);

const eight = document.createElement('button');
eight.setAttribute('id', 'oito');
eight.innerHTML = "8";
document.body.appendChild(eight);

const nine = document.createElement('button');
nine.setAttribute('id', 'nove');
nine.innerHTML = "9";
document.body.appendChild(nine);

const zero = document.createElement('button');
zero.setAttribute('id', 'zero');
zero.innerHTML = "0";
document.body.appendChild(zero);

const reset = document.createElement('button');
reset.setAttribute('id', 'reset');
reset.innerHTML = "C";
document.body.appendChild(reset);

const plus = document.createElement('button');
plus.setAttribute('id', 'soma');
plus.innerHTML = "+";
document.body.appendChild(plus);

const menos = document.createElement('button');
menos.setAttribute('id', 'subtracao');
menos.innerHTML = "-";
document.body.appendChild(menos);

const multi = document.createElement('button');
multi.setAttribute('id', 'multiplicacao');
multi.innerHTML = "*";
document.body.appendChild(multi);

const division = document.createElement('button');
division.setAttribute('id', 'divisao');
division.innerHTML = "/";
document.body.appendChild(division);

const equal = document.createElement('button');
equal.setAttribute('id', 'igual');
equal.innerHTML = "=";
document.body.appendChild(equal);


describe('Validate function limpar', () => {
    test('limpar', () =>{
        const validateElement = document.getElementById(id);
        expect(validateElement).toBeDefined();
        expect(validateElement.innerHTML).toBe("10");
        limpar();
        expect(validateElement.innerHTML).toBe("");
        validateElement.innerHTML = value;
    });
})

describe('Validate function resetar', () => {
    test('resetar', () =>{
        const ret = setVars(oper_a,oper_b,oper)
        const validateElement_2 = document.getElementById(id);
        expect(validateElement_2).toBeDefined();
        expect(validateElement_2.innerHTML).toBe("10");
        expect(ret[0]).toBe("5");
        expect(ret[1]).toBe("2");
        expect(ret[2]).toBe("+");
        resetar();
        const ret2 = setVars()
        expect(validateElement_2.innerHTML).toBe("");
        expect(ret2[0]).toBe(0);
        expect(ret2[1]).toBe(0);
        expect(ret2[2]).toBe("");
        validateElement_2.innerHTML = value;
    });
})

describe('Validate function Resolver', () => {
    test('Resolver soma', () =>{
        oper_a = '5'
        oper_b = '2'
        oper = "+"
        const ret = setVars(oper_a,oper_b,oper)
        const validateElement_2 = document.getElementById(id);
        expect(validateElement_2).toBeDefined();
        expect(validateElement_2.innerHTML).toBe("10");
        expect(ret[0]).toBe("5");
        expect(ret[1]).toBe("2");
        expect(ret[2]).toBe("+");
        resolver();
        const ret2 = setVars()
        expect(validateElement_2.innerHTML).toBe("7");
        expect(ret2[0]).toBe(0);
        expect(ret2[1]).toBe(0);
        expect(ret2[2]).toBe("");
        validateElement_2.innerHTML = value;
    });
    test('Resolver subtracao', () =>{
        oper_a = '15'
        oper_b = '3'
        oper = "-"
        const ret = setVars(oper_a,oper_b,oper)
        const validateElement_2 = document.getElementById(id);
        expect(validateElement_2).toBeDefined();
        expect(validateElement_2.innerHTML).toBe("10");
        expect(ret[0]).toBe("15");
        expect(ret[1]).toBe("3");
        expect(ret[2]).toBe("-");
        resolver();
        const ret2 = setVars()
        expect(validateElement_2.innerHTML).toBe("12");
        expect(ret2[0]).toBe(0);
        expect(ret2[1]).toBe(0);
        expect(ret2[2]).toBe("");
        validateElement_2.innerHTML = value;
    });
    test('Resolver multiplicacao', () =>{
        oper_a = '5'
        oper_b = '6'
        oper = "*"
        const ret = setVars(oper_a,oper_b,oper)
        const validateElement_2 = document.getElementById(id);
        expect(validateElement_2).toBeDefined();
        expect(validateElement_2.innerHTML).toBe("10");
        expect(ret[0]).toBe("5");
        expect(ret[1]).toBe("6");
        expect(ret[2]).toBe("*");
        resolver();
        const ret2 = setVars()
        expect(validateElement_2.innerHTML).toBe("30");
        expect(ret2[0]).toBe(0);
        expect(ret2[1]).toBe(0);
        expect(ret2[2]).toBe("");
        validateElement_2.innerHTML = value;
    });
    test('Resolver divisao', () =>{
        oper_a = '21'
        oper_b = '3'
        oper = "/"
        const ret = setVars(oper_a,oper_b,oper)
        const validateElement_2 = document.getElementById(id);
        expect(validateElement_2).toBeDefined();
        expect(validateElement_2.innerHTML).toBe("10");
        expect(ret[0]).toBe("21");
        expect(ret[1]).toBe("3");
        expect(ret[2]).toBe("/");
        resolver();
        const ret2 = setVars()
        expect(validateElement_2.innerHTML).toBe("7");
        expect(ret2[0]).toBe(0);
        expect(ret2[1]).toBe(0);
        expect(ret2[2]).toBe("");
        validateElement_2.innerHTML = value;
    });
})

describe('Validate function Init', () => {
    test('Press button 1', () =>{
        //Press 1
        const validateElement_1 = document.getElementById('um');
        const validateResult = document.getElementById(id);
        expect(validateElement_1).toBeDefined();
        expect(validateElement_1.innerHTML).toBe("1");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_1.onclick();
        expect(validateResult.innerHTML).toBe("1");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 2', () =>{
        const validateElement_2 = document.getElementById('dois');
        const validateResult = document.getElementById(id);
        expect(validateElement_2).toBeDefined();
        expect(validateElement_2.innerHTML).toBe("2");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_2.onclick();
        expect(validateResult.innerHTML).toBe("2");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 3', () =>{
        const validateElement_3 = document.getElementById('tres');
        const validateResult = document.getElementById(id);
        expect(validateElement_3).toBeDefined();
        expect(validateElement_3.innerHTML).toBe("3");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_3.onclick();
        expect(validateResult.innerHTML).toBe("3");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 4', () =>{
        const validateElement_4 = document.getElementById('quatro');
        const validateResult = document.getElementById(id);
        expect(validateElement_4).toBeDefined();
        expect(validateElement_4.innerHTML).toBe("4");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_4.onclick();
        expect(validateResult.innerHTML).toBe("4");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 5', () =>{
        const validateElement_5 = document.getElementById('cinco');
        const validateResult = document.getElementById(id);
        expect(validateElement_5).toBeDefined();
        expect(validateElement_5.innerHTML).toBe("5");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_5.onclick();
        expect(validateResult.innerHTML).toBe("5");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 6', () =>{
        const validateElement_6 = document.getElementById('seis');
        const validateResult = document.getElementById(id);
        expect(validateElement_6).toBeDefined();
        expect(validateElement_6.innerHTML).toBe("6");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_6.onclick();
        expect(validateResult.innerHTML).toBe("6");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 7', () =>{
        const validateElement_7 = document.getElementById('sete');
        const validateResult = document.getElementById(id);
        expect(validateElement_7).toBeDefined();
        expect(validateElement_7.innerHTML).toBe("7");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_7.onclick();
        expect(validateResult.innerHTML).toBe("7");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 8', () =>{
        const validateElement_8 = document.getElementById('oito');
        const validateResult = document.getElementById(id);
        expect(validateElement_8).toBeDefined();
        expect(validateElement_8.innerHTML).toBe("8");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_8.onclick();
        expect(validateResult.innerHTML).toBe("8");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 9', () =>{
        const validateElement_9 = document.getElementById('nove');
        const validateResult = document.getElementById(id);
        expect(validateElement_9).toBeDefined();
        expect(validateElement_9.innerHTML).toBe("9");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_9.onclick();
        expect(validateResult.innerHTML).toBe("9");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button 0', () =>{
        const validateElement_0 = document.getElementById('zero');
        const validateResult = document.getElementById(id);
        expect(validateElement_0).toBeDefined();
        expect(validateElement_0.innerHTML).toBe("0");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_0.onclick();
        expect(validateResult.innerHTML).toBe("0");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button +', () =>{
        const validateElement_10 = document.getElementById('soma');
        const validateResult = document.getElementById(id);
        expect(validateElement_10).toBeDefined();
        expect(validateElement_10.innerHTML).toBe("+");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_10.onclick();
        const ret = setVars()
        expect(validateResult.innerHTML).toBe("");
        expect(ret[2]).toBe("+");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button -', () =>{
        const validateElement_11 = document.getElementById('subtracao');
        const validateResult = document.getElementById(id);
        expect(validateElement_11).toBeDefined();
        expect(validateElement_11.innerHTML).toBe("-");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_11.onclick();
        const ret = setVars()
        expect(validateResult.innerHTML).toBe("");
        expect(ret[2]).toBe("-");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button *', () =>{
        const validateElement_12 = document.getElementById('multiplicacao');
        const validateResult = document.getElementById(id);
        expect(validateElement_12).toBeDefined();
        expect(validateElement_12.innerHTML).toBe("*");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_12.onclick();
        const ret = setVars()
        expect(validateResult.innerHTML).toBe("");
        expect(ret[2]).toBe("*");
        validateResult.innerHTML = value; //default value to Result
    });
    test('Press button -', () =>{
        const validateElement_13 = document.getElementById('divisao');
        const validateResult = document.getElementById(id);
        expect(validateElement_13).toBeDefined();
        expect(validateElement_13.innerHTML).toBe("/");
        expect(validateResult.innerHTML).toBe("10");
        limpar();
        init();
        validateElement_13.onclick();
        const ret = setVars()
        expect(validateResult.innerHTML).toBe("");
        expect(ret[2]).toBe("/");
        validateResult.innerHTML = value; //default value to Result
    });
})