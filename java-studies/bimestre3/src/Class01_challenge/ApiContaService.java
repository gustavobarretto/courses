package Class01_challenge;

public class ApiContaService {

    private String idConta;
    private double saldo;

    public ApiContaService() {
        this.idConta = "1235";
        this.saldo = 5000;
    }

    public void getConta() {
        System.out.println("A conta de nº " + idConta + " tem saldo de R$" + saldo);
    }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
