// A fim de revermos alguns conceitos aprendidos anteriormente, realize esse estudo de caso
// com os colegas de sua mesa. Codificando o que for pedido usando a ferramenta VS Code.

// A secretaria de uma escola contratou a sua empresa para desenvolver sua plataforma de
// gestão de alunos, sendo uma dessas partes a criação de um sistema que calcule as notas
// obtidas ao longo do semestre, Você e seu grupo fazem parte da equipe responsável por
// implementar esta funcionalidade no sistema.
// Para isso, crie um script que permita adicionar uma sequência de números (um array de
// números) consecutivamente para receber as notas dos 4 bimestres. Após isso, crie uma
// estrutura na qual todos os números do array sejam somados sequencialmente: o primeiro
// número seja somado ao segundo e o resultado seja impresso no console. Então,
// temos que pegar esse resultado e adicionar o terceiro número a ele, e assim por
// diante, até terminarmos de percorrer o array. Seguindo a lógica do exemplo a seguir:

const somaNotas = array => {
    // return result = array.reduce(reducer = (acumulator, currentValue) => {
    //     acumulator + currentValue
    //     console.log(currentValue)
    let result = 0
    for(let i = 0; i < array.length; i++) {
        result += array[i]
        console.log('Nota final do ' + (i + 1) + 'º Bimestre: ' + result.toFixed(1))
    }
    (result/4).toFixed(1) >= 7 ? console.log('Parabéns! Você foi aprovado com a média final ' + (result/4).toFixed(1) + '.') : 
    console.log('Infelizmente você foi reprovado pois sua média final é ' + (result/4).toFixed(1) + '.')
}

somaNotas([2, 9, 4.5, 8])

// Micro desafios - Etapa II - Extra (Para quem terminar
//     antes dos 50 minutos)
    
//     Terminada esta etapa é hora de preparar o código para ficar mais amigável ao usuário final,
//     com mensagens que informem a nota do aluno e sua condição:
//     1. Utilizando a função console.log informe a nota que o aluno teve em cada um dos
//     bimestres e por fim sua nota final. Por exemplo: “Parabéns pela conclusão do primeiro
//     bimestre. Sua nota foi: 8.”;
//     2. Após mostrar a nota final, crie uma estrutura de decisão que informe se o aluno foi
//     aprovado ou não, sendo a média da escola 7.
//     3. Por fim, comente as etapas do código.

const notas = [5, 7, 10, 6] //array com as notas

const total = notas.reduce((acum, curr, i) =>{
    console.log(acum += curr) //metodo reduce para fazer a soma das notas
    console.log(`Parabéns pela conclusão do ${i+1}º bimestre. Sua nota foi ${curr}.`) 
    //informar a nota de cada bimestre por cada volta (i = volta do reduce)
    return acum; //retorna a nota final
}, 0); 

const media = total / notas.length; //cálculo da média final

console.log(media >= 7 ? `Nota final: ${media}. Situação: aprovado`:`Nota final: ${media}. Situação: reprovado`); 
//condição de aprovação e reprovação cuja média de aprovação é 7
