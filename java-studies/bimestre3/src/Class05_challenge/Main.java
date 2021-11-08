package Class05_challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*Vamos pensar em um aplicativo semelhante ao Google Drive,
     um serviço que nos traz documentos. Para acessá-lo,
     devemos enviar uma url e um email. Os documentos são
     compostos por um id, uma url, um conteúdo e uma lista
     de usuários autorizados a visualizá-lo. Queremos registrar
     quem acessa os documentos.
     Como você resolveria esse problema aplicando o padrão de proxy?
     */

     public static void main(String[] args) {

          List<String> usersAuthorized = new ArrayList<>();

          usersAuthorized.add("gustavo@email.com");
          Document document1 = new Document("1", "THE_BOOKS_ON_THE_TABBLE",
                  "Table, ta-table, the books is on the table!\n");
          ICloudAccessDocument cloudAccessDocument = new VerificationAccess(document1, usersAuthorized);

          cloudAccessDocument.authorization("gustavo@email.com",
                  "THE_BOOKS_ON_THE_TABBLE");
          cloudAccessDocument.authorization("eduardo@email.com",
                  "THE_BOOKS_ON_THE_TABBLE");
          cloudAccessDocument.authorization("gustavo@email.com",
                  "SINGNING_THE_RAIN");

     }
}
