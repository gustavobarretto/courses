package Class01_challenge;

public class Main {

    /*Você está pronto para um desafio?
    Imagine que você tenha que aplicar o facade pattern
    em um sistema para sacar dinheiro no caixa eletrônico.
    Você tem três serviços (subsistemas) disponíveis para uso:
    um ficará encarregado da autenticação (AuthenticationService),
    outro de trazer os dados da conta bancária (ContaService)
    e o último de solicitar dinheiro ao banco (CaixaService).
    Queremos que o cliente possa sacar dinheiro enviando para
    o sistema o número de identificação, senha e saldo a sacar,
    sem ter que utilizar diretamente estes 3 serviços.


    1a ETAPA: Autenticação da Conta. Ela recebe id e senha.

    O serviço de autenticação possui um método denominado
    validateUserAndPassword, que receberá um identificador
    de usuário (ID) e uma senha.

    2a ETAPA: ApiContaService retorna o id da conta (através do getConta) e faz a verificação do saldo.

    O serviço que nos traz as informações da conta possui
    um método denominado getConta, que só receberá o
    identificador do usuário (ID). Devemos usar este serviço
    somente após usar o serviço de autenticação (ISSO É O QUE FAZ ELE
    SER SEGUNDA ETAPA). A conta é
    composta por um campo de identificação do usuário e um
    campo de saldo atual.

    3a E ÚLTIMA ETAPA: Verifica o saldo e realiza o saque.

    E por último, temos o serviço Caixa, que se encarrega de
    retirar o dinheiro do banco. Esse serviço possui um método
    denominado sacarDinheiro, que receberá o valor a ser sacado
    do banco.

    VERIFICA SE TEM SALDO. RETORNANDO TRUE, REALIZA O SAQUE.

    Depois de verificar se o usuário tem o dinheiro que deseja
    sacar, devemos usar o serviço de caixa. Nós propomos que
    você faça um diagrama de classes e, em seguida, faça a
    implementação deste desafio na linguagem JAVA.

    Bons estudos!*/

    public static void main(String[] args) {

        ICaixa caixa = new Caixa();

        caixa.sacarDinheiro("gustavo", "123", 1500);

        caixa.sacarDinheiro("gustavo", "123", 1200);

        caixa.sacarDinheiro("eduardo", "123", 1500);

        caixa.sacarDinheiro("gustavo", "1234", 1500);


    }
}
