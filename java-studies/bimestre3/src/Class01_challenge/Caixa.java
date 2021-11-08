package Class01_challenge;

public class Caixa implements ICaixa {

    private ApiAuthenticationService authentication;
    private ApiCaixaService caixa;
    private ApiContaService conta;

    public Caixa() {
        this.authentication = new ApiAuthenticationService();
        this.conta = new ApiContaService();
        this.caixa = new ApiCaixaService();
    }

    public void sacarDinheiro(String id, String password, double valorDoSaque) {
        if(this.authentication.validateUserAndPassword(id, password))
            if(caixa.temSaldo(valorDoSaque)) {
                this.conta.getConta();
                conta.setSaldo(conta.getSaldo() - valorDoSaque);
            } else {
                System.out.println("Saldo insuficiente!");
            }
        else System.out.println("Conta inválida!");
    }

    public boolean temSaldo(double valorDoSaque) {
        return valorDoSaque <= conta.getSaldo();
    }
}
