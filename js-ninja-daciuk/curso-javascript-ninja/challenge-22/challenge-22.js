  (function () {
    'use strict'

      /*
      Crie dois objetos, que serão duas pessoas. Cada um deve ter as propriedades
      `name` e `lastName`, preenchidos com o nome e sobrenome da pessoa.
      */

      function Person (name, lastname) {
        this.name = name;
        this.lastname = lastname;
      }

      let person1 = new Person('Gustavo', 'Barretto');
      let person2 = new Person('Raissa', 'Ribeiro');

      let eliane = {
        name: 'Eliane',
        lastname: 'Cristina'
      }

      let carlos = {
        name: 'Carlos',
        lastname: 'Augusto'
      }

      /*
      Agora crie uma função chamada `getFullName` que retorne as propriedades
      `name` e `lastName` dos objetos acima, formando um nome completo.
      A função não deve receber nenhum parâmetro, mas as propriedades `name` e
      `lastName` devem ser dinâmicas.
      A mesma função deve servir para as duas pessoas (ou qualquer outra que for
      criada).
      Depois disso, invoque essa função, mostrando no console o nome completo das
      pessoas que foram criadas anteriormente, passando as pessoas acima como
      contexto da função. Use um console.log por pessoa.
      */
      console.log( 'O nome das pessoas é:' );

      Person.prototype.getFullName = function () {

        return this.name + ' ' + this.lastname;

      }

      function getFullName2 () {
        return this.name + ' ' + this.lastname
      }

      console.log(getFullName2.call(eliane))
      console.log(getFullName2.call(carlos))

      console.log(person1.getFullName());
      console.log(person2.getFullName());

      /*
      Crie uma função chamada `sum`. Essa função pode receber uma lista de
      parâmetros variável, e deverá retornar a soma de todos eles.
      Não use estruturas de repetição para somar os argumentos.
      Na primeira linha, dentro da função, deixe um console.log para mostrar todos
      os parâmetros passados para essa função.
      */

      function sum () {
        console.log(arguments)
        return Array.prototype.reduce.call(arguments, function (accumulator, currentValue) {
          return accumulator + currentValue;
        })
      }

      /*
      Mostre no console que a função acima funciona, invocando-a em 3 console.log
      diferentes, com quantidades variáveis de parâmetros passados.
      */
      console.log( '\nSomar alguns números:' );

      console.log(sum(1, 2, 3, 4, 5))
      console.log(sum(10, 20, 30, 40))
      console.log(sum(5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75))
      console.log(sum([1,2,3]));

      /*
      Declare uma variável chamada `userEntry`, que irá receber alguns valores
      entrados pelo usuário. Mostre para o usuário a seguinte frase:
      "Entre com alguns números que serão somados:"
      */
      let userEntry = prompt('Entre com alguns números que serão somados: ')

      /*
      Mostre no console o valor entrado pelo usuário:
      */
      console.log( '\nEntrada do usuário:' );
      console.log(userEntry)

      /*
      Crie uma função chamada `justNumbers`, que recebe por parâmetro uma string
      e remove tudo o que não for número, retornando um array somente com os números
      da string. Mostre a representação em string dessa função no console.
      */
      console.log( '\nFunção que limpa entrada do usuário (somente números):' );

      function justNumbers () {
        return userEntry.match(/\d+/g);

      }

      console.log(justNumbers.toString())


      /*
      Usando a função acima, faça a limpeza dos valores entrados pelo usuário,
      atribuindo o resultado à uma variável `numbers`.
      */
      console.log( '\nEntrada do usuário limpa. Somente números:' );
      // let numbers = justNumbers().map( (number) => {
      //   return Number(number);
      // });

      let numbers = justNumbers();

      console.log(numbers);




      /*
      Agora com o array de números, utilize a função `sum` para somar todos os
      números desse array e mostre o resultado no console.
      */
      console.log( '\nSomar números entrados pelo usuário:' );

      console.log( sum.apply(sum, numbers));


  })();
