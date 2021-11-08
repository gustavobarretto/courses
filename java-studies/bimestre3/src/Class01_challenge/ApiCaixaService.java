package Class01_challenge;

public class ApiCaixaService {

    private ApiContaService conta;

    public ApiCaixaService() {
        this.conta = new ApiContaService();
    }

    public boolean temSaldo(double valor) {
        return valor <= conta.getSaldo();
    }
}
