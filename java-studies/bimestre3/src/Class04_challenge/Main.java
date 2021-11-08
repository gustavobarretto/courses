package Class04_challenge;

public class Main {
    /*Vamos pensar em um governo formado por três
    tipos de hierarquias: deputados, ministros e presidente.
    Queremos desenvolver um sistema interno de mensagens, onde
    possamos enviar documentos aos membros do governo. Além disso,
    queremos que os documentos recebidos só sejam lidos se forem autorizados.
    Um documento é composto pelo conteúdo (String) e um tipo (Integer).
    Os tipos de documentos possíveis são valores numéricos: 1, 2 ou 3.
    Cada número representa um nível de acesso:
    1 = Reservado
    2 = Secreto
    3 = Muito Secreto
    Os documentos da categoria "Reservado" serão lidos pelos deputados,
    os classificados como "Secreto", pelos ministros e, por fim, os
    categorizados como "Muito secreto" serão lidos pelo presidente.
    Lembramos também que cada um poderá ler os documentos classificados
    em ordem inferior à sua. Por exemplo, o presidente poderá ler todos
    os documentos, mas os deputados só poderão ler a categoria “Reservado”.
    Pensemos nos deputados, ministros e presidente como usuários do sistema.
    Queremos que no momento em que qualquer um dos três tipos de usuário tente
    ler um documento (tendo acesso ou não), o envie para outro tipo de usuário e
    assim sucessivamente até que todos os usuários recebam o documento. Os três
    tipos de usuário devem possuir um método de leitura do documento, e um atributo
    que indique o tipo de acesso que possui (1, 2 ou 3). Este método receberá um
    documento e dependendo do tipo de hierarquia que seja, avaliará se pode lê-lo.
    Se puder, o fará e também o enviará para outro da hierarquia. Caso não tenha
    acesso para lê-lo, também o enviará para outro tipo de hierarquia.
    Sugerimos, portanto, que você represente a solução em um diagrama UML e implemente-o em JAVA.*/

    public static void main(String[] args) {
        AccessCheck checking = new AccessCheck();
        checking.checkingAccess(new Document("TORTURE_BLACKSITE", "ENVELOP", "1"));
        checking.checkingAccess(new Document("ATOMIC_BOMB", "DATA", "3"));
        checking.checkingAccess(new Document("FINANCE_PLAN", "ENVELOP", "2"));
        checking.checkingAccess(new Document("REASON_OF_LIFE", "GOD'S MESSAGE", "99"));
    }

}
