// Declarar uma variável qualquer, que receba um objeto vazio.
let pessoa = {
    
}

console.log(pessoa)

/*
Declarar uma variável `pessoa`, que receba suas informações pessoais.
As propriedades e tipos de valores para cada propriedade desse objeto devem ser:
- `nome` - String
- `sobrenome` - String
- `sexo` - String
- `idade` - Number
- `altura` - Number
- `peso` - Number
- `andando` - Boolean - recebe "falso" por padrão
- `caminhouQuantosMetros` - Number - recebe "zero" por padrão
*/
pessoa = {
    nome: 'Gustavo',
    sobrenome: 'Barretto',
    sexo: 'Masculino',
    idade: '18',
    altura: '1,70m',
    peso: '73',
    andando: false,
    caminhouQuantosMetros: 0

}
console.log(pessoa)
console.table(pessoa)


/*
Adicione um método ao objeto `pessoa` chamado `fazerAniversario`. O método deve
alterar o valor da propriedade `idade` dessa pessoa, somando `1` a cada vez que
for chamado.
*/
pessoa = {
    ...pessoa,
    fazerAniversario: function() {
        console.log(`${this.nome} está atualmente com ${this.idade} e vai fazer aniversário...`)
        this.idade++
        console.log(`${this.nome} fez aniversário! Agora ele tem ${this.idade} anos!`)
    }

}
pessoa.fazerAniversario()

/*
Adicione um método ao objeto `pessoa` chamado `andar`, que terá as seguintes
características:
- Esse método deve receber por parâmetro um valor que representará a quantidade
de metros caminhados;
- Ele deve alterar o valor da propriedade `caminhouQuantosMetros`, somando ao
valor dessa propriedade a quantidade passada por parâmetro;
- Ele deverá modificar o valor da propriedade `andando` para o valor
booleano que representa "verdadeiro";
*/

pessoa = {
    ...pessoa,
    andar: function(metros) {
        console.log(`${this.nome} já caminhou um total de ${this.caminhouQuantosMetros} metros.`)
        this.caminhouQuantosMetros += metros
        console.log(`${this.nome} já caminhou um total de ${this.caminhouQuantosMetros} metros.`)
        this.andando = true
        console.log(this.andando)
    }
}
pessoa.andar(10)


/*
Adicione um método ao objeto `pessoa` chamado `parar`, que irá modificar o valor
da propriedade `andando` para o valor booleano que representa "falso".
*/
pessoa = { 
    ...pessoa,
    parar: function () {
        this.andando = false
        this.andando == false ? console.log(`${this.nome} parou de andar!`): ''
        // console.log(`${this.nome} continua andando!`)
    }
}
pessoa.parar()

console.log(pessoa)
console.table(pessoa)
/*
Crie um método chamado `nomeCompleto`, que retorne a frase:
- "Olá! Meu nome é [NOME] [SOBRENOME]!"
*/
pessoa = {
    ...pessoa,
    nomeCompleto: function () {
        console.log(`Olá! Meu nome é ${this.nome} ${this.sobrenome}!`)
    }
}
pessoa.nomeCompleto()



/*
Crie um método chamado `mostrarIdade`, que retorne a frase:
- "Olá, eu tenho [IDADE] anos!"
*/
pessoa = {
    ...pessoa,
    mostrarIdade: function () {
        console.log(`Olá, eu tenho ${this.idade} anos.`)
    }
}; pessoa.mostrarIdade()



/*
Crie um método chamado `mostrarPeso`, que retorne a frase:
- "Eu peso [PESO]Kg."
*/
pessoa = {
    ...pessoa,
    mostrarPeso: function () {
        console.log(`Eu peso ${this.peso}Kg.`)
    }
}; pessoa.mostrarPeso()


/*
Crie um método chamado `mostrarAltura` que retorne a frase:
- "Minha altura é [ALTURA]m."
*/
pessoa = {
    ...pessoa,
    mostrarAltura: function () {
        console.log(`Minha altura é de ${this.altura}m.`)
    }
}; pessoa.mostrarAltura()

/*
Agora vamos brincar um pouco com o objeto criado:
Qual o nome completo da pessoa? (Use a instrução para responder e comentários
inline ao lado da instrução para mostrar qual foi a resposta retornada)
*/
pessoa.nomeCompleto()

/*
Qual a idade da pessoa? (Use a instrução para responder e comentários
inline ao lado da instrução para mostrar qual foi a resposta retornada)
*/
pessoa.mostrarIdade()

/*
Qual o peso da pessoa? (Use a instrução para responder e comentários
inline ao lado da instrução para mostrar qual foi a resposta retornada)
*/
pessoa.mostrarPeso()

/*
Qual a altura da pessoa? (Use a instrução para responder e comentários
inline ao lado da instrução para mostrar qual foi a resposta retornada)
*/
pessoa.mostrarAltura()

/*
Faça a `pessoa` fazer 3 aniversários.
*/
pessoa.fazerAniversario()
pessoa.fazerAniversario()
pessoa.fazerAniversario()

/*
Quantos anos a `pessoa` tem agora? (Use a instrução para responder e
comentários inline ao lado da instrução para mostrar qual foi a resposta
retornada)
*/
pessoa.mostrarIdade()

/*
Agora, faça a `pessoa` caminhar alguns metros, invocando o método `andar` 3x,
com metragens diferentes passadas por parâmetro.
*/
pessoa.andar(12)
pessoa.andar(36)
pessoa.andar(48)

/*
A pessoa ainda está andando? (Use a instrução para responder e comentários
inline ao lado da instrução para mostrar qual foi a resposta retornada)
*/
console.log(pessoa.andando)


/*
Se a pessoa ainda está andando, faça-a parar.
*/
pessoa.parar()


/*
E agora: a pessoa ainda está andando? (Use uma instrução para responder e
comentários inline ao lado da instrução para mostrar a resposta retornada)
*/
console.log(pessoa.andando)

/*
Quantos metros a pessoa andou? (Use uma instrução para responder e comentários
inline ao lado da instrução para mostrar a resposta retornada)
*/
console.log(pessoa.caminhouQuantosMetros)

/*
Agora vamos deixar a brincadeira um pouco mais divertida! :D
Crie um método para o objeto `pessoa` chamado `apresentacao`. Esse método deve
retornar a string:
- "Olá, eu sou o [NOME COMPLETO], tenho [IDADE] anos, [ALTURA], meu peso é [PESO] e, só hoje, eu já caminhei [CAMINHOU QUANTOS METROS] metros!"

Só que, antes de retornar a string, você vai fazer algumas validações:
- Se o `sexo` de `pessoa` for "Feminino", a frase acima, no início da
apresentação, onde diz "eu sou o", deve mostrar "a" no lugar do "o";
- Se a idade for `1`, a frase acima, na parte que fala da idade, vai mostrar a
palavra "ano" ao invés de "anos", pois é singular;
- Se a quantidade de metros caminhados for igual a `1`, então a palavra que
deve conter no retorno da frase acima é "metro" no lugar de "metros".
- Para cada validação, você irá declarar uma variável localmente (dentro do
método), que será concatenada com a frase de retorno, mostrando a resposta
correta, de acordo com os dados inseridos no objeto.
*/


// Agora, apresente-se ;)
