package Class04;

public class ProcessarMail {
    public static void main(String[] args) {
        CheckMail processo = new CheckMail();
        processo.verificarEmail(new Mail("email@email.com", "tecnica@digitalhouse.com", "Reclamação"));
        processo.verificarEmail(new Mail("email@email.com", "csdsad@digitalhouse.com", "Gerencia"));
    }
}
