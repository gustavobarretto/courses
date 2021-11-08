package Class01_challenge;

public class Conta {

    private Usuario user;
    private double saldo;

    public Conta(Usuario user, int saldo) {
        this.user = user;
        this.saldo = saldo;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
