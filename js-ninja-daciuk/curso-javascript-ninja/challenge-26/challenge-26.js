/*
O desafio dessa semana é criar uma mini library (biblioteca) para
reutilizarmos nossos códigos quando fizermos manipulação de DOM!

Requisitos:
- O nome da lib deve ser "DOM".
- Ela deve ser uma função construtora, que receberá uma string por parâmetro.
Essa string será o nó do DOM a ser selecionado;
- No construtor, você deve atribuir à `this.element` todos os elementos
do DOM selecionados;
- Extenda a lib para ter os métodos `on`, `off` e `get`.
- O método `on` irá adicionar um listener de evento a todos os elementos
selecionados.
- O método `off` irá remover o listener de evento de todos os elementos
selecionados.
- O método `get` deve retornar os elementos.
- O código abaixo deve funcionar corretamente após a lib criada.

Dica: olhe os erros que acontecem no console, e vá resolvendo um a um.
Só passe para o próximo problema quando tiver resolvido o anterior :)
*/


// (function (win, doc) {
//   'use strict';

//   class DOM {

//     constructor(node) {
//       this.element = doc.querySelectorAll(node);

//     }
//     on(event, callback) {

//       this.element.forEach( el => {

//         return el.addEventListener(event, callback, false);

//       })
//     }
//     off(event, callback) {
//       this.element.forEach( el => {

//         return el.removeEventListenerevent(event, callback, false);

//       })
//     }
//     get() {
//       return this.element;
//     }
//   }


//   var $a = new DOM('[data-js="link"]');
//   $a.on('click', function(e) {
//     e.preventDefault();
//     console.log('clicou');
//   });

//   console.log('Elementos selecionados:', $a.get());
//   console.log('$a é filho de body?', $a.get()[0].parentNode === document.body);

// })(window, document);

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

  console.log($a.isArray($a));
  console.log($a.isObject($a));
  console.log($a.element[0])
  console.log(Object.prototype.toString.call($a.element[0].href))
  console.log($a.isString($a.element[0].href));
  console.log($a.isNumber($a));

  console.log('Elementos selecionados:', $a.get());
  console.log('$a é filho de body?', $a.get()[0].parentNode === document.body);

})(window, document);
