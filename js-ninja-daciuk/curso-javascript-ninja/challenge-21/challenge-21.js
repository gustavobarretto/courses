/*
O desafio de hoje será um pequeno projeto: um cronômetro!
As regras para criação do cronômetro são as seguintes:
1. Crie um arquivo index.html e adicione esse script a ele;
2. Crie um campo `input` do tipo `text`, e inicie-o com um valor 0 (zero).
Ele será o nosso cronômetro;
3. Crie 3 botões para as ações do cronômetro: Start, Stop e Reset;
4. Ao clicar em Start, o valor do campo deve ser incrementado de 1 em 1, a
cada segundo;
5. Ao clicar em Stop, o cronômetro deve parar de contar;
6. Ao clicar em Reset, o cronômetro deve zerar e parar de contar.

Utilize o atributo data-js para nomear o campo e os botões. Você pode
usar o nome que achar melhor, desde que ele seja semântico, ou seja, o nome
dado ao elemento HTML deve definir o que o elemento é ou o que ele faz.
*/

(function (doc) {
    'use strict';

    const $timer = doc.querySelector('input');
    const $start = doc.querySelector('[data-start]')
    const $stop = doc.querySelector('[data-stop]')
    const $reset =doc.querySelector('[data-reset]')

    $timer.value = 0;

    let stopTimeout;
   
    function startTimer (event){
        event.preventDefault(); 

        function counter () {
            $timer.value++;
            stopTimeout = setTimeout(counter, 1000);
        }

        counter();
    };
    
    function stopTimer (){

        clearTimeout(stopTimeout);
    };
    
    function clearTimer (){
        $timer.value = 0;
        stopTimer();
    };

    $start.addEventListener('click', startTimer, false);
    $stop.addEventListener('click', stopTimer, false);
    $reset.addEventListener('click', clearTimer, false);
    
})(document);