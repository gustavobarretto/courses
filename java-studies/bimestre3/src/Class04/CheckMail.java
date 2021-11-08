package Class04;

public class CheckMail {
    Gerenciador inicial;

    public CheckMail() {
        this.inicial = new GerenciadorGerencia();
        Gerenciador tecnico = new GerenciadorTecnico();
        Gerenciador comercial = new GerenciadorComercial();
        Gerenciador spam = new GerenciadorSpam();

        inicial.setGerenciadorSeguinte(tecnico);
        tecnico.setGerenciadorSeguinte(comercial);
        comercial.setGerenciadorSeguinte(spam);
    }

    public void verificarEmail(Mail mail) {
        inicial.verificar(mail);
    }
}
