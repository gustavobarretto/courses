(function (win, doc) {
  'use strict';

  // global variable information
  let firstNumbers = '';
  let secondNumbers = '';
  let operator = '';

  // display variable
  let $display = doc.querySelector('[type="text"]');

  // catching all buttons;
  let $ce = doc.querySelector('[class=ce]')
  let $c = doc.querySelector('[class=c]')
  let $del = doc.querySelector('[class=del]')
  let $virg = doc.querySelector('[class=virg]')
  let $result = doc.querySelector('[class=result]')
  let $buttons = doc.querySelectorAll('[class*=numbers]');
  let $operators = doc.querySelectorAll('[class=operator]')

  // Adding functions
  const deleteNumber = () => {
    !!$display.value ?
        $display.value = $display.value.slice(0, -1) == ''
          ? $display.value = '0' : $display.value.slice(0, -1)
        : $display.value = '0';
  }

  $del.addEventListener('click', deleteNumber);

  // Adding events number's buttons
  $buttons.forEach( button => {
    button.addEventListener('click', () => {
      $display.value === '0' ? $display.value = button.innerText :
                                $display.value += button.innerText;
    })
  })

  // Operators's function
  $operators.forEach( op => {
    op.addEventListener('click', () => {
      firstNumbers = $display.value
      operator = op.innerText
      ce();

    })
  })

  const result = () => {
    secondNumbers = $display.value;

    switch(operator) {
      case '+':
        $display.value = (+firstNumbers) + (+secondNumbers);
        cleaningMemory();
        break;
      case '-':
        $display.value = (+firstNumbers) - (+secondNumbers);
        cleaningMemory();
        break;
      case '*':
        $display.value = (+firstNumbers) * (+secondNumbers);
        cleaningMemory();
        break;
      case '/':
        $display.value = (+firstNumbers) / (+secondNumbers);
        cleaningMemory();
        break;
    }
  }

  $result.addEventListener('click', result);

  const cleaningMemory = () => {
    firstNumbers = '';
    secondNumbers = '';
    operator = '';
  }

  const c = () => {
    $display.value = 0;
    cleaningMemory();
  }

  $c.addEventListener('click', c)

  const ce = () => {
    $display.value = 0;

  }

  $ce.addEventListener('click', ce)

})(window, document);

/*
Vamos desenvolver mais um projeto. A ideia ?? fazer uma mini-calculadora.
As regras s??o:

- Deve ter somente 1 input, mas n??o deve ser poss??vel entrar dados nesse input
diretamente;
- O input deve iniciar com valor zero;
- Deve haver 10 bot??es para os n??meros de 0 a 9. Cada bot??o deve ser um n??mero;
- Deve haver 4 bot??es para as opera????es principais: soma (+), subtra????o(-),
multiplica????o(x) e divis??o(??);
- Deve haver um bot??o de "igual" (=) que ir?? calcular os valores e um bot??o "CE"
que ir?? limpar o input, deixando-o com valor 0;

- A cada n??mero pressionado, o input deve atualizar concatenando cada valor
digitado, como em uma calculadora real;
- Ao pressionar um bot??o com uma das 4 opera????es, deve aparecer o s??mbolo da
opera????o no input. Se o ??ltimo caractere no input j?? for um s??mbolo de alguma
opera????o, esse caractere deve ser substitu??do pelo ??ltimo pressionado.
Exemplo:
- Se o input tem os valores: "1+2+", e for pressionado o bot??o de
multiplica????o (x), ent??o no input deve aparecer "1+2x".
- Ao pressionar o bot??o de igual, o resultado do c??lculo deve ser mostrado no
input;
- Ao pressionar o bot??o "CE", o input deve ficar zerado.
*/
