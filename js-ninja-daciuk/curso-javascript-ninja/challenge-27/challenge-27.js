/*
Aproveitando a lib DOM que fizemos na semana anterior, crie agora para ela
métodos semelhantes aos que existem no array, mas que sirvam para os
elementos do DOM selecionados.
Crie os seguintes métodos:
- forEach, map, filter, reduce, reduceRight, every e some.

Crie também métodos que verificam o tipo do objeto passado por parâmetro.
Esses métodos não precisam depender de criar um novo elmento do DOM, podem
ser métodos estáticos.

Métodos estáticos não obrigam o uso do `new`, podendo ser usados diretamente
no objeto, como nos exemplos abaixo:
DOM.isArray([1, 2, 3]); // true
DOM.isFunction(function() {}); // true
DOM.isNumber('numero'); // false

Crie os seguintes métodos para verificação de tipo:
- isArray, isObject, isFunction, isNumber, isString, isBoolean, isNull.
O método isNull deve retornar `true` se o valor for null ou undefined.
*/

(function (win, doc) {
  'use strict';

  class DOM {

    constructor(node) {
      this.element = doc.querySelectorAll(node);
    }
    on(event, callback) {

      this.element.forEach( el => {

        return el.addEventListener(event, callback, false);

      })
    }
    off(event, callback) {
      this.element.forEach( el => {

        return el.removeEventListenerevent(event, callback, false);

      })
    }
    get() {
      return this.element;
    }
    ForEach() {
      return this.element.forEach( el => {
        return el;
      })
    }
    Map() {
      return this.element.map ( el => {
        return el;
      })
    }
    Filter(string) {
      return this.element.filter( el => {
        return string == el;
      })
    }
    Reduce() {
      return this.element.reduce( (currentValue, accumulator) => {
        return currentValue + accumulator;
      })
    }
    ReduceRight() {
      return this.element.ReduceRight( (currentValue, accumulator) => {
        return currentValue + accumulator;
      })
    }
    Every(value) {
      return this.element.every( el => {
        return el == value;
      })
    }
    Some(value) {
      return this.element.some( el => {
        return el == value;
      })
    }
    isArray (arr) {
      return Object.prototype.toString.call(arr) === '[object Array]';
    }
    isObject (obj) {
      return Object.prototype.toString.call(obj) === '[object Object]';
    }
    isFunction (func) {
      return Object.prototype.toString.call(func) === '[object Function]';
    }
    isNumber (number) {
      return typeof number === 'number';
    }
    isString (string) {
      return typeof string === 'string';
    }
    isBoolean (boolean) {
      return typeof boolean === 'boolean';
    }
    isNull (value) {
      value === undefined || value === null ? true : false;
    }

  }


  var $a = new DOM('[data-js="link"]');
  $a.on('click', function(e) {
    e.preventDefault();
    console.log('clicou');
  });

  console.log('Elementos selecionados:', $a.get());
  console.log('$a é filho de body?', $a.get()[0].parentNode === document.body);

})(window, document);
