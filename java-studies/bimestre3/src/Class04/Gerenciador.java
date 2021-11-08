package Class04;

public abstract class Gerenciador {

    protected Gerenciador gerenciadorSeguinte;

    public Gerenciador getGerenciadorSeguinte() {
        return gerenciadorSeguinte;
    }

    public void setGerenciadorSeguinte(Gerenciador gerenciadorSeguinte) {
        this.gerenciadorSeguinte = gerenciadorSeguinte;

    }

    public abstract void verificar(Mail mail);
}
